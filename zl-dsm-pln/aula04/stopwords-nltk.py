import nltk
from nltk.tokenize import WordPunctTokenizer
from string import punctuation
from nltk.corpus import stopwords

nltk.download('stopwords')

# Load Portuguese stop words
stop_words = stopwords.words('portuguese')

corpus =  """O acampamento
Domingo foi dia de folga para Lucas e ele decidiu acampar com seus amigos. Perto do acampamento havia uma cachoeira e um enorme pé de jaca.
Os jovens passaram o dia todo se divertindo na cachoeira e ao meio-dia resolveram preparar um macarrão para almoçarem. Lucas e os amigos também quiseram comer uma sobremesa e se lembraram do pé de jaca.
João e Pedro eram os nomes dos amigos de Lucas. Os três subiram na árvore para pegar algumas frutas, mas não conseguiram chegar até o alto da jaqueira. Um fazendeiro que morava perto do acampamento resolveu ajudar os jovens e trouxe uma escada para que alcançassem as jacas.
O fazendeiro se chamava Roberto e conseguiu ajudar Lucas e seus amigos. Depois de comerem as jacas eles ficaram conversando embaixo da jaqueira. Lucas gostou tanto daquele lugar que resolveu voltar outras vezes. Sempre que vai acampar ele faz uma visita a Roberto, pois se tornaram amigos.
Roberto é um homem do campo que gosta de ajudar as pessoas. Ele faz muitas amizades na região onde mora.
Quando a noite chegou, Lucas e os amigos decidiram voltar para casa levando algumas jacas. Eles moravam em uma cidade próxima e já planejavam voltar ao acampamento nas férias de verão.
Ao chegar em casa, a mãe de Lucas fez um doce com as jacas. Ele e os seus amigos gostaram muito da ideia.
"""

nltk.download("punkt")

# stop_words = ['o', 'de', 'ele', 'e', 'do', 'a', 'da', 'dos', 'das',
#              'na', 'no', 'nas', 'nos', 'para']

# Normalização do texto
tabela_trocas = str.maketrans("\náãéêçó", " aaeeco", punctuation)
texto_normalizado = corpus.lower().translate( tabela_trocas )

# Tokenização do texto

tokenizer = WordPunctTokenizer()
lista_tokens = tokenizer.tokenize(texto_normalizado)


print("Tokens: ", lista_tokens)

tokens_limpos = []
for token in lista_tokens:
    if token not in stop_words:
        tokens_limpos.append( token )

print("Tokens Limpos: ", tokens_limpos)
print("Quantidade de Tokens: ", len(lista_tokens))
print("Quantidade de Tokens Limpos: ", len(tokens_limpos))
