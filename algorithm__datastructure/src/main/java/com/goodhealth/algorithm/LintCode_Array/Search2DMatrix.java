package com.goodhealth.algorithm.LintCode_Array;

public class Search2DMatrix {
    public static void main(String[] args){
        int [][] ma={{1,4,5},{6,7,8}};

        System.out.println(searchMatrix(ma,8));

    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix==null||matrix.length==0){
            return false;
        }
        int x = getX(matrix,target);
        for(int i=0;i<matrix[x].length;i++){
            if (matrix[x][i]==target){
                return true;
            }
        }
        return false;
    }

    public static int getX(int[][] matrix, int target){
        for(int i=0;i<matrix.length;i++){
            if (matrix[i][0]==target){
                return i;
            }
            if (matrix[i][0]>target&&i-1>0){
                return i-1;
            }
        }
        return matrix.length-1;
    }
}
