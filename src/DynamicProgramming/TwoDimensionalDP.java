package DynamicProgramming;

public class TwoDimensionalDP {
    // Brute force count paths O(2^(n+m)) time and space
    public int bruteForce(int r , int c, int rows, int cols){
        if(r==rows || c == cols){
            return 0;
        }
        if(r == rows-1 && c == cols-1){
            return 1;
        }
        return bruteForce(r+1,c,rows,cols) + bruteForce(r,c+1,rows,cols);
    }
    // memoization O(n*m) time and space
    public int memoization(int r, int c , int rows,int cols, int[][] cache){
        if(r==rows || c == cols){
            return 0;
        }
        if(cache[r][c]>0){
            return cache[r][c];
        }if(r==rows-1 && c == cols-1){
            return 1;
        }
        cache[r][c] = memoization(r+1,c,rows,cols,cache) + memoization(r,c+1,rows,cols,cache);
        return cache[r][c];
    }

}
