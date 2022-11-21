package potato.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import potato.dao.config.MyBatisHandler;
import potato.domain.MyPageBookmarkDomain;
import potato.domain.MyPageMyInfoDomain;
import potato.domain.MyPageReportDomain;
import potato.manager.domain.ReviewDomain;
import potato.vo.LoginVO;
import potato.vo.MyPageBookmarkVO;
import potato.vo.MyPageLikeVO;
import potato.vo.MyPageMyInfoEditVO;
import potato.vo.MyPageMyReviewVO;
import potato.vo.MyPagePwEditVO;
import potato.vo.MyPageQuitVO;
import potato.vo.MypageLikeReviewVO;
import potato.vo.MypageReportVO;
@Component
public class MyPageDAO {
	
	//���������� ����
	public String selectLogin(String id) {
		String sl=null;
		//1. MyBatis Handler ���
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		//2. ������ ����
		sl=ss.selectOne("potato.mypageMapper.selectLogin");
		//3. MyBatis Handler ����
		mbh.closeHandler(ss);
		return sl;
	}//selectLogin
	
	//�� ���� ��ȸ
	public List<MyPageMyInfoDomain> selectInfo(String id) {
		List<MyPageMyInfoDomain> mid=null;
		//1. MyBatis Handler ���
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		//2. ������ ����
		mid=ss.selectList("potato.mypageMapper.selectMypageInfo", id);
		//3. MyBatis Handler ����
		mbh.closeHandler(ss);
		
		return mid;
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
		int cnt=0;
		//1. MyBatis Handler ���
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession session=mbh.getHandler();
		//2. ������ ����
		cnt=session.update("potato.mypageMapper.updatePw",peVO);
		
		if(cnt==1) {
			session.commit();
		}else {
			session.rollback();
		}
		//3. MyBatis Handler ����
		mbh.closeHandler(session);
		
		return cnt;
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
		return null;
	}//selectMyReview
	
	//�� ���� ��
	public int selectMyReviewCnt(String string) {
		return 0;
	}//selectMyReviewCnt
	
	//�� ���� - ���ƿ� �� 
	public int selectLikeCnt(String string) {
		return 0;
	}//selectLikeCnt
	
	//�� ���� - ���� ����, ����
	public int updateMyReview(MyPageMyReviewVO mrVO) {
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
		List<MyPageBookmarkDomain> mbd=null;
		//1. MyBatis Handler ���
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		//2. ������ ����
		//System.out.println(ss.selectList("potato.mypageMapper.selectBookmark", id)+"findMe");
		mbd=ss.selectList("potato.mypageMapper.selectBookmark", id);
		//3. MyBatis Handler ����
		mbh.closeHandler(ss);
		
		return mbd;
	}//selectBookmark
	
	//�ϸ�ũ�� �ްԼ� ����(���̵�, �ްԼ� �ε���)(String id�� restrea_idx�� bookmarkVO��..)
	public int delBookmark(MyPageBookmarkVO bVO) {
		int cnt=0;
		//1. MyBatis Handler ���
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		//2. ������ ����
		cnt=ss.delete("potato.mypageMapper.updateBookmark",bVO);
		ss.commit();
		//3. MyBatis Handler ����
		mbh.closeHandler(ss);
		return cnt;
	}//delBookmark
	
}//class
