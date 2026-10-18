package DynamicProgramming;

public class OneDimensionalDP {
    int bruteForceFib(int n){
        if(n<2){
            return n;
        }
        return bruteForceFib(n-1)+bruteForceFib(n-2);
    }
    // memoization
    int memoization(int n , int[] cache){
        if(n<2){
            return n;
        }
        if(cache[n]!=0){
            return cache[n];
        }

        cache[n] = memoization(n-1,cache) + memoization(n-1,cache);
        return cache[n];
    }

    // dynamic programming
    int dp(int n){
        if(n<2){
            return n;
        }
        int[] dp = {0,1};
        int i = 2;
        while(i<=n){
            int tmp = dp[1];
            dp[1]=dp[0]+dp[1];
            dp[0] = tmp;
            i++;
        }
        return dp[1];
    }
}
