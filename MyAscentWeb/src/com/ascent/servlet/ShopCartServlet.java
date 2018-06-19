package com.ascent.servlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ascent.util.CartItem;
import com.ascent.util.ShopCart;
import com.ascent.bean.Product;
import com.ascent.dao.ProductDAO;

@SuppressWarnings("serial")
public class ShopCartServlet extends HttpServlet {
	private ServletContext sc = null;

	public void init() throws ServletException {
		super.init();
		sc = this.getServletContext();
	}

	// Process the HTTP Post request
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// ��ȡ��¼״̬����¼���˳�ϵͳ����
		String state = request.getParameter("a");
		if (state.equals("add")){// ���ﳵ��Ӳ�Ʒ����
			this.addtoShopCart(request, response);
		}else if (state.equals("find")){// ���ҹ��ﳵ��Ʒ����
			this.findShopCart(request, response);
		}else if (state.equals("checkout")){// ����
			this.checkout(request, response);
		}else if (state.equals("move")) { //�Ƴ����ﳵ��Ʒ
			this.delShopCartProduct(request, response);
		}else if (state.equals("updateNum")) { //���¹��ﳵ��Ʒ����
			this.updateCartProductNum(request, response);
		}
	}

	private void doBrowse(HttpServletRequest request,HttpServletResponse response, String url) throws ServletException,IOException {
		RequestDispatcher rd = sc.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	// Clean up resources
	public void destroy() {
	}

	/**
	 * ������Ʒ����ӹ��ﳵ
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void addtoShopCart(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		ShopCart cart = (ShopCart) session.getAttribute("shopcart");
		if (cart == null) {
			cart = new ShopCart();
			session.setAttribute("shopcart", cart);
		}
		String pid = request.getParameter("pid");
		int ppid = Integer.parseInt(pid);
		boolean bl = cart.checkHashMapid(pid);// �жϹ��ﳵ�Ƿ��Ѿ����
		if (bl){// �ò�Ʒ�Ѿ����
			// Ajax���ظ���Ʒ�Ѿ���ӹ�����ʾ
			String dthtml = "�ò�Ʒ�Ѿ������ڹ��ﳵ��!";
			response.setContentType("text/html; charset=gb2312");
			response.getWriter().print(dthtml);// ����ҳ��
		} else{// û�����
			ProductDAO pd = new ProductDAO();
			Product product = pd.getProductByPid(ppid);
			cart.addProduct(pid, product);
			String dthtml = "��ӳɹ�!";// "����Ʒ�Ѿ���ӹ�";
			response.setContentType("text/html; charset=gb2312");
			response.getWriter().print(dthtml);// ����ҳ��
		}
		response.getWriter().flush();
		response.getWriter().close();
	}

	/**
	 * ��ѯ���ﳵ��Ʒ��Ϣ
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void findShopCart(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		ShopCart cart = (ShopCart) session.getAttribute("shopcart");
		if (cart == null) {
			cart = new ShopCart();
		}
		Collection<CartItem> shopCartlist = cart.getHashmap().values();// ���ع��ﳵ��value����ͼ��collection��
		session.setAttribute("shopcartlist", shopCartlist);
		this.doBrowse(request, response, "/product/cartshow.jsp");
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void delShopCartProduct(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		ShopCart cart = (ShopCart) session.getAttribute("shopcart");
		String pid = request.getParameter("pid");
		cart.removeHashMap(pid);
		Collection<CartItem> shopCartlist = cart.getHashmap().values();// ���ع��ﳵ��value����ͼ��collection��
		session.setAttribute("shopcartlist", shopCartlist);
		this.doBrowse(request, response, "/product/cartshow.jsp");
	}

	/**
	 * ���¹��ﳵ��Ʒ����
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void updateCartProductNum(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		ShopCart cart = (ShopCart) session.getAttribute("shopcart");
		String pid = request.getParameter("pid");
		String number = request.getParameter("quantity");
		cart.updateProductNumber(pid, Integer.parseInt(number));
		// Ajax���ظ���Ʒ�Ѿ���ӹ�����ʾ
		String dthtml = "�ò�Ʒ�Ѿ��޸�";// "����Ʒ�Ѿ���ӹ�";
		response.setContentType("text/html; charset=gb2312");
		response.getWriter().print(dthtml);// ����ҳ��
		response.getWriter().flush();
		response.getWriter().close();
	}

	/**
	 * ����
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void checkout(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		ShopCart cart = (ShopCart) session.getAttribute("shopcart");
		Collection<CartItem> shopCartlist = cart.getHashmap().values();// ���ع��ﳵ��value����ͼ��collection��
		session.setAttribute("shopcartlist", shopCartlist);
		this.doBrowse(request, response, "/product/checkout.jsp");
	}
}
