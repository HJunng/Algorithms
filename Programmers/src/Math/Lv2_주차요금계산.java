package Math;

import java.util.*;
public class Lv2_주차요금계산 {
	static Map<String,ArrayList<String>> carRecords = new HashMap<>(); //차량별 입출차 시간
    static ArrayList<String> cars; // 차 번호
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        
        for(int i=0;i<records.length;i++){
            String[] s = records[i].split(" ");
            
            if(!carRecords.containsKey(s[1])) carRecords.put(s[1],new ArrayList<>());
            
            carRecords.get(s[1]).add(s[0]);//입출차 시간 넣기
        }
        cars = new ArrayList<>(carRecords.keySet()); //차량번호
        Collections.sort(cars); //차량번호 작은 자동차부터 정렬
        
        answer = new int[cars.size()];
        for(int i=0;i<answer.length;i++){
            answer[i]=calculateFees(fees,cars.get(i)); //차량번호 별 요금 계산
        }
        
        
        return answer;
    }
    //주차요금 계산
    private int calculateFees(int[] fees, String car){
        
        int costs=0;
        int times=0;
        //시간 계산
        for(int i=0;i<carRecords.get(car).size();i+=2){
            
            String[] in=carRecords.get(car).get(i).split(":");
            String outTime="";
            if(i+1>=carRecords.get(car).size())
                outTime="23:59";
            else
                outTime=carRecords.get(car).get(i+1);
            String[] out = outTime.split(":");
            
            int tempTimes = Integer.parseInt(out[0])*60+Integer.parseInt(out[1]);
            tempTimes-=Integer.parseInt(in[0])*60+Integer.parseInt(in[1]);
            
            times+=tempTimes;
        }
        
        if(times<=fees[0]) return fees[1];
        costs+=fees[1]; times-=fees[0];
        
        if(times%fees[2]==0){
            costs+=(times/fees[2])*fees[3];
        }else{
            costs+=(times/fees[2]+1)*fees[3];
        }
        
        return costs;
    }
}
