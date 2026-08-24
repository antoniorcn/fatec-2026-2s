import nltk
from nltk.tokenize import word_tokenize
from string import punctuation

texto = """
No dia 15 de março de 2026, 
Ana comprou três maçãs vermelhas 
por R$ 12,50 no mercado do bairro.
Ela ficou muito feliz com a qualidade das frutas!
O vendedor João foi gentil e ainda deu um limão de brinde.
'Volte sempre', disse ele com um sorriso no rosto.
"""

nltk.download("punkt")

stopwords = ['no', 'de', 'o', 'a', 'do']

# Normalizar o texto
a_remover = punctuation
#                                  Caracteres   Caracteres
#                                  de Origem    de Destino
marcara_transformacao = str.maketrans("\n", " ", a_remover)
# O texto era assim   ==> 'Volte sempre', disse ele com um sorriso no rosto.
# O texto ficou assim ==> Volte sempre disse ele com um sorriso no rosto

texto = texto.lower()
texto = texto.translate( marcara_transformacao )
texto = texto.replace("  ", " ")

tokens = word_tokenize( texto )
tokens_limpos = []
for token in tokens:
    if token not in stopwords:
        tokens_limpos.append( token )

print("Tokens: ", tokens_limpos)

vocabulario = []
for token in tokens_limpos:
    if token not in vocabulario:
        vocabulario.append(token)
print("Vocabulario: ", vocabulario)
# vocabulario = set(tokens)

riqueza_lexical = len(vocabulario) / len(tokens)
print("Riqueza Lexical: ", riqueza_lexical)