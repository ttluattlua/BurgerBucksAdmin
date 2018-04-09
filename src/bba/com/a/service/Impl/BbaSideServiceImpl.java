package bba.com.a.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bba.com.a.dao.BbaSideDao;
import bba.com.a.model.Bb_ImageDto;
import bba.com.a.model.Bb_SideDto;
import bba.com.a.service.BbaSideService;

@Service
public class BbaSideServiceImpl implements BbaSideService {
	@Autowired
	BbaSideDao bbaSideDao;

	@Override
	public Bb_SideDto registerSide(Bb_SideDto bsdto, Bb_ImageDto bidto) {
		int seq = bbaSideDao.registerSide(bsdto);
		bidto.setRef_Seq(seq);
		System.out.println(bidto.toString());
		int image_Seq = bbaSideDao.registerSideImage(bidto);
		System.out.println("registerSide_ image_Seq:"+image_Seq);
		bsdto.setSeq(seq);
		bsdto.setImage_Seq(image_Seq);
		
		return bsdto;
	}

	@Override
	public List<Bb_SideDto> getSideList() {
		// TODO Auto-generated method stub
		
		List<Bb_SideDto> sideList = bbaSideDao.getSideList();
		List<Bb_ImageDto> imageList = bbaSideDao.getSideImageList(sideList);
		
		for (int i = 0; i < sideList.size(); i++) {
			sideList.get(i).setImage_Src(imageList.get(i).getImage_Src());
			sideList.get(i).setImage_Seq(imageList.get(i).getSeq());
		}
		
		return sideList;
	}

	@Override
	public Bb_SideDto getSideDetail(int seq) {
		// TODO Auto-generated method stub
		return bbaSideDao.getSideDetail(seq);
	}

	@Override
	public void updateSideAf(Bb_SideDto bsdto) {
		bbaSideDao.updateSideAf(bsdto);
		
	}

	@Override
	public void updateSideImageAf(Bb_ImageDto bidto) {
		bbaSideDao.updateSideImageAf(bidto);
		
	}

	@Override
	public void deleteSide(int seq, int image_Seq) {
		bbaSideDao.deleteSide(seq);
		bbaSideDao.deleteSideImage(image_Seq);
		
	}


}
