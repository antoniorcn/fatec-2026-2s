import pygame

class HeroiSprite( pygame.sprite.Sprite ):

    def __init__(self, pos_inicial, direcao_inicial, tamanho, sprite_sheet, tamanho_frame, colunas ):
        pygame.sprite.Sprite.__init__(self)
        #       x ,  y
        self.pos = pos_inicial
        self.direcao = direcao_inicial
        self.size = tamanho
        self.animacao = [29, 30, 31, 32, 33, 34, 35, 36]
        self.indice_animacao = 0
        self.maximo_colunas = colunas
        self.sprite_sheet = sprite_sheet
                                             #   width   height
        self.tamanho_frame = tamanho_frame   # ( 64,      64 )
        self.image = self.pegar_frame()
        self.rect = pygame.Rect( self.pos, self.size )

    def pegar_frame(self):
        gid = self.animacao[self.indice_animacao]
        coluna = (gid - 1) % self.maximo_colunas
        linha = (gid - 1) // self.maximo_colunas
        x = coluna * self.tamanho_frame[0]
        y = linha * self.tamanho_frame[1]
        return self.sprite_sheet.subsurface(((x, y), self.tamanho_frame))

    def update(self):
        #                       x                            y
        self.rect.move_ip( self.direcao, 0 )
        print(self.rect)
        
        self.indice_animacao = self.indice_animacao + 1
        if self.indice_animacao >= len(self.animacao):
            self.indice_animacao = 0
        self.image = self.pegar_frame()



pygame.init()

tela = pygame.display.set_mode( (800, 600), 0, 32)
sprite_sheet = pygame.image.load("./imagens/EpicArmor.png").convert_alpha()

frame_heroi = sprite_sheet.subsurface((0, 128), (64, 64))

heroi1 = HeroiSprite((0, 100), 5, (128, 128), sprite_sheet, (64, 64), 9)
heroi2 = HeroiSprite((600, 100), -5, (128, 128), sprite_sheet, (64, 64), 9)
# heroi3 = HeroiSprite((100, 260), sprite_sheet, (64, 64), 9)
# heroi4 = HeroiSprite((100, 340), sprite_sheet, (64, 64), 9)

personagens = pygame.sprite.Group( [ heroi1, heroi2 ] )

jogando = True
ciclo_atual = 0
while jogando:
    # Calcular regras
    ciclo_atual = ciclo_atual + 1
    if ciclo_atual > 200:
        personagens.update()
        ciclo_atual = 0

    if pygame.sprite.collide_rect(heroi1, heroi2):
        heroi1.kill()

    # Atualizar a tela
    tela.fill( (0, 0, 0) )
    personagens.draw( tela )
    pygame.display.update()

    # Capturar os eventos
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            jogando = False
