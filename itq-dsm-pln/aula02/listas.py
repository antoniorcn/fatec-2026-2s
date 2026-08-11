#        0, 1,  2,    3,       4
# lista = [2, 7, "Oi", True, [1, 2, 3] ]

# print("O que esta no indice 2: ", lista[2])
# print("O que esta no indice 4: ", lista[4])
# print("O que esta no indice 4 apenas o numero 3: ",
#       lista[4][2])

# #  0  1  2
# # [1, 2, 3]

# print("Como pegar apenas os indices pares da lista: ")
# print( lista[0:5:2] )

# print("Como pegar o (i) do texto")
# #                01 
# print("Letra: ", lista[2][1])   # "Oi"

# #        012 
# texto = "Ola"
# print("Texto: ", texto[0:2])

# for i in lista:
#     print(i)
#           +0      +10      +20
#        0123456789012345678901234
# texto = "Adoro programar em Python"
# lista_texto = list(texto)
# print(lista_texto)

# numeros = [1, 3, 4, 5, 6]
# lista_potencias_2 = []

# for n in numeros:
#     lista_potencias_2.append( n ** 2 )
#     print(lista_potencias_2)

# lista_potencias_2 = [n**2  for n in numeros]
# print(lista_potencias_2)


# lista_estrelinhas = ["*" for _ in range(10)]
# print(lista_estrelinhas)

# texto_estrelinhas = "*" * 10
# print(texto_estrelinhas)

# lista_estrelinhas = list(texto_estrelinhas)
# print(lista_estrelinhas)

lista_numeros = [i for i in range(1, 21)]
print(lista_numeros)
#  0  1  2  3  4  5  6  7  8   9  10  11  12  13  14  15  16  17  18  19
# [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20]

# conjunto_numeros_8_ao_16 = lista_numeros[7:16]
# print(conjunto_numeros_8_ao_16)

# os_ultimos_3_numeros = lista_numeros[-1:-4:-1]
# print("ultimos 3 numeros: ", os_ultimos_3_numeros)

lista_invertida = lista_numeros[::-1]
print("lista invertida: ", lista_invertida)

elemento4 = lista_invertida[4]
print("Elemento 4: ", elemento4)
print("lista invertida: ", lista_invertida)

elemento4 = lista_invertida.pop(4)
print("Elemento 4: ", elemento4)
print("lista invertida (alterada com Pop): ", lista_invertida)

