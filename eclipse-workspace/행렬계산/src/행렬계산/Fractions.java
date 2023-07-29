package ��İ��;

/*
 * �м��� ��Ÿ���� Ŭ�����̴�.
 */
class  Fractions{
	private int mom; //�и�
	private int son; //����
	
	Fractions(){ //�⺻ ��
		mom = 1;
		son = 0;
	}
	
	Fractions(int mom, int son) {
		this.mom = mom;
		this.son = son;
		makeSimple(); //�⺻������ ���м��� ������
	}
	
	public int getMom() {//�и� ��ȯ
		return mom;
	}
	
	public int getSon() {//���ڸ� ��ȯ
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

		//x �ڷ� ���ؼ� ������
		return (((Fractions)o).mom *son == ((Fractions)o).son*mom );	
	}

	public void makeSimple() {//����Ѵ�.
		if(son == 0){//0�� �⺻ ���� 0/1�̴�.
			mom = 1; 
			return;
		}

		if(son<0) { //���ڰ� 0���� ū ��Ȳ���� ���� �Ѵ�.
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
		
		if(mom < 0) {//���ڰ� ���� �� ���·� ������
			son *= -1;
			mom *= -1;
		}
	}
	
	//���� ������
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
	
	//���� ������
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
				return "?"; //���� �� 0/0
			}	
		}else if(mom == 0){
			return "��";
		}else {
			return son + "/" + mom;
		}
	}
	
}
