readline=input()
index=readline.find('-')
if index==-1:
    print(sum([int(i) for i in readline.split('+')]))
else:
    Pos=sum([int(i) for i in readline[0:index].split('+')])
    Neg=sum([int(i) for i in readline[index+1:].replace('-','+').split('+')])
    print(Pos-Neg)
