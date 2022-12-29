package grammar;

public class StringBuilder_Util {
    public static void main(String[] args) throws Exception {
        StringBuilder_add();
        StringBuilder_sort();
    }

    public static void StringBuilder_add(){
        System.err.println("StringBuilder_add");
        String str1= "aaasfasdf";
        String str2= "aaasfasdf";
        
        StringBuffer sb = new StringBuffer();
        sb.append(str1);
        sb.append(str2);

        System.err.println(sb);
    }

    public static void StringBuilder_sort(){
        System.err.println("StringBuilder_sort");
        String str1= "aaasfasdf";
        
        
        StringBuilder sb = new StringBuilder(str1);
        
        sb.reverse();
        System.err.println(sb);
    }

}

