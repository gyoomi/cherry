/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.d_thread_produceandcustomer;

import java.util.LinkedList;

/**
 * 类功能描述
 *  ◆◆◆◇
 * @author Leon
 * @version 2018/5/9 16:33
 */
public class Shelf {

    public static LinkedList<String> bowls = new LinkedList<>();

    static {
        initBowls();
    }

    public static void initBowls() {
        for (int i = 0; i < 6; i++) {
            bowls.add("◆");
        }
    }

    public void put(){
        if (!isFull()) {
            bowls.addLast("◆");
        }
    }

    public String get() throws Exception {
        if (!isEmpty()) {
            String rs = "";
            rs = bowls.removeFirst();
            bowls.addLast("◇");
            return rs;
        } else {
            throw new Exception("tttttt");
        }
    }

    public boolean isFull() {
        return bowls.size() == 6 ? true :false;
    }

    public boolean isEmpty() {
        return 0 == bowls.size() ? true : false;
    }

    public static void main(String[] args) throws Exception{

    }
}
