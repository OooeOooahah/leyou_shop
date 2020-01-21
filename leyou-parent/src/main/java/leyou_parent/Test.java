package leyou_parent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("hello");
        runnable.run();
        System.out.println(runnable);
        TreeSet<String> set =new TreeSet<>((x,y)->Integer.compare(x.length(),y.length()));
        int xa=10;
        Consumer<Integer> consumer =x -> System.out.println(x);
        consumer.accept(xa);

//        方法引用： 要求抽象方法的参数列表要和引用方法的参数列表相同
//        ：： 将方法名或者对象或类的名字分开
        /**
         * 三种格式：
         *  对象：：实例方法
         *  类：：静态方法
         *  类：：实例方法
         */
        System.out.println("----------------------------");
        Person p=new Person("tom","10");
        Note<String> note=p::getName;
        System.out.println(note.get("hello"));
        Function<Integer,String[]> fun=String[]::new;
        String[] s=fun.apply(20);
        System.out.println(s.length);
        System.out.println("-----------------------------");

        Person person=new Person("q","2");
        Supplier<Person> supplier=Person::new;
        System.out.println(supplier.get().getName());
        Supplier<Person> supplier1=()->new Person("tmo","hh");
        System.out.println(supplier1.get().getName());
        List<Integer> list = new ArrayList<>();
        Stream<Integer> stream = list.stream();
        stream.forEach(System.out::println);


        List<Employee> emps = Arrays.asList(
                new Employee(102, "李四", 59, 6666.66),
                new Employee(101, "张三", 18, 9999.99),
                new Employee(103, "王五", 28, 3333.33),
                new Employee(104, "赵六", 8, 7777.77),
                new Employee(104, "赵六", 8, 7777.77),
                new Employee(104, "赵六", 8, 7777.77),
                new Employee(105, "田七", 38, 5555.55)
        );
        emps.stream().filter(x->x.getAge()>10).limit(2).forEach(System.out::println);
//        并行流
        emps.stream().filter(x->x.getAge()>28).map(x->x.getName()).forEach(System.out::println);
    }
}
