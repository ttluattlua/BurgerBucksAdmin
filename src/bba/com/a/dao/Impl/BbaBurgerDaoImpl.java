package bba.com.a.dao.Impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bba.com.a.dao.BbaBurgerDao;
import bba.com.a.model.Bb_IngredientDto;

@Repository
public class BbaBurgerDaoImpl implements BbaBurgerDao {

	@Autowired
	SqlSessionTemplate sqlSession;
	
	String ns = "BBABurger.";
	/*--------------------------------------------------------------------------------------------
	 *버거 만들기 위한 재료들 가져오기
	 *-------------------------------------------------------------------------------------------*/	
	@Override
	public List<Bb_IngredientDto> getIngredientList() {
		System.out.println("BbaBurgerDaoImpl getIngredientList");
		List<Bb_IngredientDto> IngList = sqlSession.selectList(ns+"getIngredientList");
		
		for (Bb_IngredientDto bb_IngredientDto : IngList) {
			System.out.println(bb_IngredientDto.toString());
		}
		return IngList;
	}
}
