package potato.manager.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

import potato.manager.vo.MgrPassChangeVO;

@Controller
public class MgrPassChangeController {
	
	//��� ���� ȭ�� ��������
	public String passChange(HttpSession session) {
		
		return "manager/pass_change/jsp/manager_password_change";
	}
	
	//��� ���� �� �α��� �������� �̵�
	public String moveLogin(MgrPassChangeVO mpcVO) {
		
		return "manager/home/jsp/login";
	}
}
