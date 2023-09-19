class Solution {
    static char[] friends = {'A','C','F','J','M','N','R','T'};
    static boolean[] visited = new boolean[8];
    static int cnt;
    public int solution(int n, String[] data) {
        
        cnt=0;
        dfs("",data);
        
        return cnt;
    }
    void dfs(String position, String[] data){
        
        if(position.length()==8){
            if(conditionSatisfied(position,data)) cnt++;
            return;
        }
        
        for(int i=0;i<8;i++){
            if(!visited[i]){
                visited[i]=true;
                dfs(position+friends[i],data);
                visited[i]=false;
            }
        }
    }
    boolean conditionSatisfied(String position, String[] data){
        
        boolean b = true;
        
        for(int i=0;i<data.length;i++){
            if(!b) break;
            
            char f1=data[i].charAt(0);
            char f2 = data[i].charAt(2);
            
            char query = data[i].charAt(3);
            int qDistance = Integer.parseInt(data[i].charAt(4)+"");
            
            int f1Position=position.indexOf(f1+"");
            int f2Position=position.indexOf(f2+"");
            
            int fDistance = Math.abs(f1Position-f2Position)-1;
            
            if(query=='>' && fDistance<=qDistance) b=false;
            
            else if(query=='=' && fDistance!=qDistance) b=false;
                
            else if(query=='<' && fDistance>=qDistance) b=false;
                
        }
        return b;
    }
}