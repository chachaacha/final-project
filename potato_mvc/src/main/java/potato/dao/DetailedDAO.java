package potato.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import potato.dao.config.MyBatisHandler;
import potato.domain.DetailedAmenityDomain;
import potato.domain.DetailedDomain;
import potato.domain.DetailedFoodDomain;
import potato.domain.DetailedReportDomain;
import potato.domain.DetailedReviewDomain;
import potato.vo.DetailedBookmarkVO;
import potato.vo.DetailedLikeVO;
import potato.vo.DetailedReportVO;
import potato.vo.DetailedReviewVO;

@Component
public class DetailedDAO {
	
	//<�ްԼ� ��â>
	//�ްԼ� ��â ���� �ҷ�����
	public DetailedDomain selectRestDetailed(int restarea_idx) {
		DetailedDomain dd=null;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		dd=ss.selectOne("potato.detailedMapper.selRestDetailed",restarea_idx);
		
		mbh.closeHandler(ss);
		
		return dd;
	}
	
	//�ްԼ� �ϸ�ũ total
	public int selectBookmarkTotal(int restarea_idx) {
		int booktotal=0;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		booktotal=ss.selectOne("potato.detailedMapper.selBookmarkToTal",restarea_idx);
		
		mbh.closeHandler(ss);
		
		return booktotal;
	}
	
	//�ްԼ� �ϸ�ũ ����
	public int selectBookmarkChk(DetailedBookmarkVO dbVO) {
		return 0;
	}
	
	//�ްԼ� �ϸ�ũ �߰�
	public int insertBookmarkAdd(DetailedBookmarkVO dbVO) {
		return 0;
	}
	
	//�ްԼ� �ϸ�ũ ����
	public int deleteBookmarkDel(DetailedBookmarkVO dbVO) {
		return 0;
	}
	
	//�ްԼ� ���� total
	public int selectRateTotal(int restarea_idx) {
		int startotal=0;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		startotal=ss.selectOne("potato.detailedMapper.selRateTotal",restarea_idx);
		
		mbh.closeHandler(ss);
		
		return startotal;
	}
	
	//�ްԼ� ���� ����
	public List<DetailedFoodDomain> selectFoodDatailed(int restarea_idx) {
		List<DetailedFoodDomain> dfd=null;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		dfd=ss.selectList("potato.detailedMapper.selFoodDatailed",restarea_idx);
		
		mbh.closeHandler(ss);
		
		return dfd;
	}
	
	//�ްԼ� ���ǽü�������
	public List<DetailedAmenityDomain> selectAmenityImg(int restarea_idx) {
		List<DetailedAmenityDomain> dad=null;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		dad=ss.selectList("potato.detailedMapper.selAmenityImg",restarea_idx);
		
		mbh.closeHandler(ss);
		
		return dad;
	}
	
	//<�ްԼ� ����>
	//���� �ۼ�â �̵�
	public DetailedReviewDomain selectReviewWrite(int restarea_idx) {
		return null;
	}
	
	//���� ����â �̵�
	public DetailedReviewDomain selectReReviewWrite(DetailedReviewVO drVO) {
		return null;
	}
	
	//���� �� total
	public int selectReviewTotal(int restarea_idx) {
		int reviewtotal=0;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		reviewtotal=ss.selectOne("potato.detailedMapper.selReviewTotal",restarea_idx);
		
		mbh.closeHandler(ss);
		
		return reviewtotal;
	}
	
	//���� ��ȸ
	public List<DetailedReviewDomain> selectReviewAll(DetailedReviewVO drVO) {
		return null;
	}
	
	//Ÿ����� ������ �̵�
	public DetailedReviewDomain selectOtherProfile(String id) {
		return null;
	}
	
	//���� ���ƿ� total X
	public int selectLikeTotal(DetailedLikeVO dlVO) {
		return 0;
	} 
	
	//���� ���ƿ� �߰�
	public int insertLikeAdd(DetailedLikeVO dlVO) {
		return 0;
	}
	
	//���� ���ƿ� ����
	public int deleteLikeDel(DetailedLikeVO dlVO) {
		return 0;
	}
	
	//���� ����
	public int deleteReviewDel(DetailedReviewVO drVO) {
		return 0;
	}
	
	//<�Ű�â>
	//�Ű�â ����
	public List<DetailedReportDomain> selectReportPopup() {
		return null;
	}
	
	//�Ű� ����
	public int insertReportPopup(DetailedReportVO drVO) {
		return 0;
	}
}
