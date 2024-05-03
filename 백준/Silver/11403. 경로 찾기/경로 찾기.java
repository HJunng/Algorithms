import java.io.*;

public class Main {
    static int[][] connect;
    static boolean[] visited;
    static int n;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] s;

        connect = new int[n][n];
        for(int i=0;i<n;i++){
            s = br.readLine().split(" ");
            for(int j=0;j<n;j++){
                connect[i][j] = Integer.parseInt(s[j]);
            }
        }

        for(int i=0;i<n;i++){
            visited = new boolean[n];
            dfs(i,i);
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(connect[i][j]+" ");
            }
            System.out.println();
        }
    }
    static void dfs(int start, int now){

        for(int i=0;i<n;i++){
            if(!visited[i] && connect[now][i]==1){
                visited[i]=true;
                connect[start][i]=1;
                dfs(start,i);
            }
        }
    }
}