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

    # Desenhar na Tela
    pygame.display.update()
    # Capturar os eventos
    eventos = pygame.event.get()
    for e in eventos:
        # print(e)
        if e.type == pygame.QUIT:
            executando = False
        elif e.type == pygame.KEYDOWN:
            if e.key == pygame.K_DOWN:
                
# Event(768-KeyDown {'unicode': 'c', 'key': 99, 'mod': 4096, 'scancode': 6, 'window': None})>