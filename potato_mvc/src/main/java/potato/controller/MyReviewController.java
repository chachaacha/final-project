package potato.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import potato.service.MyReviewService;
import potato.vo.MyReviewVO;
@Controller
public class MyReviewController {
	
	@Autowired(required = false)
	private MyReviewService mrs;
	
	//����ڸ�����ȸ
	@RequestMapping(value = "my_review.do", method = {GET,POST})
	public String myReviewMove(HttpSession session, MyReviewVO mrVO, Model model) {
		model.addAttribute("rAll",mrs.searchMyRevAll(mrVO));
		return "mypages/jsp/my_review";
	}//myReviewMove
	
	//���� �� ���� ����(���� �ε�����)
	@RequestMapping(value = "delMyReview.do", method = GET)
		public String delMyReview(HttpSession session, String string) {
			return "myReview";
	}//delMyReview
	
	//���ƿ��� ����
	@RequestMapping(value = "like_review.do",method = GET)
		public String likeReview(HttpSession session,Model model) {
			return "mypages/jsp/like_review";
	}//likeReview
	
	//���ƿ� ���
	@RequestMapping(value = "delLike.do",method = GET)
		public String delLike(HttpSession session, String string) {
			return "delLike";
	}//delLike
	
	//�Ű�)���ƿ��� ����-�˾�
	@RequestMapping(value = "reportReview.do",method = GET)
		public String reportReview(HttpSession session, String string) {
			return "mypages/jsp/report_review_popup";
	}//reportReview
	
	
}//class
