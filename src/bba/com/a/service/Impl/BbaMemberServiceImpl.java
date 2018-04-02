package bba.com.a.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bba.com.a.dao.BbaMemberDao;
import bba.com.a.model.Bb_AdminDto;
import bba.com.a.service.BbaMemberSerivce;

@Service
public class BbaMemberServiceImpl implements BbaMemberSerivce {

	@Autowired
	private BbaMemberDao bbsMemberDao;
	
	/*------------------------------------------------------------------------------
	* 사원등록(브랜치매니저)
	* -----------------------------------------------------------------------------*/
	@Override
	public boolean addAdmin(Bb_AdminDto adminDto) throws Exception {
		return bbsMemberDao.addAdmin(adminDto);
	}

	
	
}
