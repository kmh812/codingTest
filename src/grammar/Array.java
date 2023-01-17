package grammar;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

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

        // 다중 조건 
        int[][] arr2 = new int[][]{{5,40},{3,50},{1,30},{4,20},{2,10},{6,40},{6,50},{6,10},{6,20},{6,30}};

        Arrays.sort(arr2, new Comparator<int[]>() { 
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]!=o2[0] ? o1[0]-o2[0] : o1[1]-o2[1]; // 첫번째 기준 오름차순 > 두번째 기준 오름차순  : {1,30}{2,10}{3,50}{4,20}{5,40}{6,10}{6,20}{6,30}{6,40}{6,50}
                //return o1[0]!=o2[0] ? o1[0]-o2[0] : o2[1]-o1[1]; // 첫번째 기준 오름차순 > 두번째 기준 내림차순  : {1,30}{2,10}{3,50}{4,20}{5,40}{6,50}{6,40}{6,30}{6,20}{6,10}
            }
        });

        Arrays.sort(arr2 , (o1,o2) -> {
			return o1[0]!=o2[0] ? o1[0]-o2[0] : o1[1]-o2[1]; // 첫번째 기준 오름차순 > 두번째 기준 오름차순  : {1,30}{2,10}{3,50}{4,20}{5,40}{6,10}{6,20}{6,30}{6,40}{6,50}
                //return o1[0]!=o2[0] ? o1[0]-o2[0] : o2[1]-o1[1]; // 첫번째 기준 오름차순 > 두번째 기준 내림차순  : {1,30}{2,10}{3,50}{4,20}{5,40}{6,50}{6,40}{6,30}{6,20}{6,10}
		});
    }

}

