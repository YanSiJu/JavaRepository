/**
 * 用来封装购物车里的一项商品
 */
package com.ascent.util;

import com.ascent.bean.Product;

public class CartItem {
	
	private Product product;
	private int quantity;

	/**
	 * @param product
	 */
	public CartItem(Product product) {
		quantity = 1;
		this.product = product;
	}

	public double getCartItemPrice() {
		return product.getPrice1() * quantity;
	}

	// 表示所购买商品数量加一
	public void incre() {
		quantity++;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product
	 *            the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
