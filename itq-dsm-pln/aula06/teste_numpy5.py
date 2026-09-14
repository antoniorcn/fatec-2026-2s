import numpy as np


arr1 = np.array([ [1, 2, 3], [4, 5, 6] ] )
arr2 = arr1
arr3 = arr1[:2, :2]
arr4 = arr1.copy()

arr1[0,0] = 100

print("arr1: ", arr1)
print("arr2: ", arr2)
print("arr3: ", arr3)
print("arr4: ", arr4)
