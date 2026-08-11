a = 20
b = hex(a)
c = float(a)

d = 30.6
e = d.hex()

print("A: ", a)
print("B: ", b)
print("C: ", c)
print("D: ", d)
print("E: ", e)

#           0+        10+     20+
#        0123456789012345678901234
texto = "Adoro programar em Python"

texto_baixo = texto.lower()
texto_alto = texto.upper()

txt_numeros = f"Numeros {a:^10}, {d:5.3f}"
print("Numeros : ", txt_numeros)

print("Texto em caixa baixa: ", texto_baixo)
print("Texto em caixa alta: ", texto_alto)

pos = texto.find("em")
print("Texto (em) localizado na posição: ", pos)

print("Tamanho: ", len(texto))


#    012345678
f = "PROVA NLP"
pos = f.find("P", 9)
print("P encontrado na posicao ", pos)