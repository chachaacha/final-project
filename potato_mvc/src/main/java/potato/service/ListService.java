package potato.service;

import java.util.List;

import potato.domain.DetailedDomain;
import potato.domain.RestAreaListDomain;
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
	public int searchTotalPage(SearchFlagVO sfVO) {
		
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
	
	public String pagination(SearchFlagVO sfVO) {
		int startPage=sfVO.getStartNum();
		int endPage=sfVO.getEndNum();
		int totalPages=sfVO.getTotalPages();
		String url=sfVO.getUrl();
		
		StringBuffer sb = new StringBuffer();
		if(startPage==1) {
			sb.append("<a  class='page-num' href='#void'>&lt;</a>");
		}else {
			sb
			.append("<a class='page-num' href='").append(url).append("?page=").append(startPage-1)
			.append("' tabindex='-1' aria-disabled='true'>&lt;</a>");
		}//else
		for(int i=startPage; i<=5; i++) {
			sb
			.append("<a  class='page-num' href='").append(url).append("?page=")
			.append(i).append("'>").append(i).append("</a>");
		}
		if(totalPages==endPage) {
			sb.append("&gt;");
		}else {
			sb
			.append("<a  class='page-num' href='").append(url).append("?page=").append(endPage+1).append("'>")
			.append("&gt;</a>");
		}//else
		
		return sb.toString();
	}
	
	
	public static void main(String[] args) {
		ListService ls = new ListService();
		
		//(String keyword, String url, int filterFlag, int startNum, int endNum, int totalPages) {
		SearchFlagVO sfVO = new SearchFlagVO(null,"test.jsp",0,1,10,5);
		
		System.out.println(ls.pagination(sfVO));
	}
	
	//�����˻���(ajax)
	public String searchKeywordList(String keyword) {
		
		return "";
	}
}
