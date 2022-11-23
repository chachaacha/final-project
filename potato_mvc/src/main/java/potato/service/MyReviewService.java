package potato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import potato.dao.MyReviewDAO;
import potato.domain.MyReviewDomain;
import potato.manager.vo.SearchReviewVO;
import potato.vo.MyReviewVO;
import potato.vo.OtherReviewVO;

@Component
public class MyReviewService {
	
	@Autowired(required = false)
	private MyReviewDAO mrDAO;
	
	//������̹���
	public String searchMyImg(MyReviewVO mrVO){
		String  img = mrDAO.selMyImg(mrVO);
		return img;
	}
	
	//����ڴ�
	public String searchMyNick(MyReviewVO mrVO){
		String  nick = mrDAO.selMyNick(mrVO);
		return nick;
	}
	
	//My������ȸ
	public List<MyReviewDomain> searchMyRevAll(MyReviewVO mrVO){
		List<MyReviewDomain> mlist = mrDAO.selMyRevAll(mrVO);
		return mlist;
	}
	
	//Like������ȸ
	public List<MyReviewDomain> searchLikeRevAll(MyReviewVO mrVO){
		List<MyReviewDomain> llist = mrDAO.selLikeRevAll(mrVO);
		return llist;
	}
	
	//��ü �Խù���
	public int searchTotalReview(MyReviewVO mrVO) {
		int cnt = mrDAO.selTotalReview(mrVO);
		return cnt;
	}

	// ��������������
	public int lastPage(int totalReview) {
		int lastPage = (int) Math.ceil((double) totalReview / 3);
		return lastPage;
	}

	// ������������ ���۹�ȣ
	public int startNum(int curPage) {
		int startNum = curPage - (curPage - 1) % 3; // 3�������������ش�
		return startNum;
	}

	// �� �������� ������ ������ ��, ������ ���������� ���ٸ� �ٽ� ���
	public int isLast(int lastPage, int startNum) {
		int isLast = 2; // 3������ �� 0,1,2
		if (startNum + 3 > lastPage) {
			isLast = lastPage - startNum;
		}
		System.out.println(startNum+" "+ lastPage +" "+ isLast);
		
		return isLast;
	}
	
}//class
