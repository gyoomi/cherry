/**
 * Copyright © 2018, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package cn.cherry.se.k_stream;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/8/5 16:01
 */

import java.util.*;
import java.util.stream.Collectors;

/**
 * 学生 对象
 */
class Student {
    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private int age;

    /**
     * 性别
     */
    private Gender gender;

    /**
     * 班级
     */
    private Grade grade;

    public Student(String name, int age, Gender gender, Grade grade) {
        super();
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "[name=" + name + ", age=" + age + ", gender=" + gender
                + ", grade=" + grade + "]";
    }

}

/**
 * 性别
 */
enum Gender {
    MALE, FEMALE
}

/**
 * 班级
 */
enum Grade {
    ONE, TWO, THREE, FOUR;
}

public class CollectDemo {

    public static void main(String[] args) {
// 测试数据
        List<Student> students = Arrays.asList(
                new Student("小明", 10, Gender.MALE, Grade.ONE),
                new Student("大明", 9, Gender.MALE, Grade.THREE),
                new Student("小白", 8, Gender.FEMALE, Grade.TWO),
                new Student("小黑", 14, Gender.FEMALE, Grade.FOUR),
                new Student("小红", 7, Gender.FEMALE, Grade.THREE),
                new Student("小黄", 13, Gender.MALE, Grade.ONE),
                new Student("小青", 13, Gender.FEMALE, Grade.THREE),
                new Student("小紫", 9, Gender.FEMALE, Grade.TWO),
                new Student("小王", 6, Gender.MALE, Grade.ONE),
                new Student("小李", 6, Gender.MALE, Grade.ONE),
                new Student("小马", 14, Gender.FEMALE, Grade.FOUR),
                new Student("小刘", 13, Gender.MALE, Grade.FOUR));

        // 得到所有学生的年龄列表
        // s -> s.getAge() --> Student::getAge , 不会多生成一个类似 lambda$0这样的函数
        TreeSet<Integer> treeSet = students.stream().map(Student::getAge).collect(Collectors.toCollection(TreeSet::new));
        Set<Integer> set = students.stream().map(Student::getAge).collect(Collectors.toSet());
        // 统计汇总信息
        System.out.println("------汇总信息-------");
        // 求和
        double collect = students.stream().collect(Collectors.summingDouble(Student::getAge));
        // 汇总
        IntSummaryStatistics summary = students.stream().collect(Collectors.summarizingInt(Student::getAge));
        DoubleSummaryStatistics summary2 = students.stream().collect(Collectors.summarizingDouble(Student::getAge));
        // 分块(两块 )
        Map<Boolean, List<Student>> partition1 = students.stream().collect(Collectors.partitioningBy((s -> s.getGender() == Gender.FEMALE)));
        // System.out.println(partition1.get(Boolean.TRUE));
        // System.out.println(partition1.get(Boolean.FALSE));
        // System.out.println(partition1);
        // 分块+处理（两块）
        //
        Map<Boolean, Integer> partition2 = students.stream().collect(Collectors.partitioningBy((s -> s.getGender() == Gender.FEMALE), Collectors.summingInt(Student::getAge)));
        Map<Boolean, IntSummaryStatistics> partition3 = students.stream().collect(Collectors.partitioningBy((s -> s.getGender() == Gender.FEMALE), Collectors.summarizingInt(Student::getAge)));
        // System.out.println(partition3.get(Boolean.TRUE));
        // 分组（多个）
        // 按照班级把这些学生进行分组
        Map<Grade, List<Student>> group1 = students.stream().collect(Collectors.groupingBy(Student::getGrade));
        // System.out.println(group1.get(Grade.ONE));
        // 分组 + 处理
        // 得到按照班级分组后的年龄的总和
        Map<Grade, Integer> group2 = students.stream().collect(Collectors.groupingBy(Student::getGrade, Collectors.summingInt(Student::getAge)));
        // System.out.println(group2);
        // 分组 + 处理 + 处理
        HashMap<Grade, Integer> group3 = students.stream().collect(Collectors.groupingBy(Student::getGrade, HashMap::new, Collectors.summingInt(Student::getAge)));
        System.out.println(group3);
    }

    /**
     * 可以看到有三个参数:
     *  第一个参数就是key的Function了，
     *  第二个参数是一个map工厂，也就是最终结果的容器，一般默认的是采用的HashMap::new，
     *  最后一个参数很重要是一个downstream，类型是Collector，也是一个收集器，
     *  那就是说，这三个参数其实就是为了解决分组问题的.
     *
     *  第一个参数：分组按照什么分类
     *
     *  第二个参数：分组最后用什么容器保存返回
     *
     *  第三个参数：按照第一个参数分类后，对应的分类的结果如何收集
     *
     *
     */
}
