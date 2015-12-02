// Advent of Code, day 1
// Luke Mitchell
// github.com/lukem512

#include <string>
#include <fstream>
#include <streambuf>
#include <iostream>

using namespace std;

int main (int argc, char** argv) {

	// Read input file
	std::ifstream t("input");
	std::string str;

	t.seekg(0, std::ios::end);   
	str.reserve(t.tellg());
	t.seekg(0, std::ios::beg);

	str.assign((std::istreambuf_iterator<char>(t)),
	            std::istreambuf_iterator<char>());

	t.close();

	int n = 0;
	for (int i = 0; i < str.size(); i++) {
		if (str[i] == '(') n++;
		if (str[i] == ')') n--;
	}

	cout << n << std::endl;

	return 0;
}