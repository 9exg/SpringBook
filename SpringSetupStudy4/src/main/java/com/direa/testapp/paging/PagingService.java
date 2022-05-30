package com.direa.testapp.paging;
import org.springframework.stereotype.Service;


@Service
public class PagingService {


	//테이블 시작row
	public int getStartCount(int page, int viewCnt) {
		int startCount = 0;
		startCount = (page - 1) * viewCnt + 1;
		return startCount;
	}
	
	//테이블 종료row
	public int getEndCount(int page, int viewCnt) {
		int endCount = 0;
		endCount = page * viewCnt;
		return endCount;
	}
	
	//페이징 최대 크기
	public int getMaxPcount(int maxCount, int viewCnt) {
		int maxPcount = 0;
		
		if(maxCount % viewCnt > 0){
			maxPcount = (maxCount / viewCnt) + 1;
		} else {
			maxPcount = (maxCount / viewCnt);
		}
		
		if(maxCount == 0) {
			maxPcount = 1;
		}
		
		return maxPcount;
	}
	
	//현재페이지 기준 시작페이지
	public int getStartPcount(int page, int pageCnt) {
		int startPcount = 0;
		
		if(page % pageCnt == 0 ) {
			startPcount = page - pageCnt + 1;
		} else {
			startPcount = ((page / pageCnt) * pageCnt) + 1;
		}
		
		return startPcount;
	}
	
	//현재페이지 기준 종료페이지
	public int getEndPcount(int page, int maxCount, int viewCnt, int pageCnt) {
		int endPcount = 0;
		int maxPcount = getMaxPcount(maxCount, viewCnt);
		
		endPcount = getStartPcount(page, pageCnt) + pageCnt - 1;
		
		if(endPcount >= maxPcount){
			endPcount = maxPcount;
		}
		
		return endPcount;
	}
	
	//빈형식으로 취득
	public PagingDto getPagingBean(int page, int maxCount, int viewCnt, int pageCnt) {
		PagingDto pb = new PagingDto();
		
		pb.setStartCount(getStartCount(page, viewCnt));
		pb.setEndCount(getEndCount(page, viewCnt));
		pb.setMaxPcount(getMaxPcount(maxCount, viewCnt));
		pb.setStartPcount(getStartPcount(page, pageCnt));
		pb.setEndPcount(getEndPcount(page, maxCount, viewCnt, pageCnt));
		
		return pb;
	}
}
