import pygame

pygame.init()

tela = pygame.display.set_mode((800, 600), 0, 32)
boca_largura = 130
boca_crescimento = -1
while True:
    # Calcular as regras
    boca_largura = boca_largura + boca_crescimento
    if boca_largura < 10:
        boca_crescimento = 1

    if boca_largura > 150:
        boca_crescimento = -1

    # Desenhar na tela
    tela.fill( (0, 0, 0) )
    pygame.draw.circle(tela, (255, 255, 0), (400, 300), 200, 5)
    pygame.draw.line(tela, (0, 0, 255), (300, 200), (350, 200), 5)
    pygame.draw.line(tela, (0, 0, 255), (450, 200), (500, 200), 5)
    # pygame.draw.line(color=(0, 0, 255), width=5,
    #                  start_pos=(300, 200), end_pos=(350, 200),
    #                  surface = tela)
    # ((), ())
    pygame.draw.rect(tela, (255, 0, 0), ((325, 400), (boca_largura, 25)))

    nariz = [ (400, 300), (325, 350), (475, 350) ]
    pygame.draw.polygon(tela, (255, 0, 255), nariz )

    pygame.display.update()

    # Capturar os eventos
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            exit()
