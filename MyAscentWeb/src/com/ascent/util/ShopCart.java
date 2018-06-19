package com.ascent.util;

import java.util.HashMap;

import com.ascent.bean.Product;

/**
 * 完成购物功能的类
 * @author zy
 */
public class ShopCart {

	private HashMap<String, CartItem> hashmap;

	public ShopCart() {
		hashmap = new HashMap<String ,CartItem>(); //key为商品id,value为商品信息及购买数量
	}

	/**
	 * 检查hashmap中是否有了该pid对应的对象方法
	 * @param pid 商品id
	 * @return true：有  false：无
	 */
	public boolean checkHashMapid(String pid) {
		boolean b = false;
		if (hashmap.containsKey(pid)) {
			b = true;
		}
		return b;
	}

	/**
	 * 添加商品对象
	 * @param pid 商品id
	 * @param product 商品对象
	 */
	public void addProduct(String pid, Product product) {
		if(pid!=null){
			if(hashmap.containsKey(pid)){
				CartItem item = (CartItem)hashmap.get(pid);
				item.incre();
			}else{
				CartItem item = new CartItem(product);
				hashmap.put(pid, item);
			}
		}
	}

	/**
	 * 根据id删除hashmap中的product
	 * @param pid
	 */
	public void removeHashMap(String pid) {
		hashmap.remove(pid);
	}

	/**
	 * 修改hashmap中pid对应product的数量
	 * @param pid 商品id
	 * @param quantity 修改数量
	 */
	public void updateProductNumber(String pid, int quantity) {
		hashmap.get(pid).setQuantity(quantity);
	}

	/**
	 * 清除购物车
	 */
	public void emptyCart() {
		hashmap.clear();
	}
	

	public HashMap<String, CartItem> getHashmap() {
		return hashmap;
	}

	public void setHashmap(HashMap<String, CartItem> hashmap) {
		this.hashmap = hashmap;
	}
}
