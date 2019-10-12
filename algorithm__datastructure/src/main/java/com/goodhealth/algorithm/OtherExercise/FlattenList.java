package com.goodhealth.algorithm.OtherExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class FlattenList {
    public static void main(String[] args){
        FlattenList ma = new FlattenList();
        System.out.println(ma.flatten(Arrays.asList()));
    }

    public List<Integer> flatten(List<NestedInteger> nestedList) {
        boolean isFlat = true;
        List<NestedInteger> ls = nestedList;
        while (isFlat) {
            isFlat = false;
            List<NestedInteger> newLs = new ArrayList<>();
            for (NestedInteger ni : ls) {
                if (ni.isInteger()) {
                    newLs.add(ni);
                } else {
                    newLs.addAll(ni.getList());
                    isFlat = true;
                }
            }
            ls = newLs;
        }
        List<Integer> r = new ArrayList<>();
        for (NestedInteger ni : ls) {
            r.add(ni.getInteger());
        }
        return r;
    }

    class NestedInteger {
        public boolean isInteger() {
            return false;
        }

        public Integer getInteger() {
            return 2;
        }

        public Collection<? extends NestedInteger> getList() {
            return null;
        }
    }
}
