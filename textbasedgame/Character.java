package textbasedgame;
import java.util.ArrayList;
import java.util.List;

public class Character
{
    private List <Character> characterAttributes;
    private int ID;
    private int CurrentLocation;
    private String Name;
    private String Description;

    public Character(int ID, int  CurrentLocation, String Name, String Description)
    {
        characterAttributes = new ArrayList<Character>();
        this.ID = ID;
        this.CurrentLocation = CurrentLocation;
        this.Name = Name;
        this.Description = Description;
    }

    public List <Character> getList()
    {
        return characterAttributes;
    }

    public int getID()
    {
        return ID;
    }

    public int getLocation()
    {
        return CurrentLocation;
    }

    public String getName()
    {
        return Name;
    }

    public String getDescription()
    {
        return Description;
    }
    
    //Getter and setter soon.
    @Override
    public String toString()
    {
        return "Character [ID=" + ID + ", Current Location=" + CurrentLocation + ", Name=" + Name + ", Description= " + Description + "]";
    }

}