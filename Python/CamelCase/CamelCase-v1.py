s = input().strip()
i = 1
for letter in s:
    if letter.isupper():
        i+=1
print(i)