#include "Node.h"

Node::Node(int value) {
    this->value = value;
    this->next = nullptr;
}

Node::Node() {
    this->value = 0;
    this->next = nullptr;
}
