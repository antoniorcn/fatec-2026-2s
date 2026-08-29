# Faça um programa que mostre os
# números de 1 a 9 na mesma linha usando laço for
# Exemplo:  1  2  3  4  5  6  7  8  9
# for numero in range(1, 10):
#     print(numero, sep=" ", end=" ")
#     # print(numero, " ", end="")

#  Execute o conteudo do exercício anterior, 3 x seguidas
# Exemplo:  
# 1  2  3  4  5  6  7  8  9
# 1  2  3  4  5  6  7  8  9
# 1  2  3  4  5  6  7  8  9
for i in range(3):
    for numero in range(1, 10):
        print(numero, sep=" ", end=" ")
    print()