def solution(n, lost, reserve): 
    count = 0
    lost = set(lost)
    reserve = set(reserve)
    lost1 = list(lost-reserve)
    reserve1 = list(reserve-lost)
    
    for i in range(len(lost1)):
        if lost1[i]-1 in reserve1:
            count += 1
            reserve1.remove(lost1[i]-1)
        elif lost1[i]+1 in reserve1:
            count += 1
            reserve1.remove(lost1[i]+1)
            
    answer = n - (len(lost1)-count)
    return answer
