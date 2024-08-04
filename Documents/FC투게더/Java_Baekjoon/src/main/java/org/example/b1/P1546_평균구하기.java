package org.example.b1;

import java.util.Scanner;

public class P1546_평균구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 입력된 과목의 개수

        long sum = 0; // 점수 합계
        long max = 0; // 최대 점수

        for (int i = 0; i < N; i++) {
            int temp = sc.nextInt();
            if(temp>max) max = temp;
            sum = sum + temp;
        }

        // 평균 계산 후 출력
        System.out.println(sum * 100.0 / max / N);
    }
}
