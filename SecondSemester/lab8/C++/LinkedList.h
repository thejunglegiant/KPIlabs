#ifndef LINKEDLIST_H
#define LINKEDLIST_H

#include "Node.h"

class LinkedList {
    private:
        Node* root = new Node;
        Node* findMaxNode();
    public:
        LinkedList();
        void push(int);
        void pop();
        int findAllMultiplesOfFive();
        void deleteAllAfterMax();
        void printList();

        ~LinkedList();
};

#endif