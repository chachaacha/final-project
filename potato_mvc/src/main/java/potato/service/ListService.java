package potato.service;

import java.util.List;

import potato.domain.DetailedDomain;
import potato.domain.RestAreaListDomain;
import potato.manager.vo.MgrMemberVO;
import potato.vo.ListMapPinVO;
import potato.vo.SearchFlagVO;

public class ListService {
	
	//��ü �ްԼ� ��� ��ȸ
	public List<RestAreaListDomain> searchAllList(SearchFlagVO sfVO){
		
		return null;
	}//searchAllList
	
	//��ӵ��� ��ư Ŭ�� �� �� �ҷ�����
	public List<ListMapPinVO> searchHighwayPin(int restarea_idx){
		
		return null;
	}//searchHighwayPin
	
	//�� Ŭ���� �ްԼ� ��� ��ȸ
	public List<RestAreaListDomain> searchDoList(int do_idx){
		
		return null;
	}//searchDoList
	
	//�� �ްԼ� ��Ͽ��� �˻�, ����
	public List<RestAreaListDomain> searchArrangeDo(SearchFlagVO sfVO) {
		
		return null;
	}//searchArrangeDo
	
	//�ްԼ� ��Ͽ��� ��â ��ȸ
	public DetailedDomain searchDetailPage(int restarea_idx) {
		
		return null;
	}//searchDetailPage
	
	//����¡
	//����¡
	public int searchTotalMember(MgrMemberVO mmVO) {
		
		return 0;
	}
	
	public int lastPage(int totalMember) {
		
		return 0;
	}
	
	public int startNum(int currentPage) {
		
		return 0;
	}
	
	public int isLast(int startNum, int lastPage) {
		
		return 0;
	}
	
	//�����˻���(ajax)
	public String searchKeywordList(String keyword) {
		
		return "";
	}
}
