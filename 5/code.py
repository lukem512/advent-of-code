#!/bin/python

# Advent of Code, day 5
# Luke Mitchell
# github.com/lukem512

import re

lines = [line.rstrip('\n') for line in open('input')]
n = 0
for line in lines:
	# A nice string:
	# 1.  contains at least 3 vowels.
	# 2.  contains at least one letter that appears twice in a row.
	# 3.  doesn't contain 'ab', 'cd', 'pq', or 'xy'
	#     even if they are part of one of the other requirements.

	# The Santa boolean
	nice = True

	# Check for condition #1
	vowels = ['a', 'e', 'i', 'o', 'u']
	letters = {}
	vowelCount = 0

	for letter in line:
		try:
			letters[letter] += 1
		except KeyError:
			letters[letter] = 1
	
	for vowel in vowels:
		if vowel in letters:
			vowelCount += letters[vowel]


	if vowelCount < 3:
		nice = False

	# Check for condition #2
	prev = ''
	found = False
	for letter in line:
		if letter == prev:
			found = True
			break
		prev = letter

	if not found:
		nice = False

	# Check for condition #3
	if 'ab' in line or 'cd' in line or 'pq' in line or 'xy' in line:
	    nice = False

	if nice:
		n = n+1
print n