package ai;

import Jama.Matrix;

public class B_LayerSet {

	B_Layer[] layerSet;
	int size;

	public B_LayerSet(int[] nodeCount) {
		this.size = nodeCount.length - 1;
		layerSet = new B_Layer[size];
		layerSet[0] = new B_Layer(nodeCount[0], nodeCount[1]);
		for (int i = 1; i < size; i++) {
			layerSet[i] = new B_Layer(nodeCount[i], nodeCount[i + 1]);
		}
	}

	public double[] calc(double[] input) {
		double[] datas;
		datas = layerSet[0].calc(input);
		for (int i = 1; i < layerSet.length; i++) {
			datas = layerSet[i].calc(datas);
		}
		return datas;
	}

	public double[] backProp(double[] err) {
		double[] error = layerSet[size - 1].backProp(err);
		for (int i = size - 2; i >= 0; i--) {
			error = layerSet[i].backProp(error);
		}
		return error;
	}

	// Set learning rate
	public void setLearningRate(double learningRate) {
		for (B_Layer i : layerSet) {
			i.learningRate = learningRate;
		}
	}

	public void randomize(double min, double max) {
		for (B_Layer layer : layerSet) {
			layer.randomize(min, max);
		}
	}

	public Matrix[] getweight() {
		Matrix[] M = new Matrix[size];
		for (int i = 0; i < size; i++) {
			M[i] = layerSet[i].getweight();
		}
		return M;
	}
}
