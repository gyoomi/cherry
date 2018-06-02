##编码知识预备
- ASCII码  
1、共计128字符；  
2、8bit即单字节字符；  
3、最高位前面统一规定为0；  
4、例如：65（二进制0100 0001）是A。  
- 非ASCII码  
1、什么是非ASCII码？  
英语用128个符号编码就够了，但是用来表示其他语言，128个符号是不够的。  
- Unicode 
1、什么是Unicode？
Unicode当然是一个很大的集合，现在的规模可以容纳100多万个符号。每个符号的编码都不一样，比如，U+0639表示阿拉伯字母Ain，U+0041表示英语的大写字母A，U+4E25表示汉字"严"。具体的符号对应表，可以查询unicode.org，或者专门的汉字对应表。  
2、存在定位问题  
Unicode只是一个符号集，它只规定了符号的二进制代码，却没有规定这个二进制代码应该如何存储。  
例如：“汉”字的Unicode编码是0x6C49，二进制为 01101100 01001001。也就是说这个符号的表示至少需要2个字节。表示其他更大的符号，可能需要3个字节或者4个字节，甚至更多。
- UTF-8
1、和Unicode的关系  
UTF-8是Unicode的实现方式之一。
2、规则  
1）对于单字节的符号，字节的第一位设为0，后面7位为这个符号的unicode码。因此对于英语字母，UTF-8编码和ASCII码是相同的。  
2）对于n字节的符号（n>1），第一个字节的前n位都设为1，第n+1位设为0，后面字节的前两位一律设为10。剩下的没有提及的二进制位，全部为这个符号的unicode码。 
|    十六进制   |二进制             |  
|:------------- |:-----------------|  
|0000 0000-0000 007F | 0xxxxxxx|  
|0000 0080-0000 07FF | 110xxxxx 10xxxxxx|  
|0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx|  
|0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx|    
3、例子 
    “严”  
    4E25  
    1001110	00100101  
    1110xxxx	10xxxxxx	10xxxxxx  
    填充后  
    11100100	10111000	10100101  
    111001001011100010100101  
    十进制的：14989477     
##DataOutputSteam和DataInputSteam原理解析
- 概念介绍  
1、DataOutputSteam和DataInputSteam是包装流，必须要搭配使用才行，先写出，再读入；  
2、使用这两个流主要为了使用它writeByte、writeShort、writeChar、writeUTF以及读取的方法；  
3、使用了装饰器模式和桥接模式（这里不做介绍，感兴趣的可以去研究一下）  
- 主要实现原理剖析  
1、writeLong 
```
    public final void writeLong(long v) throws IOException {
        // 从高位开始，从最高字节开始写入，共8个字节
        // (byte)(v >>> 56) 取最高位字节，存入字节缓存数组
        // 一定是按照顺序进行写入和读取的，“顺序”
        writeBuffer[0] = (byte)(v >>> 56);
        writeBuffer[1] = (byte)(v >>> 48);
        writeBuffer[2] = (byte)(v >>> 40);
        writeBuffer[3] = (byte)(v >>> 32);
        writeBuffer[4] = (byte)(v >>> 24);
        writeBuffer[5] = (byte)(v >>> 16);
        writeBuffer[6] = (byte)(v >>>  8);
        writeBuffer[7] = (byte)(v >>>  0);
        out.write(writeBuffer, 0, 8);
        incCount(8);
    }
``` 
2、writeChar 
```
    // char自动类型转为int
    // char占两个字节
    public final void writeChar(int v) throws IOException {
        // 取高位字节
        // 思路：转为进二进制，然后分高低字节进行写入
        // 注意：读取的也要按照顺序
        out.write((v >>> 8) & 0xFF);
        // 取地位字节
        out.write((v >>> 0) & 0xFF);
        incCount(2);
    }
``` 
3、writeUTF
```
static int writeUTF(String str, DataOutput out) throws IOException {
        int strlen = str.length();
        int utflen = 0;
        int c, count = 0;

        /* use charAt instead of copying String to char array */
        // 这里是计算出写入字符串所需的字节数(判断标准是UTF-8的上面有）
        // 根据此计算出下方bytearr字节缓存区的大小
        for (int i = 0; i < strlen; i++) {
            c = str.charAt(i);
            if ((c >= 0x0001) && (c <= 0x007F)) {
                utflen++;
            } else if (c > 0x07FF) {
                utflen += 3;
            } else {
                utflen += 2;
            }
        }

        if (utflen > 65535)
            throw new UTFDataFormatException(
                "encoded string too long: " + utflen + " bytes");

        byte[] bytearr = null;
        if (out instanceof DataOutputStream) {
            DataOutputStream dos = (DataOutputStream)out;
            if(dos.bytearr == null || (dos.bytearr.length < (utflen+2)))
                dos.bytearr = new byte[(utflen*2) + 2];
            bytearr = dos.bytearr;
        } else {
            bytearr = new byte[utflen+2];
        }
        
        // 在写入字符串之前，写写入这个字符串的长度；所以上方的计算写入数组初始化大小的时候都加了2
        bytearr[count++] = (byte) ((utflen >>> 8) & 0xFF);
        bytearr[count++] = (byte) ((utflen >>> 0) & 0xFF);

        // 进行写入，单个字符一个个写入，
        int i=0;
        for (i=0; i<strlen; i++) {
           c = str.charAt(i);
           if (!((c >= 0x0001) && (c <= 0x007F))) break;
           bytearr[count++] = (byte) c;
        }

        // 根据UTF-8的规则，进行判断1,2,3,个字节的写入，转换为Unicode的后
        // 进行单个字节写入
        for (;i < strlen; i++){
            c = str.charAt(i);
            if ((c >= 0x0001) && (c <= 0x007F)) {
                bytearr[count++] = (byte) c;

            } else if (c > 0x07FF) {
                bytearr[count++] = (byte) (0xE0 | ((c >> 12) & 0x0F));
                bytearr[count++] = (byte) (0x80 | ((c >>  6) & 0x3F));
                bytearr[count++] = (byte) (0x80 | ((c >>  0) & 0x3F));
            } else {
                bytearr[count++] = (byte) (0xC0 | ((c >>  6) & 0x1F));
                bytearr[count++] = (byte) (0x80 | ((c >>  0) & 0x3F));
            }
        }
        out.write(bytearr, 0, utflen+2);
        return utflen + 2;
    }
```
##总结
- 在使用时一定要注意写入和读取的顺序
- 写入字符串的会先写入字符串的长度，以便的读取的使用