package bba.com.a.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bba.com.a.dao.BbaMenuDao;
import bba.com.a.model.Bb_BeverageDto;
import bba.com.a.model.Bb_BurgerDto;
import bba.com.a.model.Bb_MenuDto;
import bba.com.a.model.Bb_SideDto;
import bba.com.a.service.BbaMenuService;


@Service
public class BbaMenuServiceImpl implements BbaMenuService {
	@Autowired
	BbaMenuDao bbaMenuDao;

	@Override
	public List<Bb_MenuDto> getMenuList() {
		return bbaMenuDao.getMenuList();
	}

	@Override
	public Bb_SideDto getDetailSide(int seq) {
		return bbaMenuDao.getDetailSide(seq);
	}

	@Override
	public Bb_BeverageDto getDetailBeverage(int seq) {
		return bbaMenuDao.getDetailBeverage(seq);
	}

	@Override
	public void deleteMenu(int seq) {
		bbaMenuDao.deleteMenu(seq);
		
	}

	@Override
	public Bb_BurgerDto getDetailBurger(int seq) {
		return bbaMenuDao.getDetailBurger(seq);
	}
}
