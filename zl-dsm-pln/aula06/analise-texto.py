"""
Programa para gerar um bag of words do texto memórias póstumas de Brás Cubas
"""
import spacy
import nltk
from sklearn.feature_extraction.text import CountVectorizer
from nltk.stem import RSLPStemmer
nome_arquivo = "C:\\git\\dados\\nlp\\machado-assis-memorias-postumas-braz-cubas.txt"
conteudo_arquivo = []
with open( nome_arquivo, "r", encoding="utf-8" ) as arquivo:
    conteudo_arquivo = arquivo.readlines()
corpus = "\n".join(conteudo_arquivo)
nlp = spacy.load("pt_core_news_sm")
docs = nlp(corpus)
vetorizador = CountVectorizer()
matriz_esparsa = vetorizador.fit_transform( conteudo_arquivo)
print("Matriz Esparsa: ", matriz_esparsa)
matriz_densa = matriz_esparsa.toarray()
print("Matriz Densa: ", matriz_densa)
linhas = len(matriz_densa)
colunas = len(matriz_densa[0])
print(f"Tamanho da matriz: {linhas} x {colunas}")
vocabulario = vetorizador.get_feature_names_out()
print("Vocabulario: ", vocabulario)
print("Tamanho do Vocabulario: ", len(vocabulario))
vocabulario_lemmas = []
for token in docs:
    if token.lemma_ not in vocabulario_lemmas:
        vocabulario_lemmas.append(token.lemma_)
print("Tamanho do Vocabulario de Lemmas: ", len(vocabulario_lemmas))

stemmer = RSLPStemmer()
vocabulario_stemm = []
for token in docs:
    stemm = stemmer.stem( str(token) )
    if stemm not in vocabulario_stemm:
        vocabulario_stemm.append(stemm)
print("Tamanho do Vocabulario de Stemm: ", len(vocabulario_stemm))
