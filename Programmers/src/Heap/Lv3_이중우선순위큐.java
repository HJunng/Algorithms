package Heap;
import java.util.*;
public class Lv3_이중우선순위큐 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		PriorityQueue<Integer> q1 = new PriorityQueue<>();
        PriorityQueue<Integer> q2 = new PriorityQueue<>(Collections.reverseOrder());
        
        String op = "| 16";
        System.out.println(op.substring(2));
        q1.add(Integer.parseInt(op.substring(2)));
	}

}
