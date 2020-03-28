#include "Shape.h"
#include <cmath>

Shape::Shape(double** coord, int size) {
    this->size = size;
    this->coord = coord;
}

double Shape::getLength(double x, double y, double a, double b) {
    return sqrt(pow((a - x), 2) + pow((b - y), 2));
}

Shape::~Shape() {
    for (int i = 0; i < this->size; i++)
        delete [] this->coord[i];
    delete [] this->coord;
}