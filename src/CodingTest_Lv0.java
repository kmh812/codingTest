import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CodingTest_Lv0 {
    public static void main(String[] args) throws Exception {
        lv0_1(); // 옹알이1
        lv0_2(); // 다음에 올 숫자 (등차수열 등비수열)
        lv0_3(); // 연속된 수읩 합
        lv0_4(); // 종이 자르기
        lv0_5(); // 문자열 밀기
        lv0_6(); // 잘라서 배열로 저장하기
        lv0_7(); // 7의 개수
        lv0_8(); // 문자열 정렬하기
        lv0_9(); // 세균증식
        lv0_10(); // 제곱수 판별하기
        lv0_11(); // 문자열안에 문자열
        lv0_12(); // OX퀴즈
        lv0_13(); // 자릿수 더하기
        lv0_14(); // n의 배수 고르기
        lv0_15(); // 숫자찾기
        lv0_16(); // 배열의 유사도
        lv0_17(); // 문자열 계산하기
        lv0_18(); // 가장큰수 찾기
        lv0_19(); // 편지
        lv0_20(); // 약수 구하기
        lv0_21(); // 한번만 등장한 문자
        lv0_22(); // 인덱스 바꾸기
        lv0_23(); // 영어가 싫어요
        lv0_24(); // 대문자와 소문자
        lv0_25(); // 암호 해독
        lv0_26(); // 3 6 9 게임
        lv0_27(); // 가까운수
        lv0_28(); // 삼각형의 완성 조건(1)
        lv0_29(); // 중복된 문자 제거
        lv0_30(); // k의 개수
        lv0_31(); // A로 B만들기
        lv0_32(); // 이진수 더하기
        lv0_33(); // 치킨쿠폰
        lv0_34(); // 로그인 성공
        lv0_35(); // 등수 매기기
        lv0_36(); // 특이한정렬
        lv0_37(); // 유한소수 판별하기
        lv0_38(); // 겹치는 선분의 길이
        lv0_39(); // 평행
        lv0_40(); // 저주의숫자3
        lv0_41(); // 외계어 사전
        lv0_42(); // 삼각형의 완성조건
        lv0_43(); // 안전지대
        lv0_44(); // 숨어있는 숫자의 덧셈(2)
        lv0_45(); // 다항식 더하기
        lv0_46(); // 최댓값 만들기(2)
        lv0_47(); // 캐릭터의 좌표
        lv0_48(); // 직사각형 넓이 구하기
        lv0_49(); // 배열원소의길이
        lv0_50(); // 컨트롤제트
        lv0_51(); // 소인수분해
        lv0_52(); //숨어있는 숫자의 덧셈(1)
        lv0_53(); //문자열 정렬하기
    }

	public static void lv0_1() {
		
		int cnt = 0;
		int cnt2 = 0;
		
		String[] talk = {"aya","ye","woo","ma"};
		
		String[] babbling = {"aya","yee", "u", "maa", "wyeoo"};
		String[] babbling2  = {"ayaye","uuuma", "ye", "yemawoo"};
		
		for(String str:babbling) {
			System.err.println("start = "+str);
			String temp=str;
			for(String str2:talk) {
				temp=temp.replaceFirst(str2, " ");
			}
			System.err.println("end = "+temp);
			
			if("".equals(temp.replaceAll(" ", ""))) {
				cnt++;
			}
		}
		
		System.err.println(cnt);
		
		for(String str:babbling2) {
			System.err.println("start = "+str);
			String temp=str;
			for(String str2:talk) {
				temp=temp.replaceFirst(str2, " ");
			}
			System.err.println("end = "+temp);
			
			if("".equals(temp.replaceAll(" ", ""))) {
				cnt2++;
			}
		}
		
		System.err.println(cnt2);
		
	}
	
	public static void lv0_2() {
		/*
		 * 등차수열 : 첫번쨰값과 두번째 값의 차이가 두번째와 값과 세번째 값의 차이가 같으면 등차
		 * 두번째 값을 첫번쨰 값으로 나눈 값의 결과를 곱해주면 된다.
		 */
		
		int[] common1 = {1,2,3,4};
		int[] common2 = {2,4,8};
		
		int number1_0 = common1[0];
		int number1_1 = common1[1];
		int number1_2 = common1[2];
		
		if(number1_1-number1_0 == number1_2-number1_1) {
			System.err.println(common1[common1.length-1]+(number1_1-number1_0));
		}else {
			System.err.println(common1[common1.length-1]*(number1_1/number1_0));
		}
		
		int number2_0 = common2[0];
		int number2_1 = common2[1];
		int number2_2 = common2[2];
		
		if(number2_1-number2_0 == number2_2-number2_1) {
			System.err.println(common2[common2.length-1]+(number2_1-number2_0));
		}else {
			System.err.println(common2[common2.length-1]*(number2_1/number2_0));
		}
	}
	
	public static void lv0_3() {
		
	}
	
	public static void lv0_4() {
		int m =3;
		int n=3;
		
		System.err.println((m*n)-1);
	}
	
	public static void lv0_5() {
//		String a="hello";
//		String b="ohell";
		
		String a="apple";
		String b="elppa";
		
		int cnt=0;
		for(int i=0; i < a.length(); i++) {
			if(!b.equals(a)){
				String start = a.substring(0,a.length()-1);
				String end = a.substring(a.length()-1);
				
				System.err.println("start = "+start);
				System.err.println("end = "+end);
				
				a = end+start;
				
				System.err.println("a 2 = "+a);
				cnt++;
			}else if(b.equals(a)){
				break;
			}
		}
		
		if(cnt == a.length()) {
			cnt = -1;
		}
		
		System.err.println(cnt);
	}
	
	public static void lv0_6() {
		String my_str = "abcdef123";
		int n = 3;
		
		int size = 0;
		
		if(my_str.length() % n > 0) {
			size = (my_str.length() / n) + 1; 
		}else {
			size = (my_str.length() / n);
		}
		
		String[] str =  new String[size];
		
		int cnt=0;
		while(my_str.length() > 0) {
			if(my_str.length() > n) {
				String temp = my_str.substring(0,n);
				System.err.println("temp = "+temp);
				str[cnt] = temp;
				my_str = my_str.substring(n);
				cnt++;
				System.err.println("my_str = "+my_str);
			}else {
				String temp = my_str;
				my_str = "";
				str[cnt] = temp;
			}
		}
		
		for(String s:str) {
			System.err.println(s);
		}
	}
	
	public static void lv0_7() {
		int[] arr = {7,77,0};
		
		int cnt=0;
		for(int i:arr) {
			String str = Integer.toString(i);
			for(char j:str.toCharArray()) {
				System.err.println("j = "+j);
				if(j=='7') {
					cnt++;
				}
			}
		}
		
		System.err.println(cnt);
	}
	
	public static void lv0_8() {
		//String str = "Bcad";
		String str = "heLLo";
		
		str = str.toLowerCase();
		
		System.err.println(str);
		
		char[] chars = str.toCharArray();
        Arrays.sort(chars);
        
        //char arrays to string
        str = new String(chars);
		
        System.err.println(str);
	}
	
	public static void lv0_9() {
		int n = 7;
		int t = 15;
		
		long sum=n;
		
		for(int i=1; i<=t; i++ ) {
			sum = sum*2;
		}
		
		System.err.println(sum);
	}
	
	public static void lv0_10() {
		int n = 144;
		
		//Math.sqrt double형태로 인수의 제곱근을 출력합니다
		Double sqrt = Math.sqrt(n);
	      
	      if(sqrt == sqrt.intValue()){
	    	  System.err.println( 1 );
	      } else {
	    	  System.err.println( 2 );
	      }
	}
	
	public static void lv0_11() {
		String str1="ab6CDE443fgh22iJKImn1o";
		String str2="6CD";
		
		if(str1.contains(str2)) {
			System.err.println(1);
		}else {
			System.err.println(2);
		}
	}
	
	public static void lv0_12() {
		String[] str = {"3-4=-3","5+6=11"}; 
		for(String s:str) {
			String[] temp = s.split("=");
			System.err.println("temp[0] = "+temp[0]);
			System.err.println("temp[1] = "+temp[1]);
			int cal=0;
			if(temp[0].contains("-")) {
				String[] temp2 = temp[0].split("-");
				System.err.println("temp2[0] = "+temp2[0]);
				System.err.println("temp2[1] = "+temp2[1]);
				cal = Integer.parseInt(temp2[1]) - Integer.parseInt(temp2[0]); 
			}else if(temp[0].contains("+")){
				
				System.err.println("temp2[0] 111");
				
				String[] temp2 = temp[0].split("\\+");
				System.err.println("temp2[0] = "+temp2[0]);
				System.err.println("temp2[1] = "+temp2[1]);
				cal = Integer.parseInt(temp2[1]) + Integer.parseInt(temp2[0]);
			}
			
			if(cal == Integer.parseInt(temp[1])) {
				System.err.println("O");
			}else {
				System.err.println("X");
			}
		}
	}
	
	public static void lv0_13() {
		int n = 930211;
		String str = Integer.toString(n);
		char [] temp = str.toCharArray();
		long sum=0;
		for(char c:temp) {
			sum += Character.getNumericValue(c);
		}
		System.err.println(sum);
	}
	
	public static void lv0_14() {
		//배열을 List로 Arrays.asList()
		//List를 배열로 toArray()
		int n = 3;
		int[] numlist = {4,5,6,7,8,9,10,11,12};
		
		List<Integer> intList = new ArrayList<>();
		
		for(int i:numlist) {
			if(i%n==0) {
				intList.add(i);
			}
		}
		
		// int List to int array
		int[] result = intList.stream().mapToInt(Integer::intValue).toArray();
		
		for(int i:result) {
			System.err.println(i);
		}
	}
	
	public static void lv0_15() {
		int num = 12314244;
		int k = 4;
		
		// int to char
		char ck = Character.forDigit(k,10);
		
		// int to String
		String numStr = Integer.toString(num);
		
		// String to char[]
		char[] numc = numStr.toCharArray();
		
		int cnt=1;
		for(char c:numc) {
			if(c==ck) {
				break;
			}
			cnt++;
		}
		
		System.err.println(cnt);
		
	}
	
	public static void lv0_16() {
		String[] a = {"a","b","c"};
		String[] b = {"com","b","d","p","c"};
		
		int count=0;
		for(String str1:a) {
			for(String str2:b) {
				if(str1.equals(str2)) {
					count++;
				}
			}
		}
		
		System.err.println(count);
	}
	
	public static void lv0_17() {
		String my_str = "3 + 5";
		
		my_str = my_str.replaceAll(" ","");
		
		long result =0;
		if(my_str.contains("+")) {
			String temp[] = my_str.split("\\+");
			result = Integer.parseInt(temp[0]) + Integer.parseInt(temp[1]);
			
		}else {
			String temp[] = my_str.split("-");
			result = Integer.parseInt(temp[0]) - Integer.parseInt(temp[1]);
		}
		
		System.err.println(result);
	}
	
	public static void lv0_18() {
		int[] arr = {1,6,4};
		
		int max=0;
		int index =0;
		for(int i=0; i<arr.length; i++) {
			if(max < arr[i]) {
				max = arr[i];
				index = i;
			}
		}
		
		System.err.println(max);
		System.err.println(index);
	}
	
	public static void lv0_19() {
		String message ="happy birthday!";
		
		System.err.println(message.length()*2);
		
		String message2 ="I love you~";
		
		System.err.println(message2.length()*2);
	}
	
	public static void lv0_20() {
		int n = 24;
		
		List<Integer> temp =new ArrayList<>();
		for(int i=1; i<=n ; i++) {
			if(n%i==0) {
				temp.add(i);
			}
		}
		
		int[] result = temp.stream().mapToInt(i-> i).toArray();
		
		for(int i:result) {
			System.err.println(i);
		}
	
	}
	
	public static void lv0_21() {
		String message ="asdffdsaghjghj";
		
		char[] messageArr = message.toCharArray();
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<messageArr.length; i++) {
			int cnt=0;
			for(int j=0; j<messageArr.length; j++) {
				if(messageArr[i]==messageArr[j]) {
					cnt++;
				}
			}
			if(cnt<2) {
				sb.append(messageArr[i]);
			}
		}
		
		System.err.println(sb);
	}
	
	public static void lv0_22() {
		
		int n = 2;
		int m = 7;
		
		String message= "i love you";
		
		char[] messageArr = message.toCharArray();
		
		char temp1 = messageArr[n];
		char temp2 = messageArr[m];
		
		System.err.println(temp1+" "+temp2);
		
		messageArr[n] = temp2;
		messageArr[m] = temp1;
		
		for(char c:messageArr) {
			System.err.println(c);
		}
	}
	
	public static void lv0_23() {
		HashMap<Integer, String> nemberMap = new HashMap<Integer, String>();
		nemberMap.put(1,"one");
		nemberMap.put(2,"two");
		nemberMap.put(3,"thee");
		nemberMap.put(4,"four");
		nemberMap.put(5,"five");
		nemberMap.put(6,"six");
		nemberMap.put(0,"zero");
		
		String number="onetwotheefivesixzero";
		
		//Map key, value 반복문 
		Set<Entry<Integer, String>> set2 = nemberMap.entrySet();
        Iterator<Entry<Integer, String>> iterator2 = set2.iterator();
        while(iterator2.hasNext()){
            Entry<Integer,String> entry = (Entry<Integer, String>)iterator2.next();
            int key = (Integer)entry.getKey();
            String value = (String)entry.getValue();
            System.out.println("hashMap Key : " + key);
            System.out.println("hashMap Value : " + value);
            number = number.replaceAll(value, Integer.toString(key));
        }
        
        System.err.println(number);
	}
	
	public static void lv0_24() {
		String message = "ccccDDD";
		
		char[] messageArr = message.toCharArray();
		StringBuffer str =  new StringBuffer();
		for(char c:messageArr) {
	   		if(Character.isLowerCase(c)) {
	   			//소문자일 때 대문자로
	        	str.append(Character.toUpperCase(c));
	        }else {
	    		// 대문자일 때 소문자로
	    		str.append(Character.toLowerCase(c));
	        }
		}
		System.err.println(str);
	}
	
	public static void lv0_25() {
		String message = "aaaabbbbddddgggghhhhjjjjkk";
		//공백제거
		message = message.trim();
		char[] messageArr = message.toCharArray();
		int n=4;
		StringBuffer str = new StringBuffer();
		for(int i=0; i<messageArr.length; i++) {
			if(i%n==0) {
				str.append(messageArr[i]);
			}
		}
		System.err.println(str);
	}
	
	public static void lv0_26() {
		int num = 123522679;
		
		// int to String
		String numStr = Integer.toString(num);

		//String to char array
		char[] numChar = numStr.toCharArray();
		
		int cnt=0;
		for(char c:numChar) {
			if(c=='3'||c=='6'||c=='9') {
				cnt++;
			}
		}
		
		System.err.println(cnt);
	}
	
	public static void lv0_27() {
		int[] arr = {13,54,8};
		int n=10;
		
		int tmp=99999999;
		for(int i:arr) {
			//절대값
			if(Math.abs(n-1) < tmp) {
				tmp = i;
			}
		}
		System.err.println(tmp);
	}
	
	public static void lv0_28() {
		int[] input =  {3,2,6};
		
		//배열 스트림
		Integer maxValue = Arrays.stream(input)
                .max()
                .getAsInt();
		
		int sum=0;
		for(int i:input) {
			if(i!=maxValue) {
				sum+=i;
			}
		}
		
		if(sum > maxValue) {
			System.err.println(1);
		}else {
			System.err.println(2);
		}
		
	}
	
	public static void lv0_29() {
		String str ="people";
		
		char[] strArr = str.toCharArray();
		
		Set<Character> hs = new HashSet<>();
		
		for(char c:strArr) {
			hs.add(c);
		}
		
		// set -> array
		System.err.println(hs.toArray());
		
		Iterator<Character> iterator2 = hs.iterator();
		while(iterator2.hasNext()){
			System.err.println(iterator2.next());
		}
	}
	
	public static void lv0_30() {
		int n = 2;
		int m = 23;
		int num = 3;
		
		int cnt=0;
		for(int i=n; i<=m; i++) {
			String temp = Integer.toString(i);
			char[] tempArr = temp.toCharArray();
			for(char c:tempArr) {
				if(c == Character.forDigit (num, 10)) {
					cnt++;
				}
			}
		}
		System.err.println(cnt);
	}
	
	public static void lv0_31() {
		String before ="aabbcc";
		String after ="baabcc";
		
		
		before = Stream.of(before.split("")).sorted().collect(Collectors.joining());
		after = Stream.of(after.split("")).sorted().collect(Collectors.joining());
		
		System.err.println("before = "+before);
		System.err.println("after = "+after);
		
		if(after.contains(before)) {
			System.err.println(1);
		}else {
			System.err.println(0);
		}
		
		
		String before2 ="aabbcc";
		String after2 ="baabcc";
		
		char[] before2Arr = before2.toCharArray();
		Arrays.sort(before2Arr);
		before2 = new String(before2Arr);
		
		char[] after2Arr = after2.toCharArray();
		Arrays.sort(after2Arr);
		after2 = new String(after2Arr);
		
		System.err.println("before2 = "+before2);
		System.err.println("after2 = "+after2);
		
		if(after2.contains(before2)) {
			System.err.println(1);
		}else {
			System.err.println(0);
		}
	}
	
	public static void lv0_32() {
		String tmp1 ="101";
		String tmp2 ="11";
		
		BigInteger A_binary = new BigInteger(tmp1, 2);
		BigInteger B_binary = new BigInteger(tmp2, 2);
		
		BigInteger sum = A_binary.add(B_binary);
		
		String sum_binary = sum.toString(2);
		System.out.println(sum_binary);
	}
	
	static int lv0_33_value_sum = 0; // 몫 더하기
    static int lv0_33_mod = 0;       // 나머지
	static int lv0_33_mod_sum = 0;   // 나머지 더하기
	
	public static void lv0_33() {
		int lv0_33_target = 10;
		int lv0_33_value = 100;
		//재귀함수 사용
		cal(lv0_33_target, lv0_33_value);
		
		System.err.println("lv0_33_value_sum = "+lv0_33_value_sum);
		System.err.println("lv0_33_mod_sum = "+lv0_33_mod_sum);
		
	}
	
	public static void cal(int lv0_33_target,int lv0_33_value) {
		int temp = lv0_33_value;
		lv0_33_value = temp / lv0_33_target; //몫구하기
		lv0_33_mod = temp % lv0_33_target;  //나머지 구하기
		
		lv0_33_value_sum += lv0_33_value; // 목더하기
		lv0_33_mod_sum += lv0_33_mod; // 목더하기
		
		if(lv0_33_value < lv0_33_target) {
			lv0_33_mod_sum += lv0_33_value;
			if(lv0_33_mod_sum>=lv0_33_target) {
				lv0_33_value_sum += lv0_33_mod_sum / lv0_33_target;
			}
		}
		
		if(lv0_33_value >= lv0_33_target) {
			cal(lv0_33_target, lv0_33_value);
		}
	}
	
	public static void lv0_34() {
		String[] input = {"kmh812","11111"};
		String[][] db = {{"kmh816","11112"},{"kmh813","11113"},{"kmh814","11114"},{"kmh815","11115"}};
		
		String message="fail";
		for(int i=0; i<db.length; i++) {
			String[] temp = db[i];
			if(input[0].equals(temp[0])) {
				if(input[1].equals(temp[1])) {
					message="login";
				}else {
					message="wrong pw";
				}
			}
		}
		
		System.err.println(message);
	}
	
	public static void lv0_35() {
		Integer [][] score = {{80,90},{60,40},{40,40},{40,60}};
		Integer [] avg = new Integer[score.length];
		
		for(int i=0; i<score.length; i++) {
			  avg[i] = (score[i][0] + score[i][1]) / 2; 
		}
		
		List<Integer> order = Arrays.stream(avg)
				.distinct() //중복제거
				.sorted(Comparator.reverseOrder()) // 역정렬
				.collect(Collectors.toList()); //List로 리턴
		
		
		Integer [] avgOrder = new Integer[score.length];
		
		for(int i=0; i<avg.length; i++) {
			for(int j=0; j<order.size(); j++) {
				if(avg[i]==order.get(j)) {
					avgOrder[i] = j+1;
					break;
				}
			}
		}
		
		for(int i=0; i<avg.length; i++) {
			System.err.println(avg[i]);
		}
		
		for(int i=0; i<avgOrder.length; i++) {
			System.err.println(avgOrder[i]);
		}
	}
	
	public static void lv0_36() {
		int[] a = {1,2,3,4,5,6};
		int n = 4;
		
		HashMap<Integer,Integer> order = new HashMap<Integer,Integer>();
		for(int i=0; i<a.length; i++) {
			order.put(a[i], Math.abs(a[i]-n));
		}
		
		List<Map.Entry<Integer,Integer>> entryList = new LinkedList<>(order.entrySet());
		
		entryList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
		    @Override
		    public int compare(Map.Entry<Integer,Integer> o1, Map.Entry<Integer,Integer> o2) {
		    	return o1.getValue() - o2.getValue();
		    }
		});
		
		for(Map.Entry<Integer,Integer> e:entryList) {
			System.err.println(e.getKey()+" "+e.getValue());
		}

        System.err.println();

        entryList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
		    @Override
		    public int compare(Map.Entry<Integer,Integer> o1, Map.Entry<Integer,Integer> o2) {
                if(o1.getValue() == o2.getValue()){
                    return o2.getKey() - o1.getKey();
                }
                return o1.getValue() - o2.getValue();
		    }
		});
		
		for(Map.Entry<Integer,Integer> e:entryList) {
			System.err.println(e.getKey()+" "+e.getValue());
		}
	}

    public static void lv0_37(){ //유한소수 판별하기


    }

    public static void lv0_38(){ //겹치는 선분의 길이
        System.err.println("lv0_38");
        int[][] nums = {{0,2},{-3,-1},{-2,1}};

        int min = 999999;
        int max = -99999;
        for(int[] n:nums){
            if(min > n[0]){
                min = n[0];
            }
            if(max < n[1]){
                max = n[1];
            }
        }

        LinkedHashMap<Integer,Integer> hm = new LinkedHashMap<Integer,Integer>();
        for(int i=min; i<max; i++){
            int cnt=0;
            for(int[] n:nums){
                for(int j=n[0]; j<n[1]; j++){
                    if(i==j){
                        cnt++;
                    }
                }
            }
            hm.put(i, cnt);
        }

        int count=0;
        for(HashMap.Entry<Integer, Integer> entry:hm.entrySet()){
            System.err.println(entry.getKey()+" "+entry.getValue());
            if(entry.getValue()>1){
                count++;
            }
        }

        System.err.println(count);
    }

    public static void lv0_39(){ //평행
        System.err.println("lv0_39");
        
    }

    public static void lv0_40(){ //평행
        System.err.println("lv0_40");
        
        int n=40;
        int count=0;
        int treeCount=0;
        while(true){
            
            String s = Integer.toString(count);
            String[] sArr = Arrays.stream(s.split("")).toArray(String[]::new);
            Boolean che = false;
            for(String ss:sArr){
                if("3".equals(ss)){
                    che = true;
                    break;
                }
            }

            if(count%3!=0 && che != true){
                treeCount++;
            }

            if(n==treeCount){
                break;
            }
 
            count++;            
        }

        System.err.println("treeCount= "+treeCount);
        System.err.println("count= "+count);
    }
    
    public static void lv0_41(){ //외계어 사전
        System.err.println("lv0_41");
        String[] spell = {"p","o","s"};
        String[] dic = {"sod","eocd","qixm","adio","soo","sop"};

        Arrays.sort(spell);

        String strJoin = String.join("", spell);
        System.err.println("strJoin = "+strJoin);

        int cnt=0;
        for(String s:dic){
            String[] temp = Arrays.stream(s.split("")).toArray(String[]::new);
            Arrays.sort(temp);
            String strTemp = String.join("", temp);
            if(strTemp.contains(strJoin)){
                cnt++;
            }
        }

        if(cnt>0){
            System.err.println(1);
        }else{
            System.err.println(2);
        }
    }

    public static void lv0_42(){ //삼각형의 완성 조건
        System.err.println("lv0_42");
        int[] side = {3,6} ;

        int max = Arrays.stream(side).max().getAsInt();
        int min = Arrays.stream(side).min().getAsInt();

        int cnt=0;
        for(int i=(max-min)+1; i<=max; i++){ // 배열값중 최대값이 있을때.
            System.err.println("1 = "+i);
            cnt++;
        }

        for(int i=max+1; i<max+min; i++){ // 신규값이 최대 값일때
            System.err.println("2 = "+i);
            cnt++;
        }

        System.err.println(cnt);
    }

    public static void lv0_43(){ //안전지대
        System.err.println("lv0_43");

        int[][] board ={{0,0,0,0,0}
                        ,{0,0,0,0,0}
                        ,{0,0,0,0,0}
                        ,{0,0,1,0,0}
                        ,{0,0,0,0,0}};
        int n = board[0].length;
        
        

        //위험지역 설정
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]==1){
                    int tar1 = i-1;
                    int tar2 = i+1;
                    int tar3 = j-1;
                    int tar4 = j+1;
                    if(tar1 > 0 && tar2 < n && tar3 > 0 && tar4 < n){
                        for(int ii=tar1; ii<=tar2; ii++){
                            for(int jj=tar3; jj<=tar4; jj++){
                                if(board[ii][jj]!=1&&board[ii][jj]!=2){
                                    board[ii][jj]=2;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.err.println();
        int count=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.err.print(board[i][j]+" ");
                if(board[i][j]==0){
                    count++;
                }
            }
            System.err.println();
        }
        System.err.println(count);
    }
    
    public static void lv0_44(){ //숨어있는 숫자의 덧셈(2)
        System.err.println("lv0_44");
        String str="asf125gdv1DR123";
        char[] strC = str.toCharArray();

        int sum=0;
        for(char c:strC){
            if(Character.isDigit(c)){
                sum+=Character.getNumericValue(c);
            }
        }
        System.err.println(sum);
    }

    public static void lv0_45(){ //다항식 더하기
        System.err.println("lv0_45");
        String polynomial = "3x + 7 + x";
        polynomial = polynomial.trim();

        System.err.println(polynomial);

        String[] polynomialArr = polynomial.split(" \\+ ");

        int xsum =0;
        int sum =0;
        for(String s:polynomialArr){
            System.err.println(s);
            if(s.contains("x")){
                if(s.equals("x")){
                    xsum += 1;
                }else{
                    //System.err.println("!! x !!" + s.replace("x", ""));
                    xsum += Integer.parseInt(s.replace("x", ""));
                }
            }else{
                sum+= Integer.parseInt(s);
            }
        }

        System.err.println(xsum);
        System.err.println(sum);
        System.err.println(xsum+"x + "+sum);
    }

    public static void lv0_46(){ //최대값 만들기(2)
        System.err.println("lv0_46");

        //int[] number = {1 ,2 ,-3 ,4 ,-5};
        //int[] number = {0,-31,24,10,1,9};
        int[] number = {10,20,30,5,5,20,5};

        Arrays.sort(number);

        int max1 = number[0] * number[1];

        System.err.println();

        Integer[] IntergerNumber = Arrays.stream(number).boxed().toArray(Integer[]::new);

        Arrays.sort(IntergerNumber,Collections.reverseOrder());

        int max2 = IntergerNumber[0] * IntergerNumber[1];

        if(max1 > max2){
            System.err.println(max1);
        }else{
            System.err.println(max2);
        }
    }

    public static void lv0_47(){ //캐릭터의 좌표
        System.err.println("lv0_47");
        String[] keyinput = {"left","right","up","right","right"};
        int[] board = {11,11};
        int[] size = {board[0]/2, board[1]/2};

        int[] temp={0,0};
        for(String s:keyinput){
            System.err.println("key = "+s);
            System.err.println("start = "+temp[0]+" "+temp[1]);
            if("up".equals(s)){
                if(temp[1] < size[1] && temp[1] > size[1]*-1){
                    temp[1] += 1;
                }
            }else if("down".equals(s)){
                if(temp[1] < size[1] && temp[1] > size[1]*-1){
                    temp[1] += -1;
                }
            }else if("left".equals(s)){
                if(temp[0] < size[0] && temp[0] > size[0]*-1){
                    temp[0] += -1;
                }
            }else if("right".equals(s)){
                if(temp[0] < size[0] && temp[0] > size[0]*-1){
                    temp[0] += 1;
                }
            }
            System.err.println("end = "+temp[0]+" "+temp[1]);
            System.err.println();
        }
        System.err.println(temp[0]+" "+temp[1]);
    }

    public static void lv0_48(){ //직사각형 넓이 구하기
        System.err.println("lv0_48");
        //int[][] dots = {{1,1},{2,1},{2,2},{1,2}};
        int[][] dots = {{-1,-1},{1,1},{1,-1},{-1,1}};
        int w=0, h=0;
        for(int i=0; i<dots.length-1; i++){
            for(int j=i+1; j<dots.length; j++){
                if(dots[i][0] == dots[j][0]){
                    w = dots[i][1] - dots[j][1];
                }
                if(dots[i][1] == dots[j][1]){
                    h = dots[i][0] - dots[j][0];
                }

            }
        }
        System.err.println(Math.abs(w*h));
    }

    public static void lv0_49(){ //배열원소의길이
        System.err.println("lv0_49");
        String[] word = {"asdf","sdv","webc","asd"};

        int[] size = new int[word.length];

        for(int i=0; i<word.length; i++){
            String s = word[i];
            size[i] = s.toCharArray().length;
        }

        for(int i:size){
            System.err.println(i);
        }

    }

    public static void lv0_50(){ //컨트롤제트
        System.err.println("lv0_50");
        //String str="10 Z 1 2 3";
        String str="-1 -2 -3 Z";
        String[] sArr = str.split(" ");
        int sum=0;
        for(int i=0; i<sArr.length; i++){
            if("Z".equals(sArr[i])){
                int n = Integer.parseInt(sArr[i-1]);
                sum-=n;
            }else{
                int n = Integer.parseInt(sArr[i]);
                sum+=n;
            }
        }
        System.err.println(sum);
    }
    
    public static void lv0_51(){ //소인수분해
        System.err.println("lv0_51");
        List<Integer> List = new ArrayList<>();
        int n = 12;
        int i = 2;
        while (n != 1) {
            // i가 n의 약수이면 나누고 출력
            if (n % i == 0) {
                n/= i;
                List.add(i);
            } else {
                i++;
            }
        }

        int[] temp = List.stream().distinct().sorted().mapToInt(Integer::intValue).toArray();
        
        for(int nn:temp){
            System.err.println(nn);
        }
    }

    public static void lv0_52(){ //숨어있는 숫자의 덧셈(1)
        System.err.println("lv0_52");
        String my_string ="adgdb1264dvgh";
        char[] cArr = my_string.toCharArray();
        int sum=0;
        for(char c:cArr){
            if(Character.isDigit(c)){
                sum+= Character.getNumericValue(c);;
            }
        }
        System.err.println(sum);
    }

    public static void lv0_53(){ //문자열 정렬하기
        System.err.println("lv0_53");
        String str ="asdf12342";
        char[] cArr = str.toCharArray();
        List<Integer> list = new ArrayList<>();
        for(char c:cArr){
            if(Character.isDigit(c)){
                list.add(Character.getNumericValue(c));
            }
        }

        int[] temp = list.stream().sorted().mapToInt(Integer::intValue).toArray();

        for(int i:temp){
            System.err.println(i);
        }
    }

    public static void lv0_54(){ //모음제거
        System.err.println("lv0_54");
        
    }
}
