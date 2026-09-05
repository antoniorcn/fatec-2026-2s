print("Programa que soma dois numeros")
print("")
print("Por favor digite um numero: ")
try:
    n1 = int( input() )
except ValueError as err:
    print("Você precisa digitar um numero valido")
    print(f"Porque deu erro: {err}")

print("Por favor digite outro numero: ")
n2 = int( input() )

soma = n1 + n2

print(f"A soma é: {soma}")

print("Fim do programa")