package topic.other;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LC200 岛屿数量
 * @author d3y1
 */
public class LC200 {
    public int numIslands(char[][] grid) {
        return solution1(grid);
    }

    private int m,n;
    private boolean[][] isVisited;
    private int[] dx = new int[]{1, -1, 0, 0};
    private int[] dy = new int[]{0, 0, 1, -1};

    /**
     * bfs
     * @param grid
     * @return
     */
    private int solution1(char[][] grid){
        m = grid.length;
        n = grid[0].length;
        isVisited = new boolean[m][n];
        int island = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!isVisited[i][j]){
                    isVisited[i][j] = true;
                    if(grid[i][j] == '1'){
                        bfs(grid, i, j);
                        island++;
                    }
                }
            }
        }

        return island;
    }

    /**
     * bfs
     * @param grid
     * @param row
     * @param col
     */
    private void bfs(char[][]grid, int row, int col){
        Queue<Loc> queue = new LinkedList<>();
        queue.offer(new Loc(row, col));
        Loc loc;
        int nextRow,nextCol;
        while(!queue.isEmpty()){
            loc = queue.poll();
            for(int i=0; i<4; i++){
                nextRow = loc.row+dx[i];
                nextCol = loc.col+dy[i];
                if(isValid(nextRow, nextCol)){
                    if(!isVisited[nextRow][nextCol]){
                        isVisited[nextRow][nextCol] = true;
                        if(grid[nextRow][nextCol] == '1'){
                            queue.offer(new Loc(nextRow, nextCol));
                        }
                    }
                }
            }
        }
    }

    /**
     * 校验位置是否合法
     * @param row
     * @param col
     * @return
     */
    private boolean isValid(int row, int col){
        if(0<=row&&row<m && 0<=col&&col<n){
            return true;
        }

        return false;
    }

    /**
     * 位置
     */
    private class Loc {
        int row;
        int col;
        public Loc(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
}
