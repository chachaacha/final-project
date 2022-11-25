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
		sl=ss.selectOne("potato.mypageMapper.selectMyLogin");
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
		int updateInfoCnt=0;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		updateInfoCnt=ss.update("potato.mypageMapper.updateMypageInfo",mieVO);
		
		if(updateInfoCnt == 1 ) {
			ss.commit();
		}
		
		mbh.closeHandler(ss);
		return updateInfoCnt;
	}//updateInfo
	
	//��й�ȣ ����
	public int updatePw(MyPagePwEditVO peVO) {
		int updateCnt=0;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession session=mbh.getHandler();
		
		updateCnt=session.update("potato.mypageMapper.updatePw",peVO);
		
		if(updateCnt==1) { //���������� ������ Ŀ��
			session.commit();
		}else { //���������� ������
			session.rollback();
		}
		
		mbh.closeHandler(session);
		
		return updateCnt;
	}//updatePw
	
	//ȸ�� Ż��
	public int updateQuit(MyPageQuitVO qVO) {
		int quitCount=0;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession session=mbh.getHandler();
		
		quitCount=session.update("potato.mypageMapper.updateQuit",qVO);
		
		if(quitCount ==1) {
			session.commit();
			session.close();
		}
		mbh.closeHandler(session);
		return quitCount;
	}//updateQuit
	
	
	//�ϸ�ũ�� �ްԼ� ��ȸ
	public List<MyPageBookmarkDomain> selectBookmark(String id){
		List<MyPageBookmarkDomain> mbd=null;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		//System.out.println(ss.selectList("potato.mypageMapper.selectBookmark", id)+"findMe");
		mbd=ss.selectList("potato.mypageMapper.selectBookmark", id);
		
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
