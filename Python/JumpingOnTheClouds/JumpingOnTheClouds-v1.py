# -*- coding: utf-8 -*-
"""
Created on Mon Aug 29 15:31:03 2016

@author: Prasanth_B
"""

n = int(input().strip())
c = [int(c_temp) for c_temp in input().strip().split(' ')]
i = 0
steps=0
while (i != (n-1)):
    i = (i+2) if ((i < (n-2)) and (c[i+2] == 0)) else (i+1)
    steps+=1
print(steps)