package potato.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import potato.domain.MyPageBookmarkDomain;
import potato.domain.MyPageReportDomain;
import potato.domain.MyPageReviewDomain;
import potato.manager.domain.ReviewDomain;
import potato.vo.LoginVO;
import potato.vo.MyPageLikeVO;
import potato.vo.MyPageMyInfoEditVO;
import potato.vo.MyPageMyReviewVO;
import potato.vo.MyPagePwEditVO;
import potato.vo.MyPageQuitVO;
import potato.vo.MypageReportVO;

public class MyPageService {
	
	//���������� ����
	public String searchMyPageIn(String id) {
		
		return null;
	}//searchMyPageIn
	
	//�� ���� ��ȸ
	public String searchInfo(String id) {
		
		return null;
	}//searchInfo
	
	//���̵�,��й�ȣ Ȯ��
	public boolean searchMember(LoginVO lVO) {
		
		return false;
	}//searchMember
	
	//�� ���� ����
	public int updateInfo(MyPageMyInfoEditVO mieVO) {
		
		return 0; 
	}//updateInfo
	
	//��й�ȣ ���� ó��
	public int modifyPw(MyPagePwEditVO peVO) {
		return 0;
	}//modifyPw
	
	//ȸ��Ż��
	public int updateQuit(MyPageQuitVO qVO) {
		return 0;
	}//updateQuit
	
	//ȸ��Ż�� ó��
	public String quitProcess(HttpSession session, MyPageQuitVO qVO) {
		return null;
	}//quitProcess
	
	//������ȸ 
	public String searchMyReview(List<MyPageReviewDomain> list) {
		return null;
	}//searchMyReview
	
	//�� ���� ��
	public int searchMyReviewCnt(String id) {
		return 0;
	}//searchMyReviewCnt
	
	//���ƿ� ��
	public int searchLikeCnt(MyPageLikeVO lVO) {
		return 0;
	}//searchLikeCnt
	
	//�� ���� ����, ����
	public int updateMyReview(MyPageMyReviewVO mrVO) {
		return 0;
	}//updateMyReview
	
	//����¡(������ ����)
	//���� ���ϴ� ������ ������ ���� ���� �ְ� ���࿡ �ʰ��� ��� isLast�� �Ű������� ���� set
		public int isLast(int lastPage, int startNum) {
			
			return 0;
		}
	public int searchLikeReview(MyPageMyReviewVO rVO) {
		return 0;
	}//searchLikeReview
		
	//���ƿ��� ���� ��ȸ
	public List<ReviewDomain> searchLikeReview(String id){
		return null;
	}//searchLikeReview
	
	//���� ��
	public int searchLikeReviewCnt(String id) {
		return 0;
	}//searchLikeReviewCnt
	
	//���ƿ� �� ��ȸ
	public int searchLikeCnt(String id) {
		return 0;
	}//searchLikeCnt
	
	//���ƿ� �߰�
	public void addLike(MyPageLikeVO lVO) {
		
	}//addLike
	
	//���ƿ� ���
	public int delLike(MyPageLikeVO lVO) {
		return 0;
	}//delLike
	
	//�Ű�â �˾�(�̰� �³�,,,)
	public MyPageReportDomain reportPopup() {
		return null;
	}//MyPageReportDomain
	
	//�Ű��ϱ�(ó������)
	public String reportReview(MypageReportVO rVO) {
		return null;
	}//reportReview
	
	//�ϸ�ũ�� �ްԼ� ��ȸ
	public List<MyPageBookmarkDomain>searchBookmark(String id){
		return null;
	}//searchBookmark
	
	//�ϸ�ũ�� �ްԼ� ����(���̵�, �ްԼ� �ε���-int)
	public int removeBookmark(String id, int restarea_idx) {
		return 0;
	}//removeBookmark
	
	
}//class
