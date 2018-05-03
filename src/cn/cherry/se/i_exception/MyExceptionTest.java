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
    public static void main(String[] args) {

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
