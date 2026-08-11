lista = [1, 2, 3]

a = lista
b = lista.copy()

print("Lista: ", lista)
print("a: ", a)
print("b: ", b)

a_lista_mesma_coisa = a is lista
b_lista_mesma_coisa = b is lista
print("a e lista são a mesma coisa: ", a_lista_mesma_coisa)
print("b e lista são a mesma coisa: ", b_lista_mesma_coisa)