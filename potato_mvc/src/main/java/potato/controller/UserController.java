package potato.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import potato.domain.UserDomain;
import potato.service.UserService;
import potato.vo.ForgotIdVO;
import potato.vo.ForgotPwVO;
import potato.vo.LoginVO;
import potato.vo.ManagerLoginVO;
import potato.vo.UserInfoVO;

//@SessionAttributes({"id","nick", "img"})
@Controller
@Component
public class UserController {
	
	@Autowired(required = false)
	private UserService us;
	

	/**
	 * �α��� ������ �̵�
	 * @return
	 */
	@RequestMapping(value = "/login_page.do", method = GET)
	public String loginPage(HttpSession session) {
		session.invalidate();
		return "login/jsp/login";
	}//loginPage
	
	/**
	 * �Ŵ��� �α��� ������ �̵�
	 * @return
	 */
	@RequestMapping(value = "/managerlogin_page.do", method = GET)
	public String managerloginPage() {
		return "manager/home/jsp/manager_login";
	}//loginPage
	
	/**
	 * ȸ�� �α���
	 * @param lVO
	 * @param session
	 * @param id
	 * @param pass
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/login.do", method = POST)
	public String login(LoginVO lVO, HttpSession session, String id, String pass) {
		UserDomain ud=null;
		lVO.setId(id);
		lVO.setPass(pass);
		ud=us.searchMember(lVO);
		session.setAttribute("id", ud.getId());
		session.setAttribute("nick", ud.getNick());
		session.setAttribute("img", ud.getImg());
		JSONObject jsonObj=new JSONObject();
		jsonObj.put("id", ud.getId());
		jsonObj.put("nick", ud.getNick());
		jsonObj.put("quit", ud.getQuit());
		jsonObj.put("img", ud.getImg());
		return jsonObj.toJSONString();
	}//login
	

	/**
	 * �Ŵ��� �α���
	 * @param mlVO
	 * @param ss
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/managerlogin.do", method = POST)
	public String managerlogin(ManagerLoginVO mlVO, String manager_id, String pass, HttpSession session) {
		mlVO.setManager_id(manager_id);
		mlVO.setPass(pass);
		int cnt=us.searchManager(mlVO);
		if( cnt ==1 ) {
			session.setAttribute("manager_id", manager_id);
		}
		JSONObject jsonObj=new JSONObject();
		jsonObj.put("cnt", cnt);
		return jsonObj.toJSONString();
	}//login
	
	/**
	 * �α׾ƿ�
	 * @param ss
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "logout.do", method = GET)
	public String logout( SessionStatus ss, HttpSession session) {
		String url="redirect:user_mainhome.do";
		ss.setComplete();
		session.invalidate();
		return url;
	}//logout
	
	/**
	 * ȸ������������ 1�̵�
	 * @return
	 */
	@RequestMapping(value = "/signUpAgree.do", method = GET)
	public String signUpAgreePage() {
		return "login/jsp/service_check";
	}
	
	/**
	 * �̿���1 �̵�
	 * @return
	 */
	@RequestMapping(value = "/tos1.do", method = GET)
	public String tos1() {
		return "login/jsp/tos1";
	}
	
	/**
	 * �̿���2 �̵�
	 * @return
	 */
	@RequestMapping(value = "/tos2.do", method = GET)
	public String tos2() {
		return "login/jsp/tos2";
	}
	
	/**
	 * ȸ������1 ������ �̵�
	 * @return
	 */
	@RequestMapping(value = "/signUp.do", method = GET)
	public String signUpPage1() {
		return "login/jsp/join";
	}
	
	/**
	 * ȸ������2 ������ �̵�
	 * @param model
	 * @param uiVO
	 * @return
	 */
	@RequestMapping(value = "/signUp2.do", method = POST)
	public String signUpPage2(HttpServletRequest request, Model model, UserInfoVO uiVO, HttpSession session) {
		String year=request.getParameter("year");
		String month=request.getParameter("month");
		if( month.length() == 1 ) {
			month="0"+month;
		}
		String day=request.getParameter("day");
		if( day.length() == 1 ) {
			day="0"+day;
		}
		String birth= year+"-"+month+"-"+day;
		uiVO.setBirth(birth);
		session.setAttribute("uiVO", uiVO);
		return "login/jsp/join_img";
	}
	
	/**
	 * ȸ������ 3������ �̵�
	 * @param session
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/signUp3.do", method = POST)
	public String signUpPage3(HttpServletRequest request, Model model, HttpSession session, UserInfoVO uiVO, SessionStatus ss) {
		File saveDir=new File("C:/Users/user/git/potato_mvc/potato_mvc/src/main/webapp/css/images/");
		int maxSize=1024*1024*20; //byte*kb*mb*gb;
		String url="redirect:user_mainhome.do";
		try {
			uiVO=(UserInfoVO)session.getAttribute("uiVO");
			MultipartRequest mr=new MultipartRequest(request, saveDir.getAbsolutePath(), 
					maxSize, "UTF-8", new DefaultFileRenamePolicy());
			//3. �Ķ���͸� �ޱ�( VO�� �־�� �Ѵٸ� VO�� �����Ͽ� ���� �ִ´�.
			uiVO.setImg(mr.getFilesystemName("upfile"));
			//JSP���� �Է°��� �����ֱ����� model�� VO�� �ִ´�.
			String rename=mr.getFilesystemName("upfile");
			if( rename == null ) {
				uiVO.setImg("basic.png");
			}
		} catch (IOException ie) {
			ie.printStackTrace();
		}
		ss.setComplete();
		session.invalidate();
		int cnt=us.addMember(uiVO);
		if( cnt == 1 ) {
			model.addAttribute("joinId", uiVO.getId());
			url="login/jsp/join_end";
		}
		return url;
	}
	
	/**
	 * ȸ�����Կ��� ���������� �̵�
	 * @param ss
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/signUp4.do", method = GET)
	public String signUp4(SessionStatus ss, HttpSession session) {
		ss.isComplete();
		session.invalidate();
		return "redirect:user_mainhome.do";
	}
	
	/**
	 * ���̵� �ߺ�Ȯ��
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/duplChkId.do", method = POST)
	public String duplChkId(String id) {
		String jsonObj = us.searchDuplChkId(id);
		return jsonObj;
	}
	
	/**
	 * �г��� �ߺ� Ȯ��
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "duplChkNick.do", method = POST)
	public String duplChkNick(String nick) {
		String jsonObj = us.searchDuplChkNick(nick);
		return jsonObj;
	}
	
	/**
	 * ���̵� ã�� ������ �̵�
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/forgotId.do", method = GET)
	public String forgotUserId(HttpSession session) {
		session.invalidate();
		return "login/jsp/find_id";
	}
	
	/**
	 * ��й�ȣ ã�� �̵�
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/forgotPw.do", method = GET)
	public String forgotUserPw(HttpSession session) {
		session.invalidate();
		return "login/jsp/find_pass";
	}
	
	/**
	 * ���̵�ã�� �˾�â
	 * @return
	 */
	@RequestMapping(value = "/forgotIdPop.do", method = GET)
	public String forgotIdPop() {
		return "login/jsp/find_id_popup";
	}
	
	/**
	 * ��й�ȣã�� �˾�â
	 * @return
	 */
	@RequestMapping(value = "/forgotPwPop.do", method = GET)
	public String forgotPwPop() {
		return "login/jsp/find_pass_popup";
	}
	
	/**
	 * ���̵� ã��
	 * @param fiVO
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/forgotIdChk.do", method= POST) 
	public String forgotUserIdChk(ForgotIdVO fiVO, HttpSession session, String name, String birth, String phone) { 
		String id="";
		fiVO.setName(name);
		fiVO.setBirth(birth);
		fiVO.setPhone(phone);
		id=us.searchId(fiVO);
		session.setAttribute("findId", id);
		JSONObject jsonObj=new JSONObject();
		jsonObj.put("id", id);
		return jsonObj.toJSONString();
	}
	 
	
	/**
	 * ��й�ȣ ã��
	 * @param fpVO
	 * @param session
	 * @param id
	 * @param name
	 * @param phone
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/forgotPwChk.do", method = POST)
	public String forgotUserPwChk(ForgotPwVO fpVO, HttpSession session, String id, String name, String phone) {
		String pass="";
		fpVO.setId(id);
		fpVO.setName(name);
		fpVO.setPhone(phone);
		pass=us.searchPw(fpVO);
		session.setAttribute("findPw", pass);
		JSONObject jsonObj=new JSONObject();
		jsonObj.put("pass", pass);
		return jsonObj.toJSONString();
	}
	
}//class
