import numpy as np

numberOfTestCases = (int) (input())
inputArray = []
resultArray = []
for i in range(numberOfTestCases):
    sizeOfArray = input()
    inputArrayStr = input()
    inputArray.clear()
    for x in inputArrayStr.split(sep=" "):
        inputArray.append((int) (x))
        numpyArray = np.array(inputArray)
    elementExists = False
    for k in range(0, len(inputArray)):
        lSum = np.sum(numpyArray[:k])
        rSum = np.sum(numpyArray[k+1:])
        if (lSum == rSum):
            elementExists = True
            break
    if (elementExists == True):
        resultArray.append("YES")
    else:
        resultArray.append("NO")
for result in resultArray:
    print(result)