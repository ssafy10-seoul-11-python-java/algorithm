num_str = input()
num_list = []
str_length = len(num_str)

### 입력 받기
i = 0
while i < str_length:
    if num_str[i] == "-" or num_str[i] == '+':
        num_list.append(num_str[i])
        i += 1
    else:
        len = 0
        for j in range(0, 6):
            if i+j == str_length or num_str[i+j] == '-' or num_str[i+j] == '+':
                num_list.append(int(num_str[i:i+j]))
                len = j
                break
        i += len

# print(num_list)
### 문제 풀이
# 55-50+40
ans = 0
now = '+'
for i in num_list:
    if i == '-':
        now = '-'
    elif i != "+":
        if now == '+':
            ans += i
        else:
            ans -= i
print(ans)