package org.example.PCCE;

public class 홀짝에따라다른값반환 {
    public int solution(int n) {
        int result = 0;

        if (n % 2 != 0) {
            for (int i = 1; i <= n; i += 2) {
                result += i;
            }
        } else {
            for (int i = 2; i <= n; i += 2) {
                result += i * i;
            }
        }

        return result;
    }
}
