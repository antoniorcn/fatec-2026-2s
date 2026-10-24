import pygame

pygame.init()

WIDTH = 800
HEIGHT = 600

tela = pygame.display.set_mode((WIDTH, HEIGHT), 0, 32)

font = pygame.font.Font("BAUHS93.TTF", 32)

raquete_original_x = 50
raquete_original_y = 550
raquete_original_w = 156
raquete_original_h = 36
raquete_velocidade = 0
raquete_img = pygame.image.load("raquete.png").convert_alpha()
raquete_original_img = pygame.transform.scale(raquete_img, (raquete_original_w, raquete_original_h))

nome_jogo = font.render("A R K A N O I D", True, (255, 255, 0))


bola_x = 350
bola_y = 10
bola_size = 15
bola_vel_x = 1
bola_vel_y = 1
bola_cor = (255, 255, 0)

jogando = True

pontos = 0 
vidas = 5
while jogando:
    # Regras do Jogo
    raquete_original_x = raquete_original_x + raquete_velocidade
    bola_x = bola_x + bola_vel_x
    bola_y = bola_y + bola_vel_y

    if bola_x > WIDTH:
        bola_vel_x = -1
    if bola_x < 0:
        bola_vel_x = 1

    if bola_y > HEIGHT:
        bola_y = 10
        bola_x = 350
        vidas = vidas - 1
    if vidas <= 0:
        jogando = False
    if bola_y < 0:
        bola_vel_y = 1

    bola_rect = pygame.Rect( (bola_x, bola_y), (bola_size, bola_size) )
    raquete_rect = pygame.Rect((raquete_original_x, raquete_original_y),
                               (raquete_original_w, raquete_original_h))

    if raquete_rect.colliderect( bola_rect ):
        bola_vel_y = bola_vel_y * -1
        pontos = pontos + 1


    # Desenhar na tela
    tela.fill((0, 0, 0))
    tela.blit(raquete_original_img, (raquete_original_x, raquete_original_y))
    tela.blit(nome_jogo, (350, 10))

    str_vidas = f"Vidas: {vidas}"
    str_pontos = f"Pontos: {pontos}"
    vidas_img = font.render(str_vidas, True, (255, 255, 0))
    pontos_img = font.render(str_pontos, True, (255, 255, 0))
    tela.blit(vidas_img, (50, 10))
    tela.blit(pontos_img, (600, 10))

    pygame.draw.ellipse(tela, bola_cor, bola_rect )

    pygame.display.update()

    # Capturar eventos do usuario
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            jogando = False
        elif e.type == pygame.KEYDOWN:
            if e.key == pygame.K_a:
                raquete_velocidade = -1
            elif e.key == pygame.K_d:
                raquete_velocidade = 1
        elif e.type == pygame.KEYUP:
            if e.key in [pygame.K_a, pygame.K_d]:
                raquete_velocidade = 0
