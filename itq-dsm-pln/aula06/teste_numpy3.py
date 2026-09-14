import numpy as np

arr1 = np.ones( (3, 4) )
print(arr1)

arr2 = np.ones( (4, 3) )
print(arr2)

arr3 = arr1 @ arr2
print(arr3)

arr4 = np.reshape(arr1, (2, 6))
print(arr4)

arr5 = np.reshape(arr2, (3, 4))
arr6 = arr5 + arr1
print(arr6)


arr6 = arr2.T + arr1
print(arr6)