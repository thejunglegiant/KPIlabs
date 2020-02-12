#include "functions.h"

int increment(int a) {
    int counter = 0;

    while((a & (1 << counter)) > 0)
        counter++;

    a ^= ((1 << (counter + 1)) - 1);

    return a;
}

bool compareBinaries(int a, int b) {
    return !(a^b);
}