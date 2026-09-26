"""Este codigo desenha diversas elipses 
de diversos tamanhos e posições aleatórias na tela."""
import pygame
from random import randint

pygame.init()

# tela : pygame.Surface = pygame.display.set_mode((1024, 768), 0, 32)
tela = pygame.display.set_mode((1024, 768), 0, 32)

executando = True
while executando:

    # Calculo regras
    x = randint(0, 800)
    y = randint(0, 600)
    w = randint(0, 400)
    h = randint(0, 300)

    r = randint(0, 255)
    g = randint(0, 255)
    b = randint(0, 255)


    # Desenhar na Tela
    pygame.draw.ellipse(tela, (r, g, b), ((x, y), (w, h)), 0)
    pygame.display.update()
    # Capturar os eventos
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            executando = False