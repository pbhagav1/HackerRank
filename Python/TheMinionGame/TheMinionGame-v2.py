inputString = input()
vowelWordCount = 0
consonantWordCount = 0
for i in range(len(inputString)):
    if ((inputString[i][0] == 'A') or (inputString[i][0] == 'E') or (inputString[i][0] == 'I') or (inputString[i][0] == 'O') or (inputString[i][0] == 'U')):
        vowelWordCount+=(len(inputString) - i)
    else:
        consonantWordCount+=(len(inputString) - i)
if consonantWordCount > vowelWordCount:
    print("Stuart", consonantWordCount)
elif vowelWordCount > consonantWordCount:
    print("Kevin", vowelWordCount)
else:
    print("Draw")