import numpy as np

matriz_1 = np.ones((4, 3))

matriz_0 = np.zeros((4, 3))

print("matriz_1: ", matriz_1)
print("matriz_0: ", matriz_0)

nova_matriz = np.concatenate( [matriz_0, matriz_1], axis=1 )
print("Nova Matriz: ", nova_matriz)
print(f"Dims: {nova_matriz.ndim}\tShape: {nova_matriz.shape}")

matriz_stack = np.stack([matriz_0, matriz_1])
print("Matriz Stack: ", matriz_stack)
print(f"Dims: {matriz_stack.ndim}\tShape: {matriz_stack.shape}")

m_stack2 = matriz_stack + 5
print("Matriz Stack 2: ", m_stack2)

m1_t = matriz_1.T
print("Matriz 1: ", matriz_1)
print("Matriz 1 (transposta): ", m1_t)

m_stack3 = matriz_stack + matriz_1
print("Matriz Stack 3: ", m_stack3)

# m_stack4 = matriz_stack + m1_t      # Não funciona
# print("Matriz Stack 4: ", m_stack4)

print("Matriz 1: ", matriz_1)  # 4 x 3
m1_6x2 = matriz_1.reshape((6, 2))
print("Matriz 1 (6x2): ", m1_6x2)  # 4 x 3

v1 = np.arange(0, 12)
print("V1: ", v1)
m2 = v1.reshape((4, 3))
print("M2: ", m2)

m3 = m2.reshape((3, 4))
print("M3: ", m3)

m4 = m2.T
print("M4: ", m4)


m5 = np.arange(1, 13).reshape((3, 4))
m6 = m5
m7 = m5[:2, :3]
m8 = m5.copy()

m5[1, 2] = 17

print("M5: ", m5)
print("M6: ", m6)
print("M7: ", m7)
print("M8: ", m8)
