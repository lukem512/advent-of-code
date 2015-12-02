#!/bin/python

# Advent of Code, day 2
# Luke Mitchell
# github.com/lukem512

lines = [line.rstrip('\n') for line in open('input')]
n = 0
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
	n += min(sides)
print n