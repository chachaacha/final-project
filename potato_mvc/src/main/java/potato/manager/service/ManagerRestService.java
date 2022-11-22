package potato.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import potato.manager.dao.MgrRestDAO;
import potato.manager.domain.DoDomain;
import potato.manager.domain.FoodDomain;
import potato.manager.domain.LineDomain;
import potato.manager.domain.RestDomain;
import potato.manager.vo.AmenityVO;
import potato.manager.vo.FoodVO;
import potato.manager.vo.RestVO;
import potato.manager.vo.SearchRestVO;

@Component
public class ManagerRestService {
	@Autowired(required = false)
	private MgrRestDAO mrDAO;
	
	//�ްԼҰ�������
	public List<RestDomain> searchRest(SearchRestVO srVO) {
		List<RestDomain> list = mrDAO.selectRest(srVO);
		return list;
	}
	
	//�뼱��������
	public List<LineDomain> searchLine() {
		List<LineDomain> list = mrDAO.selectLine();
		return list;
	}
	
	//���ްԼҰ�������
	public int searchTotalRest(SearchRestVO srVO) {
		int totalReview = mrDAO.selectTotalRest(srVO);
		return totalReview;
	}
	
	//���������������ϱ�
	public int lastPage(int totalReview) {
		int lastPage = (int)Math.ceil((double)totalReview/10);
		return lastPage ;
	}
	
	//���� ���������� ����������
	public int startNum(int curPage) {
		int startNum = curPage-(curPage-1)%3;
		return startNum;
	}
	
	//���� ���ϴ� ������ ������ ���� ���� �ְ� ���࿡ �ʰ��� ��� isLast�� �Ű������� ���� set
	public int isLast(int lastPage, int startNum) {
		int isLast=2;
		if(startNum +3 > lastPage) {
			isLast = lastPage - startNum;
		}
		return isLast;
	}
	
	//�ްԼ� ��
	public RestDomain searchRestDetail(int restarea_idx) {
		RestDomain rd = mrDAO.selectRestDetail(restarea_idx);
		return rd;
	}
	
	//�ްԼһ�â�� ����â���û��
	public List<FoodDomain> searchRestFood(int restarea_idx) {
		List<FoodDomain> list = mrDAO.selectRestFood(restarea_idx);
		return list;
	}
	
	//����������
	public List<DoDomain> searchDo() {
		List<DoDomain> list = mrDAO.selectDo();
		return list;
	}
	
	//�ްԼ��߰�
	public int addRest(RestVO rVO) {
		int cnt = mrDAO.insertRest(rVO);
		return cnt;
	}
	
	//�߰����ްԼ��� �ε�����������
	public int searchNewIdx(RestVO rVO) {
		int idx = mrDAO.selectNewIdx(rVO);
		return idx;
	}
	
	//�ްԼ� �����߰��ϱ�
	public int addFood(List<FoodVO> list) {
		int cnt = mrDAO.insertFood(list);
		return cnt;
	}
	
	//�ްԼ� ���ǽü��߰��ϱ�
	public int addAmenity(AmenityVO amVO) {
		int cnt = mrDAO.insertAmenity(amVO);
		return cnt;
	}
	
	
	public RestDomain searchRestInfo(int restarea_idx) {
		
		return null;
	}
		
	public int modifyRest(RestVO rVO) {
		
		return 0;
	}
	
	public int removeRest(int restarea_idx) {
		
		return 0;
	}
}
