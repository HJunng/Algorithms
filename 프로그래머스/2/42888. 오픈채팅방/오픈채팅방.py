def solution(record):
    answer = []
    
    id_name = dict()
    
    
    for re in record:
        split = re.split()
        if split[0]=="Leave": continue
        
        id_name[split[1]] = split[2]
        
    for re in record:
        split = re.split()
        
        if(split[0]=="Enter") :
            answer.append(id_name[split[1]]+"님이 들어왔습니다.")
        elif(split[0]=="Leave") :
            answer.append(id_name[split[1]]+"님이 나갔습니다.")
        
    
    return answer