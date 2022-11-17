package potato.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import potato.dao.config.MyBatisHandler;
import potato.domain.MyPageBookmarkDomain;
import potato.domain.MyPageMyInfoDomain;
import potato.domain.MyPageReportDomain;
import potato.manager.domain.ReviewDomain;
import potato.vo.MyPageBookmarkVO;
import potato.vo.MyPageLikeVO;
import potato.vo.MyPageMyInfoEditVO;
import potato.vo.MyPageMyReviewVO;
import potato.vo.MyPagePwEditVO;
import potato.vo.MyPageQuitVO;
import potato.vo.MypageLikeReviewVO;
import potato.vo.MypageReportVO;

public class MyPageDAO {
	
	//���������� ����
	public String selectLogin(String id) {
		//1. MyBatis Handler ���
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		//2. ������ ����
		//3. MyBatis Handler ����
		return null;
	}//selectLogin
	
	//�� ���� ��ȸ
	public MyPageMyInfoDomain selectInfo(MyPageMyInfoEditVO mieVO) {
		
		//1. MyBatis Handler ���
		//2. ������ ����
		//3. MyBatis Handler ����
		return null;
	}//selectInfo
	
	//�� ���� ����
	public int updateInfo(MyPageMyInfoEditVO mieVO) {
		//1. MyBatis Handler ���
		//2. ������ ����
		//3. MyBatis Handler ����
		return 0;
	}//updateInfo
	
	//��й�ȣ ����
	public int updatePw(MyPagePwEditVO peVO) {
		//1. MyBatis Handler ���
		//2. ������ ����
		//3. MyBatis Handler ����
		return 0;
	}//updatePw
	
	//ȸ�� Ż��
	public int updateQuit(MyPageQuitVO qVO) {
		//1. MyBatis Handler ���
		//2. ������ ����
		//3. MyBatis Handler ����
		return 0;
	}//updateQuit
	
	//���� ��ȸ
	public List<ReviewDomain> selectMyReview(String id){
		//1. MyBatis Handler ���
		//2. ������ ����
		//3. MyBatis Handler ����
		return null;
	}//selectMyReview
	
	//�� ���� ��
	public int selectMyReviewCnt(String string) {
		//1. MyBatis Handler ���
		//2. ������ ����
		//3. MyBatis Handler ����
		return 0;
	}//selectMyReviewCnt
	
	//�� ���� - ���ƿ� �� 
	public int selectLikeCnt(String string) {
		//1. MyBatis Handler ���
		//2. ������ ����
		//3. MyBatis Handler ����
		return 0;
	}//selectLikeCnt
	
	//�� ���� - ���� ����, ����
	public int updateMyReview(MyPageMyReviewVO mrVO) {
		//1. MyBatis Handler ���
		//2. ������ ����
		//3. MyBatis Handler ����
		return 0;
	}//updateMyReview
	
	//���ƿ� �� ���� ��ȸ
	public List<ReviewDomain>selectLikeReview(MypageLikeReviewVO lrVO){
		return null;
	}//selectLikeReview
	
	//���ƿ� �� ���� ��
	public int selectLikeReviewCnt(MypageLikeReviewVO lrVO) {
		return 0;
	}//selectLikeReviewCnt
	
	//���ƿ��� ���� :���ƿ� �� ��ȸ
	public int selectLikeCnt(MypageLikeReviewVO lrVO) {
		return 0;
	}//selectLikeCnt
	
	//���ƿ��� ���� : ���ƿ� �߰�
	public void insertLike(MyPageLikeVO lVO) {
		
	}//insertLike
	
	//���ƿ��� ���� : ���ƿ� ���
	public int delLike(MyPageLikeVO lVO) {
		return 0;
	}//delLike
	
	//���ƿ��� ���� - �Ű�â �˾�
	public MyPageReportDomain selectReportPopup() {
		return null;
	}//selectReportPopup
	
	//���ƿ��� ���� - �Ű��ϱ�
	public void insertReviewReport(MypageReportVO rVO) {
		
	}//insertReviewReport
	
	//�ϸ�ũ�� �ްԼ� ��ȸ
	public List<MyPageBookmarkDomain> selectBookmark(String id){
		List<MyPageBookmarkDomain> list=null;
		//1. MyBatis Handler ���
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		//2. ������ ����
		list=ss.selectList("potato.bookmark.selectBookmark", id);
		//3. MyBatis Handler ����
		mbh.closeHandler(ss);
		
		return list;
	}//selectBookmark
	
	//�ϸ�ũ�� �ްԼ� ����(���̵�, �ްԼ� �ε���)(String id�� restrea_idx�� bookmarkVO��..)
	public int delBookmark(MyPageBookmarkVO bVO) {
		//1. MyBatis Handler ���
		//2. ������ ����
		//3. MyBatis Handler ����
		return 0;
	}//delBookmark
	
}//class
