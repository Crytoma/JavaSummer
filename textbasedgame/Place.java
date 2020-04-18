package textbasedgame;

class Place 
{
    private int ID;
    private String Description;
    private int North;
    private int East;
    private int South;
    private int West;
    private int Up;
    private int Down;

    public Place(int ID, String Description, int North, int  East, int South, int West, int Up, int Down)
    {
        this.ID = ID;
        this.Description = Description;
        this.North = North;
        this.East = East;
        this.South = South;
        this.West = West;
        this.Up = Up;
        this.Down = Down;

    }

    public int getID()
    {
        return ID;
    }

    public String getDescription()
    {
        return Description;
    }
    
    //Getter and setter soon.
    @Override
    public String toString()
    {
        return "Place [ID=" + ID + ", Description= " + Description + "]";
    }

}