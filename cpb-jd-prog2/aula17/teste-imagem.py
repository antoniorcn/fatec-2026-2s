import pygame

pygame.init()

tela = pygame.display.set_mode((800, 600), 0, 32)

raquete_img = pygame.image.load("raquete.png").convert_alpha()
raquete_original_img = pygame.transform.scale(raquete_img, (156, 36))
raquete_flipped_img = pygame.transform.flip(raquete_original_img, True, True)
raquete_rotated_img = pygame.transform.rotate(raquete_original_img, 45)


print("Fontes: ", pygame.font.get_fonts())


# font = pygame.font.Font("BAUHS93.TTF", 40)
font = pygame.font.SysFont("gabriola", 32, True, False)

texto_arkanoid = font.render("A R K A N O I D", True, (255, 255, 0))

#                             0    1
#                          ( 350, 150 )
#
def desenhar_cruzeta(tela, pos : tuple, imagem : pygame.Surface):
    w = imagem.get_width()
    h = imagem.get_height()
    # x = pos[0]
    # y = pos[1]
    x, y = pos
    pygame.draw.line(tela, (255, 0, 0),
                     (x + (w / 2.0) - 20,
                      y + (h / 2.0)),
                     (x + (w / 2.0) + 20,
                      y + (h / 2.0)), 3)

    pygame.draw.line(tela, (255, 0, 0),
                     (x + (w / 2.0),
                      y + (h / 2.0) - 20),
                     (x + (w / 2.0),
                      y + (h / 2.0) + 20), 3)


raquete_original_x = 350
raquete_original_y = 150

jogando = True
while jogando:
    # Regras do Jogo

    # Desenhar na tela
    # tela.blit(raquete_img, (350, 150))


    tela.blit(raquete_original_img, (raquete_original_x, raquete_original_y))
    tela.blit(raquete_rotated_img, (350, 350))

    tela.blit(texto_arkanoid, (200, 0))

    desenhar_cruzeta(tela, (raquete_original_x, raquete_original_y), raquete_original_img)
    desenhar_cruzeta(tela, (350, 350), raquete_rotated_img)
    
    pygame.display.update()

    # Capturar eventos do usuario
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            jogando = False
