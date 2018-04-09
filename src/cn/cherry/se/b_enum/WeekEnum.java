/**
 * Copyright © 2018, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.b_enum;

/**
 * 星期枚举类
 *
 * @author Leon
 * @version 2018/4/9 22:32
 */
public enum WeekEnum {
    MONDAY("星期一",1),TUESDAY("星期二",2),WENSDAY("星期三",3);

    /**
     * 名称
     */
    private String name;

    /**
     * 数值
     */
    private Integer value;

    private WeekEnum(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Integer getValue() {
        return value;
    }

}
