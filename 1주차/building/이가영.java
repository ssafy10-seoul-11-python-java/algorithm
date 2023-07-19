package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Building {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		int []dr = {-1,1,0,0,1,-1,1,-1}; //상하좌우
		int []dc = {0,0,-1,1,1,-1,-1,1}; //상하좌우
		int result = 2 ;
		boolean all;
		
		for(int t=0;t<T;++t) {
			int N = Integer.parseInt(in.readLine());
			String[][] arr = new String[N][N];
			for(int i =0;i<N;i++) {
				String[] st = in.readLine().split(" ");
				for(int j=0; j< N; j++) {
					arr[i][j] = st[j];	
				}		
			}
			
			for(int i =0;i<N;i++) {
				for(int j=0; j< N; j++) {
					all = true;
					if(arr[i][j].equals("B")) {
						for(int d=0;d<dr.length;d++) {
							int dri=i+dr[d];
							int drc=j+dc[d];
							if(dri>=0 && dri <N&& drc>=0&& drc <N) {
								if(arr[dri][drc].equals("G")) {
									all = false;
									break;
								}
							}
						}
						
						if(all==true) {
							
							int sum = -1;
							for(int k=0;k<N;k++) {
								if(arr[i][k].equals("B")) {
									sum+=1;
								}
								if(arr[k][j].equals("B")) {
									sum+=1;							
								}
							}
							result = Math.max(sum, result);
						}
					}
					
					
				}		
			}

			System.out.printf("#%d %d",(t+1),result);		
		
		}
	}

}