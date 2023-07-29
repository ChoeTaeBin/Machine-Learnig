package 행렬계산;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TestDriver {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Matrix matrix;//행렬


		StringTokenizer st = new StringTokenizer(br.readLine());
		//임시 저장소
		Fractions[][] matrixBuff = new Fractions[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];
		//입력을 받음
		for(int r=0; r<matrixBuff.length; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<matrixBuff[0].length; c++) {
				matrixBuff[r][c] = new Fractions(1,Integer.parseInt(st.nextToken()));
			}
		}
		matrix = new Matrix(matrixBuff); //행렬 객체를 만들어서 저장
		matrix.print();

		System.out.println(matrix.getDeterminant());

	}
}
