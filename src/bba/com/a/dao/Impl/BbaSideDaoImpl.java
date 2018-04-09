package bba.com.a.dao.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bba.com.a.dao.BbaSideDao;
import bba.com.a.model.Bb_ImageDto;
import bba.com.a.model.Bb_SideDto;

@Repository
public class BbaSideDaoImpl implements BbaSideDao {

	@Autowired
	SqlSessionTemplate sqlSession;
	
	String ns = "BBASide.";

	/*--------------------------------------------------------------------------------------------
	 * side 새로 등록 
	 *-------------------------------------------------------------------------------------------*/
	@Override
	public int registerSide(Bb_SideDto bsdto) {
		System.out.println("BbaSideDaoImpl registerSide");
		System.out.println(bsdto.toString());
		int count = sqlSession.insert(ns+"registerSide", bsdto);
		//select key로 리터해온거
		int seq = bsdto.getSeq();
		System.out.println("seq: " + seq);
		return seq;
	}

	/*--------------------------------------------------------------------------------------------
	 * side 새로 이미지 등록 
	 *-------------------------------------------------------------------------------------------*/
	
	@Override
	public int registerSideImage(Bb_ImageDto bidto) {
		// TODO Auto-generated method stub
		int count = sqlSession.insert(ns+"registerSideImage", bidto);
		int seq = bidto.getSeq();
		return seq;
	}
	
	/*--------------------------------------------------------------------------------------------
	 * side 리스트 가져오기 
	 *-------------------------------------------------------------------------------------------*/
	

	@Override
	public List<Bb_SideDto> getSideList() {
		// TODO Auto-generated method stub
		List<Bb_SideDto> bslist = sqlSession.selectList(ns+"getSideList");
		for (Bb_SideDto bb_SideDto : bslist) {
			System.out.println(bb_SideDto.toString());
		}
		return bslist;
	}

	
	
	/*--------------------------------------------------------------------------------------------
	 * side 이미지 리스트들 가져오기
	 *-------------------------------------------------------------------------------------------*/
	@Override
	public List<Bb_ImageDto> getSideImageList(List<Bb_SideDto> bslist) {
		
		
		List<Integer> seqlist = new ArrayList<>();
		for (int i = 0; i < bslist.size(); i++) {
			seqlist.add(bslist.get(i).getSeq());
			System.out.println("list["+i+"]: "+ seqlist.get(i));
		}
		HashMap<String, Object> list = new HashMap<String, Object>(); 
		list.put("list", seqlist);
		
		List<Bb_ImageDto> ImageList = sqlSession.selectList(ns+"getSideImageList", list);
		return ImageList;
	}

	/*--------------------------------------------------------------------------------------------
	 * side 디테일 가져오기
	 *-------------------------------------------------------------------------------------------*/
	@Override
	public Bb_SideDto getSideDetail(int seq) {

		return sqlSession.selectOne(ns+"getSideDetail", seq);
	}
	
	/*--------------------------------------------------------------------------------------------
	 * side 업데이트 완료
	 *-------------------------------------------------------------------------------------------*/
	
	@Override
	public void updateSideAf(Bb_SideDto bsdto) {
		sqlSession.update(ns+"updateSideAf", bsdto);
	}
	
	
	/*--------------------------------------------------------------------------------------------
	 * 이미지 업데이트 완료
	 *-------------------------------------------------------------------------------------------*/
	
	@Override
	public void updateSideImageAf(Bb_ImageDto bidto) {
		sqlSession.update(ns+"updateSideImageAf", bidto);
	}

	/*--------------------------------------------------------------------------------------------
	 * side 삭제하기
	 *-------------------------------------------------------------------------------------------*/
	@Override
	public void deleteSide(int seq) {
		sqlSession.update(ns+"deleteSide", seq);
		
	}

	/*--------------------------------------------------------------------------------------------
	 * side이미지 삭제하기
	 *-------------------------------------------------------------------------------------------*/
	@Override
	public void deleteSideImage(int image_Seq) {
		sqlSession.update(ns+"deleteSideImage", image_Seq);
		
	}

}
