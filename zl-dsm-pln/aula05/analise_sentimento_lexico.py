"""
Programa para fazer a analise de sentimento de textos usando o Lexicon v3
"""

import nltk
from nltk.tokenize import word_tokenize
from string import punctuation
nltk.download("punkt")

corpus = [
    "Eu adorei este produto, superou todas as minhas expectativas fique feliz!",
    "O atendimento foi rápido e muito gentil.",
    "Estou muito feliz com o resultado do meu pedido.",
    "O serviço foi horrível e demorou uma eternidade.",
    "Não recomendo esta compra, o material é muito fraco.",
    "Fiquei chateado com o descaso da empresa.",
    "O pacote chegou na data prevista.",
    "Este é o manual de instruções do aparelho.",
    "A reunião está marcada para amanhã às dez horas."
]

def limpar_texto( texto : str ) -> str:
    tabela = str.maketrans("", "", punctuation)
    texto_limpo = texto.lower().translate( tabela )
    return texto_limpo

nome_arquivo = "C:\\git\\dados\\nlp\\lexico_v3.0.txt"

lexicon = {}

# arquivo = open(nome_arquivo, "r", encoding="utf-8")
# arquivo.close()

with open(nome_arquivo, "r", encoding="utf-8") as arquivo:
    linha = " "
    while linha != "":
        linha = arquivo.readline()   # =[, emot, -1, A
        if linha is not None and linha != "":
            #                                 0      1      2     3
            elementos = linha.split(",")  # ['=[', 'emot', '-1', 'A']
            if len(elementos) >= 3:
                chave = elementos[0]
                valor = int(elementos[2])
                lexicon[chave] = valor   # {'=[': -1}

# print("Tamanho Lexicon: ", len(lexicon) )

# palavra = "esforçado"
# valor = lexicon.get(palavra, "<palavra não existe>")
# print(f"Palavra: {palavra}   Valor: {valor}")


def limpar_tokenizar( texto : str ) -> list:
    documento_limpo = limpar_texto(texto)
    lista_tokens = word_tokenize(documento_limpo)
    return lista_tokens


def somar_tokens( tokens : list ) -> int:
    soma = 0
    print("Lista Tokens: ", tokens)
    for token in tokens:
        valor = lexicon.get(token, 0)
        # print(f"Token: {token}   Valor: {valor}")
        soma += valor
    return soma


tokens = limpar_tokenizar(corpus[2])
soma = somar_tokens( tokens )
print(f"Soma final: {soma}   Resultado: ",
      "POSITIVO" if soma > 0 else "NEUTRO" if soma == 0 else "NEGATIVO")
# if soma > 0:
#     print("POSITIVO")
# elif soma == 0:
#     print("NEUTRO")
# else: 
#     print("NEGATIVO")


