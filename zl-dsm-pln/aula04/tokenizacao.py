corpus =  """O acampamento
Domingo foi dia de folga para Lucas e ele decidiu acampar com seus amigos. Perto do acampamento havia uma cachoeira e um enorme pé de jaca.
Os jovens passaram o dia todo se divertindo na cachoeira e ao meio-dia resolveram preparar um macarrão para almoçarem. Lucas e os amigos também quiseram comer uma sobremesa e se lembraram do pé de jaca.
João e Pedro eram os nomes dos amigos de Lucas. Os três subiram na árvore para pegar algumas frutas, mas não conseguiram chegar até o alto da jaqueira. Um fazendeiro que morava perto do acampamento resolveu ajudar os jovens e trouxe uma escada para que alcançassem as jacas.
O fazendeiro se chamava Roberto e conseguiu ajudar Lucas e seus amigos. Depois de comerem as jacas eles ficaram conversando embaixo da jaqueira. Lucas gostou tanto daquele lugar que resolveu voltar outras vezes. Sempre que vai acampar ele faz uma visita a Roberto, pois se tornaram amigos.
Roberto é um homem do campo que gosta de ajudar as pessoas. Ele faz muitas amizades na região onde mora.
Quando a noite chegou, Lucas e os amigos decidiram voltar para casa levando algumas jacas. Eles moravam em uma cidade próxima e já planejavam voltar ao acampamento nas férias de verão.
Ao chegar em casa, a mãe de Lucas fez um doce com as jacas. Ele e os seus amigos gostaram muito da ideia.
"""

# Normalização do texto
tabela_trocas = str.maketrans("\náãéêçó", " aaeeco", ".,")
texto_normalizado = corpus.lower().translate( tabela_trocas )

# texto_normalizado = corpus.lower().replace("\n", " ").replace(".", "").replace(",", "")

# texto_normalizado = texto_normalizado.replace("\n", " ")
# texto_normalizado = texto_normalizado.replace(".", "")
# texto_normalizado = texto_normalizado.replace(",", "")

# Tokenização do texto

lista_tokens = texto_normalizado.split(" ")
lista_tokens.pop()

print("Tokens: ", lista_tokens)
