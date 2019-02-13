package test;

public class LeastSquareMethod {

	private double[] x;
	private double[] y;
	private int n = 5;
	private double[] coefficient;

	public LeastSquareMethod(int[] x) {
		this.x = new double[x.length];
		this.y = new double[x.length];
		for(int i = 0; i < x.length; i++) {
			this.y[i] = x[i]; 
			this.x[i] = i;
		}
		compute();
	}

	public double gety(double x) {
		double sum = 0;
		for (int i = 0; i < coefficient.length; i++) {
			sum += Math.pow(x, i) * coefficient[i];
		}
		return sum;
	}

	private void compute() {
		double[] s = new double[(n - 1) * 2 + 1];
		for (int i = 0; i < s.length; i++) {
			for (int j = 0; j < x.length; j++) {
				s[i] += Math.pow(x[j], i);
			}
		}
		double[] b = new double[n];
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < x.length; j++) {
				b[i] += Math.pow(x[j], i) * y[j];
			}
		}
		double[][] a = new double[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = s[i + j];
			}
		}
		
		double[][] aa = new double[a.length][a[0].length+1];
		for(int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				aa[i][j] = a[i][j];
				
			}
		}
		for (int i = 0; i < b.length; i++) {
			aa[i][aa.length] = b[i];
			
		}
		coefficient = caculate(aa);
		coefficient = calcLinearEquation(a, b);
	}

	private double[] calcLinearEquation(double[][] a, double[] b) {
//		double[] result = new double[b.length];
//		for(int i = 0; i < b.length; i++) {
//			for(int j = 0; j < a[i])
//		}
//		
//		return result;
		if (a == null || b == null || a.length == 0 || a.length != b.length) {
			return null;
		}
		for (double[] x : a) {
			if (x == null || x.length != a.length)
				return null;
		}

		int len = a.length - 1;
		double[] result = new double[a.length];

		if (len == 0) {
			result[0] = b[0] / a[0][0];
			return result;
		}

		double[][] aa = new double[len][len];
		double[] bb = new double[len];
		int posx = -1, posy = -1;
		for (int i = 0; i <= len; i++) {
			for (int j = 0; j <= len; j++)
				if (a[i][j] != 0.0d) {
					posy = j;
					break;
				}
			if (posy != -1) {
				posx = i;
				break;
			}
		}
		if (posx == -1) {
			return null;
		}

		int count = 0;
		for (int i = 0; i <= len; i++) {
			if (i == posx) {
				continue;
			}
			bb[count] = b[i] * a[posx][posy] - b[posx] * a[i][posy];
			int count2 = 0;
			for (int j = 0; j <= len; j++) {
				if (j == posy) {
					continue;
				}
				aa[count][count2] = a[i][j] * a[posx][posy] - a[posx][j]
						* a[i][posy];
				count2++;
			}
			count++;
		}

		// Calculate sub linear equation
		double[] result2 = calcLinearEquation(aa, bb);

		// After sub linear calculation, calculate the current coefficient
		double sum = b[posx];
		count = 0;
		for (int i = 0; i <= len; i++) {
			if (i == posy) {
				continue;
			}
			sum -= a[posx][i] * result2[count];
			result[i] = result2[count];
			count++;
		}
		result[posy] = sum / a[posx][posy];
		return result;
	}
	
	public double[] caculate(double[][] a) // 高斯消元求未知数X   
	{          
		int _rows = a.length;         
		int _cols = a[0].length;         
		int L = _rows - 1;         
		int i, j, l, n, m, k = 0;          
		double[] temp1 = new double[_rows];          /* 第一个do-while是将增广矩阵消成上三角形式 */         
		do {              
			n = 0;              
			for (l = k; l < L; l++)                  
				temp1[n++] = a[l + 1][k] / a[k][k];             
			for (m = 0, i = k + 1; i < _rows; i++, m++) {                 
				for (j = k; j < _cols; j++)                      
					a[i][j] -= temp1[m] * a[k][j];             
				}             
			k++;         
			}          
		while (k < _rows);           /*第二个do-while是将矩阵消成对角形式，并且重新给k赋值,最后只剩下对角线和最后一列的数，其它都为0*/         
		k = L - 1;         
		do {              
			n = 0;              
			for (l = k; l >= 0; l--)                  
				temp1[n++] = a[k - l][k + 1] / a[k + 1][k + 1];             
			for (m = 0, i = k; i >= 0; i--, m++) {                 
				for (j = k; j < _cols; j++)                      
					a[k - i][j] -= temp1[m] * a[k + 1][j];             
				}             
			k--;         
			}          
		while (k >= 0); 
	 
    /* 下一个for是解方程组 */          
		double[] newresult = new double[_rows];         
		for (i = 0; i < _rows; i++) {              
			newresult[i] = a[i][_rows] / a[i][i];   
			System.out.println(newresult[i]);
			}          
		return newresult;     
		}

	
	public static void main(String[] args) {
		LeastSquareMethod eastSquareMethod = new LeastSquareMethod(
				new int[] { 0,0,0,1,2,0,0,0});
		System.out.println(eastSquareMethod.gety(3));
	}
}
