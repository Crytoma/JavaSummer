package textbasedgame;

class Item
{
    private int ID;
    private String Description;
    private String Status;
    private int Location;
    private String Name;
    private String Commands;
    private String Results;

    public Item(int ID, String Description, String Status, int Location, String Name, String Commands, String Results)
    {
        this.ID = ID;
        this.Description = Description;
        this.Status = Status;
        this.Location = Location;
        this.Name = Name;
        this.Commands = Commands;
        this.Results = Results;

        
    }

    public int getID()
    {
        return ID;
    }

    public int getLocation()
    {
        return Location;
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
        return "Item [ID=" + ID + ", Name=" + Name + ", Description= " + Description + ", Status= " + Status + "]";
    }

}