import Generate as gen

import Tests as ts
import Graph as gr
import Functions as fun

# array length
length = 10

ts.bubbletest(length)
ts.improved_bubble_test(length)
ts.insertion_test(length)

# graphics, if needed
gr.create_graph("Bubble sort", fun.bubble_sort)
gr.create_graph("Improved bubble sort", fun.improved_bubble_sort)
gr.create_graph("Insertion sort", fun.insertion_sort)