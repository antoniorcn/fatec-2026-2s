# Numero Fatorial

#   2! = 2 * 1 = 2
#   3! = 3 * 2 * 1 = 6
#   4! = 4 * 3 * 2 * 1 = 24
#   5! = 5 * 4!
#   4! = 4 * 3!
#   3! = 3 * 2!
#   2! = 2 * 1

def fatorial( numero ):
    if numero <= 1:
        return 1
    return numero * fatorial(numero - 1)

f5 = fatorial(1)
print("Fatorial de 5: ", f5)


# fatorial(5)
# 5 * fatorial(4) = 5 * 24 = 120
# 4 * fatorial(3) = 4 * 6 = 24
# 3 * fatorial(2) = 3 * 2 = 6
# 2 * fatorial(1) = 2  * 1 = 2

