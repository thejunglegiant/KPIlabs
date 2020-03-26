file_name = input("Enter input file name: ")
input_file = open(file_name, "r+")
temp = input_file.readlines()
array_first = []
array_second = []

for i in range(1, int(temp[0]) + 1):
    array_first.append(int(temp[i]))
    array_second.append(int(temp[i]))

input_file.close()


def partition(arr, low, high):
    counter = 0
    pivot = arr[high]
    i = low - 1

    for j in range(low, high):
        counter += 1
        if arr[j] < pivot:
            i += 1
            arr[i], arr[j] = arr[j], arr[i]

    arr[i + 1], arr[high] = arr[high], arr[i + 1]
    return i + 1, counter


def quick_sort(arr, low, high):
    counter = 0

    if low < high:
        pivot, counter = partition(arr, low, high)
        counter += quick_sort(arr, low, pivot - 1)
        counter += quick_sort(arr, pivot + 1, high)

    return counter


def median_of_three(arr, low, high):
    mid = (low + high) // 2
    a = arr[low]
    b = arr[mid]
    c = arr[high]
    if a <= b <= c:
        return b, mid
    if c <= b <= a:
        return b, mid
    if a <= c <= b:
        return c, high
    if b <= c <= a:
        return c, high
    return a, low


def partition_median(arr, low, high):
    counter = 0
    pivot, elem_to_swap = median_of_three(arr, low, high)
    arr[high], arr[elem_to_swap] = arr[elem_to_swap], arr[high]
    i = low - 1

    for j in range(low, high):
        counter += 1
        if arr[j] < pivot:
            i += 1
            arr[i], arr[j] = arr[j], arr[i]

    arr[i + 1], arr[high] = arr[high], arr[i + 1]
    return i + 1, counter


def quick_sort_median(arr, low, high):
    counter = 0

    if low < high:
        pivot, counter = partition_median(arr, low, high)
        counter += quick_sort_median(arr, low, pivot - 1)
        counter += quick_sort_median(arr, pivot + 1, high)

    return counter


counter_first = quick_sort(array_first, 0, len(array_first) - 1)
counter_second = quick_sort_median(array_second, 0, len(array_second) - 1)

output_file = open("is92_morozov_04_output.txt", "w+")

for i in range(len(array_second)):
    if i == 4:
        output_file.write(str(array_second[i]) + "\t\t" + str(counter_first) + " " + str(counter_second) + "\n")
    else:
        output_file.write(str(array_second[i]) + "\n")

output_file.close()
