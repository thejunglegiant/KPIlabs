#include <iostream>
#include "LinkedList.h"
#include "Node.h"

using namespace std;

LinkedList::LinkedList() {
    root->value = 0;
    root->next = nullptr;
}

void LinkedList::push(int x) {
    Node* currentNode = this->root;

    while (true) {
        if (currentNode->next == nullptr) {
            currentNode->next = new Node(x);
            break;
        }

        currentNode = currentNode->next;
    }
}

void LinkedList::pop() {
    Node* currentNode = this->root;

    while (true) {
        if (currentNode->next->next == nullptr) {
            Node* n = currentNode->next;
            currentNode->next = nullptr;
            delete n;
            break;
        }

        currentNode = currentNode->next;
    }
}

int LinkedList::findAllMultiplesOfFive() {
    int counter = 0;
    Node* currentNode = this->root->next;

    while (true) {
        if (currentNode == nullptr || currentNode->next == nullptr) {
            break;
        }
        if ((int)currentNode->value % 5 == 0) {
            counter++;
        }

        currentNode = currentNode->next;
    }

    return counter;
}

Node* LinkedList::findMaxNode() {
    Node* currentNode = root;
    Node* maxNode = currentNode;

    while (currentNode->next != nullptr) {
        if (maxNode->value < currentNode->value) {
            maxNode = currentNode;
        }

        currentNode = currentNode->next;
    }

    return maxNode;
}

void LinkedList::deleteAllAfterMax() {
    Node* maxNode = findMaxNode();
    Node* currentNode = maxNode->next;
    maxNode->next = nullptr;
    while (currentNode != nullptr) {
        Node* n = currentNode;
        currentNode = currentNode->next;
        delete n;
    }
}

void LinkedList::printList() {
    Node* currentNode = root;

	while (currentNode != nullptr) {
		cout << currentNode->value << " ";
		currentNode = currentNode->next;
	}

	cout << endl;
}

LinkedList::~LinkedList() {
    while(root != nullptr) {
        Node * n = root->next;
        delete root;
        root = n;
    }
}