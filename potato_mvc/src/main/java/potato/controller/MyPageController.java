package potato.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import potato.service.MyPageService;
import potato.vo.MyPageBookmarkVO;
import potato.vo.MyPageMyInfoEditVO;
import potato.vo.MyPagePwEditVO;
import potato.vo.MyPageQuitVO;
@Controller
public class MyPageController {
	
	@Autowired(required = false)
	private MyPageService mps;
	
	//���������� ����ȭ��
	@RequestMapping(value="myPageIn.do", method=GET)
	public String myPageIn(HttpSession session) {
		//���Ƿ� ���� �����	
		session.setAttribute("id", "");
		
		return "mypages/jsp/mypage_in";
	}//myPageIn
	
	//���̵�, ��й�ȣ Ȯ��
	@RequestMapping(value="chkIdPass.do",method=GET)
	public String chkIdPass(HttpSession session, String string ) {
		return "";
	}//chkIdPass
	
	//�� ���� ���� ��
	@RequestMapping(value="my_info_edit.do",method = GET)
	public String myInfoEdit(HttpSession session, Model model ) {
		//���Ƿ� ���� �����	
		session.setAttribute("id", "coffee");
		
		//model.addAttribute("mie",mps.searchInfo((String)session.getAttribute("name")));
		//model.addAttribute("mie",mps.searchInfo((String)session.getAttribute("nick")));
		model.addAttribute("mie",mps.searchInfo((String)session.getAttribute("id")));
		//model.addAttribute("mie",mps.searchInfo((String)session.getAttribute("birth")));
		//model.addAttribute("mie",mps.searchInfo((String)session.getAttribute("phone")));
		//model.addAttribute("mie",mps.searchInfo((String)session.getAttribute("email")));
		//System.out.println(mps.searchInfo((String)session.getAttribute("id"))+"findMe");
		
		return "mypages/jsp/my_info_edit";
	}//myInfoEdit
	
	//�� ���� ����(ó��)
	@RequestMapping(value="my_info_edit_process.do",method = GET)
		public String myEditProcess(HttpSession session, MyPageMyInfoEditVO mmeVO, Model model) {
			return "my_info_edit_process";
	}//myInfoEditProcess
	
	//������ �������
	@RequestMapping(value = "addProfileImg.do",method=GET)
		public String addProfileImg(String string) {
			return "addProfileImg";
	}//addProfileImg
	
	//������ ��������
	@RequestMapping(value = "delProfileImg.do",method=GET)
		public String delProfileImg(String string) {
			return "delProfileImg";
	}//delProfileImg
	
	//��й�ȣ ���� ��
	@RequestMapping(value="password_edit.do",method = {GET, POST})
		public String pwEdit(HttpSession session) {
		session.setAttribute("id", "coffee");
			return "mypages/jsp/password_edit";
	}//pwEdit
	
	//��й�ȣ ���� ó��
	@RequestMapping(value = "password_edit_process.do" ,method= GET)
		public String pwEditProcess(MyPagePwEditVO mpeVO, Model model ) {
			int cnt=mps.modifyPw(mpeVO);
			model.addAttribute("cnt", cnt);
		
		return "forward:password_edit.do";
	}//pwEditProcess
	
	//ȸ�� Ż�� ��
	@RequestMapping(value = "unregister.do", method = GET)
		public String unregister() {
			return "mypages/jsp/unregister";
	}//quit
	
	//ȸ�� Ż�� ó��
	@RequestMapping(value = "unregister_process.do", method = GET)
		public String quitProcess(HttpSession session, MyPageQuitVO mqVO ) {
			return "unregister_process";
	}//quitProcess
	
	//���� �� ���� ��ȸ
	@RequestMapping(value = "my_review.do", method = GET)
		public String myReview(HttpSession session, Model model) {
			return "mypages/jsp/my_review";
	}//myReview
	
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
	
	//���ã���� �ްԼ�
	@RequestMapping(value = "bookmark.do", method=GET)
		public String bookmark(HttpSession session, Model model) {
		//���Ƿ� ���� �����	
		session.setAttribute("id", "coffee");
		//System.out.println(session.getAttribute("id")+"findMe");
		//System.out.println(mps.searchBookmark((String)session.getAttribute("id"))+"findMe");
		model.addAttribute("bookmarklist",mps.searchBookmark((String)session.getAttribute("id")));
		return "mypages/jsp/bookmark";
	}//bookmark
	
	//���ã���� �ްԼ� ����
	@RequestMapping(value = "delBookmark.do", method=POST)
		public String delBookmark(HttpSession session, MyPageBookmarkVO bVO, Model model) {
			int cnt=mps.removeBookmark(session, bVO);
			model.addAttribute("delBookmark", cnt);
		return "forward:bookmark.do";
	}//bookmark
	
	
}//class
