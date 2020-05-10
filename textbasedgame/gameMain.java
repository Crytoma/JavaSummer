package textbasedgame;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class gameMain
{
    public final int INVENTORY = 1001;
    public final int MINIMUM_ID_FOR_ITEM = 2001;
    public final int ID_DIFFERENCE_BETWEEN_OBJECT_IN_TWO_LOCATIONS = 10000;

    public static void main(String [] arguments)
    {
        List<Character> characters = readCharacterCSV("textbasedgame\\charactersData.csv");
        List <Place> places = readPlaceCSV("textbasedgame\\placesData.csv");
        List <Item> items = readItemCSV("textbasedgame\\itemsData.csv");
        playGame(characters, items, places);
        System.exit(0);
    }

    public static void say(String speech)
    {
        System.out.println();
        System.out.println(speech);
        System.out.println();

    }

    public static void playGame(List <Character> characters, List <Item> items, List <Place> places)
    {
        boolean stopGame = false;
        boolean moved = true;
        int characterLocation = 0;
        String instruction = "";
        String command = "";

        while (!(stopGame))
        {
            if (moved)
            {
                System.out.println(places.get(characters.get(0).getLocation() - 1).getDescription());
                displayGettableItemsInCurrentLocation(items, characterLocation);
                moved = false;
            } 

            instruction = getInstruction();
            command = extractCommand(instruction);
            instruction = extractInstruction(instruction);

            switch (command)
            {
                case "get":
                    //items = getItem(items, instruction, characters.get(0).getLocation());
                case "use":
                    //items = useItem(items, instruction, characters.get(0).getLocation(), places);
                case "go":

                case "read": 

                case "examine":

                case "open":
                
                case "close":

                case "move":

                case "say":

                case "playdice":

                default:
                    System.out.println("Sorry, the command " + command + " is retarded.");
            }

        }
    }

    public static void examineItem(List items, List characters, String itemToExamine, int currentLocation)
    {
        int count = 0;
        if (itemToExamine == "inventory")
        {
            displayInventory(items);
        }
    }

    public static void displayInventory(List items)
    {
        System.out.println();
        System.out.println("You are currently carrying the following items: ");
        
    }

    public static String getInstruction()
    {
        Scanner sc = new Scanner(System.in);
        String instruction = sc.next();
        sc.close();
        return instruction;
    }

    public static String extractCommand(String instruction)
    {
        String command = "";
        if (!(instruction.contains(" ")))//Avoids single worded input and no whitespace
        {
            return "Instructions must be two words.";
        }
        while (instruction.length() > 0 && (!(instruction.startsWith(" "))))
        {
            command += instruction.charAt(0);
        }
        return command;
    }

    public static String extractInstruction(String instruction)
    {
        String  newInstruction = "";

        if (!(instruction.contains(" ")))//Avoids single worded input and no whitespace
        {
            return "Instructions must be two words.";
        }
        while (instruction.length() > 0 && (!(instruction.startsWith(" "))))
        {
            newInstruction = instruction.substring(1, instruction.length());
        }
        while (instruction.length() > 0 && instruction.startsWith(" "));
        {
            newInstruction = instruction.substring(1, instruction.length());
        }
        return newInstruction;
    }


    public static void displayGettableItemsInCurrentLocation(List <Item> itemList,  int currentLocation)
    {
        boolean containsGettableItems = false;
        String listOfItems = "On the floor there is: ";
        for (Item item : itemList)
            {
                if (item.getLocation() == currentLocation && item.getStatus().contains("gettable"))
                {
                    if (containsGettableItems)
                        {
                            listOfItems += ", "; 
                        }
                    listOfItems += item.getName();
                    containsGettableItems = true;
                }
                if (containsGettableItems)
                    {
                        System.out.println(listOfItems + ".");
                    }
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
            String [] attributes = line.split(",\\s*(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
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
        int CurrentLocation = Integer.parseInt(attribute[3]);
        String Name = attribute[1];
        String Description = attribute[2];
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
            String [] attributes = line.split(",\\s*(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
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
            String [] attributes = line.split(",\\s*(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
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
