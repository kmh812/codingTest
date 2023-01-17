
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class CodingTest_Lv2 {
    public static void main(String[] args) throws Exception {
        //lv2_1(); 
		//lv2_2();
		//lv2_3();
		//lv2_4();
		//lv2_5();
		//lv2_6();
		//lv2_7();
		// lv2_8();
		// lv2_9();
		// lv2_10();
		// lv2_11();
		// lv2_12();
		// lv2_13();
		// lv2_14();
		// lv2_15();
		// lv2_16();
		// lv2_17();
		// lv2_18();
		// lv2_19();
		// lv2_20();
		// lv2_21();
		lv2_22();
		lv2_24();
		lv2_25();
		lv2_26();
    }

	public static void lv2_1() { //택배 배달과 수거하기
		System.err.println("lv2_1");
		// int cap =4;
		// int n =5;
		// int[] deliveries = {1,0,3,1,2};
		// int[] pickups =    {0,3,0,4,0};
		int cap =2;
		int n =7;
		int[] deliveries = {1,0,2,0,1,0,2};
		int[] pickups =    {0,2,0,1,0,2,0};
		int deliveriesSum=0;
		int pickupsSum=0;
		for(int i=deliveries.length-1; i>=0 ; i--){
			int deliverieCap = cap;
			int deliverieMax = 0;
			for(int j=deliveries.length-1; j>=0 ; j--){
				int deliverie = deliveries[j];
				if(deliverie>0){
					if(deliverieMax < j){
						deliverieMax = (j+1);
					}
					System.err.println("i = "+i+" j = "+j+" deliverie = "+deliverie+" deliverieCap = "+deliverieCap);	
					if(deliverieCap-deliverie >= 0){
						deliverieCap-=deliverie;
						deliveries[j] = 0;
					}else{
						break;
					}
				}
			}

			int pickupCap = cap;
			int pickupMax = deliverieMax;
			for(int j=deliverieMax-1; j>=0 ; j--){
				int pickup = pickups[j];
				if(pickup>0){
					System.err.println("i = "+i+" j = "+j+" pickup = "+pickup+" pickupCap = "+pickupCap);	
					if(pickupCap-pickup >= 0){
						pickupCap-=pickup;
						pickups[j] = 0;
					}else{
						break;
					}
				}
			}
			System.err.println("deliverieMax = "+deliverieMax);
			System.err.println("pickupMax = "+pickupMax);

			deliveriesSum+=deliverieMax;
			pickupsSum+=pickupMax;
		}

		System.err.println("deliveriesSum = "+deliveriesSum+" pickupsSum = "+pickupsSum);
		System.err.println("total = "+(deliveriesSum+pickupsSum));
		
	}

	private static int[] lv2_2_answer = {0,0};
	private static int[] lv2_2_discounts;
	private static int lv2_2_maxDiscount = 10;
	private static int lv2_2_minDiscount = 40;

	public static void lv2_2() { //이모티콘 할인 행사
		System.err.println("!!!!!!!!!!!!! lv2_2 !!!!!!!!!!!!!!!");
		int[][] users = {{40,10000},{25,10000}};
        int[] emoticons = {7000,9000};
        //int[] per ={10,20,30,40};

		//최고 할인률과 최저 할인률을 구한다.
		for(int i = 0; i < users.length; i++) {
    		int cur = ((int)Math.ceil(users[i][0]/10.0))*10;
    		if(cur < lv2_2_minDiscount) {
    			lv2_2_minDiscount = cur;
    		}
    		
    		if(cur > lv2_2_maxDiscount) {
    			lv2_2_maxDiscount = cur;
    		}
    	}
    	

		//최저 할인율과 최고 할인률을 배열에 넣는다.
    	lv2_2_discounts = new int[(lv2_2_maxDiscount-lv2_2_minDiscount)/10+1];
    	int cur = lv2_2_minDiscount;
    	for(int i = 0; i < lv2_2_discounts.length; i++) {
    		lv2_2_discounts[i] = cur;
    		cur+=10;
    	}


		//def알고리즘 시작
    	lv2_2_dfs(0,new int[emoticons.length],users,emoticons);
		//  int[][] discountArr = {{30,30},{30,40},{40,30},{40,40}};
		// for(int[] i:discountArr){
		// 	lv2_2_dfs(i,users,emoticons);
		// }

        for(int i:lv2_2_answer){
			System.err.println(i);
		}
	}

	private static void lv2_2_dfs(int depth,int[] discount,int[][] users, int[] emoticons) {
		//이모티콘 가격 갯수와 깊이가 같은지 확인
		if(depth == emoticons.length) {
			int user = 0;
			int cost = 0;
			for(int i = 0; i < users.length; i++) {
				int curCost = 0;
				for(int j = 0; j < emoticons.length; j++) {
					if(users[i][0] <= discount[j]) {
						curCost += emoticons[j]*(100-discount[j])/100;
					}
				}
				if(users[i][1] <= curCost) {
					user++;
				}else {
					cost+=curCost;
				}
			}

			if(user > lv2_2_answer[0]) {
				lv2_2_answer[0] = user;
				lv2_2_answer[1] = cost;
			}else if(user == lv2_2_answer[0] && cost > lv2_2_answer[1]) {
				lv2_2_answer[1] = cost;
			}

			return;
		}

		for(int i = 0; i < lv2_2_discounts.length; i++) {
			discount[depth] = lv2_2_discounts[i];
			lv2_2_dfs(depth+1,discount,users,emoticons);
		}
	}

	static int lv2_3_answer = 0;
	public static void lv2_3() { //타켓넘버
		System.err.println("!!!!!!!!!!!!! lv2_3 !!!!!!!!!!!!!!!");
		int[] numbers = {1,1,1,1,1};
		int target = 3;
		int depth =0;
		int sum =0;
		lv2_3_def(depth, numbers, target, sum);
		System.err.println(" lv2_3_answer = "+lv2_3_answer);
	}

	public static void lv2_3_def(int depth, int[] numbers, int target, int sum) { //타켓넘버 재귀
		if(depth == numbers.length){
			if(target == sum){ 
				lv2_3_answer++;
			}
		}else{
			lv2_3_def(depth + 1, numbers, target, sum + numbers[depth]); // 해당 노드의 값을 더하고 다음 깊이 탐색
			lv2_3_def(depth + 1, numbers, target, sum - numbers[depth]); // 해당 노드의 값을 빼고 다음 깊이 탐색
		}
	}

	public static void lv2_4() { //마법의 엘리베이터
		System.err.println("!!!!!!!!!!!!! lv2_4 !!!!!!!!!!!!!!!");
		int storey = 16;

		char[] arr = Integer.toString(storey).toCharArray();
		int cnt=0;
		int up=0;
		for(int i=arr.length-1; i>=0; i--){
			int num = Character.getNumericValue(arr[i]);
			if(up>0){
				num=num+up;
				up--;
			}

			if(num <= 5){
				cnt+=num;
			}else{
				cnt+=10-num;
				up+=1;
			}
		}

		System.err.println("cnt ="+cnt);
	}

	public static void lv2_5() { //유사 칸토어 비트열 ?? 몬소린지 모르겠다 ㅎ
		System.err.println("!!!!!!!!!!!!! lv2_5 !!!!!!!!!!!!!!!");

	}

	public static void lv2_6() { //테이블 해시 함수
		System.err.println("!!!!!!!!!!!!! lv2_6 !!!!!!!!!!!!!!!");
		int[][] data = {{2,2,6},{1,5,10},{4,2,9,},{3,8,3}};
		int col=2;

		Arrays.sort(data , (o1,o2) -> {
			return o1[col-1]!=o2[col-1] ? o1[col-1]-o2[col-1] : o2[0] - o1[0];
		});

		int sum =0;
		for(int i=2; i<=3; i++){
			int[] temp = data[i-1];
			System.err.println(temp[0] % i);
			System.err.println(temp[1] % i);
			System.err.println(temp[2] % i);
			sum+=(temp[0] % i)+(temp[1] % i)+(temp[2] % i);
		}

		System.err.println("sum ="+sum);
	}

	public static void lv2_7() { //디펜스 게임
		System.err.println("!!!!!!!!!!!!! lv2_7 !!!!!!!!!!!!!!!");
		int n =7;
		int k=3;
		int[] enemy = {4,2,4,5,3,3,1};

		int sum =0;
		for(int i=0; i<enemy.length; i++){
			sum+=enemy[i];
		}
		int avg = sum / enemy.length;

		System.err.println("avg = "+avg);

		int cnt=0;
		for(int i=0; i<enemy.length; i++){
			if(enemy[i] > avg){
				if(k>0){
					k--;
				}else{
					if(enemy[i] > n){
						cnt =i;
						break;
					}
					n-=enemy[i];	
				}
			}else{
				if(enemy[i] > n){
					cnt =i;
					break;
				}
				n-=enemy[i];
			}
		}

		System.err.println("cnt = "+cnt);
	}

	public static void lv2_8() { //점찍기
		System.err.println("!!!!!!!!!!!!! lv2_8 !!!!!!!!!!!!!!!");
		int k = 2;
		int d = 4;

		int cnt=0;
		for(int i=0; i<=d; i=i+k){
			for(int j=0; j<=d; j=j+k){
				if(i+j <= d){
					System.err.println(i+" "+j);
					cnt++;
				}
			}
		}

		System.err.println("cnt = "+cnt);
	}

	public static void lv2_9() { //귤고르기
		System.err.println("!!!!!!!!!!!!! lv2_9 !!!!!!!!!!!!!!!");
		int k =6;

		int[] tangerine={1,3,2,5,4,5,2,3};
		
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i=0; i<tangerine.length; i++){
			int cnt =0;
			for(int j=0; j<tangerine.length; j++){
				if(tangerine[i] == tangerine[j]){
					cnt++;
				}
			}
			map.put(tangerine[i], cnt);
		}

		System.err.println(map);


		List<HashMap.Entry<Integer,Integer>> entrys4 = new ArrayList<>(map.entrySet());

        entrys4.sort(new Comparator<HashMap.Entry<Integer,Integer>>() {
            @Override
            public int compare(HashMap.Entry<Integer,Integer> o1, HashMap.Entry<Integer,Integer> o2) {
                if(o1.getValue() == o2.getValue()){
                    return o2.getKey() - o1.getKey();
                }
                return o2.getValue() - o1.getValue();
            }
        });

		int cnt=0;
		for(int i=0; i<entrys4.size(); i++){
			System.err.println(entrys4.get(i).getValue());
			
			k-=entrys4.get(i).getValue();
			if(k==0){
				cnt = i+1;
				break;
			}
		}

		System.err.println("cnt = "+cnt);
	}

	public static void lv2_10() { //숫자 카드 나누기
		System.err.println("!!!!!!!!!!!!! lv2_10 !!!!!!!!!!!!!!!");
		int[] arrayA = {10,20};
		int[] arrayB = {5,17};

		Integer maxA = Arrays.stream(arrayA).max().getAsInt();
		Integer maxB = Arrays.stream(arrayB).max().getAsInt();
		int max = 0;
		
		if(maxA > maxB){
			max = maxA;
		}else{
			max = maxB;
		}

		System.err.println("max = "+max);

		int value=0;
		for(int i=1; i<=max; i++){
			int cntA=0;
			for(int j=0; j<arrayA.length; j++){
				if(arrayA[j]%i==0){
					cntA++;
				}
			}

			int cntB=0;
			for(int j=0; j<arrayB.length; j++){
				if(arrayB[j]%i==0){
					cntB++;
				}
			}

			//System.err.println("cntA = "+cntA+" cntB = "+cntB);

			if(cntA == arrayA.length && cntB==0){
				value=i;
			}else if(cntB == arrayB.length && cntA==0){
				value=i;
			}
		}

		System.err.println("value = "+value);		
	}

	public static void lv2_11() { //우박수열 정적분
		System.err.println("!!!!!!!!!!!!! lv2_11 !!!!!!!!!!!!!!!");

	}

	public static void lv2_12() { //롤케이크 자르기
		System.err.println("!!!!!!!!!!!!! lv2_12 !!!!!!!!!!!!!!!");
		int[] topping = {1,2,1,3,1,4,1,2};
		int count=0;
		for(int i=1; i<=topping.length; i++){
			int[] temp1Arr = Arrays.copyOfRange(topping, 0, i);
			int[] temp2Arr = Arrays.copyOfRange(topping, i, topping.length);

			Integer[] temp1ArrInteger = Arrays.stream(temp1Arr).boxed().toArray(Integer[]::new); 
			Integer[] temp2ArrInteger = Arrays.stream(temp2Arr).boxed().toArray(Integer[]::new); 

			HashSet<Integer> hashSet1 = new HashSet<>(Arrays.asList(temp1ArrInteger));
			HashSet<Integer> hashSet2 = new HashSet<>(Arrays.asList(temp2ArrInteger));

			//System.err.println("temp1 = "+hashSet1+" temp2 = "+hashSet2);
			if(hashSet1.size() == hashSet2.size()){
				count++;
			}
		}
		System.err.println("count = "+count);
	}

	public static void lv2_13() { //택배상장
		System.err.println("!!!!!!!!!!!!! lv2_13 !!!!!!!!!!!!!!!");
		int[] order = {4,3,1,2,5};
		//int[] order = {5,4,3,2,1};
		int[] box = new int[order.length];

		for(int i=0; i<order.length; i++){
			box[i] = (i+1);
		}

		int[] tempArr = null;

		int count=0;
		for(int i=0; i<order.length; i++){
			System.err.println(order[i]);
			int temp = order[i];
			if(tempArr != null && tempArr.length > 0){
				int temp2 = tempArr[tempArr.length-1];
				System.err.println("temp2 = "+temp2);
				if(temp != temp2){
					count = i;
					break;
				}
				
				count = (i+1);
			}

			tempArr = Arrays.copyOfRange(box, 0, temp-1);
		}

		System.err.println("count = "+count);
	}

	public static void lv2_14() { //연속 부분 수열 합의 개수
		System.err.println("!!!!!!!!!!!!! lv2_14 !!!!!!!!!!!!!!!");
	}

	public static void lv2_15() { //혼자 놀기의 달인
		System.err.println("!!!!!!!!!!!!! lv2_15 !!!!!!!!!!!!!!!");
		int[] cards = {8,6,3,7,2,5,1,4};

		int num=0;
		int cnt=1;
		List<Integer> list = new ArrayList<>();
		List<List<Integer>> result = new ArrayList<>();
		while(true){

			int temp1 = cards[num];
			System.err.println("num = "+num+" temp1 ="+temp1);

			if(temp1==0){
				if(cnt>2){
					break;
				}else{
					cnt++;
					for(int i=0; i<cards.length; i++){
						if(cards[i]!=0){
							result.add(list);
							list = new ArrayList<>();
							num=i;
							break;
						}
					}
				}
			}else{
				int temp2 = cards[temp1-1];
				System.err.println("temp1-1 = "+(temp1-1)+" temp2 = "+temp2);
				list.add(temp1);
				list.add(temp2);

				if(temp2==0){
					temp2=0;
				}else{
					temp2=temp2-1;;
				}

				cards[num] = 0;
				num = temp2;
			}
		}

		int cnt1 = 0;
		List temp1 = result.get(0);
		for(int i=0; i<temp1.size(); i++){
			System.err.println(temp1.get(i));
			if((int)temp1.get(i) > 0){
				cnt1++;
			}
		}

		int cnt2 = 0;
		List temp2 = result.get(1);
		for(int i=0; i<temp2.size(); i++){
			System.err.println(temp2.get(i));
			if((int)temp2.get(i) > 0){
				cnt2++;
			}
		}

		System.err.println(cnt1*cnt2);
	}

	public static void lv2_16() { //할인행사
		System.err.println("!!!!!!!!!!!!! lv2_16 !!!!!!!!!!!!!!!");

		String[] want = {"banana","apple","rice","pork","pot"};

		int[] number ={3,2,2,2,1};

		String[] discount = {"chicken","apple","apple","banana","rice"
		                    ,"apple","pork","banana","pork","rice"
		                    ,"pot","banana","apple","banana"
	 						};
		
		int totalCnt =0;
		for(int i=0; i<discount.length; i++){
			boolean chk=true;
			int max=discount.length;
			if(i+10 < max){
				max = i+10;
			}
			
			for(int k=0; k<want.length; k++){
				String wantStr = want[k];
				int num = number[k];
				int cnt=0;
				for(int j=i; j<max; j++){
					if(wantStr.equals(discount[j])){
						cnt++;
					}
				}

				if(cnt != num){
					chk = false;
					break;
				}
			}

			if(chk){
				totalCnt++;
			}
		}

		System.err.println("totalCnt = "+totalCnt);		
	}

	public static void lv2_17() { //두 큐 합 같게 만들기
		System.err.println("!!!!!!!!!!!!! lv2_16 !!!!!!!!!!!!!!!");
		int[] q1 = {3,2,7,2};
		int[] q2 = {4,6,5,1};

		Queue<Integer> queue1 = new LinkedList<>();
		Queue<Integer> queue2 = new LinkedList<>();

		for(int i:q1){
			queue1.offer(i);
		}
		for(int i:q2){
			queue2.offer(i);
		}
		
		int q1Sum = lv2_17_1(queue1);
		int q2Sum = lv2_17_1(queue2);

		int avg = (q1Sum+q2Sum)/2;

		int cnt=0;

		while(q1Sum !=avg && q2Sum != avg){
			
			if(cnt>0 && cnt/2 > q1.length){
				cnt = -1;
			}

			if(q1Sum==avg && q2Sum == avg){
				System.err.println(q1Sum);
				System.err.println(q2Sum);
				break;
			}

			int q1Poll = queue1.poll();
			int q2Poll = queue2.poll();

			queue1.offer(q2Poll);
			queue2.offer(q1Poll);

			q1Sum = lv2_17_1(queue1);
			q2Sum = lv2_17_1(queue2);

			System.err.println("q1Sum = "+q1Sum);
			System.err.println("q2Sum = "+q2Sum);

			cnt = cnt+2;
		}

		System.err.println("cnt = "+cnt);
	}
	
	public static int lv2_17_1(Queue<Integer> queue) {
		int sum = 0;
		for(int i:queue){
			sum+=i;
		}
		return sum;
	}

	public static void lv2_18() { // 양궁대회
		System.err.println("!!!!!!!!!!!!! lv2_18 !!!!!!!!!!!!!!!");
		int n=5;
		int[] info = {2,1,1,1,0,0,0,0,0,0,0};

		int max=0;
		int[] result = new int[info.length];
		int[] result2 = new int[info.length];
		for(int i=0; i<info.length; i++){
			for(int j=0; j<info.length; j++){
				int infoTemp = info[j];
				if(i>j){
					result[j]=0;
				}else{
					int temp = n-(infoTemp+1);
					if(temp >= 0){
						result[j]= (infoTemp+1);
						n=n-(infoTemp+1);
					}else{
						result[j] = 0;
					}
				}
			}

			int sum=0;
			for(int o=0; o<result.length; o++){
				if(result[o] > 0){
					if(o==0){
						sum += 10;
					}else if(o==1){
						sum += 9;
					}else if(o==2){
						sum += 8;
					}else if(o==3){
						sum += 7;
					}else if(o==4){
						sum += 6;
					}else if(o==5){
						sum += 5;
					}else if(o==6){
						sum += 4;
					}else if(o==7){
						sum += 3;
					}else if(o==8){
						sum += 2;
					}else if(o==9){
						sum += 1;
					}else if(o==10){
						sum += 0;
					}
				}
			}
			//System.err.println(" sum = "+sum);
			if(sum > max){
				result2 = result.clone();
				max = sum;
			}
			n=5;
		}
		
		int sum = Arrays.stream(result2).sum();

		System.err.println(" max = "+max);
		System.err.println(" sum = "+sum);

		if(sum > 0){
			for(int o=0; o<result2.length; o++){
				System.err.print(" "+result2[o]);
			}
		}else{
			System.err.print(" -1 ");
		}
		System.err.println("");
	}

	public static void lv2_19() throws ParseException { // 주차 요금 계산
		System.err.println("!!!!!!!!!!!!! lv2_19 !!!!!!!!!!!!!!!");
		int[] free  = {180,5000,10,600};

		String[] recoeds = {"05:34 5961 IN"
							,"06:00 0000 IN"
							,"06:34 0000 OUT"
							,"07:59 5961 OUT"
							,"07:59 0148 IN"
							,"18:59 0000 IN"
							,"19:09 0148 OUT"
							,"22:59 5961 IN"
							,"23:00 5961 OUT"
							};
		
		HashMap<String,List<HashMap<String,String>>> map = new HashMap<>();

		for(int i=0; i<recoeds.length; i++){
			String[] str = recoeds[i].split(" ");
			if(!map.containsKey(str[1])){
				List<HashMap<String,String>> temp = new ArrayList<>();
				for(int j=0; j<recoeds.length; j++){
					String[] str2 = recoeds[j].split(" ");
					if(str[1].equals(str2[1])){
						HashMap<String,String> tempMap = new HashMap<>();
						tempMap.put("TIME", str2[0]);
						tempMap.put("INOUT", str2[2]);
						temp.add(tempMap);
					}
				}
				map.put(str[1], temp);
			}
		}

		HashMap<String,Integer> reulst = new HashMap<>();

		for(HashMap.Entry<String,List<HashMap<String,String>>> i: map.entrySet()){
			System.err.println(i.getKey());
			System.err.println(i.getValue());
			String key = i.getKey();
			List<HashMap<String,String>> value = i.getValue();
			List<HashMap<String,String>> value2 = new ArrayList<>();
			
			value2 = value.stream()
				.sorted((o1, o2) -> o1.get("TIME").compareTo(o2.get("TIME")))
				.collect(Collectors.toList())
				;

			int totalmin=0;
			String inTime="";
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
			for(HashMap<String,String> temp2: value2){
				String time = temp2.get("TIME");
				String intout = temp2.get("INOUT");
				if(intout.equals("IN")){
					inTime = time;
				}else{
					Date d1 = sdf.parse(time);
					Date d2 = sdf.parse(inTime);
					long diff = d1.getTime() - d2.getTime();
					long min = diff / 60000;
					totalmin+=min;
					inTime="";
				}
			}

			if(!inTime.equals("")){
				String time = "23:59";
				Date d1 = sdf.parse(time);
				Date d2 = sdf.parse(inTime);
				long diff = d1.getTime() - d2.getTime();
				long min = diff / 60000;
				totalmin+=min;
				inTime="";
			}

			int price=0;
			System.err.println("totalmin = "+totalmin);
			if(totalmin <= free[0]){
				System.err.println("price = "+free[1]);
				price = free[1];
			}else{
				double math = (double)(totalmin-free[0])/ free[2];
				System.err.println("math = "+math);
				
				price = (int) (free[1]+ Math.ceil(math) * free[3]);
				System.err.println("price = "+price);
			}

			reulst.put(key, price);
		}

		System.err.println("reulst = "+reulst);
		
		List<String> list = new ArrayList<>(reulst.keySet());
        list.sort((i1,i2)->i1.compareTo(i2)); //정방향 정렬

		int[] priceArr = new int[list.size()];

        for(int i=0; i<reulst.size(); i++){
			//System.err.println(reulst.get(list.get(i)));
			priceArr[i] = reulst.get(list.get(i));
        }

		for(int i=0; i<priceArr.length; i++){
			System.err.println("priceArr = "+priceArr[i]);
		}
	}

	public static void lv2_20() { // k진수에서 소수 개수 구하기
		System.err.println("!!!!!!!!!!!!! lv2_20 !!!!!!!!!!!!!!!");
		// int n = 437674;
		// int k =3;
		int n = 110011;
		int k = 10;

		String[] strArr;

		if(k > 10){
			strArr = Integer.toString(n,k).split("0");
		}else{
			strArr = Integer.toString(n).split("0");
		}

		List<String> list = new ArrayList<>();
		for(String s: strArr){
			System.err.println("s= "+s);
			if(!s.equals("")){
				if(!lv2_20_1(s)){
					list.add(s);
				}
			}
		}

		System.err.println(list);

	}

	public static boolean lv2_20_1(String str) {
		int temp = Integer.parseInt(str);
		boolean isPrime = false;
		if(temp == 1){
			isPrime = true;
		}else{
			for (int i = 2; i < temp; i++) {
				// 1과 num 자신 외에 나누어지는 수가 있는지 검사할 조건문
				if (temp % i == 0) {
					// 나누어지는 수가 있을 경우 isPrime의 값을 true로 바꾼다.
					isPrime = true;
					// 한 번이라도 이 조건문이 실행될 경우 num은 소수가 아니므로 반복문을 빠져나온다.
					break;
				}
			}
		}
		
		return isPrime;
	}

	static int n; // 원소 개수
    static int[][] numbers; // 순열을 저장할 배열
    static boolean[] isSelected; // 뽑았는지 여부를 저장할 배열
    static int count=0; // 순열 개수
	static int max=0;
	static int k =80;
	public static void lv2_21() { // 피로도
		System.err.println("!!!!!!!!!!!!! lv2_21 !!!!!!!!!!!!!!!");
		int[][] dungeons = {{80,20},{50,40},{30,10}};

		n = dungeons.length;
        numbers = new int[n][2];
        isSelected = new boolean[n+1];
        Permutation(0,dungeons);
        System.out.println("max : " + max);
	}

    public static void Permutation(int num,int[][] dungeons) {
        // base condition
        if(num == n) {
            //System.out.println(Arrays.toString(numbers));
			for(int[] i:numbers){
				System.err.print(i[0]+" "+i[1]+" : ");
				if(k >= i[0]){
					k=k-i[1];
					count++;
				}else{
					//break;
				}
			}

			if(max < count){
				max = count;
			}

			count=0;
			k = 80;
			System.err.println(" ");
            return;
        }

        for(int i = 1; i <= n; i++) {
            if (isSelected[i]) continue; // 중복 검사

            // 중복이 아니라면
            numbers[num] = dungeons[i-1].clone();
            isSelected[i] = true;
            Permutation(num + 1, dungeons); // 다음 요소 뽑기
            isSelected[i] = false;
        }
    }


	public static void lv2_22() { // n^2 배열 자르기
		System.err.println("!!!!!!!!!!!!! lv2_22 !!!!!!!!!!!!!!!");
		// int n=3;
		// int left =2;
		// int right = 5;
		int n=4;
		int left=7;
		int right=14;

		List<Integer> list = new ArrayList<>();

		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				int tmp = j;
				if(i>=j){
					tmp = i;
				}
				//temp[i][j] = tmp+1;
				list.add(tmp+1);
			}
		}

		System.err.println("list = "+list);

		int[] temp = list.stream().mapToInt(Integer::intValue).toArray();

		System.err.println("temp = "+temp);

		int[] temp2 = Arrays.copyOfRange(temp, left, right+1);

		for(int i:temp2){
			System.err.println(i);
		}
		
	}

	public static void lv2_23() { // 교점에 별 만들기
		System.err.println("!!!!!!!!!!!!! lv2_23 !!!!!!!!!!!!!!!");
	}

	public static void lv2_24() { // 전력망을 둘로 나누기
		System.err.println("!!!!!!!!!!!!! lv2_24 !!!!!!!!!!!!!!!");

		int n=9;
		int[][] wites ={{1,3}
						,{2,3}
						,{3,4}
						,{4,5}
						,{4,6}
						,{4,7}
						,{7,8}
						,{7,9}
					};
	}

	public static void lv2_25() { // 모음 사전
		System.err.println("!!!!!!!!!!!!! lv2_25 !!!!!!!!!!!!!!!");
	}

	public static void lv2_26() { // 거리두기 확인 하기
		System.err.println("!!!!!!!!!!!!! lv2_26 !!!!!!!!!!!!!!!");
		//1. 사람이 있는 곳에서 사방의 좌표 확인 하기.
		//2. 사람이 있는 곳에서 위 아래 좌 우에 파티션이 있으면 거리 두기
		//3. 사람이 있는 곳에서 위 아래 좌 우에 테이블이 있으면 테이블이
	    //   있는 기준으로 본인 말고 다른 사람이 있으면 거리두기를 지기지 않음

		// P: 응시자
		// O: 빈테이블
		// X : 파티션

		String[][] places = {{"POOOP","OXXOX","OPXPX","OOXOX","POXXP"}
							,{"POOPX","OXPXP","PXXXO","OXXXO","OOOPP"}
							};
		
		for(int i=0; i<places.length; i++){
			String[] place = places[i];
			
			char[][]  change = new char[5][5];
			for(int x=0; x<place.length; x++){
				//System.err.println(place[x]);
				char[] charArr = place[x].toCharArray();
				change[x] = charArr.clone();
			}

			for(int x=0; x<place.length; x++){
				for(int y=0; y<place.length; y++){
					System.err.print(change[x][y]+" : ");
				}
				System.err.println("");
			}

			for(int x=0; x<change.length; x++){
				for(int y=0; y<change.length; y++){
					char c = change[x][y];
					if(c == 'P'){
						//좌표 확인
						if(!lv2_26_1(x,y,change)){
							System.err.println(" x = "+x+" y = "+y);
						}
					}	
				}
			}
			
		}

	}

	public static boolean lv2_26_1(int x, int y, char[][]  change){

		char temp;

		//위
		if(x-1 >= 0){
			temp = change[x-1][y];
			if(temp == 'P'){
				return false;
			}
		}
		
		//아래
		if(x+1 < 5){
			temp = change[x+1][y];
			if(temp == 'P'){
				return false;
			}
		}

		//앞
		if(y-1 >= 0){
			temp = change[x][y-1];
			if(temp == 'P'){
				return false;
			}
		}
		
		//뒤
		if(y+1 < 5){
			temp = change[x][y+1];
			if(temp == 'P'){
				return false;
			}
		}

		//위(2칸)
		if(x-2 >= 0){
			temp = change[x-2][y];
			if(temp == 'P'){
				if(change[x-1][y]!='X'){
					return false;
				}
			}
		}
		
		//아래(2칸)
		if(x+2 < 5){
			temp = change[x+2][y];
			if(temp == 'P'){
				if(change[x+1][y]!='X'){
					return false;
				}
			}
		}

		//앞(2칸)
		if(y-2 >= 0){
			temp = change[x][y-2];
			if(temp == 'P'){
				if(change[x][y-1]!='X'){
					return false;
				}
			}
		}
		
		//뒤(2칸)
		if(y+2 < 5){
			temp = change[x][y+2];
			if(temp == 'P'){
				if(change[x][y+1]!='X'){
					return false;
				}
			}
		}
		
		//대각선(왼상)
		if(x-1 >=0 && y-1 >= 0 && x-1 < 5 && y-1 < 5){
			temp = change[x-1][y-1];
			if(temp == 'P'){
				//위
				char temp2;
				temp2 = change[x-1][y];
				if(temp2 != 'X'){
					return false;
				}
				
				//앞
				temp2 = change[x][y-1];
				if(temp2 != 'X'){
					return false;
				}
				
			}
			
		}

		//대각선(우상)
		if(x-1 >=0 && y+1 >= 0 && x-1 < 5 && y+1 < 5){
			temp = change[x-1][y+1];
			if(temp == 'P'){
				//위
				char temp2;
				temp2 = change[x-1][y];
				if(temp2 != 'X'){
					return false;
				}
				
				//뒤
				temp2 = change[x][y+1];
				if(temp2 != 'X'){
					return false;
				}
			}			
		}

		//대각선(좌하)
		if(x+1 >=0 && y-1 >= 0 && x+1 < 5 && y-1 < 5){
			temp = change[x+1][y-1];
			if(temp == 'P'){
				//위
				char temp2;
				
				//아래
				temp2 = change[x+1][y];
				if(temp2 != 'X'){
					return false;
				}
				
				//앞
				temp2 = change[x][y-1];
				if(temp2 != 'X'){
					return false;
				}
			}			
		}

		//대각선(우하)
		if(x+1 >=0 && y+1 >= 0 && x+1 < 5 && y+1 < 5){
			temp = change[x+1][y+1];
			if(temp == 'P'){
				//위
				char temp2;
				
				//아래
				temp2 = change[x+1][y];
				if(temp2 != 'X'){
					return false;
				}
				
				//뒤
				temp2 = change[x][y+1];
				if(temp2 != 'X'){
					return false;
				}
			}			
		}

		return true;
	}

}
