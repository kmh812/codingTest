package grammar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Convert_Int {
    public static void main(String[] args) throws Exception {
        IntToString();
        IntToChar();
        IntToLong();
        IntToDouble();      
        IntArrToIntList();
        IntListToIntArr();
        IntArrToIntegerArr();
        IntegerArrToIntArr();
    }

    public static void IntToString(){
        System.err.println("IntToString");
        int n=1;
        String s = Integer.toString(n);
        System.err.println(s);

        Integer in =12;
        String s2 = Integer.toString(in);
        System.err.println(s2);
    }

    public static void IntToChar(){
        System.err.println("IntToChar");
        int n=1;
        char c = Character.forDigit(n,10);
        System.err.println(c);
    }

    public static void IntToLong(){
        System.err.println("IntToLong");
        int n=1000000000;
        long l = new Long(n);
        System.err.println(l);

        long l2 = (long)n;
        System.err.println(l2);
    }

    public static void IntToDouble(){
        System.err.println("IntToDouble");
        int n=1000000000;
        double d = new Double(n);
        System.err.println(d);

        double d2 = (double)n;
        System.err.println(d2);
    }

    public static void IntArrToIntList(){
        System.err.println("IntArrToIntList");
        //1. stram이용
        int[] i = {1,2,3,4};
        List<Integer> il = Arrays.stream(i).boxed().collect(Collectors.toList());
        for(int n:il){
            System.err.println(n);
        }

        //2. for문이용
        List<Integer> il2 = new ArrayList<>();
        for(int n:il2){
            System.err.println(n);
        }
    }

    public static void IntListToIntArr(){
        System.err.println("IntListToIntArr");
        List<Integer> il = Arrays.asList(1,2,3,4);
        int[] iArr = il.stream().mapToInt(Integer::intValue).toArray();

        for(int i:iArr){
            System.err.println(i);
        }
    }

    public static void IntArrToIntegerArr(){
        System.err.println("IntArrToIntegerArr");
        int[] topping = {1,2,1,3,1,4,1,2};
        
        Integer[] temp1ArrInteger = Arrays.stream(topping).boxed().toArray(Integer[]::new); 
		
        for(int i:temp1ArrInteger){
            System.err.println(i);
        }
    }

    public static void IntegerArrToIntArr(){
        System.err.println("IntegerArrToIntArr");
        Integer[] topping = {1,2,1,3,1,4,1,2};
        
        int[] temp1ArrInteger = Arrays.stream(topping).mapToInt(Integer::intValue).toArray();
		
        for(int i:temp1ArrInteger){
            System.err.println(i);
        }
    }
    
    
}

