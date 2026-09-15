import numpy as np

m1 = np.arange(1, 13).reshape((3, 4))
print("M1: ", m1)
m2 = m1 * 6
print("M2: ", m2)

m3 = m2 / m1
print("M3: ", m3)

m4 = m2 % 4
m5 = m4 == 0
m6 = m5.astype(np.int32)
print("M4: ", m4)
print("M5: ", m5)
print("M6: ", m6)

m7 = m2 * m6
print("M7: ", m7)

# m7 += 3
# print("M7: ", m7)

m8 = m7 / m7
print(m8)

m9 = np.isnan(m8)
print(m9)

m9_i = m8[m8 > 0]

m10 = m9_i.astype(np.int32)
print(m10)
