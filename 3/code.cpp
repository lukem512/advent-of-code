// Advent of Code, day 3
// Luke Mitchell
// github.com/lukem512

#include <string>
#include <fstream>
#include <streambuf>
#include <iostream>
#include <map>

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

class Coordinates {
public:
	int lat;
	int lon;

	Coordinates() {
		lat = 0;
		lon = 0;
	}
};

namespace std {
	template<> struct less<Coordinates>
	{
	   bool operator() (const Coordinates& lhs, const Coordinates& rhs) const
	   {
	   		if (lhs.lon == rhs.lon)
	   			return lhs.lat < rhs.lat;
	   		else
	   			return lhs.lon < rhs.lon;
	   }
	};
}

int main (int argc, char** argv) {

	string str = readFile("input");

	std::map<Coordinates, int> houses;

	Coordinates coords;

	// First house
	houses[coords]++;

	for (int i = 0; i < str.size(); i++) {
		switch(str[i]) {
			case '<':
				coords.lat++;
			break;

			case '>':
				coords.lat--;
			break;

			case '^':
				coords.lon++;
			break;

			case 'v':
				coords.lon--;
			break;
		}

		houses[coords]++;
	}

	cout << "Santa delivered at least one present to " << houses.size() << " houses!" << endl;

	return 0;
}
