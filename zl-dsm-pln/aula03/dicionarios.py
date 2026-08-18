texto = "ABC123"
nome1 = "Joao Silva"
nome2 = "Maria Silva"
nome3 = "Joao Silva"

print("Hash texto: ", hash(texto))
print("Hash nome1: ", hash(nome1))
print("Hash nome2: ", hash(nome2))
print("Hash nome3: ", hash(nome3))


dicionario2 = dict()

lista1 = []
lista1.append("joao")           # 0
lista1.append(27)               # 1
lista1.append("22/08/1998")     # 2

# dicionario1 = {}
# dicionario1["nome"] = "joao"
# dicionario1["idade"] = 27
# dicionario1["nascimento"] = "22/08/1998"

#              chave   valor   chave    valor   chave          valor
dicionario1 = {"nome": "joao", "idade": 27,    "nascimento": "22/08/1998"}

#                      chave   valor    chave  valor    chave          valor
# dicionario1 = dict( [("nome", "joao"), ("idade", 27), ("nascimento", "22/08/1998")] )

#                      chave   valor    chave  valor    chave          valor
#dicionario1 = dict( nome="joao", idade=27, nascimento="22/08/1998")

print("Idade pela lista: ", lista1[1])
print("Idade pelo dicionario: ", dicionario1["idade"])

print("Dicionario1: ", dicionario1)
dicionario1["genero"] = "masculino"
dicionario1["idade"] = 31

print("Dicionario1: ", dicionario1)

del dicionario1["genero"]

print("Dicionario1: ", dicionario1)

tamanho = len(dicionario1)
print("Tamanho do dicionario1:", tamanho)

# if "genero" in dicionario1:
#     print("Genero: ", dicionario1["genero"])
# else:
#     print("Não existe chave 'genero' no dicionario")
dicionario1["genero"] = "masculino"
valor = dicionario1.get("genero", "Não existe chave 'genero' no dicionario")

print("Genero: ", valor)

chaves = dicionario1.keys()
print("Chaves do dicionario: ", chaves)


valores = dicionario1.values()
print("Valores do dicionario: ", valores)


items = dicionario1.items()
print("Items do dicionario: ", items)

# Mostrar todos os valores, apenas os valores
print("Apenas os valores")
for v in dicionario1.values():
    print(v)


# Mostrar todas as chaves, apenas as chaves
print("Apenas as chaves")
for k in dicionario1:
    print(k)

# Mostrar chaves e valores dos elementos do dicionario
print("Chaves e Valores")
for item in dicionario1.items():
    chave, valor = item
    print(chave, " => ", valor)
