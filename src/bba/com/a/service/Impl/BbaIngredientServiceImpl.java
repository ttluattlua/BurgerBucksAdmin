package bba.com.a.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bba.com.a.dao.BbaIngredientDao;
import bba.com.a.model.Bb_IngredientDto;
import bba.com.a.model.Bb_ImageDto;
import bba.com.a.service.BbaIngredientService;

@Service
public class BbaIngredientServiceImpl implements BbaIngredientService {
	@Autowired
	BbaIngredientDao bbaIngredientDao;

	@Override
	public Bb_IngredientDto registerIng(Bb_IngredientDto bigdto, Bb_ImageDto bidto) {
		int seq = bbaIngredientDao.registerIng(bigdto);
		bidto.setRef_Seq(seq);
		System.out.println(bidto.toString());
		int image_Seq = bbaIngredientDao.registerIngImage(bidto);
		System.out.println("registerIng_ image_Seq:"+image_Seq);
		bigdto.setSeq(seq);
		bigdto.setImage_Seq(image_Seq);
		
		return bigdto;
	}

	@Override
	public List<Bb_IngredientDto> getIngList() {
		List<Bb_IngredientDto> IngList = bbaIngredientDao.getIngList();
		List<Bb_ImageDto> imageList = bbaIngredientDao.getIngImageList(IngList);
		
		for (int i = 0; i < IngList.size(); i++) {
			IngList.get(i).setWhat_Image(imageList.get(i).getWhat_Image());
			IngList.get(i).setImage_Src(imageList.get(i).getImage_Src());
			IngList.get(i).setImage_Seq(imageList.get(i).getSeq());
		}
		
		return IngList;
	}

	@Override
	public Bb_IngredientDto getIngDetail(int seq) {
		// TODO Auto-generated method stub
		return bbaIngredientDao.getIngDetail(seq);
	}

	@Override
	public void updateIngAf(Bb_IngredientDto bigdto) {
		bbaIngredientDao.updateIngAf(bigdto);
		
	}

	@Override
	public void updateIngImageAf(Bb_ImageDto bidto) {
		bbaIngredientDao.updateIngImageAf(bidto);
		
	}

	@Override
	public void deleteIng(int seq, int image_Seq) {
		bbaIngredientDao.deleteIng(seq);
		bbaIngredientDao.deleteIngImage(image_Seq);
		
	}
}
