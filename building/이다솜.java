import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//  제출은 1-2
public class Building {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 }; // 상부터 시계방향으로
		int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			char[][] buldings = new char[N][];

			for (int i = 0; i < N; i++) {
				buldings[i] = br.readLine().toCharArray();
			}
			int ans =0 ;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int nowBuilding = 2;
					if (buldings[i][j] == 'B') {
						// 빌딩인경우 , 주변에 G가 없는지 탐색
						int nr, nc;
						boolean isGreen = false;
						for (int k = 0; k < 8; k++) {
							nr = i + dr[k];
							nc = j + dc[k];
							if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
								if(buldings[nr][nc] == 'G' ) {
									isGreen = true;
									break;
								}
							}
						}
						// 주변 탐색 이후 -> 주변에 녹지 있는지 확인 완료
						if(!isGreen) {
							nowBuilding = -1;
							
							for(int r=0; r<N; r++) {
								if(buldings[i][r] == 'B') nowBuilding +=1;		
							}
							for(int r=0; r<N; r++) {
								if(buldings[r][j] == 'B') nowBuilding +=1;		
							}
							
							if(nowBuilding >= ans) ans = nowBuilding;
						}
					} 

				}
			}
			System.out.println("#"+tc+" "+ ans);
		}

	}
}
