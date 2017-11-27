package ai;

public class Test {
	public static void main(String[] args) {
		// 노드 개수 정의
		int[] nodes = { 21, 8, 8 };
		double[][] size = null ;
		// 레이어셋 만들기
		LayerSet layerSet = new LayerSet(nodes);

		// for (int k = 0; k < 10; k++) {
		// 레이어셋 섞기
		layerSet.size(size);
		// 정의역과 치역 정의
		double[] x = new double[21];
		double[] y = new double[8];
		int i;

		// 정의역과 치역에 값 넣기
		for (i = 0; i < 21; i++) {
			x[i] =(int)( Math.random()*5);
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
}
