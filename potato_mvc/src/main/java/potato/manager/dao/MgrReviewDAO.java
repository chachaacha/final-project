package potato.manager.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import potato.dao.config.MyBatisHandler;
import potato.manager.domain.ReviewDomain;
import potato.manager.vo.ReviewVO;
import potato.manager.vo.SearchReviewVO;

@Component
public class MgrReviewDAO {
	
	/**
	 * ����ҷ�����
	 * @param srVO
	 * @return
	 */
	public List<ReviewDomain> selectReview(SearchReviewVO srVO) {
		List<ReviewDomain> list = null;
		
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		list = ss.selectList("potato.manager.review.selectReview", srVO);
		mbh.closeHandler(ss);
		
		return list;
	}
	
	/**
	 * �� �Խù� ���� ���ϱ�
	 * @param srVO
	 * @return
	 */
	public int selectTotalReview(SearchReviewVO srVO) {
		int cnt = 0;
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		cnt = ss.selectOne("potato.manager.review.selectTotalReview", srVO);
		
		return cnt;
	}
	
	/**
	 * AJAX �˻��� ������
	 * @param keyword
	 * @return
	 */
	public List<String> selectKeywordList(String keyword) {
		
		return null;
	}
	
	/**
	 * �������� �������
	 * @param list
	 * @return
	 */
	public int deleteMultipleReview(List<ReviewVO> list) {
		int cnt=0;
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		cnt = ss.delete("potato.manager.review.deleteMultipleReviews", list);
		if(list.size() == cnt) {
			ss.commit();
		} else {
			ss.rollback();
		}
		return cnt;
	}
	
	/**
	 * �����â ������
	 * @param rVO
	 * @return
	 */
	public ReviewDomain selectReviewDetail(ReviewVO rVO) {
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		ReviewDomain rd = ss.selectOne("potato.manager.review.selectReviewDetail", rVO);
		return rd;
	}
	
	/**
	 * �� ���� ���並 ����
	 * @param rVO
	 * @return
	 */
	public int deleteReview(ReviewVO rVO) {
		int cnt = 0;
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		cnt = ss.delete("potato.manager.review.deleteSingleReview",rVO);
		if(cnt == 1) {
			ss.commit();
		} else {
			ss.rollback();
		}
		return cnt;
	}
	
	
}
