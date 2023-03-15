package org.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2696 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcase = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < testcase; tc++) {
            int number = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] arr = new int[number];
            for(int i = 0; i<number; i++) {
                if(!st.hasMoreElements()) {
                    st = new StringTokenizer(br.readLine());
                }
                arr[i] = Integer.parseInt(st.nextToken());
            }
            System.out.println(number/2 + 1);
            StringBuilder sb = new StringBuilder();
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            int count = 0;
            for(int i = 0; i<number; i++) {
                queue.add(arr[i]);
                if((i+1)%2 == 1) {

                    int mid = i/2;
                    Queue<Integer> queue1 = new LinkedList<>();
                    for(int k = 0; k<mid; k++) {
                        queue1.add(queue.poll());
                    }
                    count++;
                    sb.append(queue.peek()).append(" ");
                    if(count >= 10 && count % 10 == 0) {
                        sb.append("\n");
                    }
                    while (!queue1.isEmpty()) {
                        queue.add(queue1.poll());
                    }
                }
            }


            System.out.println(sb);
        }
    }
}
