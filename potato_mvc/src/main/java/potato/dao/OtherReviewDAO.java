package potato.dao;

import java.util.List;

import potato.domain.OtherReviewReportDomain;
import potato.domain.OtherReviewUserDomain;
import potato.manager.domain.ReviewDomain;
import potato.vo.OtherReviewLikeVO;
import potato.vo.OtherReviewVO;

public class OtherReviewDAO {
	
	//Ÿ����� ����
	public OtherReviewUserDomain  selectOtherUser(String id) {
		return null;
	}
	
	//����ڸ���Ǽ�
	public int selectReviewCnt(String id) {
		return 0;
	}
	
	//��ü������ȸ
	public List<ReviewDomain> selectReviewAll(OtherReviewVO orVO){
		return null;
	}

	//����¡ó��
	public int selectTotalReview(OtherReviewLikeVO lVO) {
		return 0;
	}
	
	//���ƿ� ��
	public int selectLikeCnt(OtherReviewLikeVO lVO) {
		return 0;
	}
	
	//�Ű� â�̵�
	public OtherReviewReportDomain selectReportOption() {
		return null;
	}
	 

}
