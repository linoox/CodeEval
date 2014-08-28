#include <stdio.h>

void checkEndianness() {

	unsigned int i = 1;
	char *c = (char*)&i;

	if(*c) {
		printf("LittleEndian");
	}
	else {
		printf("BigEndian");
	}

}

int main(int argc, char const *argv[])
{
	checkEndianness();

	return 0;
}