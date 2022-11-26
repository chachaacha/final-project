package potato.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import potato.domain.OtherReviewDomain;
import potato.service.OtherReviewService;
import potato.vo.OtherReviewVO;

@Controller
public class OtherReviewController {
	
	@Autowired(required = false)
	private OtherReviewService ors;
///////////////////Ÿ����ڸ�����ȸ////////////////////
	
	//Ÿ����ڸ�����ȸ
	@RequestMapping(value="other_review.do", method= {POST,GET})
	public String otherReviewMove(HttpSession session, OtherReviewVO orVO, Model model) {
		//otherPid : Ŭ������ �� �ԷµǴ� ���̵�
		model.addAttribute("img",ors.searchOtherImg(orVO));
		model.addAttribute("nick",ors.searchOtherNick(orVO));
		model.addAttribute("rCnt",ors.searchOtherRev(orVO));
		
		//����¡����
		int totalData = ors.searchOtherRev(orVO);
		int lastPage = ors.lastPage(totalData);
		int curPage = orVO.getPageFlag();
		int startNum = ors.startNum(curPage);
		int isLast = ors.isLast(lastPage, startNum);
		
		List<OtherReviewDomain> list=ors.searchOtherRevAll(orVO);
		//view�� ����
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("startNum", startNum);
		model.addAttribute("isLast", isLast);
		model.addAttribute("curPage", curPage);
		model.addAttribute("rAll", list);
		System.out.println( "------------" + list );
		return  "other_profiles/jsp/other_user_profiles";
	}//otherReviewMove

}//class
