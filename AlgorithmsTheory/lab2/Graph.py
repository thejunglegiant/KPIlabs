import Generate as gen
import matplotlib.pyplot as plt
import InsertionSort as insert
import MergeSort as merge

test_range = [5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55]
# test_range = [10, 20, 30, 40, 50, 60, 70, 80, 90, 100]
# test_range = [100, 200, 300, 400, 500, 600, 700, 800, 900, 1000]


def create_graph(sort_type):
    if sort_type == "Best":
        arrays, counters = data_best(merge.merge)
        plt.plot(arrays, counters, label="Merge sort")
        arrays, counters = data_best(insert.insertion_sort)
        plt.plot(arrays, counters, label="Insertion sort")
    elif sort_type == "Random":
        arrays, counters = data_random(merge.merge)
        plt.plot(arrays, counters, label="Merge sort")
        arrays, counters = data_random(insert.insertion_sort)
        plt.plot(arrays, counters, label="Insertion sort")
    else:
        arrays, counters = data_worst(merge.merge)
        plt.plot(arrays, counters, label="Merge sort")
        arrays, counters = data_worst(insert.insertion_sort)
        plt.plot(arrays, counters, label="Insertion sort")

    plt.xlabel('number of elements')
    plt.ylabel('number of swaps')
    plt.title(sort_type)
    plt.legend()
    plt.show()


def data_best(sort_type):
    counters = []
    arrays = []
    for i in test_range:
        array = gen.array_best(i)
        _sorted, counter = sort_type(array)
        counters.append(counter)
        arrays.append(i)

    return arrays, counters


def data_random(sort_type):
    counters = []
    arrays = []
    for i in test_range:
        array = gen.array_random(i)
        _sorted, counter = sort_type(array)
        counters.append(counter)
        arrays.append(i)

    return arrays, counters


def data_worst(sort_type):
    counters = []
    arrays = []
    for i in test_range:
        array = gen.array_worst(i)
        _sorted, counter = sort_type(array)
        counters.append(counter)
        arrays.append(i)

    return arrays, counters
