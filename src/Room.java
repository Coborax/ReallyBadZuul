import java.util.HashMap;
import java.util.Map;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */
public class Room 
{
    private String description;
    HashMap<String, Room> exits = new HashMap<>();

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
    }

    /**
     * Define a exit of this room.
     * @param direction The direction of the exit.
     * @param room The room at the exit.
     */
    public void setExit(String direction, Room room)
    {
        exits.put(direction, room);
    }

    /***
     * Get an exit from the given string value
     * @param direction The value to get the exit
     * @return The room located at the exit
     */
    public Room getExit(String direction) {
        return exits.get(direction);
    }


    /***
     * Return a description of the room’s exits,
     * for example, "Exits: north west".
     * @return A description of the available exits.
     */
    public String getExitString() {
        String exitString = "Exits: ";
        for (Map.Entry<String, Room> exit : exits.entrySet()) {
            exitString += exit.getKey();
        }
        return exitString;
    }

    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }

    public String getLongDescription() {
        return "You are " + description + ".\n" + getExitString();
    }

}
