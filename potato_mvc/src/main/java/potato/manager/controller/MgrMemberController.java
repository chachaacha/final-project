package potato.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
		//��� Ÿ��
		int memberType=mmVO.getMemberType();
		model.addAttribute("memberType",memberType);

		//����¡ ����
		int totalPages = mms.searchTotalPages(mmVO);
		int lastPage = mms.lastPage(totalPages);
		int currentPage = mmVO.getPageFlag();
		int startNum = mms.startNum(currentPage);
		int isLast = mms.isLast(startNum,lastPage);
		
		
		//view�� ����
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("startNum", startNum);
		model.addAttribute("isLast", isLast);
		model.addAttribute("currentPage", currentPage);
		
		//ȸ�� ���
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
	public String memberBlockPopup(HttpServletRequest request,String id, Model model) {
		id=request.getParameter("id");
		model.addAttribute("reasonList",mms.searchReason());
		model.addAttribute("blockId",id);
		
		return "manager/member_management/jsp/member_block_popup";
	}//memberInfoPopup
	
	//ȸ�� ����
	@RequestMapping(value="/mgr_block.do",method={GET,POST})
	public String block(HttpServletRequest request,ManagerBlockVO mbVO,Model model) {
		int cnt=mms.addBlock(mbVO);
		mbVO.setId(request.getParameter("id"));
		mbVO.setBlock_idx(Integer.parseInt(request.getParameter("block_idx")));
		/*
		 * �̹� ���ܵ� �� ���� �� ��� ǥ���ؾ� ����..
		 * if(mbVO.getBlock_idx() != 0) { mms.addBlock(mbVO); }
		 */
		
		model.addAttribute("blockCnt",cnt);
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
