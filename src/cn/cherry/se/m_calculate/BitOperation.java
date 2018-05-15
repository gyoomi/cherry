/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.m_calculate;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/5/15 15:16
 */
public class BitOperation {

    /**
     * << 运算（左移运算是将一个二进制位的操作数按指定移动的位数向左移位，移出位被丢弃，右边的空位一律补0。）
     * 0000 0000 0000 0000 0000 0000 0000 1000
     * 0000 0000 0000 0000 0000 0000 0010 0000   ---> 结果是：32
     */
    public static void test01() {
        int a = 45;
        int b = -45;
        System.out.println("十进制数据：" + a + " -> " + Integer.toBinaryString(a) + "    " + (a << 2) + " = " + a + " << 2");
        System.out.println("十进制数据：" + b + " -> " + Integer.toBinaryString(b) + "    " + (b << 2) + " = " + b + " << 2");
    }

    /**
     * >> 运算（右移运算是将一个二进制位的操作数按指定移动的位数向右移动，移出位被丢弃，左边移出的空位或者一律补0，或者补符号位
     *         右移对于无符号类型强制补0，对于有符号类型续补符号位）
     * -8 >> 2的过程详解
     * -8的补码：    1111 1111 1111 1111 1111 1111 1111 1000
     * 右移2位：     1111 1111 1111 1111 1111 1111 1111 1110  （得到右移结果）
     * 转换为10进制： -1
     *               1111 1111 1111 1111 1111 1111 1111 1101
     *               取反
     *               1000 0000 0000 0000 0000 0000 0000 0010   -> 结果就是-2
     *
     */
    public static void test02() {
        int a = 8;
        int b = -8;
        System.out.println("十进制数据：" + a + " -> " + Integer.toBinaryString(a) + "    " + (a >> 2) + " = " + a + " >> 2");
        System.out.println("十进制数据：" + b + " -> " + Integer.toBinaryString(b) + "    " + (b >> 2) + " = " + b + " >> 2");
    }

    /**
     * >>> 无符号位移（无符号的移位只有右移，没有左移使用“>>>”进行移位，都补充0）
     * -7 >>>过程：
     *         1111 1111 1111 1111 1111 1111 1111 1001          -7 补码
     *         0001 1111 1111 1111 1111 1111 1111 1111           运算后的结果 十进制就是：536870911
     *
     */
    public static void test03() {
        int a = 7;
        int b = -7;
        System.out.println("十进制数据：" + a + " -> " + Integer.toBinaryString(a) + "    " + (a >>> 3) + " = " + a + " >>> 3");
        System.out.println("十进制数据：" + b + " -> " + Integer.toBinaryString(b) + "    " + (b >>> 3) + " = " + b + " >>> 3");
    }

    /**
     * &运算（二进制下，全为1，则为1，否则为0）
     * 8 & -7 过程：
     *             0000 0000 0000 0000 0000 0000 0000 1000    8
     *             1000 0000 0000 0000 0000 0000 0000 0111    -7 原码
     *             1111 1111 1111 1111 1111 1111 1111 1000    -7 反码
     *             1111 1111 1111 1111 1111 1111 1111 1001    -7 补码
     *
     *             & 后的结果为：
     *             0000 0000 0000 0000 0000 0000 0000 1000    ->8
     *
     *
     */
    public static void test04() {
        int a = 8;
        int b = 7;
        int c = -7;
        System.out.println(a + " & " + b + " = " + (a & b));
        System.out.println(a + " & " + c + " = " + (a & c));
    }

    /**
     * |运算（二进制下，只要有一个1，就为1，否则就0）
     *
     */
    public static void test05() {
        int a = 11;
        int b = 3;
        System.out.println(a + " | " + b + " = " + (a | b));
    }

    /**
     * ^运算（二进制下，相同为0，不同为1）
     *
     */
    public static void test06() {
        int a = 11;
        int b = 3;
        System.out.println(a + " ^ " + b + " = " + (a ^ b));
    }

    public static void main(String[] args) {
        test06();
    }
}
