package potato.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import potato.domain.UserDomain;
import potato.service.MyPageService;
import potato.service.UserService;
import potato.vo.LoginVO;
import potato.vo.MyPageBookmarkVO;
import potato.vo.MyPageMyInfoEditVO;
import potato.vo.MyPagePwEditVO;
import potato.vo.MyPageQuitVO;
@Controller
public class MyPageController {
	
	@Autowired(required = false)
	private MyPageService mps;
	@Autowired(required = false)
	private UserService us;
	//���������� ����ȭ��
	@RequestMapping(value="myPageIn.do", method=GET)
	public String myPageIn(HttpSession session,String pass, LoginVO LVO) {
		String url="mypages/jsp/mypage_in";
	
		  if(session.getAttribute("id")==null) {
			url="forward:user_mainhome.do"; }
			 System.out.println("------������������ ���� : id is--------"+(String)session.getAttribute("id"));
		return "mypages/jsp/mypage_in";
	}//myPageIn
	
	//���̵�, ��й�ȣ Ȯ��
	@RequestMapping(value="chkIdPass.do",method=POST)
	public String chkIdPass(HttpSession session, LoginVO LVO,Model model) {
		UserDomain ud=null;	
		LVO.setId((String)session.getAttribute("id"));
		model.addAttribute("pass",LVO.getPass());
		if(session.getAttribute("id")!=null) {
			System.out.println("------���̵� ��й�ȣ Ȯ�� ������: id is--------"+(String)session.getAttribute("id"));
			System.out.println("-----���̵��й�ȣ Ȯ�� : --------"+LVO);
		ud=us.searchMember(LVO);
		}else {
			return "login_page.do";
		}
		return "redirect:my_info_edit.do";
	}//chkIdPass
	
	//�� ���� ���� ��
	//���� ������������ �ҷ����� �޼ҵ�� ȸ������ ������ ó�����ִ� �޼ҵ� �ΰ��� �����.
	//���� �����̱� ������ forward���ٴ� redirect�� ó���ϴ� ���� ����.
	@RequestMapping(value="my_info_edit.do",method = GET)
	public String myInfoEdit(HttpSession session, Model model) {
		model.addAttribute("MyInfoList", mps.searchInfo((String)session.getAttribute("id")));
//		System.out.println(mps.searchInfo((String)session.getAttribute("id"))+"findMe");//Ȯ�ο�
		System.out.println("------�� ���� ���� �� : id is--------"+(String)session.getAttribute("id"));
		return "mypages/jsp/my_info_edit";
	}//myInfoEdit
	
	//�� ���� ����(ó��) �⺻�̹����� �������� �ʰ� ó���ϱ�
	@RequestMapping(value="my_info_edit_process.do",method = POST)
		public String myEditProcess(HttpSession session, MyPageMyInfoEditVO mmeVO, Model model) {
		model.addAttribute("EditList", mps.updateInfo(mmeVO));
			return "redirect:my_info_edit";
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
	@RequestMapping(value="password_edit.do",method =GET)
		public String pwEdit(HttpSession session) {
		
			return "mypages/jsp/password_edit";
	}//pwEdit
	
	//��й�ȣ ���� ó��
	@RequestMapping(value = "password_edit_process.do" ,method= GET)
		public String pwEditProcess(MyPagePwEditVO peVO, Model model ) {
			int cnt=mps.modifyPw(peVO);
			model.addAttribute("cnt", cnt);
		
		return "forward:password_edit.do";
	}//pwEditProcess
	
	//ȸ�� Ż�� ��
	@RequestMapping(value = "unregister.do", method = GET)
		public String unregister(HttpSession session) {
		System.out.println("------ ȸ��Ż�� ��: id is--------"+(String)session.getAttribute("id"));
			return "mypages/jsp/unregister";
	}//quit
	
	//ȸ�� Ż�� ó��
	@RequestMapping(value = "unregister_process.do", method = POST)
		public String quitProcess(HttpSession session, MyPageQuitVO mqVO ) {
		int quitCnt=mps.updateQuit(mqVO);
		System.out.println("------ ȸ��Ż�� ó��: id is--------"+(String)session.getAttribute("id"));
		return "forward:user_mainhome.do";
	}//quitProcess
	
	
	//���ã���� �ްԼ�
	@RequestMapping(value = "bookmark.do", method=GET)
		public String bookmark(HttpSession session, Model model) {
		//System.out.println(mps.searchBookmark((String)session.getAttribute("id"))+"findMe");
		model.addAttribute("bookmarklist",mps.searchBookmark((String)session.getAttribute("id")));
		
		return "mypages/jsp/bookmark";
	}//bookmark
	
	//���ã���� �ްԼ� ����
	@RequestMapping(value = "delBookmark.do", method=POST)
		public String delBookmark(HttpSession session,MyPageBookmarkVO bVO, Model model) {
			int cnt=mps.removeBookmark(session, bVO);
			model.addAttribute("delBookmark", cnt);
		return "redirect:bookmark.do";
	}//bookmark
	
	
}//class
