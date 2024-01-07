import java.util.ArrayList;

public class CalculatorII {
	
	 private ArrayList<String> operators;
	 private ArrayList<Double> numbers;
	 private double result;
	 
	 public CalculatorII() {
		 this.operators = new ArrayList<String>();
		 this.numbers = new ArrayList<Double>();
	 }
	 
	 public double getResult() {
			return this.result;
		}

		public void setResult(double result) {
			this.result = result;
		}
	    
	 public void performOperation(double number){
	        numbers.add(number);
	    }

	 public void performOperation(String operator){
	        if (operator != "="){
	            operators.add(operator);
	        }
	        else {
	            Double start = numbers.get(numbers.size()-1);
	            for(int i = operators.size()-1; i >= 0; i--){
	                switch(operators.get(i)){
	                    case "+": start = start + numbers.get(i); break;
	                    case "-": start = start - numbers.get(i); break;
	                    case "*": start = start * numbers.get(i); break;
	                    case "/": start = start / numbers.get(i); break;
	                    default: System.out.println("Invalid operator."); break;
	                }
	            }
	            this.setResult(start);
	        }
	    }
	    public void getResults(){
	        System.out.println("The result is: " + this.getResult());
	    } 

}
