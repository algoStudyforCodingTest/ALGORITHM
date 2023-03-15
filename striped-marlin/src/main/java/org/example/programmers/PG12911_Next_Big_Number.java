package org.example.programmers;

public class PG12911_Next_Big_Number {
    public static int solution(int n) {
        String binaryNumber = Integer.toBinaryString(n);
        char[] chars = binaryNumber.toCharArray();

        int oneCount = 0;

        for (char aChar : chars) {
            if(aChar == '1') {
                oneCount++;
            }
        }

        int bigOneCount = 0;
        do {
            n+=1;
            String bigBinaryNumber = Integer.toBinaryString(n);
            char[] bigChar = bigBinaryNumber.toCharArray();
            bigOneCount = 0;

            for(char aChar : bigChar) {
                if(aChar == '1') {
                    bigOneCount++;
                }
            }
        } while (oneCount != bigOneCount);

        return n;
    }

    public static int solution2(int n) {
        int postPattern = n & -n;
        int smallPattern = ((n ^ (n + postPattern)) / postPattern) >> 2;
        return n + postPattern | smallPattern;
    }

    public static void main(String[] args) {
        int n = 78;
        System.out.println(solution(n));

        n = 15;
        System.out.println(solution2(n));
    }
}
