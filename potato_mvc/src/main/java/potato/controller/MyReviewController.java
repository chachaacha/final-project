package potato.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import potato.domain.MyReviewDomain;
import potato.service.MyReviewService;
import potato.vo.MyReviewVO;
@Controller
public class MyReviewController {
	
	@Autowired(required = false)
	private MyReviewService mrs;
	
	//����ڸ�����ȸ
	@RequestMapping(value = "my_review.do", method = GET)
	public String myReviewMove(HttpSession session, MyReviewVO mrVO, Model model) {
		model.addAttribute("img",mrs.searchMyImg(mrVO));
		model.addAttribute("nick",mrs.searchMyNick(mrVO));
		
		System.out.println("------id is---------"+session.getAttribute("id"));
		
		mrVO.setId((String)session.getAttribute("id"));//id �־��ֱ�
		
		List<MyReviewDomain> list=mrs.searchMyRevAll(mrVO);
		System.out.println("-----����Ʈ----"+list);//����Ʈ��ȸ
		model.addAttribute("mAll",list);
		
		//����¡����
		int totalData = mrs.searchTotalReview(mrVO);
		int lastPage = mrs.lastPage(totalData);
		int curPage = mrVO.getPageFlag();
		int startNum = mrs.startNum(curPage);
		int isLast = mrs.isLast(lastPage, startNum);
		
		
		//view�� ����
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("startNum", startNum);
		model.addAttribute("isLast", isLast);
		model.addAttribute("curPage", curPage);
		model.addAttribute("reviewList", mrs.searchMyRevAll(mrVO));
		
		
		return "mypages/jsp/my_review";
	}//myReviewMove
	
	//��������ƿ��Ѹ�����ȸ
	@RequestMapping(value = "like_review.do", method = GET)
	public String likeReviewMove(HttpSession session, MyReviewVO mrVO, Model model) {
		
		mrVO.setId((String)session.getAttribute("id"));//id �־��ֱ�
		model.addAttribute("lAll",mrs.searchLikeRevAll(mrVO));
		return "mypages/jsp/like_review";
	}//likeReviewMove
	
	
	//���� �� ���� ����(���� �ε�����)
	@RequestMapping(value = "delMyReview.do", method = GET)
		public String delMyReview(HttpSession session, String string) {
			return "myReview";
	}//delMyReview
	
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
