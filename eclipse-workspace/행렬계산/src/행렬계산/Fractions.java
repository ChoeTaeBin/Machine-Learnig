package 행렬계산;

/*
 * 분수를 나타내는 클래스이다.
 */
class  Fractions{
	private int mom; //분모
	private int son; //분자
	
	Fractions(){ //기본 값
		mom = 1;
		son = 0;
	}
	
	Fractions(int mom, int son) {
		this.mom = mom;
		this.son = son;
		makeSimple(); //기본적으로 기약분수로 만들어둠
	}
	
	public int getMom() {//분모를 반환
		return mom;
	}
	
	public int getSon() {//분자를 반환
		return son;
	}
	
	public void setMom(int mom) {
		this.mom = mom;
	}
	
	public void setSon(int son) {
		this.son = son;
	}
	
	public boolean equals(Object o){
		if(!(o instanceof Fractions)) {
			return false;
		}

		//x 자로 곱해서 같은지
		return (((Fractions)o).mom *son == ((Fractions)o).son*mom );	
	}

	public void makeSimple() {//약분한다.
		if(son == 0){//0의 기본 형은 0/1이다.
			mom = 1; 
			return;
		}

		if(son<0) { //분자가 0보다 큰 상황으로 통일 한다.
			son *= -1;
			mom *= -1;
		}

		for(int divisor=1; divisor<=son; divisor++) {
			if(son % divisor == 0 && mom % divisor == 0) {
				son /= divisor;
				mom /= divisor;
				divisor = 1;
			}
		}
		
		if(mom < 0) {//분자가 음수 인 형태로 맞추자
			son *= -1;
			mom *= -1;
		}
	}
	
	//단항 연산자
	void add(Fractions f) {
		Fractions result = add(this,f);
		mom = result.mom;
		son = result.son;
	}
	
	void subtract(Fractions f) {
		Fractions result = subtract(this,f);
		mom = result.mom;
		son = result.son;
	}
	
	void multiply(Fractions f) {
		Fractions result = multiply(this,f);
		mom = result.mom;
		son = result.son;
	}
	
	void divide(Fractions f) {
		Fractions result = divide(this,f);
		mom = result.mom;
		son = result.son;
	}
	
	//양항 연산자
	public static Fractions add(Fractions f1, Fractions f2) {
		return new Fractions(f1.mom*f2.mom, f1.son*f2.mom + f2.son*f1.mom);
		
	}
	
	public static Fractions subtract(Fractions f1, Fractions f2) {
		return add(f1,new Fractions(f2.mom, -f2.son));
	}
	
	public static Fractions multiply(Fractions f1, Fractions f2) {
		return new Fractions(f1.mom * f2.mom, f1.son * f2.son);
	}
	
	public static Fractions divide(Fractions f1, Fractions f2) {
		return new Fractions(f1.mom * f2.son, f1.son * f2.mom);
	}
	
	public String toString() {
		if(son == 0) {
			if(mom!=0) {
				return "0";
			}else {
				return "?"; //부정 형 0/0
			}	
		}else if(mom == 0){
			return "∞";
		}else {
			return son + "/" + mom;
		}
	}
	
}
