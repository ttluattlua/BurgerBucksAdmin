package bba.com.a.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bba.com.a.dao.BbaBurgerDao;
import bba.com.a.service.BbaBurgerService;

@Service
public class BbaBurgerServiceImpl implements BbaBurgerService {

	@Autowired
	BbaBurgerDao bbaBurgerDao;
	
}
