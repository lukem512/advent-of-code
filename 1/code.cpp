// Advent of Code, day 1
// Luke Mitchell
// github.com/lukem512

#include <string>
#include <fstream>
#include <streambuf>
#include <iostream>

using namespace std;

// Read input file
std::string readFile (std::string filename) {
	std::ifstream t("input");
	std::string str;

	t.seekg(0, std::ios::end);   
	str.reserve(t.tellg());
	t.seekg(0, std::ios::beg);

	str.assign((std::istreambuf_iterator<char>(t)),
	            std::istreambuf_iterator<char>());

	t.close();

	return str;
}

int main (int argc, char** argv) {

	string str = readFile("input");

	int n = 0;
        bool part2complete = false;
	for (int i = 0; i < str.size(); i++) {
		if (str[i] == '(') n++;
		if (str[i] == ')') n--;
                if (!part2complete && n < 0) {
                    cout << "Santa entered the basement at character " << i+1 << endl;
                    part2complete = true;
                }
	}

	cout << "Santa finished on floor " << n << std::endl;

	return 0;
}
