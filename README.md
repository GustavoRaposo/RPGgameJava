# RPGgameJava
Introdução:
  Este é um jogo de RPG por turno. As mecânicas são básicas e baseadas nos RPG's clássicos, onde quem ataca primeiro é quem tem o maior
  atributo de velocidade e vence quem levar os pontos de vida (HP) do oponente a 0 por primeiro.
  Inicialmente existe dois tipos de ataque:
  
    - ataque básico:
      Este ataque por definição é uma magia, mas este ataque não consome pontos de mana (MP) e recupera sua pontos de mana (MP),
      porém causa um dano menor comparado aos demais ataques.
    - magias:
      Este ataque necessita que o jogador tenha pontos de mana (MP) maior ou igual ao custo desta magia, se atender essa condição o
      custo da magia é subtraido aos pontos mana (MP) total do jogador, estes ataques causam um dano maior
      
  Todo ataque possui chances de falhar ou causar um acerto crítico, estes dois eventos tem 5% de chance acontecer, caso o ataque falhe
  seu dano ao oponente será nulo, caso aconteça um acerto crícito o dano é multiplicado pelo atributo de dano crítico do personagem.
  
  Cada personagem possui atributos como:
  
    - pontos de vida (HP)
    - pontos de mana (MP)
    - ataque
    - defesa
    - velocidade
    - dano crítico
    
  Além destes atributos cada personagem possui um conjunto de  quatro (4) magias, sendo um (1) ataque básico e três (3) magias.

Como rodar o jogo:

  Primeiramente é necessário que a máquina possua Java intalado, em seguida caso você tenha alguma IDE que execute Java, basta executar
  o arquivo RPGgame.java

Codigo Fonte:

  O codigo fonte apresenta quatro (4) arquivos principais:
  
    - RPGgame.java
    - Game.java
    - Player.java
    - Spell.java
    
  arquivo RPGgame:
  
    Este arquivo possui o método main que instancia um objeto "game" da Classe Game e chama o método run que iniciará o jogo
    
  arquivo game:
  
    Aqui estão todas as mecâncias do jogo e as instanciações das classes Player e Spell
    
  arquivo player:
  
    Aqui é definido a classe Player com seus atributos e metodos conrrespondente a ele.
    
  arquivo spell:
  
    Assim como o arquivo player, aqui é definido a classe Spell com seus atributos
