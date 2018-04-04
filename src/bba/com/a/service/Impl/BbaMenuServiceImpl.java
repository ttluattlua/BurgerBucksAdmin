package bba.com.a.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bba.com.a.dao.BbaMenuDao;
import bba.com.a.service.BbaMenuService;


@Service
public class BbaMenuServiceImpl implements BbaMenuService {
	@Autowired
	BbaMenuDao bbaMenuDao;
}
