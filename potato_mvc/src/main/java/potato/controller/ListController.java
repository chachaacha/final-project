package potato.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import potato.vo.SearchFlagVO;

@Controller
public class ListController {
	
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
	public String doMap() {
		
		return "list/jsp/do_list";
	}
	
	//Ŭ���� �� �ްԼ� ������� �̵�
	public String doRestAreaList(int do_idx, Model model) {
		
		return "list/jsp/do_list_details";
	}

	//�� �ްԼҿ��� �˻�, ����
	public String doSearchArrange(SearchFlagVO sfVO, Model model) {
		
		return "list/jsp/list_view_all";
	}
	
	//�ްԼ� ��Ͽ��� �Ǵ� ��ӵ��� �������� �� Ŭ���ؼ� ��â �̵�
	public String detailPage(int restarea_idx, Model model) {
		
		return "list/jsp/user_detailed";
	}
	
	///ex-FOOD
	public String exFoodList(int restarea_idx) {
		
		return "list/jsp/exfood_list";
	}//exFoodList
	
	//���� �˻���(ajax)
	public String keywordList(String keyword) {
		
		return "";
	}
	
}
