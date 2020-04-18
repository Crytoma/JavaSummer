package chickengame;

public class chicken
{
    private int age;
    private String name;
    private int chickenID;
    private int eggRatePerWeek;

    public chicken(String name, int age, int eggRatePerWeek, int chickenID)
    {
        this.name = name;
        this.age = age;
        this.eggRatePerWeek = eggRatePerWeek;
        this.chickenID = chickenID;
    }
}
