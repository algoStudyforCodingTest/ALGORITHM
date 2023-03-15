package org.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2630 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] paper = new int[n][n];

        for(int i = 0; i<n; i++) {
            String[] arr= br.readLine().split(" ");
            for(int j = 0; j < arr.length; j++) {
                paper[i][j] = Integer.parseInt(arr[j]);
            }
        }
        cut(n, 0, 0, paper);

        System.out.println(white);
        System.out.println(blue);


    }

    static int white = 0;
    static int blue = 0;

    public static void cut(int n, int x, int y, int[][] paper) {
        if(n == 1) {
            if(paper[x][y] == 1) {
                blue++;
            }
            if(paper[x][y] == 0) {
                white++;
            }
            return;
        }

        int wCount = 0;
        int bCount = 0;

        for(int i = x; i<x + n; i++) {
            for(int j = y; j<y + n; j++) {
                if(paper[i][j] == 0) {
                    wCount++;
                }
                if(paper[i][j] == 1) {
                    bCount++;
                }

            }
        }
        if (wCount == Math.pow(n,2) && bCount == 0) {
            white++;
            return;
        } if(bCount == Math.pow(n,2) && wCount == 0) {
            blue++;
            return;
        }

        cut(n/2, x,y,paper);
        cut(n/2, x+n/2, y, paper);
        cut(n/2, x, y+n/2, paper);
        cut(n/2, x + n/2, y+n/2, paper);

    }
}
