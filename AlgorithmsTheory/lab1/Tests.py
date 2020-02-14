import Functions as fn
import random

def bubble_test(length):
    print("Bubble sort:")
    # best
    array = [x for x in range(length, 0, -1)]
    print(f"Best set.\nStart array: {array}\nSorted: {fn.bubble_sort(array)}\n")
    # random
    array = random.sample(range(1, length + 1), length)
    print(f"Random set.\nStart array: {array}\nSorted: {fn.bubble_sort(array)}\n")
    # worth
    array = [x for x in range(1, length + 1)]
    print(f"Worth set.\nStart array: {array}\nSorted: {fn.bubble_sort(array)}\n")

def improved_bubble_test(length):
    print("Improved bubble sort:")
    # best
    array = [x for x in range(length, 0, -1)]
    print(f"Best set.\nStart array: {array}\nSorted: {fn.improved_bubble_sort(array)}\n")
    # random
    array = random.sample(range(1, length + 1), length)
    print(f"Random set.\nStart array: {array}\nSorted: {fn.improved_bubble_sort(array)}\n")
    # worth
    array = [x for x in range(1, length + 1)]
    print(f"Worth set.\nStart array: {array}\nSorted: {fn.improved_bubble_sort(array)}\n")

def insertion_test(length):
    print("Insertion sort:")
    # best
    array = [x for x in range(length, 0, -1)]
    print(f"Best set.\nStart array: {array}\nSorted: {fn.insertion_sort(array)}\n")
    # random
    array = random.sample(range(1, length + 1), length)
    print(f"Random set.\nStart array: {array}\nSorted: {fn.insertion_sort(array)}\n")
    # worth
    array = [x for x in range(1, length + 1)]
    print(f"Worth set.\nStart array: {array}\nSorted: {fn.insertion_sort(array)}\n")
