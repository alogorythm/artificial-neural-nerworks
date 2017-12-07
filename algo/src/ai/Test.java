package ai;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import Jama.Matrix;

public class Test {
	static int[] nodes = { 19, 8, 8 };
	static double[] x = new double[19];
	static double[] y = new double[8];
	static LayerSet layerSet = new LayerSet(nodes);
	static FileReader fr;
	static FileWriter fw;
	public static void propagation(LayerSet layerSet, double[][] size) {
		
		layerSet.size(size);
		int i;		

		for (i = 0; i < 19; i++) {
			//x[i] = (int) (Math.random() * 5);
			x[i]=UI.data[i];
		}
		y = layerSet.calc(x);
		// 출력.
		for (i = 0; i < 19; i++) {
			System.out.printf("%.2f ",x[i]);
		}
		System.out.println(" ");
		for (i = 0; i < 8; i++) {
			System.out.printf("%.2f ",y[i]);
		}
		System.out.println(" ");
	}

	public static void propagation(LayerSet layerSet, Matrix[] M) {
		
		layerSet.size(M);
		int i;
		y = layerSet.calc(x);
		
		for (i = 0; i < 19; i++) {
			System.out.printf("%.2f ",x[i]);
		}
		System.out.println(" ");
		for (i = 0; i < 8; i++) {
			System.out.printf("%.2f ",y[i]);
		}
		System.out.println(" ");
		
	}

	public static void showing() {
		
		double[][] size = new double[19][8];
		
		for (int i = 0; i < 19; i++) {
			x[i]=UI.data[i];
		}
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 8; j++) {
				size[i][j] = Math.random() * 5;
			}
		}
		
		propagation(layerSet, size);
		System.out.println("   ");
		
		double[][] x1 ={ { 3, 2, 3, 3, 3, 1, 3, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 2, 1, 3, 1, 3, 1, 2, 3, 1, 1, 1, 1, 1, 3, 1, 1, 1, 2 },
				{ 1, 1, 3, 3, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1 },
				{ 1, 1, 1, 1, 3, 2, 1, 1, 3, 2, 2, 3, 1, 1, 1, 2, 2, 1, 1 },
				{ 1, 1, 1, 3, 1, 3, 1, 1, 3, 1, 1, 2, 1, 1, 3, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 3, 3, 1, 1, 2, 1, 1, 3, 2, 2, 3, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 3, 1, 1, 1, 1, 1, 3, 1, 1 },
				{ 1, 1, 1, 1, 1, 2, 1, 1, 1, 3, 2, 1, 1, 1, 1, 2, 2, 1, 1 } };
		double[][] y1 = { { 1, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 1, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1 } };
		B_LayerSet l = new B_LayerSet(nodes);
		Learner L = new Learner(l, x1, y1);
		L.scgLearn(100000);

		for (double[] data : x1) {
			for (double y : l.calc(data)) {
				System.out.println(y);
			}
		}
		
		Matrix[] M = L.getweight();
		for (int i = 0; i < M.length; i++) {
			for (int j = 0; j < M[i].getRowDimension(); j++) {
				for(int k=0;k<M[i].getColumnDimension();k++) {
					System.out.print(M[i].get(j, k)+" ");
				}
				System.out.println("");
			}
			System.out.println("");
		}
		try {
			filewrite(M);
		} catch (IOException e) {
			// TODO 자동 생성된 catch 블록
			e.printStackTrace();
		}
		try {
			M=fileread();
		} catch (IOException e) {
			// TODO 자동 생성된 catch 블록
			e.printStackTrace();
		}
		for (int i = 0; i < M.length; i++) {
			for (int j = 0; j < M[i].getRowDimension(); j++) {
				for(int k=0;k<M[i].getColumnDimension();k++) {
					System.out.print(M[i].get(j, k)+" ");
				}
				System.out.println("");
			}
			System.out.println("");
		}
		System.out.println("   ");
		layerSet.setweight(M);
		
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 8; j++) {
				size[i][j] = 0;
			}
		}
		
		propagation(layerSet, M);
		for(int  m=0;m<8;m++)
		diagnosis.testresult[m]=y[m];
		diagnosis Diagnosis = new diagnosis();
	}
	public static Matrix[] reverse(Matrix[] m) {
		Matrix[] M=new Matrix[m.length];
		for(int i=0;i<m.length;i++) {
			double[][] d0=m[i].getArray();
			double[][] d1=new double[d0[0].length][d0.length];
			for(int j=0;j<d0[0].length;j++) {
				for(int k=0;k<d0.length;k++) {
					d1[j][k]=d0[k][j];
				}
			}
			Matrix t= new Matrix(d1);
			M[i]=t;
		}
		return M;
	}
	public static Matrix[] fileread() throws IOException {
		double[][] m0 = new double[8][19];
		double[][] m1 = new double[8][8];
		try {
			fr = new FileReader("matrix.txt");
			String s = "";

			int c1 = 0, c2 = 0, c3 = 0;
			while (true) {
				int i;
				i = fr.read();
			
				if (i == 32) {
					double d = Double.parseDouble(s);
					m0[c2][c1] = d;
					c1++;
					if (c1 == 19)
						c1 = 0;
					s = "";
					continue;
				}
				if (i == 13) {
					fr.read();
					if (c3 == 8) {
						break;
					}
					c3++;
					c2++;
					if (c2 == 8)
						c2 = 0;
					s = "";
					continue;
				}
				s = s + String.valueOf((char) i);
			}
			while (true) {
				int i;
				i = fr.read();
				if (i == -1)
					break;
				if (i == 32) {
					double d = Double.parseDouble(s);
					m1[c1][c2] = d;
					c1++;
					if (c1 == 8)
						c1 = 0;
					s = "";
					continue;
				}
				if (i == 13) {
					fr.read();
					c2++;
					if (c2 == 8)
						c2 = 0;
					s = "";
					continue;
				}
				s = s + String.valueOf((char) i);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fr.close();
		}
		Matrix[] m = new Matrix[2];
		Matrix t0 = new Matrix(m0);
		m[0] = t0;
		Matrix t1 = new Matrix(m1);
		m[1] = t1;
		return m;
	}

	public static void filewrite(Matrix[] M) throws IOException {
		try {
			fw = new FileWriter("matrix.txt");
			for (int i = 0; i < M.length; i++) {
				double[][] W = M[i].getArray();
				for (int j = 0; j < W.length; j++) {
					for (int k = 0; k < W[j].length; k++) {
						fw.write(String.valueOf(W[j][k]) + " ");
					}
					fw.write("\r\n");
				}
				fw.write("\r\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fw.close();
		}
		System.out.println("   ");

	}

}
