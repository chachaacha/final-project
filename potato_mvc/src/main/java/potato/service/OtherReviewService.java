package potato.service;

import java.util.List;

import potato.domain.OtherReviewUserDomain;
import potato.manager.domain.ReviewDomain;
import potato.manager.vo.SearchReviewVO;
import potato.vo.OtherReviewLikeVO;
import potato.vo.OtherReviewVO;

public class OtherReviewService {
	
	//Ÿ�����������
	public OtherReviewUserDomain searchOtherUser(String id) {
		return null;
	}
	
	//���� ��
	public int searchReviewCnt(String id) {
		return 0;
	}
	
	//������ȸ
	public List<ReviewDomain> searchReviewAll(OtherReviewVO orVO){
		return null;
	}

	//����¡
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
	
	//���ƿ� ��
	public int searchLikeCnt(OtherReviewLikeVO orlVO) {
		return 0;
	}
	
}
