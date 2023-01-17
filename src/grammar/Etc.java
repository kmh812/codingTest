package grammar;

import java.math.BigInteger;

public class Etc {
    public static void main(String[] args) throws Exception {
        BigInteger(); //진수변환
        SubString(); //문자열 자르기
        Math_abs(); //절대값
        isPrime(); //소수 구하기
    }

    public static void BigInteger(){
        String tmp1 ="101";
		String tmp2 ="11";
		
        //String 2진수 변환
		BigInteger A_binary = new BigInteger(tmp1, 2);
		BigInteger B_binary = new BigInteger(tmp2, 2);

        //2진수 더하기
        BigInteger sum = A_binary.add(B_binary);
		

        //2진수 String 변환
		String sum_binary = sum.toString(2);
		System.err.println(sum_binary);

        int a = 25;

        System.err.println("10진수 -> 2진수");
        System.err.println(Integer.toBinaryString(a));
        System.err.println(Integer.toString(a,2));

        System.err.println("10진수 -> 3진수");
        System.err.println(Integer.toString(a,3));

        String aa = "110011";

        System.err.println("2진수 -> 10진수");
        System.err.println(Integer.parseInt(aa,3));

        System.err.println("3진수 -> 10진수");
        System.err.println(Integer.parseInt(aa,3));

        System.err.println("4진수 -> 10진수");
        System.err.println(Integer.parseInt(aa,4));
    }

    public static void SubString(){
        String str ="abcd";
		
        System.err.println(str.substring(0));
        System.err.println(str.substring(0,1));
        System.err.println(str.substring(1,2));
        System.err.println(str.substring(1,4));
    }

    public static void Math_abs(){
        int temp = -11;
        Math.abs(temp);
        System.err.println(Math.abs(temp));
    }

    public static boolean isPrime() {
        
        int temp =10;
        boolean isPrime = false;
        if(temp == 1){
            isPrime = true;
        }else{
            for (int i = 2; i < temp; i++) {
                // 1과 num 자신 외에 나누어지는 수가 있는지 검사할 조건문
                if (temp % i == 0) {
                    // 나누어지는 수가 있을 경우 isPrime의 값을 true로 바꾼다.
                    isPrime = true;
                    // 한 번이라도 이 조건문이 실행될 경우 num은 소수가 아니므로 반복문을 빠져나온다.
                    break;
                }
            }
        }
        
        return isPrime;
    }

}

