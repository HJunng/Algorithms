import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 9876543210 -> 감소하는 수 중에 가장 큰 수.

        // n이 10미만일 때, 바로 종료.
        if(n<10) {
            System.out.println(n); return;
        }
        n -= 9; // n이 10 미만이 아니니까, 그 만큼 0~9까지 개수 빼주기.

        List<Long> beforeList = new ArrayList<>();
        List<Long> afterList;

        for(int i=0;i<=9;i++){
            beforeList.add((long)i);
        }


        while (beforeList.get(beforeList.size()-1) != 9876543210L) {
            // afterList에는 beforeList보다 한자릿수 더 큰 수들이 오름차순으로 들어가 있음.
            afterList = new ArrayList<>();
            for(int i=0;i<=9;i++) { // 첫번째 자릿수.
                for(long right : beforeList) {
                    // right의 가장 큰 자릿수 값보다 앞에 올 수 있는지 확인.
                    if(i>getFirstDigit(right)) {
                        afterList.add(
                                Long.parseLong(Integer.toString(i)+Long.toString(right))
                        );
                    } else break;
                }
            }

            // afterList안에 n번째 수가 있는지 확인
            if(n <= afterList.size()) {
                System.out.println(afterList.get(n-1));
                return;
            }

            n -= afterList.size();
            beforeList = afterList;
        }

        // 9876543210L의 index보다 더 큰 게 나온 경우.
        if(n>0) {
            System.out.println(-1);
        }
    }
    static int getFirstDigit(long num) {
        char first = Long.toString(num).charAt(0);
        return first-'0';
    }
}