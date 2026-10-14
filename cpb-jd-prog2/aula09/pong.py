import pygame
from random import randint
pygame.init()

WIDTH = 800
HEIGHT = 600

tela = pygame.display.set_mode((WIDTH, HEIGHT), 0, 32)

def atualizar_bola( bola : dict ): 
    x, y = bola["pos"]
    dir_x, dir_y = bola["direcao"]

    if x >= WIDTH:
        dir_x = -1
    if x <= 0:
        dir_x = 1
    if y >= HEIGHT:
        dir_y = -1
    if y <= 0:
        dir_y = 1

    bola["pos"] = (x + dir_x, y + dir_y)
    bola["direcao"] = (dir_x, dir_y)


def desenhar_bola( bola : dict ):
    pygame.draw.circle(tela, bola["cor"], bola["pos"], bola["size"] )

jogando = True

# bola_pos = (WIDTH / 2, HEIGHT / 2)
# bola_size = 10
# bola_cor = (255, 255, 0)
# bola_direcao_x = 1

# bola = {"pos" : (WIDTH / 2, HEIGHT / 2), "size": 10,
#        "cor": (255, 255, 0), "direcao": (1, 1)}

# bola2 = {"pos" : (50, HEIGHT / 2), "size": 10,
#         "cor": (255, 0, 0), "direcao": (1, 1)}

lista_bolas = []
for i in range(50):
    bola = {"pos" : (randint(1, WIDTH), randint(1, HEIGHT)), 
            "size": randint(5, 20),
            "cor": (randint(0, 255), randint(0, 255), randint(0, 255)), 
            "direcao": (randint(-1, 2), randint(-1, 2))}
    lista_bolas.append( bola )

while jogando:
    # Calcular as regras
    # bola["pos"] = (bola["pos"][0] + 1, bola["pos"][1])
    for bola in lista_bolas:
        atualizar_bola( bola )
    # atualizar_bola( bola2 )

    # Pintar a tela
    tela.fill( (0, 0, 0) )
    for bola in lista_bolas:
        desenhar_bola(bola)

    # desenhar_bola(bola)
    # desenhar_bola(bola2)
    pygame.display.update()

    # Capturar os eventos do jogador
    for evento in pygame.event.get():
        if evento.type == pygame.QUIT:
            jogando = False
