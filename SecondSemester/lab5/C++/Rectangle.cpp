#include "Shape.h"
#include "Rectangle.h"
#include <iostream>

Rectangle::Rectangle(double** coord, int size) : Shape(coord, size) {
    this->width = this->getLength(
        this->coord[0][0],
        this->coord[0][1],
        this->coord[0][0],
        this->coord[1][1]
    );
    this->length = this->getLength(
        this->coord[0][0],
        this->coord[0][1],
        this->coord[1][0],
        this->coord[0][1]
    );
}

double Rectangle::getArea() {
    return this->width * this->length;
}

double Rectangle::getPerimeter() {
    return 2 * (this->width + this->length);
}

void Rectangle::getInfo() {
    std::cout << "Width: " << this->width << std::endl;
    std::cout << "Length: " << this->length << std::endl;
}