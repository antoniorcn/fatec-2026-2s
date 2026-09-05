import pygame

pygame.init()

WIDTH = 600
HEIGHT = 800

BLACK = (0, 0, 0)
RED = (255, 0, 0)
WHITE = (255, 255, 255)

tela = pygame.display.set_mode( (WIDTH, HEIGHT), 0, 32)
raquete_a_x = 200
raquete_a_vel = 0
ball_x = 300
ball_y = 400
ball_vel_x = 1
ball_vel_y = 1

jogando = True
while jogando:
    # Calcular as regras
    raquete_a_x = raquete_a_x + raquete_a_vel
    if (raquete_a_x + 100) > WIDTH:
        raquete_a_x = 500
    if raquete_a_x < 0:
        raquete_a_x = 0

    ball_x = ball_x + ball_vel_x
    ball_y = ball_y + ball_vel_y

    if ball_x > WIDTH:
        ball_vel_x = -1
    elif ball_x < 0:
        ball_vel_x = 1

    if ball_y > HEIGHT:
        ball_vel_y = -1
    elif ball_y < 0:
        ball_vel_y = 1

    raquete_rect = pygame.Rect( ( (raquete_a_x, 700), (100, 30) ) )

    if raquete_rect.collidepoint(ball_x, ball_y):
        ball_vel_y = ball_vel_y * -1
    

    # Pintar a tela
    tela.fill(BLACK)
    pygame.draw.rect(tela, RED, raquete_rect, 0 )
    pygame.draw.circle(tela, WHITE, (ball_x, ball_y), 10.0, 3)
    pygame.display.update()
    # Capturar os eventos
    for evento in pygame.event.get():
        if evento.type == pygame.QUIT:
            jogando = False
        elif evento.type == pygame.KEYDOWN:
            if evento.key == pygame.K_a:
                raquete_a_vel = -1
            elif evento.key == pygame.K_d:
                raquete_a_vel = 1
