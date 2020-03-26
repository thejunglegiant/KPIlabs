import Generate as gen
import matplotlib.pyplot as plt
import InsertionSort as insert
import MergeSort as merge
import Functions as fun

test_range = [x for x in range(0, 50)]


def create_graph(sort_type):
    if sort_type == "Best":
        arrays, counters = data_best(merge.sort)
        plt.plot(arrays, counters, label="Merge sort")
        arrays, counters = data_best(insert.sort)
        plt.plot(arrays, counters, label="Insertion sort")
        arrays, counters = data_best(fun.hybrid_sort)
        plt.plot(arrays, counters, label="Hybrid sort")
    elif sort_type == "Random":
        arrays, counters = data_random(merge.sort)
        plt.plot(arrays, counters, label="Merge sort")
        arrays, counters = data_random(insert.sort)
        plt.plot(arrays, counters, label="Insertion sort")
        arrays, counters = data_random(fun.hybrid_sort)
        plt.plot(arrays, counters, label="Hybrid sort")
    else:
        arrays, counters = data_worst(merge.sort)
        plt.plot(arrays, counters, label="Merge sort")
        arrays, counters = data_worst(insert.sort)
        plt.plot(arrays, counters, label="Insertion sort")
        arrays, counters = data_worst(fun.hybrid_sort)
        plt.plot(arrays, counters, label="Hybrid sort")

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
