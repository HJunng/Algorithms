import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] maxNum;
    static int[] minNum;
    static boolean[] visit;
    static String[] ops;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ops = br.readLine().split(" ");

        visit = new boolean[10];
        maxNum = new int[n+1];
        maxDfs(0);
        for(int i=0;i<maxNum.length;i++){
            System.out.print(maxNum[i]);
        }
        System.out.println();

        Arrays.fill(visit, false);
        minNum = new int[n+1];
        minDfs(0);
        for(int i=0;i<minNum.length;i++){
            System.out.print(minNum[i]);
        }
        System.out.println();


    }
    static boolean maxDfs(int idx){
        if(idx == maxNum.length){
            if(isCorrect(maxNum)) return true;
            else return false;
        }

        boolean flag = false;

        for(int i=9;i>=0;i--){
            if(!visit[i]){
                visit[i] = true;
                maxNum[idx]=i;
                flag = maxDfs(idx+1);
                if(flag) break;
                visit[i] = false;
            }
        }
        return flag;
    }

    static boolean minDfs(int idx){
        if(idx == minNum.length){
            if(isCorrect(minNum)) return true;
            else return false;
        }

        boolean flag = false;

        for(int i=0;i<=9;i++){
            if(!visit[i]){
                visit[i] = true;
                minNum[idx]=i;
                flag = minDfs(idx+1);
                if(flag) break;
                visit[i] = false;
            }
        }
        return flag;
    }

    static boolean isCorrect(int[] nums){
        boolean flag = true;

        for(int i=0;i<ops.length;i++){
            if(ops[i].equals("<") && nums[i]<nums[i+1]) continue;
            else if(ops[i].equals(">") && nums[i]>nums[i+1]) continue;
            else {
                flag = false; break;
            }
        }
        return flag;
    }
}