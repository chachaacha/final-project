package potato.dao;

import java.util.List;

import potato.domain.DetailedAmenityDomain;
import potato.domain.DetailedDomain;
import potato.domain.DetailedFoodDomain;
import potato.domain.DetailedReportDomain;
import potato.domain.DetailedReviewDomain;
import potato.vo.DetailedBookmarkVO;
import potato.vo.DetailedLikeVO;
import potato.vo.DetailedReportVO;
import potato.vo.DetailedReviewVO;

public class DetailedDAO {
	
	//<�ްԼ� ��â>
	//�ްԼ� ��â ���� �ҷ�����
	public DetailedDomain selectRestDetailed(int restarea_idx) {
		return null;
	}
	
	//�ްԼ� �ϸ�ũ total
	public int selectBookmarkTotal(int restarea_idx) {
		return 0;
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
		return 0;
	}
	
	//�ްԼ� ���� ����
	public List<DetailedFoodDomain> selectFoodDatailed(int restarea_idx) {
		return null;
	}
	
	//�ްԼ� ���ǽü�������
	public List<DetailedAmenityDomain> selectAmenityImg(int restarea_idx) {
		return null;
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
		return 0;
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
