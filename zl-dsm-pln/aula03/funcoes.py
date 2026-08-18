print("Desenhar cabecalho")

def cabecalho( autor, nome_programa ):
    print("********************************")
    print(f"**  Feito por: {autor}  **")
    print(f"** Programa que mostra {nome_programa}  **")
    print("********************************")


cabecalho( "prof. Antonio", "lista" )
lista = [1, 2, 3, 4, 5]
print("Lista: ", lista)

cabecalho( "prof. Antonio", "dict" )
dicionario1 = {"nome": "Antonio", "profissao": "Professor"}
print("Dicionario: ", dicionario1)

# def somar( n1, n2 = 0 ):
def somar( n1 : int, n2 : int = 0 ) -> int:
    soma = n1 + n2
    print("n1: ", n1)
    print("n2: ", n2)
    print("Soma: ", soma)
    return soma

def calcular2( n1, n2 ):
    soma = n1 + n2
    produto = n1 * n2
    return soma, produto

def calcular3( n1, n2, n3 ):
    soma = n1 + n2 + n3
    produto = n1 * n2 * n3
    return soma, produto


# print("soma: ", soma)   # Variavel soma não existe fora da função

s1 = somar( 10, 40 )
s2 = somar(110, 320)

s3 = somar(s1, s2)

somar(n2=80, n1=109)

print("Calcular")
tupla = calcular2( 7, 5)
print("Resultado: ", tupla)

print("Calcular")
s, p = calcular2( 7, 5 )
print("Resultado 1: ", s)
print("Resultado 2: ", p)

print("Calcular 3")
s, p = calcular3( 11, 13, 15 )
print("Resultado 1: ", s)
print("Resultado 2: ", p)


def calcular( *numeros ):
    soma = 0
    for n in numeros:
        soma = soma + n
    return soma

print("Calcular N")
s = calcular( 2, 4, 6 )
print("Soma: ", s)


# def impostos( ipi=0, icms=0, iss=0, ir=0, ipva=0, iptu=0 ):
#     soma = ipi + icms + iss + ir + ipva + iptu
#     return soma


def impostos( **imp ):
    """
        Função para somar impostos
    """
    soma = 0
    for item in imp.items():
        nome, valor = item
        # print("Imposto: ", item[0], " valor: ", item[1])
        print("Imposto: ", nome, " valor: ", valor)
        soma = soma + valor
    return soma

s = impostos(ipi=10, icms=18)
print("Soma impostos: ", s)
s = impostos(iva=9, icms=18)
print("Soma impostos: ", s)
s = impostos(pis=1, icms=18, ipi=9, iva=5, cofins=2)
print("Soma impostos: ", s)


print("Fim do programa")
