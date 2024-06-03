import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=n;i++){
            list.add(i);
        }

        int idx = k-1;
        while(!list.isEmpty()){
            sb.append(list.get(idx));
            list.remove(idx);

            if(list.isEmpty()) break;

            sb.append(", ");
            idx = (idx+k-1)%list.size();
        }
        sb.append(">");
        System.out.println(sb);
    }
}