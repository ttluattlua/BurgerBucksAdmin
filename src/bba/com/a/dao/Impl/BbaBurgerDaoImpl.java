package bba.com.a.dao.Impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bba.com.a.dao.BbaBurgerDao;
import bba.com.a.model.Bb_BurgerDto;
import bba.com.a.model.Bb_ImageDto;
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
	@Override
	public List<Bb_BurgerDto> getBurgerListForBurgerTB() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(ns+"getBurgerListForBurgerTB");
	}
	@Override
	public int registerBurger(Bb_BurgerDto bgdto) {
		System.out.println("registerBurger");
		System.out.println("버거등록다오:"+bgdto.toString());
		int count = sqlSession.insert(ns+"registerBurger", bgdto);
		//select key로 리터해온거
		int seq = bgdto.getSeq();
		System.out.println("seq: " + seq);
		return seq;
	}
	@Override
	public int registerburgerImage(Bb_ImageDto bidto) {
		int count = sqlSession.insert(ns+"registerburgerImage", bidto);
		int seq = bidto.getSeq();
		return seq;
	}
	
	/*--------------------------------------------------------------------------------------------
	 * 버거 등록후 재료들 이름뽑아오기 
	 *-------------------------------------------------------------------------------------------*/
	@Override
	public Bb_BurgerDto getBurgerIngredientForBurgerTB(int seq) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(ns+"getBurgerIngredientForBurgerTB", seq);
	}
	
	
}
