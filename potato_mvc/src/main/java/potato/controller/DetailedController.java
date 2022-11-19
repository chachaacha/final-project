package potato.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import potato.domain.DetailedReviewDomain;
import potato.service.DetailedService;
import potato.vo.DetailedReportVO;
import potato.vo.DetailedReviewVO;

@Controller
public class DetailedController {
	
	@Autowired(required = false)
	private DetailedService ds;

	//�ްԼ� ��â ����
	@RequestMapping(value = "user_detailed.do", method=GET)
	public String userDetailedMove(int restarea_idx, Model model) {
		
		model.addAttribute("rd", ds.getRestDetailed(restarea_idx));
		model.addAttribute("bt", ds.getBookmarkTotal(restarea_idx));
		model.addAttribute("rt", ds.getRateTotal(restarea_idx));
		model.addAttribute("fd", ds.getFoodDatailed(restarea_idx));
		model.addAttribute("ai", ds.getAmenityImg(restarea_idx));
		model.addAttribute("rt", ds.getReviewTotal(restarea_idx));
		
		return "detailed/jsp/user_detailed";
	}
	
	//�ްԼ� ���ã�� �߰� �Ǵ� ����(�񵿱�)
	@ResponseBody
	@RequestMapping(value = "ajax_detailed_bookmark.do", method=GET)
	public String enterBookMark(HttpSession session, int restarea_idx) {
		String ajax_json="";
		return ajax_json;
	}

	//�����ۼ�â ����
	@RequestMapping(value = "write.do", method=GET)
	public String writePageMove(HttpSession session, int restarea_idx, Model model) {
		return "detailed/jsp/write";
	}
	
	//�������â ����
	@RequestMapping(value = "rewrite.do", method=GET)
	public String rewritePageMove(HttpSession session, DetailedReviewVO drVO, Model model) {
		return "detailed/jsp/rewrite";
	}
	
	//�ްԼ� ���� + ��ư ����¡ (�񵿱�)
	@ResponseBody
	@RequestMapping(value = "ajax_detailed_page.do", method=GET)
	public String reviewPageFilter(HttpServletRequest request, DetailedReviewVO drVO, Model model) {
		/*
		 * drVO.setDateFlag(Integer.parseInt(request.getParameter("dataFlag")));
		 * drVO.setRestarea_idx(Integer.parseInt(request.getParameter("restarea_idx")));
		 * drVO.setAddFlag(Integer.parseInt(request.getParameter("addFlag")));
		 */
		/* System.out.println(drVO+"findMe"); */
		String ajax_json=ds.getReviewAll(drVO);
		/* model.addAttribute("aj", ajax_json); */
		return ajax_json;
	}
	
	//Ÿ����� ������ �̵�
	@RequestMapping(value = "detailed_other_profiles.do", method=GET)
	public String otherProFileMove(HttpSession session, String id, Model model) {
		return "other_profiles/jsp/other_user_profiles";
	}
	
	//���� �Ű�â ����
	@RequestMapping(value = "report_review_popup.do", method=GET)
	public String reportPopup(HttpSession session, String id_writer, Model model) {
		return "detailed/jsp/report_review_popup";
	}
	
	//���� �Ű� ����(�񵿱�.. ?)
	@ResponseBody
	@RequestMapping(value = "ajax_detailed_report.do", method=GET)
	public String setReport(DetailedReportVO drVO) {
		String ajax_json="";
		return ajax_json;
	}
	
	//���� ����
	@RequestMapping(value = "detailed_review_delete.do", method=GET)
	public String deleteReview(HttpSession session, String id_writer, Model model) {
		return "detailed/jsp/user_detailed";
	}
	
	
}
