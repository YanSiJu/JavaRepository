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
		// 获取登录状态（登录或退出系统）；
		String state = request.getParameter("a");
		if (state.equals("add")){// 向购物车添加产品动作
			this.addtoShopCart(request, response);
		}else if (state.equals("find")){// 查找购物车产品动作
			this.findShopCart(request, response);
		}else if (state.equals("checkout")){// 结帐
			this.checkout(request, response);
		}else if (state.equals("move")) { //移除购物车商品
			this.delShopCartProduct(request, response);
		}else if (state.equals("updateNum")) { //更新购物车产品数量
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
	 * 购买商品，添加购物车
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
		boolean bl = cart.checkHashMapid(pid);// 判断购物车是否已经添加
		if (bl){// 该产品已经添加
			// Ajax返回该商品已经添加过的提示
			String dthtml = "该产品已经保存在购物车里!";
			response.setContentType("text/html; charset=gb2312");
			response.getWriter().print(dthtml);// 返回页面
		} else{// 没有添加
			ProductDAO pd = new ProductDAO();
			Product product = pd.getProductByPid(ppid);
			cart.addProduct(pid, product);
			String dthtml = "添加成功!";// "该商品已经添加过";
			response.setContentType("text/html; charset=gb2312");
			response.getWriter().print(dthtml);// 返回页面
		}
		response.getWriter().flush();
		response.getWriter().close();
	}

	/**
	 * 查询购物车商品信息
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
		Collection<CartItem> shopCartlist = cart.getHashmap().values();// 返回购物车里value的视图（collection）
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
		Collection<CartItem> shopCartlist = cart.getHashmap().values();// 返回购物车里value的视图（collection）
		session.setAttribute("shopcartlist", shopCartlist);
		this.doBrowse(request, response, "/product/cartshow.jsp");
	}

	/**
	 * 更新购物车商品数量
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
		// Ajax返回该商品已经添加过的提示
		String dthtml = "该产品已经修改";// "该商品已经添加过";
		response.setContentType("text/html; charset=gb2312");
		response.getWriter().print(dthtml);// 返回页面
		response.getWriter().flush();
		response.getWriter().close();
	}

	/**
	 * 结算
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void checkout(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		ShopCart cart = (ShopCart) session.getAttribute("shopcart");
		Collection<CartItem> shopCartlist = cart.getHashmap().values();// 返回购物车里value的视图（collection）
		session.setAttribute("shopcartlist", shopCartlist);
		this.doBrowse(request, response, "/product/checkout.jsp");
	}
}
