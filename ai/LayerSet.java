package ai;

import java.util.ArrayList;

public class LayerSet {

	// 레이어들을 넣어둘 ArrayList
	ArrayList<Layer> layers = new ArrayList<>();

	// 레이어 노드들의 개수를 받는다.
	public LayerSet(int[] nodes) {
		for (int i = 1; i < nodes.length; i++) {
			// nodes[0]은 초기 입력값의 개수, 그 이후로 nodes[i-1]이 해당 레이어의 입력 값 개수,
			// nodes[i]가 해당 레이어의 노드 개수. 이 부분 이해 잘 하셔야합니다.
			Layer layer = new Layer(nodes[i - 1], nodes[i]);
			layers.add(layer);
		}
	}

	// 유전알고리즘할 때 쓸, 텅 빈 레이어셋 만드는 생성자
	public LayerSet() {
		// null
	}

	// 이것도 유전알고리즘에 사용할, 레이어셋 설정하는 함수.
	public void setLayers(ArrayList<Layer> layers) {
		this.layers = layers;
	}

	// 계산하는 함수. 중요합니다.
	public double[] calc(double[] input) {
		// 일단 배열을 입력값으로 받습니다. 그리고 그 배열을 2차 배열로 변환합니다. 행렬 연산을 위해서죠.
		double[][] output = new double[1][input.length];

		// 초기 입력값을 설정합니다.
		output[0] = input;
		// 초기 입력 값을 처음 레이어에 넣고, 그 출력값을 다시 두 번째 레이어에 넣고...를 반복합니다.
		for (int i = 0; i < layers.size(); i++) {
			output = layers.get(i).calc(output);
		}
		return output[0];
	}

	// 포함하고 있는 모든 레이어에 appendRandomize를 size크기로 합니다.
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
	// 이전과 같이 레이어셋을 복사하는 함수.
	public LayerSet copy() {
		LayerSet output = new LayerSet();
		for (Layer i : layers) {
			output.layers.add(i.copy());
		}
		return output;
	}
}
