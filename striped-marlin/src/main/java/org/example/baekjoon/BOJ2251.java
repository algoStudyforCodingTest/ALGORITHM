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

        int[] bucket = new int[3];
        bucket[0] = A;
        bucket[1] = B;
        bucket[2] = C;

        Boolean[] visited = new Boolean[3];
        Arrays.fill(visited, false);

        Map<Integer[], Boolean[]> map = new HashMap<>();
        map.put(water, visited);

        Queue<Map<Integer[], Boolean[]>> queue = new LinkedList<>();
        queue.add(map);

        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {


            Map<Integer[], Boolean[]> map1 = queue.poll();
            List<Integer[]> list1 = new ArrayList<>(map1.keySet());
            Integer[] w = list1.get(0);
            Boolean[] visit1 = map1.get(w);

            int a = w[0];
            int b = w[1];
            int c = w[2];

            if(b + a <= B) {
                if(!list.contains(c)) {
                    list.add(c);
                }
            }

            if(a == 0 && w[4] > 0) {
                if(!list.contains(c)) {
                    list.add(c);
                }
            }
            Integer[] copy = new Integer[5];
            for(int i = 0; i<5; i++) {
                copy[i] = w[i];
            }

            Boolean[] copyVisit = new Boolean[3];
            for(int i = 0; i<3; i++) {
                copyVisit[i] = visit1[i];
            }

            for(int i = 0; i<3; i++) {
                for(int j = 0; j<3; j++) {
                    if(i == j) continue;
                    if(w[i] > 0 &&  !visit1[j]) {
                        w[j] += w[i];
                        if(w[j] > bucket[j]) {
                            w[i] = w[j] - bucket[j];
                            w[j] = bucket[j];
                        } else {
                            w[i] = 0;
                        }
                        visit1[j] = true;
                        w[4] += 1;
                        Integer[] tmp = new Integer[5];
                        for(int k = 0; k<5; k++) {
                            tmp[k] = w[k];
                        }
                        Boolean[] visitTmp = new Boolean[3];
                        for(int k = 0; k<3; k++) {
                            visitTmp[k] = visit1[k];
                        }
                        Map<Integer[], Boolean[]> map2 = new HashMap<>();
                        map2.put(tmp, visitTmp);
                        queue.add(map2);
                        for(int k = 0; k<5; k++) {
                            w[k] = copy[k];
                        }
                        for(int k = 0; k<3; k++) {
                            visit1[k] = copyVisit[k];
                        }
                    }
                }
            }
        }
        list.sort(Comparator.naturalOrder());
        for(int i = 0; i<list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

    }


}
