# -*- coding: utf-8 -*-
"""
Created on Mon Aug 29 15:12:32 2016

@author: Prasanth_B
"""

n = int(input().strip())
A = [int(A_temp) for A_temp in input().strip().split(' ')]
minDistance = n
for i in range(n - 1):
    try:
        nextIndex = A.index(A[i], i + 1)
    except ValueError:
        nextIndex = -1
    if ((nextIndex != -1) and ((nextIndex - i) < minDistance)):
        minDistance = nextIndex - i
    #for j in range(i + 1, n):
        #if ((A[i] == A[j]) and ((j - i) < minDistance)):
            #minDistance = j - i
minDistance = minDistance if minDistance != n else -1
print(minDistance)