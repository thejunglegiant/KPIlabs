import Generate as gen
import matplotlib.pyplot as plt

test_range = [100, 200, 300, 400, 500, 600, 700, 800, 900, 1000]


def create_graph(sort_type, fun):
    arrays, counters = data_best(fun)
    plt.plot(arrays, counters, label="best")
    arrays, counters = data_random(fun)
    plt.plot(arrays, counters, label="random")
    arrays, counters = data_worst(fun)
    plt.plot(arrays, counters, label="worst")
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
