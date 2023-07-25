S = list(input()) #문자열



def espell():
    if S == S[::-1]:  # 주어진 문자열이 이미 팰린드롬인 경우
        return len(S)
    for i in range(len(S)):
        if S[i:] == S[i:][::-1]:
            return len(S) + i
    # 겹치는 문자열 아예 없을때
    return len(S) + len(S[-2::-1])


print(espell())
