
public class Calculator {
	private double operandOne;
	private double operandTwo;
	private String operation;
	
	//Getters & Setters
	public double getOperandOne() {
		return this.operandOne;
	}
	public void setOperandOne(double operandOne) {
		this.operandOne = operandOne;
	}
	public double getOperandTwo() {
		return this.operandTwo;
	}
	public void setOperandTwo(double operandTwo) {
		this.operandTwo = operandTwo;
	}
	public String getOperation() {
		return this.operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	public double performOperation() {
		double result = 0.0;
		if(this.getOperation() == "+") {
			result = this.getOperandOne() + this.getOperandTwo();
		}
		if(this.getOperation() == "-") {
			result = this.getOperandOne() - this.getOperandTwo();
		}
		return result;
	}
	
	public void getResults() {
		System.out.println("The result is: " + this.performOperation());
		}

}
