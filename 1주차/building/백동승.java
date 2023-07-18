package java_homework;

import java.io.*;

class Solution
{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    
    public static void main(String args[]) throws Exception
    {
 
        int T = Integer.parseInt(br.readLine().trim());
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	int ret = 2;
        	
        	int n = Integer.parseInt(br.readLine().trim());
        	String[] map = new String[n];
        	boolean[][] nextToG = new boolean[n+2][n+2];
        	int[] r_cnt = new int[n+1];
        	int[] c_cnt = new int[n+1];
        	for(int i = 0; i < n; i++) {
        		map[i] = br.readLine();
        		for(int j = 0; j < n; j++) {
        			if(map[i].charAt(2*j)=='G') {
        				for(int dr = -1; dr <= 1; dr++)
        					for(int dc = -1; dc <= 1; dc++)
        						nextToG[i+1+dr][j+1+dc] = true;
        			}
        			else {
        				r_cnt[i+1]++;
        				c_cnt[j+1]++;
        			}
        		}
        	}
        	for(int i = 1; i <= n; i++) {
        		for(int j = 1; j <= n; j++) {
        			if(!nextToG[i][j]) {
        				int floor = r_cnt[i] + c_cnt[j] - 1;
        				ret = (floor > ret) ? floor : ret;
        			}
        		}
        	}
        	bw.write("#"+test_case+" "+ret+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
	}
}
