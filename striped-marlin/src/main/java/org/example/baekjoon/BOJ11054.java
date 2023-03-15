package org.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] A = new int[num];
        int[] A_reverse = new int[num];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<num; i++) {
            int n = Integer.parseInt(st.nextToken());
            A[i] = n;
            A_reverse[num-1 - i] = n;
        }

        int[] dp1 = new int[num];
        int[] dp2 = new int[num];
        for(int i = 0; i<num; i++) {
            dp1[i] = 1;
            dp2[i] = 1;
            for(int j = 0; j<i; j++) {
                if(A[i] > A[j] && dp1[i] < dp1[j] + 1) {
                    dp1[i] = dp1[j] + 1;
                }
                if(A_reverse[i] > A_reverse[j] && dp2[i] < dp2[j] + 1) {
                    dp2[i] = dp2[j] + 1;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
//        System.out.println(Arrays.toString(dp1));
//        System.out.println(Arrays.toString(dp2));

        int[] dp = new int[num];
        for(int i = 0; i<num; i++) {
            dp[i] = dp2[num - i-1];
        }

        for(int i = 0; i<num; i++) {
            int num1 = dp1[i];
            int num2 = dp[i];
            result.add(num1 + num2 - 1);
        }
        result.add(dp1[num-1]);
        result.add(dp2[0]);

        result.sort(Comparator.reverseOrder());

        System.out.println(result.get(0));

    }
}
