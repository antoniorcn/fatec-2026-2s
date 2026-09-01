"""
Programa para gerar um bag of words com base em um texto
"""

DOCUMENTO1 = "O menino corre no parque.".lower().replace(".", " ")
DOCUMENTO2 = "Ele sorri enquanto brinca.".lower().replace(".", " ")
DOCUMENTO3 = "A mãe observa o menino de longe.".lower().replace(".", " ")

vocabulario = []

def adicionar_vocabulario( texto ):
    """
    Função para dividir o texto em tokens
    e adicionar ao vocabulario
    """
    # global vocabulario
    tokens = texto.split(" ")
    for token in tokens:
        if token is not None and token != "" and token not in vocabulario:
            vocabulario.append( token )

adicionar_vocabulario(DOCUMENTO1)
adicionar_vocabulario(DOCUMENTO2)
adicionar_vocabulario(DOCUMENTO3)

print("Indices : ", end="")
for idx, palavra in enumerate(vocabulario):
    print( f"{(idx + 1):^10}", end="")
print()
print("Palavras: ", end="")
for idx, palavra in enumerate(vocabulario):
    print( f"{palavra:^10}", end="")

#Indices :     1         2         3         4         5         6         7         8         9         10        11        12        13        14
#Palavras:     o       menino    corre       no      parque     ele      sorri    enquanto   brinca      a        mãe     observa      de      longe
#DOCUMENTO1 = "O menino corre no parque."
#DOCUMENTO2 = "Ele sorri enquanto brinca."
#DOCUMENTO3 = "A mãe observa o menino de longe."
bow_documento1 = [1, 2, 3, 4, 5]
bow_documento2 = [6, 7, 8, 9]
bow_documento3 = [10, 11, 12, 1, 2, 13, 14]
