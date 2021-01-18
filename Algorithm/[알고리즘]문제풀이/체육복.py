def solution(n, lost, reserve): 
    count = 0
    for i in range(len(lost)):
        if lost[i] in reserve:
            count += 1
            reserve.remove(lost[i])
            
        elif lost[i]-1 in reserve:
            count += 1
            reserve.remove(lost[i]-1)
            
        elif lost[i]+1 in reserve:
            count += 1
            reserve.remove(lost[i]+1)


    answer = n - (len(lost)-count)
    return answer