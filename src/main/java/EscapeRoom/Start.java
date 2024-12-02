package EscapeRoom;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Start {

    private Inventory inventory;
    public static void start(){
        int option, option2, id, id2, difficultyLevel, time;
        String name, theme, material;
        double price;
        Clue clue = null;
        Object object = null;
        Scanner read = new Scanner(System.in);
        read.useDelimiter("\r?\n");
        Inventory inventory = new Inventory();
        do{
            System.out.println("\n\nChoose one of the following options: ");
            System.out.println("    1.-Create new room.");
            System.out.println("    2.-Add clue to room.");
            System.out.println("    3.-Add object to room.");
            System.out.println("    4.-Display inventory.");
            System.out.println("    5.-Remove element from inventory.");
            System.out.println("    6.-Exit");
            option = read.nextInt();
            switch (option){
                case 1:
                    System.out.println("What is the room's id?");
                    id = read.nextInt();
                    System.out.println("What is the room's name?");
                    name = read.next();
                    System.out.println("What is the room's difficulty level?");
                    difficultyLevel = read.nextInt();
                    try{
                        inventory.CreateRoom(id,name,difficultyLevel);
                    }catch(DuplicatedRoomException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("    1.-Choose existing clue.");
                    System.out.println("    2.-Create new clue.");
                    option2 = read.nextInt();
                    if(option2==1){
                        System.out.println("Select an Id.");
                        inventory.getCluesInfo();
                        id2 = read.nextInt();
                        try {
                            clue = inventory.FindClue(id2);
                        } catch (ClueNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    else if(option2==2){
                        System.out.println("Create an id:");
                        id2 = read.nextInt();
                        System.out.println("Choose a price:");
                        price = read.nextDouble();
                        System.out.println("Create a name:");
                        name = read.next();
                        System.out.println("Determine the duration:");
                        time = read.nextInt();
                        System.out.println("Choose a theme:");
                        theme = read.next();
                        try {
                            clue = inventory.CreateClue(id2,price,name,time,Theme.PIRATES);
                        } catch (DuplicatedClueException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    System.out.println("What room id do you want to add the clue to?");
                    id = read.nextInt();
                    try{
                        inventory.addCluetoRoom(clue,id);
                    }catch(RoomNotFoundException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("    1.-Choose existing object.");
                    System.out.println("    2.-Create new object.");
                    option2 = read.nextInt();
                    if(option2==1){
                        System.out.println("Select an Id.");
                        inventory.getObjectsInfo();
                        id2 = read.nextInt();
                        try {
                            object = inventory.FindObject(id2);
                        } catch (ObjectNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    else if(option2==2){
                        System.out.println("Create an id:");
                        id2 = read.nextInt();
                        System.out.println("Choose a price:");
                        price = read.nextDouble();
                        System.out.println("Create a description:");
                        name = read.next();
                        System.out.println("Choose a material:");
                        material = read.next();
                        try {
                            object = inventory.CreateObject(id2,price,name,Material.PLASTIC);
                        } catch (DuplicatedObjectException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    System.out.println("What room id do you want to add the object to?");
                    id = read.nextInt();
                    try{
                        inventory.addObjecttoRoom(object,id);
                    }catch(RoomNotFoundException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("This is the inventory of the Escape Room");
                    inventory.getRoomsInfo();
                    inventory.getObjectsInfo();
                    inventory.getCluesInfo();
                    break;
                case 5:
                    System.out.println("Choose the type of element you want to delete:");
                    System.out.println("    1.-Object.");
                    System.out.println("    2.-Clue.");
                    option2 = read.nextInt();
                    if(option2==1){
                        System.out.println("Select an Id.");
                        inventory.getObjectsInfo();
                        id2 = read.nextInt();
                        try {
                            inventory.removeObject(inventory.FindObject(id2));
                        } catch (ObjectNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    else if(option2==2){
                        System.out.println("Select an Id.");
                        inventory.getCluesInfo();
                        id2 = read.nextInt();
                        try {
                            clue = inventory.FindClue(id2);
                        } catch (ClueNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
            }
        }while(option!=8);
        System.out.println("Until next time!");
        read.close();
    }
}
