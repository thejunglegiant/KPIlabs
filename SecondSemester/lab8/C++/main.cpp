#include <iostream>
#include <ctime>
#include "LinkedList.h"

using namespace std;

int main() {
    srand(time(NULL));
    LinkedList list = LinkedList();
    
    for (int i = 0; i < 10; i++)
        list.push(rand() % 100);
    
    list.printList();
    cout << endl;
    cout << "Amount of numbers which are multiples of five: "
        << list.findAllMultiplesOfFive() << endl;
    cout << endl;
    list.deleteAllAfterMax();
    list.printList();
    list.pop();
    list.printList();

    return 0;
}