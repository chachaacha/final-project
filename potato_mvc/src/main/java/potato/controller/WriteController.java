package potato.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import potato.vo.WriteReviewVO;

@Controller
public class WriteController {

	//�����ۼ��Ϸ�
	@RequestMapping(value = "review_write.do", method={GET,POST})
	public String reviewWrite(HttpSession session, HttpServletRequest request, WriteReviewVO wrVO) {
		return "forward:user_detailed.do";
	}
	
	//���� ���� �ۼ��Ϸ�
	@RequestMapping(value = "re_review_write.do", method={GET,POST})
	public String reReviewWrite(HttpSession session, HttpServletRequest request, WriteReviewVO wrVO) {
		return "forward:user_detailed.do";
	}
	
}
