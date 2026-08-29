from random import choice

# simbolos_caca_niquel = ['$', '7', 'X', 'O', '#', '@', '&', '%', 'W', 'V']

simbolos_caca_niquel = ['$', '7', 'X', 'O', '#']

while True:

    simbolo_1 = choice( simbolos_caca_niquel )
    simbolo_2 = choice( simbolos_caca_niquel )
    simbolo_3 = choice( simbolos_caca_niquel )

    barra_horizontal = "-" * 80
    lateral = "-" * 10
    print( barra_horizontal)

    telinha = f" {simbolo_1:^18}|{simbolo_2:^18}|{simbolo_3:^18} "

    print( lateral, telinha,  lateral)
    print( barra_horizontal)

    ganhou = simbolo_1 == simbolo_2 and simbolo_2 == simbolo_3

    if ganhou:  # ganhou == True
        print("Parabéns você ganhou o prêmio máximo")
    elif simbolo_1 == simbolo_2:
        print("Você ganhou 2X o que acabou de aposta")
    elif simbolo_2 == simbolo_3:
        print("Você ganhou 3X o que acabou de aposta")
    elif simbolo_1 == simbolo_3:
        print("Você ganhou o mesmo valor de volta")
    else:
        print("Que pena você perdeu, tente mais vez, mas lembre-se jogue com responsabilidade")

    input()

print("Fim do jogo")