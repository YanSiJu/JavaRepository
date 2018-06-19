
public class square extends rect_angle{
	private int m_sqLenth;
	
	public square(){}	
	public square(int L){
		this.m_sqLenth = L;
	}	
	public square(int X, int Y, int L){
		this.m_x = X;
		this.m_y = Y;
		this.m_sqLenth = L;
	}	
	public square(square sq){
		this(sq.m_x, sq.m_y, sq.m_sqLenth);
	}
	// 请完成计算周长的方法
	public int calLength(){
		return 4*this.m_sqLenth;
	}
	// 请完成计算面积的方法
	public int calArea(){
		return m_sqLenth*m_sqLenth;
	}
}
