import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = new String[3];

        for(int i=0;i<3;i++) str[i] = br.readLine();


        int[][][] lcs = new int[str[0].length()+1][str[1].length()+1][str[2].length()+1];

        int max=0;
        for(int i=1;i<=str[0].length();i++){
            for(int j=1;j<=str[1].length();j++){
                for(int k=1;k<=str[2].length();k++){

                    if(str[0].charAt(i-1)==str[1].charAt(j-1) && str[1].charAt(j-1)==str[2].charAt(k-1)){
                        lcs[i][j][k] = lcs[i-1][j-1][k-1]+1;
                    } else{
                        // lcs[i-1][j][k], lcs[i][j-1][k], lcs[i][j][k-1] 중에 가장 큰 수
                        lcs[i][j][k] = Math.max(Math.max(lcs[i-1][j][k],lcs[i][j-1][k]), lcs[i][j][k-1]);
                    }

                    max = Math.max(max, lcs[i][j][k]);
                }
            }
        }

        System.out.println(max);
    }
}