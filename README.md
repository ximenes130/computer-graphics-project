# Projeto de Computação Gráfica

### Integrantes
- Ana Luiza
- Luiz Ximenes
- Carlos Gonçalves

### Requisitos
A definir...

### Como executar
A definir...

### Detalhes

Implementar um Editor Vetorial 2D para “adicionar” e “manipular” polígonos fechados utilizando somente o teclado e mouse.

#### Conhecimento necessário:

- Estruturas simples dinâmicas para armazenar os dados gráficos;
- Algoritmo de seleção: selecionar polígonos côncavos (não entrelaçados);
- Transformações geométricas 2D: movimentar, girar e redimensionar objetos;
- Conceitos básicos de grafo de cena;

**Descrição:** o cenário consiste em implementar um Editor Vetorial 2D para “adicionar” e “manipular” polígonos fechados utilizando somente o teclado e mouse utilizando a biblioteca OpenGL. A aplicação deve permitir “adicionar” interativamente (“clicando” na tela) polígonos sem limite do número de vértices, e sem limite de polígonos. Além disso, cada polígono pode ter sua própria cor e deve ser possível: apagar/mover vértices e apagar/mover polígonos. Estas funções (apagar/mover) devem se interativas (o usuário deve clicar no polígono ou vértice).

**Observação:** as funções do OpenGL “glTranslate”, “glRotate” e “glScale” não deve ser utilizada para fazer as Transformações Geométricas, e sim deve ser usado a classe “Transform” associada ao objeto gráfico. Assim o método de desenho do objeto gráfico utiliza “Transform” junto com as funções do OpenGL “glPushMatrix”, “glMultMatrixd”e “glPopMatrix”. A justificativa, é que desta forma isolasse o render do OpenGL facilitando, se for o caso, mudar para outra forma de renderizar (por exemplo, DirectX). Observem que após mover os objetos gráficos usando a matriz de transformação do referido objeto não é possível simplesmente selecionar o objeto usando os seus vértices originais. Tem de pegar o valor das coordenadas de tela (do pixel), converter para o espaço gráfico e converter para o espaço do objeto gráfico transformado usando as matrizes de transformações do grafo de cena até chegar no objeto desejado.

#### Questões Práticas:

Todas as questões deste trabalho devem ser implementadas em único projeto.

**Especificação e documentação**
>1. Especificar usando Diagrama de Classes;
>2. Documentar o código (JavaDoc ou DoxyGen).

**Estrutura de dados dinâmica**
>3. Inserir e remover polígonos;
>4. Selecionar vértice usando o mouse para pode mover ou remover o respectivo vértice (no caso do mover vértice o valores da coordenada é alterada, e não os valores da matriz de transformação).

**Visualização**
>5. Exibir o “rasto” ao desenhar os segmentos do polígono.

**Interação com o usuário (usando teclado e mouse)**
>6. Desenhar polígonos (fechado) “clicando” na tela;
>7. Trocar as cores dos polígonos (pode ser associado a uma tecla);
>8. Seleção de polígonos usando detecção hierárquica filtrando primeiro pela BBox e, se for interno a BBox então testar usando Scan Line (exibir a BBox do polígono selecionado).

**Transformações Geométricas (usar matriz de transformação, não altera os valores dos vértices dos polígonos)**

>9. Translação: mover o polígono selecionado;
>10. Escala: redimensionar o polígono selecionado em relação ao centro da sua BBox;
>11. Rotação: girar o polígono selecionado em relação ao centro da sua BBox.

**Grafo de cena (usar matriz de transformação global para acumular transformações de acordo com o grafo de cena)**
>12. Espelhamento: espelhar o objeto em relação ao eixo z.
