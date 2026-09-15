import numpy as np

obj_arquivo = np.load("./arquivo.npz")
m1 = obj_arquivo["matriz1"]
print("Matriz1: ", m1)
