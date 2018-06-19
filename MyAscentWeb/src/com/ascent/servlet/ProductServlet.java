package com.ascent.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import com.ascent.bean.Product;
import com.ascent.bean.Usr;
import com.ascent.dao.ProductDAO;
import com.jspsmart.upload.SmartUpload;

@SuppressWarnings("serial")
public class ProductServlet extends HttpServlet {
	private ServletContext sc = null;
	private ServletConfig config = null;
	private String uploadPath = "upload"; // ���ڴ���ϴ��ļ���Ŀ¼

	public void init() throws ServletException {
		super.init();
		sc = this.getServletContext();
		config = this.getServletConfig();

		// �ļ��в����ھ��Զ�������
		if (!new File(uploadPath).isDirectory())
			new File(uploadPath).mkdirs();
	}

	// Process the HTTP Post request
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String state = request.getParameter("a");
		if (state.equals("all")){// ����ǲ�ѯ��Ʒ�������ѯҵ�񡣣�all��ʾ��ѯ���У�
			this.findProduceAll(request, response);
		}else if (state.equals("save")) {//�����Ʒ
			this.addProduct(request, response);
		}else if (state.equals("search")) {//��ѯ��Ʒ
			this.searchProduct(request, response);
		}else if (state.equals("updateProduct")){// ִ�и��µĲ�ѯ
			this.productSearchbyid(request, response);
		}else if (state.equals("update")){// ���������Ϣ
			this.updateProduct(request, response);
		}else if (state.equals("del")){// ɾ����Ʒ��Ϣ
			this.deleteProduct(request, response);
		}
	}

	private void doBrowse(HttpServletRequest request,HttpServletResponse response, String url) throws ServletException,IOException {
		RequestDispatcher rd = sc.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	private void doBrowseErr(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = sc.getRequestDispatcher("/product/products.jsp");
		rd.forward(request, response);
	}

	private void doError(HttpServletRequest request,HttpServletResponse response, String error)throws ServletException, IOException {
		request.setAttribute("error", error);
		this.doBrowseErr(request, response);
	}

	// Clean up resources
	public void destroy() {
	}

	/**
	 * ��ѯ���з���
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findProduceAll(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		ProductDAO pd = new ProductDAO();
		List<Product> procuctList = pd.getAllProduct();
		if (procuctList == null) {
			this.doError(request, response, "��ѯ��Ʒʧ��!");
		} else {
			HttpSession mysession = request.getSession(false);
			Usr pu = (Usr) mysession.getAttribute("productuser");
			request.setAttribute("productlist", procuctList);
			if (pu == null){ // �ο�
				this.doBrowse(request, response, "/product/products_show.jsp");
			} else {// �����ע���û�
				if ("2".equals(pu.getSuperuser())||"3".equals(pu.getSuperuser())){//����Ա
					this.doBrowse(request, response, "/admin/admin_products_show.jsp");
				} else if("1".equals(pu.getSuperuser())){//��ͨ�û�
					this.doBrowse(request, response, "/product/products_show.jsp");
				}
			}
		}
	}

	/**
	 *  �����Ʒ
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addProduct(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

		SmartUpload mySmartUpload = new SmartUpload();
		try {
			// Initialization
			mySmartUpload.initialize(config, request, response);
			mySmartUpload.setMaxFileSize(500 * 1024);
			// Upload
			mySmartUpload.upload();
			// ȡ��text���е�����
			String productnumber = mySmartUpload.getRequest().getParameter("productnumber");
			String pname = mySmartUpload.getRequest().getParameter("productname");
			String pcatalogno = mySmartUpload.getRequest().getParameter("catalogno");
			String pcas = mySmartUpload.getRequest().getParameter("cas");
			String pmdlnumber = mySmartUpload.getRequest().getParameter("mdlnumber");
			String pnewproduct = mySmartUpload.getRequest().getParameter("newproduct");
			String pformula = mySmartUpload.getRequest().getParameter("formula");
			String pcategory = mySmartUpload.getRequest().getParameter("category");
			String pstock = mySmartUpload.getRequest().getParameter("stock");
			String price1 = mySmartUpload.getRequest().getParameter("price1");
			String price2 = mySmartUpload.getRequest().getParameter("price2");
			String prealstock = mySmartUpload.getRequest().getParameter("realstock");
			String weight = mySmartUpload.getRequest().getParameter("weight");
			String pnote = mySmartUpload.getRequest().getParameter("note");
			
			Product pdt = new Product();
			pdt.setProductnumber(productnumber);
			pdt.setProductname(pname);
			pdt.setCategoryno(pcatalogno);
			pdt.setCas(pcas);
			pdt.setMdlint(pmdlnumber);
			pdt.setIsnewproduct(pnewproduct);
			pdt.setFormula(pformula);
			pdt.setCategory(pcategory);
			pdt.setStock(pstock);
			pdt.setRealstock(prealstock);
			pdt.setPrice1(Float.parseFloat(price1));
			pdt.setPrice2(Float.parseFloat(price2));
			pdt.setWeight(weight);
			pdt.setNote(pnote);
			com.jspsmart.upload.File myfile = mySmartUpload.getFiles().getFile(0);
			// ��ȡ�ϴ��ļ����ƺͺ�׺
			String fileName = myfile.getFileName();
			if (fileName != null && !fileName.equals("")) {
				pdt.setImagepath(fileName);
				myfile.saveAs("/" + uploadPath + "/" + fileName, 1);
			}
			ProductDAO Pd = new ProductDAO();
			Pd.saveProduct(pdt);
		} catch (Exception e) {
			System.out.println("Unable to upload the file.<br>");
			System.out.println("Error : " + e.toString());
		}
		try {
			this.findProduceAll(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ������ѯ
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void searchProduct(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String searchNames = request.getParameter("searchName");
		String searchValues = request.getParameter("searchValue");
		ProductDAO pd = new ProductDAO();
		List<Product> productList = pd.searchProcuct(searchNames, searchValues);
		request.setAttribute("searchproductlist", productList);
		this.doBrowse(request, response, "/product/products_search_show.jsp");
	}

	/**
	 * �鿴��Ʒ��Ϣ
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void productSearchbyid(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String productid = request.getParameter("pid");
		int pid = Integer.valueOf(productid);
		ProductDAO pd = new ProductDAO();
		Product product = pd.getProductByPid(pid);
		request.setAttribute("pid_product", product);
		this.doBrowse(request, response, "/admin/update_products_admin.jsp");
	}

	/**
	 *  ���²�Ʒ
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updateProduct(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		SmartUpload mySmartUpload = new SmartUpload();
		try {
			// Initialization
			mySmartUpload.initialize(config, request, response);
			mySmartUpload.setMaxFileSize(500 * 1024);
			// Upload
			mySmartUpload.upload();
			// ȡ��text���е�����
			String productid = mySmartUpload.getRequest().getParameter("pid");
			int pid = Integer.valueOf(productid);
			String productnumber = mySmartUpload.getRequest().getParameter("productnumber");
			String pname = mySmartUpload.getRequest().getParameter("productname");
			String pcas = mySmartUpload.getRequest().getParameter("cas");
			String pmdlnumber = mySmartUpload.getRequest().getParameter("mdlnumber");
			String pnewproduct = mySmartUpload.getRequest().getParameter("newproduct");
			String pformula = mySmartUpload.getRequest().getParameter("formula");
			String pcategory = mySmartUpload.getRequest().getParameter("category");
			String pcategoryno = mySmartUpload.getRequest().getParameter("categoryno");
			String pstock = mySmartUpload.getRequest().getParameter("stock");
			String prealstock = mySmartUpload.getRequest().getParameter("realstock");
			String weight = mySmartUpload.getRequest().getParameter("weight");
			String price1 = mySmartUpload.getRequest().getParameter("price1");
			String price2 = mySmartUpload.getRequest().getParameter("price2");
			String pnote = mySmartUpload.getRequest().getParameter("note");
			
			Product pdt = new Product();
			pdt.setId(pid);
			pdt.setProductname(pname); 
			pdt.setProductnumber(productnumber);
			pdt.setCas(pcas); 
			pdt.setMdlint(pmdlnumber);
			pdt.setIsnewproduct(pnewproduct);
			pdt.setFormula(pformula);
			pdt.setCategory(pcategory); 
			pdt.setCategoryno(pcategoryno);
			pdt.setStock(pstock);
			pdt.setRealstock(prealstock); 
			pdt.setWeight(weight);
			pdt.setPrice1(Float.parseFloat(price1));
			pdt.setPrice2(Float.parseFloat(price2));
			pdt.setNote(pnote);
			com.jspsmart.upload.File myfile = mySmartUpload.getFiles().getFile(0);
			// ��ȡ�ϴ��ļ����ƺͺ�׺
			String fileName = myfile.getFileName();
			if (fileName != null && !fileName.equals("")) {
				pdt.setImagepath(fileName);
				myfile.saveAs("/" + uploadPath + "/" + fileName, 1);
			}
			ProductDAO Pd = new ProductDAO();
			Pd.updateProduct(pdt);
		} catch (Exception e) {
			System.out.println("Unable to upload the file.<br>");
			System.out.println("Error : " + e.toString());
		}
		try {
			this.findProduceAll(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ɾ����Ʒ
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void deleteProduct(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String productid = request.getParameter("pid");
		int pid = Integer.valueOf(productid);
		ProductDAO pd = new ProductDAO();
		pd.delProductByPid(pid);
		List<Product> ProcuctList = pd.getAllProduct();
		request.setAttribute("productlist", ProcuctList);
		this.doBrowse(request, response, "/admin/admin_products_show.jsp");
	}
}
