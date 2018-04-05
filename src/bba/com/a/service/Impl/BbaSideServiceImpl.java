package bba.com.a.service.Impl;

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
		bbaSideDao.registerSideImage(bidto);
		
		bsdto.setSeq(seq);
		
		return bsdto;
	}
}
