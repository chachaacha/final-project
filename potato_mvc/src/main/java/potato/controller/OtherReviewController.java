package potato.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OtherReviewController {
	
	//Ÿ����ڸ���
	@RequestMapping(value="otherReviewMove.do", method=GET)
	public String OtherReviewMove(HttpSession session, String id, Model model) {
		return "other_profiles/jsp/other_user_profiles";
	}//OtherReviewMove
	
	//�Ű�)����-�˾�
	@RequestMapping(value = "reportPop.do",method = GET)
	public String reportPop(HttpSession session, String string) {
		return "other_profiles/jsp/report_review_popup";
	}//reportReview

}
