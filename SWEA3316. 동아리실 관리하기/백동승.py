def solve(idx):
    for i in range(1,16):
        for j in range(1,16):
            if(i & j) and (i & dic[s[idx]]):
                dp[idx+1][i] %= 1000000007
                dp[idx+1][i] += dp[idx][j]
 
 
T = int(input())
for test_case in range(1, T + 1):
    s = input()
    s_len = len(s)
    dic = {"A":0b0001,"B":0b0010,"C":0b0100,"D":0b1000}
    dp = [[0 for j in range(16)] for i in range(s_len+1)]
    dp[0][1] = 1;
    for i in range(s_len):
        solve(i)
    ret = 0
    for i in range(1,16):
        ret += dp[s_len][i]
    print("#{} {}".format(test_case, ret%1000000007))
