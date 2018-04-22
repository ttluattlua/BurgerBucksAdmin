package bba.com.a.dao.Impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bba.com.a.dao.BbaMenuDao;
import bba.com.a.model.Bb_BeverageDto;
import bba.com.a.model.Bb_BurgerDto;
import bba.com.a.model.Bb_MenuDto;
import bba.com.a.model.Bb_SideDto;


@Repository
public class BbaMenuDaoImpl implements BbaMenuDao {
	
	@Autowired
	SqlSessionTemplate sqlSession;
	
	String ns = "BBAMenu.";
	/*--------------------------------------------------------------------------------------------
	 *menu리스트가져오기 
	 *-------------------------------------------------------------------------------------------*/
	
	@Override
	public List<Bb_MenuDto> getMenuList() {
		List<Bb_MenuDto> mList = sqlSession.selectList(ns+"getMenuList");
		System.out.println("실행");
		for (Bb_MenuDto bb_MenuDto : mList) {
			System.out.println(bb_MenuDto.toString());		
		}
		return mList;
	}
	
	/*--------------------------------------------------------------------------------------------
	 *menu 디테일 사이드 가져오기 
	 *-------------------------------------------------------------------------------------------*/
	
	@Override
	public Bb_SideDto getDetailSide(int seq) {
		return sqlSession.selectOne(ns+"getDetailSide", seq);
	}

	/*--------------------------------------------------------------------------------------------
	 *menu 디테일 음료 가져오기 
	 *-------------------------------------------------------------------------------------------*/
	
	@Override
	public Bb_BeverageDto getDetailBeverage(int seq) {
		return sqlSession.selectOne(ns+"getDetailBeverage", seq);
	}
	
	/*--------------------------------------------------------------------------------------------
	 *메뉴지우기
	 *-------------------------------------------------------------------------------------------*/
	
	@Override
	public void deleteMenu(int seq) {
		sqlSession.update(ns+"deleteMenu", seq);
	}
	
	/*--------------------------------------------------------------------------------------------
	 *메뉴버거디테일가져오기
	 *-------------------------------------------------------------------------------------------*/
	
	@Override
	public Bb_BurgerDto getDetailBurger(int seq) {
		return sqlSession.selectOne(ns+"getMenuDetailBurger", seq);
	}
}
