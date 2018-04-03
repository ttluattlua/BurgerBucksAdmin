package bba.com.a.service;

import java.util.List;

import bba.com.a.model.Bb_StoreDto;

public interface BbaStoreSerivce {
	
	public int registerStore(Bb_StoreDto bsdto);
	
	public List<Bb_StoreDto> GetStoreList();

}
