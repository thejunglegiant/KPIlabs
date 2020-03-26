import InsertionSort as insert
import MergeSort as merge
import Functions as fun
import Generate as gen


def merge_test(length):
    print("Merge sort:")
    # best
    array = gen.array_best(length)
    print(f"Best set.\nStart array: {array}\nSorted: {merge.sort(array)}\n")
    # random
    array = gen.array_random(length)
    print(f"Random set.\nStart array: {array}\nSorted: {merge.sort(array)}\n")
    # worth
    array = gen.array_worst(length)
    print(f"Worth set.\nStart array: {array}\nSorted: {merge.sort(array)}\n")


def insertion_test(length):
    print("Insertion sort:")
    # best
    array = gen.array_best(length)
    print(f"Best set.\nStart array: {array}\nSorted: {insert.sort(array)}\n")
    # random
    array = gen.array_random(length)
    print(f"Random set.\nStart array: {array}\nSorted: {insert.sort(array)}\n")
    # worth
    array = gen.array_worst(length)
    print(f"Worth set.\nStart array: {array}\nSorted: {insert.sort(array)}\n")


def hybrid_test(length):
    print("Hybrid sort:")
    # best
    array = gen.array_best(length)
    print(f"Best set.\nStart array: {array}\nSorted: {fun.hybrid_sort(array)}\n")
    # random
    array = gen.array_random(length)
    print(f"Random set.\nStart array: {array}\nSorted: {fun.hybrid_sort(array)}\n")
    # worth
    array = gen.array_worst(length)
    print(f"Worth set.\nStart array: {array}\nSorted: {fun.hybrid_sort(array)}\n")
