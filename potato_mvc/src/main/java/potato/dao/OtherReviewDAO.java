package potato.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import potato.dao.config.MyBatisHandler;
import potato.domain.OtherReviewReportDomain;
import potato.domain.OtherReviewUserDomain;
import potato.manager.domain.ReviewDomain;
import potato.vo.OtherReviewLikeVO;
import potato.vo.OtherReviewVO;

public class OtherReviewDAO {
	
	/**
	 * ����� �г���,�������̹��� ��ȸ
	 * @param id
	 * @return
	 */
	public OtherReviewUserDomain selOtherInfo(String id) {
		OtherReviewUserDomain orud=null;
		
	MyBatisHandler mbh = MyBatisHandler.getInstance();
	SqlSession ss = mbh.getHandler();
	orud = ss.selectOne("potato.otherReview.selOtherInfo", id);
	mbh.closeHandler(ss);
		
		return orud;
	}//selotherInfo
	
	/**
	 * ����� ���� ��
	 * @param id
	 * @return
	 */
	public int selRevCnt(String id) {
		int revCnt=0;
		
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		revCnt = ss.selectOne("potato.otherReview.selRevCnt", id);
		mbh.closeHandler(ss);
		
		return revCnt;
	}//selRevCnt
	
	/**
	 * ����� ���� ��ȸ
	 * @param orVO
	 * @return
	 */
	public List<ReviewDomain> selRevAll(OtherReviewVO orVO){
		List<ReviewDomain> list= null;
		
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		list = ss.selectOne("potato.otherReview.selRevAll", orVO);
		mbh.closeHandler(ss);
		
		return list;
	}//selRevAll

}
