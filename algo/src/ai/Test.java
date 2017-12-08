package algo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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
	public static double[][] dataread(String S) throws IOException {
		double[][] D = null;
		FileReader fr1 = null;
		FileReader fr2 = null;
		try {
			fr1 = new FileReader(S);
			String s = "";
			int c1=0,c2=0,c=0;
			while (true) {
				int i;
				i = fr1.read();
				if (i == 32) {
					c1++;
					s = "";
					continue;
				}
				if (i == 13) {
					c2++;
					c=c1;
					c1=0;
					continue;
				}
				if(i==-1)
					break;
				
			}
			D=new double[c2][c];
			fr1.close();
			fr2 =new FileReader(S);
			s = "";
			c1=0;
			c2=0;
			
			while (true) {
				int i;
				
				i = fr2.read();
				if (i == 32) {
					double d = Double.parseDouble(s);
					D[c2][c1]=d;
					s = "";
					c1++;
					continue;
				}
				if (i == 13) {
					fr2.read();
					s = "";
					c1=0;
					c2++;
					if(c2==D.length)
						break;
					continue;
				}
				s = s + String.valueOf((char) i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fr2.close();
		}
		return D;
	}

	public static void datawrite(String S,double[][] d) throws IOException {

		FileWriter fw = null;
		try {
			fw = new FileWriter(S);
			for (int i = 0; i < d.length; i++) {
				for (int j = 0; j < d[i].length; j++) {
						fw.write( d[i][j]+ " ");
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
	static double[][] AtoD(ArrayList<double[]> A){
		double[][] d = new double[A.size()][A.get(0).length];
		for(int i=0;i<A.size();i++) {
			d[i]=A.get(i);
		}
		return d;
	}
	public static void showing() throws IOException {
		Matrix[] M = null;
		double[][] size = new double[19][8];
		Scanner scan = new Scanner(System.in);
		String command;	
		for (int i = 0; i < 19; i++) {
			x[i]=UI.data[i];
		}
		/*for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 8; j++) {
				size[i][j] = Math.random() * 1;
			}
		}
		
		propagation(layerSet, size);
		*/
		M=fileread();
		propagation(layerSet, M);
		System.out.println("   ");
		System.out.println("학습?");
		command=scan.next();
		if(command.equals("yes")) {
			double[][] x1 = dataread("inputdata.txt");
			double[][] y1 = dataread("outputdata.txt");
			B_LayerSet l = new B_LayerSet(nodes);
			Learner L = new Learner(l, x1, y1);
			L.scgLearn(100000);

			for (double[] data : x1) {
				for (double y : l.calc(data)) {
					System.out.println(y);
				}
			}
		
			M = L.getweight();
		}
		System.out.println("   ");
		System.out.println("적용?");
		command=scan.next();
		if(command.equals("yes")) {
			layerSet.setweight(M);
		
			propagation(layerSet, M);
		}
		System.out.println("저장?");
		command=scan.next();
		if(command.equals("yes")) {
			filewrite(M);

		}
		for(int  m=0;m<8;m++)
		diagnosis.testresult[m]=y[m];
		diagnosis Diagnosis = new diagnosis();
	}
}
