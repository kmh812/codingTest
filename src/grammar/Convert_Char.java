package grammar;

public class Convert_Char {
    public static void main(String[] args) throws Exception {
        CharToInt();
        CharArrToString();
    }

    public static void CharToInt(){
        char c = '2';
        int i = Character.getNumericValue(c);
        System.err.println(i);

    }

    public static void CharArrToString(){
        char[] c = {'a','b'};
        String s = new String(c);
        System.err.println(s);
    }

}

