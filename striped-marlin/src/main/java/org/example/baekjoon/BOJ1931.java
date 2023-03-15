package org.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcase = Integer.parseInt(br.readLine());
        List<List<Long>> meetings = new ArrayList<>();
        for(int i = 0; i< testcase; i++) {
            List<Long> time = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            time.add(Long.parseLong(st.nextToken()));
            time.add(Long.parseLong(st.nextToken()));

            meetings.add(time);
        }
        long count = 0;
        long start = 0;
        long end = 0;
        long size = 0;
        int i = 0;
        long tmpStart = -1;
        long tmpEnd = -1;
        meetings = meetings.stream()
                .sorted((o1, o2) ->  {
                    if(o1.get(1) == o2.get(1)) {
                        return (int) (o1.get(0) - o2.get(0));
                    } return (int) (o1.get(1) - o2.get(1));
                }).collect(Collectors.toList());
        while (tmpEnd != end && tmpStart != end) {

            tmpStart = start;
            tmpEnd = end;


            size = meetings.size();
            for (; i< meetings.size(); i++) {
                if (meetings.get(i).get(1) >= end && meetings.get(i).get(0) >= end) {
                    if(end > 0) {
                        if((meetings.get(i).get(0) > start && meetings.get(i).get(0) < end) && (meetings.get(i).get(1) > start && meetings.get(i).get(1) < end)) {
                            start = meetings.get(i).get(0);
                            end = meetings.get(i).get(1);
                            continue;
                        }

                    }

                    start = meetings.get(i).get(0);
                    end = meetings.get(i).get(1);

                    count++; i++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
