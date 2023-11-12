import java.util.*;
import java.io.*;

public class Main {
	static Map<Character,ArrayList<Character>> tree = new HashMap<>();

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String[] s;
		for(int i=0;i<N;i++) {
			s = br.readLine().split(" ");
			
			char parent = s[0].charAt(0);
			char leftChild = s[1].charAt(0);
			char rightChild = s[2].charAt(0);
			
			tree.put(parent, new ArrayList<>()); // 자식노드 넣을 자리 만들기 : List
			
			// 부모노드에 왼쪽자식 추가 
			tree.get(parent).add(leftChild);  
			
			//부모노드에 오른쪽 자식 추가 
			tree.get(parent).add(rightChild); 
		}
		
		preorder('A'); System.out.println();
		inorder('A'); System.out.println();
		postorder('A');
		
	}
	// 전위 순회 
	static void preorder(char parent) {
		
		System.out.print(parent);
		
		// 왼쪽 노드 방문 (비어있지 않을 경우)
		if(tree.get(parent).get(0)!='.')
			preorder(tree.get(parent).get(0)); 
		
		// 오른쪽 노드 방문 (비어있지 않을 경우)
		if(tree.get(parent).get(1)!='.')
			preorder(tree.get(parent).get(1));
		
	}
	// 중위 순회
	static void inorder(char parent) {
		
		// 왼쪽 노드 방문 (비어있지 않을 경우)
		if(tree.get(parent).get(0)!='.')
			inorder(tree.get(parent).get(0)); 
		
		// 부모노드 방문 
		System.out.print(parent); 
		
		// 오른쪽 노드 방문 (비어있지 않을 경우)
		if(tree.get(parent).get(1)!='.')
			inorder(tree.get(parent).get(1));
		
	}
	// 후위 순회
	static void postorder(char parent) {
	
		// 왼쪽 노드 방문 (비어있지 않을 경우)
		if(tree.get(parent).get(0)!='.')
			postorder(tree.get(parent).get(0)); 
				
		// 오른쪽 노드 방문 (비어있지 않을 경우)
		if(tree.get(parent).get(1)!='.')
			postorder(tree.get(parent).get(1));
		
		System.out.print(parent);
	}
}