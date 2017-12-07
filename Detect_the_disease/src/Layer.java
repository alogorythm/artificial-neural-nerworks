

import Jama.Matrix;

public class Layer {

	int input;
	int node;
	Matrix weight = null;

	public Layer(int input, int node) {
		this.input = input;
		this.node = node;
		weight = new Matrix(initialize(new double[input][node]));
	}

	public double[][] initialize(double[][] input) {
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[i].length; j++) {
				input[i][j] = 0;
			}
		}
		return input;
	}
	
	public static double[][] appendRandom(double[][] input, double size) {
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[i].length; j++) {
				input[i][j] = input[i][j] + (Math.random() * 2 - 1) * size;
			}
		}
		return input;
	}
	
	public void appendRandom(double size) {
		weight = new Matrix(appendRandom(weight.getArray(), size));
	}
	public static double[][] append(double[][] input, double[][] size) {

		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[i].length; j++) {
				input[i][j] = input[i][j] + size[i][j];
			}
		}
		return input;
	}

	public void append(double[][] size) {
		weight = new Matrix(append(weight.getArray(), size));
	}

	public void append(Matrix m) {
		weight = m;
		int a = weight.getColumnDimension();
		int b = weight.getRowDimension();
		double[][] d = weight.getArray();
		double[][] D = new double[a][b];
		for (int i = 0; i < b; i++) {
			for (int j = 0; j < a; j++) {
				D[j][i] = d[i][j];
			}
		}
		weight = new Matrix(D);
	}

	public double sigmoid(double input) {
		return 1 / (1 + Math.exp(-input));
	}

	public double[][] sigmoid(double[][] input) {
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[i].length; j++) {
				input[i][j] = sigmoid(input[i][j]);
			}
		}
		return input;
	}

	public double[][] calc(double[][] input) {
		Matrix inputConv = new Matrix(input);
		inputConv = inputConv.times(weight);
		double[][] temp = inputConv.getArray();
		return sigmoid(temp);
	}

	public void setweight(Matrix m) {
		weight = m;
	}
}