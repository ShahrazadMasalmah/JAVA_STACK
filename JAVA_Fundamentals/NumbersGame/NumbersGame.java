import java.util.Random;
public class NumbersGame {
    public static void main(String[] args){
        System.out.println("Hello, human. I am thinking of a number between 0 and 10.");
        System.out.println("*********************************************************");
        System.out.println("Can you guess the number?");
        System.out.println("If you are not up to the task, you can always type 'q' to quit.");
        int answer = new Random().nextInt(0,10);
        //System.out.println(answer);
        int counter = 0;
        try {
             while(true){
            String guess = System.console().readLine();
            if(Integer.parseInt(guess) < 0 || Integer.parseInt(guess) > 10 ){
                System.out.println("Invalid Number");
            }
            else {
                if(guess.equals("q")){
                System.out.println("I knew you didn't have it in you.");
                System.out.println("Shutting down...");
                break;
                }
                if(Integer.parseInt(guess)==answer){
                    System.out.println("Lucky guess! But can you do it again?");
                    answer = new Random().nextInt(0,10);
                    //System.out.println(answer);
                    //break;
                }
                else{
                    counter++;
                    System.out.println("Swing and a miss! Keep trying...");
                    if(counter > 2){
                        System.out.println("You have failed to quess the number!");
                        break;
                    }
                }
            }
           
        }
       
        } catch (NumberFormatException e) {
            // TODO: handle exception
            System.out.println("Invalid input!");
        }
        
        System.out.println("Game over. Shutting down...");
    }
}

