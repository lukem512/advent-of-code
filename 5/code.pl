#!/bin/perl

# Advent of Code, day 5
# Luke Mitchell
# github.com/lukem512

use strict;
use warnings;

my $file = 'input';
open my $info, $file or die "Santa lost his list!";

my $n = 0;
my $found = 1;
while(my $line = <$info>) {   
    $found = 1;

	# Check for a pair of any two letters that appears
    # at least twice in the string without overlapping
    # i.e. 'xyxy' or 'aabcdefgaa' but not 'aaa'
    if ($line =~ /([a-z][a-z])[a-z]*\1+/) {
    	# Do nothing
    } else {
    	$found = 0;
    }

    # Check for at least one letter which repeats
    # with exactly one letter between them
    # i.e. 'xyx', 'abcdefeghi', 'efe' or 'aaa'
    if ($line =~ /([a-z])[a-z]\1+/) {
        # Do nothing
    } else {
        $found = 0;
    }

    if ($found) {
    	$n++;
    }
}

print "Santa has " . $n . " names on his nice list.\n";

close $info;