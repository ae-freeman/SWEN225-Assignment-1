/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.0.5071.d9da8f6cd modeling language!*/


import java.util.List;

// line 125 "model.ump"
// line 194 "model.ump"
public class Room {

    //------------------------
    // MEMBER VARIABLES
    //------------------------


    //Room Attributes
    private List<Cell> doorCells;
    private String name;

    //Room Associations
    private List<Cell> cells;

    public Room(String name) {
        this.name = name;
    }

    public Room(String name, List<Cell> cells) {
        this.name = name;
        this.cells = cells;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}