import random


def array_best(length):
    return [x for x in range(length, 0, -1)]


def array_random(length):
    return random.sample(range(1, length + 1), length)


def array_worst(length):
    return [x for x in range(1, length + 1)]
