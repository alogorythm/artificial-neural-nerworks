import Jama.Matrix;

public class Test {
	static int[] nodes = { 21, 8, 8 };
	static double[] x = new double[21];
	static double[] y = new double[8];
	static LayerSet layerSet = new LayerSet(nodes);

	public static void propagation(LayerSet layerSet, double[][] size) {
		
		layerSet.size(size);
		int i;
		
		for (i = 0; i < 21; i++) {
			x[i] = (int) (Math.random() * 5);
		}
		y = layerSet.calc(x);
		// 출력.
		for (i = 0; i < 21; i++) {
			System.out.print(x[i] + " ");
		}
		System.out.println(" ");
		for (i = 0; i < 8; i++) {
			System.out.print(y[i] + " ");
		}
		System.out.println(" ");
	}

	public static void propagation(LayerSet layerSet, Matrix[] M) {
		
		layerSet.size(M);
		int i;
		y = layerSet.calc(x);
		
		for (i = 0; i < 21; i++) {
			System.out.print(x[i] + " ");
		}
		System.out.println(" ");
		for (i = 0; i < 8; i++) {
			System.out.print(y[i] + " ");
		}
		System.out.println(" ");
	}

	public static void main(String[] args) {
		
		double[][] size = new double[21][8];
		
		for (int i = 0; i < 21; i++) {
			x[i] = (int) (Math.random() * 5);
		}
		for (int i = 0; i < 21; i++) {
			for (int j = 0; j < 8; j++) {
				size[i][j] = Math.random() * 5;
			}
		}
		
		propagation(layerSet, size);
		System.out.println("   ");
		
		double[][] x1 = new double[1][];
		x1[0] = x;
		double[][] y1 = new double[1][];
		B_LayerSet l = new B_LayerSet(nodes);
		y1[0] = x;
		Learner L = new Learner(l, x1, y1);
		L.scgLearn(10000);

		for (double[] data : x1) {
			for (double y : l.calc(data)) {
				System.out.println(y);
			}
		}
		
		Matrix[] M = L.getweight();
		System.out.println("   ");
		layerSet.setweight(M);
		
		for (int i = 0; i < 21; i++) {
			for (int j = 0; j < 8; j++) {
				size[i][j] = 0;
			}
		}
		
		propagation(layerSet, M);
	}
}
