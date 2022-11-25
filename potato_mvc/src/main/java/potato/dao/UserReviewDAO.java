package potato.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import potato.dao.config.MyBatisHandler;
import potato.domain.MyPageReportDomain;
import potato.domain.MyReviewDomain;
import potato.vo.MyPageMyReviewVO;
import potato.vo.MyReviewVO;
import potato.vo.MypageLikeReviewVO;
import potato.vo.MypageReportVO;

@Component
public class UserReviewDAO {
///////////////////�׺��////////////////////
	public String selMyImg(MyReviewVO mrVO) {
		String myImg = null;
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		myImg = ss.selectOne("potato.userReview.selMyImg", mrVO);
		mbh.closeHandler(ss);
		return myImg;
	}//selMyImg
	public String selMyNick(MyReviewVO mrVO) {
		String myNick = null;
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		myNick = ss.selectOne("potato.userReview.selMyNick", mrVO);
		mbh.closeHandler(ss);
		return myNick;
	}//selMyNick
	
///////////////////����ڸ�����ȸ////////////////////
	public List<MyReviewDomain> selMyRevAll(MyReviewVO mrVO){
		List<MyReviewDomain> mlist=null;
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler(); 
		
		System.out.println("-----mrVO DAO -"+ mrVO);
		mlist = ss.selectList("potato.userReview.selMyRevAll", mrVO);
		mbh.closeHandler(ss);
		return mlist;		
	}//selMyRevAll
	
///////////////////���ƿ��Ѹ�����ȸ////////////////////	
	public List<MyReviewDomain> selLikeRevAll(MyReviewVO mrVO){
		List<MyReviewDomain> llist=null;
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler(); 
		llist = ss.selectList("potato.userReview.selLikeRevAll", mrVO);
		mbh.closeHandler(ss);
		return llist;		
	}//selLikeRevAll
	
/////���ƿ�/////	
	//�������ƿ� ����
	public int selLikeChk(MypageLikeReviewVO mplrVO) {
		int likeChk=0;
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		likeChk=ss.selectOne("potato.userReview.selLikeChk",mplrVO);
		mbh.closeHandler(ss);
		return likeChk;
	}//selLikeChk
	
	//�������ƿ� �߰�
	public String insertLikeAdd(MypageLikeReviewVO mplrVO) {
		String addlike=null;
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		addlike=ss.selectOne("potato.userReview.insertLikeAdd",mplrVO);
		ss.commit();
		mbh.closeHandler(ss);
		return addlike;
	}//insertLikeAdd
		
	//���� ���ƿ� ����
	public String delLike(MypageLikeReviewVO mplrVO) {
		String delLike=null;
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		delLike=ss.selectOne("potato.userReview.delLike",mplrVO);
		ss.commit();
		mbh.closeHandler(ss);
		return delLike;
	}//delLike
	
/////�Ű�/////	
	//����ڽŰ� �˾�â ����
	public List<MyPageReportDomain> selRevReport() {
		List<MyPageReportDomain> mprd=null;
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		mprd=ss.selectList("potato.userReview.selRevReport");
		mbh.closeHandler(ss);
		return mprd;
	}//selRevReport
	
	//�Ű� ����
	public Integer insertRevReport(MypageReportVO mprVO) {
		Integer revReport=0;
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		revReport=ss.selectOne("potato.userReview.insertRevReport",mprVO);
		ss.commit();
		mbh.closeHandler(ss);
		return revReport;
	}//insertRevReport
	
	//�Ű� ���� ����
	public Integer selRevReportChk(MypageReportVO mprVO) {
		Integer revReportChk=0;
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		revReportChk=ss.selectOne("potato.userReview.selRevReportChk",mprVO);
		mbh.closeHandler(ss);
		return revReportChk;
	}//selRevReportChk
	
/////����/////
	public MyReviewDomain selRevEdit(MyPageMyReviewVO mpmrVO) {
		MyReviewDomain mrd=null;
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		mrd=ss.selectOne("potato.userReview.selRevEdit",mpmrVO);
		mbh.closeHandler(ss);
		return mrd;
	}//selRevEdit
	
/////����/////	
	//�������
	public String delmyRev(MyPageMyReviewVO mpmrVO) {
		String delmyRev=null;
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		delmyRev=ss.selectOne("potato.userReview.delmyRev",mpmrVO);
		ss.commit();
		mbh.closeHandler(ss);
		return delmyRev;
	}//delmyRev
	
///////////////////����¡////////////////////		
	//�� ���� ��
	public int selTotalReview(MyReviewVO mrVO) {
		int cnt = 0;
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		cnt = ss.selectOne("potato.userReview.selTotalReview", mrVO);
		return cnt;
	}//selTotalReview
	
	//���� ���ƿ��� �� �����
	public int selTotalLikedReview(MyReviewVO mrVO) {
		int cnt = 0;
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		cnt = ss.selectOne("potato.userReview.selTotalLikedReview", mrVO);
		return cnt;
	}

}//class
