"""
This tool samples N words from a list of words
"""

import random
import os
import time

f = open(input("File path:"), "r")
n = int(input("How many?"))
lines = [line.rstrip('\n') for line in f]
output = sorted(random.sample(lines, n))
# New file name is the name of the old file + number of words + unix time
filename = os.path.splitext(os.path.basename(f.name))[0] + str(n) + "_" + str(int(time.time()))
if set(output).__len__() == n: # making sure that all outputs are unique
    with open(os.path.join(os.path.dirname(__file__),filename + ".txt"), 'w') as w:
        for item in output:
            w.write("%s\n" % item)
    print("Done")
else:
    print("Set error")
