print("Ola mundo...")
print("Bemvindos a aula de PLN")
a = 10
print("A: ", a, type(a))
a = "aaa"

print("A: ", a, type(a))

#    012345678
f = "PROVA NLP"
pos = f.find("P", 1)
print("Pos (P)=>", pos)


a = 25
b = 1.0/2.0
potencia = a ** b
print("25 ** 1/2 => ", potencia)


print("Divisão")

a = 20
b = 3
c = a / b
d = a // b
e = a % b
print("Operador (/) Divisão: ", a, " / ", b, " => ", c)
print("Operador (//) Quociente: ", a, " // ", b, " => ", d)
print("Operador (%) Resto: ", a, " % ", b, " => ", e)

# (dividendo)    20 |   3   (divisor)
#                   --------
#              resto   quociente

print("Operacoes relacionais")

nota = 7
faltas = 10
passou = nota > 6   # (True ou False)
reprovou_falta = faltas > 16

# aprovado = passou and reprovou_falta == False
aprovado = passou and not reprovou_falta
print("Aprovado: ", aprovado)

# AND (and)
# |   E1   |   E2  | Resultado |
# ------------------------------
# | True   | True  | True      |
# | True   | False | False     |
# | False  | True  | False     |
# | False  | False | False     |

# OR (or)
# |   E1   |   E2  | Resultado |
# ------------------------------
# | True   | True  | True      |
# | True   | False | True      |
# | False  | True  | True      |
# | False  | False | False     |

# XOR  (^)
# |   E1   |   E2  | Resultado |
# ------------------------------
# | True   | True  | False     |
# | True   | False | True      |
# | False  | True  | True      |
# | False  | False | False     |



a = 0
while ( a < 10):
    print(a)
    a += 1      # a = a + 1

b = 37845637845
b %= 100  # b = b % 100   # Resultado ?    Faixa de resultado ? 
print("B: ", b)

# Pertencimento
print("Pertencimento")
lista_numeros = [10, 290, 40, 60, 80, 100]
d = 50 in lista_numeros
print("50 esta na lista ==> ", d)

# Identidade

print("Identidade")

a = "Texto"
b = a
print("A: ", a)
print("B: ", b)
print("São o mesmo objeto ==> ", a is b)
b = a[::]
print("A: ", a)
print("B: ", b)
print("São o mesmo objeto ==> ", a is b)

# Rotação de Bits
print("Rotacao de bits >> ")
a = 20          # |0|0|0|1|0|1|0|0|
c = a >> 2      # |0|0|0|0|0|1|0|1|
print("C: ", c)

print("Rotacao de bits <<")
a = 20          # |0|0|0|1|0|1|0|0|
c = a << 3      # |1|0|1|0|0|0|0|0|
print("C: ", c)


