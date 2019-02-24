"""
This tool fetches the possible synonyms of a word.
A visual check will be required to ensure that all the synonyms work

Using https://www.datamuse.com/api/

Library required: Requests:
pip install requests
"""

import os
import time
import requests
import json

# C:\Users\Simon\Documents\Code\comp354-pib\tools\words100_1550871908.txt
# C:\Users\Simon\Documents\Code\comp354-pib\tools\words10_1550875193.txt
MAX_SYN = 4

def main():
    wordList = open(input("File path: "), "r")
    lines = [line.rstrip('\n') for line in wordList]
    output = {}

    for line in lines:
        print("Working on: " + line)
        output[line] = {} # Actual word
        output[line]["syn"] = syn_search(line) # Create a "syn" attribute and setting it as an array

    jsonOutput = json.dumps(output)

    filename = os.path.splitext(os.path.basename(wordList.name))[0] + "_SYN_" + str(int(time.time()))
    with open(os.path.join(os.path.dirname(__file__),filename + ".json"), 'w') as w:
        w.write(jsonOutput)
    print("Done")

def syn_search(word):
    processArray = []

    searchType = "rel_syn" # Refer to API docs
    apiCall = requests.get("https://api.datamuse.com/words?" + searchType + "=" + word)
    apiResult = json.loads(apiCall.text)
    for result in apiResult:
        if processArray.__len__() is MAX_SYN:
            break
        curSyn = result["word"]
        # Check if current word is not in the clue and the clue is only 1 word
        if word not in curSyn and len(curSyn.split()) is 1:
            processArray.append(curSyn)

    # alt search
    if processArray.__len__() < MAX_SYN:
        extraApiCall = requests.get("https://api.datamuse.com/words?rel_trg=" + word)
        extraApiCallResult = json.loads(extraApiCall.text)
        for extraResult in extraApiCallResult:
            if processArray.__len__() is MAX_SYN:
                break
            curSyn = extraResult["word"]
            if word not in curSyn and len(curSyn.split()) is 1:
                processArray.append(curSyn)

    return processArray

main()
