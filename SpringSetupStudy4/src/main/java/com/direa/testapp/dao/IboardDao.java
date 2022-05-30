package com.direa.testapp.dao;

import java.util.HashMap;
import java.util.List;

public interface IboardDao {

	public List<HashMap<String, String>> getBookList(HashMap<String, String> params) throws Throwable;
	public HashMap<String, String> getBook(HashMap<String, String> params) throws Throwable;
	public int getCnt() throws Throwable;
	public void bookWrite(HashMap<String, String> params)throws Throwable;
	public int bookUpdate(HashMap<String, String> params)throws Throwable;
	public void bookDelete(HashMap<String, String> params) throws Throwable;
}
