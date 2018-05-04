/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.i_exception;

import java.io.IOException;

/**
 * 异常限制;
 *     1、派生类不能抛出比基类更多的异常。包括方法在内
 *     2、构造方法不受约束1的约束
 *     3、派生构造法方法中不能捕捉基本异常，只能进行继续抛出
 *
 * @author Leon
 * @version 2018/5/4 10:46
 */
public class ConstructorException {
}

class Test{
    public Test() throws IOException {

    }
}

class Test1 extends Test{
    public Test1()throws IOException, Exception{

    }
}
