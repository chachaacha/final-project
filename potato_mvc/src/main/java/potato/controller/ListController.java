package potato.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import potato.vo.SearchFlagVO;

@Controller
public class ListController {
	//���
	@RequestMapping(value="/header.do",method=GET)
	public String userHeader() {
		
		return "common/jsp/user_header";
	}
	
	//��ü �ްԼ� ���
	@RequestMapping(value="/allList.do", method=GET)
	public String allRestAreaList(SearchFlagVO sfVO, Model model) {
		
		return "list/jsp/list_view_all";
	}//allRestAreaList
	
	//��ӵ��κ�) ��ư Ŭ���� �ش� ���� �� �ҷ�����
	@RequestMapping(value="/mapPin.do",method=GET)
	public String highwayMapPin(Model model) {
		
		return "list/jsp/highway_list";
	}
	
	//���� �ްԼ�(����)
	@RequestMapping(value="doMap.do",method=GET)
	public String doMap() {
		
		return "list/jsp/do_list";
	}
	
	//Ŭ���� �� �ްԼ� ������� �̵�
	@RequestMapping(value="doList.do",method=GET)
	public String doRestAreaList(int do_idx, Model model) {
		
		return "list/jsp/do_list_details";
	}

	//�� �ްԼҿ��� �˻�, ����
	@RequestMapping(value="searchArrange.do",method=GET)
	public String doSearchArrange(SearchFlagVO sfVO, Model model) {
		
		return "list/jsp/list_view_all";
	}
	
	//�ްԼ� ��Ͽ��� �Ǵ� ��ӵ��� �������� �� Ŭ���ؼ� ��â �̵�
	//�Ű����� int restarea_idx, Model model
	@RequestMapping(value="listToDetail.do",method=GET)
	public String detailPage() {
		
		return "detailed/jsp/user_detailed";
	}
	
	//ex-FOOD //�Ű����� : int restarea_idx
	@RequestMapping(value="exFood.do",method=GET)
	public String exFoodList() {
		
		return "list/jsp/exfood_list";
	}//exFoodList
	
	//���� �˻���(ajax)
	@RequestMapping(value="relatedKeyword.do",method = GET)
	public String keywordList(String keyword) {
		
		return "list/jsp/list_view_all";
	}
	
}
