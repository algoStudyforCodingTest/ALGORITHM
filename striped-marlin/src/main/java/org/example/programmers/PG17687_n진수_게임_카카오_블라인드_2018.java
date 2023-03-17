package org.example.programmers;

public class PG17687_n진수_게임_카카오_블라인드_2018 {
    public static String solution(int n, int t, int m, int p) {
        //게임 진짜.....
        int number = 0;
        int tmp = 0;
        StringBuilder sb = new StringBuilder();
        while (tmp < t * m + p) {
            String str = conversion(number, n);
            sb.append(str);
            tmp += str.length();
            number++;
        }
        String total = sb.toString();

        sb = new StringBuilder();
        for(int i = 0; i<t; i++) {
            sb.append(total.charAt(i * m + (p-1)));
        }


        System.out.println(sb.toString());
        return sb.toString();

    }
    public static String conversion(int number, int N) {
        StringBuilder sb = new StringBuilder();
        int current = number;

        if(number == 0){
            return "0";
        }

        while (current > 0) {
            if(current%N < 10) {
                sb.append(current%N);
            } else {
                sb.append((char)(current % N - 10 + 'A'));
//                Integer.toString()
            }
            current /= N;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(2,4,2,1));
    }
}
