inputString = input()
vowelWordCount = 0
consonantWordCount = 0
for i in range(len(inputString)):
    for j in range(i + 1, len(inputString) + 1):
        if ((inputString[i:j][0] == 'A') or (inputString[i:j][0] == 'E') or (inputString[i:j][0] == 'I') or (inputString[i:j][0] == 'O') or (inputString[i:j][0] == 'U')) :
            vowelWordCount+=1
        else:
            consonantWordCount+=1
if consonantWordCount > vowelWordCount:
    print("Stuart", consonantWordCount)
elif vowelWordCount > consonantWordCount:
    print("Kevin", vowelWordCount)
else:
    print("Draw")