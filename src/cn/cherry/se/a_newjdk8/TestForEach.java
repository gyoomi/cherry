/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.a_newjdk8;

/**
 * for死循环
 *
 * @author Leon
 * @version 2018/4/23 17:36
 */
public class TestForEach {
    public static void main(String[] args) {
        int i = 0;
        for(;;){
            i++;
            if ( i > 1000000){
                break;
            }
            System.out.println(i);
        }
    }
}
