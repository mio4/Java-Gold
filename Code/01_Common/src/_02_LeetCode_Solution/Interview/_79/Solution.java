package _02_LeetCode_Solution.Interview._79;

public class Solution {
    private static int m;
    private static int n;
    public static boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        boolean[][] isVisit = new boolean[m][n];

        for(int i=0; i < m; i++){
            for(int j=0; j < n; j++){
                if(search(board,isVisit,i,j,word,0)){
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean search(char[][] board,boolean[][] isVisit,int i,int j,String word,int begin){
        if(board[i][j] != word.charAt(begin) || isVisit[i][j]){
            return false;
        }
        if(word.length() == begin+1){
            return true;
        }

        if(isValid(i-1,j)){
            isVisit[i][j] = true;
            if(search(board,isVisit,i-1,j,word,begin+1)) return true;
            isVisit[i][j] = false;
        }
        if(isValid(i+1,j)) {
            isVisit[i][j] = true;
            if(search(board, isVisit, i + 1, j, word, begin + 1)) return true;
            isVisit[i][j] = false;
        }
        if(isValid(i,j-1)){
            isVisit[i][j] = true;
            if(search(board,isVisit,i,j-1,word,begin+1)) return true;
            isVisit[i][j] = false;
        }
        if(isValid(i,j+1)){
            isVisit[i][j] = true;
            if(search(board,isVisit,i,j+1,word,begin+1)) return true;
            isVisit[i][j] = false;
        }
        return false;
    }

    public static boolean isValid(int i,int j){
        return (i >= 0 && i < m && j >= 0 && j < n);
    }

    public static void main(String[] args) {
//        char[][] a  = {{'a'}};
//        exist(a,"a");

        char[][] a2 ={{'a','a'}};
        exist(a2,"aaa");
    }
}
