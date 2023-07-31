for T in range(1, 11):
    N = int(input())
    code = list(map(int, input().split()))  # 코드
    M = int(input())
    instruction = list(input().split())  # 명령어
 
    ins = []
    for i in range(len(instruction)):
        if instruction[i] == "I" or instruction[i] == "D" or instruction[i] == "A":
            if i != 0:
                ins.append(tmp)
            tmp = [instruction[i]]
        elif i == len(instruction)-1:
            tmp.append(instruction[i])
            ins.append(tmp)
        else:
            tmp.append(instruction[i])
 
    for i in range(M):
        if ins[i][0] == "I":
            x = int(ins[i][1])
            y = int(ins[i][2])
            s = ins[i][3:]
            for j in range(y):
                code.insert(x+j, int(s[j]))
        elif ins[i][0] == "D":
            x = int(ins[i][1])
            y = int(ins[i][2])
            for j in range(y):
                del (code[x])
        elif ins[i][0] == "A":
            y = int(ins[i][1])
            s = ins[i][2:]
            for j in range(y):
                code.append(int(s[j]))
 
    print(f'#{T}',end=" ")
    print(*code[0:10])
