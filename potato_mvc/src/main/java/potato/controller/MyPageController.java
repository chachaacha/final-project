package potato.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

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
			url="redirect:user_mainhome.do"; }
			 //System.out.println("------������������ ���� : id is--------"+(String)session.getAttribute("id"));
		return "mypages/jsp/mypage_in";
	}//myPageIn
	
	//���̵�, ��й�ȣ Ȯ��
	@RequestMapping(value="chkIdPass.do",method=POST)
	public String chkIdPass(HttpSession session, LoginVO LVO,Model model) {
		String result="redirect:myPageIn.do";
		LVO.setId((String)session.getAttribute("id"));
		int cnt = us.searchMember(LVO);
		if(  cnt == 1 ) {
			System.out.println("------���̵� ��й�ȣ Ȯ�� ������: id is--------"+(String)session.getAttribute("id"));
			System.out.println("-----���̵��й�ȣ Ȯ�� : --------"+LVO);
			result= "redirect:my_info_edit.do";
		}else {
			session.setAttribute("passFlag", false);
		}
		return result;
	}//chkIdPass
	
	//�� ���� ���� ��
	//���� ������������ �ҷ����� �޼ҵ�� ȸ������ ������ ó�����ִ� �޼ҵ� �ΰ��� �����.
	//���� �����̱� ������ forward���ٴ� redirect�� ó���ϴ� ���� ����.
	@RequestMapping(value="my_info_edit.do",method = GET)
	public String myInfoEdit(HttpSession session, Model model) {
		System.out.println("------�� ���� ���� �� : id is--------"+(String)session.getAttribute("id"));
		
		model.addAttribute("MyInfoList", mps.searchInfo((String)session.getAttribute("id")));
		
		return "mypages/jsp/my_info_edit";
	}//myInfoEdit
	
	//�� ���� ����(ó��) �⺻�̹����� �������� �ʰ� ó���ϱ�
	@RequestMapping(value="my_info_edit_process.do",method = POST)
		public String myEditProcess(HttpSession session, MyPageMyInfoEditVO mieVO, Model model, HttpServletRequest request) {
		mieVO.setId((String)session.getAttribute("id"));
		
		
		File saveDir=new File("C:/Users/user/git/potato_mvc/potato_mvc/src/main/webapp/css/images");
		int maxSize=1024*1024*20*20; // byte * kb * mb *gb
		String responseURL="day1104/upload_err";
		try {
			MultipartRequest mr=new MultipartRequest(request, saveDir.getAbsolutePath(),maxSize, "UTF-8",
					new DefaultFileRenamePolicy() );
			
			mieVO.setImg(mr.getFilesystemName("upfile"));
			mieVO.setEmail(mr.getParameter("email"));
			
			mps.updateInfo(mieVO);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
//		model.addAttribute("EditList", mps.updateInfo((String)session.getAttribute("id"));
			return "redirect:my_info_edit.do";
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
		public String pwEditProcess(HttpSession session, MyPagePwEditVO peVO, Model model ) {
		peVO.setId((String)session.getAttribute("id"));
		int cnt=mps.modifyPw(peVO);
			
			model.addAttribute("cnt", cnt);
		
		return "redirect:password_edit.do";
	}//pwEditProcess
	
	//ȸ�� Ż�� ��
	@RequestMapping(value = "unregister.do", method = GET)
		public String unregister(HttpSession session) {
		
			return "mypages/jsp/unregister";
	}//quit
	
	//ȸ�� Ż�� ó��
	@RequestMapping(value = "unregister_process.do", method = POST)
		public String quitProcess(HttpSession session, MyPageQuitVO mqVO ) {
		//System.out.println("------ ȸ��Ż�� ��: id is--------"+(String)session.getAttribute("id"));
		//System.out.println("------ ȸ��Ż�� ó��: id is--------"+(String)session.getAttribute("id"));
		mqVO.setId((String)session.getAttribute("id"));
		int quitCount=mps.updateQuit(mqVO);
		
		return "redirect:user_mainhome.do";//ó���� �Ϸ�Ǹ� ����ȭ������ �̵�!
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
