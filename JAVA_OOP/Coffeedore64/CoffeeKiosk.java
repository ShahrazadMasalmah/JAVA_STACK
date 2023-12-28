import java.util.ArrayList;

public class CoffeeKiosk {
    private ArrayList<Item> menu;
    private ArrayList<Order> orders;

    public CoffeeKiosk() {
        this.menu = new ArrayList<Item>();
        this.orders = new ArrayList<Order>();
    }

    public void addMenuItem(String name, double price){
        Item newItem = new Item(name, price);
        this.menu.add(newItem);
        newItem.setItemIndex(menu.size() - 1);
    }

    public void displayMenu(){
        for(Item item : menu){
            System.out.println(item.getItemIndex() + " " + item.getItemName() + " -- $" + item.getItemPrice());
        }
    }

    public void newOrder() {
        
    	// Shows the user a message prompt and then sets their input to a variable, name
        System.out.println("Please enter customer name for new order:");
        String name = System.console().readLine();
    
    	// Your code:
        // Create a new order with the given input string
        Order newOrder = new Order(name);
        this.orders.add(newOrder);
        // Show the user the menu, so they can choose items to add.
        displayMenu();
    	// Prompts the user to enter an item number
        System.out.println("Please enter a menu item index or q to quit:");
        String itemNumber = System.console().readLine();
        
        // Write a while loop to collect all user's order items
        while(!itemNumber.equals("q")) {
            // Get the item object from the menu, and add the item to the order
            newOrder.addItem(this.menu.get(Integer.parseInt(itemNumber)));
            // Ask them to enter a new item index or q again, and take their input
            System.out.println("Please enter a menu item index or q to quit:");
            itemNumber = System.console().readLine();
        }
        // After you have collected their order, print the order details 
        newOrder.display();

    }

    public void addMenuItemByInput(){
        System.out.println("Please enter Item name or q for exit:");
        String name = System.console().readLine();
        System.out.println("Please enter item price:");
        String itemPrice = System.console().readLine();
        addMenuItem(name, Double.parseDouble(itemPrice));
        while(!name.equals("q")){
            //System.out.println("Please enter -1 for exit:");
            System.out.println("Please enter Item name or q for exit:");
            name = System.console().readLine();
            System.out.println("Please enter item price:");
            itemPrice = System.console().readLine();
            addMenuItem(name, Double.parseDouble(itemPrice));
        }
    }

}
