def readInput():
    numOfTestCases = int(input())
    listOfInpStrings = []
    for i in range(numOfTestCases):
        listOfInpStrings.append(input())
        listOfInpStrings.append(input())
    return numOfTestCases, listOfInpStrings

def buildPalindrome(stringA, stringB):
    numOfPalindromeStrings = 0
    listOfPalidromeStrings = []
    for i in range(len(stringA)):
        for j in range(i + 1, len(stringA) + 1):
            subStringA = stringA[i:j]
            for k in range(len(stringB)):
                for l in range(k + 1, len(stringB) + 1):
                    subStringB = stringB[k:l]
                    palindromeString = subStringA + subStringB
                    palindromeCheck = checkPalindromString(palindromeString)
                    if (palindromeCheck):
                        numOfPalindromeStrings+=1
                        negLengthOfPalindromeString = 0 - len(palindromeString)
                        listOfPalidromeStrings.append([palindromeString, negLengthOfPalindromeString])
    return numOfPalindromeStrings, listOfPalidromeStrings

def checkPalindromString(palindromeString):
    revPalindromeString = ''.join(reversed(palindromeString))
    if (palindromeString == revPalindromeString):
        return True
    else:
        return False

numOfTestCases, listOfInpStrings = readInput()
for i in range(numOfTestCases):
    j = 2 * i;
    stringA = listOfInpStrings[j]
    stringB = listOfInpStrings[j+1]
    numOfPalindromeStrings, listOfPalidromeStrings = buildPalindrome(stringA, stringB)
    if (numOfPalindromeStrings != 0):
        listOfPalidromeStrings.sort(key=lambda x:(x[1], x[0].lower()))
        print(listOfPalidromeStrings[0][0])
    else:
        print(-1)