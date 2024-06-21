import java.util.*;

public class Main {
    static class Emoticon{
        int length, seconds, copy;
        private Emoticon(int length, int seconds, int copy){
            this.length = length;
            this.seconds = seconds;
            this.copy = copy;
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();

        Set<String> visit = new HashSet<>();

        Queue<Emoticon> q = new LinkedList<>();
        q.add(new Emoticon(1,0,0)); // 이모티콘길이, 초
        visit.add("1_");

        while(!q.isEmpty()) {
            Emoticon e = q.poll();

            if(e.length == s) {
                System.out.println(e.seconds);
                return;
            }

            // 1. 현재 화면 복사
            if(!visit.contains(e.length+"_"+e.length)) { // "현재길이_copy길이"
                q.add(new Emoticon(e.length, e.seconds+1, e.length));
                visit.add(e.length+"_"+e.length);
            }

            // 2. 클립보드에서 붙여넣기
            if(!visit.contains(e.length+e.copy+"_"+e.copy)) {
                q.add(new Emoticon(e.length+e.copy, e.seconds+1, e.copy));
                visit.add(e.length+e.copy+"_"+e.copy);
            }

            // 3. 이모티콘 한개 삭제
            if(!visit.contains(e.length-1+"_"+e.copy)) {
                q.add(new Emoticon(e.length-1, e.seconds+1, e.copy));
                visit.add(e.length-1+"_"+e.copy);
            }
        }
    }
}