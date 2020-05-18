#ifndef LINKEDLIST_H
#define LINKEDLIST_H

class LinkedList {
    private:
        int size;
        int* _list;
    public:
        LinkedList();
        void push(int);
        void pop();
        int findAllMultiplesOfFive();
        int findIndexOfMax();
        void deleteAllAfterMax();
        void printList();
};

#endif