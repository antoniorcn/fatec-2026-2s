import numpy as np

m1 = np.arange(1, 25).reshape( (6, 4) )
print("M1: ", m1)

m2 = m1[0, -1]
print("M2: ", m2)

m3 = m1[:, -1]
print("M3: ", m3)

m4 = m1[1:-1, 1:-1]
print("M4: ", m4)

m5 = m1[1:-1:1, -2:0:-1]
print("M5: ", m5)

m6 = np.sum(m5, axis=1, keepdims=True)
print("M6: ", m6)