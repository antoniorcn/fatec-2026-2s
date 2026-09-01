from sklearn.feature_extraction.text import CountVectorizer

"""
Programa para gerar um bag of words binary com base nos documentos
"""

DOCUMENTO1 = "O menino corre no parque.".lower().replace(".", " ")
DOCUMENTO2 = "Ele sorri enquanto ele brinca.".lower().replace(".", " ")
DOCUMENTO3 = "A mãe observa o menino de longe.".lower().replace(".", " ")

vetorizador = CountVectorizer(binary = True)
lista_documentos = [DOCUMENTO1, DOCUMENTO2, DOCUMENTO3]
matriz_esparsa = vetorizador.fit_transform(lista_documentos)
print("Matriz Esparsa: ", matriz_esparsa)
matriz_densa = matriz_esparsa.toarray()
print("Matriz Densa: ", matriz_densa)
print("Vocabulario: ", vetorizador.get_feature_names_out())
