package ai;

import Jama.Matrix;

public class Learner {

	B_LayerSet layerSet;
	double[][] dataSet;
	double[][] answerSet;

	public Learner(B_LayerSet layerSet, double[][] dataSet, double[][] answerSet) {

		this.layerSet = layerSet;
		this.dataSet = dataSet;
		this.answerSet = answerSet;

		layerSet.randomize(-1, 1);
	}

	public double[] scgLearn(int count) {
		if (dataSet.length == answerSet.length) {
			double[] output = new double[dataSet.length * count];
			int k = 0;
			for (int c = 0; c < count; c++) {
				for (int i = 0; i < dataSet.length; i++) {
					double[] result = layerSet.calc(dataSet[i]);
					double[] err = getErr(result, answerSet[i]);
					output[k] = getSize(err);
					k++;
					layerSet.backProp(err);
				}

			}
			return output;
		} else {
			return null;
		}
	}

	public B_LayerSet getLayerSet() {
		return this.layerSet;
	}

	protected double[] getErr(double[] result, double[] answer) {
		double[] output = new double[result.length];
		for (int i = 0; i < 8; i++) {
			output[i] = answer[i] - result[i];
		}
		return output;
	}

	private double getSize(double[] d) {
		double output = 0;
		for (double e : d) {
			output += e * e;
		}
		return Math.sqrt(output);
	}

	public Matrix[] getweight() {
		return layerSet.getweight();
	}
}
