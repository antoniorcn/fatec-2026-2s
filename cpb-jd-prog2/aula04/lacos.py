# print("Inicio do programa")
# a = 0
# while a <= 5:
#     a = a + 1
#     if a == 3:
#         continue
#     if a == 4:
#         break
#     print(f"executando {a}...")

# print("Fim do programa")

print("Inicio do Programa")

# for i in range(3, 10):
#     print(f"executando {i}...")

#                inicio   termino (exclusivo)   passo
for numero in range(0,      11,                  2):
    print(f"Numero: {numero}")
    if numero == 8:
        break
else:
    print("Imprimi os numeros pares de 0 a 10")
print("Fim do Programa")