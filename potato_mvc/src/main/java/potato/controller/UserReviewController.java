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
import potato.service.UserReviewService;
import potato.vo.MyReviewVO;
import potato.vo.OtherReviewVO;

@Controller
public class UserReviewController {
	
	@Autowired(required = false)
	private UserReviewService urs;
///////////////////Ÿ����ڸ�����ȸ////////////////////
	
	//Ÿ����ڸ�����ȸ
	@RequestMapping(value="other_review.do", method= {POST,GET})
	public String otherReviewMove(HttpSession session, OtherReviewVO orVO, Model model) {
		//otherPid : Ŭ������ �� �ԷµǴ� ���̵�
		model.addAttribute("img",urs.searchOtherImg(orVO));
		model.addAttribute("nick",urs.searchOtherNick(orVO));
		model.addAttribute("rCnt",urs.searchOtherRev(orVO));
		model.addAttribute("rAll",urs.searchOtherRevAll(orVO));
		
		
		return  "other_profiles/jsp/other_user_profiles";
	}//otherReviewMove

///////////////////����ڸ�����ȸ////////////////////
	
	//����ڸ�����ȸ
	@RequestMapping(value = "my_review.do", method = GET)
	public String myReviewMove(HttpSession session, MyReviewVO mrVO, Model model) {
		model.addAttribute("img",urs.searchMyImg(mrVO));
		model.addAttribute("nick",urs.searchMyNick(mrVO));
		
		System.out.println("------id is---------"+session.getAttribute("id"));
		
		mrVO.setId((String)session.getAttribute("id"));//id �־��ֱ�
		
		List<MyReviewDomain> list=urs.searchMyRevAll(mrVO);
		System.out.println("-----����Ʈ----"+list);//����Ʈ��ȸ
		model.addAttribute("mAll",list);
		
		//����¡����
		int totalData = urs.searchTotalReview(mrVO);
		int lastPage = urs.lastPage(totalData);
		int curPage = mrVO.getPageFlag();
		int startNum = urs.startNum(curPage);
		int isLast = urs.isLast(lastPage, startNum);
		
		//view�� ����
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("startNum", startNum);
		model.addAttribute("isLast", isLast);
		model.addAttribute("curPage", curPage);
		model.addAttribute("reviewList", urs.searchMyRevAll(mrVO));
		
		
		return "mypages/jsp/my_review";
	}//myReviewMove
	
///////////////////���ƿ��Ѹ�����ȸ////////////////////	
	@RequestMapping(value = "like_review.do", method = GET)
	public String likeReviewMove(HttpSession session, MyReviewVO mrVO, Model model) {
		
		mrVO.setId((String)session.getAttribute("id"));//id �־��ֱ�
		model.addAttribute("lAll",urs.searchLikeRevAll(mrVO));
		
		//����¡����
		int totalData = urs.searchTotalReview(mrVO);
		int lastPage = urs.lastPage(totalData);
		int curPage = mrVO.getPageFlag();
		int startNum = urs.startNum(curPage);
		int isLast = urs.isLast(lastPage, startNum);
				
		//view�� ����
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("startNum", startNum);
		model.addAttribute("isLast", isLast);
		model.addAttribute("curPage", curPage);
		model.addAttribute("reviewList", urs.searchMyRevAll(mrVO));
		
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
