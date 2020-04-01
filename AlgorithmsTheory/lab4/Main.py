import random


def array_best(length):
    return [x for x in range(length, 0, -1)]


def array_random(length):
    return random.sample(range(1, length + 1), length)


def array_worst(length):
    return [x for x in range(1, length + 1)]


def counting_sort(A, place):
    size = len(A)
    # Масив для запису остаточних даних.
    B = [0] * size
    # Тимчасовий масив для підрахування к-ті конкретних елементів у масиві А.
    C = [0] * 10

    # Підраховухємо к-ть кожного унікальних елементів у даному масиві.
    for i in range(0, size):
        C[A[i] // place % 10] += 1

    # Наступна операція допомагає у майбутньому розставити елементи у потрібні комірки.
    # Таким чином, якщо значення комірки під певним індексом дорівнює Х, то елемент, що дорівнює цьому індексу
    # буде мати Х-1 елементів меньших за нього.
    for i in range(1, 10):
        C[i] += C[i - 1]

    # Останнє, що залишається зробити -- це розташувати усі елементи у правильному порядку за допомогою допоміжного
    # масиву С за принципом, який я описав у минулому коментарі. Також на кожній ітерації ми декрементуємо counter на
    # одиницю, аби показати, що даний елемент уже відсортовано.
    for i in range(size - 1, -1, -1):
        B[C[A[i] // place % 10] - 1] = A[i]
        C[A[i] // place % 10] -= 1

    for i in range(0, size):
        A[i] = B[i]


def radix_sort(array):
    # d - к-ть розрядів, по яким варто відсортувати масив;
    # place - поточний розряд
    global d
    place = 1
    while d > 0:
        counting_sort(array, place)
        d -= 1
        place *= 10


d = int(input("Enter d value: "))
size = int(input("Enter length of the array: "))
arr = array_random(size)
print("Start array:")
print(arr)
radix_sort(arr)
print("Sorted array:")
print(arr)
