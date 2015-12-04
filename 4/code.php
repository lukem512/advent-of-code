<?php

// Advent of Code, day 4
// Luke Mitchell
// github.com/lukem512

$input = "yzbqklnj";
$nNonce = 0;

$nZeroes = 5;

$found = false;
while (!$found) {
	$hash = md5($input.$nNonce);

	$found = true;
	for ($i = 0; $i < $nZeroes; $i++) {
	    if ($hash[$i] != "0") {
	    	$found = false;
	    }
	}

	if ($found) {
		print ($hash);
		print ("\n");
		print ($nNonce);
		print ("\n");
	}

	$nNonce++;
}

?>
