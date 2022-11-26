package potato.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import potato.service.UserService;
import potato.vo.LoginVO;

@Controller
public class ConnectionController {
	
	@Autowired(required = false)
	private UserService us;
	
	//���������� ����ȭ��
		@RequestMapping(value="myPageIn2.do", method=GET)
		public String myPageIn(HttpSession session,String pass, LoginVO LVO) {
			return "mypages/jsp/mypage_in2";
		}//myPageIn
	
	//���̵�, ��й�ȣ Ȯ��
	@RequestMapping(value="chkIdPass2.do",method=POST)
	public String chkIdPass(HttpSession session, LoginVO LVO,Model model) {
		String result="redirect:my_review.do";
		LVO.setId((String)session.getAttribute("id"));
		int cnt = us.searchMember(LVO);
		if(  cnt == 1 ) {
			result= "redirect:my_review.do";
		}else {
			session.setAttribute("passFlag", false);
		}
		return result;
	}//chkIdPass

}//class
