from random import random, seed, randint, choice

# seed(50)
# numero1 = random()  # Produzir um numero entre 0 e 1 (exclusivo)
# print(numero1)
# numero2 = random()
# print(numero2)
# numero3 = random()
# print(numero3)
# numero4 = random()
# print(numero4)

# # Produzir um numero entre 0 e 20
# print("Produzir numero entre 0 e 20")
# numero5 = int(random() * 21)
# print(numero5)

# # Produzir um numero entre 30 e 70
# print("Produzir numero entre 30 e 70")
# numero5 = int(random() * 41) + 30
# print(numero5)

# print("Produzir numero entre 30 e 70")
# numero5 = randint(30, 70)
# print(numero5)

lista = [2, 4, 6, 8, 10, 12, 14]
numero = choice( lista )
print(numero)