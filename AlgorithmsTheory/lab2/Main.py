import MergeSort as merge
import InsertionSort as insert
import time
import Tests as ts
import Graph as gr

# Tests
ts.merge_test(100)
ts.insertion_test(100)

# Graph
gr.create_graph("Best")
gr.create_graph("Random")
gr.create_graph("Worst")
