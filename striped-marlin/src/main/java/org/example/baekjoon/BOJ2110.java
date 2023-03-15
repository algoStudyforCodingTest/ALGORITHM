package org.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        list.sort(Comparator.naturalOrder());

        int start = 1;
        int end = list.get(list.size()-1) - list.get(0)+1;

        int mid;
        while (start < end) {
            mid = (start + end) / 2;

            int home_start = list.get(0);
            int count = 1;
            for(int j = 1; j<list.size(); j++) {
                if(list.get(j) >= home_start + mid) {
                    home_start = list.get(j);
                    count++;
                }
            } if(count < C) {
                end = mid;
            } else {
                start = mid+1;
            }
        }
        System.out.println(start-1);
    }
}
