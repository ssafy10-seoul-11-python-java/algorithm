import java.util.PriorityQueue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 
class Point implements Comparable<Point> {
    int y, x, t;
    public Point(int y, int x, int t) {
        this.y = y;
        this.x = x;
        this.t = t;
    }
 
    @Override
    public int compareTo(Point p) {
        return this.t > p.t ? 1 : -1;
    }
}
 
class Solution {
 
    private static final int SIZE = 102;
    private static int[][] board = new int[SIZE][SIZE];
 
    public static void main(String[] args) throws Exception {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
 
        for (int test_case = 1; test_case <= T; test_case++) {
            int n, ret = 0;
            n = Integer.parseInt(br.readLine().trim());
 
            for (int j = 0; j <= n + 1; j++) board[0][j] = -1;
            for (int i = 1; i <= n; i++) {
                board[i][0] = -1;
                String[] line = br.readLine().split("");
                for (int j = 1; j <= n; j++) {
                    board[i][j] = Integer.parseInt(line[j-1]);
                }
                board[i][n + 1] = -1;
            }
            for (int j = 0; j <= n + 1; j++) board[n + 1][j] = -1;
 
            PriorityQueue<Point> pq = new PriorityQueue<>();
            pq.add(new Point(1, 1, board[1][1]));
 
            while (!pq.isEmpty()) {
                Point p = pq.poll();
                board[p.y][p.x] = -1;
                if (p.y == n && p.x == n) {
                    ret = p.t;
                    break;
                }
                if (board[p.y + 1][p.x] != -1)
                    pq.add(new Point(p.y + 1, p.x, p.t + board[p.y + 1][p.x]));
                if (board[p.y - 1][p.x] != -1)
                    pq.add(new Point(p.y - 1, p.x, p.t + board[p.y - 1][p.x]));
                if (board[p.y][p.x + 1] != -1)
                    pq.add(new Point(p.y, p.x + 1, p.t + board[p.y][p.x + 1]));
                if (board[p.y][p.x - 1] != -1)
                    pq.add(new Point(p.y, p.x - 1, p.t + board[p.y][p.x - 1]));
            }
            bw.write("#" + test_case + " " + ret + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
