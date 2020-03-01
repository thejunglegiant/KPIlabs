#include <iostream>
#include <cstring>
#include "Line.h"

using namespace std;

Line::Line(char* Line) {
    this->line = Line;
}

int Line::getLength() {
    return strlen(line);
}

int Line::findElement(char obj) {
    int times = 0;

    for(int j = 0; j < strlen(line); j++) {
        if(line[j] == obj) {
            times += 1;
        }
    }

    return times;
}

void Line::outputString() {
    for(int j = 0; j < strlen(line); j++)
        cout << line[j];
    cout << endl;
}