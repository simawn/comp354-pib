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

"""
r = requests.get("https://api.datamuse.com/words?rel_spc=ocean")
j = json.loads(r.text)
print(j[0]["word"])
"""
# C:\Users\Simon\Documents\Code\comp354-pib\tools\words100_1550871908.txt
# C:\Users\Simon\Documents\Code\comp354-pib\tools\words10_1550875193.txt

wordList = open(input("File path: "), "r")
lines = [line.rstrip('\n') for line in wordList]
output = {}

for line in lines:
    output[line] = {} # Actual word
    output[line]["syn"] = syn_search(line) # Create a "syn" attribute and setting it as an array
    #start appending

def syn_search(word):
    processArray = []

    searchType = "rel_syn" #refer to API docs
    apiCall = requests.get("https://api.datamuse.com/words?" + searchType + "=" + word)
    result = json.loads(apiCall.text)
    # loop through results and reject if:
    # contains more than 2 words
    # the actual word is contained in the synonym
    # if pass, append to array
    # stop and return array when array length 4. if less than 4:
    # run extra_search()
    return processArray

def extra_search(word):
    #extra search if there are less than 4 words found
    #rel_spc
    #rel_gen
    #rel_trg
    pass

"""
for line in lines:
    output[line] = {}
    output[line]["syn"] = []
    output[line]["syn"].append("syn1")
    output[line]["syn"].append("syn2")
    output[line]["syn"].append("syn3")

print(json.dumps(output))
"""
