import java.util.ArrayList;
    
// Here we're creating a new data type called Order
public class Order {
    
    // MEMBER VARIABLES
    private String name; // default value of null
    private boolean ready; // default value false
    private ArrayList<Item> items; // defaults to null
    
    // CONSTRUCTOR
    // No arguments, sets name to "Guest", initializes items as an empty list.
    public Order(){
        this.name = "Guest";
        items = new ArrayList<Item>();
    }
    
    // OVERLOADED CONSTRUCTOR
    // Takes a name as an argument, sets name to this custom name.
    // Initializes items as an empty list.
    public Order(String name){
        this.name = name;
        items = new ArrayList<Item>();
    }
    
    // ORDER METHODS
    
    	// Most of your code will go here, 
    	// so implement the getters and setters first!
    
    // GETTERS & SETTERS
    public String getOrderName(){
        return this.name;
    }

    public void setOrderName(String name){
        this.name = name;
    }

    public boolean getOrderIsReady(){
        return this.ready;
    }

    public void setOrderIsReady(boolean ready){
        this.ready = ready;
    }

    public ArrayList<Item> getOrderItems(){
        return this.items;
    }

    public void setOrderItems(ArrayList<Item> items){
        this.items = items;
    }

    public void addItem(Item item){
        this.items.add(item);
    }

    public String getStatusMessage(){
        if(this.ready){
            return "Your order is ready.";
        }
        else {
            return "Thank you for waiting. Your order will be ready soon.";
        }
    }
    
    public double getOrderTotal(){
        double total = 0.0;
        for(Item item : this.items){
            total += item.getItemPrice();
        }
        return total;
    }
    
    public void display(){
        System.out.println("Customer Name: " + this.getOrderName());
        for(Item item : this.items){
            System.out.println(item.getItemName() + " - $" + item.getItemPrice());
        }
        System.out.println("Total: $" + this.getOrderTotal());
    }
}

