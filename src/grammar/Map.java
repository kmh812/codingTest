package grammar;

import java.util.stream.*;
import java.util.*;

public class Map {
    public static void main(String[] args) throws Exception {
        //HashMap, LinkedHashMap, Hashtable, TreeMap
        HashMap();
        HashMap_Sort();
    }

    public static void HashMap(){
        System.err.println("HashMap");
        //1. 순서 : 없음
        //2. 키 중복 안됨
        HashMap<Integer, Integer> hm = new HashMap<Integer,Integer>();
        hm.put(1, 1111);
        hm.put(2, 2222);

        //Iterator
        System.err.println("Iterator");
        Iterator<Integer> keys = hm.keySet().iterator();
        while(keys.hasNext()){
            int key = keys.next();
            System.err.println(key);
            System.err.println(hm.get(key));
        }

        //keySet()
        System.err.println("keySet");
        for(int key: hm.keySet()){
            System.err.println(key);
            System.err.println(hm.get(key));
            
        }

        //entry
        System.err.println("Entry");
        for(HashMap.Entry<Integer, Integer> entry:hm.entrySet()){
            System.err.println(entry.getKey()+" "+entry.getValue());
        }

    }

    public static void HashMap_Sort(){
        System.err.println("HashMap_Sort");
        System.err.println("MapToList");
        HashMap<Integer,String> hm = new HashMap<Integer, String>();
        hm.put(1, "aaaa");
        hm.put(2, "cccc");
        hm.put(4, "bbbb");
        hm.put(5, "bbbb");

        //1. key 정렬
        //list로 key 변환
        List<Integer> list = new ArrayList<>(hm.keySet());
        list.sort((i1,i2)->i1.compareTo(i2)); //정방향 정렬
        for(int i:list){
            System.err.println("key = "+i+" value = "+hm.get(i));
        }

        System.err.println();

        list.sort((i1,i2)->i2.compareTo(i1)); //역방향 정렬
        for(int i:list){
            System.err.println("key = "+i+" value = "+hm.get(i));
        }

        //2. value로 정렬
        List<String> list2 = new ArrayList<>(hm.values());
        list2.sort((s1,s2)->s1.compareTo(s2));

        for(String s:list2){
            System.err.println("value = "+s);
        }
        System.err.println();
        list2.sort((s1,s2)->s2.compareTo(s1));

        for(String s:list2){
            System.err.println("value = "+s);
        }
        
        System.out.println();

        //3.stram 
        //3.1 정방향 정렬 sort by key
        List<HashMap.Entry<Integer,String>> entrys = 
            hm.entrySet().stream()
                .sorted(HashMap.Entry.comparingByKey())
                .collect(Collectors.toList());
            
        for(HashMap.Entry<Integer,String> enrty:entrys){
            System.err.println(enrty.getKey()+" "+enrty.getValue());
        }

        System.out.println();
        //3.2 정방향 정렬 sort by value
        List<HashMap.Entry<Integer,String>> entrys2 = 
            hm.entrySet().stream()
                .sorted(HashMap.Entry.comparingByValue())
                .collect(Collectors.toList());

        for(HashMap.Entry<Integer,String> enrty:entrys2){
            System.err.println(enrty.getKey()+" "+enrty.getValue());
        }
        System.out.println();

        //3.3 역방향 정렬 sort by key
        List<HashMap.Entry<Integer,String>> entrys3 = 
            hm.entrySet().stream()
                .sorted(Collections.reverseOrder(HashMap.Entry.comparingByKey()))
                .collect(Collectors.toList())
        ;

        for(HashMap.Entry<Integer,String> enrty:entrys3){
            System.err.println(enrty.getKey()+" "+enrty.getValue());
        }
        
        System.out.println();

        List<HashMap.Entry<Integer,String>> entry4 =
            hm.entrySet().stream()
                .sorted(Collections.reverseOrder(HashMap.Entry.comparingByValue()))
                .collect(Collectors.toList());

        for(HashMap.Entry<Integer,String> enrty:entry4){
            System.err.println(enrty.getKey()+" "+enrty.getValue());
        }

        LinkedHashMap<Integer,String> hm2 = new LinkedHashMap<Integer,String>();

        for(HashMap.Entry<Integer,String> enrty:entry4){
            hm2.put(enrty.getKey(),enrty.getValue());
        }

        for(int key:hm2.keySet()){
            System.err.println("key = "+key+" value = "+hm2.get(key));
        }

        //4.복합정렬
        System.err.println("복합정렬");
        List<HashMap.Entry<Integer,String>> entrys4 = new ArrayList<>(hm.entrySet());

        entrys4.sort(new Comparator<HashMap.Entry<Integer,String>>() {
            @Override
            public int compare(HashMap.Entry<Integer,String> o1, HashMap.Entry<Integer,String> o2) {
                if(o1.getValue().equals(o2.getValue())){
                    return o1.getKey() - o2.getKey();
                }
                return o2.getKey() - o1.getKey();
            }
        });

        for(HashMap.Entry<Integer,String> e:entrys4){
            System.err.println(e);
        }
    }
}