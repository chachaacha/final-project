package potato.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class HomeController {

	//����ȭ�� ����
	@RequestMapping(value = "user_mainhome.do", method=GET)
	public String userHomeMove(HttpSession session, Model model) {
		return "mainhome/jsp/user_mainhome";
	}
	
	//���� ����
	@RequestMapping(value = "help.do", method=GET)
	public String helpMove() {
		return "cs/jsp/help";
	}
	
}
