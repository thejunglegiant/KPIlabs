import Tests as ts
import Graph as gr
import Functions as fn

# array length
length = 10

ts.bubble_test(length)
ts.improved_bubble_test(length)
ts.insertion_test(length)

# graphics, if needed
gr.create_graph("Bubble sort", fn.bubble_sort)
gr.create_graph("Improved bubble sort", fn.improved_bubble_sort)
gr.create_graph("Insertion sort", fn.insertion_sort)