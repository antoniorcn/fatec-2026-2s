lista1 = [0, 3, 6, 9, 12]
print("Lista 1: ", lista1)

# Lista com 150 numeros multiplos de 3
lista2 = []

# for i in range(150):
#     numero = i * 3
#     lista2.append( numero )
# print("Lista 2: ", lista2)

lista3 = [ i * 3  for i in range(20) ]
print("Lista3: ", lista3)

lista4 = lista3[2:7]
print("Sub lista: ", lista4)

lista5 = lista3[-1:-6:-1]
print("Sub lista final: ", lista5)


lista6 = [0, 1, 2, 3, 4]
lista7 = [5, 6, 7]
lista8 = lista6 + lista7

print("Lista6: ", lista6)
print("Lista7: ", lista7)
print("Lista8: ", lista8)

