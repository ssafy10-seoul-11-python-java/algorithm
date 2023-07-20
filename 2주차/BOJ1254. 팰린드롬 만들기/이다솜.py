# 1. 펠린드롬인지 판단하는 함수 하나
def check(target):
    length = len(target)
    for i in range(0, length-1//2):
        if target[i] != target[length-i-1]:
            return False
    return True


# 2. 풀이는 브루트포스
text = input()
length = len(text)

for i in range(0, length):
    add_text = list(text[0:i])
    add_text.reverse()
    new_text = text + "".join(add_text)
    # print(new_text)
    if check(new_text):
        print(len(new_text))
        break
