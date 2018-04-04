package bba.com.a.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bba.com.a.dao.BbaIngredientDao;
import bba.com.a.service.BbaIngredientService;

@Service
public class BbaIngredientServiceImpl implements BbaIngredientService {
	@Autowired
	BbaIngredientDao bbaIngredientDao;
}
