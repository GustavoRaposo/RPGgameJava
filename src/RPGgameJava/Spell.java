package RPGgameJava;

public class Spell {
    private String name;
    private int power;
    private int cost;

    public Spell(String name, int power, int cost) {
        this.name = name;
        this.power = power;
        this.cost = cost;
    }

    Spell() {
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
    
}
