import pygame
pygame.init()
print("Novo Circulo")
tela = pygame.display.set_mode( (800, 600), 0, 32 )
x = 40
while True:
    # Calcula as regras
    pontos = [ (400, 50), (200, 500), (600, 500) ]
    x = x + 0.1

    # Desenha na tela
    tela.fill( (0, 0, 0) )
    tela.set_at( (400, 100), (255, 255, 0) )
    pygame.draw.circle( tela, (255, 255, 0), (x, 150), 30, 5 )
    pygame.draw.rect( tela, (255, 255, 0),  ( (50, 300), (300, 20) ), 5 )
    pygame.draw.polygon( tela, (255, 255, 0), pontos, 2)
    pygame.display.update()

    # Captura os eventos (intenções) do jogador
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            exit()