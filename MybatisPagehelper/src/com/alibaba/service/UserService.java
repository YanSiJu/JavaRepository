package com.alibaba.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.alibaba.entity.User;

@Service
public interface UserService {

	List<User> getAll();

}
