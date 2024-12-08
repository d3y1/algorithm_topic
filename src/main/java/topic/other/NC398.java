package topic.other;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * NC398 腐烂的苹果
 * @author d3y1
 */
public class NC398 {
    // 行列
    private int n,m;
    // 是否访问过
    private boolean[][] isVisited;
    // dx dy; 上下左右 四个方向
    private int[] dx = new int[]{-1, 1, 0, 0};
    private int[] dy = new int[]{0, 0, 1, -1};

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param grid int整型ArrayList<ArrayList<>>
     * @return int整型
     */
    public int rotApple (ArrayList<ArrayList<Integer>> grid) {
        return solution(grid);
    }

    /**
     * bfs
     * @param grid
     * @return
     */
    private int solution(ArrayList<ArrayList<Integer>> grid){
        n = grid.size();
        m = grid.get(0).size();

        isVisited = new boolean[n][m];

        Queue<Loc> queue = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid.get(i).get(j) == 2){
                    queue.offer(new Loc(i, j));
                    isVisited[i][j] = true;
                }
            }
        }

        int size;
        Loc loc;
        int nextRow,nextCol;
        int minute = -1;
        while(!queue.isEmpty()){
            size = queue.size();
            while(size-- > 0){
                loc = queue.poll();
                for(int i=0; i<4; i++){
                    nextRow = loc.row+dx[i];
                    nextCol = loc.col+dy[i];
                    if(isLocValid(nextRow, nextCol) && !isVisited[nextRow][nextCol]){
                        isVisited[nextRow][nextCol] = true;
                        if(grid.get(nextRow).get(nextCol) == 1){
                            grid.get(nextRow).set(nextCol, 2);
                            queue.offer(new Loc(nextRow, nextCol));
                        }
                    }
                }
            }
            minute++;
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid.get(i).get(j) == 1){
                    return -1;
                }
            }
        }

        return minute;
    }

    /**
     * 校验位置是否合法
     * @param row
     * @param col
     * @return
     */
    private boolean isLocValid(int row, int col){
        if((0<=row&&row<n) && (0<=col&&col<m)){
            return true;
        }

        return false;
    }

    /**
     * 腐烂苹果位置
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