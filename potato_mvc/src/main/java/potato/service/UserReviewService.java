package potato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import potato.dao.UserReviewDAO;
import potato.domain.MyPageReportDomain;
import potato.domain.MyReviewDomain;
import potato.vo.MyPageMyReviewVO;
import potato.vo.MyReviewVO;
import potato.vo.MypageLikeReviewVO;
import potato.vo.MypageReportVO;

@Component
public class UserReviewService {
	
	@Autowired(required = false)
	private UserReviewDAO urDAO;
	
///////////////////�׺��////////////////////	
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
///////////////////����ڸ�����ȸ////////////////////	
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

/////���ƿ�/////	
	//���� ���ƿ� �߰�
	public String getLikeAdd(MypageLikeReviewVO mplrVO) {
		String addlike=urDAO.insertLikeAdd(mplrVO);
		return addlike;
	}
		
	//���� ���ƿ� ����
	public String getLikeDel(MypageLikeReviewVO mplrVO) {
		String delLike=urDAO.delLike(mplrVO);
		return delLike;
	}
	
/////�Ű�/////		
	//����ڽŰ� �˾�â ����
	public List<MyPageReportDomain> searchRevReport() {
		List<MyPageReportDomain> mprd=null;
		mprd=urDAO.selRevReport();
		return mprd;
	}

	//�Ű� ����
	public Integer setRevReport(MypageReportVO mprVO) {
		Integer revReport=0;
		revReport=urDAO.insertRevReport(mprVO);
		return revReport;
	}
	
	//�Ű� ���� ����
	public Integer searchRevReportChk(MypageReportVO mprVO) {
		Integer revReportChk=0;
		revReportChk=urDAO.selRevReportChk(mprVO);
		return revReportChk;
	}

/////����/////
	//���� ����â �̵�
	public MyReviewDomain searchRevEdit(MyPageMyReviewVO mpmrVO) {
		MyReviewDomain mrd=urDAO.selRevEdit(mpmrVO);
		return mrd;
	}
	
/////����/////		
	//���� ����
	public String getRevDel(MyPageMyReviewVO mpmrVO) {
		String delmyRev=null;
		delmyRev=urDAO.delmyRev(mpmrVO);
		return delmyRev;
	}
///////////////////����¡////////////////////		
	
	//������ ���� ��ü �Խù���
	public int searchTotalReview(MyReviewVO mrVO) {
		int cnt = urDAO.selTotalReview(mrVO);
		return cnt;
	}
	
	//���� ���ƿ��� ���� ��ü �Խù���
	public int searchTotalLikedReview(MyReviewVO mrVO) {
		int cnt = urDAO.selTotalLikedReview(mrVO);
		return cnt;
	}
	

	// ��������������
	public int lastPage(int totalReview) {
		int lastPage = (int) Math.ceil((double) totalReview / 5);
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
