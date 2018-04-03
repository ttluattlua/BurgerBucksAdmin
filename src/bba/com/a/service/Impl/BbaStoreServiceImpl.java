package bba.com.a.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bba.com.a.dao.BbaStoreDao;
import bba.com.a.model.Bb_StoreDto;
import bba.com.a.service.BbaStoreSerivce;


@Service
public class BbaStoreServiceImpl implements BbaStoreSerivce {
	
	@Autowired
	BbaStoreDao bbaStoreDao;

	@Override
	public int registerStore(Bb_StoreDto bsdto) {
		return bbaStoreDao.registerStore(bsdto);
		
	}

	@Override
	public List<Bb_StoreDto> GetStoreList() {
		// TODO Auto-generated method stub
		return bbaStoreDao.GetStoreList();
	}
	
	

}
