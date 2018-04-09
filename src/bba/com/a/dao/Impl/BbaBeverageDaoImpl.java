package bba.com.a.dao.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bba.com.a.dao.BbaBeverageDao;
import bba.com.a.model.Bb_BeverageDto;
import bba.com.a.model.Bb_ImageDto;
import bba.com.a.model.Bb_SideDto;

@Repository
public class BbaBeverageDaoImpl implements BbaBeverageDao {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	String ns = "BBABeverage.";

	/*--------------------------------------------------------------------------------------------
	 * 음료 새로 등록 
	 *-------------------------------------------------------------------------------------------*/
	@Override
	public int registerBev(Bb_BeverageDto bbdto) {
		System.out.println("registerBev");
		System.out.println(bbdto.toString());
		int count = sqlSession.insert(ns+"registerBev", bbdto);
		//select key로 리터해온거
		int seq = bbdto.getSeq();
		System.out.println("seq: " + seq);
		return seq;
	}

	/*--------------------------------------------------------------------------------------------
	 * 음료 새로 이미지 등록 
	 *-------------------------------------------------------------------------------------------*/
	
	@Override
	public int registerBevImage(Bb_ImageDto bidto) {

		int count = sqlSession.insert(ns+"registerBevImage", bidto);
		int seq = bidto.getSeq();
		return seq;
	}

	
	/*--------------------------------------------------------------------------------------------
	 * 음료 리스트 가져오기 
	 *-------------------------------------------------------------------------------------------*/
	
	@Override
	public List<Bb_BeverageDto> getBevList() {
		// TODO Auto-generated method stub
		List<Bb_BeverageDto> bslist = sqlSession.selectList(ns+"getBevList");
		for (Bb_BeverageDto bb_BeverageDto : bslist) {
			System.out.println(bb_BeverageDto.toString());
		}
		return bslist;
	}
	
	/*--------------------------------------------------------------------------------------------
	 * 음료 이미지 리스트들 가져오기
	 *-------------------------------------------------------------------------------------------*/
	@Override
	public List<Bb_ImageDto> getBevImageList(List<Bb_BeverageDto> bslist) {
		List<Integer> seqlist = new ArrayList<>();
		for (int i = 0; i < bslist.size(); i++) {
			seqlist.add(bslist.get(i).getSeq());
			System.out.println("list["+i+"]: "+ seqlist.get(i));
		}
		HashMap<String, Object> list = new HashMap<String, Object>(); 
		list.put("list", seqlist);
		
		List<Bb_ImageDto> ImageList = sqlSession.selectList(ns+"getBevImageList", list);
		return ImageList;
	}
	/*--------------------------------------------------------------------------------------------
	 * 음료 디테일 가져오기
	 *-------------------------------------------------------------------------------------------*/
	@Override
	public Bb_BeverageDto getBevDetail(int seq) {
		return sqlSession.selectOne(ns+"getBevDetail", seq);
	}
	/*--------------------------------------------------------------------------------------------
	 * 음료 업데이트 완료
	 *-------------------------------------------------------------------------------------------*/
	
	@Override
	public void updateBevAf(Bb_BeverageDto bbdto) {
		sqlSession.update(ns+"updateBevAf", bbdto);
		
	}
	/*--------------------------------------------------------------------------------------------
	 * 음료 이미지 업데이트 완료
	 *-------------------------------------------------------------------------------------------*/
	
	@Override
	public void updateBevImageAf(Bb_ImageDto bidto) {
		sqlSession.update(ns+"updateBevImageAf", bidto);
		
	}
	/*--------------------------------------------------------------------------------------------
	 *음료 side 삭제하기
	 *-------------------------------------------------------------------------------------------*/
	@Override
	public void deleteBev(int seq) {
		sqlSession.update(ns+"deleteBev", seq);
		
	}
	/*--------------------------------------------------------------------------------------------
	 * Bev 이미지 삭제하기
	 *-------------------------------------------------------------------------------------------*/
	@Override
	public void deleteBevImage(int image_Seq) {
		sqlSession.update(ns+"deleteBevImage", image_Seq);
		
	}
}
