package org.example.b1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11720_숫자의합 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 첫 번째 줄의 숫자 N 읽기
        String sNum = br.readLine(); // 다음 줄에 있는 숫자 문자열 읽기

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += sNum.charAt(i) - '0'; // 각 숫자를 더하기
        }

        System.out.println(sum);
    }
}
