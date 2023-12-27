import java.util.ArrayList;

public class CafeUtil {
    public int getStreakGoal(int numWeek) {
        int sum = 0;
        for(int i=1; i <= numWeek; i++){
            sum += i;
        }
        return sum;
    }

    public double getOrderTotal(double[] prices) {
        double total = 0.0;
        for(double price : prices){
            total += price;
        }
        return total;
    }

    public void displayMenu(ArrayList<String> menuItems) {
        for(int i=0; i < menuItems.size(); i++) {
            System.out.println(i + " " + menuItems.get(i));
        }
    }

    public void addCustomer(ArrayList<String> customers) {
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        System.out.println(String.format("Hello, %s here!", userName));  
        System.out.println(String.format("There are %d people in front of you.", customers.size()));
        customers.add(userName); 
        System.out.println(customers);
    }

    public void printPriceChart(String product, double price, int maxQuantity) {
        double cost;
        double discount = 0.0;
        System.out.println(product);
        for(int i=1; i <= maxQuantity; i++){
            cost = (price * i) - discount;
            discount += 0.50;
            System.out.println(String.format("%d - $%.2f", i, cost));
        }
    }

    public boolean displayMenu(ArrayList<String> menuItems, ArrayList<Double> prices) {
        if(menuItems.size() == prices.size()){
            for(int i=0; i < menuItems.size(); i++){
                System.out.println(String.format("%d %s -- $%.2f", i, menuItems.get(i),prices.get(i)));
            }
            return true;
        }
        else{
            System.out.println("The two arrays do not have the same size.");
            return false;
        }
    }

}