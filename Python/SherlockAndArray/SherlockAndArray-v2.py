# -*- coding: utf-8 -*-
"""
Created on Sat Aug 27 14:50:23 2016

@author: Prasanth_B
"""

numberOfTestCases = (int) (input())
inputArray = []
resultArray = []
for i in range(numberOfTestCases):
    sizeOfArray = input()
    #inputArrayStr = input()
    #inputArray.clear()
    #for x in inputArrayStr.split(sep=" "):
        #inputArray.append((int) (x))
    inputArray = [(int) (x) for x in input().split(sep=" ")]
    elementExists = False
    for k in range(0, len(inputArray)):
        #lSum = 0
        #for l in range(k):
            #lSum+=inputArray[l]
        lSum = sum(inputArray[:k])
        rSum = sum(inputArray[k+1:])
        #rSum = 0
        #for r in range(k+1, len(inputArray)):
            #rSum+=inputArray[r]
        #print("Element : ", inputArray[k])
        #print("lSum : ", lSum)
        #print("rSum : ", rSum)
        if (lSum == rSum):
            elementExists = True
            break
    #if (elementExists == True):
        #resultArray.append("YES")
    #else:
        #resultArray.append("NO")
    resultArray.append("YES" if elementExists else "NO")
for result in resultArray:
    print(result)