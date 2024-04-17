import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<String,String> parent;
    static Map<String, Integer> cnt;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while(tc-- > 0){
            int f = Integer.parseInt(br.readLine());
            parent = new HashMap<>();
            cnt = new HashMap<>();

            for(int i=0;i<f;i++){
                String[] s = br.readLine().split(" ");

                if(!parent.containsKey(s[0])) parent.put(s[0],s[0]);
                if(!parent.containsKey(s[1])) parent.put(s[1],s[1]);
                if(!cnt.containsKey(s[0])) cnt.put(s[0],1);
                if(!cnt.containsKey(s[1])) cnt.put(s[1],1);

                int result = union(parent.get(s[0]), parent.get(s[1]));

                System.out.println(result);
//                System.out.println(parent);
            }
        }
    }
    private static String find(String x){
        // 내가 루트면 그냥 반환
        if(parent.get(x).equals(x))
            return x;

        parent.put(x,find(parent.get(x)));
        return parent.get(x);
    }
    private static int union(String x, String y){
        String xRoot = find(x);
        String yRoot = find(y);

        // 같은 집합이면 바로 종료.
        if(xRoot.equals(yRoot)) return cnt.get(xRoot);

        // rank를 이용해서 더 낮은 트리를 더 높은 트리에 붙인다.
        if(cnt.get(xRoot) < cnt.get(yRoot)){
            parent.put(xRoot,yRoot);
            cnt.put(yRoot, cnt.get(yRoot)+cnt.get(xRoot));
            return cnt.get(yRoot);
        }
        else{ // xRoot 가 부모
            parent.put(yRoot,xRoot);
            cnt.put(xRoot, cnt.get(xRoot)+cnt.get(yRoot));
            return cnt.get(xRoot);
        }
    }
}