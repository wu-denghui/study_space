package com.goodhealth.algorithm.ComparatorAndComparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName ComparatorAndComparable
 * @Description 比较器
 *
 * 与Comparable接口不同的是：
 * ①、Comparator位于包java.util下，而Comparable位于包java.lang下。
 * ②、Comparable接口将比较代码嵌入需要进行比较的类的自身代码中，而Comparator接口在一个独立的类中实现比较。
 * ③、如果前期类的设计没有考虑到类的Compare问题而没有实现Comparable接口，
 *     后期可以通过Comparator接口来实现比较算法进行排序，并且为了使用不同的排序标准做准备，比如：升序、降序。
 * ④、Comparable接口强制进行自然排序，而Comparator接口不强制进行自然排序，可以指定排序顺序。
 * @Author WDH
 * @Date 2019/9/6 10:41
 * @Version 1.0
 **/
public class MyComparator implements Comparator<ComparableUsage> {

    public static void main(String[] args){
        // 排序
        MyComparator myComparator = new MyComparator();
        List<ComparableUsage> list = new ArrayList<>();
        Collections.sort(list,myComparator);
    }

    @Override
    public int compare(ComparableUsage o1, ComparableUsage o2) {
        if (o1.getAge() > o2.getAge()){
            return 1;
        }
        if (o1.getAge() < o2.getAge()){
            return -1;
        }
        if (o1.getAge().equals(o2.getAge())){
            if (o1.getName().hashCode() > o2.getName().hashCode()){
                return 1;
            }
            if (o1.getName().hashCode() < o2.getName().hashCode()){
                return -1;
            }
        }
        return 0;
    }


}
