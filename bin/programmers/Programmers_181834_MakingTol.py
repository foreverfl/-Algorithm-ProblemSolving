def solution(myString):
    answer = ""
    for i in range(len(myString)):
        if myString[i] <= 'l':
            answer += 'l'
        else:
            answer += myString[i]
    return answer
