import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
    	
        int[] stageFail = new int[N + 1]; // 스테이지에 도달했지만 실패한 사람 수
        int[] stageReach = new int[N + 1]; // 스테이지에 도달한 사람 수

        for (int i = 0; i < stages.length; i++) {
            for (int j = 0; j < stages[i]; j++) {
                stageReach[j] += 1;
            }
            // 도달 했으나 클리어하지 못한 플레이어 수 증가
            stageFail[stages[i] - 1] += 1;
        }

        // 스테이지 번호와 실패율을 저장할 map
        Map<Integer, Double> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            // 스테이지에 도달한 사람이 없거나 클리어한 사람이 없는 경우
            if (stageFail[i] == 0 || stageReach[i] == 0) {
                map.put(i + 1, 0.0);
            } else {
                // 실패율 계산하여 맵에 저장
                map.put(i + 1, (double) stageFail[i] / (double) stageReach[i]);
            }
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        
        list.sort((o1, o2) -> Double.compare(map.get(o2), map.get(o1)));

        return list.stream().mapToInt(i -> i).toArray();
    }
}