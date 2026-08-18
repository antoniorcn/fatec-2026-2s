#          0   1   2
lista1 = [ 10, 20 ,30 ]

#          0        1        2
lista2 = [ "Joao", "Maria", "Jose"]

#          0   1      2                3     4     5
lista3 = [ 50, True, ["A", "B", "C"], 45.9, None, "Texto"]

                      #   0    1    2 
letras = lista3[2]    # ["A", "B", "C"]

letra_b = lista3[2][1]

print("Lista1: ", lista1)
print("Lista2: ", lista2)
print("Lista3: ", lista3)
print("Letras: ", letras)
print("Letra B: ", letra_b)

lista_vazia = list()

texto = "Eu gosto de programar em Python"

letras_texto = list( texto )

print("Letras do texto: ", letras_texto)
letras_ordenadas = letras_texto.copy()
letras_ordenadas.sort()
print("Letras ordenadas: ", letras_ordenadas)

# lista_pares = range(0, 201, 2)
# lista_pares = []
# for i in range(0, 201, 2):
#     lista_pares.append( i )


lista_pares = [i * 4 for i in range(0, 101)]

print("Numeros Pares: ", lista_pares)


# Matriz 3 x 4
# (
#   1    1    1    1
#   2    2    0    2
#   3    0    0    2 
# )

matriz3x4 = [
    [1, 1, 1, 1],
    [2, 2, 0, 2],
    [3, 0, 0, 2]
]

valor = matriz3x4[2][3]
print(valor)

#                 0  1  2  3  4  5   6   7   8   9   10  11  12  13
numeros_primos = [1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41]

print(numeros_primos[0:6])
print(numeros_primos[4:10])
print(numeros_primos[3:11:2])


print(numeros_primos[-3:-1])
print(numeros_primos[-3:])

print(numeros_primos[-1:-4:-1])
print(numeros_primos[::-1])

tamanho = len(numeros_primos)
print("Numeros Primos: ", numeros_primos)
print("Numeros Primos Inverso: ", numeros_primos[::-1])
print("Tamanho da lista: ", tamanho)

numeros_primos2 = [47, 53, 61]
print("Numeros Primos: ", numeros_primos)
print("Numeros Primos segunda lista: ", numeros_primos2)
numeros_primos.extend(numeros_primos2)
print("Todos os numeros Primos: ", numeros_primos)

#   0  1  2  3  4  5   6   7   8   9   10  11  12  13  14  15  16
#  [1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 47, 53, 61]

numeros_primos.insert(10, 27)

print("Todos os numeros Primos incluindo o numero 27: ", numeros_primos)

try:
    pos = numeros_primos.index(8)
    print("Encontramos o numero 8 na lista de primos na posicao", pos)
except: 
    print("Numero 8 não foi encontrado na lista de primos")


numeros_primos.extend([1, 3, 5, 5, 7, 7, 11])

qtd_numeros_1 = numeros_primos.count(1)
qtd_numeros_3 = numeros_primos.count(3)
qtd_numeros_5 = numeros_primos.count(5)
qtd_numeros_7 = numeros_primos.count(7)
qtd_numeros_11 = numeros_primos.count(11)

print("Nova Lista de numeros primos: ", numeros_primos)
print("Quantidade de numeros 1: ", qtd_numeros_1)
print("Quantidade de numeros 3: ", qtd_numeros_3)
print("Quantidade de numeros 5: ", qtd_numeros_5)
print("Quantidade de numeros 7: ", qtd_numeros_7)
print("Quantidade de numeros 11: ", qtd_numeros_11)

numeros_primos3 = numeros_primos.copy()

print("Numeros Primos: ", numeros_primos)
print("Numeros Primos3: ", numeros_primos3)

valor_extraido = numeros_primos.pop(6) # Remove e retorna o elemento pelo indice
print("Valor extraido da lista: ", valor_extraido)

valor_extraido = numeros_primos.remove(11) # Remove a primeira ocorrencia pelo valor e não retorna nada
print("Valor extraido da lista: ", valor_extraido)


print("Numeros Primos: ", numeros_primos)
print("Numeros Primos3: ", numeros_primos3)
