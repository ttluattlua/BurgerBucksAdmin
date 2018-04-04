package bba.com.a.dao.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bba.com.a.dao.BbaMenuDao;


@Repository
public class BbaMenuDaoImpl implements BbaMenuDao {
	
	@Autowired
	SqlSessionTemplate sqlSession;
	
	String ns = "BBAMenu.";
}
