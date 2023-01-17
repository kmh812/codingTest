package grammar.Algorithms;

import java.util.Arrays;

public class Permutation {

    static int n; // 원소 개수
    static int[] numbers; // 순열을 저장할 배열
    static boolean[] isSelected; // 뽑았는지 여부를 저장할 배열
    static int count; // 순열 개수

    public static void main(String[] args) throws Exception {
        //모든수를 순서를 다르게 하여 비교 한다.
        n = 5;
        numbers = new int[n];
        isSelected = new boolean[n+1];
        Permutation(0);
        System.out.println("순열의 개수: " + count);
    }

    public static void Permutation(int k) {
        // base condition
        if(k == n) {
            count++;
            System.out.println(Arrays.toString(numbers));
            return;
        }

        for(int i = 1; i <= n; i++) {
            if (isSelected[i]) continue; // 중복 검사

            // 중복이 아니라면
            numbers[k] = i;
            isSelected[i] = true;
            Permutation(k + 1); // 다음 요소 뽑기
            isSelected[i] = false;
        }
    }
}
