import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    // SENSEI BONUS
    public String guestGreeting(String name) {
        // YOUR CODE HERE
        SimpleDateFormat SDFormat = new SimpleDateFormat("hh:mm aa MM/dd/yyyy");
        // Initializing the calendar Object
        Calendar cal = Calendar.getInstance();
        // Using format() method for conversion
        String current_date = SDFormat.format(cal.getTime());
        return String.format("Hello, %s. Lovely to see you at %s", name, current_date);
    }
    
    public String dateAnnouncement() {
        // YOUR CODE HERE
        Date date = new Date();
        return String.format("It is currently %s", date);
    }
    
    public String respondBeforeAlexis(String conversation) {
        // YOUR CODE HERE
        if(conversation.indexOf("Alexis") > -1){
            return "Right away, sir. She certainly isn't sophisticated enough for that.";
        }
        else if(conversation.indexOf("Alfred") > -1){
            return "At your service. As you wish, naturally.";
        } 
        else {
            return "Right. And with that I shall retire.";
        }
        
    }
    
	// NINJA BONUS
	// See the specs to overload the guestGreeting method
     public String guestGreeting(String name, String dayPeriod) {
        // YOUR CODE HERE
        return String.format("Good %s, %s. Lovely to see you.",dayPeriod, name);
    }
    // Write your own AlfredQuote method using any of the String methods you have learned!
    public String connectTogether(String firstString, String secondString) {
        return firstString.concat(secondString);
    }

}

