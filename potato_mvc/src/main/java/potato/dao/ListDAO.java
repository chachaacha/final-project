package potato.dao;

import java.util.List;

import potato.domain.DetailedDomain;
import potato.domain.RestAreaListDomain;
import potato.vo.ListMapPinVO;
import potato.vo.SearchFlagVO;

public class ListDAO {
	
	//��ü�ްԼ� ��� �����ֱ�
	public List<RestAreaListDomain> selectAllRestAreaList(SearchFlagVO sfVO){
		
		return null;
	}//selectAllRestAreaList
	
	//��ӵ��� ��ư Ŭ���� �� �ҷ�����
	public List<String> selectHighwayPin(ListMapPinVO lmpVO){
		
		return null;
	}//selectHighwayPin
	
	//�� Ŭ���� �ްԼ� ��� �����ֱ�
	public List<RestAreaListDomain> selectDoList(int do_idx){
		
		return null;
	}//selectDoList
	
	//�� �ްԼ� ��Ͽ��� �˻�, ����
	public List<RestAreaListDomain> selectSearchArrangeDo(SearchFlagVO sfVO){
		
		return null;
	}
	
	//�ްԼ� ��Ͽ��� ��â���� �̵�
	public DetailedDomain selectDetailPage(int restarea_idx) {
		
		return null;
	}
	
	//����¡
	public int selectTotalPage(SearchFlagVO sfVO) {
		
		return 0;
	}
	
	//�����˻���(ajax)
	public String searchKeywordList(String keyword) {
		
		return null;
	}
}
