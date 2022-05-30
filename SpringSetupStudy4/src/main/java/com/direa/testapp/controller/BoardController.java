package com.direa.testapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.direa.testapp.paging.PagingBean;
import com.direa.testapp.paging.PagingService;
import com.direa.testapp.service.IboardService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class BoardController {
	
	@Autowired
	public IboardService iboardService;
	
	@Autowired
	private PagingService pagingService;
	
	
	/**
	 * List View 이동 
	 * @param mav
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping (value = "bookList")
	public ModelAndView goList (ModelAndView mav) throws Throwable {
		mav.setViewName("bookList");
		return mav;
	}
	
	
	
	/**
	 * 글쓰기 View 이동
	 * @param mav
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value = "/aBookWrite")
	public ModelAndView getWrite (ModelAndView mav) throws Throwable{
		mav.setViewName("create");
		return mav;
	}
	
	
	
	
	/**
	 * 수정 View 이동
	 * @param mav
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value = "/aBookUpdate")
	public ModelAndView goUpdate (@RequestParam HashMap<String, String> params,
									 ModelAndView mav) throws Throwable{ 
		HashMap<String, String> data = iboardService.getBook(params);
		mav.addObject("data", data);
		mav.setViewName("update");
		return mav;
	}
	
	
	
	
	
	
	/**
	 * getList data
	 * @param params
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value = "aBookListAjax", method = RequestMethod.GET,  produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String getList(@RequestParam HashMap<String,String> params) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();

		Map<String, Object> modelMap = new HashMap<String, Object>();
		
		//전체 글 개수	
		int cnt = iboardService.getCnt();
		
		//PagingBean 사용하기
		PagingBean pb 
		= pagingService.getPagingBean(Integer.parseInt(params.get("page")), cnt, 10, 5);
		System.out.println("check");
		
		
		params.put("startCount", Integer.toString(pb.getStartCount())); 
		params.put("endCount", Integer.toString(pb.getEndCount()));
	
		
		//리스트 데이터 받아오기
		List<HashMap<String,String>> list = iboardService.getBookList(params);
		
		
		//데이터 보내기
		modelMap.put("list", list);
		modelMap.put("pb", pb);
		
		return mapper.writeValueAsString(modelMap);
	}
	

	
	/**
	 * getDetail 
	 * @param params
	 * @param mav
	 * @return
	 * @throws Throwable
	 */
	// getDetail
	@RequestMapping(value = "/aBook")
	public ModelAndView getDetail (@RequestParam HashMap<String, String> params,
						       ModelAndView mav) throws Throwable {
		
		HashMap<String, String> data = iboardService.getBook(params);
		
		mav.addObject("data", data);
	
		mav.setViewName("detail");
		return mav;
	}
	

	/**
	 * Create & Update & Delete Process
	 * @param params
	 * @param gbn
	 * @return
	 * @throws Throwable
	 * 
	 */
	
	@RequestMapping(value = "/aBookAction/{gbn}", method = RequestMethod.POST,  produces = "text/json;charset=UTF-8")
	@ResponseBody 
	public String abookProcess(@RequestParam HashMap<String, String> params,
							   @PathVariable String gbn) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		
		Map<String, Object> modelMap = new HashMap<String, Object>();
		
		try {
			switch(gbn) {
			case "insert" :
				iboardService.bookWrite(params);
				break;
			case "update" :
				iboardService.bookUpdate(params);
				break;
			case "delete" :
				iboardService.bookDelete(params);
				break;
			}
			modelMap.put("res", "success");
		}catch (Throwable e) {
			e.printStackTrace();
			modelMap.put("res", "failed");
		}
		
		return mapper.writeValueAsString(modelMap);
	}
	
	
}
