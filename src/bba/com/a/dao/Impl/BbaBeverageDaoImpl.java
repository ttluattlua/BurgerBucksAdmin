package bba.com.a.dao.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bba.com.a.dao.BbaBeverageDao;

@Repository
public class BbaBeverageDaoImpl implements BbaBeverageDao {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	String ns = "BBABeverage.";
}
