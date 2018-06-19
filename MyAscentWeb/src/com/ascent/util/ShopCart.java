package com.ascent.util;

import java.util.HashMap;

import com.ascent.bean.Product;

/**
 * ��ɹ��﹦�ܵ���
 * @author zy
 */
public class ShopCart {

	private HashMap<String, CartItem> hashmap;

	public ShopCart() {
		hashmap = new HashMap<String ,CartItem>(); //keyΪ��Ʒid,valueΪ��Ʒ��Ϣ����������
	}

	/**
	 * ���hashmap���Ƿ����˸�pid��Ӧ�Ķ��󷽷�
	 * @param pid ��Ʒid
	 * @return true����  false����
	 */
	public boolean checkHashMapid(String pid) {
		boolean b = false;
		if (hashmap.containsKey(pid)) {
			b = true;
		}
		return b;
	}

	/**
	 * �����Ʒ����
	 * @param pid ��Ʒid
	 * @param product ��Ʒ����
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
	 * ����idɾ��hashmap�е�product
	 * @param pid
	 */
	public void removeHashMap(String pid) {
		hashmap.remove(pid);
	}

	/**
	 * �޸�hashmap��pid��Ӧproduct������
	 * @param pid ��Ʒid
	 * @param quantity �޸�����
	 */
	public void updateProductNumber(String pid, int quantity) {
		hashmap.get(pid).setQuantity(quantity);
	}

	/**
	 * ������ﳵ
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
