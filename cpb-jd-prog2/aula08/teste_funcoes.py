"""
Codigo para testar funcoes na aula 08
"""

from matematica import somar_numeros, dividir_numeros,\
    divisao_escolar, somar_numeros_varios


s = somar_numeros(20, 50)
print( "Soma dos numeros: ", s )

s = dividir_numeros(10, 2)
print( "Divisao dos numeros: ", s )

# n1 = int(input("Digite o primeiro numero: "))
# n2 = int(input("Digite o primeiro numero: "))
# s = somar_numeros( n1, n2 )

# print( "Soma dos numeros: ", s )
s = somar_numeros_varios(5, 4, 3, 2, 1)
print("Soma de varios numeros: ", s)


n1 = int(input("Digite o primeiro numero: "))
n2 = int(input("Digite o primeiro numero: "))
q, r = divisao_escolar( n1, n2 )

print(f"Divisao Escolar dos numeros, quociente {q} resto {r}")
