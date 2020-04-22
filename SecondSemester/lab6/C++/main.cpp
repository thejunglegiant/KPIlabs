#include <iostream>
#include "Expression.h"

using namespace std;

int main() {
    Expression expression = Expression(2, 11, 0);
    cout << expression.getAnswer() << endl;

    return 0;
}