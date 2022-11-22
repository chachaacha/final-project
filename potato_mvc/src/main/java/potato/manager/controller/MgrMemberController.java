package potato.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import potato.manager.domain.MgrMemberDomain;
import potato.manager.service.MgrMemberService;
import potato.manager.vo.ManagerBlockVO;
import potato.manager.vo.MgrMemberVO;

@Controller
public class MgrMemberController {
	
	@Autowired(required = false)
	private MgrMemberService mms;
	
	//ȸ����� ��ȸ
	@RequestMapping(value="/mgr_memberManagement.do",method= {GET,POST})
	public String memberList(String memberCat, MgrMemberVO mmVO,Model model, HttpSession session) {
		
		//����¡ ����
//		int totalPages = mms.searchTotalPages(mmVO);
//		int lastPage = mms.lastPage(totalPages);
//		int currentPage = mmVO.getPageFlag();
//		int startNum = mms.startNum(currentPage);
//		int isLast = mms.isLast(lastPage, startNum);
//		
		//��� Ÿ��
		int memberType=mmVO.getMemberType();
		
//		//view�� ����
//		model.addAttribute("lastPage", lastPage);
//		model.addAttribute("startNum", startNum);
//		model.addAttribute("isLast", isLast);
//		model.addAttribute("currentPage", currentPage);
		
		model.addAttribute("memberType",memberType);
		
		List<MgrMemberDomain> list=mms.searchMember(mmVO,memberCat,session);
		
		model.addAttribute("memberList", list);

		return "manager/member_management/jsp/member_management";
	}//memberList
	
	//ȸ�� ������ �˾�â ����
	@RequestMapping(value="/mgr_memberInfoPopup.do",method=GET)
	public String memberInfoPopup(String memberId, Model model) {
		System.out.println("---------��â : "+memberId);
		model.addAttribute("memberData",mms.searchMemberInfo(memberId));
		
		return "manager/member_management/jsp/member_info_popup";
	}//memberInfoPopup
	
	//ȸ�� ���� �˾�â ����
	@RequestMapping(value="/mgr_memberBlockPopup.do",method=GET)
	public String memberBlockPopup(String id, Model model) {
		model.addAttribute("reasonList",mms.searchReason());
		model.addAttribute("id",id);
		System.out.println("---------------���� ���̵� : "+id);
		return "manager/member_management/jsp/member_block_popup";
	}//memberInfoPopup
	
	//ȸ�� ����
	@RequestMapping(value="/mgr_block.do",method=GET)
	public String block(ManagerBlockVO mbVO,Model model) {
		mms.addBlock(mbVO);
		
		return "forward:mgr_memberManagement.do";
	}
	
	//���� ����
	@RequestMapping(value="/mgr_unblock.do",method=POST)
	public String unblock(String id,Model model) {
		int unblockCnt=mms.removeBlock(id);
		model.addAttribute("unblockCnt",unblockCnt);
		
		return "forward:mgr_memberManagement.do";
	}
}//class
