#include "Expression.h"
#include <cmath>
#include <stdexcept>

Expression::Expression(double a, double c, double d) {
    this->_a = a;
    this->_c = c;
    this->_d = d;
}

double Expression::fun() {
    return (2*this->_c - this->_d*sqrt(42*this->_d))
        / (this->_c + this->_a - 1);
}

double Expression::getAnswer() {
    if (this->_c + this->_a == 1)
        throw std::invalid_argument("Division by zero is impossible!");

    if (this->_d <= 0)
        throw std::invalid_argument("d value must be strictly more than zero!");

    return fun();
}

// setters and getters
void Expression::setA(double a) {
    this->_a = a;
}
double Expression::getA() {
    return this->_a;
}
void Expression::setC(double c) {
    this->_d = c;
}
double Expression::getC() {
    return this->_c;
}
void Expression::setD(double d) {
    this->_d = d;
}
double Expression::getD() {
    return this->_d;
}
