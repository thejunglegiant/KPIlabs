import InsertionSort
import MergeSort


def hybrid_sort(array):
    if len(array) < 20:
        return InsertionSort.sort(array)
    else:
        return MergeSort.sort(array)
