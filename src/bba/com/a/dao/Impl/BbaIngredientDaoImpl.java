package bba.com.a.dao.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bba.com.a.dao.BbaIngredientDao;

@Repository
public class BbaIngredientDaoImpl implements BbaIngredientDao {

	@Autowired
	SqlSessionTemplate sqlSession;
	
	String ns = "BBAIngredient.";
}
