import numpy as np

array2 = np.array([ [2, 4], [5, 6], [7, 8] ], dtype=np.float32)  # 3 x 2
array3 = np.array([ [[3, 4, 5], [1, 2, 3]], [[3, 2, 1], [0, 4, 2]], [[1, 1, 1], [2, 2, 2]] ])  # 3 x 2 x 3 

print("Array2")
print("Numero de dimensoes: ", array2.ndim)
print("Formato: ", array2.shape)
print("Tipo de dados: ", array2.dtype)
print(array2)

print("Array3")
print("Numero de dimensoes: ", array3.ndim)
print("Formato: ", array3.shape)
print("Tipo de dados: ", array3.dtype)
print(array3)

zeros = np.zeros((10, 6), dtype=np.int32)
print(zeros)
ones = np.ones((10, 6), dtype=np.int32)
print(ones)

eye = np.eye(5)
print( eye )

arr1 = np.arange(0, 50, 1)
print(arr1)
arr2 = np.linspace(-10, 10, 100)
print(arr2)

gen = np.random.default_rng( 100 )
arr3 = gen.random((5, 4))
print(arr3)

arr4 = (arr3 * 10).astype(dtype=np.int32)
print(arr4)
