class Node:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None


def build_BST(arr):
    if len(arr) < 1:
        return None

    mid = (len(arr)) // 2

    root = Node(arr[mid])

    root.left = build_BST(arr[:mid])
    root.right = build_BST(arr[mid + 1:])

    return root


def fun(root, tmp, constSum, S=0):

    if root is not None:

        tmpSum = 0
        for item in tmp:
            tmpSum += item.val
        if constSum - tmpSum != S:
            tmp = []
            S = constSum

        tmp.append(root)
        S -= root.val

        if S == 0:
            nodesList.append(tmp)
            tmp = []
            S = constSum
        elif S < 0:
            tmp = []
            S = constSum

        fun(root.left, tmp, constSum, S)
        fun(root.right, tmp, constSum, S)


def sort(arr):
    if len(arr) > 1:
        mid = len(arr) // 2

        L = arr[mid:]
        R = arr[:mid]

        sort(L)
        sort(R)

        i = j = k = 0

        while i < len(L) and j < len(R):
            if L[i] < R[j]:
                arr[k] = L[i]
                i += 1
            else:
                arr[k] = R[j]
                j += 1
            k += 1

        while i < len(L):
            arr[k] = L[i]
            i += 1
            k += 1
        while j < len(R):
            arr[k] = R[j]
            j += 1
            k += 1


array = []
file_name = input("Enter input file name: ")
constS = int(input("Enter S value: "))
with open(file_name) as f:
    for x in next(f).split():
        if int(x) != 0:
            array.append(int(x))

sort(array)
root = build_BST(array)
nodesList = []
fun(root, [], constS)

output_file = open("is92_morozov_08_output", "w+")

for x in nodesList:
    for item in x:
        print(item.val, end=" ")
        output_file.write(str(item.val) + " ")
    print()
    output_file.write("\n")
