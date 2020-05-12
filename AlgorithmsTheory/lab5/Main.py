def max_heapify(arr, n, i):
    largest = i
    l = 2 * i + 1
    r = 2 * i + 2

    # Первірка: чи існує ліва дочірня частина кореня, та чи більша вона за корень
    if l < n and arr[i] < arr[l]:
        largest = l

    # Первірка: чи існує права дочірня частина кореня, та чи більша вона за корень
    if r < n and arr[largest] < arr[r]:
        largest = r

    # Зміна кореня за потреби
    if largest != i:
        arr[i], arr[largest] = arr[largest], arr[i]
        max_heapify(arr, n, largest)


def min_heapify(arr, n, i):
    min = i
    l = 2 * i + 1
    r = 2 * i + 2

    # Первірка: чи існує ліва дочірня частина кореня, та чи меньша вона за корень
    if l < n and arr[i] > arr[l]:
        min = l

    # Первірка: чи існує права дочірня частина кореня, та чи меньша вона за корень
    if r < n and arr[min] > arr[r]:
        min = r

    # Зміна кореня за потреби
    if min != i:
        arr[i], arr[min] = arr[min], arr[i]
        min_heapify(arr, n, min)


def build_heap(arr, heapify):
    start_index = len(arr) // 2 - 1

    for i in range(start_index, -1, -1):
        heapify(arr, len(arr), i)


# Зчитування вхідного файлу
# file_name = input("Enter input file name: ")
input_file = open("input.txt", "r+")
temp = input_file.readlines()
input_file.close()

# Ініціалізація пірамід
Hlow = []  # незростаюча піраміда
Hhigh = []  # неспадна піраміда

output_file = open("is92_morozov_06_output.txt", "w+")

for i in range(1, int(temp[0]) + 1):
    num = int(temp[i])

    # Визначення піраміди, в яку буде записано наступне число
    if len(Hlow) > 0 and num < Hlow[0]:
        Hlow.append(num)
    else:
        Hhigh.append(num)

    # Збереження різниці кількості елементів кожної купи
    # Hlow не повинна бути більшою а меншою за розміром за Hhigh, і відповідно навпаки
    if len(Hlow) - len(Hhigh) > 1:
        Hhigh.append(Hlow[0])
        Hlow.pop(0)
    elif len(Hhigh) - len(Hlow) > 1:
        Hlow.append(Hhigh[0])
        Hhigh.pop(0)

    # Збереження структури купи
    build_heap(Hlow, max_heapify)
    build_heap(Hhigh, min_heapify)

    # Пошук медіани та її запис у вихідний файл
    if len(Hlow) == len(Hhigh):
        output_file.write(str(Hlow[0]) + " " + str(Hhigh[0]) + "\n")
        print(Hlow[0], Hhigh[0])
    elif len(Hhigh) - len(Hlow) > 0:
        output_file.write(str(Hhigh[0]) + "\n")
        print(Hhigh[0])
    elif len(Hlow) > 0:
        output_file.write(str(Hlow[0]) + "\n")
        print(Hlow[0])

output_file.close()
