from random import random, seed, randint, randrange, choice

# Como mudar a escala para ir de 100 a 200 ? 

# Aleatorio
# seed( 54 )
lista = [1, 3, 5, 6, 9, 10, 12]
for i in range(1, 60):
    # numero_aleatorio = int(random() * 5)
    # numero_aleatorio = randint(0, 5)
    # numero_aleatorio = randrange(0, 20, 2)
    numero_aleatorio = choice( lista )
    print(f"Numero aleatorio {i}: ", numero_aleatorio)
