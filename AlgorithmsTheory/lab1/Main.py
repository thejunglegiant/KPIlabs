import numpy as np

m = int(input("Input an amount of rows: "))
n = int(input("Input an amount of columns: "))

A = np.random.randint(10, size=(m,n))
print(A)
print()

for j in range(m):
    for k in range(0, m-j-1):
        if A[k][0] < A[k+1][0]:
            for i in range(0, n):
                temp = A[k][i]
                A[k][i] = A[k+1][i]
                A[k+1][i] = temp

print(A)