import MergeSort as merge
import InsertionSort as insert
import Generate as gen
import time


def merge_test(length):
    print("Merge sort:")
    # best
    array = gen.array_best(length)
    t_first = time.process_time()
    print(f"Best set.\nStart array: {array}\nSorted: {merge.merge(array)}\n"
          f"Merge time: {time.process_time() - t_first}\n")
    # random
    array = gen.array_random(length)
    t_first = time.process_time()
    print(f"Random set.\nStart array: {array}\nSorted: {merge.merge(array)}\n"
          f"Merge time: {time.process_time() - t_first}\n")
    # worth
    array = gen.array_worst(length)
    t_first = time.process_time()
    print(f"Worth set.\nStart array: {array}\nSorted: {merge.merge(array)}\n"
          f"Merge time: {time.process_time() - t_first}\n")


def insertion_test(length):
    print("Insertion sort:")
    # best
    array = gen.array_best(length)
    t_first = time.process_time()
    print(f"Best set.\nStart array: {array}\nSorted: {insert.insertion_sort(array)}\n"
          f"Insertion time: {time.process_time() - t_first}\n")
    # random
    array = gen.array_random(length)
    t_first = time.process_time()
    print(f"Random set.\nStart array: {array}\nSorted: {insert.insertion_sort(array)}\n"
          f"Insertion time: {time.process_time() - t_first}\n")
    # worth
    array = gen.array_worst(length)
    t_first = time.process_time()
    print(f"Worth set.\nStart array: {array}\nSorted: {insert.insertion_sort(array)}\n"
          f"Insertion time: {time.process_time() - t_first}\n")