package potato.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

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
	
	@RequestMapping(value = "/login_page.do", method = GET)
	public String loginPage() {
		return "login/jsp/login";
	}//loginPage
	@RequestMapping(value = "/managerlogin_page.do", method = GET)
	public String managerloginPage() {
		return "manager/home/jsp/manager_login";
	}//loginPage
	
	@RequestMapping(value = "/login.do", method = POST)
	public String login(LoginVO lVO, HttpSession ss) {
		String url="redirect:user_mainhome.do";
		UserDomain ud = null;
		ud=us.searchMember(lVO);
		ss.setAttribute("id", ud.getId());
		ss.setAttribute("nick", ud.getNick());
		ss.setAttribute("img", ud.getImg());
		return url;
	}//login
	
	@RequestMapping(value = "/managerlogin.do", method = POST)
	public String managerlogin(ManagerLoginVO mlVO, HttpSession ss) {
		String url="";
		boolean flag=us.searchManager(mlVO);
		System.out.println(flag);
		if( flag ) {
			ss.setAttribute("manager_id", mlVO.getManager_id());
			url="redirect:mgr_home.do";
		} else {
			url="manager/home/jsp/manager_login";
		}
		return url;
	}//login
	
	@RequestMapping(value = "logout.do", method = GET)
	public String logout( SessionStatus ss, HttpSession session) {
		String url="redirect:user_mainhome.do";
		ss.setComplete();
		session.invalidate();
		return url;
	}//logout
	
	@RequestMapping(value = "/signUpAgree.do", method = GET)
	public String signUpAgreePage() {
		return "login/jsp/service_check";
	}
	
	@RequestMapping(value = "/tos1.do", method = GET)
	public String tos1() {
		return "login/jsp/tos1";
	}
	
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
	public String signUpPage2(HttpServletRequest request, HttpSession session, UserInfoVO uiVO) {
		String year=request.getParameter("year");
		String month=request.getParameter("month");
		String day=request.getParameter("day");
		String birth= year+"-"+month+"-"+day;
		System.out.println("Hello= "+month);
		System.out.println("Hello= "+birth);
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
	public String signUpPage3(HttpSession session, Model model, HttpServletRequest request) {
		return "login/jsp/join_end";
	}
	
	/**
	 * ���̵� �ߺ�Ȯ��
	 * @return
	 */
	@RequestMapping("/duplChkId.do")
	public String duplChkId() {
		return "";
	}
	
	/**
	 * �г��� �ߺ� Ȯ��
	 * @return
	 */
	@RequestMapping("duplChkNick.do")
	public String duplChkNick() {
		return "";
	}
	
	@RequestMapping(value = "/forgotId.do", method = GET)
	public String forgotUserId() {
		return "login/jsp/find_id";
	}
	
	@RequestMapping(value = "/forgotPw.do", method = GET)
	public String forgotUserPw() {
		return "login/jsp/find_pass";
	}
	
	@RequestMapping(value = "/forgotIdChk.do", method= POST) public String
	forgotUserIdChk(ForgotIdVO fiVO, Model model) { 
		String id="";
		id=us.searchId(fiVO); 
		model.addAttribute("id", id); 
		return "login/jsp/lolo";
	}
	 
	
	@RequestMapping(value = "/forgotPwChk.do", method = POST)
	public String forgotUserPwChk(ForgotPwVO fpVO, Model model) {
		String pass="";
		pass=us.searchPw(fpVO);
		model.addAttribute("id", fpVO.getId());
		model.addAttribute("pass", pass);
		return "login/jsp/lolo";
//		return "login/jsp/find_pass_popup";
	}
	
}//class
