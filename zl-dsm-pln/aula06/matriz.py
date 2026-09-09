import numpy as np

m = [
    [1, 2, 3],
    [4, 5, 6]
]  # Matriz 2 x 3 usando listas

matriz = np.array( m, dtype=np.float64)

print("Matriz em lista: ", m)
print("Matriz Numpy: ", matriz)
print("Dimensoes da Matriz: ", matriz.ndim)
print("Formato da Matriz: ", matriz.shape)
print("Tipo de dados da Matriz: ", matriz.dtype)
print("Matriz transposta: ", matriz.T)

# m_buraco = [
#     [2, 0, 0, 1],
#     [0, 0, 1],
#     [3, 4, 5, 6]
# ]
# matriz_buraco = np.array(m_buraco)
# Gera erro informando que a matriz não está homogênea

vetor1d = np.arange(-10, 10.1, 0.1)
print("Vetor arange: ", vetor1d)
print("Vetor arange Dimensoes: ", vetor1d.ndim)
print("Vetor arange Shape: ", vetor1d.shape)

m1 = np.ones((3, 4))
print(m1)

m0 = np.zeros((3, 4))
print(m0)

array_conc = np.concatenate( [m1, m0], axis=1 )
print("Array Concatenado: ", array_conc)
print("Array Concatenado Tipo: ", array_conc.dtype)

array_int = array_conc.astype(np.int32)
print("Array Inteiros: ", array_int)

array_bool = array_conc.astype(np.bool)
print("Array Boolean: ", array_bool)


print("Matriz: ", matriz)
print("Matriz Shape: ", matriz.shape)

# m_ones = np.ones( matriz.shape )
m_ones = np.ones_like( matriz )
print("Matriz ones: ", m_ones)

print("Matriz aleatoria")
arr_random = np.random.random((10, 4))
print(arr_random)
# arr_random[5][2]   # Se fosse uma lista acessaria dessa maneira

print(arr_random[5, 2])  # Acesso a elementos dentro de uma matriz com mais de uma dimensão


arr_identidade = np.eye( 9 )
print("Array identidade: ", arr_identidade)

arr_iden_3 = arr_identidade * 3
print(arr_iden_3)

arr_iden_15 = arr_identidade + 15
print(arr_iden_15)

arr_soma = arr_iden_15 + arr_iden_3
print(arr_soma)

arr1 = np.array([
    [3, 4, 5],
    [6, 7, 8]
])

arr2 = np.array([
    [8, 9],
    [1, 2],
    [3, 4]
])

# é possivel multiplicar matrizes ex: 2x3 @ 3x2

print("Arr1: ", arr1)
print("Arr2: ", arr2)
mult = arr1 @ arr2
print("Multplicacao: ", mult)

# Não da para multiplicar matrizes ex: 3x2 @ 2x3
# mult = arr1 @ arr2.T
# print("Multplicacao Aray2 transposto: ", mult)