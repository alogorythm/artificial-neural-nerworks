

import Jama.Matrix;

public class B_Layer {
	int inputCount;
	int outputCount;

	Matrix weight;
	double[] input;
	double[] output;

	double learningRate = 0.1;

	public B_Layer(int input, int output) {
		this.inputCount = input;
		this.outputCount = output;
		weight = new Matrix(initialize(new double[input][output]));

	}

	public double[][] initialize(double[][] input) {
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[i].length; j++) {
				input[i][j] = 0;
			}
		}
		return input;
	}

	public double[][] randomize1(double min, double max) {
		double input[][] = new double[outputCount][inputCount];

		for (int i = 0; i < outputCount; i++) {
			for (int j = 0; j < inputCount; j++) {
				input[i][j] = (max - min) * Math.random() + min;
			}
		}
		return input;
	}

	public void randomize(double min, double max) {
		weight = new Matrix(randomize1(min, max));

	}

	public double[] calc(double[] input) {
		this.input = input;
		double[] output = new double[this.outputCount];
		for (int i = 0; i < this.outputCount; i++) {
			for (int j = 0; j < this.inputCount; j++) {
				output[i] += input[j] * weight.get(i, j);
			}

		}
		this.output = calcS(output);
		return this.output;
	}

	public double[] backProp(double[] err) {
		double[] delta = new double[outputCount];
		for (int i = 0; i < delta.length; i++) {
			delta[i] = calcDeff(output[i]) * err[i];
		}

		double[] output = new double[inputCount];
		for (int i = 0; i < inputCount; i++) {
			for (int j = 0; j < outputCount; j++) {
				output[i] += delta[j] * weight.get(j, i);
			}
		}

		for (int i = 0; i < outputCount; i++) {
			for (int j = 0; j < inputCount; j++) {
				weight.set(i, j, weight.get(i, j) + learningRate * delta[i] * input[j]);
			}
		}
		return output;
	}

	public double[] calcS(double[] input) {
		for (int i = 0; i < input.length; i++) {
			input[i] = calc(input[i]);
		}
		return input;
	}

	double calc(double input) {

		return 1.0 / (Math.exp(-input) + 1);
	}

	double calcDeff(double input) {
		return calc(input) * (1 - calc(input));
	}

	public Matrix getweight() {
		return weight;
	}
}
