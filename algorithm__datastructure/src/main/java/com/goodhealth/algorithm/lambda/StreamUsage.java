package com.goodhealth.algorithm.lambda;

import com.goodhealth.algorithm.Jackson_FastJson.Student;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description
 * @Author WDH
 * @Date 2019/9/19 19:31
 **/
public class StreamUsage {
    public static void main(String[] args){
//        collectionStream();
        arrayStream();
    }

    /**
     * 数组流的使用
     */
    public static void arrayStream(){
        /**
         *  1.构造流
         */
        Student stu1 = new Student("小王",12);
        Student stu2 = new Student("小L",4);
        Student stu3 = new Student("小Z",10);
        Integer[] arr = {1,2,3,4,5,6,3,2,7};
        Stream.of("A","b","C");
        Stream.of(1,2,3,4,6,3,2);
        Stream.of(arr);
        Arrays.stream(arr);
        Student[] array ={stu1,stu2,stu3};
        /**
         *   2.使用stream
         */
        Arrays.stream(array)
        // map  一一映射的关系  A->B  lambda中有返回值  括号内是个Function
        // mapToInt就是把原始Stream转换成一个新的Stream，
        // mapToInt，mapToLong和mapToDouble 三个变种方法，这个新生成的Stream中的元素都是int类型可以免除自动装箱/拆箱的额外消耗；
        .map(t-> {t.setAge(t.getAge()+10);return t;})
        // filter 过滤 一一映射   括号内是个Predicate
        .filter(t->t.getAge()>18).toArray();

        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        );
        // flatMap 将多个流平铺出来  变成一条流 123456
        inputStream.flatMap((list) -> list.stream())
        // forEach 方法接收一个 Lambda 表达式，然后在 Stream 的每一个元素上执行该表达式。括号内是个Consumer
        .forEach(System.out::print);

        List<String> strs = Arrays.asList("d", "b", "a", "c", "a");
        //  max/min  传入一个Comparator比较器  返回流中最大值Optional
        Optional<String> max = strs.stream().max((o1, o2) -> o1.compareTo(o2)); max.get();
        //count 统计流中元素个数
        strs.stream().skip(2).count();
        // 串行流时  findFirst/findAny(终止流操作) 返回的都是流的第一个元素Optional
        // 并发流时  findFirst返回的是流的第一个元素 findAny返回的是上个并发流操作中执行最快的流中的第一个元素Optional
        Optional<String> aa = strs.stream().filter(str -> !str.equals("a")).findFirst();
        aa.ifPresent(System.out::println);
        Optional<String> bb = strs.stream().filter(str -> !str.equals("a")).findAny();
        Optional<String> aa1 = strs.parallelStream().filter(str -> !str.equals("a")).findFirst();
        Optional<String> bb1 = strs.parallelStream().filter(str -> !str.equals("a")).findAny();
        /**
         * 3.终止流
         */
        // toArray 将流转化为数组  不带参数默认转为Object[]
        Object[] res = Arrays.stream(arr).map(t->t*2).toArray();
        Integer[] res2 = Arrays.stream(arr).map(t->t*2).toArray(Integer[]::new);
        //  Collectors.summarizingInt/summarizingLong/summarizingDouble  获得流的统计
        IntSummaryStatistics result = Arrays.stream(arr).peek(System.out::println).map(t->t*2).collect(Collectors.summarizingInt(Integer::valueOf));
        result.getAverage();
        result.getCount();
        result.getMax();
        result.getMin();
        result.getSum();
        // mapping  只在流中获取自己想要的字段
        List<String> nameList = Arrays.stream(array).collect(Collectors.mapping(Student::getLoginName,Collectors.toList()));

    }

    /**
     * 集合流的使用
     */
    public static void collectionStream(){
        Integer[] arr = {1,2,3,4,5,6,3,2,7};
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(arr));
        /**  1.构造流 */
        list.stream();
        /**  2.使用stream
         * map (mapToInt, flatMap 等)、 filter、
         * distinct、 sorted、 peek、 limit、 skip、
         * parallel、 sequential、 unordered
         */
        // reduce 累计操作（流中元素每一个前后处理一次，4个元素处理3次）
        // 参数为  初始值（可选） BinaryOperator  返回的不是流而是Optional(没有初始值）或 T（有初始值）
        Integer a = list.stream().reduce(1,(n,m)-> n*m);
        Optional<Integer> aa = list.stream().reduce((n,m)-> n*m);
        // limit 只取流中指定数量的前几个元素
        list.stream().limit(3).collect(Collectors.toList());
        // skip  跑去流中指定数量的前几个元素
        list.stream().skip(3).collect(Collectors.toList());
        // sorted  排序  参数为Comparator  可选 当不传时是自然排序
        list.stream().skip(2).sorted((n,m)->n.compareTo(m)).collect(Collectors.toList());
        // distinct 去重
        list.stream().sorted().distinct().collect(Collectors.toList());
        // anyMatch  noneMatch   allMatch   返回boolean  传入一个Predicate
        list.stream().allMatch(t->t>8);
        /**
         * 终止流
         */
        // Collectors.toList()    转成list
        list.stream().map(t->t*2).collect(Collectors.toList());
        list.stream().map(t->t*2).collect(Collectors.toSet());
        list.stream().map(t->t*2).collect(Collectors.toCollection(ArrayList::new));
        list.stream().map(t->t*2).collect(Collectors.toCollection(LinkedList::new));
        list.stream().map(t->t*2).collect(Collectors.toCollection(HashSet::new));
        // Collectors.partitioningBy 根据条件分组为 true 和 false 两条list
        list.stream().map(t-> 2*t).collect(Collectors.partitioningBy(t->t>10));
        // Collectors.groupingBy 根据条件分为多个组
        /** 分组且计算每组最大值*/
         Map<String,Optional<Integer>> mop = Stream.of(-6, -7, -8, -9, 1, 2, 3, 4, 5, 6)
                .collect(Collectors.groupingBy(integer -> {
                    if (integer < 0) {
                        return "小于";
                    } else if (integer == 0) {
                        return "等于";
                    } else {
                        return "大于";
                    }
                }, Collectors.maxBy(Comparator.naturalOrder())));
        System.out.println(mop.get("大于").get());
        // toMap  toCurrentHashMap   转换为map
        // 转成map时 如有key冲突 会报错java.lang.IllegalStateException: Duplicate key N
        list.stream().map(t-> 2*t).collect(Collectors.toMap(Function.identity(),Function.identity()));
        list.stream().map(t-> 2*t).collect(Collectors.toConcurrentMap(Function.identity(),Function.identity()));
        // Collectors.toJoin(分隔符，前缀，后缀) 三个参数皆为可选 将元素按指定规格拼接 内部为StringBuffer
        list.stream().map(t->2*t).map(String::valueOf).collect(Collectors.joining("-","[","]"));
    }
}
