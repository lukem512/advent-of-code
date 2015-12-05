#!/bin/perl

# Advent of Code, day 5
# Luke Mitchell
# github.com/lukem512

use strict;
use warnings;

my $file = 'input';
open my $info, $file or die "Santa lost his list!";

my $n = 0;
while(my $line = <$info>) {   
	my $found = 1;

	# Check for vowels
    if ($line =~ /((a|e|i|o|u)[a-z]*){3}/) {
    	# Do nothing
    } else {
    	$found = 0;
    }

	# Check for repeated pairs
    if ($line =~ /([a-z])\1+/) {
    	# Do nothing
    } else {
    	$found = 0;
    }

    # Check for rejected pairs
    if ($line =~ /(ab)|(cd)|(pq)|(xy)/) {
    	$found = 0;
    }

    # print $found;
    if ($found) {
    	$n++;
    }
}

print "Santa has " . $n . " names on his nice list.\n";

close $info;