import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by joe on 9/6/16.
 */
public class InventoryTracker{

    static ArrayList<InventoryItem> inventoryList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        InventoryItem item =new InventoryItem("",0,"");

        //need static createItem method here

        //Weapon sword=new Weapon("Sword",1,"Weapon");
        //Food bread=new Food();
        //Clothing shirt=new Clothing();


        while (true) {
            item.printInventory();
            item.printOptions();
            String choice= scanner.nextLine();

            switch (choice){
                case"1":
                    item.createItem();
                    break;
                case"2":
                    item.addItem();
                    break;
                case"3":
                    item.deleteItem();
                    break;
                case"4":
                    item.updateQuant();
                    break;
                default:
                    break;
            }
        }
    }
}
