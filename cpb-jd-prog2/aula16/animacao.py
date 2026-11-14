import pygame


pygame.init()


tela = pygame.display.set_mode( (800, 600), 0, 32)
ss_heroi = pygame.image.load("./imagens/EpicArmor.png").convert_alpha()

gid = 29
max_colunas = 9
width = 64
height = 64

#                  0   1  2   3   4   5   6   7 
lista_animacao = [29, 30, 31, 32, 33, 34, 35, 36]

jogando = True
ciclo_atual = 0
indice_animacao = 0
heroi_x = 200
while jogando:

    # Calcular regras
    
    ciclo_atual = ciclo_atual + 1
    if ciclo_atual > 200:
        heroi_x = heroi_x - 1
        indice_animacao = indice_animacao + 1
        if indice_animacao >= len(lista_animacao):
            indice_animacao = 0
        ciclo_atual = 0
    gid = lista_animacao[indice_animacao]
    coluna = (gid - 1) % max_colunas
    linha = (gid - 1) // max_colunas
    x = coluna * width
    y = linha * height

    frame_heroi = ss_heroi.subsurface(((x, y), (width, height)))
    frame_heroi = pygame.transform.scale( frame_heroi, (128, 128) )

    # Desenhar na tela
    tela.fill( (0, 0, 0) )
    tela.blit(frame_heroi, (heroi_x, 100))
    pygame.display.update()


    # Capturar os eventos
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            jogando = False