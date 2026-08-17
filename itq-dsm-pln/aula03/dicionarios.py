dicionario1 = {}  # Dicionario vazio

# gestao_feira = {
#     "Joao": ["Bananas", "Morangos", "Uvas"], 
#     "Maria": "Macas", 
#     "Jose": "Goiabas"
# }

gestao_feira = dict( [
    ("Joao", ["Bananas", "Morangos", "Uvas"]),
    ("Maria", "Macas"),
    ("Jose", "Goiabas")
    ] )

print("Frutas do Joao:", gestao_feira["Joao"])
print("Frutas da Maria:", gestao_feira["Maria"])
print("Frutas do Jose:", gestao_feira["Jose"])

s1 = "Texto"
s2 = "Texto"
s3 = "Outro Texto"
print("Hash S1: ", s1.__hash__())
print("Hash S2: ", s2.__hash__())
print("Hash S3: ", s3.__hash__())

print("Tamanho: ", len(gestao_feira))

frutas = gestao_feira.copy()

print("Lista de pedido atual: ", gestao_feira)
print("Pedido de frutas da Maria: ", gestao_feira["Maria"])
print("Removendo o pedido da Maria...")
del gestao_feira["Maria"]
print("Pedido removido")
print("Lista de pedido atual: ", gestao_feira)

jose_fez_pedido = "Jose" in gestao_feira
maria_fez_pedido = "Maria" in gestao_feira
print("Jose fez algum pedido de frutas: ", jose_fez_pedido)
print("Maria fez algum pedido de frutas: ", maria_fez_pedido)

chaves = gestao_feira.keys()  # Retorna um conjunto com as chaves existentes no dicionario
print("Chaves: ", chaves)

valores = gestao_feira.values()
print("Valores: ", valores) # Retorna uma lista com todos os valores armazenados no dicionario

itens = gestao_feira.items()
print("Itens retornados: ", itens)

print("Dicionario Frutas: ", frutas)

print(" **** Conjuntos **** ")
# Guarda informações únicas, ou seja sem repetição, e não é ordenado

conjunto = {"Arthur", "Caio", "Humberto"}
print("Conjunto: ", conjunto)
# print("Conjunto elemento 0: ", conjunto[0])
print("O Caio esta no conjunto: ", "Caio" in conjunto)
print("O Alfredo esta no conjunto: ", "Alfredo" in conjunto)

print("Elementos do conjunto")
for c in conjunto:
    print(c)
lista_nomes_conjunto = list( conjunto )
print("Lista com os nomes do conjunto: ", lista_nomes_conjunto)
print("Conjunto elemento 0: ", lista_nomes_conjunto[0])