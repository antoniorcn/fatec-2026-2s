import nltk
from nltk.tokenize import word_tokenize
from nltk.corpus import stopwords
from string import punctuation

from wordcloud import WordCloud
import matplotlib.pyplot as plt

nltk.download("punkt")
nltk.download('stopwords')


minhas_stopwords = set(stopwords.words('portuguese'))


def normalizar_texto( texto ):
    # Normalizar o texto
    a_remover = punctuation
    #                                  Caracteres   Caracteres
    #                                  de Origem    de Destino
    mascara_transformacao = str.maketrans("\n\r", "  ", a_remover)
    # O texto era assim   ==> 'Volte sempre', disse ele com um sorriso no rosto.
    # O texto ficou assim ==> Volte sempre disse ele com um sorriso no rosto

    texto = texto.lower()
    texto = texto.translate( mascara_transformacao )
    texto = texto.replace("  ", " ")
    return texto


def tokenizacao( texto ):
    tokens = word_tokenize( texto )
    return tokens


def remover_stopwords( tokens, lista_stopwords ):
    tokens_limpos = []
    for token in tokens:
        if token not in lista_stopwords:
            tokens_limpos.append( token )
    return tokens_limpos


def gerar_vocabulario( tokens ):
    vocabulario = list(set( tokens ))
    return vocabulario
    # vocabulario = []
    # for token in tokens:
    #     if token not in vocabulario:
    #         vocabulario.append(token)
    # return vocabulario


try:
    arquivo = open("./casmurro.txt", 'r', encoding="utf-8")
    with arquivo:
        texto = arquivo.read()
        texto_normalizado = normalizar_texto( texto )
        tokens = tokenizacao( texto_normalizado )
        tokens_limpos = remover_stopwords( tokens, minhas_stopwords ) # Tokens
        # [ 'dom', 'observa', 'horizonte']

        texto_limpo = " ".join(tokens_limpos)
        wc = WordCloud(width=800, height=600)
        img = wc.generate(texto_limpo)   # Preciso do Texto
        # "dom observa o horizonte"

        vocabulario = gerar_vocabulario( tokens_limpos )

        print("Minhas Stop Words: ", minhas_stopwords)
        print("Quantidade de tokens totais: ", len(tokens))
        print("Quantidade de tokens limpos: ", len(tokens_limpos))
        print("Tamanho do Vocabulario: ", len(vocabulario))

        riqueza_lexical = len(vocabulario) / len(tokens_limpos)
        print("Riqueza Lexical: ", riqueza_lexical)

        plt.figure(figsize=(10, 5))
        plt.imshow(img, interpolation='bilinear')
        plt.axis('off')
        plt.savefig("nuvem_de_palavras.png", bbox_inches='tight')
except IOError:
    print("Arquivo não pode ser aberto")
