package potato.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import potato.vo.DetailedReviewVO;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.servlet.http.HttpSession;

@Controller
public class UserDetailedController {

	//�ްԼ� ��â ����
	@RequestMapping(value = "user_detailed.do", method=GET)
	public String userDetailedMove(String restidx, Model model) {
		return "detailed/jsp/user_detailed";
	}

	//�����ۼ�â ����
	@RequestMapping(value = "write.do", method=GET)
	public String writePageMove(HttpSession session, DetailedReviewVO drVO, Model model) {
		return "detailed/jsp/write";
	}
	
	//�������â ����
	@RequestMapping(value = "rewrite.do", method=GET)
	public String rewritePageMove(HttpSession session, DetailedReviewVO drVO, Model model) {
		return "detailed/jsp/rewrite";
	}
	
	//���� �Ű�â ����
	@RequestMapping(value = "report_review_popup.do", method=GET)
	public String reportPopip(HttpSession session, String restname, Model model) {
		return "detailed/jsp/report_review_popup";
	}
	
}
