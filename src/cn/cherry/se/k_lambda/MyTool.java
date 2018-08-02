/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.k_lambda;

/**
 * 使用jdk 8 接口static方法来创建工具类
 *
 * @author Leon
 * @version 2018/8/1 14:28
 */
public interface MyTool {

    public static int add(int x, int y) {
        return x + y;
    }
}
