package grammar;

import java.util.Arrays;
import java.util.Collections;

public class Array {
    public static void main(String[] args) throws Exception {
        Array_MaxMin();
        Array_Sort();
    }

    public static void Array_MaxMin(){
        System.err.println("Array_MaxMin");
        int[] array = {5,22,51,31,12};

        Integer max = Arrays.stream(array).max().getAsInt();
        Integer min = Arrays.stream(array).min().getAsInt();

        System.err.println("max = "+max);
        System.err.println("min = "+min);
    }

    public static void Array_Sort(){
        System.err.println("Array_Sort");
        int[] array = {5,22,51,31,12};
        Arrays.sort(array); // int 정방향

        for(int i:array){
            System.err.println(i);
        }
        System.err.println();
        Integer[] array2 = Arrays.stream(array).boxed().toArray(Integer[]::new);
        Arrays.sort(array2, Collections.reverseOrder()); //int 역방향

        for(int i:array2){
            System.err.println(i);
        }

        String[] strArr = {"aaa","bbb","ccc"};
        Arrays.sort(strArr); //String 정방향

        for(String i:strArr){
            System.err.println(i);
        }
        System.err.println();
        Arrays.sort(strArr, Collections.reverseOrder()); //String 역방향

        for(String i:strArr){
            System.err.println(i);
        }

        char[] charArr = {'a','b','c'};
        Arrays.sort(charArr); //char 정방향

        for(char i:charArr){
            System.err.println(i);
        }
        System.err.println();
        StringBuilder sb = new StringBuilder(String.valueOf(charArr));
        
        sb.reverse();

        for(char i:charArr){
            System.err.println(i);
        }
    }

}

