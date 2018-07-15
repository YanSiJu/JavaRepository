package com.alibaba.util;

import redis.clients.jedis.Jedis;

public class JedisUtil {

	private static Jedis jedis = new Jedis("localhost");

	/**
	 * 方法名：addToMenuPraiseHSet</br> 
	 * 详述：记录用户点赞菜品的记录</br> 
	 * 开发人员：Bill </br>
	 * 创建时间：2018年7月15日 </br>
	 * @param userId 
	 * @param menuId 
	 * @return 如果用户已点赞过该菜品，则返回
	 * {@code true}；否则返回{@code false} 
	 * @throws
	 */
	public static boolean addToMenuPraiseHSet(int userId, int menuId) {
		String key = String.valueOf(userId);
		String field = "menuHSet";

		// 判断是否有field字段
		if (jedis.hexists(key, field)) {
			// 存在这个字段，则获取它的值
			String hVal = jedis.hget(key, field);
			if (!existsId(hVal.split(","), menuId)) {
				// 不存在menuId(即没有点赞该菜品)，将menuId添加到字段中
				StringBuilder list = new StringBuilder(hVal);
				list.append("," + menuId);
				jedis.hset(key, field, list.toString());
				return false;
			} else {
				return true;
			}
		} else {
			// 设置value的初始值
			String value = "" + userId;
			jedis.hset(key, field, value);
			return false;
		}

	}

	/**     
	* 方法名：existsId</br>
	* 详述：TODO（简单方法可一句话概述）</br>
	* 开发人员：Bill </br>
	* 创建时间：2018年7月15日  </br>
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
	* 方法名：addToPostPraiseHSet</br>
	* 详述：TODO（简单方法可一句话概述）</br>
	* 开发人员：Bill </br>
	* 创建时间：2018年7月15日  </br>
	* @param userId
	* @param postId
	* @return
	* @throws 
	*/
	public static boolean addToPostPraiseHSet(int userId, int postId) {
		String key = String.valueOf(userId);
		String field = "postHSet";

		// 判断是否有field字段
		if (jedis.hexists(key, field)) {
			// 存在这个字段，则获取它的值
			String hVal = jedis.hget(key, field);
			if (!existsId(hVal.split(","), postId)) {
				// 不存在postId(即没有点赞该帖子)，将postId添加到字段中
				StringBuilder list = new StringBuilder(hVal);
				list.append("," + postId);
				jedis.hset(key, field, list.toString());
				return false;
			} else {
				return true;
			}
		} else {
			// 设置value的初始值
			String value = "" + userId;
			jedis.hset(key, field, value);
			return false;
		}

	}
}
