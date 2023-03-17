package org.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2251 {
    static int A;
    static int B;
    static int C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        Integer[] water = new Integer[5];
        Arrays.fill(water, 0);
        water[2] = C;

        Boolean[][][] visited = new Boolean[A+1][B+1][C+1];
        for(int i = 0; i<=A; i++) {
            for(int j = 0; j<=B; j++) {
                Arrays.fill(visited[i][j], false);
            }
        }
        visited[0][0][C-1] = true;


        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(water);

        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {


            Integer[] w = queue.poll();

            int a = w[0];
            int b = w[1];
            int c = w[2];

            if(a == 0) {
                if(!list.contains(c)) {
                    list.add(c);
                }
            }

            int ta; int tb; int tc;
            // a -> b
            if(a != 0) {
                ta =a; tb = b; tc = c;
                tb = a + b;
                if(tb > B) {
                    ta = a + b - B;
                    tb = B;
                } else {
                    ta = 0;
                }
                if(!visited[ta][tb][tc]) {
                    visited[ta][tb][tc] = true;
                    queue.add(new Integer[]{ta, tb, tc});
                }
            }
            // a -> c
            if(a != 0) {
                ta =a; tb = b; tc = c;
                tc = a + c;
                if(tc > C) {
                    ta = a + c - C;
                    tc = C;
                } else {
                    ta = 0;
                }
                if(!visited[ta][tb][tc]) {
                    visited[ta][tb][tc] = true;
                    queue.add(new Integer[]{ta, tb, tc});
                }
            }
            //b->a
            if(b != 0) {
                ta =a; tb = b; tc = c;
                ta = b + a;
                if(ta > A) {
                    tb = a + b - A;
                    ta = A;
                } else {
                    tb = 0;
                }
                if(!visited[ta][tb][tc]) {
                    visited[ta][tb][tc] = true;
                    queue.add(new Integer[]{ta, tb, tc});
                }
            }
            //b->c
            if(b != 0) {
                ta =a; tb = b; tc = c;
                tc = b + c;
                if(tc > C) {
                    tb = c + b - C;
                    tc = C;
                } else {
                    tb = 0;
                }
                if(!visited[ta][tb][tc]) {
                    visited[ta][tb][tc] = true;
                    queue.add(new Integer[]{ta, tb, tc});
                }
            }
            //c->a
            if(c != 0) {
                ta =a; tb = b; tc = c;
                ta = a + c;
                if(ta > A) {
                    tc = c + a - A;
                    ta = A;
                } else {
                    tc = 0;
                }
                if(!visited[ta][tb][tc]) {
                    visited[ta][tb][tc] = true;
                    queue.add(new Integer[]{ta, tb, tc});
                }
            }
            //c->b
            if(c != 0) {
                ta =a; tb = b; tc = c;
                tb = b + c;
                if(tb > B) {
                    tc = c + b - B;
                    tb = B;
                } else {
                    tc = 0;
                }
                if(!visited[ta][tb][tc]) {
                    visited[ta][tb][tc] = true;
                    queue.add(new Integer[]{ta, tb, tc});
                }
            }
        }
        list.sort(Comparator.naturalOrder());
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }

    }


}
