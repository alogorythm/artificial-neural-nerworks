package algorithm;

public class Sigmoid {
	double result;
	public Sigmoid(double input) {
		result=1.0 / (Math.exp(-input) + 1); 
	}
}
