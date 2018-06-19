
public class rect_angle {
	protected int m_x, m_y;
	private int m_width, m_height;

	public rect_angle() {
	}

	public rect_angle(int w, int h) {
		m_width = w;
		m_height = h;
	}

	public rect_angle(int X, int Y, int w, int h) {
		this(w, h);
		m_x = X;
		m_y = Y;
	}

	public rect_angle(rect_angle r) {
		this(r.m_width, r.m_height);
		m_x = r.m_x;
		m_y = r.m_y;
	}

	// 请完成计算周长的方法
	public int calLength() {
		return 2 * (m_width + m_height);
	}

	// 请完成计算面积的方法
	public int calArea() {
		return m_width * m_height;
	}

	public static void main(String[] args) {
		/*
		 * rect_angle ra = new rect_angle(2,2,5,6);
		 * System.out.println(ra.calArea()); System.out.println(ra.calLength());
		 */
		square sq = new square(1, 1, 5);
		System.out.println(sq.calArea());
		System.out.println(sq.calLength());
	}

}
