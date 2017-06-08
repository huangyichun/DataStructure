import java.util.LinkedList;

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
 */
public class LeetCode_21 {

    int[][] offset = new int[][]{{-1, 0},{0, -1},{1, 0},{0, 1}};
    public void solve(char[][] board) {
        if(board == null || board.length <= 1 || board[0].length <= 1){
            return;
        }
        //第一行
        for (int i = 0; i < board[0].length; ++i) {
            if(board[0][i] == 'O'){
                changeOToY(board, 0, i);
            }
        }
        //第一列
        for (int i = 0; i < board.length; ++i) {
            if(board[i][0] == 'O'){
                changeOToY(board, i, 0);
            }
        }
        //最后一列
        for(int i = 0; i < board.length; ++i) {
            if(board[i][board[0].length-1] == 'O'){
                changeOToY(board, i, board[0].length-1);
            }
        }
        //最后一行
        for(int i = 0; i < board[0].length; ++i) {
            if(board[board.length-1][i] == 'O'){
                changeOToY(board, board.length-1, i);
            }
        }

        for(int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if(board[i][j] == '*') {
                    board[i][j] = 'O';
                }else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
    public void changeOToY(char[][] board, int x, int y) {
        for (int i = 0; i < offset.length; ++i) {
            int offsetX = x + offset[i][0];
            int offsetY = y + offset[i][1];
            if (offsetX >= 0 && offsetX < board.length &&
                    offsetY>=0 && offsetY <board[0].length && board[offsetX][offsetY] == 'O') {
                board[offsetX][offsetY] = '*';
                changeOToY(board, offsetX, offsetY);
            }
        }
    }

    /*public void changeOToY(char[][] board, int x,  int y) {
        LinkedList<Point> queue = new LinkedList<>();
        queue.offer(point);
        while (!queue.isEmpty()) {
            Point node = queue.poll();
            board[node.x][node.y] = '*';
            for(int i = 0; i < offset.length; ++i) {
                int offsetX = node.x + offset[i][0];
                int offsetY = node.y + offset[i][1];
                if (offsetX >= 0 && offsetX < board.length &&
                        offsetY>=0 && offsetY <board[0].length && board[offsetX][offsetY] == 'O') {
                    queue.offer(new Point(offsetX, offsetY));
                }
            }
        }
    }*/

}


