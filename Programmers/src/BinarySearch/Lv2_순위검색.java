package BinarySearch;
import java.util.*;

public class Lv2_순위검색 {
	static HashMap<String, ArrayList<Integer>> scoreMap; //key: "언어-직무-직급-음식" ex - "java-backend-junior-pizza", values: 코테 점수 -> 4가지 조건에 속하는 코테 점수 나열.
    static int score;
    static String[] strings;
    static String[] sInfoArr; //info 5개 정보 저장.

    static void dfs(int lv) {
        if (lv == 4) { //코테 점수
            String str = String.join("", strings); //코테 점수를 제외한 나머지를 모두 이어붙여서 저장.
            if (!scoreMap.containsKey(str))//이전에 저장하지 않았다면 map에 key로 저장.
                scoreMap.put(str, new ArrayList<>());
            scoreMap.get(str).add(score);//value값에 코테점수 저장.
        }else {
            strings[lv] = sInfoArr[lv]; //언어, 직무, 신입or경력, 선호음식은 그냥 strings에 저장.
            dfs(lv + 1);
            strings[lv] = "-";// 해당 조건을 고려하지 않을 때도 생각해서 -도 넣어주기.
            dfs(lv + 1);
            
            
            // info가 java backend junior pizza 150 으로 들어왔다면
            //저장되는 키는 javabackendjuniorpizza, javabackendjunior-, javabackend-pizza, 
            //           javabackend--, java-juniorpizza, java-junior-,java--pizza, java---,
            //           -backendjuniorpizza, -backendjunior-, -backend-pizza, -backend--,
            //           --juniorpizza, --junior-, ---- 이렇게 총 16가지의 키에 150코테점수가 모두 들어간다.
        }
    }
    static int lowerBound(ArrayList<Integer> list, int key) { //key보다 점수가 아래인 사람 몇명인지 반환.
        int left = 0, right = list.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (list.get(mid) < key) //주어진 점수보다 낮다면
                left = mid + 1;
            else
                right = mid - 1;
        }

        return left;
    }

    public static int[] solution(String[] info, String[] query) {
        scoreMap = new HashMap<>();

        for (String sInfo : info) {
            strings = new String[4]; //4개자리 생성.
            sInfoArr = sInfo.split(" "); //언어, 직무, 신입or경력, 선호음식 저장
            score = Integer.parseInt(sInfoArr[4]); //코테점수는 score에 따로 저장.
            dfs(0); //정보를 scoreMap에 저장
        }

        for (String key : scoreMap.keySet())//총 16가지 경우의 수 (2^4)
            Collections.sort(scoreMap.get(key)); //각 키별로 코테점수 정렬.

        int idx = 0;
        int[] answer = new int[query.length];
        for (String q : query) { //질문 하나씩 가져옴.
            String[] strs = q.split(" and | "); // " and "와 " "로 문자열 자름.
            String key = strs[0] + strs[1] + strs[2] + strs[3]; //코테점수를 뺀 나머지 정보들이 key

           if (!scoreMap.containsKey(key)) //이 key와 같은 사람이 없는 것.
               answer[idx++] = 0;
           else {
               ArrayList<Integer> ansList = scoreMap.get(key); //[조건] 4가지에 부합하는 사람이 여러 명이면
               //이분탐색으로 주어진 query 점수보다 낮은 사람들 모두 빼기.
               answer[idx++] = ansList.size() - lowerBound(ansList, Integer.parseInt(strs[4]));
           }
        }
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
