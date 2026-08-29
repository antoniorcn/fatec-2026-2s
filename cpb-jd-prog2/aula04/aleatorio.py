from random import random, randint, randrange, choice

# numero_roleta = int(random() * 32) + 1   # 0 .. 1     ==> 0 .. 32
# numero_roleta = randint(1, 32)
# numero_roleta = randrange(2, 33, 2)

numeros = [10, 20, 30]

numero_roleta = choice( numeros )

print("Numero roleta: ", numero_roleta)

# Roleta com 32 numeros

