# letra a
a = 20 + 30 # 50
print( a )

# letra b
b = "O valor do numero é " + str(30)  # O valor do numero é 30
print( b )
print("O valor do numero é ", a)

c = hex( 898908 ) # DB75C
print("C: ", c)

d = len("Ola Mundo")  # 9
print("Tamanho de Ola Mundo: ", d)

e = int("153") + 160  # 313
print("Resultado: ", e)

#              +10
#    012345678901
f = "PROVA PROGII"
pos = f.find("P", 2)  # 6
print("Posicao encontrada do P: ", pos)


numero = 174
numero_hexadecimal = 0xDB75C
numero_hex = hex( numero )
numero_bin = bin( numero )
numero_dec = int(numero_hexadecimal)
numero_bin2 = bin(numero_hexadecimal)
print("Numero em Hex: ", numero_hex)
print("Numero em Binario: ", numero_bin)
print("Numero em Decimal", numero_dec)
print("Numero em Binario2: ", numero_bin2)