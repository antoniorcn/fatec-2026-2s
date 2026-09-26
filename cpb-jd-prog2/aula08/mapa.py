"""Jogo com Mapa feito por matrizes 12x12"""
import pygame

# "G" -> Grama
# "P" -> Pedra
# "A" -> Agua
# "C" -> Chão

mapa = [
    ["G", "P", "P", "C", "G", "G", "G", "G", "G", "G", "G", "G"],
    ["G", "G", "G", "C", "C", "C", "G", "G", "G", "G", "G", "G"],
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

def carregar_imagem( nome_imagem : str,
                    largura : int = 64, altura : int = 64 ):
    """Função que carrega uma imagem e transforma ela para
     altura e largura desejadas"""
    temp = pygame.image.load( nome_imagem ).convert_alpha()
    image_transformada = pygame.transform.scale( temp, (largura, altura) )
    return image_transformada

IMAGE_WIDTH = 64
IMAGE_HEIGHT = 64

pygame.init()

tela = pygame.display.set_mode((800, 600), 0, 32)

grama = carregar_imagem("grama.png", largura=IMAGE_WIDTH, altura=IMAGE_HEIGHT)
agua = carregar_imagem("agua.png", IMAGE_WIDTH, IMAGE_HEIGHT)
pedra = carregar_imagem("pedra.png", IMAGE_WIDTH, IMAGE_HEIGHT)
chao = carregar_imagem("chao.png", IMAGE_WIDTH, IMAGE_HEIGHT)
hero = carregar_imagem("hero64.png", 42, IMAGE_HEIGHT)

# grama_temp = pygame.image.load("grama.png").convert_alpha()
# grama = pygame.transform.scale( grama_temp, (IMAGE_WIDTH, IMAGE_HEIGHT) )
# agua_temp = pygame.image.load("agua.png").convert_alpha()
# pedra_temp = pygame.image.load("pedra.png").convert_alpha()
# chao_temp = pygame.image.load("chao.png").convert_alpha()
# agua = pygame.transform.scale( agua_temp, (IMAGE_WIDTH, IMAGE_HEIGHT) )
# pedra = pygame.transform.scale( pedra_temp, (IMAGE_WIDTH, IMAGE_HEIGHT) )
# chao = pygame.transform.scale( chao_temp, (IMAGE_WIDTH, IMAGE_HEIGHT) )
# carregar_imagem("grama.png", 64, 64)

rodando = True

heroi = {"pos": (10, 10), "imagem": hero}
nova_posicao_heroi = heroi["pos"]
while rodando:

    # Calculo de regras
    hx, hy = nova_posicao_heroi
    hxc = hx + (IMAGE_WIDTH // 2)
    hyc = hy + (IMAGE_HEIGHT // 2)
    hcoluna = hxc // IMAGE_WIDTH
    hlinha = hyc // IMAGE_HEIGHT
    if 0 < hxc < 800 and 0 < hyc < 600 and \
        mapa[hlinha][hcoluna] in ["G", "C"]:
        heroi["pos"] = nova_posicao_heroi

    # Desenho de tela
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
    tela.blit(heroi["imagem"], heroi["pos"])

    pygame.display.update()

    # Capturar os eventos
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            rodando = False
        elif e.type == pygame.KEYDOWN:
            if e.key == pygame.K_DOWN:
                hx, hy = heroi["pos"]
                nova_posicao_heroi = (hx, hy + 5)
            elif e.key == pygame.K_UP:
                hx, hy = heroi["pos"]
                nova_posicao_heroi = (hx, hy - 5)
            elif e.key == pygame.K_LEFT:
                hx, hy = heroi["pos"]
                nova_posicao_heroi = (hx - 5, hy)
            elif e.key == pygame.K_RIGHT:
                hx, hy = heroi["pos"]
                nova_posicao_heroi = (hx + 5, hy)
