package cn.ccsu.service;

import java.util.List;

public interface ICashier {

	void checkout(String username, List<Integer> id) throws Exception;
}
