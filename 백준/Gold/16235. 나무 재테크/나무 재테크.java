import java.io.*;
import java.util.*;

public class Main {
    static int n,m,k;
    static int[][] ground; // 현재 땅의 양분
    static int[][] addFood; // S2D2가 추가하는 양분의 양

    // 트리를 나이 적은 순으로 저장.
    static PriorityQueue<Tree> pq = new PriorityQueue<>((a,b)->a.age-b.age);

    static Queue<Tree> dead = new LinkedList<>(); // 죽은 나무 저장.
    static Queue<Tree> breed = new LinkedList<>(); // 번식할 나무 저장

    static class Tree{
        int x,y,age;
        public Tree(int x, int y, int age){
            this.x = x;
            this.y = y;
            this.age = age;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        k = Integer.parseInt(s[2]); // k년 후

        ground = new int[n][n];
        addFood = new int[n][n];

        for(int i=0;i<n;i++){
            s = br.readLine().split(" ");
            for(int j=0;j<n;j++){
                addFood[i][j] = Integer.parseInt(s[j]);
                ground[i][j]=5;
            }
        }

        for(int i=0;i<m;i++){
            s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0])-1;
            int y = Integer.parseInt(s[1])-1;
            int z = Integer.parseInt(s[2]);

            pq.add(new Tree(x,y,z));
        }

        // ----여기까지 입력받는 부분----
        for(int i=0;i<k;i++){
            spring();
            summer();
            fall();
            winter();
        }

        System.out.println(pq.size());

    }
    // 봄에는 모든 나무들이 자신의 나이만큼 양분을 먹음.
    static void spring(){
        int size = pq.size();

        List<Tree> newPQ = new ArrayList<>();

        for(int i=0;i<size;i++){
            Tree tree = pq.poll();
            // 트리의 나이만큼의 양분을 먹을 수 있는지
            if(ground[tree.x][tree.y]>= tree.age){
                ground[tree.x][tree.y] -= tree.age;
                tree.age+=1;
                newPQ.add(tree);
                // 나무의 나이가 5의 배수이면 번식해야함.
                if(tree.age %5==0) breed.add(tree);
            }else{ // 먹을 수 없으면 죽음.
                dead.add(tree);
            }
        }
        pq.addAll(newPQ);
    }
    // 여름에는 죽은 나무를 양분으로 변하게 된다.
    static void summer(){
        while(!dead.isEmpty()){
            Tree tree = dead.poll();
            ground[tree.x][tree.y] += tree.age/2;
        }
    }
    // 가을에는 나무가 번식한다.
    static void fall(){
        int[] dx = {1,1,1,0,0,-1,-1,-1};
        int[] dy = {1,0,-1,1,-1,1,0,-1};

        // 8방향으로 범위를 벗어나지 않으면 1짜리 나무가 생긴다.
        while(!breed.isEmpty()){
            Tree tree = breed.poll();

            for(int i=0;i<8;i++){
                int nx = tree.x + dx[i];
                int ny = tree.y + dy[i];

                if(nx>=0 && nx<n && ny>=0 && ny<n){
                    pq.add(new Tree(nx,ny,1));
                }
            }
        }
    }
    // 겨울에는 S2D2가 돌아다니면서 땅에 양분을 추가한다.
    static void winter(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                ground[i][j] += addFood[i][j];
            }
        }
    }
}
