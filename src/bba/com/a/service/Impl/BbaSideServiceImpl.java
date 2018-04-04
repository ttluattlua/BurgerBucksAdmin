package bba.com.a.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bba.com.a.dao.BbaSideDao;
import bba.com.a.service.BbaSideService;

@Service
public class BbaSideServiceImpl implements BbaSideService {
	@Autowired
	BbaSideDao bbaSideDao;
}
