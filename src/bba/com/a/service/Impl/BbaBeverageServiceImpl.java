package bba.com.a.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bba.com.a.dao.BbaBeverageDao;
import bba.com.a.service.BbaBeverageService;


@Service
public class BbaBeverageServiceImpl implements BbaBeverageService {
	
	@Autowired
	BbaBeverageDao bbaBeverageDao;
}
