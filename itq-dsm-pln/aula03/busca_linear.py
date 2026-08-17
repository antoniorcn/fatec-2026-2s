#                0  1  2  3  4
lista_numeros = [2, 4, 6, 8, 10]


def busca_linear2( lista : list, valor ):
    try:
        pos = lista.index( valor )
        return pos
    except: 
        return -1



def busca_linear( lista, valor ):
    # for idx, l in enumerate(lista):
    #     if l == valor:
    #         return idx
    idx = 0
    for l in lista:
        if l == valor:
            return idx
        idx = idx + 1
    return -1

resultado = busca_linear2( lista_numeros, 6 )
print("Resultado: ", resultado)