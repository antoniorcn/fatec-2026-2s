print ("Aritmeticos")
a = 6
b = 3
pot = a ** b

print("A: ", a)
print("B: ", b)
print("Pot: ", pot) 


a = 20
b = 6

print("a =", a)
print("b =", b)
print("a / b =", a / b)
print("a // b =", a // b)
print("a %% b =", a % b)

#   (dividendo)   20  |     6   (divisor)
#                      ------------
#       (resto)    2         3 (quociente)


# Operadores relacionais
print ("Relacionais")

a = 4
b = 0

c = a > b   # Resulta em um resulado boolean (True ou False)

print("A: ", a)
print("B: ", b)
print("C: ", c)

# operadores Logicos
print("Operadores Lógicos")

nota_prova = 4.2
reprovado_nota = nota_prova < 6.0  # Foi reprovado por nota ? 

faltas = 17
reprovado_falta = faltas > 16 # Foi reprovado por falta ?   (Maximo 16 faltas)

aprovado = not reprovado_nota and not reprovado_falta
# aprovado = not (reprovado_nota or reprovado_falta)

print("Nota: ", nota_prova)
print("Faltas: ", faltas)
print("Aprovado: ", aprovado)

# Operador AND
# Tabela Verdade
#    T1     |      T2       |       Resultado   |
# ----------|---------------|-------------------|
#   True    |     True      |       True        |
#   False   |     True      |       False       |
#   True    |     False     |       False       |
#   False   |     False     |       False       |

# Operador OR
# Tabela Verdade
#    T1     |      T2       |       Resultado   |
# ----------|---------------|-------------------|
#   True    |     True      |       True        |
#   False   |     True      |       True        |
#   True    |     False     |       True        |
#   False   |     False     |       False       |


# Operador eXclusiveOR (XOR)
# Tabela Verdade
#    T1     |      T2       |       Resultado   |
# ----------|---------------|-------------------|
#   True    |     True      |       False       |
#   False   |     True      |       True        |
#   True    |     False     |       True        |
#   False   |     False     |       False       |