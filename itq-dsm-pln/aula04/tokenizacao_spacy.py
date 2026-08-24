import spacy

texto = """
No dia 15 de março de 2026, 
Ana comprou três maçãs vermelhas 
por R$ 12,50 no mercado do bairro.
Ela ficou muito feliz com a qualidade das frutas!
O vendedor João foi gentil e ainda deu um limão de brinde.
'Volte sempre', disse ele com um sorriso no rosto.
"""

# Normalizar o texto
a_remover = "\n\"\'!"
#                                  Caracteres   Caracteres
#                                  de Origem    de Destino
marcara_transformacao = str.maketrans(".,", "  ", a_remover)
# O texto era assim   ==> 'Volte sempre', disse ele com um sorriso no rosto.
# O texto ficou assim ==> Volte sempre disse ele com um sorriso no rosto
texto = texto.lower()
texto = texto.translate( marcara_transformacao )
texto = texto.replace("  ", " ")

nlp = spacy.blank("pt")

tokens = nlp( texto )

vocabulario = []

print("Tokens: ")
for token in tokens:
    str_token = str(token)
    print(str_token, ", ", end="")
    if str_token not in vocabulario:
        vocabulario.append(str_token)
print("Vocabulario: ", vocabulario)

riqueza_lexical = len(vocabulario) / len(tokens)
print("Riqueza Lexical: ", riqueza_lexical)