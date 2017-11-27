package ai;

import Jama.Matrix;

public class Layer {

	int input;
	int node;

	Matrix weight;
	Matrix bias;

	public Layer(int input, int node) {
		// input은 입력 값의 개수, node는 이 레이어의 노드 개수
		this.input = input;
		this.node = node;
		// 가중치 행렬을 만든다.
		weight = new Matrix(initialize(new double[input][node]));
		// bias 행렬을 만든다.
		bias = new Matrix(initialize(new double[1][input]));
	}

	// 이건 그냥 무시해도 되는 함수. 배열을 전부 0으로 채운다.
	public double[][] initialize(double[][] input) {
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[i].length; j++) {
				input[i][j] = 0;
			}
		}
		return input;
	}

	// 어떤 배열에 size 크기 이내로 랜덤한 숫자를 더하거나 빼 주는 함수. Genetic Algorithm에 사용하는 것.
	public static double[][] appendRandom(double[][] input, double size) {
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[i].length; j++) {
				input[i][j] = input[i][j] + (Math.random() * 2 - 1) * size;
			}
		}
		return input;
	}

	// 위의 appendRandom을 weight(가중치)와 bias에 적용해주는 함수
	public void appendRandom(double size) {
		weight = new Matrix(appendRandom(weight.getArray(), size));
		bias = new Matrix(appendRandom(bias.getArray(), size));
	}
	// 어떤 배열에 size 크기 이내로 랜덤한 숫자를 더하거나 빼 주는 함수. Genetic Algorithm에 사용하는 것.
		public static double[][] append(double[][] input, double[][] size) {
			for (int i = 0; i < input.length; i++) {
				for (int j = 0; j < input[i].length; j++) {
					input[i][j] = input[i][j] + size[i][j];
				}
			}
			return input;
		}

		// 위의 appendRandom을 weight(가중치)와 bias에 적용해주는 함수
		public void append(double[][] size) {
			weight = new Matrix(append(weight.getArray(), size));
		}
	// 시그모이드 함수.
	public double sigmoid(double input) {
		return 1 / (1 + Math.exp(-input));
	}

	// 배열의 각 원소에 시그모이드를 적용해주는 함수.
	public double[][] sigmoid(double[][] input) {
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[i].length; j++) {
				input[i][j] = sigmoid(input[i][j]);
			}
		}
		return input;
	}

	// 입력 배열을 받아서 행렬 연산을 하는 함수.
	public double[][] calc(double[][] input) {
		Matrix inputConv = new Matrix(input);

		// 입력값에 bias를 더해서
		inputConv = inputConv.plus(bias);
		// 가중치와 행렬 곱을 해 준다.
		inputConv = inputConv.times(weight);
		// 계산 결과의 값을 배열로 얻어서
		double[][] temp = inputConv.getArray();
		// sigmoid를 통과시켜 반환한다.
		return sigmoid(temp);
	}

	// Genetic Algorithm에 사용할, 이 레이어를 복사하는 함수.
	public Layer copy() {
		Layer output = new Layer(input, node);
		output.bias = this.bias.copy();
		output.weight = this.weight.copy();
		return output;
	}

	// 이 아래로는 단순히 배열 출력하는 함수. 1도 안 중요함.
	public static void print(double[][] input) {
		for (double[] i : input) {
			for (double j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}

	public static void print(double[] input) {
		for (double j : input) {
			System.out.print(j + " ");
		}
		System.out.println();
	}
}