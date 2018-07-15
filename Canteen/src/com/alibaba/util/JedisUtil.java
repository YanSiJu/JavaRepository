package com.alibaba.util;

import redis.clients.jedis.Jedis;

public class JedisUtil {

	private static Jedis jedis = new Jedis("localhost");

	/**
	 * ��������addToMenuPraiseHSet</br> 
	 * ��������¼�û����޲�Ʒ�ļ�¼</br> 
	 * ������Ա��Bill </br>
	 * ����ʱ�䣺2018��7��15�� </br>
	 * @param userId 
	 * @param menuId 
	 * @return ����û��ѵ��޹��ò�Ʒ���򷵻�
	 * {@code true}�����򷵻�{@code false} 
	 * @throws
	 */
	public static boolean addToMenuPraiseHSet(int userId, int menuId) {
		String key = String.valueOf(userId);
		String field = "menuHSet";

		// �ж��Ƿ���field�ֶ�
		if (jedis.hexists(key, field)) {
			// ��������ֶΣ����ȡ����ֵ
			String hVal = jedis.hget(key, field);
			if (!existsId(hVal.split(","), menuId)) {
				// ������menuId(��û�е��޸ò�Ʒ)����menuId��ӵ��ֶ���
				StringBuilder list = new StringBuilder(hVal);
				list.append("," + menuId);
				jedis.hset(key, field, list.toString());
				return false;
			} else {
				return true;
			}
		} else {
			// ����value�ĳ�ʼֵ
			String value = "" + userId;
			jedis.hset(key, field, value);
			return false;
		}

	}

	/**     
	* ��������existsId</br>
	* ������TODO���򵥷�����һ�仰������</br>
	* ������Ա��Bill </br>
	* ����ʱ�䣺2018��7��15��  </br>
	* @param str
	* @param id
	* @return
	* @throws 
	*/
	private static boolean existsId(String[] str, int id) {
		String specifiedId = "" + id;
		for (String s : str) {
			if (specifiedId.equals(s)) {
				return true;
			}
		}
		return false;
	}

	/**     
	* ��������addToPostPraiseHSet</br>
	* ������TODO���򵥷�����һ�仰������</br>
	* ������Ա��Bill </br>
	* ����ʱ�䣺2018��7��15��  </br>
	* @param userId
	* @param postId
	* @return
	* @throws 
	*/
	public static boolean addToPostPraiseHSet(int userId, int postId) {
		String key = String.valueOf(userId);
		String field = "postHSet";

		// �ж��Ƿ���field�ֶ�
		if (jedis.hexists(key, field)) {
			// ��������ֶΣ����ȡ����ֵ
			String hVal = jedis.hget(key, field);
			if (!existsId(hVal.split(","), postId)) {
				// ������postId(��û�е��޸�����)����postId��ӵ��ֶ���
				StringBuilder list = new StringBuilder(hVal);
				list.append("," + postId);
				jedis.hset(key, field, list.toString());
				return false;
			} else {
				return true;
			}
		} else {
			// ����value�ĳ�ʼֵ
			String value = "" + userId;
			jedis.hset(key, field, value);
			return false;
		}

	}
}
