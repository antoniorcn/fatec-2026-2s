texto = """
No dia 15 de março de 2026, 
Ana comprou três maçãs vermelhas 
por R$ 12,50 no mercado do bairro.
Ela ficou muito feliz com a qualidade das frutas!
O vendedor João foi gentil e ainda deu um limão de brinde.
'Volte sempre', disse ele com um sorriso no rosto."
"""

texto = texto.lower().replace("\n", "")\
    .replace(".", " ").replace(",", " ")\
    .replace("\"", "").replace("\'", "")\
    .replace("  ", " ")

tokens = texto.split(" ")
print("Tokens: ", tokens)

vocabulario = []
for token in tokens:
    if token not in vocabulario:
        vocabulario.append(token)
print("Vocabulario: ", vocabulario)
# vocabulario = set(tokens)

riqueza_lexical = len(vocabulario) / len(tokens)
print("Riqueza Lexical: ", riqueza_lexical)