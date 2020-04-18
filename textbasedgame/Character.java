package textbasedgame;

class Character
{
    private int ID;
    private int CurrentLocation;
    private String Name;
    private String Description;

    public Character(int ID, int  CurrentLocation, String Name, String Description)
    {
        this.ID = ID;
        this.CurrentLocation = CurrentLocation;
        this.Name = Name;
        this.Description = Description;
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