# Bag Of Words - Básico
tokens = ['rato', 'roeu', 'a', 'roupa', 'do', 'rei', 'de',
          'Roma', 'O', 'rato', 'roeu', 'a', 'roupa', 'do', 'rei',
          'da', 'Rússia']
#                 1      2      3     4       5      6     7
vocabulario = ['rato', 'roeu', 'a', 'roupa', 'do', 'rei', 'de',
#                8      9    10     11
               'Roma', 'O', 'da', 'Rússia']
bag_of_words = [1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 10, 11]

corpus = """O menino corre no parque.
Ele sorri enquanto brinca.
A mãe observa o menino de longe.
""".lower()
tokens=['o', 'menino', 'corre', 'no', 'parque', 'ele',
        'sorri', 'enquanto', 'brinca', 'a', 'mae', 'observa',
        'o', 'menino', 'de', 'longe', 'e']

#               0      1         2       3      4        5
vocabulario = ['o', 'menino', 'corre', 'no', 'parque', 'ele',
#          6          7          8      9    10       11
        'sorri', 'enquanto', 'brinca', 'a', 'mae', 'observa',
#        12     13
        'de', 'longe']

bag_of_words_documento_1 = [0, 1, 2, 3, 4]
bag_of_words_documento_2 = [5, 6, 7, 8]
bag_of_words_documento_3 = [9, 10, 11, 0, 1, 12, 13]

# Bag Of Words - Binary
corpus = """O menino corre no parque.
Ele sorri enquanto brinca.
A mãe observa o menino de longe.
""".lower()
tokens=['o', 'menino', 'corre', 'no', 'parque', 'ele',
        'sorri', 'enquanto', 'brinca', 'a', 'mae', 'observa',
        'o', 'menino', 'de', 'longe']

#               0      1         2       3      4        5
vocabulario = ['o', 'menino', 'corre', 'no', 'parque', 'ele',
#          6          7          8      9    10       11
        'sorri', 'enquanto', 'brinca', 'a', 'mae', 'observa',
#        12     13
        'de', 'longe']

#                         0  1  2  3  4  5  6  7  8  9 10 11 12 13
bow_binary_documento_1 = [1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0]
bow_binary_documento_2 = [0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0]
bow_binary_documento_3 = [1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1]
