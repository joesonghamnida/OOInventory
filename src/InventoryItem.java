/**
 * Created by joe on 9/6/16.
 */
public class InventoryItem {
    protected String itemName;
    protected int itemQuant;
    String category;

    //constructor
    public InventoryItem(String itemName, int quantity,String category){
        this.itemName=itemName;
        this.itemQuant=quantity;
        this.category=category;
    }

    //getters
    public String getItemName(){
        return itemName;
    }

    static String[] categories={"Weapon","Food","Clothing","Magic","Earmuffs"};

    //methods
    public static void createItem() throws Exception{

        System.out.println("Available categories:");
        for(int i=0;i<categories.length;i++){
            System.out.println(categories[i]);
        }

        System.out.println("Please enter the desired item category");
        String category=InventoryTracker.scanner.nextLine();
        String itemCategory=category;

        System.out.println("Please enter the item name:");
        String itemName = InventoryTracker.scanner.nextLine();
        System.out.println("Please enter the item quantity");
        int itemQuantity = Integer.valueOf(InventoryTracker.scanner.nextLine());

        switch (category){
            case "Weapon":
                Weapon weapon =new Weapon(itemName,itemQuantity);
                InventoryTracker.inventoryList.add(weapon);
                break;
            case "Food":
                Food food =new Food(itemName,itemQuantity);
                InventoryTracker.inventoryList.add(food);
                break;
            case "Clothing":
                Clothing clothing=new Clothing(itemName,itemQuantity);
                InventoryTracker.inventoryList.add(clothing);
                break;
            case "Magic":
                Magic magic=new Magic(itemName,itemQuantity);
                InventoryTracker.inventoryList.add(magic);
                break;
            case "Earmuffs":
                EarMuffs earMuffs=new EarMuffs(itemName,itemQuantity);
                InventoryTracker.inventoryList.add(earMuffs);
            default:
                throw new Exception("That is not a valid category");
        }

    }

    public void printInventory(){
        int i=1;
        for(InventoryItem item:InventoryTracker.inventoryList){
            System.out.printf("%d. [%d] %s :%s\n",i,item.itemQuant,item.itemName,item.category);
            i++;
        }
    }

    public static void printOptions(){
        System.out.println("-----");
        System.out.println("Options");
        System.out.println("[1] Create new item");
        System.out.println("[2] Add item");
        System.out.println("[3] Enter item number to remove item");
        System.out.println("[4] Update item quantity");
    }

    public void addItem(){

        System.out.println("Please enter the item category");
        String itemCategory = InventoryTracker.scanner.nextLine();
        System.out.println("Please enter the item name:");
        String itemName = InventoryTracker.scanner.nextLine();
        System.out.println("Please enter the item quantity");
        int itemQuantity = Integer.valueOf(InventoryTracker.scanner.nextLine());

        InventoryItem item = new InventoryItem(itemName,itemQuantity,itemCategory);
        InventoryTracker.inventoryList.add(item);
    }

    public void deleteItem(){
        System.out.println("Please enter the item index number you wish to delete");
        int removeChoiceInt = Integer.parseInt(InventoryTracker.scanner.nextLine());

        InventoryTracker.inventoryList.remove(removeChoiceInt-1);

    }
    public void updateQuant(){
        System.out.println("Please enter the item index you wish to update:");
        int updateIndex = Integer.parseInt(InventoryTracker.scanner.nextLine());
        System.out.println("Please enter the updated quantity");
        int updateQuantity=Integer.parseInt(InventoryTracker.scanner.nextLine());

        InventoryItem item=InventoryTracker.inventoryList.get(updateIndex-1);
        item.itemQuant=updateQuantity;
    }
}
