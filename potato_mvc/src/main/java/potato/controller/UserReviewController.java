package potato.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import potato.domain.MyReviewDomain;
import potato.service.UserReviewService;
import potato.vo.MyPageMyReviewVO;
import potato.vo.MyReviewVO;
import potato.vo.MypageLikeReviewVO;
import potato.vo.MypageReportVO;

@Controller
public class UserReviewController {
	
	@Autowired(required = false)
	private UserReviewService urs;
///////////////////����ڸ�����ȸ////////////////////
	
	//����ڸ�����ȸ
	@RequestMapping(value = "my_review.do", method = GET)
	public String myReviewMove(HttpSession session, MyReviewVO mrVO, Model model) {
		////�׺��////
		model.addAttribute("img",urs.searchMyImg(mrVO));
		model.addAttribute("nick",urs.searchMyNick(mrVO));
		
		System.out.println("------id is---------"+session.getAttribute("id"));
		//session id�� paramter�� �̻��Ѱ� ���� set ���ִ� �κ�
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
		model.addAttribute("reviewList", urs.searchLikeRevAll(mrVO));
		
		return "mypages/jsp/like_review";
	}//likeReviewMove
	
	//���� ���ƿ� �߰�(�񵿱�)
	@ResponseBody
	@RequestMapping(value = "ajax_addLike.do", method= {GET,POST})
	public String enterLike(HttpSession session, MypageLikeReviewVO mlrVO) {
		String jsonObj=urs.getLikeAdd(mlrVO);
		return jsonObj;
	}

	//���� ���ƿ� ����(�񵿱�)
	@ResponseBody
	@RequestMapping(value = "ajax_delLike.do", method= {GET,POST})
	public String cancelLike(HttpSession session, MypageLikeReviewVO mlrVO) {
		String jsonObj=urs.getLikeDel(mlrVO);
		return jsonObj;
	}
	
	//����ڽŰ� �˾�â ����
	@RequestMapping(value="like_review_report.do",method=GET)
	public String lRevReportMove(HttpServletRequest request,MypageReportVO mrVO, Model model) {
		model.addAttribute("rp", urs.searchRevReport());
		
		mrVO.setId_reporter(request.getParameter("id"));
		mrVO.setRestarea_idx(Integer.parseInt(request.getParameter("restarea_idx")));
		mrVO.setReview_idx(Integer.parseInt(request.getParameter("review_idx")));
		
		model.addAttribute("rpc", urs.searchRevReportChk(mrVO));
		return "mypages/jsp/report_review_popup";
	}
	
	//���� �Ű� ����
	@RequestMapping(value = "mypage_report.do", method= {GET,POST})
	public String setReport(HttpServletRequest request, MypageReportVO mrVO, Model model) {
		urs.setRevReport(mrVO);
		
		mrVO.setId_reporter(request.getParameter("id_reporter"));
		mrVO.setRestarea_idx(Integer.parseInt(request.getParameter("restarea_idx")));
		mrVO.setReview_idx(Integer.parseInt(request.getParameter("review_idx")));
		
		model.addAttribute("rpc", urs.searchRevReportChk(mrVO));
		
		return "mypages/jsp/report_review_popup";
	}
	
	////���� ����
	@ResponseBody
	@RequestMapping(value = "del_my_review.do", method= {GET,POST})
	public String delMyReview(MyPageMyReviewVO mpmrVO) {
		String jsonObj=urs.getRevDel(mpmrVO);
		return jsonObj;
	}
	
}//class