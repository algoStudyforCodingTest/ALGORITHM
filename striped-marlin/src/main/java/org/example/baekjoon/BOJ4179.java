package org.example.baekjoon;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Queue;
import java.util.*;

public class BOJ4179 {
    public static class Jihun {
        int x;
        int y;

        public Jihun(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = new int[]{1,-1,0,0};
    static int[] dy = new int[]{0,0,1,-1};

    public static class Fire {
        int x;
        int y;

        public Fire(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int r = Integer.parseInt(str[0]);
        int c = Integer.parseInt(str[1]);
        char[][] maps = new char[r][c];
        boolean[][] visited = new boolean[r][c];

        Jihun jihun = new Jihun(0,0);
        Fire fires = new Fire(0,0);
        for(int i = 0; i<r;i++) {
            String tmp = br.readLine();
            for (int j = 0; j<c; j++) {
                maps[i][j] = tmp.charAt(j);
                if(tmp.charAt(j) == 'J') {
                    jihun = new Jihun(i,j);
                    visited[i][j] = true;
                }
                if(tmp.charAt(j) == 'F') {
                    fires = new Fire(i,j);
                }
            }
        }

        char[][] fire = new char[r][c];
        for(int i = 0; i<fire.length; i++) {
            Arrays.fill(fire[i], ' ');
        }
        int[][] count = new int[r][c];
        fire[fires.x][fires.y] = 'F';
        List<Point> points = new ArrayList<>();
        points.add(new Point(fires.x, fires.y));


        int result = bfs(maps, fire, visited, jihun, count, points);

        if(result == -1) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(result);
        }

    }

    public static int bfs(char[][] maps, char[][] fire, boolean[][] visited, Jihun jihun, int[][] count, List<Point> points) {
        Queue<Jihun> queue = new LinkedList<>();
        queue.offer(jihun);

        int result = 0;
        int max = 0;

        outer:
        while (!queue.isEmpty()) {
            Jihun j1 = queue.peek();
            if((j1.x == 0 || j1.x == maps.length-1) ||
                    (j1.y == 0 || j1.y == maps[0].length-1)) {
                result = count[j1.x][j1.y] + 1;
                break;
            }
            Jihun j = queue.poll();
            int jx = j.x; int jy = j.y;

            if(count[jx][jy] >= max) {
                List<Point> lists = new ArrayList<>();
                for(int i = 0; i<points.size(); i++) {
                    int x = points.get(i).x;
                    int y = points.get(i).y;
                    for(int k = 0; k< dx.length; k++) {
                        int tx = x + dx[k]; int ty = y + dy[k];
                        if(tx >= 0 && tx < fire.length && ty >= 0 && ty < fire[0].length) {
                            lists.add(new Point(tx, ty));
                        }
                    }
                }
                points.addAll(lists);

                for(int i = 0; i<points.size(); i++) {
                    int x = points.get(i).x;
                    int y = points.get(i).y;

                    if(fire[x][y] != 'F') {
                        fire[x][y] = 'F';
                    }
                }
            }

            for(int i = 0; i<dx.length; i++) {
                int tx = jx + dx[i]; int ty = jy + dy[i];
                if(tx >= 0 && tx < maps.length
                        && ty >=0 && ty < maps[0].length) {
                    if(fire[tx][ty] != 'F'
                            && maps[tx][ty] == '.'
                            && !visited[tx][ty]) {
                        visited[tx][ty] = true;
                        count[tx][ty] = count[jx][jy] + 1;
                        if(max < count[tx][ty]) {
                            max = count[tx][ty];
                        }
                        queue.offer(new Jihun(tx, ty));
                    }

                }


            }
        }
        if(queue.isEmpty()) {
            return -1;
        } else {
            return result;
        }
    }
}
