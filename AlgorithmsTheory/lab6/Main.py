import math
import sys


def dividing_hash(key, N):
    return key % N


def multiplexing_hash(key, N):
    A = (math.sqrt(5) - 1) / 2
    return int((N * (A * key % 1)))


def linear_probe(i, key, N):
    LINEAR_CONSTANT = 17
    return i * LINEAR_CONSTANT


def quadratic_probe(i, key, N):
    return pow(i, 2) + i


def double_probe(i, key, N):
    return i * dividing_hash(key, N - 1)


class ChainedHashTable(object):
    def __init__(self, length=5, hash_function=dividing_hash):
        self.array = [None] * length
        self.N = length
        self.hash = hash_function
        self.collisions = 0

    def set(self, key, value):
        index = self.hash(key, self.N)
        if self.array[index] is not None:
            # Такий індекс є зайнятим, тож ми перевіряємо ключ,
            # якщо знаходимо такий самий, то просто змінюємо значення.
            # В іншому випадку ми додаємо нову пару (ключ, значення) в ланцюжок.
            for item in self.array[index]:
                if item[0] == key:
                    item[1] = value
                    break
            else:
                self.collisions += 1
                self.array[index].append([key, value])
        else:
            # Такий індекс є не зайнятим, тож ми просто записуємо
            # пару (ключ, значення).
            self.array[index] = []
            self.array[index].append([key, value])

    def get(self, key):
        index = self.hash(key, self.N)
        if self.array[index] is None:
            return None
        else:
            # Пробігаємося по ланцюжку у пошуках потрібного ключа,
            # інакше повертаємо пусте значення/None.
            for item in self.array[index]:
                if item[0] == key:
                    return item

            return None


class OpenAddressHashTable(object):
    def __init__(self, length, probe_function=linear_probe):
        self.array = [None] * pow(length, 3)
        self.N = pow(length, 3)
        self.probe = probe_function
        self.collisions = 0

    def set(self, key, value):
        i = 1
        keyHash = dividing_hash(key, self.N)
        index = keyHash

        while self.array[index] is not None and self.array[index][0] != key:
            # Даний індекс уже зайнятий, тому шукаємо наступний.
            index = (keyHash + self.probe(i, key, self.N)) % self.N
            self.collisions += 1
            i += 1

        self.array[index] = [key, value]

    def get(self, key):
        i = 1
        keyHash = dividing_hash(key, self.N)
        index = keyHash

        if self.array[index] is None:
            return None

        while self.array[index] is not None and self.array[index][0] != key:
            # Даний індекс займає інший/чужий ключ, тому шукаємо наступний.
            index = (keyHash + self.probe(i, key, self.N)) % self.N
            i += 1

        return self.array[index]


# file_name = input("Enter input file name: ")
k = int(input("Choose a type of a hash-table [1-5]: "))
with open("input_1000.txt") as f:
    i = 0
    N, M = [int(x) for x in next(f).split()]
    A = []
    S = []
    for line in f:
        i += 1
        A.append(int(line))
        if i == N:
            break

    for line in f:
        S.append(int(line))

T = object
if k == 1:
    T = ChainedHashTable(N)
elif k == 2:
    T = ChainedHashTable(N, multiplexing_hash)
elif k == 3:
    T = OpenAddressHashTable(N)
elif k == 4:
    T = OpenAddressHashTable(N, quadratic_probe)
elif k == 5:
    T = OpenAddressHashTable(N, double_probe)
else:
    print("Wrong k value!")
    sys.exit()

for item in A:
    T.set(item, item)

output_file = open("is92_morozov_07_output.txt", "w+")
output_file.write(str(T.collisions) + "\n")
print(str(T.collisions))
for s in S:
    for x in A:
        tmp = T.get(s - x)
        if tmp is not None and s - x == tmp[0]:
            output_file.write(str(x) + " " + str(tmp[0]) + "\n")
            print(x, tmp[0])
            break
    else:
        output_file.write("0 0" + "\n")
        print(0, 0)
