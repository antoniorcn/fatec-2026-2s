lexicon = dict()

nome_arquivo_lexico = "c:\\git\\dados\\nlp\\lexico_v3.0.txt"

with open(nome_arquivo_lexico, "+r", encoding="utf-8") as arquivo_lexico:
    linha = " "
    while linha != "":
        linha = arquivo_lexico.readline()   # =[,emot,-1,A
        #                                       0      1      2     3
        linha_split = linha.split(",")      # ['=[', 'emot', '-1', 'A']
        if len(linha_split) >= 3:
            chave = linha_split[0]      # '=['
            valor = int(linha_split[2]) # '-1' => -1
            lexicon[chave] = valor

corpus = """O menino corre no parque.
Ele sorri enquanto brinca.
A mãe observa o menino de longe.
""".lower().replace(".", " ")

print("Tamaho do Lexicon: ", len(lexicon))

# palavra = "triste"
# valor = lexicon.get(palavra, "<palavra inexistente>")
# print(f"Valor da palavra {palavra}: {valor}")

tokens = corpus.split(" ")
soma = 0
for token in tokens:
    valor = lexicon.get(token, 0)
    soma += valor
    print(token, "=>", valor)

print("O texto é: ", "POSITIVO" if soma > 0 else "NEGATIVO" if soma < 0 else "INDIFERENTE")
