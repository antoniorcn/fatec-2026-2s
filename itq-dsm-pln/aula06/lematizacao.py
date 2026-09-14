import spacy

nlp = spacy.load("pt_core_news_sm")

nome_arquivo = "casmurro.txt"
vocabulario = []
vocabulario_com_lemma = []
numero_tokens = 0
textao = ""

lemmas = {
    "estudo" : "estudo",
    "estudante" : "estudo",
    "estudado" : "estudo",
    "estudando" : "estudo",
    "estudamos" : "estudo",
    "carro" : "carro",
    "carroça" : "carro",
    "carruagem" : "carro",
    "carrossel" : "carro"
}

with open(nome_arquivo, "r", encoding="utf-8") as arquivo:
    linha = " "
    while linha != "":
        linha = arquivo.readline()
        textao += linha.lower()
        tokens = linha.lower().split(" ")
        numero_tokens += len(tokens)
        for token in tokens:
            if token not in vocabulario:
                vocabulario.append( token )
            lemma = lemmas.get(token, token)
            if lemma not in vocabulario_com_lemma:
                vocabulario_com_lemma.append( lemma )

print("Quantidade de palavras no vocabulario do Casmurro.txt: ", numero_tokens)
print("Tamanho do vocabulario do Casmurro.txt: ", len(vocabulario))
print("Tamanho do vocabulario usando lemma do Casmurro.txt: ", len(vocabulario_com_lemma))


print("Tamanho do texto em caracteres: ", len(textao))

vocabulario_com_lemma = []
doc = nlp( textao )
for palavra in doc: 
    lemma = palavra.lemma
    if lemma not in vocabulario_com_lemma:
        vocabulario_com_lemma.append( lemma )
print("Tamanho do vocabulario usando lemma (Spacy) do Casmurro.txt: ", len(vocabulario_com_lemma))
