package com.direa.testapp.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao implements IboardDao {
	
	@Autowired
	public SqlSession sqlSession;

	@Override
	public HashMap<String, String> getBook(HashMap<String, String> params) throws Throwable {
		return sqlSession.selectOne("book.getBook", params);	
	}

	@Override
	public int getCnt() throws Throwable {
		return sqlSession.selectOne("book.getCnt", null);
	}

	@Override
	public void bookWrite(HashMap<String, String> params) throws Throwable {
		sqlSession.insert("book.bookWrite", params);
	}

	@Override
	public int bookUpdate(HashMap<String, String> params) throws Throwable {
		return sqlSession.update("book.bookUpdate", params);
	}

	@Override
	public void bookDelete(HashMap<String, String> params) throws Throwable {
		sqlSession.delete("book.bookDelete", params);
	}

	@Override
	public List<HashMap<String, String>> getBookList(HashMap<String, String> params) throws Throwable {
		return sqlSession.selectList("book.getBookList", params);
	}


}
