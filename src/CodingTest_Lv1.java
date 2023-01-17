
import java.util.*;
import java.util.Map.Entry;

public class CodingTest_Lv1 {
    public static void main(String[] args) throws Exception {
        // lv1_1(); 
        // lv1_2();
		// lv1_3();
		// lv1_4();
		// lv1_5();
		// lv1_6();
		// lv1_7();
		// lv1_8();
		// lv1_9();
		// lv1_10();
		// lv1_11();
		// lv1_12();
		// lv1_13();
		// lv1_14();
		// lv1_15();
		// lv1_16();
		// lv1_17();
		// lv1_18();
		// lv1_19();
		// lv1_20();
		// lv1_21();
		// lv1_22();
		// lv1_23();
		// lv1_24();
		// lv1_25();
		// lv1_26();
		// lv1_27();
		// lv1_28();
		// lv1_29();
		// lv1_30();
		// lv1_31();
		// lv1_32();
		lv1_33();
		lv1_34();
		lv1_35();
		lv1_36();
		lv1_37();
		lv1_38();
		lv1_39();
    }

	public static void lv1_1() { //크기가 작은 부분 문자열
		System.err.println("lv1_1");
		// String str1="3141592";
		// String str2="271";
		String str1="500220839878";
		String str2="7";
		int cnt=0;
		for(int i=0; i<=str1.length()-str2.length(); i++){
			String temp = str1.substring(i, i+str2.length());
			// System.err.println(temp+" "+str2);
			if(Integer.parseInt(str2) >= Integer.parseInt(temp)){
				cnt++;
			}
		}
		System.err.println(cnt);
	}

	public static void lv1_2() { //가장 가까운 같은 글자
		System.err.println("lv1_2");
		//String str="banana";
		String str="foobar";
		char[] strArr = str.toCharArray();
		int[] result = new int[strArr.length];
		for(int i=0; i<strArr.length; i++){
			System.err.println("i = "+strArr[i]);
			if(i==0){
				result[i] = -1;
			}else{
				int cnt=0;
				for(int j=0; j<i; j++){
					System.err.println("i = "+strArr[i]+" j = "+strArr[j]);
					if(strArr[i] == strArr[j]){
						cnt=j;
					}
				}
				System.err.println("cnt = "+cnt);
				if(0<cnt){
					result[i] = i - cnt;
				}else{
					result[i] = -1;
				}
			}			
		}

		for(int n:result){
			System.err.println(n);
		}
	}

	public static void lv1_3() { //문자열 나누기
		System.err.println("lv1_3");
		String s="banana";
		//String s="abracadabra";
		char[] sArr = s.toCharArray();
		int cnt1=0;
		int cnt2=0;
		int totalCnt=0;
		System.err.println("s.length() = "+s.length());
		for(int i=0; i<=s.length(); i++){
			System.err.println("i = "+i);
			if(i==s.length()){
				totalCnt++;
			}

			for(int j=i; j<s.length(); j++){
				System.err.println("sArr[i] = "+sArr[i]);
				System.err.println("sArr[j] = "+sArr[j]);
				if(sArr[i]==sArr[j]){
					cnt1++;
				}else{
					cnt2++;
				}
				System.err.println("cnt1 = "+cnt1);
				System.err.println("cnt2 = "+cnt2);
				if(cnt1==cnt2){
					i = j+1;
					totalCnt++;
					cnt1=0;
					cnt2=0;
				}
			}
		}
		System.err.println("totalCnt = "+totalCnt);
	}

	public static void lv1_4() { //명예의 전당(1)
		System.err.println("lv1_4");
		int k=4;
		//int[] score ={10,100,20,150,1,100,200};
		int[] score ={0,300,40,300,20,70,150,50,500,1000};
		List<Integer> list = new ArrayList<>();
		int[] result = new int[score.length];

		for(int i=0; i<score.length; i++){
			if(list.size() < k){
				list.add(score[i]);
				Collections.sort(list);
			}else{
				if(list.get(0) < score[i]){
					list.set(0, score[i]);
					Collections.sort(list);
				}
			}

			result[i] = list.get(0);
		}

		System.err.println(list);
		for(int i:result){
			System.err.println(i);
		}
	}

	public static void lv1_5() { //기사단원의 무기
		System.err.println("lv1_5"); 
		int number = 10;
		int limit = 3 ;
		int power = 2;
		int[] temp = new int[number];
		for(int i=1; i<=number; i++){
			int cnt =0;
			for(int j=1; j*j<=i; j++){
				if (j * j == i) cnt++;
				else if (i % j == 0) cnt += 2;
			}
			temp[i-1] = cnt;
		}

		int sum=0;
		for(int i:temp){
			System.err.println(i);
			if(i>3){
				sum+=power;
			}else{
				sum+=i;	
			}
		}

		System.err.println("sum = "+sum);
	}

	public static void lv1_6() { //과일장수
		System.err.println("lv1_6");
		int k = 3;
		int m = 4;
		int[] score = {1,2,3,1,2,3,1};
		List<Integer> temp = new ArrayList<>();
		int box = score.length / 4;

		//System.err.println("box = "+box);

		Integer[] score2 = Arrays.stream(score).boxed().toArray(Integer[]::new);
		Arrays.sort(score2, Collections.reverseOrder()); //int 역방향
		for(int i=0; i<m ; i++){
			temp.add(score2[i]);
		}

		int min = temp.stream().mapToInt(i->i).min().getAsInt();

		//System.err.println(min);

		System.err.println(min * m * box);

	}

	public static void lv1_7() { // 푸드파이트 대회
		System.err.println("lv1_7");
		//int[] food = {1,3,4,6};
		int[] food = {1,7,1,2};

		int mid = food.length /2 ;
		System.err.println("mid ="+mid);

		List<Integer> temp = new ArrayList<>();
		for(int i=1; i<food.length; i++){
			//System.err.println(food[i]);
			System.err.println(food[i]/2);
			int cnt = food[i]/2;
			for(int j=1; j<=cnt; j++){
				temp.add(i);
			}
		}
		List<Integer> temp2 = new ArrayList<>();
		temp2.addAll(temp);
		temp2.sort((o1, o2) -> o2-o1);
		temp.add(0);
		temp.addAll(temp2);
		System.err.println("temp = "+temp);
	}

	public static void lv1_8() { // 햄버거 만들기
		System.err.println("lv1_8");
		int[] ingredient = {2,1,1,2,3,1,2,3,1};
		//int[] ingredient = {1,3,2,1,2,1,3,1,2};
		String str = Arrays.toString(ingredient)
			.replaceAll("[^0-9 ]","")
			.replaceAll(" ","")
			;

		System.err.println(str);
		int cnt=0;
		while(str.contains("1231")){
			System.err.println("str = "+str);
			cnt++;
			str = str.replace("1231", "");
		}

		System.err.println("cnt = "+cnt);
	}

	public static void lv1_9() { // 옹알이
		System.err.println("lv1_9");
		String[] talk = {"aya","ye","woo","ma"};
		String[] babbing = {"aya","ye","u","maa"};
		String[] babbing2 = {"ayaye","uuu","yeye","yemawoo","ayaayaa"};

		int count=0;
		for(String s:babbing){
			for(String s2:talk){
				if(s.contains(s2)){
					s = s.replace(s2, "");
				}
			}
			if(s.equals("")){
				count++;
			}
		}

		System.err.println(count);
	}

	static int lv1_10_sum=0;
	public static void lv1_10() { // 콜라 문제
		System.err.println("lv1_10");
		
		int a = 3;
		int b = 1;
		int n = 20;
		lv1_10_1(n,a,b);

		System.err.println(lv1_10_sum);
	}

	public static void lv1_10_1(int number,int a, int b){
		if(number >= a){
			int temp = number/a*b;
			int temp2 = number%a;

			System.err.println("temp = "+temp+" temp2 = "+temp2);

			lv1_10_sum+=temp;
			lv1_10_1(temp+temp2, a, b);
		}
	}

	public static void lv1_11(){ //삼총사
		System.err.println("lv1_11");
		//int[] number ={-2,3,0,2,-5};
		int[] number ={-3,-2,-1,0,1,2,3};
		Arrays.sort(number);
		int cnt=0;
		for(int i=0; i<number.length; i++){
			for(int j=i+1; j<number.length; j++){
				for(int k=j+1; k<number.length; k++){
					if(number[i]+number[j]+number[k]==0){
						cnt++;
					}
				}	
			}
		}
		System.err.println(cnt);
	}

	public static void lv1_12(){ //숫자 짝궁
		System.err.println("lv1_12");
		//String x = "100";
		//String y = "2345";
		// String x = "100";
		// String y = "123450";
		String x = "12321";
		String y = "42531";

		char[] xArr = x.toCharArray();
		char[] yArr = y.toCharArray();

		List<String> temp = new ArrayList<>();

		for(int i=0; i<xArr.length; i++){
			for(int j=0; j<yArr.length; j++){
				if(xArr[i]==yArr[j]){
					temp.add(String.valueOf(xArr[i]));
					yArr[j] = '-';
					break;
				}
			}
		}

		System.err.println("temp.size() = "+temp.size());

		temp.sort((o1, o2) -> o2.compareTo(o1));

		if(temp.size() < 1){
			System.err.println("-1");
		}else{
			int cnt = temp.size();
			int sCnt =0;
			for(String s:temp){
				if(s.equals("0")){
					sCnt++;
				}
			}
			if(cnt == sCnt){
				System.err.println("0");
			}else{
				System.err.println("temp = "+temp.toString()
					.replaceAll("[^0-9 ]","")
					.replaceAll(" ", ""));
			}
		}
	}

	public static void lv1_13(){ //성격 유형 검사하기
		System.err.println("lv1_13");
		String[] sruvey = {"AN","CF","MJ","RT","NA"};
		int[] choices = {5,3,2,7,5};
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		for(int i=0; i<sruvey.length; i++){
			String temp1 = sruvey[i].substring(0,1);
			String temp2 = sruvey[i].substring(1,2);
			int num = choices[i];
			int cal = 0;
			if(num == 1){
				cal = 3;
			}else if(num == 2){
				cal = 2;
			}else if(num == 3){
				cal = 1;
			}else if(num == 4){
				cal = 0;
			}else if(num == 5){
				cal = 1;
			}else if(num == 6){
				cal = 2;
			}else if(num == 7){
				cal = 3;
			}
			
			System.err.println(temp1+ " "+temp2);
			if(num>0&&num<4){
				map.put(temp1, cal);
				map.put(temp2, 0);

			}else if(num>4&&num<8){
				map.put(temp2, cal);
				map.put(temp1, 0);
			}
		}

		System.err.println(map);

		StringBuffer sb = new StringBuffer();
		if(map.get("R") > map.get("T")){
			sb.append("R");
		}else if(map.get("R") < map.get("T")){
			sb.append("T");
		}else if(map.get("R") == map.get("T")){
			sb.append("R");
		}

		if(map.get("C") > map.get("F")){
			sb.append("C");
		}else if(map.get("C") < map.get("F")){
			sb.append("F");
		}else if(map.get("C") == map.get("F")){
			sb.append("C");
		}

		if(map.get("J") > map.get("M")){
			sb.append("J");
		}else if(map.get("J") < map.get("M")){
			sb.append("M");
		}else if(map.get("J") == map.get("M")){
			sb.append("J");
		}

		if(map.get("A") > map.get("N")){
			sb.append("A");
		}else if(map.get("A") < map.get("N")){
			sb.append("N");
		}else if(map.get("A") == map.get("N")){
			sb.append("A");
		}
		
		System.err.println("sb = "+sb);
	}

	public static void lv1_14(){ //신고결과 받기
		System.err.println("lv1_14");
		String[] id_list = {"m","f","a","n"};
		String[] report = {"m f","a f","f n","m n","a m"};
		int k =2;
		LinkedHashMap<String,Set<String>> map = new LinkedHashMap<>();
		LinkedHashMap<String,Integer> countMap = new LinkedHashMap<>();

		for(int i=0; i<id_list.length; i++){
			String id = id_list[i];
			Set<String> set = new HashSet<>();
			int count=0;
			for(int j=0; j<report.length; j++){
				String[] temp = report[j].split(" ");
				if(id.equals(temp[0])){
					System.err.println(temp[0]+" "+temp[1]);
					set.add(temp[1]);
				}

				if(id.equals(temp[1])){
					count++;
				}
			}
			map.put(id, set);
			countMap.put(id, count);
		}

		System.err.println("map = "+map);
		System.err.println("countMap = "+countMap);
		int[] result = new int[map.entrySet().size()];
		int mapcont=0;
		for(Entry<String, Set<String>> entry:map.entrySet()){
            //System.err.println(entry.getKey()+" "+entry.getValue());
			int count=0;
			for(Entry<String,Integer> entry2:countMap.entrySet()){
				if(entry2.getValue() >= k){
					//System.err.println("entry2 = "+entry2);
					for(String set:entry.getValue()){
						//System.err.println("set= "+set);
						if(set.equals(entry2.getKey())){
							count++;
						}
					}
				}
			}
			result[mapcont] = count;
			mapcont++;
			System.err.println("count = "+count); 
        }

		for(int i:result){
			System.err.println(i);
		}
	 }

	 public static void lv1_15(){ //나머지가 1이 되는 숫자
		System.err.println("lv1_15");
		int n = 12;
		List<Integer> list = new ArrayList<>();
		for(int i=1; i<=n; i++){
			if(n%i==1){
				System.err.println(i);
				list.add(i);
			}
		}

		int min = list.stream().mapToInt(Integer::intValue).min().getAsInt();

		System.err.println("min = "+min);
	 }

	 public static void lv1_16(){ //최소 직사각형
		System.err.println("lv1_16");
	 }

	 public static void lv1_17(){ //없는 숫자 더하기
		System.err.println("lv1_17");
		int[] numbers = {1,2,3,4,6,7,8,0};
		Arrays.sort(numbers);
		int sum=0;
		for(int i=0; i<10; i++){
			boolean chk = false;
			for(int j:numbers){
				if(i==j){
					chk = true;
					break;
				}
			}
			if(!chk){
				sum+=i;
			}
		}

		System.err.println("sum = "+sum);
	 }

	 public static void lv1_18(){ //부족한 금액 계산하기
		System.err.println("lv1_18");
		int price =3;
		int money = 20;
		int count = 4;
		int sum=0;
		for(int i=1; i<=count; i++){
			System.err.println(price*i);
			sum+=price*i;
		}

		System.err.println("sum = "+sum);
		
		if(sum-money > 0){
			System.err.println(sum-money);
		}else{
			System.err.println(0);
		}
	 }

	 public static void lv1_19(){ //숫자 문자열과 영단어
		System.err.println("lv1_19");
		String s ="one4seveneight";

		HashMap<Integer,String> map = new HashMap<>();
		map.put(0, "zero");
		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");
		map.put(4, "four");
		map.put(5, "five");
		map.put(6, "six");
		map.put(7, "seven");
		map.put(8, "eight");
		map.put(9, "nine");

		for(Entry<Integer,String> entry:map.entrySet()){
			if(s.contains(entry.getValue())){
				s = s.replace(entry.getValue(), Integer.toString(entry.getKey()));
			}
		}

		System.err.println(s);
	 }
	 public static void lv1_20(){ //약수의 개수와 덧셈
		System.err.println("lv1_20");
		int left = 13;
		int rigth = 17;
		int sum =0;
		for(int i=left; i<=rigth; i++){
			//System.err.println("i = "+i);
			int count=0;
			for(int j=1; j<=i; j++){
				if(i%j==0){
					count++;
					//System.err.println("i = "+i+" j = "+j);
				}
			}
			//System.err.println("count = "+count);
			if(count%2==0){
				sum+=i;
			}else{
				sum-=i;
			}
		}

		System.err.println(sum);
	 }

	 public static void lv1_21(){ //로또의 최고 순위와 최저 순위
		System.err.println("lv1_21");
		int[] lottos = {44,1,0,0,31,25};
		int[] win_nums = {31,10,45,1,6,19};
		int zero_cnt=0;
		int cnt=0;
		for(int i:lottos){
			if(i!=0){
				for(int j:win_nums){
					if(i==j){
						cnt++;
						break;
					}
				}
			}else{
				zero_cnt++;
			}
		}

		System.err.println("cnt = "+cnt+" zero_cnt ="+zero_cnt);
		int[] result = new int[2];
		result[0] = lv1_21_1(cnt+zero_cnt);
		result[1] = lv1_21_1(cnt);

		for(int i:result){
			System.err.println(i);
		}
		
	 }

	 public static int lv1_21_1(int score){
		int result=6;
		if(score==6){
			result=1;
		}else if(score==5){
			result=2;
		}else if(score==4){
			result=3;
		}else if(score==3){
			result=4;
		}else if(score==2){
			result=5;
		}
		return result;
	 }

	public static void lv1_22(){ //음양 더하기
		System.err.println("lv1_22");
		int[] absolutes = {4,7,12};
		boolean[] signs = {true,false,true};

		int sum=0;
		for(int i=0; i<absolutes.length; i++){
			if(signs[i]){
				sum+=absolutes[i];
			}else{
				sum+=(absolutes[i]*-1);
			}
		}
		System.err.println("sum = "+sum);
	}

	public static void lv1_23(){ //신규 아이디 추천
		System.err.println("lv1_23");
		String new_id = "...!@BaT#*..y.abcdefghijklm";
		System.err.println(new_id);
		new_id = new_id.toLowerCase();

		char[] cArr = new_id.toCharArray();

		for(char c:cArr){
			if(!Character.isDigit(c)
				&&!Character.isLowerCase(c)
				&&c!='-'
				&&c!='_'
				&&c!='.') {
				System.err.println(c);
				new_id = new_id.replace(String.valueOf(c), "");
			}
		}

		while(new_id.contains("..")){
			new_id = new_id.replace("..", ".");
		}

		if(new_id.substring(0, 1).equals(".")){
			new_id = new_id.substring(1, new_id.length());
		}

		if(new_id.substring(new_id.length()-1, new_id.length()).equals(".")){
			new_id = new_id.substring(0, new_id.length()-1);
		}
		
		if(new_id.equals("")){
			new_id="a";
		}

		if(new_id.length() >= 16){
			new_id = new_id.substring(0, 15);
			if(new_id.substring(new_id.length()-1, new_id.length()).equals(".")){
				new_id = new_id.substring(0, new_id.length()-1);
			}
		}

		while(new_id.length() <= 2){
			new_id += new_id.substring(0, new_id.length()-1);
		}
		
		System.err.println(new_id);

	}

	public static void lv1_24(){ //내적
		System.err.println("lv1_24");
		int[] a = {1,2,3,4};
		int[] b = {-3,-1,0,2};
		int sum=0;
		for(int i=0; i< a.length; i++){
			sum+=a[i]*b[i];
		}

		System.err.println(sum);
	}

	public static void lv1_25(){ //3진법 뒤집기
		System.err.println("lv1_25");
		int n=45;
		System.out.println(Integer.toString(n,3));
		StringBuilder sb = new StringBuilder(Integer.toString(n,3));
		sb.reverse();
		System.out.println(sb);
		int temp = Integer.parseInt(String.valueOf(sb),3);
		System.err.println(temp);

	}

	public static void lv1_26(){ //두개 뽑아서 더하기
		System.err.println("lv1_25");
		Set<Integer> temp = new HashSet<>();
		//int[] numbers = {2,1,3,4,1};
		int[] numbers = {5,0,2,7};
		for(int i=0; i<numbers.length; i++){
			for(int j=i+1; j<numbers.length; j++){
				temp.add(numbers[i]+numbers[j]);
			}
		}

		System.err.println("temp= "+temp);

		List<Integer> templist = new ArrayList<>(temp);

		Collections.sort(templist,Collections.reverseOrder());

		System.err.println("templist= "+templist);

	}

	public static void lv1_27(){ //키패드 누르기
		System.err.println("lv1_27");
		HashMap<String,String> hand = new HashMap<>();
		hand.put("left","*");
		hand.put("rigth","#");

		int[] numbers = {1,3,4,5,8,2,1,4,5,9,5};
		String handType = "right";

		HashMap<String,HashMap<String,Integer>> pad = new HashMap<>();
		HashMap<String,Integer> padXy = new HashMap<>();
		padXy.put("X", 0);
		padXy.put("Y", 0);
		pad.put("1",padXy);

		padXy = new HashMap<>();
		padXy.put("X", 0);
		padXy.put("Y", 1);
		pad.put("2",padXy);

		padXy = new HashMap<>();
		padXy.put("X", 0);
		padXy.put("Y", 2);
		pad.put("3",padXy);
		
		padXy = new HashMap<>();
		padXy.put("X", 1);
		padXy.put("Y", 0);
		pad.put("4",padXy);

		padXy = new HashMap<>();
		padXy.put("X", 1);
		padXy.put("Y", 1);
		pad.put("5",padXy);

		padXy = new HashMap<>();
		padXy.put("X", 1);
		padXy.put("Y", 2);
		pad.put("6",padXy);

		padXy = new HashMap<>();
		padXy.put("X", 2);
		padXy.put("Y", 0);
		pad.put("7",padXy);

		padXy = new HashMap<>();
		padXy.put("X", 2);
		padXy.put("Y", 1);
		pad.put("8",padXy);

		padXy = new HashMap<>();
		padXy.put("X", 2);
		padXy.put("Y", 2);
		pad.put("9",padXy);

		padXy = new HashMap<>();
		padXy.put("X", 3);
		padXy.put("Y", 0);
		pad.put("*",padXy);

		padXy = new HashMap<>();
		padXy.put("X", 3);
		padXy.put("Y", 1);
		pad.put("0",padXy);


		padXy = new HashMap<>();
		padXy.put("X", 3);
		padXy.put("Y", 2);
		pad.put("#",padXy);
		
		StringBuffer sb = new StringBuffer();
		for(int i:numbers){
			if(i==1||i==4||i==7){ // L
				sb.append("L");
				hand.put("left", Integer.toString(i));
			}else if(i==3||i==6||i==9){ // R
				sb.append("R");
				hand.put("rigth", Integer.toString(i));
			}else{
				
				HashMap<String,Integer> nowMap = pad.get(Integer.toString(i)); //현재 누른 값
				HashMap<String,Integer> leftMap = pad.get(hand.get("left"));
				HashMap<String,Integer> rigthMap = pad.get(hand.get("rigth"));
				
				int nowX = nowMap.get("X");
				int nowY = nowMap.get("Y");

				int leftX = leftMap.get("X");
				int leftY = leftMap.get("Y");
				
				int rigthX = rigthMap.get("X");
				int rigthY = rigthMap.get("Y");
				
				//System.err.println("i = "+i +" nowX = "+nowX+" nowY= "+nowY);
				//System.err.println("hand left = "+hand.get("left")+" leftX = "+leftX+" leftY = "+leftY);
				//System.err.println("hand rigth = "+hand.get("rigth")+" rigthX = "+rigthX+" rigthY = "+rigthY);

				int tempLeftX = nowX - leftX;
				int tempLeftY = nowY - leftY;

				int tempRigthX = nowX - rigthX;
				int tempRigthY = nowY - rigthY;

				//System.err.println("tempLeftX = "+tempLeftX+" tempLeftY = "+tempLeftY);
				//System.err.println("tempRigthX = "+tempRigthX+" tempLeftY = "+tempRigthY);
				
				int sumLeft = Math.abs(tempLeftX) + Math.abs(tempLeftY);
				int sumRigth = Math.abs(tempRigthX) + Math.abs(tempRigthY);

				//System.err.println("sumLeft = "+sumLeft+" sumRigth = "+sumRigth);
				
				if(sumLeft > sumRigth){
					sb.append("R");
					hand.put("rigth", Integer.toString(i));
				}else if(sumLeft < sumRigth){
					sb.append("L");
					hand.put("left", Integer.toString(i));
				}else if(sumLeft == sumRigth){
					if(handType.equals("right")){
						sb.append("R");
						hand.put("rigth", Integer.toString(i));
					}else{
						sb.append("L");
						hand.put("left", Integer.toString(i));
					}
				}				
			}
		}
		System.err.println("sb = "+sb);
	}

	public static void lv1_28(){ //크레인 인형뽑기 게임
		System.err.println("lv1_28");
		int[][] board = {{0,0,0,0,0}
		                ,{0,0,1,0,3}
					    ,{0,2,5,0,1}
						,{4,2,4,4,2}
						,{3,5,1,3,1}};

		int[] move = {1,5,3,5,1,2,1,4};
		//Queue<Integer> queue = new LinkedList<>(); //가장 먼저 넣은 데이터를 가장 먼저 꺼낼수 있는 구조
		Stack<Integer> stack = new Stack<>(); // 가장 늦게 들어간 데이터를 먼저 꺼낼수 있는 구조
		int cnt=0;
		for(int i:move){
			System.err.println("i = "+(i-1));
			for(int j=0; j<board.length; j++){
				System.err.println("j = "+board[j][(i-1)]);
				if(board[j][(i-1)] != 0){
					int temp = board[j][(i-1)];
					System.err.println("stack = "+stack);
					System.err.println("stack size= "+stack.size());
					if(stack.size()>1){
						int peek = stack.peek();
						System.err.println("peek = "+peek);
						if(temp != peek){
							stack.push(temp);
						}else{
							stack.pop();
							cnt+=2;
						}
					}else{
						stack.push(temp);
					}


					board[j][(i-1)] = 0;
					break;
				}
			}
		}

		//[4, 3, 1, 1, 3, 2, 4]
		System.err.println("stack = "+stack);
		System.err.println("cnt = "+cnt);
			
	}

	public static void lv1_29(){ //실패율
		System.err.println("lv1_29");
		int[] stages = {2,1,2,6,2,4,3,3};
		int n=5;
		Arrays.sort(stages);

		HashMap<Integer,Double> map = new HashMap<>();
		
		System.err.println("stages.length = "+stages.length);

		for(int i=1; i<=n; i++){
			int count1=0;
			int count2=0;
			for(int j=0; j<stages.length; j++){
				System.err.println("i = "+i+" j = "+j+" stages[j] = "+stages[j]);
				if(i>=stages[j]&& i<=stages[j]){
					count1++;
				}
				if(i<=stages[j]){
					count2++;
				}
			}
			System.err.println("count = "+count1+ " count2 = "+count2);

			Double result=0.0;
			if(count1==0 || count2==0){
				result=0.0;
			}else{
				result=(double)count1/count2;
			}
			
			System.err.println((double)count1/count2);
			map.put(i,result);
		}

		System.err.println(map);

		List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));
		
		int[] iArr = list.stream().mapToInt(Integer::intValue).toArray();

		for(int i:iArr){
			System.err.println(i);
		}
	}

	public static void lv1_30(){ //체육복
		System.err.println("lv1_30");
		int n =3;
		//int[] lost = {2,4};
		//int[] reserve = {1,3,5};
		int[] lost = {3};
		int[] reserve = {1};
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i=1; i<=n; i++){
			boolean chk = false;
			for(int j=0; j<lost.length; j++){
				if(i==lost[j]){
					chk=true;
					break;
				}
			}

			if(chk){
				System.err.println(i);
				List<Integer> temp = new ArrayList<>();
				for(int j=0; j<reserve.length; j++){
					if(i == reserve[j] ||i == reserve[j]-1 || i == reserve[j]+1){
						temp.add(reserve[j]);
					}
				}

				if(!temp.isEmpty()){
					int min = temp.stream().mapToInt(Integer::intValue).min().getAsInt();
					for(int j=0; j<reserve.length; j++){
						if(reserve[j]==min){
							reserve[j] = 100000;
						}
					}
					map.put(i,min);
				}else{
					map.put(i,-1);
				}
			}else{
				map.put(i,0);
			}
		}

		System.err.println("map = "+map);
		int count=0;
		for(HashMap.Entry<Integer,Integer> m:map.entrySet()){
			if(m.getValue() > -1){
				count++;
			}
		}

		System.err.println("count = "+count);
	}

	public static void lv1_31(){ //모의고사
		System.err.println("lv1_31");
		int[] answers = {1,2,3,4,5,1,2,3,4,5};
		int[] one =     {1,2,3,4,5};
		int[] two =     {2,1,2,3,2,4,2,5};
		int[] thee =    {3,3,1,1,2,2,4,4,5,5};
		int oneCount=0;
		int twoCount=0;
		int theeCount=0;
		for(int i=0; i<answers.length; i++){
			int tempOne =0;
			int tempTwo =0;
			int tempthee =0;
			
			if(i >= one.length){
				System.err.println(i+" i/one.length = "+i%one.length);
				tempOne = i%one.length;
			}else{
				tempOne = i;
			}

			if(answers[i] == one[tempOne]){
				oneCount++;
			}

			if(i >= two.length){
				System.err.println(i+" i/two.length = "+i%two.length);
				tempTwo = i%two.length;
			}else{
				tempTwo = i;
			}

			if(answers[i] == two[tempTwo]){
				twoCount++;
			}

			if(i >= thee.length){
				System.err.println(i+" i/thee.length = "+i%thee.length);
				tempthee = i%thee.length;
			}else{
				tempthee = i;
			}

			if(answers[i] == thee[tempthee]){
				theeCount++;
			}
		}

		// System.err.println(oneCount);
		// System.err.println(twoCount);
		// System.err.println(theeCount);

		if(oneCount > twoCount){
			if(oneCount > theeCount){
				System.err.println(1);
			}else{
				System.err.println(3);
			}
		}else{
			if(twoCount > theeCount){
				System.err.println(2);
			}else{
				System.err.println(3);
			}
		}
	}

	public static void lv1_32(){ //K번째수
		System.err.println("lv1_32");
		int[] array = {1,5,2,6,3,7,4};

		int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
		int arrCnt = commands.length;
		int[] reulst = new int[arrCnt];
		int cnt=0;

		for(int[] i:commands){
			int[] temp = i;
			int[] tempArr = new int[temp[1]-temp[0]+1];
			
			System.err.println("temp[0]-1 "+(temp[0]-1));
			System.err.println("temp[1]-1 "+(temp[1]-1));

			tempArr = Arrays.copyOfRange(array, (temp[0]-1), (temp[1]));
			
			for(int j:tempArr){
				System.err.println("j= "+j);
			}

			Arrays.sort(tempArr);

			for(int j:tempArr){
				System.err.println("tempArr = "+j);
			}

			System.err.println("num ="+tempArr[temp[2]-1]);
			reulst[cnt] = tempArr[temp[2]-1];
			cnt++;
		}

		for(int j:reulst){
			System.err.println("reulst = "+j);
		}
	}

	public static void lv1_33(){ //완주하지 못한 선수
		System.err.println("lv1_33");
		// String[] participant = {"leo","kiki","eden"};
		// String[] completion = {"eden","kiki"};
		String[] participant = {"m","s","m","a"};
		String[] completion = {"s","a","m"};

		for(int i=0; i<participant.length; i++){
			for(int j=0; j<completion.length; j++){
				if(participant[i]==completion[j]){
					participant[i]="X";
					completion[j] = "Y";
					break;
				}
			}
		}

		for(int i=0; i<participant.length; i++){
			if(!participant[i].equals("X")){
				System.err.println("participant = "+participant[i]);
			}
		}

		for(int j=0; j<completion.length; j++){
			System.err.println("completion = "+completion[j]);
		}
	}

	public static void lv1_34(){ //다트게임
		System.err.println("lv1_34");

		//String dartResult ="1S2D*3T";
		String dartResult ="1D2S#10S";
		char[] cArr = dartResult.toCharArray();

		HashMap<Integer,Integer> map = new HashMap<>();
		int intCnt = 0;
		for(int i=0; i<cArr.length; i++){
			char c = cArr[i];
			if(Character.isDigit(c)){ //숫자일경우 list에 담는다.
				//System.err.println(c);
				if(i>0){
					char cTemp = cArr[i-1];
					if(Character.isDigit(cTemp)){
						String  sTemp1 = cArr[i-1]+"";
						String  sTemp2 = cArr[i]+"";
						int intTemp = Integer.parseInt(sTemp1+sTemp2);
						//System.err.println(" intTemp = "+intTemp);
						//System.err.println(" intCnt = "+intCnt);
						map.put(intCnt-1,intTemp);
					}else{
						map.put(intCnt,Character.getNumericValue(c));
						intCnt++; // 숫자 카운트	
					}
				}else{
					map.put(intCnt,Character.getNumericValue(c));
					intCnt++; // 숫자 카운트
				}
			}else{ //숫자가 아닌경우 계산
				System.err.println("intCnt = "+intCnt+ " c = "+c);
				if(c == 'S'){
					//System.err.println("S intCnt = "+intCnt);
					//System.err.println("S map  = "+map);
					int temp = map.get(intCnt-1);
					//System.err.println("S temp 1= "+temp);
					temp = temp * 1;
					//System.err.println("S temp 2= "+temp);
					map.put(intCnt-1, temp);
				}else if(c == 'D'){
					//System.err.println("D intCnt = "+intCnt);
					//System.err.println("D map  = "+map);
					int temp = map.get(intCnt-1);
					//System.err.println("D temp 1= "+temp);
					temp = temp * temp;
					//System.err.println("D temp 2= "+temp);
					map.put(intCnt-1, temp);
				}else if(c == 'T'){
					int temp = map.get(intCnt-1);
					temp = temp * temp* temp;
					map.put(intCnt-1, temp);
				}else if(c == '*'){
					//System.err.println("* intCnt = "+intCnt);
					if(intCnt >= 2){
						int temp = map.get(intCnt-1);
						int temp2 = map.get(intCnt-2);
						//System.err.println("* temp 1= "+temp);
						//System.err.println("* temp2 1= "+temp2);
						temp = temp * 2;
						temp2 = temp2 * 2;
						//System.err.println("* temp 2= "+temp);
						//System.err.println("* temp2 2= "+temp2);
						map.put(intCnt-1, temp);
						map.put(intCnt-2, temp2);
					}else{
						int temp = map.get(intCnt-1);
						temp = temp * temp;
						map.put(intCnt-1, temp);
					}
				}else if(c == '#'){
					int temp = map.get(intCnt-1);
					temp = temp * -1;
					map.put(intCnt-1, temp);
				}
			}
		}

		int sum=0;
		for(int i=0; i<map.size();i++){
			System.err.println(map.get(i));
			sum+=map.get(i);
		}

		System.err.println("sum = "+sum);
	}

	public static void lv1_35(){ //비밀지도
		System.err.println("lv1_35");
		int n=5;

		int[] arr1={9,20,28,18,11};
		int[] arr2={30,1,21,17,28};

		List<String> list1 = new ArrayList<>();
		List<String> list2 = new ArrayList<>();
		for(int i=0; i<arr1.length; i++){
			String temp = lv1_35_1(arr1[i],n);
			//System.err.println(" temp= "+temp);
			list1.add(temp);
		}
		
		for(int i=0; i<arr2.length; i++){
			String temp = lv1_35_1(arr2[i],n);
			//System.err.println(" temp= "+temp);
			list2.add(temp);
		}

		// for(int i=0; i<list1.size(); i++){
		// 	System.err.println(" temp= "+list1.get(i));
		// }
		// System.err.println("");
		// for(int i=0; i<list2.size(); i++){
		// 	System.err.println(" temp= "+list2.get(i));
		// }

		List<String> result = new ArrayList<>();
		for(int i=0; i<list1.size(); i++){
			String temp1 = list1.get(i);
			String temp2 = list2.get(i);
			//System.err.println(" list1 str = "+temp1);
			//System.err.println(" list2 str = "+temp2);
			
			char[] temp1Arr = temp1.toCharArray();
			char[] temp2Arr = temp2.toCharArray();
			String strTemp="";
			for(int j=0; j<temp1Arr.length; j++){
				if(temp1Arr[j]=='0'&&temp2Arr[j]=='0'){
					strTemp+=" ";
				}else{
					strTemp+="#";
				}
			}
			//System.err.println(strTemp);
			result.add(strTemp);
		}

		System.err.println("result = "+result);
	}

	public static String lv1_35_1(int num,int n){
		//System.err.println("num = "+num);
		String str =Integer.toBinaryString(num);
		//System.err.println("str = "+str);
		String temp="";
		for(int i=0; i<n-str.length();i++){
			temp+="0";
		}
		return temp+str;
	}

	public static void lv1_36(){ //예산
		System.err.println("lv1_36");
		int[] d= {1,3,2,5,4};
		int dudget =9;
		Arrays.sort(d);
		int count=0;
		for(int i=0; i<d.length; i++){
			if(dudget >= d[i]){
				dudget = dudget - d[i];
				count++;
			}else{
				break;
			}
		}

		System.err.println("count= "+count);
	}

	public static void lv1_37(){ //소수 만들기
		System.err.println("lv1_37");
		//int[] num = {1,2,3,4};
		int[] num = {1,2,7,6,4};
		Arrays.sort(num);

		int cnt=0;
		for(int i=0; i<num.length; i++){
			for(int j=i+1; j<num.length; j++){
				for(int k=j+1; k<num.length; k++ ){
					int temp = num[i]+num[i]+num[k];
					if(temp%2==0){
						cnt++;
					}
				}
			}
		}

		System.err.println("cnt = "+cnt);
	}

	public static void lv1_38(){ //직사각형 별찍기
		System.err.println("lv1_38");
		int n=5;
		int m=3;
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				System.err.print("*");
			}
			System.err.println("");
		}
	}

	public static void lv1_39(){ //x만큼 간격이 있는 n개의 숫자
		System.err.println("lv1_39");
		// int x =2;
		// int n=5;
		int x = 4;
		int n = 3;
		int[] result = new int[n];
		int temp=0;
		for(int i=0; i<n; i++){
			//list.add(temp+=x);
			result[i] = temp+=x;
			//temp+=x;
		}

		for(int i=0; i<result.length; i++){
			System.err.println(result[i]);
		}
	}
}
