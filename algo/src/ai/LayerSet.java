package ai;

import Jama.Matrix;

public class LayerSet {

	Layer[] layers;

	public LayerSet(int[] nodes) {
		layers = new Layer[nodes.length - 1];
		for (int i = 1; i < nodes.length; i++) {
			Layer layer = new Layer(nodes[i - 1], nodes[i]);
			layers[i - 1] = layer;
		}
	}

	public LayerSet() {

	}

	public void setLayers(Layer[] layers) {
		this.layers = layers;
	}

	public double[] calc(double[] input) {
		double[][] output = new double[1][input.length];
		output[0] = input;
		for (int i = 0; i < layers.length; i++) {
			output = layers[i].calc(output);
		}
		return output[0];
	}

	public LayerSet randomize(double size) {
		for (Layer i : layers) {
			i.appendRandom(size);
		}
		return this;
	}

	public LayerSet size(double[][] size) {
		for (Layer i : layers) {
			i.append(size);
		}
		return this;
	}

	public LayerSet size(Matrix[] m) {
		int j = 0;
		for (Layer i : layers) {
			i.append(m[j]);
			j++;
		}
		return this;
	}

	public void setweight(Matrix[] m) {
		for (int i = 0; i < layers.length; i++) {
			layers[i].setweight(m[i]);
		}
	}
}
