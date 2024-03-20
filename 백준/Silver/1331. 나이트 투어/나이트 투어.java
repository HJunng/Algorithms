import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String first = br.readLine();
        String bef = first;

        Set<String> visited = new HashSet<>();
        visited.add(first);

        for(int i=1;i<36;i++){
            String now = br.readLine();

            // 방문한 적이 있으면 Invalid
            if(visited.contains(now)){
                System.out.println("Invalid");
                return;
            }

            visited.add(now);

            // 나이트 이동 경로가 이상하면 Invalid
            if(!correctWay(bef,now)){
                System.out.println("Invalid");
                return;
            }

            bef = now;
        }

        // 마지막 위치에서 처음 위치로 돌아올 수 있는지 확인.
        if(!correctWay(bef,first)){
            System.out.println("Invalid");
            return;
        }

        System.out.println("Valid");
    }
    static boolean correctWay(String bef, String now){

        // 열 차이
        int col = Math.abs(bef.charAt(0)-now.charAt(0));
        int row = Math.abs((bef.charAt(1)-'0')-(now.charAt(1)-'0'));

        if(col!=0 && row!=0 && row+col==3)
            return true;
        else
            return false;
    }
}