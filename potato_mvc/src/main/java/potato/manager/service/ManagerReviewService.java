package potato.manager.service;

import java.util.List;

import potato.manager.domain.ReviewDomain;
import potato.manager.vo.ReviewVO;
import potato.manager.vo.SearchReviewVO;

public class ManagerReviewService {
	
	public List<ReviewDomain> searchReview() {
		
		return null;
	}
	
	public int searchTotalReview(SearchReviewVO srVO) {
		
		return 0;
	}
	
	public int lastPage(int totalReview) {
		
		return 0;
	}
	
	public int startNum(int curPage) {
		
		return 0;
	}
	
	//���� ���ϴ� ������ ������ ���� ���� �ְ� ���࿡ �ʰ��� ��� isLast�� �Ű������� ���� set
	public int isLast(int lastPage, int startNum) {
		
		return 0;
	}
	
	public List<String> searchKeywordList(String keyword) {
		
		return null;
	}
	
	public int removeReviews(String[] revIdxArr ) {
		
		return 0;
	}
	
	public ReviewDomain searchReviewDetail(ReviewVO rVO) {
		
		return null;
	}
	
	public int removeReview(ReviewVO rVO) {
		
		return 0;
	}
	
	
}
