lista1 = ['A', 'B', 'C']
lista2 = [1, 2, 3, 4, 5]
lista3 = ["Joao", "Maria", "Jose"]


# print("\n\nImprimindo lista")
# for l in lista1:
#     print( l )


# print("\n\nImprimindo lista")
# for l in lista2:
#     print( l )

# print("\n\nImprimindo lista")
# for l in lista3:
#     print( l )


# def imprimir1():
#     print("\n\nImprimindo lista")
#     for l in lista1:
#         print( l )

# def imprimir2():
#     print("\n\nImprimindo lista")
#     for l in lista2:
#         print( l )

# def imprimir3():
#     print("\n\nImprimindo lista")
#     for l in lista3:
#         print( l )


# imprimir1()
# imprimir2()
# imprimir3()


def imprimir( lista, borda = "#"):
    """
    Funcao usada para imprimir uma lista envolvida em um quadro com a 
    borda especificada no texto <borda>
    """
    print("Imprimindo a lista")
    print(borda * 80)
    for l in lista:
        print(f"{borda}{l:^78}{borda}")
    print(borda * 80)


def calcular_media( lista ):
    media = sum(lista) / len(lista)
    print("Media: ", media)


imprimir( lista1 )
imprimir( lista2, "*" )
imprimir( lista3, "=" )
calcular_media( lista2 )

imprimir( borda="^", lista=lista2 )

lista4 = [ 10, 15, 12, 13 ]
calcular_media( lista4 )

def somar_tudo( lista ):
    soma = sum(lista)
    print("Soma: ", soma)
    return soma

lista5 = [5.8,  10.9, 20.4, 12.50, 23.10, 14.30]
s = somar_tudo( lista5 )
print("Valor total da soma: ", s)
cada_um_paga = s / 3
print("Cada um paga: ", cada_um_paga)


def converte_texto( texto ):
    maiusc = texto.upper()
    minusc = texto.lower()
    return minusc, maiusc



t = "Eu gosto de programar em Python"
# resultado = converte_texto( t ) # ( minusculo, maiusculo )
# lower, upper = resultado
# print("Resultado: ", resultado)
lower, upper = converte_texto( t ) # ( minusculo, maiusculo )
print("Caixa baixa: ", lower)
print("Caixa alta: ", upper)
