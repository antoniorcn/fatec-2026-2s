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

raquete_a = {"x": 200, "vel": 0, "imagem" : None}
bloco_r = {"x": 100, "y": 100, "imagem": None}

blocos = [{"x": 32, "y": 100, "imagem": None},
          {"x": 96, "y": 100, "imagem": None},
          {"x": 160, "y": 100, "imagem": None},
          {"x": 224, "y": 100, "imagem": None},
          {"x": 288, "y": 100, "imagem": None}]

# Surface (Imagem) da Raquete
raquete_imagem = pygame.image.load("./raquete_a.png").convert_alpha()
bloco_r_imagem = pygame.image.load("./bloco_red.png").convert_alpha()
raquete_a["imagem"] = pygame.transform.scale( raquete_imagem, (128, 32) )
for i in range(5):
    blocos[i]["imagem"] = pygame.transform.scale(bloco_r_imagem, (64, 32))

ball = {"x": 300, "y": 400, "vel_x": 1, "vel_y": 1}



jogando = True
while jogando:
    # Calcular as regras
    raquete_a["imagem"].get_size() # (64, 16)  [0]
    raquete_a["x"] = raquete_a["x"] + raquete_a["vel"]
    if (raquete_a["x"] + raquete_a["imagem"].get_size()[0]) > WIDTH:
        raquete_a["x"] = WIDTH - raquete_a["imagem"].get_size()[0]
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


    raquete_rect = pygame.Rect( ( (raquete_a["x"], 700),
                                 raquete_a["imagem"].get_size() ) )


    if raquete_rect.collidepoint(ball["x"], ball["y"]):
        ball["vel_y"] = ball["vel_y"] * -1

    for i in range(5):
        bloco_r_rect = pygame.Rect( ( (blocos[i]["x"], blocos[i]["y"]),
                                         (64, 32) ))
        if bloco_r_rect.collidepoint(ball["x"], ball["y"]):
            ball["vel_y"] = ball["vel_y"] * -1


    # Pintar a tela
    tela.fill(BLACK)
    # pygame.draw.rect(tela, RED, raquete_rect, 0 )
    tela.blit( raquete_a["imagem"], (raquete_a["x"], 700))
    for i in range(5):
        tela.blit( blocos[i]["imagem"], (blocos[i]["x"], blocos[i]["y"]))
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
