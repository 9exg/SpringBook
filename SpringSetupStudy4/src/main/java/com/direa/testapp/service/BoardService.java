package com.direa.testapp.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.direa.testapp.dao.IboardDao;

@Service
public class BoardService implements IboardService{
	
	@Autowired
	public IboardDao iboardDao;

	@Override
	public List<HashMap<String, String>> getBookList(HashMap<String, String> params) throws Throwable {
		return iboardDao.getBookList(params);
	}

	@Override
	public HashMap<String, String> getBook(HashMap<String, String> params) throws Throwable {
		return iboardDao.getBook(params);
	}

	@Override
	public int getCnt() throws Throwable {
		return iboardDao.getCnt();
	}

	@Override
	public void bookWrite(HashMap<String, String> params) throws Throwable {
		iboardDao.bookWrite(params);
	}

	@Override
	public int bookUpdate(HashMap<String, String> params) throws Throwable {
		return iboardDao.bookUpdate(params);
	}

	@Override
	public void bookDelete(HashMap<String, String> params) throws Throwable {
		iboardDao.bookDelete(params);
		
	}

}
