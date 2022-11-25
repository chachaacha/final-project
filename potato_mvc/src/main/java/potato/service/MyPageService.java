package potato.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import potato.dao.MyPageDAO;
import potato.domain.MyPageBookmarkDomain;
import potato.domain.MyPageMyInfoDomain;
import potato.domain.MyPageReportDomain;
import potato.domain.MyPageReviewDomain;
import potato.manager.domain.ReviewDomain;
import potato.vo.LoginVO;
import potato.vo.MyPageBookmarkVO;
import potato.vo.MyPageLikeVO;
import potato.vo.MyPageMyInfoEditVO;
import potato.vo.MyPageMyReviewVO;
import potato.vo.MyPagePwEditVO;
import potato.vo.MyPageQuitVO;
import potato.vo.MypageReportVO;

@Component
public class MyPageService {
	@Autowired(required = false)
	private MyPageDAO mDAO;
	
	//���������� ����
	public String searchMyPageIn(String id) {
		String sl=null;
		sl=mDAO.selectLogin(id);
		return sl;
	}//searchMyPageIn
	
	//�� ���� ��ȸ
	public List<MyPageMyInfoDomain>searchInfo(String id) {
		List<MyPageMyInfoDomain>mid=null;
		mid=mDAO.selectInfo(id);
		return mid;
	}//searchInfo
	
	//���̵�,��й�ȣ Ȯ��
	public boolean searchMember(LoginVO lVO) {
		
		return false;
	}//searchMember
	
	//�� ���� ����
	public int updateInfo(MyPageMyInfoEditVO mieVO) {
		int updateInfoCnt=0;
		updateInfoCnt=mDAO.updateInfo(mieVO);
		
		return updateInfoCnt; 
	}//updateInfo
	
	//��й�ȣ ���� ó��
	//���� �����̱� ������ forward���ٴ� redirect�� ó�����ִ� ���� ����.
	
	public int modifyPw(MyPagePwEditVO peVO) {
		int updateCnt=0;
		updateCnt=mDAO.updatePw(peVO);
		return updateCnt;
	}//modifyPw
	
	//ȸ��Ż��
	public int updateQuit(MyPageQuitVO qVO) {
		int quitCount=0;
		quitCount=mDAO.updateQuit(qVO);
		return quitCount;
	}//updateQuit
	
	//ȸ��Ż�� ó��
	//public String quitProcess(HttpSession session, MyPageQuitVO qVO) {
		//Ż�� ó���� �Ϸ�Ǹ� �������� �̵���Ű��
		//return null;
//	}//quitProcess
	
	
	//�ϸ�ũ�� �ްԼ� ��ȸ
	public List<MyPageBookmarkDomain>searchBookmark(String id){
		List<MyPageBookmarkDomain> mbd=null;
		mbd=mDAO.selectBookmark(id);
		return mbd;
	}//searchBookmark
	
	//�ϸ�ũ�� �ްԼ� ����(���̵�, �ްԼ� �ε���-int)
	public int removeBookmark(HttpSession session, MyPageBookmarkVO bVO) {
		int cnt=mDAO.delBookmark(bVO);
		return cnt;
	}//removeBookmark
	
	
}//class
