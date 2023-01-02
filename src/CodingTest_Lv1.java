import java.math.BigInteger;
import java.util.*;

public class CodingTest_Lv1 {
    public static void main(String[] args) throws Exception {
        lv1_1(); 
        lv1_2();
		lv1_3();
		lv1_4();
		lv1_5();
		lv1_6();
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
}
