#include <iostream>
#include "LinkedList.h"

LinkedList::LinkedList() {
    this->size = 1;
    this-> _list = new int[this->size];
}

void LinkedList::push(int x) {
    int* tmp = new int[++this->size];
    tmp[1] = x;

    for (int i = 1; i < this->size - 1; i++)
        tmp[i + 1] = this->_list[i];
    
    this->_list = tmp;
}

void LinkedList::pop() {
    int* tmp = new int[--this->size];

    for (int i = 0; i < this->size; i++)
        tmp[i] = this->_list[i];
    
    this->_list = tmp;
}

int LinkedList::findAllMultiplesOfFive() {
    int counter = 0;

    for (int i = 1; i < this->size; i++)
        if (this->_list[i] % 5 == 0)
            counter++;

    return counter;
}

int LinkedList::findIndexOfMax() {
    int max = this->_list[0];
    int index = 0;

    for (int i = 0; i < this->size; i++) {
        if (max < this->_list[i]) {
            max = this->_list[i];
            index = i;
        }
    }

    return index;
}

void LinkedList::deleteAllAfterMax() {
    this->size = this->findIndexOfMax() + 1;
    int* tmp = new int[this->size];

    for (int i = 0; i < this->size; i++) {
        tmp[i] = this->_list[i];
    }

    this->_list = tmp;
}

void LinkedList::printList() {
    for (int i = 0; i < this->size; i++)
        std::cout << this->_list[i] << " ";
    std::cout << std::endl;
}