import random

n = 10
evenArray = []
array = random.sample(range(1, 11), n)
print(array)

for j in range(n):
    for k in range(0, n - j - 1):
        if array[k] < array[k + 1]:
            array[k], array[k + 1] = array[k + 1], array[k]

for i in range(n):
    if array[i] % 2 == 0:
        evenArray.append(array[i])

print(evenArray)