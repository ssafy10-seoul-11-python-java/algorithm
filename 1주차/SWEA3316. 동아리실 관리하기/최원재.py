T = int(input())
 
for test_case in range(1, T + 1):
    order = input()
    arr = [[0 for j in range(16)] for i in range(len(order) + 1)]  # dp배열 초기화
    arr[0][1] = 1 # 처음 열쇠는 A
 
    for i in range(0,len(order)):
        curr = (1 << (ord(order[i]) - 65))  #다음 당직 순서 A - 0001, B- 0010, C - 0100, D - 1000
        for j in range(1, 16):      #전날 부원
            for k in range(1, 16):  #오늘 부원
                if(j&k > 0):        #곂치는 사람이 있는가
                    if(k&curr > 0): #오늘 책임자가 있는가
                        arr[i+1][k] += arr[i][j]
                        arr[i+1][k] %= 1000000007
    cnt = 0
    for i in range(16):
        cnt += arr[len(order)][i]    #마지막날 배열 더하기
    print('#'+ str(test_case) + ' ' + str(cnt % 1000000007))
