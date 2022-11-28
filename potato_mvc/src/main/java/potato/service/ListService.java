package potato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import potato.dao.ListDAO;
import potato.domain.DetailedDomain;
import potato.domain.ListMapPinDomain;
import potato.domain.RestAreaListDomain;
import potato.vo.DoSearchVO;
import potato.vo.SearchFlagVO;

@Component
public class ListService {
	
	@Autowired(required = false)
	private ListDAO lDAO;
	
	//��ü �ްԼ� ��� ��ȸ
	public List<RestAreaListDomain> searchAllList(SearchFlagVO sfVO){
		List<RestAreaListDomain> list=null;
		list=lDAO.selectAllRestAreaList(sfVO);
		
		return list;
	}//searchAllList
	
	//��ӵ��� �� �ҷ�����
	//��ΰ�ӵ���
	public List<ListMapPinDomain> searchPin1(){
		List<ListMapPinDomain> list=null;
		list=lDAO.selectPin1();
		return list;
	}//searchPin1
	
	//���ذ�ӵ���
	public List<ListMapPinDomain> searchPin2(){
		List<ListMapPinDomain> list=null;
		list=lDAO.selectPin2();
		return list;
	}//searchPin2
	
	//���ؾȰ�ӵ���
	public List<ListMapPinDomain> searchPin3(){
		List<ListMapPinDomain> list=null;
		list=lDAO.selectPin3();
		return list;
	}//searchPin3
	
	//������ӵ���
	public List<ListMapPinDomain> searchPin4(){
		List<ListMapPinDomain> list=null;
		list=lDAO.selectPin4();
		return list;
	}//searchPin4
	
	//�ߺγ�����ӵ���
	public List<ListMapPinDomain> searchPin5(){
		List<ListMapPinDomain> list=null;
		list=lDAO.selectPin5();
		return list;
	}//searchPin5
	
	//�� Ŭ���� �ްԼ� ��� ��ȸ
	public List<RestAreaListDomain> searchDoList(DoSearchVO dsVO){
		List<RestAreaListDomain> list = null;
		list=lDAO.selectDoList(dsVO);
		return list;
	}//searchDoList
	
	//�� �̸� ��������
	public String searchDoName(int do_idx) {
		String name=lDAO.selectDoName(do_idx);
		
		return name;
	}
	
	//�� �ްԼ� ��Ͽ��� �˻�, ����
	public List<RestAreaListDomain> searchArrangeDo(SearchFlagVO sfVO) {
		
		return null;
	}//searchArrangeDo
	
	//////////////////////����¡/////////////////////
	//��ü ��������(��ü ����Ʈ)
	public int searchTotalPages(SearchFlagVO sfVO) {
		int cnt=lDAO.selectTotalPages(sfVO);
		
		return cnt;
	}
	
	public int searchDoTotalPages(DoSearchVO dsVO) {
		int cnt=lDAO.selectDoTotalPages(dsVO);
		
		return cnt;
	}
	
	//������ ������ ��ȣ
	public int lastPage(int totalPages) {
		int lastPage=(int)Math.ceil((double)totalPages/6); //6���� �����ش�.
		return lastPage;
	}
	
	//������������ ���� ��ȣ
	public int startNum(int currentPage) {
		int startNum=currentPage-(currentPage-1) % 3;//3�������� �����ش�.
		return startNum;
	}
	
	// �� �������� ������ ������ ��, ������ ���������� ���ٸ� �ٽ� ���
	public int isLast(int startNum, int lastPage) {
		int isLast = 2; // 3������ �� 0,1,2
		if (startNum + 3 > lastPage) {
			isLast = lastPage - startNum;
		}
		return isLast;
	}
	
	
	
	//�����˻���(ajax)
	public String searchKeywordList(String keyword) {
		
		return "";
	}
}
