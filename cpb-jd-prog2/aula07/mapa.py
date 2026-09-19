import pygame

# "G" -> Grama
# "P" -> Pedra
# "A" -> Agua
# "C" -> Chão

mapa = [
    ["G", "P", "P", "C", "G", "G", "G", "G", "G", "G", "G", "G"],
    ["G", "P", "G", "C", "C", "C", "G", "G", "G", "G", "G", "G"],
    ["A", "A", "A", "G", "G", "C", "C", "C", "C", "C", "C", "G"],
    ["G", "G", "A", "A", "A", "A", "A", "G", "G", "G", "C", "G"],
    ["G", "G", "G", "G", "G", "G", "A", "G", "G", "G", "C", "G"],
    ["G", "G", "G", "G", "G", "G", "A", "A", "A", "A", "C", "A"],
    ["G", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "G"],
    ["G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G"],
    ["G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G"],
    ["G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G"],
    ["G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G"],
    ["G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G"]
]

IMAGE_WIDTH = 64
IMAGE_HEIGHT = 64

pygame.init()

tela = pygame.display.set_mode((800, 600), 0, 32)

grama_temp = pygame.image.load("grama.png").convert_alpha()
agua_temp = pygame.image.load("agua.png").convert_alpha()
pedra_temp = pygame.image.load("pedra.png").convert_alpha()
chao_temp = pygame.image.load("chao.png").convert_alpha()

grama = pygame.transform.scale( grama_temp, (IMAGE_WIDTH, IMAGE_HEIGHT) )
agua = pygame.transform.scale( agua_temp, (IMAGE_WIDTH, IMAGE_HEIGHT) )
pedra = pygame.transform.scale( pedra_temp, (IMAGE_WIDTH, IMAGE_HEIGHT) )
chao = pygame.transform.scale( chao_temp, (IMAGE_WIDTH, IMAGE_HEIGHT) )

rodando = True

while rodando:

    for num_linha in range(12):
        y = num_linha * IMAGE_HEIGHT
        for num_coluna in range(12):
            celula = mapa[num_linha][num_coluna]  # "A"
            x = num_coluna * IMAGE_WIDTH
            if celula == "G":
                tela.blit( grama, (x, y) )
            elif celula == "P":
                tela.blit( pedra, (x, y) )
            elif celula == "C":
                tela.blit( chao, (x, y) )
            elif celula == "A":
                tela.blit( agua, (x, y) )
            

    pygame.display.update()

    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            rodando = False