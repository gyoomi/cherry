/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.k_lambda;

import java.util.function.Supplier;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/8/1 18:05
 */
class Log {
    /**
     * 不打印debug级别的日志
     *
     * @return
     */
    public boolean isDebug() {
        return true;
    }

    public void debug(String string) {
        if (this.isDebug()) {
            System.out.println(string);
        }
    }

    public void debug(Supplier<String> supplier) {
        if (this.isDebug()) {
            // 真正要打印的时候，才调用
            System.out.println(supplier.get());
        }
    }
}
public class LazyDemo01 {

    public static void main(String[] args) {
        LazyDemo01 demo = new LazyDemo01();
        Log log = new Log();
        //log.debug(() -> "打印之前必须判断日志等级" + demo.toString());
        log.debug("打印了");
    }
    @Override
    public String toString() {
        System.out.println("toString被调用了");
        return super.toString();
    }
}
