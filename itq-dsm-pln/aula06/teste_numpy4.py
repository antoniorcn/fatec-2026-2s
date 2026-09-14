import numpy as np


# rng = np.random.default_rng(100)
# arr1 = rng.integers(1, 12, (3, 4))

arr1 = np.arange(1, 13).reshape( (3, 4) )
print("Original: ", arr1)

arr2 = arr1.reshape( (4, 3) )
print("Reshape (4, 3): ", arr2)

arr3 = arr1.T
print("T (4, 3): ", arr3)