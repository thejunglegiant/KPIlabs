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
