#include "Line.h"
#include <cstring>

void Line::init(char *arr) {
    this->size = strlen(arr);
    this->_line = new char[this->size];

    for (int i = 0; i < this->size; i++)
        this->_line[i] = arr[i];
}

Line::Line(int length) {
    this->_line = new char[length];
}

Line::Line(char *arr) {
    init(arr);
}

Line::Line(const Line &newLine) {
    init(newLine._line);
}

char* Line::getLine() {
    return this->_line;
}

Line Line::operator=(const Line &anotherLine) {
    if (this->_line != nullptr)
        delete [] this->_line;

    this->size = anotherLine.size;
    this->_line = new char[this->size];

    for (int i = 0; i < this->size; i++)
        this->_line[i] = anotherLine._line[i];

    return *this;
}

Line Line::operator+(const Line &anotherLine) {
    char *temp = new char[this->size + anotherLine.size];
    int i = 0;

    for (; i < this->size; i++)
        temp[i] = this->_line[i];

    for (; i < this->size + anotherLine.size; i++)
        temp[i] = anotherLine._line[i - this->size];

    return Line(temp);
}

Line Line::operator-(char symbol) {
    for (int i = 0; i < this->size; i++) {
        if (this->_line[i] == symbol) {
            char* temp = new char[this->size - 1];
            int j = 0;

            for (; j < i; j++) {
                temp[j] = this->_line[j];
            }
            for (; j < this->size - 1; j++) {
                temp[j] = this->_line[j+1];
            }
            
            return Line(temp);
        }
    }

    return *this;
}

Line::~Line() {
    delete [] this->_line;
}
