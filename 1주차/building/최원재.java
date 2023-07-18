package com.ssafy.ws.step3;

import java.util.Scanner;
public class BuildingTest {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		for(int tc = 1; tc <= c; tc++) {
			int n = sc.nextInt();
			char arr[][] = new char[n][n];
			for(int i = 0; i<n;i++) {
				for(int j = 0; j < n; j++) {
					arr[i][j] = sc.next().charAt(0);
				}
			}
			int max_v = 0;
			
			int dr[] = {-1, -1,-1, 0, 0, 1, 1, 1};
			int dc[] = {-1, 0, 1,-1, 1, -1, 0, 1};
			
			for(int i = 0; i<n;i++) {
				label: for(int j = 0; j < n; j++) {
					int num = -1;
					int nr, nc;  
					for (int k = 0; k < 8; k++) {
						nr = i+dr[k];
						nc = j+dc[k];
						if(nr<0 || nr >= n || nc < 0 || nc >= n) continue;
						if(arr[nr][nc] == 'G') {
							if(max_v < 2) max_v = 2;
							continue label;
						}
					}
					for(int  k = 0; k < n; k++) {
						if(arr[i][k] == 'B') num++;
						if(arr[k][j] == 'B') num++;
					}
					if(num > max_v) max_v = num;
				}
			}
			System.out.println("#" + tc + " " + max_v);
		}
	}
}