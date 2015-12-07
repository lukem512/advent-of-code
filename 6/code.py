#!/bin/python

import re

# Advent of Code, day 6
# Luke Mitchell
# github.com/lukem512

def modifier(command, part2 = False):
    if command == "toggle":
        if (part2):
            return lambda x: x+2
        else:
            return lambda x: 1-x
    if command == "turn on":
        if (part2):
            return lambda x: x+1
        else:
            return lambda x: 1
    if command == "turn off":
        if (part2):
            return lambda x: 0 if x <= 0 else x-1
        else:
            return lambda x: 0
    return None

def modify(lights, start, end, do):
    for x in xrange(int(start[0]), int(end[0]) + 1):
        for y in xrange(int(start[1]), int(end[1]) + 1):
            lights[x][y] = do(lights[x][y])

lines = [line.rstrip('\n') for line in open('input')]

lights = [[0]*1000 for x in range(1000)]
for line in lines:
    tokens = line.split(' ')
    m = re.search('(?P<command>\w+( \w*)?) (?P<start>\d+,\d+) through (?P<end>\d+,\d+)', line)
    modify(lights, m.group('start').split(','), m.group('end').split(','), modifier(m.group('command'), True))

sums = [sum(x) for x in zip(*lights)]
print (sum(sums))
