package bba.com.a.dao.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bba.com.a.dao.BbaIngredientDao;
import bba.com.a.model.Bb_BeverageDto;
import bba.com.a.model.Bb_ImageDto;
import bba.com.a.model.Bb_IngredientDto;

@Repository
public class BbaIngredientDaoImpl implements BbaIngredientDao {

	@Autowired
	SqlSessionTemplate sqlSession;
	
	String ns = "BBAIngredient.";
	/*--------------------------------------------------------------------------------------------
	 * 재료 새로 등록 
	 *-------------------------------------------------------------------------------------------*/
	@Override
	public int registerIng(Bb_IngredientDto bigdto) {
		System.out.println("registerIng");
		System.out.println(bigdto.toString());
		int count = sqlSession.insert(ns+"registerIng", bigdto);
		//select key로 리터해온거
		int seq = bigdto.getSeq();
		System.out.println("seq: " + seq);
		return seq;
	}

	/*--------------------------------------------------------------------------------------------
	 * 재료 새로 이미지 등록 
	 *-------------------------------------------------------------------------------------------*/
	
	@Override
	public int registerIngImage(Bb_ImageDto bidto) {
		int count = sqlSession.insert(ns+"registerIngImage", bidto);
		int seq = bidto.getSeq();
		return seq;
	}
	/*--------------------------------------------------------------------------------------------
	 * 재료 리스트 가져오기 
	 *-------------------------------------------------------------------------------------------*/
	
	@Override
	public List<Bb_IngredientDto> getIngList() {
		// TODO Auto-generated method stub
		List<Bb_IngredientDto> bblist = sqlSession.selectList(ns+"getIngList");
		for (Bb_IngredientDto bb_IngredientDto : bblist) {
			System.out.println(bb_IngredientDto.toString());
		}
		return bblist;
	}

	/*--------------------------------------------------------------------------------------------
	 * 재료 이미지 리스트들 가져오기
	 *-------------------------------------------------------------------------------------------*/
	@Override
	public List<Bb_ImageDto> getIngImageList(List<Bb_IngredientDto> bblist) {
		List<Integer> seqlist = new ArrayList<>();
		for (int i = 0; i < bblist.size(); i++) {
			seqlist.add(bblist.get(i).getSeq());
			System.out.println("list["+i+"]: "+ seqlist.get(i));
		}
		HashMap<String, Object> list = new HashMap<String, Object>(); 
		list.put("list", seqlist);
		
		List<Bb_ImageDto> ImageList = sqlSession.selectList(ns+"getIngImageList", list);
		return ImageList;
	}
	/*--------------------------------------------------------------------------------------------
	 * 재료 디테일 가져오기
	 *-------------------------------------------------------------------------------------------*/
	@Override
	public Bb_IngredientDto getIngDetail(int seq) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(ns+"getIngDetail", seq);
	}
	/*--------------------------------------------------------------------------------------------
	 * 재료 업데이트 완료
	 *-------------------------------------------------------------------------------------------*/
	
	@Override
	public void updateIngAf(Bb_IngredientDto bigdto) {
		sqlSession.update(ns+"updateIngAf", bigdto);
		
	}
	/*--------------------------------------------------------------------------------------------
	 * 재료 이미지 업데이트 완료
	 *-------------------------------------------------------------------------------------------*/
	
	@Override
	public void updateIngImageAf(Bb_ImageDto bidto) {
		sqlSession.update(ns+"updateIngImageAf", bidto);
		
	}
	/*--------------------------------------------------------------------------------------------
	 *재료 side 삭제하기
	 *-------------------------------------------------------------------------------------------*/
	@Override
	public void deleteIng(int seq) {
		sqlSession.update(ns+"deleteIng", seq);
		
	}
	/*--------------------------------------------------------------------------------------------
	 * 재료 이미지 삭제하기
	 *-------------------------------------------------------------------------------------------*/
	@Override
	public void deleteIngImage(int image_Seq) {
		sqlSession.update(ns+"deleteIngImage", image_Seq);
		
	}
}
