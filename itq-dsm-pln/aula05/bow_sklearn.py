from sklearn.feature_extraction.text import CountVectorizer

corpus = [
    "O menino corre no parque.",
    "Ele sorri enquanto brinca.",
    "A mãe observa o menino de longe."
]


vetorizador = CountVectorizer(binary=True)
lista_vetores = vetorizador.fit_transform( corpus )
print("Lista esparsa comprimida", lista_vetores)

lista_esparsa = lista_vetores.toarray()
print("Lista Esparsa: ", lista_esparsa)