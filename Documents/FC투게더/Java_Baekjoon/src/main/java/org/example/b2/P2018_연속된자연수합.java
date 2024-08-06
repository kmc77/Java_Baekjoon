package org.example.b2;

import java.util.Scanner;

public class P2018_연속된자연수합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 1; // N 자체를 하나의 경우로 카운트
        int sum = 1; // 초기 합
        int start_index = 1; // 시작 인덱스
        int end_index = 1; // 끝 인덱스

        while (end_index != N) {
            if(sum == N) {
                count++; end_index++; sum += end_index;
            } else if (sum > N) {
                sum -= start_index; start_index++;
            } else {
                end_index++; sum += end_index;
            }
        }
        System.out.println(count);
    }
}
