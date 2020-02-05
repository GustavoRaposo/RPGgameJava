package RPGgameJava;

import java.util.ArrayList;

public class Player {
    private String name;
    private float hp;
    private int mp;
    private int atack;
    private int defense;
    private int speed;
    private float criticalDamage;
    private ArrayList<Spell> spells;

    public Player(String name, float hp, int mp, int atack, int defense, int speed, float criticalDamage, ArrayList<Spell> spells) {
        this.name = name;
        this.hp = hp;
        this.mp = mp;
        this.atack = atack;
        this.defense = defense;
        this.speed = speed;
        this.criticalDamage = criticalDamage;
        this.spells = spells;
    }

    Player() {
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHp() {
        return hp;
    }

    public void setHp(float hp) {
        this.hp = hp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getAtack() {
        return atack;
    }

    public void setAtack(int atack) {
        this.atack = atack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public float getCriticalDamage() {
        return criticalDamage;
    }

    public void setCriticalDamage(float criticalDamage) {
        this.criticalDamage = criticalDamage;
    }

    public ArrayList<Spell> getSpells() {
        return spells;
    }

    public void setSpells(ArrayList<Spell> spells) {
        this.spells = spells;
    }
    
    ////Imprime os atributos do Player
    public void printPlayerStats(){
        System.out.println("----------------------------\n" +
                           "Name   : " + this.name + "\n" +
                           "HP     : " + this.hp + "\n" +
                           "MP     : " + this.mp + "\n" +
                           "ATK    : " + this.atack + "\n" + 
                           "DEF    : " + this.defense + "\n" +
                           "SPD    : " + this.speed + "\n" +
                           "----------------------------\n");
    }
    
    //Imprime as "spells" do Player
    public void printPlayerSpells(ArrayList<Spell> s){
        for(int i = 0; i <= s.size(); i++){
            System.out.println("["+ (i+1) + "]:---------------------------\n" +
                               "Name  :" + s.get(i).getName() + "\n" +
                               "Power :" + s.get(i).getPower() + "\n" +
                               "Cost  :" + s.get(i).getCost() + " MP\n" +
                               "--------------------------------\n");
        }
    }
    
}
