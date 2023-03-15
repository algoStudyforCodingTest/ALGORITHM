package org.example.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1520 {
    static int[] dx = new int[]{1,-1,0,0};
    static int[] dy = new int[]{0,0,1,-1};

    static int M;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int[][] map = new int[M][N];
        for(int i = 0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[M][N];

        dfs(map, dp, 0, 0);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(String.valueOf(dfs(map, dp, 0, 0)));
        bw.flush();
        bw.close();


    }
    static int count = 0;
    public static int dfs(int[][] map, int[][] dp, int x, int y) {
        if(x == M-1 && y == N-1) {
            return 1;
        }
        /*
        * else if(dp[x][y] > 0) {
        *
        * count++;
        * return
        * }
        * */
        if(dp[x][y] > 0) {
            count++;
            return dp[x][y];
        }


        for(int i = 0; i<dx.length; i++) {
            int tx = x + dx[i]; int ty = y + dy[i];
            if(tx >=0 && tx < M && ty >=0 && ty < N) {
                if(map[x][y] > map[tx][ty]) {

                    dp[x][y] += dfs(map, dp, tx, ty);
                }
            }
        }
        return dp[x][y];

    }
}
