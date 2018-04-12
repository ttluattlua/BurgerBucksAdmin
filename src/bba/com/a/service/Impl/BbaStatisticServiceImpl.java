package bba.com.a.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bba.com.a.dao.BbaStatisticDao;
import bba.com.a.service.BbaStatisticService;

@Service
public class BbaStatisticServiceImpl implements BbaStatisticService {

	@Autowired
	BbaStatisticDao bbaStatisticDao;

	@Override
	public int getMemberCounts() {

		return bbaStatisticDao.getMemberCounts();
	}

	@Override
	public int getStoreCounts() {
		return bbaStatisticDao.getStoreCounts();
	}

	@Override
	public int getPreviousMonthProfit() {

		return bbaStatisticDao.getPreviousMonthProfit();
	}

	@Override
	public int getPreviousMonthOrderCounts() {

		return bbaStatisticDao.getPreviousMonthOrderCounts();
	}
	
	
	

}
