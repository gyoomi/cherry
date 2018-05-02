/**
 * Copyright © 2018, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.g_innerclass;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/5/2 22:36
 */
public class StaticInnerClassTest {
    public static void main(String[] args) {
        double[] d = new double[20];
        for (int i = 0; i < d.length; i++) {
            d[i] = Math.random();
        }
        ArrayAlg.Pair pair = ArrayAlg.minmax(d);
        System.out.println(pair.getFirst());
        System.out.println(pair.getSecond());
    }
}

class ArrayAlg{

    public static class Pair{
        private double first;
        private double second;

        public Pair(double f, double s){
            first = f;
            second = s;
        }

        public double getFirst(){
            return first;
        }

        public double getSecond(){
            return second;
        }
    }

    public static Pair minmax(double[] values){
        double min = Double.POSITIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;
        for (double value : values) {
            if (min > value){
                min = value;
            }
            if (max < value){
                max = value;
            }
        }
        return new Pair(min, max);
    }
}
