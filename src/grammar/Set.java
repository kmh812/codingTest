package grammar;

import java.util.Iterator;
import java.util.HashSet;


public class Set {
    public static void main(String[] args) throws Exception {
        //객체(데이터)를 중복해서 저장할 수 없다.
        //기본은 저장 순서가 보장되지 않는다.
        //HashSet, TreeSet, LinkedHashSet
        HashSet();
        TreeSet();
        LinkedHashSet();
    }

    public static void HashSet(){
        //데이터를 중복 저장할 수 없고 순서를 보장하지 않는다.
        String str ="people";
		char[] strArr = str.toCharArray();
		HashSet<Character> hs = new HashSet<>();
		
        for(char c:strArr) {
			hs.add(c);
		}
        
		// set -> array
		System.err.println(hs.toArray());
		
		Iterator<Character> iterator = hs.iterator();
		while(iterator.hasNext()){
			System.err.println(iterator.next());
		}
    }

    public static void TreeSet(){
        //중복된 데이터를 저장할 수 없고 기본적으로 오름차순으로 데이터를 정렬
    }

    public static void LinkedHashSet(){
        //중복된 데이터를 저장할 수 없다. 차이점은 입력된 순서대로 데이터를 관리
    }

}

