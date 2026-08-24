import nltk
from nltk.tokenize import word_tokenize

texto = """
No dia 15 de março de 2026, 
Ana comprou três maçãs vermelhas 
por R$ 12,50 no mercado do bairro.
Ela ficou muito feliz com a qualidade das frutas!
O vendedor João foi gentil e ainda deu um limão de brinde.
'Volte sempre', disse ele com um sorriso no rosto.
"""

nltk.download("punkt")

# Normalizar o texto
a_remover = "\n\"\'!"
#                                  Caracteres   Caracteres
#                                  de Origem    de Destino
marcara_transformacao = str.maketrans(".,", "  ", a_remover)
# O texto era assim   ==> 'Volte sempre', disse ele com um sorriso no rosto.
# O texto ficou assim ==> Volte sempre disse ele com um sorriso no rosto



tokens = word_tokenize( texto )

# # Nosso mecanismo de tokenização
# texto = texto.lower()
# texto = texto.translate( marcara_transformacao )
# texto = texto.replace("  ", " ")


# texto = texto.lower().replace("\n", " ")\
#     .replace(".", " ").replace(",", " ")\
#     .replace("\"", "").replace("\'", "")\
#     .replace("  ", " ").replace("!", " ")

# tokens = texto.split(" ")

print("Tokens: ", tokens)

vocabulario = []
for token in tokens:
    if token not in vocabulario:
        vocabulario.append(token)
print("Vocabulario: ", vocabulario)
# vocabulario = set(tokens)

riqueza_lexical = len(vocabulario) / len(tokens)
print("Riqueza Lexical: ", riqueza_lexical)