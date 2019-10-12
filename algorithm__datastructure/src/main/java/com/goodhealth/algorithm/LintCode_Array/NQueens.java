package com.goodhealth.algorithm.LintCode_Array;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */

/**
 * @author 24663
 * @date 2018年9月21日
 * @Description
 */
public class NQueens {
	public static void main(String[] args) {
		NQueens nQueens=new NQueens();
		List<List<String>> result = nQueens.solveNQueens(8);
		System.out.println(result.size());
		String  string;
		for (int i = 0; i < result.size(); i++) {
			for (int j = 0; j < result.get(i).size(); j++) {
			string=result.get(i).get(j);
				System.out.println(string);
			}
		}
	}

	public List<List<String>> solveNQueens(int n) {
		List<List<String>> result = new ArrayList<List<String>>();
		boolean[][] bool = new boolean[n][n];
		for (int i = 0; i < bool.length; i++) {
			for (int j = 0; j < bool.length; j++) {
				bool[i][j] = true;
			}
		}
		find( result,bool, n,0);
		return result;
	}

	private void find(List<List<String>> result, boolean[][] bool, int n, int index) {
		if (index == n) {
			List<String> list=getList(bool,n);
			if (!result.contains(list)) {
				result.add(list);
			}
			return;
		}
		boolean[][] temp=new boolean[n][n] ;
		back(temp, bool);
		for (int j = 0; j < n; j++) {
			if (bool[index][j]) {
				change(bool,index,j,n);
				find(result, bool, n, index+1);
				back(bool,temp);
			}
		}

	}
 

	private void back(boolean[][] bool, boolean[][] temp) {
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp.length; j++) {
				bool[i][j]=temp[i][j];
			}
		}
	}


	private List<String> getList(boolean[][] bool, int n) {
		List<String> list=new ArrayList<String>() ;
		char[][] ch=new char[n][n];
		for (int i = 0; i < bool.length; i++) {
			for (int j = 0; j < bool.length; j++) {
				if (bool[i][j]==true) {
				    ch[i][j]='Q';
				}else{
					ch[i][j]='.';
				}
			}
		}
		String string;
		for (int i = 0; i < ch.length; i++) {
			string=new String(ch[i]);
			list.add(string);
		}
		return list;
	}

	private void change(boolean[][] bool,int x,int y,int n) {
		for (int i = 0; i < n; i++) {
			if (i==y) {
				bool[x][i]=true;
			}else{
				bool[x][i]=false;
			}
		}
		for (int i = 0; i < n; i++) {
			if (i==x) {
				bool[i][y]=true;
			}else{
				bool[i][y]=false;
			}
		}
		if (x+1<n&&y-1>=0) {
			bool[x+1][y-1]=false;
		}
		if (x+1<n&&y+1<n) {
			bool[x+1][y+1]=false;
		}
	}
//-------------------------------------------------------------------------------------------------------------
	List<List<String>> solveNQueens0(int n) {
        List<List<String>> results = new ArrayList<>();
        if (n <= 0) {
            return results;
        }
        
        search(results, new ArrayList<Integer>(), n);
        return results;
    }
   
    private void search(List<List<String>> results,
                        List<Integer> cols,
                        int n) {
        if (cols.size() == n) {
            results.add(drawChessboard(cols));
            return;
        }
        
        for (int colIndex = 0; colIndex < n; colIndex++) {
            if (!isValid(cols, colIndex)) {
                continue;
            }
            cols.add(colIndex);
            search(results, cols, n);
            cols.remove(cols.size() - 1);
        }
    }
    
    private List<String> drawChessboard(List<Integer> cols) {
        List<String> chessboard = new ArrayList<>();
        for (int i = 0; i < cols.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < cols.size(); j++) {
                sb.append(j == cols.get(i) ? 'Q' : '.');
            }
            chessboard.add(sb.toString());
        }
        return chessboard;
    }
    
    private boolean isValid(List<Integer> cols, int column) {
        int row = cols.size();
        for (int rowIndex = 0; rowIndex < cols.size(); rowIndex++) {
            if (cols.get(rowIndex) == column) {
                return false;
            }
            if (rowIndex + cols.get(rowIndex) == row + column) {
                return false;
            }
            if (rowIndex - cols.get(rowIndex) == row - column) {
                return false;
            }
        }
        return true;
    }
	
	
	
	
}
