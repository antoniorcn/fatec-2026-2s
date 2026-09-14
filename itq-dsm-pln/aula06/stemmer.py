import spacy
import nltk
from nltk.stem import RSLPStemmer
from nltk.tokenize import PunktTokenizer
stok = PunktTokenizer("portuguese")

nlp = spacy.load("pt_core_news_sm")

nome_arquivo = "casmurro.txt"
vocabulario = []
vocabulario_com_stem = []
numero_tokens = 0
textao = ""

stemmer = RSLPStemmer()

with open(nome_arquivo, "r", encoding="utf-8") as arquivo:
    linha = " "
    while linha != "":
        linha = arquivo.readline()
        textao += linha.lower()
        tokens = linha.lower().split(" ")
        numero_tokens += len(tokens)
        for token in tokens:
            token = token.replace(" ", "")
            if token is not None and token != "":
                if token not in vocabulario:
                    vocabulario.append( token )

                # Colocar o stem no vocabulario_stem
                # print("Token: ", token, end="")
                token_stemmed = stemmer.stem( token )
                # print("Stem: ", token_stemmed)
                if token_stemmed not in vocabulario_com_stem:
                    vocabulario_com_stem.append( token_stemmed )

print("Quantidade de palavras no vocabulario do Casmurro.txt: ", numero_tokens)
print("Tamanho do vocabulario do Casmurro.txt: ", len(vocabulario))
print("Tamanho do texto em caracteres: ", len(textao))
print("Tamanho do vocabulario usando stem (RSLPStemmer) do Casmurro.txt: ",
      len(vocabulario_com_stem))

vocabulario_com_lemma = []
doc = nlp( textao )
for palavra in doc:
    lemma = palavra.lemma
    if lemma not in vocabulario_com_lemma:
        vocabulario_com_lemma.append( lemma )
print("Tamanho do vocabulario usando lemma (Spacy) do Casmurro.txt: ", len(vocabulario_com_lemma))
