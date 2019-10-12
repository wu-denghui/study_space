package com.goodhealth.algorithm.lambda;

import com.goodhealth.algorithm.Jackson_FastJson.Student;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

/**
 * @Description
 * @Author WDH
 * @Date 2019/9/19 14:57
 **/
public class FunctionInterface {

    public static void main(String[] args){
        unaryOperator();
    }

    /**
     * public interface Supplier<T> {...} Supplier 接口代表一个结果的提供者。
     * 用来生成数据的且必须返回一个数据，数据的类型通过泛型参数给定
     * 1.T get()
     */
    public static void supplier(){
        int a = 10;
        int b = 20;
        // 用于生产对象
        Supplier supplier = ()-> {return  new Student(); };
        //  直接使用
        Supplier supplier1 = ()-> "hanshujiekong";
        Supplier supplier2 = ()->{ return (a+b)/5;};
        // 用于作为方法的参数 此时 Lambda 表达式相当于方法体
        int[] arr ={1,2,4,5,9,6,3};
        int maxValues = maxValues(()-> {
            int max = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (max < arr[i]) {
                    max = arr[i];
                }
            }
                return max;
        });
    }

    public static int  maxValues(Supplier<Integer> supplier){
        return supplier.get();
    }

    /**
     * public interface Consumer<T> {...}
     * Consumer 接口代表接受单一的输入变量而且没有返回值的一类操作。
     * 它的作用和 Supplier 相反，是消费一个数据的，消费的数据类型需要通过泛型指定。
     * 1.void accept(T t);
     * 消费一个数据的时候，首先做一个操作，然后再做另一个操作，两个操作依次执行，实现一种组合操作。
     * 2.default Consumer<T>  andThen(Consumer<T>  after)
     *     例如：before.andThen(after).accept(s);
     *     before是一个Consumer，after也是一个Consumer  先执行before的accept在执行after的accept
     */
    public void  consumer(){
        // 直接使用
        Consumer consumer = (t)-> System.out.println(t);
        consumer.accept(123);
        Student student = new Student("xx");
        // 作为函数的入参-accept
        increaseAge(student,(Student s)->{
            s.setAge(1);
        });
        // 作为函数的入参 - andThen
        String[] arr = { "张飞,男", "貂蝉,女", "曹操,男","孙尚香,女"};
        //这里的 s 表示数组中的每个元素
        printInfo(arr, s ->{
            System.out.println("姓名：" + s.split(",")[0]);
        },s ->{
            System.out.println("性别：" + s.split(",")[1]);
        });
    }

    private void increaseAge(Student student, Consumer<Student> consumer){
        consumer.accept(student);
    }

    private void printInfo(String[] arr, Consumer<String> name, Consumer<String> gender) {
        for (String s : arr) {
            // 先执行name的accept 再执行gender的accept
            name.andThen(gender).accept(s);
        }
    }

    /**
     * public interface Predicate<T> {...}
     * Predicate 中文意思为谓语，"我是一个程序员"，"是"或"不是"就是谓语。
     * 它代表只有一个变量的函数，返回 boolean 类型。
     * 1.boolean test(T t); //抽象方法，对 t 进行测试，返回 boolean 类型
     *  组合方法，将当前的谓语与另一个谓语进行短路的与操作，返回一个谓语对象
     * 2.default Predicate<T> and(Predicate<? super T>  other) {...}
     *  对当前的谓语进行逻辑非操作，返回一个谓语对象
     * 3. default Predicate<T> negate() {...}
     * 组合方法，将当前的谓语与另一个谓语进行短路的或操作，返回一个谓语对象
     * 4.default Predicate<T> or(Predicate<? super T> other) {...}
     *  静态方法，判断 test(object)方法传入的对象是否与参数 targetRef 对象相等
     * 5. static  Predicate<T> isEqual(Object targetRef) {...}
     */
    public void predicate(){
        // 直接使用  test
        Predicate<String> predicate = s ->"true".equals(s);
        predicate.test("trme");
        //  直接使用 and/or
        Predicate<String> predicate1 = s -> "tr".equals(s);
        predicate.and(predicate1).test("tem");
        predicate.or(predicate1).test("tem");
        //  直接使用 negate
        predicate.negate().test("sd");
    }

    /**
     * public interface Function<T, R> {...}
     * 根据一个参数得到另一个参数值，前面称为计算的参数，后面称为计算的结果。有进有出，所以称为“函数 Function”。
     * 对给定的变量 t 进行计算，得到返回的结果 R
     * 1.R apply(T t);
     * 默认组合方法，先计算当前函数，再计算传入的函数
     * 2.default <V> Function<T, V> andThen(Function<? super R, ? extends V> after) {...}
     * 默认组合方法，先计算传入的函数，再计算当前函数
     * 3.default <V> Function<V, R> compose(Function<? super V, ? extends T> before) {...}
     * 静态方法：总是返回它的输入变量
     * 4.static <T> Function<T, T> identity() {...}
     */
    public void function(){
        // 直接使用 apply
        Function<Integer,Integer> function = (i)->2*i;
        function.apply(10);
        // 直接使用 andThen
        Function<Integer,Integer> function1 = (i)->i%10;
        function.andThen(function1).apply(100);
        // 直接使用compose
        function1.compose(function).apply(100);
    }

    /**
     * public interface BinaryOperator<T> extends BiFunction<T,T,T> {...}
     * BinaryOperator 表示对两个相同类型的操作数进行操作，产生相同类型的结果。
     * 从父接口 BiFunction 中继承下来的抽象方法，传入两个参数 t 和 u 进行函数计算，返回计算的结果。
     * 1.T apply(T t, T u);
     * 返回一个BinaryOperator ，它根据指定的Comparator返回两个元素中的较大Comparator 。  
     * 2.static <T> BinaryOperator<T> maxBy(Comparator<? super T> comparator){...}
     * 返回BinaryOperator返回根据指定的两个元件的较小的Comparator 。
     * 3.static <T> BinaryOperator<T> minBy(Comparator<? super T> comparator){...}
     */
    public void binaryOperator(){
        // 直接使用apply
        BinaryOperator<Integer> binaryOperator = (m,n)->m+n;
        binaryOperator.apply(1,2);
        // 直接使用 maxBy minBy
        BinaryOperator<Integer> binaryOperator1 = BinaryOperator.maxBy(Comparator.naturalOrder());
        binaryOperator.apply(4,5);
    }

    /**
     * public interface UnaryOperator<T> extends Function<T, T>{...}
     * 从 Function 接口中继承下来的抽象方法，使用给定的参数应用此一元运算函数，返回另一个值。
     * 1.T apply(T t);
     * 始终返回其输入参数的一元运算符也就是后续 apply()输入的是什么，就返回什么。
     * 2.static  UnaryOperator identity() {...}
     */
    public static void unaryOperator(){
        // 直接使用apply
        UnaryOperator<Integer> unaryOperator = t-> t*10;
        System.out.println(unaryOperator.apply(10));
        // 作为函数的参数使用 apply
        List names = Arrays.asList("Jack","Rose","Tom","NewBoy");
        System.out.println("替换前：" + names);
        UnaryOperator<String> unaryOperator1 = s -> s.toUpperCase();
        names.replaceAll(unaryOperator1);
        System.out.println("替换后：" + names);
    }


}
