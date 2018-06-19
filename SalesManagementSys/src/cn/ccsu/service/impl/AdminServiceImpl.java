package cn.ccsu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.ccsu.mapper.AdminMapper;
import cn.ccsu.service.IAdminService;

/**
 * @author Bill
 *
 */
@Service
public class AdminServiceImpl implements IAdminService {

	public AdminServiceImpl() {

	}

	@Autowired
	private AdminMapper mapper;

	@Override
	public boolean validateIdentify(String acc, String passwd) {
		System.out.println("passwd:"+passwd+"  acc:"+acc);
		System.out.println("admin:"+mapper.selectAdm(acc, passwd));
		if (mapper.selectAdm(acc, passwd) != null) {
			return true;
		}
		return false;
	}

}
