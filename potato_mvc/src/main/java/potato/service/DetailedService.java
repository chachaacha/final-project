package potato.service;

import java.util.List;

import potato.domain.DetailedDomain;
import potato.domain.DetailedFoodDomain;
import potato.domain.DetailedReviewDomain;
import potato.vo.DetailedBookmarkVO;
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
	public void setBookmarkAdd(DetailedBookmarkVO dbVO) {
		
	}
	
	//�ްԼ� �ϸ�ũ ���� (�񵿱�)
	public void setBookmarkDel(DetailedBookmarkVO dbVO) {
		
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
	public String getAmenityImg(int restarea_idx) {
		return null;
	}
	
	//<�ްԼ� ����>
	//���� �ۼ�â �̵�
	public DetailedReviewVO moveReviewWrite(String id) {
		return null;
	}
	
	//���� ����â �̵�
	public DetailedReviewVO moveReReviewWrite(String id) {
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
	
	
	
}
