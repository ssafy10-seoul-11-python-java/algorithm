def max_number():
    max = 0
    if len(minus) > 1:
        for i in range(len(minus) - 1):
            temp = minus[i] + minus[i + 1]
            if temp > max:
                max = temp
                a = minus[i]
                b = minus[i + 1]
        minus.remove(a)
        minus.remove(b)
        minus.append(max)
        max_number()


string_number = input()
string_number = string_number.split("-")

for i in range(len(string_number)):
    if "+" in string_number[i]:
        minus = list(map(int, string_number[i].split("+")))
        max_number()
        string_number[i] = int(minus[0])
    else:
        string_number[i] = int(string_number[i])

result = string_number[0]
for n in string_number[1:]:
    result = result - n
print(result)
