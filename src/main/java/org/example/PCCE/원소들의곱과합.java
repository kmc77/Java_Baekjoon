package org.example.PCCE;

public class 원소들의곱과합 {
    public int solution(int[] num_list) {
        int sum = 0;
        int multiply = 1;

        for (int i = 0; i < num_list.length; i++) {
            sum += num_list[i];
            multiply *= num_list[i];
        }

        if (multiply < sum * sum) {
            return 1;
        } else {
            return 0;
        }
    }
}