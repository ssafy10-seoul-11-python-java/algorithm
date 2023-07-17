import java.io.*;
 
 
class Solution
{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static long[][] dp;
    private static String s;
    private static void solve(int idx){
        for(int i = 1; i < 16; i++)
            for(int j = 1; j < 16; j++)
                if((i&j) != 0 && (i & (1 << (s.charAt(idx)-'A'))) != 0){
                    dp[idx+1][i] %= 1000000007;
                    dp[idx+1][i] += dp[idx][j];
                }
    }
     
    public static void main(String args[]) throws Exception
    {
 
        int T = Integer.parseInt(br.readLine().trim());
 
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            s = br.readLine();
            dp = new long[s.length()+1][];
            for(int i = 0; i < s.length()+1; i++) dp[i] = new long[16];
            dp[0][1] = 1;
            for(int i = 0; i < s.length(); i++) solve(i);
            long ret = 0;
            for(int i = 1; i < 16; i++) ret += dp[s.length()][i];
            bw.write("#"+test_case+" "+ret%1000000007 + "\n");
 
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
