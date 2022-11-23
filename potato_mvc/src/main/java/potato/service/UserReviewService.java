package potato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import potato.dao.UserReviewDAO;
import potato.domain.MyReviewDomain;
import potato.domain.OtherReviewDomain;
import potato.vo.MyReviewVO;
import potato.vo.OtherReviewVO;

@Component
public class UserReviewService {
	
	@Autowired(required = false)
	private UserReviewDAO urDAO;
///////////////////Ÿ����ڸ�����ȸ////////////////////
	
	//������̹���
	public String searchOtherImg(OtherReviewVO orVO){
		String  img = urDAO.selOtherImg(orVO);
		return img;
	}
	
	//����ڴ�
	public String searchOtherNick(OtherReviewVO orVO){
		String  nick = urDAO.selOtherNick(orVO);
		return nick;
	}
	
	//������ȸ
	public List<OtherReviewDomain> searchOtherRevAll(OtherReviewVO orVO){
		List<OtherReviewDomain> list = urDAO.selOtherRevAll(orVO);
		return list;
	}
	
	//��ü�����
	public int searchOtherRev(OtherReviewVO orVO) {
		int otherRev=urDAO.selOtherRev(orVO);
		return otherRev;
	}//searchOtherRev
	

///////////////////����ڸ�����ȸ////////////////////	
	
	//������̹���
	public String searchMyImg(MyReviewVO mrVO){
		String  img = urDAO.selMyImg(mrVO);
		return img;
	}
	
	//����ڴ�
	public String searchMyNick(MyReviewVO mrVO){
		String  nick = urDAO.selMyNick(mrVO);
		return nick;
	}
	
	//My������ȸ
	public List<MyReviewDomain> searchMyRevAll(MyReviewVO mrVO){
		List<MyReviewDomain> mlist = urDAO.selMyRevAll(mrVO);
		return mlist;
	}

///////////////////���ƿ��Ѹ�����ȸ////////////////////
	
	//Like������ȸ
	public List<MyReviewDomain> searchLikeRevAll(MyReviewVO mrVO){
		List<MyReviewDomain> llist = urDAO.selLikeRevAll(mrVO);
		return llist;
	}

///////////////////����¡////////////////////		
	
	//��ü �Խù���
	public int searchTotalReview(MyReviewVO mrVO) {
		int cnt = urDAO.selTotalReview(mrVO);
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
