import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int[][] map;
    static int[][][] chickDist;
    static List<int[]> chickList;
    static List<int[]> houseList;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        n = Integer.parseInt(s[0]); // map 크기
        m = Integer.parseInt(s[1]); // 치킨집 최대 m개

        map = new int[n][n];
        chickList = new ArrayList<>();
        houseList = new ArrayList<>();

        for(int i=0;i<n;i++){
            s = br.readLine().split(" ");
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(s[j]);

                // 집이면 houseList에 추가해두기.
                if(map[i][j]==1) houseList.add(new int[]{i,j});
                // 치킨집이면 chickList에 추가해두기.
                else if(map[i][j]==2) chickList.add(new int[]{i,j});
            }
        }

        // chickDist[i][j][k] : (i,j)칸에서 k번째 치킨집까지 거리
        chickDist = new int[n][n][chickList.size()];
        for(int k=0;k<chickList.size();k++){    // O(n^2) ~ O(125000)
            // 치킨집 위치
            int cx = chickList.get(k)[0];
            int cy = chickList.get(k)[1];

            for(int[] h : houseList){
                chickDist[h[0]][h[1]][k] = Math.abs(h[0]-cx) + Math.abs(h[1]-cy);
            }
        }

        dfs(new ArrayList<>(), -1);

        System.out.println(result);
    }
    private static void dfs(List<Integer> pickChicken, int lastIdx){ // O(n^m)

        // 치킨집을 다 골랐을 경우
        if(pickChicken.size()>=m){
            result = Math.min(result, calMinDist(pickChicken));
            return;
        }

        // 마지막으로 골랐던 치킨집 index보다 큰 치킨집을 선택.
        for(int i=lastIdx+1;i<chickList.size();i++){
            pickChicken.add(i);
            dfs(pickChicken,i);
            pickChicken.remove(pickChicken.size()-1);
        }
    }
    private static int calMinDist(List<Integer> pickChicken){ // O(m*n^2)
        int sum = 0;

        for(int[] h : houseList){
            int min = Integer.MAX_VALUE;
            for(int ch : pickChicken){
                min = Math.min(min, chickDist[h[0]][h[1]][ch]);
            }
            sum += min;
        }

        return sum;
    }
}