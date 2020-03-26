global counter


def merge_sort(array):
    global counter
    if len(array) > 1:
        counter += 1
        mid = len(array) // 2
        L = array[:mid]
        R = array[mid:]
        merge_sort(L)
        merge_sort(R)

        l = r = c = 0

        while l < len(L) and r < len(R):
            if L[l] > R[r]:
                array[c] = L[l]
                l += 1
            else:
                array[c] = R[r]
                r += 1
            c += 1
            counter += 1

        while l < len(L):
            array[c] = L[l]
            l += 1
            c += 1
            counter += 1

        while r < len(R):
            array[c] = R[r]
            r += 1
            c += 1
            counter += 1

        return array


def sort(array):
    global counter
    counter = 0
    arr = merge_sort(array)

    return arr, counter
