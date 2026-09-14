import numpy as np
# Combinação

rng = np.random.default_rng(50)

arr1 = rng.random((4, 3))
arr2 = rng.random((4, 3))

arr3 = np.concatenate([arr1, arr2], axis=1)
print(arr1)
print(arr2)
print(arr3)

arr4 = np.stack([arr1, arr2])
print(arr4)

arr5 = arr4 * 10
print(arr5)