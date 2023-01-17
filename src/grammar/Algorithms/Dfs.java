package grammar.Algorithms;

public class Dfs {

    public static void main(String[] args) throws Exception {
        // 깊이 우선 탐색
        // 재귀 함수를 사용
        // 1. 다음 동작에 대한 정의
        // 2. 실행 내역 작성
        dfs_1(1);

        // int[] numbers = {1,1,1,1,1};
		// int target = 3;
		// int depth =0;
		// int sum =0;
		// dfs_2(depth, numbers, target, sum);
		// System.err.println(" lv2_3_answer = "+lv2_3_answer);
    }

    static boolean[] dfs_visited = new boolean[9]; 
    static int[][] dfs_graph = {{}
                          , {2, 3, 8}
                          , {1, 6, 8}
                          , {1, 5}
                          , {5, 7}
                          , {3, 4, 7}
                          , {2}
                          , {4, 5}
                          , {1, 2}};

    static StringBuilder dfs_sb = new StringBuilder();

    public static void dfs_1(int x) {    
        dfs_visited[x] = true; 
        dfs_sb.append(x).append(" ");
        System.err.println("dfs_sb = "+dfs_sb);
        for (int i = 0; i < dfs_graph[x].length; i++) {
            if (!dfs_visited[dfs_graph[x][i]]){
                dfs_1(dfs_graph[x][i]);
            }
        }
    }

    static int lv2_3_answer = 0;
    public static void dfs_2(int depth, int[] numbers, int target, int sum) { //타켓넘버 재귀
		if(depth == numbers.length){
			if(target == sum){ 
				lv2_3_answer++;
			}
		}else{
			dfs_2(depth + 1, numbers, target, sum + numbers[depth]); // 해당 노드의 값을 더하고 다음 깊이 탐색
			dfs_2(depth + 1, numbers, target, sum - numbers[depth]); // 해당 노드의 값을 빼고 다음 깊이 탐색
		}
	}
}
