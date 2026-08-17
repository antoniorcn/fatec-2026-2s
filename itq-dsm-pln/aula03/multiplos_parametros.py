# def calcular_produto( n1, n2 ):
#     return n1 * n2

def calcular_produto( *numero ):  # [10, 20]  ou [10, 20, 30]
    produto = 1
    for i in numero:
        produto = produto * i
    return produto


prod = calcular_produto(10, 20)
print("Produto: ", prod)

prod = calcular_produto(10, 20, 30)
print("Produto: ", prod)


# def calcular( n1, n2, op ):
#     if op == "soma":
#         return n1 + n2
#     elif op == "subtracao":
#         return n1 - n2
#     elif op == "multiplicacao":
#         return n1 * n2
#     elif op == "divisao":
#         return n1 / n2
#     else:
#         return 0

# resultado = calcular( 10, 20, "soma" )
# print("Resultado: ", resultado)



# def calcular( n1, n2, op ):
#     if op == "soma":
#         return n1 + n2
#     elif op == "subtracao":
#         return n1 - n2
#     elif op == "multiplicacao":
#         return n1 * n2
#     elif op == "divisao":
#         return n1 / n2
#     else:
#         return 0

# def calcular_varios( **dados ):
#     soma = 0
#     chaves = dados.keys()
#     for chave in chaves:
#         chave.startswith("op")
#         operacao = dados["op1"]
#         valor1 = dados["numero1"]
#         valor2 = dados["numero2"]
#         soma = soma + calcular( valor1, valor2, operacao)
#     return soma


def calcular_impostos( valor_base, **impostos ):
    print("Calculando impostos de: ", valor_base)
    soma = 0
    for item in impostos.items():
        valor_imposto = valor_base * item[1] / 100
        print(item[0], "=", valor_imposto)
        soma += valor_imposto
    print("Total Imposos: ", soma)
    print("Total Geral: ", valor_base + soma)
    return soma



calcular_impostos(100.0, icms=18, ipi=10, ir=25, iss=4)

calcular_impostos(350.0, icms=18, ipi=10, ir=25, iss=4)

print("Ao importar um ESP32 no valor de R$ 50,00, iremos pagar: ")
calcular_impostos(50.0, icms=18, iss=4)
