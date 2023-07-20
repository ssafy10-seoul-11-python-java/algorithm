import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
  
class Solution {
  
    private static char[][] board = new char[302][302];
  
    private static void dfs(int r, int c) {
        if (board[r][c] == '.') {
            board[r][c] = 'C';
            for (int off_r = -1; off_r <= 1; off_r++)
                for (int off_c = -1; off_c <= 1; off_c++)
                    dfs(r + off_r, c + off_c);
        } else if (board[r][c] == '1') {
            board[r][c] = 'C';
        }
    }
  
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  
        int T = Integer.parseInt(br.readLine());
  
        for (int test_case = 1; test_case <= T; test_case++) {
            int n;
            int click = 0;
            n = Integer.parseInt(br.readLine());
  
            for (int j = 0; j <= n + 1; j++)
                board[0][j] = '*';
            for (int i = 1; i <= n; i++) {
                board[i][0] = '*';
                String s = br.readLine();
                for (int j = 1; j <= n; j++)
                    board[i][j] = s.charAt(j-1);
                board[i][n + 1] = '*';
            }
            for (int j = 0; j <= n + 1; j++)
                board[n + 1][j] = '*';
  
            for (int i = 1; i <= n; i++)
                for (int j = 1; j <= n; j++)
                    if (board[i][j] == '*')
                        for (int off_i = -1; off_i <= 1; off_i++)
                            for (int off_j = -1; off_j <= 1; off_j++)
                                if (board[i + off_i][j + off_j] != '*')
                                    board[i + off_i][j + off_j] = '1';
              
            for (int i = 1; i <= n; i++)
                for (int j = 1; j <= n; j++)
                    if (board[i][j] == '.') {
                        dfs(i, j);
                        click++;
                    }
  
            for (int i = 1; i <= n; i++)
                for (int j = 1; j <= n; j++)
                    if (board[i][j] == '1')
                        click++;
  
            bw.write("#" + test_case + " " + click + "\n");
        }
        bw.flush();
        bw.close();
    }
}
