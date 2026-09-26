"""Modulo de matematica com funcoes de aritmetica"""

def somar_numeros( num1 : int, num2: int ) -> int:
    """Esta função serve para somar dois numeros inteiros, retornando 
    outro numero inteiro no final
    passe dois parametros e receba um numero"""
    soma = num1 + num2
    return soma


def somar_numeros_varios( *numeros : int ) -> int:
    """Esta função serve para somar varios numeros inteiros, retornando 
    outro numero inteiro no final
    passe quantos parametros desejar e receba um numero"""
    soma = 0
    for num in numeros:
        soma = soma + num
    return soma

def dividir_numeros( num1 : int, num2 : int ) -> float:
    """Esta função serve para dividir dois numeros inteiros, retornando 
    outro numero float no final
    passe dois parametros e receba um numero float"""
    divisao = num1 / num2
    return divisao

def divisao_escolar( num1 : int, num2 : int):
    """Função para dividir um numero pelo outro 
    retornando o quociente e o resto """
    quociente = num1 // num2
    resto = num1 % num2
    return quociente, resto
