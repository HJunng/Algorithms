import java.io.*;
import java.util.*;

public class Main {
    static int aMax = 200;
    static List<int[]> abList;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 수가 1개만 주어질 경우, 다음에 올 경우는 너무 많음.
        if(n==1){
            System.out.println("A");
            return;
        }

        String[] s = br.readLine().split(" ");
        int[] num = new int[n];
        for(int i=0;i<n;i++) num[i] = Integer.parseInt(s[i]);

        if(n==2 && num[0]==num[1]){
            System.out.println(num[0]);
            return;
        }else if(n==2 && num[0]!=num[1]){
            System.out.println("A");
            return;
        }

        abList = findAB(num[0],num[1]);
        for(int i=1;i<n-1;i++){
            if(abList.size()==0) break;
            checkAB(num[i],num[i+1]);
        }

        if(abList.size()==1){
            int[] ab = abList.get(0);
            System.out.println(num[n-1]*ab[0]+ab[1]);
        } else if(abList.size()>1){
            System.out.println("A");
        } else{
            System.out.println("B");
        }
    }
    private static List<int[]> findAB(int n1, int n2){
        List<int[]> list = new ArrayList<>();

        if(n1 == n2){
            list.add(new int[]{1,0});
            return list;
        }

        for(int a=0; a<=aMax; a++){
            int b = n2 - a*n1;

            list.add(new int[]{a,b});

            if(a==0) continue;

            // a가 다른 부호일 경우
            b = n2 + a*n1;
            list.add(new int[]{-a,b});
        }

        return list;
    }
    private static void checkAB(int n1, int n2){

        for(int i=0;i<abList.size();i++){
            int a = abList.get(i)[0];
            int b = abList.get(i)[1];

            if(n1*a +b != n2){
                abList.remove(i);
                i--;
            }
        }
    }
}