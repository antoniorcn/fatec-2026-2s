from sklearn.feature_extraction.text import CountVectorizer

corpus = [
    "o menino corre corre corre no parque.",
    "ele brinca e sorri, sorri enquanto brinca.",
    "a mãe observa o menino de longe enquanto o menino brinca."
]


vetorizador = CountVectorizer()
lista_vetores = vetorizador.fit_transform( corpus )
print("Lista esparsa comprimida", lista_vetores)

lista_esparsa = lista_vetores.toarray()
print("Lista Esparsa: ", lista_esparsa)

print("Vocabulario: ", vetorizador.get_feature_names_out())
