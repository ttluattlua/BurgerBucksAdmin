package bba.com.a.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bba.com.a.dao.BbaBurgerDao;
import bba.com.a.model.Bb_BurgerDto;
import bba.com.a.model.Bb_ImageDto;
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

	@Override
	public List<Bb_BurgerDto> getBurgerListForBurgerTB() {
		// TODO Auto-generated method stub
		return bbaBurgerDao.getBurgerListForBurgerTB();
	}

	@Override
	public Bb_BurgerDto registerBurger(Bb_BurgerDto bgdto, Bb_ImageDto bidto) {
		int seq = bbaBurgerDao.registerBurger(bgdto);
		bidto.setRef_Seq(seq);
		System.out.println(bidto.toString());
		int image_Seq = bbaBurgerDao.registerburgerImage(bidto);
		System.out.println("registerIng_ image_Seq:"+image_Seq);
		bgdto.setSeq(seq);
		bgdto.setImage_Seq(image_Seq);
		
		return bgdto;
	}

	@Override
	public Bb_BurgerDto getBurgerIngredientForBurgerTB(int seq) {
		// TODO Auto-generated method stub
		return bbaBurgerDao.getBurgerIngredientForBurgerTB(seq);
	}
	
}
