package potato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import potato.dao.OtherReviewDAO;
import potato.domain.OtherReviewDomain;
import potato.domain.OtherReviewUserDomain;
import potato.manager.domain.ReviewDomain;
import potato.manager.vo.SearchReviewVO;
import potato.vo.OtherReviewLikeVO;
import potato.vo.OtherReviewVO;

@Component
public class OtherReviewService {
	
	@Autowired(required = false)
	private OtherReviewDAO orDAO;
	
	//Ÿ�����������
	public OtherReviewUserDomain searchOtherUser(String id) {
		return null;
	}
	
	// ��ü �Խù���
	public int searchTotalReview(SearchReviewVO srVO) {
		int cnt = orDAO.selectTotalReview(srVO);
		return cnt;
	}

	// ��������������
	public int lastPage(int totalReview) {
		int lastPage = (int) Math.ceil((double) totalReview / 10);
		return lastPage;
	}

	// ������������ ���۹�ȣ
	public int startNum(int curPage) {
		int startNum = curPage - (curPage - 1) % 3; // 3�������������ش�
		return startNum;
	}

	// �� �������� ������ ��������, ���� ���������̺��� ���ٸ� �ٽð��
	public int isLast(int lastPage, int startNum) {
		int isLast = 2; // 3������ �� 0,1,2
		if (startNum + 3 > lastPage) {
			isLast = lastPage - startNum;
		}
		return isLast;
	}
	
}
