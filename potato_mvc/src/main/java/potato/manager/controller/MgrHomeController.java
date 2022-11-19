package potato.manager.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import potato.manager.service.MgrHomeService; 

@Controller
public class MgrHomeController {
	
	@Autowired(required = false)
	private MgrHomeService mhs;
	
	/**
	 * ������ Ȩ (��ú���) ����
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value="mgr_home.do",method=GET)
	public String mgrHomeMove(HttpSession session,Model model) {

//		if(session.getAttribute("manager_id")==null) {
//			url="forward:managerlogin_page.do";
//		}
		
		//���� �Ű� ��
		model.addAttribute("reportCnt", mhs.searchReportCnt());
		//�α� �ްԼ�
		model.addAttribute("popOne", mhs.searchPopOne());
		//���� �ްԼ�
		model.addAttribute("bookmark", mhs.searchBookmark());
		//�湮�� ��Ȳ(����)
		int visitFlag = 2;
		model.addAttribute("yesvisit", mhs.searchVisitorCnt(visitFlag));
		//�湮�� ��Ȳ(����)
		visitFlag=1;
		model.addAttribute("tovisit", mhs.searchVisitorCnt(visitFlag));
		//�湮�� ��Ȳ(��)
		visitFlag=0;
		model.addAttribute("visitorCnt", mhs.searchVisitorCnt(visitFlag));
		//ȸ�� ��Ȳ(��ü)
		model.addAttribute("allMemCnt", mhs.searchAllMem());
		//ȸ�� ��Ȳ(�ű�)
		model.addAttribute("newMemCnt", mhs.searchNewMemCnt());
		//ȸ�� ��Ȳ(Ż��)
		model.addAttribute("quitMemCnt", mhs.searchQuitMem());
		//�α� �ްԼ� ��ŷ
		model.addAttribute("rank", mhs.searchPopAll());
		
		return "manager/home/jsp/manager_mainhome";
	}//mgrHomeMove
}//class
