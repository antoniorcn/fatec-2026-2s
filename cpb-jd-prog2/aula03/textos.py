#       0123456789
nome = "Joao Silva"
nome_maiusc = nome.upper()
print("Nome: ", nome)
print("Nome Maiusculo: ", nome_maiusc)
# Fazer o minusculo usando lower()
tamanho = len( nome )
print("Tamanho do nome: ", tamanho)
  # "silva"
novo_nome = nome.lower()
pos = novo_nome.find( "sIlVa".lower() ) # nome.find("silva")
print("O ", nome , " pertence a familia Silva")
print("Pois tem a palavra Silva na posicao", pos)

# pos = nome.find("Santos")
# print("O ", nome , " pertence a familia Santos")
# print("Pois tem a palavra Santos na posicao", pos)