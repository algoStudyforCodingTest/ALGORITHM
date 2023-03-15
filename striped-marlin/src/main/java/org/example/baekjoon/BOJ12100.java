package org.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ12100 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Integer, Boolean>[][] map = new HashMap[N][N];

        for(int i = 0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++) {
                Map<Integer, Boolean> m = new HashMap<>();
                m.put(Integer.parseInt(st.nextToken()), false);
                map[i][j] = m;
            }
        }
        List<Integer> list1 = new ArrayList<>();
        direction(0, new Integer[5], 0 );
        for(int i = 0; i<list.size(); i++) {
            Integer[] a = list.get(i);
            int m = max(0, map, a);
            list1.add(m);
        }
        list1.sort(Comparator.reverseOrder());
        System.out.println(0);
    }
    static int[] dir = new int[]{0,1,2,3};
    static List<Integer[]> list = new ArrayList<>();
    public static void direction(int count, Integer[] arr, int i) {
        if(count >= 5) {
            list.add(arr);
            return;
        }
        for(int j = 0; j< dir.length; j++){
            arr[i] = dir[j];
            count+=1; i += 1;
            direction(count, arr, i);
        }

    }
    public static int max(int count, Map<Integer, Boolean>[][] arr, Integer[] dir) {
        for(int i = 0; i<dir.length; i++) {
            int d = dir[i];
            count+=1;
            move(arr, d);
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<arr.length; i++) {
            for(int j = 0; j<arr.length; j++) {
                Map<Integer, Boolean> map = arr[i][j];
                List<Integer> list1 = new ArrayList<>(map.keySet());
                if(list1.get(0) > max) {
                    max = list1.get(0);
                }
            }
        } return max;
    }

    public static Map<Integer, Boolean>[][] move(Map<Integer, Boolean>[][] arr, int dir) {
        if(dir == 0) {
            for(int i = 0; i<arr.length-1; i++) {
                for(int j = 0; j < arr.length; j++) {
                    Map<Integer,Boolean> m = arr[i][j];
                    List<Integer> l = new ArrayList<>(m.keySet());
                    int num = l.get(0);

                    if(m.get(num)) {
                        continue;
                    }

                    Map<Integer,Boolean> m1 = arr[i+1][j];
                    List<Integer> l1 = new ArrayList<>(m1.keySet());
                    int num1 = l1.get(0);

                    if(num != 0) {
                        num += num1;
                        m.clear();
                        m.put(num, true);
                        arr[i][j] = m;
                        m1.clear();
                        m1.put(0, false);
                        arr[i+1][j] = m1;
                    }
                }
            }

        }
        else if(dir == 1) {
            for(int i = 0; i<arr.length; i++) {
                for(int j = 0; j < arr.length-1; j++) {
                    Map<Integer,Boolean> m = arr[i][j];
                    List<Integer> l = new ArrayList<>(m.keySet());
                    int num = l.get(0);

                    if(m.get(num)) {
                        continue;
                    }

                    Map<Integer,Boolean> m1 = arr[i][j+1];
                    List<Integer> l1 = new ArrayList<>(m1.keySet());
                    int num1 = l1.get(0);

                    if(num != 0) {
                        num += num1;
                        m.clear();
                        m.put(num, true);
                        arr[i][j] = m;
                        m1.clear();
                        m1.put(0, false);
                        arr[i][j+1] = m1;
                    }
                }
            }

        }else if(dir == 2) {
            for(int i = arr.length-1; i>0; i--) {
                for(int j = arr.length; j >= 0; j--) {
                    Map<Integer,Boolean> m = arr[i][j];
                    List<Integer> l = new ArrayList<>(m.keySet());
                    int num = l.get(0);

                    if(m.get(num)) {
                        continue;
                    }

                    Map<Integer,Boolean> m1 = arr[i-1][j];
                    List<Integer> l1 = new ArrayList<>(m1.keySet());
                    int num1 = l1.get(0);

                    if(num != 0) {
                        num += num1;
                        m.clear();
                        m.put(num, true);
                        arr[i][j] = m;
                        m1.clear();
                        m1.put(0, false);
                        arr[i-1][j] = m1;
                    }
                }
            }

        }else {
            for(int i = arr.length-1; i>=0; i--) {
                for(int j = arr.length-1; j >0; j--) {
                    Map<Integer,Boolean> m = arr[i][j];
                    List<Integer> l = new ArrayList<>(m.keySet());
                    int num = l.get(0);

                    if(m.get(num)) {
                        continue;
                    }

                    Map<Integer,Boolean> m1 = arr[i][j-1];
                    List<Integer> l1 = new ArrayList<>(m1.keySet());
                    int num1 = l1.get(0);

                    if(num != 0) {
                        num += num1;
                        m.clear();
                        m.put(num, true);
                        arr[i][j] = m;
                        m1.clear();
                        m1.put(0, false);
                        arr[i][j-1] = m1;
                    }
                }
            }

        }
        return arr;
    }
}
