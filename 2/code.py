#!/bin/python

# Advent of Code, day 2
# Luke Mitchell
# github.com/lukem512

lines = [line.rstrip('\n') for line in open('input')]
n = 0
ribbon = 0
for line in lines:
	dimensions = line.split('x')
	# Compute area
	l = int(dimensions[0])
	w = int(dimensions[1])
	h = int(dimensions[2])
	n += 2*l*w + 2*w*h + 2*h*l
	# Compute slack
	# 'area of the smallest side'
	sides = [l*w, l*h, w*h]
        sides = sorted(sides);
        n += sides[0]
        # Compute length of ribbon
        # 'shortest distance around its sides'
        lengths = [l, w, h]
        lengths = sorted(lengths)
        ribbon += 2*lengths[0] + 2*lengths[1]
        # Compute length of bow
        ribbon += l*w*h
print n
print ribbon
