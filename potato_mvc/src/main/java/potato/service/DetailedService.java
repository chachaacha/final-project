package potato.service;

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

public class DetailedService {

	//<�ްԼ� ��â>
	//�ްԼ� ��â ���� �ҷ�����
	public DetailedDomain getRestDetailed(int restarea_idx) {
		return null;
	}
	
	//�ްԼ� �ϸ�ũ total
	public int getBookmarkTotal(int restarea_idx) {
		return 0;
	}
	
	//�ްԼ� �ϸ�ũ ����
	public int getBookmarkChk(DetailedBookmarkVO dbVO) {
		return 0;
	}
	
	//�ްԼ� �ϸ�ũ �߰� (�񵿱�)
	public int setBookmarkAdd(DetailedBookmarkVO dbVO) {
		return 0;
	}
	
	//�ްԼ� �ϸ�ũ ���� (�񵿱�)
	public int setBookmarkDel(DetailedBookmarkVO dbVO) {
		return 0;
	}
	
	//�ްԼ� ���� total
	public int getRateTotal(int restarea_idx) {
		return 0;
	}
	
	//�ްԼ� ���� ����
	public List<DetailedFoodDomain> getFoodDatailed(int restarea_idx) {
		return null;
	}
	
	//�ްԼ� ���ǽü�������
	public List<DetailedAmenityDomain> getAmenityImg(int restarea_idx) {
		return null;
	}
	
	//<�ްԼ� ����>
	//���� �ۼ�â �̵�
	public DetailedReviewDomain moveReviewWrite(int restarea_idx) {
		return null;
	}
	
	//���� ����â �̵�
	public DetailedReviewDomain moveReReviewWrite(DetailedReviewVO drVO) {
		return null;
	}
	
	//���� �� total
	public int getReviewTotal(int restarea_idx) {
		return 0;
	}
	
	//���� ��ȸ(�񵿱�)
	public List<DetailedReviewDomain> getReviewAll(DetailedReviewVO drVO) {
		return null;
	}
	
	//����¡ ó�� ���� 
	public int getStartPageNum() {
		return 0;
	}
	
	//����¡ ������ ������
	public int getLastPageNum(int total) {
		return 0;
	}
	
	//����¡ �⺻ ������ ��
	public int getPageScale() {
		return 0;
	}
	
	//Ÿ����� ������ �̵�
	public DetailedReviewDomain moveOtherProfile(String id) {
		return null;
	}
	
	//���� ���ƿ� total
	public int getLikeTotal(DetailedLikeVO dlVO) {
		return 0;
	}
	
	//���� ���ƿ� �߰�
	public int getLikeAdd(DetailedLikeVO dlVO) {
		return 0;
	}
	
	//���� ���ƿ� ����
	public int getLikeDel(DetailedLikeVO dlVO) {
		return 0;
	}
	
	//���� ����
	public int getReviewDel(DetailedReviewVO drVO) {
		return 0;
	}
	
	//<�Ű�â>
	//�Ű�â ����
	public List<DetailedReportDomain> getReportPopup() {
		return null;
	}
	
	//�Ű� ����
	public int setReportPopup(DetailedReportVO drVO) {
		return 0;
	}
	
}
