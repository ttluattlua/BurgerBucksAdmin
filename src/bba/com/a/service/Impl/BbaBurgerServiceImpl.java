package bba.com.a.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bba.com.a.dao.BbaBurgerDao;
import bba.com.a.model.Bb_IngredientDto;
import bba.com.a.service.BbaBurgerService;

@Service
public class BbaBurgerServiceImpl implements BbaBurgerService {

	@Autowired
	BbaBurgerDao bbaBurgerDao;

	@Override
	public List<Bb_IngredientDto> getIngredientList() {
		// TODO Auto-generated method stub
		return bbaBurgerDao.getIngredientList();
	}
	
}
