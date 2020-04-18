package chickengame;

public class warriorChicken extends chicken
{
    private int hp;
    private int stamina;
    private int armor;

    public warriorChicken(int hp, int stamina, int armor, String name, int age, int eggRatePerWeek, int chickenID)
    {
        super(name, age, eggRatePerWeek, chickenID);
        this.hp = hp;
        this.stamina = stamina;
        this.armor = armor;

    }

}