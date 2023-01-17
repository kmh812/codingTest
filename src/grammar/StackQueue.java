package grammar;
import java.util.*;

public class StackQueue {
    
    public static void main(String[] args) throws Exception {

        // Stack ==> 후입선출(LIFO - Last In First Out)의 자료구조
        // Queue ==> 선입선출(FIFO - First In First Out)의 자료구조

        // Stack은 꺼내올 때 pop(), 입력할 때 push()
        // Queue는 꺼내올 때 poll(), 입력할 때 offer()
        // 둘 다 모두 어떤 값이 있는지 확인할 때는 peek()
        
        Stack<Integer> stack = new Stack<>();
        // 데이터 입력
        stack.push(3);
        stack.push(2);
        stack.push(1);
        
        System.out.println("stack = "+stack);
        System.out.println("stack size = "+stack.size());    // 사이즈 확인
        System.out.println("stack peek = "+stack.peek());    // 데이터를 빼지 않고 현재 가장 위에 위치하는 데이터 확인
        System.out.println("stack pop = "+stack.pop());     // 데이터를 빼고 가장 위에 위치하는 데이터 확인
        System.out.println("stack size = "+stack.size());    // 사이즈 확인
        stack.clear();      // stack 초기화

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);     // queue에 값 1 추가
        queue.offer(2);     // queue에 값 2 추가
        queue.offer(3);     // queue에 값 3 추가
        
        System.out.println("queue = "+queue);
        System.out.println("queue size = "+queue.size());    // 사이즈 확인
        System.out.println("queue poll = "+queue.peek());    // 데이터를 빼지 않고 현재 가장 위에 위치하는 데이터 확인
        System.out.println("queue poll = "+queue.poll());    // 데이터를 빼고 현재 가장 위에 위치하는 데이터 확인
        System.out.println("queue remove = "+queue.remove());     // 데이터를 빼고 가장 위에 위치하는 데이터 확인
        System.out.println("queue size = "+queue.size());    // 사이즈 확인
        queue.clear();      // queue 초기화
    }
}
