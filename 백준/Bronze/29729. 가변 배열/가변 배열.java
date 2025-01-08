import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int initialSize = Integer.parseInt(s[0]);
        int N = Integer.parseInt(s[1]); // 저장 명령 개수
        N += Integer.parseInt(s[2]); // 삭제 명령 개수

        int size = initialSize;
        int curSize = 0;

        while(N-- >0) {
            int command = Integer.parseInt(br.readLine());

            if(command == 1) { // 저장
                if(curSize+1>size){
                    size *= 2;
                }
                curSize++;
            } else { // 삭제
                curSize--;
            }
        }

        System.out.println(size);
    }
}