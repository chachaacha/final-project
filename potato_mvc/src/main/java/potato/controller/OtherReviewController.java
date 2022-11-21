package potato.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import potato.service.OtherReviewService;
import potato.vo.OtherReviewVO;

@Controller
public class OtherReviewController {
	
	@Autowired(required = false)
	private OtherReviewService ors;
	
	//Ÿ����ڸ�����ȸ
	@RequestMapping(value="other_review.do", method= {POST,GET})
	public String otherReviewMove(String otherPId, HttpSession session, OtherReviewVO orVO, Model model) {
		
		session.setAttribute("id", "sotteok");
		model.addAttribute("revAll",ors.searchOtherRevAll(orVO));
		
		return  "other_profiles/jsp/other_user_profiles";
	}//otherReviewMove
	
}//class
