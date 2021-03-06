import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a 2D board containing'X'and'O', capture all regions surrounded by'X'.
 * A region is captured by flipping all'O's into'X's in that surrounded region .
 * For example,
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * <p>
 * After running your function, the board should be:
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 *
 * 思路:从矩阵的四个边查找字符为’O'的结点
 * 然后从该节点出发使用广度优先搜素，将找到的节点改为'F'
 */
public class SurroundedRegions {

    private static final int[][] offset = new int[][]{{-1, 0},{0, -1},{1, 0},{0, 1}};
    private static final int FREE = 'F';
    private static final int TRAVEL = 'T';
    public void solve(char[][] board) {
        if(board == null || board.length <= 1 || board[0].length <= 1){
            return;
        }
        int row = board.length;
        int col = board[0].length;
        //第一行和最后一行
        for (int i = 0; i < col; ++i) {
            if(board[0][i] == 'O'){
                bfs(board, new Point(0, i));
            }
            if(board[row-1][i] == 'O'){
                bfs(board, new Point(row-1, i));
            }
        }
        //第一列和最后一列
        for (int i = 1; i < row-1; ++i) {
            if(board[i][0] == 'O'){
                bfs(board, new Point(i, 0));
            }
            if(board[i][col-1] == 'O'){
                bfs(board,  new Point(i, col-1));
            }
        }

        for(int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if(board[i][j] == TRAVEL) {
                    board[i][j] = 'O';
                }else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    /**
     * 采用广度优先搜素
     * @param board
     * @param point
     */
    public void bfs(char[][] board, Point point) {
        LinkedList<Point> queue = new LinkedList<>();
        queue.offer(point);
        while (!queue.isEmpty()) {
            Point node = queue.poll();
            board[node.x][node.y] = TRAVEL; //一定要修改，不然会重复添加
            for (Point point1 : expand(board, node)) {
                queue.offer(point1);
            }
        }
    }

    /**
     * 找到相邻结点为‘O'的结点
     * @param board
     * @param node
     * @return
     */
    public List<Point> expand(char[][] board, Point node) {
        List<Point> list = new ArrayList<>();
        for(int i = 0; i < offset.length; ++i) {
            int offsetX = node.x + offset[i][0];
            int offsetY = node.y + offset[i][1];

            if (offsetX >= 0 && offsetX < board.length &&
                    offsetY>=0 && offsetY <board[0].length && board[offsetX][offsetY] == 'O') {
                board[offsetX][offsetY] = FREE;
                list.add(new Point(offsetX, offsetY));
            }
        }
        return list;
    }

    class Point {
        int x;
        int y;
        Point(int a, int b) {
            x = a;
            y = b;
        }
    }
}


