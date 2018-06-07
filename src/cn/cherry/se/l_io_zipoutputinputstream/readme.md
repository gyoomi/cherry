###ZipInputStream和ZipOutputStream定义
- 压缩流  
  在日常中经常会使用到zip或rar这样的压缩文件，更加便利了我们日常文件的传输和使用。当然在java中
也提供了相应的输入输出流来压缩和解压gzip、zip和rar这样的文件。
- ZipInputStream  
  “压缩文件输入流”，用于读取磁盘上的压缩文件
- ZipOutputStream  
  “压缩文件输出流”，用于将程序中的压缩流写出到磁盘上。
  通常需要使用ZipFile ZipInputStream/ZipOutputStream ZipEntry级File完成解压缩操作。
- 其他相似流  
- 在JAVA IO中，不仅可以实现ZIP压缩格式的输入、输出，也可以实现JAR及GZIP文件格式的压缩：  
- JAR压缩的支持类保存在java.util.jar包中，常用的类有如下几个：  
  - JAR压缩输出流：JarOutputStream
  - JAR压缩输入流：JarInputStream
  - JAR文件：JARFile
  - JAR实体：JAREntry
- GZIP是用于UNIX系统的文件压缩，在Linux中经常会使用到*.gz的文件，就是GZIP格式，GZIP压缩的支持类保存在java.util.zip包中，常用的类有如下几个：  
  - GZIP压缩输出流：GZIPOutputStream
  - GZIP压缩输入流：GZIPInputStream
###使用用例
- 压缩
```
    // 压缩入口1
    public static void compress(String srcPath, String destPath,boolean dirFlag) throws Exception {
        compress(new File(srcPath), new File(destPath), dirFlag);
    }
    
    // 压缩入口2
    public static void compress(String srcPath, String destPath) throws Exception {
        compress(new File(srcPath), new File(destPath), DEFAULT_DIR);
    }
    
    // 压缩入口3
    public static void compress(File srcFile, File destFile, boolean dirFlag) throws Exception {
        compress(srcFile, new ZipOutputStream(new FileOutputStream(destFile)), dirFlag);
    }

    public static void compress(File srcFile, ZipOutputStream zos, boolean dirFlag) throws Exception {
        // 需要解压的压缩文件对象
        // 压缩输出流
        // 是否在压缩文件时创建一个父文件夹后再压缩
        if (srcFile.isDirectory()) {
            if (dirFlag) {
                doCompress(zos, srcFile, srcFile.getName() + File.separator);
            } else {
                doCompress(zos, srcFile, "");
            }
        } else {
            doCompress(zos, srcFile, "");
        }
        zos.close();
    }

    public static void doCompress(ZipOutputStream zos, File file, String baseDir) throws Exception {
        if (file.isDirectory()) {
            // 递归循环，只压缩其中所有文件
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                doCompress(zos, files[i], baseDir);
            }
        } else {
            // 进行文件压缩的操作
            byte[] buff = new byte[DEFAULT_BUFF_SIZE];
            InputStream in = new FileInputStream(file);
            zos.putNextEntry(new ZipEntry(baseDir + File.separator + file.getName()));
            int len;
            while ((len = in.read(buff,0 ,DEFAULT_BUFF_SIZE)) != -1) {
                zos.write(buff, 0, len);
            }
            in.close();
        }
    }
```
- 解压
```
/**
     * Default buff byte size
     *
     */
    private static final int DEFAULT_BUFF_SIZE = 1024;

    /**
     * Default basedir value
     *
     */
    private static final boolean DEFAULT_DIR = false;

    // 程序入口1
    public static void decompress(String srcPath) throws Exception {
        decompress(new File(srcPath));
    }

    // 程序入口2
    public static void decompress(File srcFile) throws Exception {
        File baseFile = srcFile.getParentFile();
        decompress(srcFile, baseFile);
    }

    // 程序入口3
    public static void decompress(String srcPath, String destPath) throws Exception {
        decompress(new File(srcPath), new File(destPath));
    }

    // 程序基本入口
    public static void decompress(File srcFile, File destFile) throws Exception {
        CheckedInputStream cis = new CheckedInputStream(new FileInputStream(srcFile), new CRC32());
        ZipInputStream zis = new ZipInputStream(cis);
        // 解压操作
        doDecompress(destFile, zis);
        zis.close();
    }

    private static void doDecompress(File destFile, ZipInputStream zis) throws Exception {
        ZipEntry zipEntry = null;
        while ((zipEntry = zis.getNextEntry()) != null) {
            String dir = destFile.getPath() + File.separator + zipEntry.getName();
            File dirFile = new File(dir);
            // 如果父文件夹不存在，则递归创建其父文件夹
            fileProber(dirFile);
            if (zipEntry.isDirectory()) {
                // 如果zipEntry是目录，则创建目录
                dirFile.mkdirs();
            } else {
                // 解压压缩文件的其中具体的一个zipEntry对象
                doDecompressFile(dirFile, zis);
            }
            zis.closeEntry();
        }
    }
    
    // 一般意义上的文件复制操作
    private static void doDecompressFile(File destFile, ZipInputStream zis) throws Exception {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));
        int len;
        byte[] buff = new byte[DEFAULT_BUFF_SIZE];
        while ((len = zis.read(buff, 0 ,DEFAULT_BUFF_SIZE)) != -1) {
            bos.write(buff, 0, len);
        }
        bos.close();
    }

    /**
     * 文件探测
     *
     * When the parent file not exist.Create it.
     *
     * @param dirFile
     * @throws Exception
     */
    public static void fileProber(File dirFile) throws Exception {
        File parentFile = dirFile.getParentFile();
        if (!parentFile.exists()) {
            fileProber(parentFile);
            parentFile.mkdirs();
        }
    }
```
###总结
- 压缩文件中的每个具体的压缩实体在Java中用ZipEntry来表示，每一个压缩文件很有可能包含多个ZipEntry
- 其他两个gzip和rar压缩文件的操作类似，在这里就省略
- 其中压缩流的来源和目的不一定是磁盘，很有可能是网络和内存中
- ZipFile表示对压缩文件抽象
- 具体的项目的开发可以使用Apache的工具包和网上的一些第三方jar工具，但是手写一笔进一步加深对其了解和java流的认识