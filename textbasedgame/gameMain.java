package textbasedgame;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class gameMain
{
    public static void main(String [] arguments)
    {
        List <Character> characters = readCharacterCSV("textbasedgame\\charactersData.csv");
        List <Place> places = readPlaceCSV("textbasedgame\\placesData.csv");
        List <Item> items = readItemCSV("textbasedgame\\itemsData.csv");

        for (Character c : characters)
        {
            System.out.println(c);
        }
        
        for (Place p : places)
        {
            System.out.println(p);
        }

        for (Item i : items)
        {
            System.out.println(i);
        }
        
    }

    public static List <Character> readCharacterCSV(String Filename)
    {
    List <Character> characters = new ArrayList<>();
    Path pathToSave = Paths.get(Filename);

    try (BufferedReader br = Files.newBufferedReader(pathToSave, StandardCharsets.US_ASCII))
    {
        int characterIterations = Integer.parseInt(br.readLine());
        int currentIterations = 0;


        String line = br.readLine();
        while (line != null && currentIterations != characterIterations)
        {
            String [] attributes = line.split("\\s*,\\s*");
            Character character = createCharacter(attributes);
            characters.add(character);
            line = br.readLine();
            currentIterations += 1;
        }
    } catch (IOException ioe) 
    {
        ioe.printStackTrace();
    } 
    return characters;

}

    private static Character createCharacter(String [] attribute)
    {
        int ID = Integer.parseInt(attribute[0]);
        int CurrentLocation = Integer.parseInt(attribute[1]);
        String Name = attribute[2];
        String Description = attribute[3];
        return new Character(ID, CurrentLocation, Name, Description);
    }




    public static List <Place> readPlaceCSV(String Filename)
    {
    List <Place> places = new ArrayList<>();
    Path pathToSave = Paths.get(Filename);
    try (BufferedReader br = Files.newBufferedReader(pathToSave, StandardCharsets.US_ASCII))
    {
        int placeIterations = Integer.parseInt(br.readLine());
        int currentIterations = 0;
        String line = br.readLine();
        while (line != null && currentIterations != placeIterations)
        {
            String [] attributes = line.split("\\s*,\\s*");
            Place place = createPlace(attributes);
            places.add(place);
            line = br.readLine();
            currentIterations += 1;
        }
    } catch (IOException ioe) 
    {
        ioe.printStackTrace();
    }
    return places;
}

    private static Place createPlace(String [] metadata)
    {
        int ID = Integer.parseInt(metadata[0]);
        String Description = metadata[1];
        int North = Integer.parseInt(metadata[2]);
        int East = Integer.parseInt(metadata[3]);
        int South = Integer.parseInt(metadata[4]);
        int West = Integer.parseInt(metadata[5]);
        int Up = Integer.parseInt(metadata[6]);
        int Down = Integer.parseInt(metadata[7]);

        return new Place(ID, Description, North, East, South, West, Up, Down);
    }

    
    public static List <Item> readItemCSV(String Filename)
    {
    List <Item> items = new ArrayList<>();
    Path pathToSave = Paths.get(Filename);
    try (BufferedReader br = Files.newBufferedReader(pathToSave, StandardCharsets.US_ASCII))
    {
        int itemIterations = Integer.parseInt(br.readLine());
        int currentIterations = 0;
        String line = br.readLine();
        while (line != null && currentIterations != itemIterations)
        {
            String [] attributes = line.split("\\s*,\\s*");
            Item item = createItem(attributes);
            items.add(item);
            line = br.readLine();
            currentIterations += 1;
        }
    } catch (IOException ioe) 
    {
        ioe.printStackTrace();
    }
    return items;
}

    private static Item createItem(String [] metadata)
    {
        int ID = Integer.parseInt(metadata[0]);
        String Description = metadata[1];
        String Status = metadata[2];
        int Location = Integer.parseInt(metadata[3]);
        String Name = metadata[4];
        String Commands = metadata[5];
        String Results = metadata[6];

        return new Item(ID, Description, Status, Location, Name, Commands, Results);
    }
}
