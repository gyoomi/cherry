/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.n_serializable;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/5/31 10:55
 */
public class BeanUtil {

    public static <T> T initProperty(T obj, Map<String,Object> map) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            declaredFields[i].setAccessible(true);
            String fieldName = declaredFields[i].getName();
            Set<String> keySet = map.keySet();
            for (String s : keySet) {
                if (fieldName.equals(s)) {
                    declaredFields[i].set(obj, map.get(s));
                }
            }
        }

        return obj;
    }

    public static void main(String[] args) throws IllegalAccessException {
        Student s = new Student();
        Map<String,Object> map = new HashMap<>();
        map.put("id", 1001);
        map.put("name", "jack");
        map.put("hobby", "hehe1111");
        Student ss = initProperty(s, map);
        System.out.println(ss);
    }
}
