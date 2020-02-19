def bubble_sort(array):
    counter = 0
    n = len(array)
    for j in range(n):
        for k in range(0, n - 1):
            counter += 1
            if array[k] < array[k + 1]:
                array[k], array[k + 1] = array[k + 1], array[k]

    return array, counter


def improved_bubble_sort(array):
    counter = 0
    j = 1
    n = len(array)
    while j > 0:
        j = 0
        for k in range(0, n - j - 1):
            counter += 1
            if array[k] < array[k + 1]:
                array[k], array[k + 1] = array[k + 1], array[k]
                j += 1

    return array, counter


def insertion_sort(array):
    counter = 0
    for j in range(1, len(array)):
        key = array[j]
        k = j - 1
        while k >= 0 and key > array[k]:
            array[k + 1] = array[k]
            k -= 1
            counter += 1

        array[k + 1] = key
        counter += 1

    return array, counter
