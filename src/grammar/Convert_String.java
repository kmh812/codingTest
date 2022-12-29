package grammar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Convert_String {
    public static void main(String[] args) throws Exception {
        StringToInt();
        StringToCharArr();
        StringArrToStringList();
        StringListToStringArr();
        StringArrToString();
        StringListToString();
    }

    public static void StringToInt(){
        System.err.println("StringToInt");
        String s ="11";
        int i = Integer.parseInt(s);
        System.err.println(i);
    }

    public static void StringToCharArr(){
        System.err.println("StringToCharArr");
        String s ="12";
        char[] cArr = s.toCharArray();
        for(char c:cArr){
            System.err.println(c);
        }
    }

    public static void StringArrToStringList(){
        System.err.println("StringArrToStringList");
        String[] sArr = {"aa","bb","cc"};
        List<String> sList = Stream.of(sArr).collect(Collectors.toList());
        for(String s:sList){
            System.err.println(s);
        }
    }

    public static void StringListToStringArr(){
        System.err.println("StringListToStringArr");
        List<String> sl = Arrays.asList("aa","bb","cc");

        String[] sArr1 = (String[]) sl.toArray();
        String[] sArr2 = sl.stream().toArray(String[]::new);

        for(String s:sArr1){
            System.err.println(s);
        }

        for(String s:sArr2){
            System.err.println(s);
        }
    }

    public static void StringArrToString(){
        System.err.println("StringArrToString");
        String[] strArr = {"aaa","bbb","ccc"};
        String str = String.join("", strArr);
        System.err.println(str);
    }

    public static void StringListToString(){
        System.err.println("StringListToString");
        List<String> strList = Arrays.asList("aaa","bbb","ccc");
        String str = strList.stream().collect(Collectors.joining(""));
        System.err.println(str);
        System.err.println();
        String str2 = String.join("", strList);
        System.err.println(str2);

    }
}

