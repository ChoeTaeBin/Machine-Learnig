package ��İ��;

public class Matrix{//���
	Fractions[][] matrix;
	int row; //�� ũ��
	int col; //�� ũ��

	Matrix(Fractions[][] matrix){
		this.matrix = matrix;
		row = matrix.length;
		col = matrix[0].length;
	}

	Matrix multiplyToLeft(Matrix counterPart){ //���ʿ� ���� ����� ��ȯ
		Fractions[][] cMatrix = counterPart.matrix;

		int cRow = cMatrix.length; //��� ��� �� ũ��
		int cCol = cMatrix[0].length; //��� ��� �� ũ��

		if(col != cRow) {
			System.out.println("���� ���°� ���� ����");
			return null;
		}

		Fractions[][] result = new Fractions[row][cCol];//����� ����

		for(int r=0; r<row; r++) {
			for(int c=0; c<cCol; c++) {
				//this�� r�຤�Ϳ� cMatrix�� c�� ���͸� �����Ͽ� ��� ����� r�� c���� ���� �Ѵ�.
				result[r][c] = new Fractions();
				for(int i=0; i<col; i++) {
					result[r][c].add(Fractions.multiply(matrix[r][i],cMatrix[i][c]));
				}
			}
		}

		return new Matrix(result);
	}

	Fractions getDeterminant() {
		if(row != col) {
			System.out.println("���� ��ĸ� ��Ľ��� ���� �� �ֽ��ϴ�.");
		}
		boolean[] isHidden = new boolean[col]; //������ ���� ǥ��
		
		return determinant(0,0,row, isHidden); //0��0�� ���� size�� row�� ����� ���� ���ؼ� ��ȯ�Ѵ�.
	}
	
	private Fractions determinant(int startRow, int startCol,int size, boolean[] isHidden) {//size*size ũ���� ����Ľ��� ����
		if(size == 1) {//���� ����
			return matrix[startRow][startCol];
		}
		
		Fractions result = new Fractions();//����� ����
		
		int curCol = startCol; //startCol�� �������� �����ָ� ��� �� �� ����
		for(int i=0; i<size; i++) {//size���� ����Ľ��� ���� ���ؾ���
			isHidden[curCol] = true; //���� �� ����
			
			int c = 0; //���� ���� ã�� ���� 
			while(isHidden[c]) {//�� ���� ���� ���� ���� col���� ���� �ؾ���
				c++;
			}
			
			if(i%2 == 0){//Ȧ����°�� ����
				result.add(Fractions.multiply(matrix[startRow][curCol], determinant(startRow+1,c,size-1,isHidden)));
				System.out.println(result);
			}else {//¦����°�� ��
				result.subtract(Fractions.multiply(matrix[startRow][curCol], determinant(startRow+1,c,size-1,isHidden)));
				System.out.println(result);
			}
			
			isHidden[curCol] = false; //���� ����
			
			curCol = nextCol(curCol,isHidden); //���� ������ ���� ���� ã��
		}
		return result;
	}
	
	private int nextCol(int curCol,boolean[] isHidden) {//�������� ���� ���� ���� ã�� �ִ� �Լ�
		int nextCol = curCol+1;
		
		while(nextCol < col) {
			if(!isHidden[nextCol]) {//���� ���� �ʾҴٸ�
				return nextCol;
			}
			nextCol++;
		}
		
		return -1; //���� �� ����
	}

	void print() {
		for(int r=0; r<row ; r++) {
			for(int c=0; c<col; c++) {
				System.out.print(matrix[r][c] + "\t");
			}
			System.out.println();
		}
	}
}
