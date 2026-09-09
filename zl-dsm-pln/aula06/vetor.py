import numpy as np

v = [2, 4, 6]  # Vetor feito usando uma lista

print("Vetor V: ", v)

vetor_v = np.array( v, dtype=np.float32 )
print("Vetor V Numpy: ", vetor_v)
print("Dimensoes do vetor V: ", vetor_v.ndim)
print("Formato do vetor V: ", vetor_v.shape)
print("Tipo de dado do vetor V: ", vetor_v.dtype)
# print("Vetor V Transposto: ", np.transpose(vetor_v))
# print("Shape do Vetor V Transposto: ", np.transpose(vetor_v).shape)

print("Pegar a primeira celula do vetor V: ", vetor_v[ 0 ])