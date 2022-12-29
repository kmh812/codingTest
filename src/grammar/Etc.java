package grammar;

import java.math.BigInteger;

public class Etc {
    public static void main(String[] args) throws Exception {
        BigInteger(); //진수변환
        SubString(); //문자열 자르기
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
		System.out.println(sum_binary);
    }

    public static void SubString(){
        String str ="abcd";
		
        System.err.println(str.substring(0));
        System.err.println(str.substring(0,1));
        System.err.println(str.substring(1,2));
        System.err.println(str.substring(1,4));
    }

}

