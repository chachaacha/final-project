package potato.manager.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import potato.manager.service.ManagerReviewService;
import potato.manager.vo.ReviewVO;
import potato.manager.vo.SearchReviewVO;

@Controller
public class ManagerReviewController {

	@Autowired(required = false)
	private ManagerReviewService mrs;

	@RequestMapping(value = "manager_review.do", method = GET)
	public String reviewMain(SearchReviewVO srVO, Model model, HttpSession session) {
		String url = "manager/review_management/jsp/manager_review_management";
		/*
		 * ����ó���ϸ� �ּ�Ǯ�� if(session.getAttribute("manager_id")==null) {
		 * url="forward:managerlogin_page.do"; }
		 */

		if (srVO.getSearchType() != null && !"".equals(srVO.getSearchType())) {
			if (srVO.getSearchType().equals("1")) {
				srVO.setSearchType("ra.name");
			} else if (srVO.getSearchType().equals("2")) {
				srVO.setSearchType("re.contents");
			} else {
				srVO.setSearchType("re.id");
			}
		}

		model.addAttribute("reviewList", mrs.searchReview(srVO));

		return url;
	}

	@ResponseBody
	@RequestMapping(value = "manager_review_ajax.do", method = GET)
	public String keywordList(String keyword) {
		String json = "";

		return json;
	}

	@RequestMapping(value = "manager_multipleReviews_delete.do", method = POST)
	public String delReviews(String[] revIdxArr) {

		return "manager/review_management/jsp/manager_review_management";
	}

	@RequestMapping(value = "manager_open_reviewPopup.do", method = GET)
	public String openPopup(ReviewVO rVO, Model model) {

		return "manager/review_management/jsp/my_review_popup";
	}

	@RequestMapping(value = "manager_singleReview_delete.do", method = POST)
	public String delReview(ReviewVO rVO) {

		return "manager/review_management/jsp/manager_review_popup";
	}
}
