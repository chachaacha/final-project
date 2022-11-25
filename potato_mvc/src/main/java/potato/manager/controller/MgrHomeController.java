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
	
	//����������
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

		if(session.getAttribute("manager_id")==null) {
			return "forward:managerlogin_page.do";
		}
		
	//view�� ����
		//���� �Ű� ��
		model.addAttribute("reportCnt", mhs.searchReportCnt());
		//�α� �ްԼ�
		model.addAttribute("popOne", mhs.searchPopOne());
		//���� �ްԼ�
		model.addAttribute("bookmark", mhs.searchBookmark());
		//�ְ� ��¥
		int DateFlag=6;
		model.addAttribute("D6", mhs.searchVisitDate(DateFlag));
		DateFlag=5;
		model.addAttribute("D5", mhs.searchVisitDate(DateFlag));
		DateFlag=4;
		model.addAttribute("D4", mhs.searchVisitDate(DateFlag));
		DateFlag=3;
		model.addAttribute("D3", mhs.searchVisitDate(DateFlag));
		DateFlag=2;
		model.addAttribute("D2", mhs.searchVisitDate(DateFlag));
		DateFlag=1;
		model.addAttribute("D1", mhs.searchVisitDate(DateFlag));
		DateFlag=0;
		model.addAttribute("D0", mhs.searchVisitDate(DateFlag));
		//�ְ� �湮�� ��
		int visitFlag=6;
		model.addAttribute("V6", mhs.searchVisitorCnt(visitFlag));
		visitFlag=5;
		model.addAttribute("V5", mhs.searchVisitorCnt(visitFlag));
		visitFlag=4;
		model.addAttribute("V4", mhs.searchVisitorCnt(visitFlag));
		visitFlag=3;
		model.addAttribute("V3", mhs.searchVisitorCnt(visitFlag));
		visitFlag=2;
		model.addAttribute("V2", mhs.searchVisitorCnt(visitFlag));
		//�湮�� ��Ȳ(����)
		visitFlag=1;
		model.addAttribute("yesvisit", mhs.searchVisitorCnt(visitFlag));
		//�湮�� ��Ȳ(����)
		visitFlag=0;
		model.addAttribute("tovisit", mhs.searchVisitorCnt(visitFlag));
		//�湮�� ��Ȳ(��)
		visitFlag=10;
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
