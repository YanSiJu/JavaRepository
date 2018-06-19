package cn.ccsu.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.ccsu.entity.Salesman;
import cn.ccsu.mapper.SalesmanMapper;
import cn.ccsu.service.ISalesmanService;

/**
 * @author Bill
 *
 */
@Service
public class SalesmanServiceImpl implements ISalesmanService {

	@Autowired
	private SalesmanMapper mapper;

	public SalesmanServiceImpl() {

	}

	@Override
	public int addSalesman(Salesman salman) {
		if (salman != null) {
			mapper.addSalesman(salman);
			return 1;
		} else {
			return -1;
		}

	}

	@Override
	public List<Salesman> querySalesman(String name, Integer id, String sex) {

		Map<String, Object> map = new HashMap<>(3);
		map.put("name", name);
		map.put("id", id);
		map.put("sex", sex);
		return mapper.selectSalesman(map);
	}

	@Override
	public int modifySalesman(Salesman salman) {
		if (salman != null) {
			mapper.updateSalesman(salman);
			return 1;
		} else {
			return -1;
		}
	}

	@Override
	public void deleteSalesman(Integer id) {

		mapper.deleteSalesman(id);

	}

	@Override
	public List<Salesman> queryAllSalesman() {
		return mapper.selectAllSalesman();
	}

}
