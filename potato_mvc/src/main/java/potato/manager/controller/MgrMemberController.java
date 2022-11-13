package potato.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import potato.manager.vo.ManagerBlockVO;
import potato.manager.vo.MgrMemberVO;

@Controller
public class MgrMemberController {
	
	//ȸ����� ��ȸ
	@RequestMapping(value="/mgr_memberManagement.do",method=GET)
	public String memberList(MgrMemberVO mVO,Model model) {
		
		return "manager/member_management/jsp/member_management";
	}//memberList
	
	//ȸ�� ������ �˾�â ����
	@RequestMapping(value="/mgr_memberInfoPopup.do",method=GET)
	public String memberInfoPopup(String id, Model model) {
		
		return "manager/member_management/jsp/member_info_popup";
	}//memberInfoPopup
	
	//ȸ�� ���� �˾�â ����
	@RequestMapping(value="/mgr_memberBlockPopup.do",method=GET)
	public String memberBlockPopup(String id, Model model) {
		
		return "manager/member_management/jsp/member_block_popup";
	}//memberInfoPopup
	
	//ȸ�� ����
	@RequestMapping(value="/mgr_block.do",method=GET)
	public String block(ManagerBlockVO mbVO) {
		
		return "";
	}
	
	//���� ����
	@RequestMapping(value="/mgr_unblock.do",method=POST)
	public String unblock(String id) {
		
		return "";
	}
}//class
