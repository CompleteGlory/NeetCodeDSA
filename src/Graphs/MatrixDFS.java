package Graphs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

public class MatrixDFS {
    public int dfs(int[][] grid,int r,int c , int[][] visit){
        int rows = grid.length;
        int cols = grid[0].length;
        if(Math.min(r,c)<0 || r==rows || c == cols || visit[r][c]==1 || grid[r][c] == 1 ){
            return 0;
        }
        if (r==rows-1 && c == cols-1){
            return 1;
        }
        visit[r][c]=1;
        int count = 0;
        count+=dfs(grid,r+1,c,visit);
        count+=dfs(grid,r-1,c,visit);
        count+=dfs(grid,r,c+1,visit);
        count+=dfs(grid,r,c-1,visit);

        visit[r][c]=0;
        return count;
    }



    public int bfs(int[][] grid){
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] visited = new int[4][4];
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[2]);
        visited[0][0]=1;
        int length = 0;
        while(!queue.isEmpty()){
            int queueLength = queue.size();
            for(int i = 0; i < queueLength; i++){
                int[] pair = queue.poll();
                int r = pair[0] , c = pair[1];
                if(r == rows-1 && c == cols-1 ){
                    return length;
                }
                int[][] neighbors = {{r,c+1},{r,c-1},{c,r+1},{r,c-1}};
                for(int j=0;j<4;j++){
                    int newR = neighbors[j][0], newC = neighbors[j][1];
                    if(Math.min(newR,newC) <0 || newR == rows || newC == cols || visited[newR][newC] ==1 || grid[newR][newC] ==1 ){
                        continue;
                    }
                    queue.add(neighbors[j]);
                    visited[newR][newC] = 1;
                }
            }
            length++;
        }
        return length;
    }

    public int bfs2(int[][] grid){
        int rows = grid.length;
        int cols = grid[0].length;
        Deque<int[]> q = new ArrayDeque<>();
        int[][] visit = new int[rows][cols];
        int ans =0;
        q.add(new int[2]);
        visit[0][0]=1;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0;i<size;i++){
                int[] pair = q.poll();
                int r = pair[0],c = pair[1];
                if(r == rows-1 && c == cols-1){
                    return ans;
                }
                int[][] neighbours = {{r+1,c},{r-1,c},{r,c+1},{r,c-1}};
                for(int j = 0; j<4;j++){
                    int newR = neighbours[j][0],newC = neighbours[j][1];
                    if(Math.min(newR,newC) < 0 || newR ==rows || newC == cols || visit[newR][newC]==1 || grid[newR][newC]==1){
                        continue;
                    }

                    q.add(neighbours[j]);
                    visit[newR][newC]=1;
                }
            }
            ans++;
        }
        return ans;
    }
}
