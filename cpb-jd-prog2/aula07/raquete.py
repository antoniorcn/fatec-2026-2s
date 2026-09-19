import pygame

pygame.init()

WIDTH = 600
HEIGHT = 800

BLACK = (0, 0, 0)
RED = (255, 0, 0)
WHITE = (255, 255, 255)

tela = pygame.display.set_mode( (WIDTH, HEIGHT), 0, 32)
# Trocar estas variaveis por dicionarios
# um chamado (ball) e outro chamado (raquete)

pygame.image.load("./raquete_a.png")

# raquete_a_x = 200
# raquete_a_vel = 0

raquete_a = {"x": 200, "vel": 0}

ball = {"x": 300, "y": 400, "vel_x": 1, "vel_y": 1}
# ball_x = 300
# ball_y = 400
# ball_vel_x = 1
# ball_vel_y = 1

jogando = True
while jogando:
    # Calcular as regras
    raquete_a["x"] = raquete_a["x"] + raquete_a["vel"]
    if (raquete_a["x"] + 100) > WIDTH:
        raquete_a["x"] = 500
    if raquete_a["x"] < 0:
        raquete_a["x"] = 0

    ball["x"] = ball["x"] + ball["vel_x"]
    ball["y"] = ball["y"] + ball["vel_y"]

    if ball["x"] > WIDTH:
        ball["vel_x"] = -1
    elif ball["x"] < 0:
        ball["vel_x"] = 1

    if ball["y"] > HEIGHT:
        ball["vel_y"] = -1
    elif ball["y"] < 0:
        ball["vel_y"] = 1

    raquete_rect = pygame.Rect( ( (raquete_a["x"], 700), (100, 30) ) )

    if raquete_rect.collidepoint(ball["x"], ball["y"]):
        ball["vel_y"] = ball["vel_y"] * -1


    # Pintar a tela
    tela.fill(BLACK)
    pygame.draw.rect(tela, RED, raquete_rect, 0 )
    pygame.draw.circle(tela, WHITE, (ball["x"], ball["y"]), 10.0, 3)
    pygame.display.update()
    # Capturar os eventos
    for evento in pygame.event.get():
        if evento.type == pygame.QUIT:
            jogando = False
        elif evento.type == pygame.KEYDOWN:
            if evento.key == pygame.K_a:
                raquete_a["vel"] = -1
            elif evento.key == pygame.K_d:
                raquete_a["vel"] = 1
