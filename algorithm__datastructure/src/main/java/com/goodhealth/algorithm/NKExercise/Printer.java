/**
 * 将一个二维矩阵顺时针打印
 */
package com.goodhealth.algorithm.NKExercise;

public class Printer {
	public static void main(String[] args) {
		Printer printer = new Printer();
		int[][] mat = { { 1, 2, 3 ,4,5}, { 4, 5, 6 ,4,5}, { 5, 6, 7,5,6 }, { 7, 8, 9,6 ,7},{7,7,8,9,10 }};
		int n = mat[0].length;
		int m = mat.length;
		int[] an = printer.clockwisePrint(mat, n, m);
		for (int i = 0; i < an.length; i++) {
			System.out.println(an[i]);
		}

	}

    public int[]    clockwisePrint(int[][] mat,int n,int m) { 
        int[] a =new int[m*n]; 
          if( mat ==null) 
              return a; 
          int i =0; 
          int j =0; 
          int k =0; 
          int startX =0; 
          int startY =0;    
          int endX = n -1; 
          int endY = m -1; 
          while( startX <= endX && startY <= endY ){ 
       
          //如果只剩下一行

              if( startX ==    endX ){    

                  for( ; j    <= endY ;j++,k++){ 
                      a[k] =    mat[startX][j]; 
                  } 
                  return a; 
              } 
          //如果只剩下一列 
              if( startY ==    endY ){ 
                  for( ; i    <= endX ; i++,k++){ 
                      a[k] =    mat[i][startY]; 
                  } 
                  return a; 
              } 
               
              //将矩阵上边除右顶点添加到返回的数组中

              for( ; j < endX ; j++,k++){ 
                  a[k] =    mat[i][j]; 
              } 
             //将矩阵右边除边下顶点添加到返回的数组中 
              for( ; i <  endY ; i++,k++){ 
                  a[k] =    mat[i][j]; 
              } 
            //将矩阵下边除边左顶点添加到返回的数组中 
              for( ; j >   startX ; j--,k++){ 
                  a[k] =    mat[i][j]; 
              } 
               //将矩阵左边除边上顶点添加到返回的数组中 
              for( ; i >    startY ; i--,k++){ 
                  a[k] =   mat[i][j]; 
              } 
                  
              i++; 
              j++; 
              startX++; 
              startY++; 
              endX--; 
              endY--; 
          }       
      
          return a; 
      } 
  } 
