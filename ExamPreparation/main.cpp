#include "module.h"

using namespace std;
using namespace myspace;

/*
Calculate matrix elements by rhombus.
*/

int main() {
    cout << "Enter a size of matrix: ";
    cin >> myspace::size;
    matrix = create_matrix(myspace::size);
    print_matrix(matrix, myspace::size);
    cout << "\nSum equals: " << count_matrix(matrix, myspace::size) << endl;

    return 0;
}