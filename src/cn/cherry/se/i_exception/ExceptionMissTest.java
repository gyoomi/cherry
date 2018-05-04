/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.i_exception;

/**
 * 异常丢失
 *
 * @author Leon
 * @version 2018/5/4 10:24
 */
public class ExceptionMissTest {

    public static void main(String[] args) {
        // 丢失ImporantException异常
        try {
            ExceptionMissTest missTest = new ExceptionMissTest();
            try {
                missTest.f();
            } finally {
                missTest.m();
            }
        } catch (Exception e){
            System.out.println(e);
        }

    }

    void f() throws ImportantException {
        throw new ImportantException();
    }

    void m() throws LostException {
        throw new LostException();
    }
}

class ImportantException extends Exception{
    @Override
    public String toString() {
        return "A very important Exception!!!";
    }
}

class LostException extends Exception{
    @Override
    public String toString() {
        return "A lost Exception!!!";
    }
}
