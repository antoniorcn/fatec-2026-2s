import numpy as np

dados = np.array([5, 7, 8, 10, 10])
print(dados)
print("Soma: ", dados.sum())
print("Media: ", dados.mean())
print("Min: ", dados.min())
print("Max: ", dados.max())
print("Mediana: ", np.median(dados))
print("Desvio padrao: ", dados.std())
