package RPGgameJava;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
    //Objetos da classe Spell instanciados
    private Spell basicAtack = new Spell("Chapuletada", 10, 0);
    private Spell spell_00 = new Spell("Flames", 15, 10);
    private Spell spell_01 = new Spell("Fire Bolt", 20, 20);
    private Spell spell_02 = new Spell("Fireball", 30, 30);
    private Spell spell_03 = new Spell("Frost Bite", 15, 10);
    private Spell spell_04 = new Spell("Ice Spike", 20, 20);
    private Spell spell_05 = new Spell("Ice Storm", 30, 30);
    private Spell spell_06 = new Spell("Sparks", 15, 10);
    private Spell spell_07 = new Spell("Lightning Bolt", 20, 20);
    private Spell spell_08 = new Spell("Chain Lightning", 30, 30);
    private ArrayList<Spell> spellSet00 = new ArrayList();
    private ArrayList<Spell> spellSet01 = new ArrayList();
    private ArrayList<Spell> spellSet02 = new ArrayList();
    //Objetos da classe Player instanciados
    private Player character_00 = new Player("Markov", 100, 100, 10, 10, 9, (float) 1.5,spellSet00);
    private Player character_01 = new Player("Morrigan", 100, 100, 10, 10, 10, (float) 1.5,spellSet01);
    private Player character_02 = new Player("Jaina", 100, 100, 10, 10, 8, (float) 1.5,spellSet02);
    private ArrayList<Player> characters = new ArrayList();
    
    //Adiciona os objetos instanciados as listas spellSet_00, spellSet_01 e spellSet_02
    public void loadSpells(){
        spellSet00.add(basicAtack);
        spellSet00.add(spell_00);
        spellSet00.add(spell_01);
        spellSet00.add(spell_02);
        spellSet01.add(basicAtack);
        spellSet01.add(spell_03);
        spellSet01.add(spell_04);
        spellSet01.add(spell_05);
        spellSet02.add(basicAtack);
        spellSet02.add(spell_06);
        spellSet02.add(spell_07);
        spellSet02.add(spell_08);
    }
    
    //Adiciona os objetos instanciados a lista characters
    public void loadCharacters(){
        characters.add(character_00);
        characters.add(character_01);
        characters.add(character_02);
    }
    
    //Imprime todos os objetos da lista characters
    public void printCharacters(){
        for(int i = 0; i < characters.size(); i++){
            System.out.println("[" + (i+1) + "] " + "-------------------------" + 
                                        "\n " + "   NAME: " + characters.get(i).getName() +
                                        "\n " + "   HP: " + characters.get(i).getHp() +
                                        "\n " + "   MP: " + characters.get(i).getMp() +
                                        "\n " + "   ATK: " + characters.get(i).getAtack() +
                                        "\n " + "   DEF: " + characters.get(i).getDefense() +
                                        "\n " + "   SPD: " + characters.get(i).getSpeed() + 
                                        "\n " + "   -------------------------\n");
        }
    }
    
    //Imprime todas "spells" de um objeto Player
    public void printSpells(Player p){
        for(int i = 0; i < p.getSpells().size(); i++){
            System.out.println("[" + (i+1) + "] " + "-------------------------" + 
                                        "\n " + "   NOME: " + p.getSpells().get(i).getName() +
                                        "\n " + "   POWER: " + p.getSpells().get(i).getPower() +
                                        "\n " + "   COST: " + p.getSpells().get(i).getCost() +
                                        "\n " + "   -------------------------\n");
        }
    }
    
    //Seleciona um objeto player instanciado para o jogador
    public Player playerSelection(int option){
        return characters.get(option - 1);
    }
    
    //Seleciona um objeto player instanciado para o computador de forma aleatória e que seja diferente 
    //do objeto retornado por playerSelection()
    public Player computerSelection(Player p){
        Player c = new Player();
        Random seed = new Random();
        int dice = seed.nextInt(characters.size());
        c = characters.get(dice);
        while(c == p){
            dice = seed.nextInt(characters.size());
            c = characters.get(dice);
        }
        return c;
    }
    
    //Simula um dado de 20 lados
    public int rollDice(){
        Random seed = new Random();
        int x = seed.nextInt(20) + 1;
        return x;
    }
    
    //Calcula o dano de acordo com os atributos do jogador e do computador
    public float damage(Player x, Player y, Spell z){
        int dice = rollDice();
        System.out.println(x.getName() + " conjure " + z.getName());
        float damage;
        
        if(dice == 1){
            System.out.println(x.getName() + " miss!");
            return 0;
        }
        
        if(dice == 20){
            damage = (x.getAtack() + z.getPower() - y.getDefense()) * x.getCriticalDamage();
            System.out.println("Critical Hit! " + y.getName() + " lost " + damage + " health points.");
            return damage;
        }
        
        damage = (x.getAtack() + z.getPower() - y.getDefense()) * 1;
        System.out.println(y.getName() + " lost " + damage + " health points.");
        return damage;
    }
    
    //Seleciona a "spell" que será conjurada pelo jogador
    public Spell playerAction(Player p, int option){
        if(option == 1){
            p.setMp(p.getMp() + 15);
            if(p.getMp() >= 100){
                p.setMp(100);
            }
            return p.getSpells().get(0);
        }
        p.setMp(p.getMp() - p.getSpells().get(option - 1).getCost());
        return p.getSpells().get(option - 1);
    }
    
    //Seleciona a "spell" que será conjurada pelo computador
    public Spell computerAction(Player c){
        Random seed = new Random();
        int option = seed.nextInt(4);
        if(c.getMp() < c.getSpells().get(option).getCost()){
            c.setMp(c.getMp() + 15);
            if(c.getMp() >= 100){
                c.setMp(100);
            }
            return c.getSpells().get(0);
        }
        c.setMp(c.getMp() - c.getSpells().get(option).getCost());
        return c.getSpells().get(option);
    }
    
    //Define a ordem de batalha, quem ataca antes e quem ataca depois.
    public void turn(Player p, Player c){
        Spell pSpell = new Spell();
        Spell cSpell = new Spell();
        Scanner s = new Scanner(System.in);
        int option = 0;
        printSpells(p);
        option = s.nextInt();
        pSpell = playerAction(p, option);
        
        cSpell = computerAction(c);
        
        if(p.getSpeed() > c.getSpeed()){
            c.setHp(c.getHp() - damage(p, c, pSpell));
            if(c.getHp() > 0){
                p.setHp(p.getHp() - damage(c, p, cSpell));
            }
        }
        if(p.getSpeed() < c.getSpeed()){
            p.setHp(p.getHp() - damage(c, p, cSpell));
            if(p.getHp() > 0){
                c.setHp(c.getHp() - damage(p, c, pSpell));
            }
        }
        if(p.getSpeed() == c.getSpeed()){
            int dice = rollDice();
            if(dice <= 10){
                c.setHp(c.getHp() - damage(p, c, pSpell));
                if(c.getHp() > 0){
                    p.setHp(p.getHp() - damage(c, p, cSpell));
                }
            }
            if(dice > 10){
                p.setHp(p.getHp() - damage(c, p, cSpell));
                if(p.getHp() > 0){
                    c.setHp(c.getHp() - damage(p, c, pSpell));
                }
            }
        }
    }
    
    //Atualiza as informações dos jogadores a cada turno
    public void battle(Player p, Player c){
        int turnCounter = 1;
        System.out.println(p.getName() + " VS " + c.getName());
        while(p.getHp() > 0 && c.getHp() > 0){
            System.out.println("Turn: " + turnCounter);
            System.out.println(p.getName() + " " + p.getHp() + "HP / " + p.getMp() + "MP");
            System.out.println(c.getName() + " " + c.getHp() + "HP / " + c.getMp() + "MP");
            turn(p,c);
            turnCounter++;
            if(c.getHp() <= 0){
                System.out.println(p.getName() + " Wins!");
            }
            if(p.getHp() <= 0){
                System.out.println(c.getName() + " Wins!");
            }
        }
    }
    
    //Chama todas as funções necessárias para o funcionamento do jogo
    public void run(){
        Scanner s = new Scanner(System.in);
        Player p = new Player();
        Player c = new Player();
        loadSpells();
        loadCharacters();
        printCharacters();
        int option = s.nextInt();
        try{
            p = playerSelection(option);
        }catch(Exception e){
           System.out.println("Invalid value!");
            printCharacters();
            p = playerSelection(option);
        }
        c = computerSelection(p);
        battle(p, c);
        System.out.println("Game Over...");
    }
}
