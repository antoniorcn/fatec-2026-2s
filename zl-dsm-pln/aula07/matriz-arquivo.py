import numpy as np

m1 = np.arange(0, 24).reshape((4,6))
print("M1: ", m1)

np.savez("./arquivo.npz", matriz1=m1)
