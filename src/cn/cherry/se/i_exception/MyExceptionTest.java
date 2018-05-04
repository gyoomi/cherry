/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.i_exception;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/5/3 17:51
 */
public class MyExceptionTest {
    /**
     * 重抛异常，会将异常抛给上一级的环境中，同一个try后面的catch块将会被忽略不执行。
     *
     * @param args
     * @throws MyException
     */
    public static void main(String[] args) throws MyException {
/*        try {
            f();
        } catch (MyException e) {
             e.printStackTrace();
        } finally {
            System.out.println("finally block!!!");
        }*/
        String d = m();
        System.out.println(d);
    }

    public static void f() throws MyException{
        System.out.println("Method f()");
        throw new MyException("occur error!!!");
    }

    // 返回3
    public static String d(){
        try {
            return "1";
        } catch (Exception e){
            return "2";
        } finally {
            return "3";
        }
    }

    // 返回3
    public static String m(){
        try {
            throw new RuntimeException();
        } catch (Exception e){
            return "2";
        } finally {
            return "3";
        }
    }
}

class MyException extends Exception{

    public MyException(){
        super();
    }

    public MyException(String msg){
        super(msg);
    }
}
