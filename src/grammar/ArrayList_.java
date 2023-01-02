package grammar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayList_ {
    public static void main(String[] args) throws Exception {
        List_MaxMin();
        List_Sort();
    }

    public static void List_MaxMin(){
        System.err.println("!!!! List_MaxMin !!!!");
        List<Integer> list = Arrays.asList(5,123,1,23);
        int max = list.stream().mapToInt(i->i).max().getAsInt();
        int min = list.stream().mapToInt(i->i).min().getAsInt();

        System.err.println("max = "+max);
        System.err.println("min = "+min);
    }

    public static void List_Sort(){
        System.err.println("!!!! List_Sort !!!!");
        List<Integer> list = Arrays.asList(5,123,1,23);

        List<Integer> temp = list.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());

        for(int i:temp){
            System.err.println(i);
        }

        temp = list.stream().sorted().collect(Collectors.toList());

        for(int i:temp){
            System.err.println(i);
        }

        
        //단일 map 정렬
        HashMap<Integer,String> map = new HashMap<>();
        map.put(1, "aaaa");
        map.put(2, "bbbb");
        map.put(3, "cccc");
        map.put(4, "cccc");
        
        List<HashMap.Entry<Integer,String>> mapList = new ArrayList<>(map.entrySet());

        mapList = mapList.stream().sorted((o1, o2) -> {
                if( o1.getValue().equals( o2.getValue())){
                    return o1.getKey() - o2.getKey();
                }else{
                    return o2.getValue().compareTo(o1.getValue());
                }
            }).collect(Collectors.toList());

        System.err.println(mapList);

        
        //복합 map 정렬
        List<HashMap<Integer,String>> mapList2 = new ArrayList<>();

        HashMap<Integer,String> map2 = new HashMap<>();
        map2.put(1, "aaaa");
        map2.put(2, "bbbb");
        map2.put(3, "cccc");
        mapList2.add(map2);

        map2 = new HashMap<>();
        map2.put(1, "hhhh");
        map2.put(2, "iiii");
        map2.put(3, "jjjj");
        mapList2.add(map2);

        map2 = new HashMap<>();
        map2.put(1, "aaaa");
        map2.put(2, "bbbb");
        map2.put(3, "aaaa");
        mapList2.add(map2);
        System.err.println(mapList2);

        List<HashMap<Integer,String>> tempList = 
            mapList2.stream()
                .sorted(
                    Comparator.comparing(
                        (HashMap<Integer,String> tempMap) -> tempMap.get(1)
                    )
                    .reversed()
                )
                .collect(Collectors.toList());
        
        System.err.println("tempList = "+tempList);

        tempList = 
            mapList2.stream()
                .sorted(
                    Comparator.comparing(
                        (HashMap<Integer,String> tempMap) -> tempMap.get(1)
                    )
                    .reversed()
                    .thenComparing(
                        (HashMap<Integer,String> tempMap) -> tempMap.get(3)
                    )
                 )
                .collect(Collectors.toList());
        
        System.err.println("tempList = "+tempList);
    }


}