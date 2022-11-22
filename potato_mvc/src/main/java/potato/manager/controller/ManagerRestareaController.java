package potato.manager.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import potato.manager.service.ManagerRestService;
import potato.manager.vo.AmenityVO;
import potato.manager.vo.FoodVO;
import potato.manager.vo.RestVO;
import potato.manager.vo.SearchRestVO;

@Controller
public class ManagerRestareaController {
	@Autowired(required = false)
	private ManagerRestService mrs;
	
	
	@RequestMapping(value="manager_restarea.do",method= {GET, POST})
	public String restMain(SearchRestVO srVO, Model model, HttpSession session) {
		String url="manager/rest_management/jsp/manager_rest_management";
		/*
		 * ����ó���ϸ� �ּ�Ǯ��
		if(session.getAttribute("manager_id")==null) {
			url="forward:managerlogin_page.do";
		}
		*/
		
		//����¡
		int totalReview = mrs.searchTotalRest(srVO);
		int lastPage = mrs.lastPage(totalReview);
		int curPage = srVO.getPageFlag();
		int startNum = mrs.startNum(curPage);
		int isLast = mrs.isLast(lastPage, startNum);
		
		//view����
		model.addAttribute("restList", mrs.searchRest(srVO));
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("curPage", curPage);
		model.addAttribute("startNum", startNum);
		model.addAttribute("isLast", isLast);
		model.addAttribute("lineList", mrs.searchLine());
		return url;
	}
	
	
	@RequestMapping(value="manager_restdetailPopup.do",method=POST)
	public String restDetailPopup(int restarea_idx, Model model) {
		model.addAttribute("detail", mrs.searchRestDetail(restarea_idx));
		model.addAttribute("foodList", mrs.searchRestFood(restarea_idx));
		return "manager/rest_management/jsp/rest_popup";
	}
	
	@RequestMapping(value="manager_writePopup.do", method=GET)
	public String openWriteRest(Model model) {
		model.addAttribute("lineList", mrs.searchLine());
		model.addAttribute("doList", mrs.searchDo());
		return "manager/rest_management/jsp/manager_rest_write_popup";
	}
	
	@RequestMapping(value="manager_rest_add.do", method=POST)
	public String newRest(HttpServletRequest request) {
		File saveDir = new File("C:/Users/user/git/potato_mvc/potato_mvc/src/main/webapp/css/images/");
		int maxSize=1024*1024*20;
		try {
			MultipartRequest mr = new MultipartRequest(request, saveDir.getAbsolutePath(), maxSize, "UTF-8", new DefaultFileRenamePolicy());
			RestVO rVO = new RestVO();
			
			//�ްԼ� ���̺� �Է� �Ķ���� ó��
			rVO.setName(mr.getParameter("restName"));
			rVO.setImg(mr.getFilesystemName("upFile"));
			rVO.setLat(parseDouble(mr.getParameter("lat")));
			rVO.setLng(parseDouble(mr.getParameter("lng")));
			rVO.setDo_idx(parseInt(mr.getParameter("doIdx")));
			rVO.setLine_idx(parseInt(mr.getParameter("lineIdx")));
			rVO.setTel(mr.getParameter("tel"));
			rVO.setCarwash_chk(mr.getParameter("washChk"));
			if(mr.getParameter("washChk") == null) {
				rVO.setCarwash_chk("N");
			}
			rVO.setRepair_chk(mr.getParameter("repairChk"));
			if(mr.getParameter("repairChk") == null) {
				rVO.setRepair_chk("N");
			}
			rVO.setCargolounge_chk(mr.getParameter("cargoChk"));
			if(mr.getParameter("cargoChk") == null) {
				rVO.setCargolounge_chk("N");
			}
			
			//�ްԼ� ���̺� ��������Ȯ��
			int restResultCnt = mrs.addRest(rVO);
			
			//�ްԼ����̺� �߰������� ����, �ü����̺� �߰�
			if(restResultCnt == 1) {
				int idx = mrs.searchNewIdx(rVO); // �߰��� �ε�����ȯ
				
				//���� ���̺�� �Ķ����
				List<FoodVO> foodList = new ArrayList<FoodVO>();
				FoodVO fVO = null;
				for(int i =0; i<mr.getParameterValues("foodName").length; i ++) {
					fVO = new FoodVO();
					fVO.setRestarea_idx(idx);
					fVO.setFood_idx(i+1);
					fVO.setImg(mr.getFilesystemName("foodFile"+i));
					fVO.setName(mr.getParameterValues("foodName")[i]);
					fVO.setPrice(parseInt(mr.getParameterValues("foodPrice")[i]));
					fVO.setContents(mr.getParameterValues("foodConts")[i]);
					fVO.setIngredient(mr.getParameterValues("foodIng")[i]);
					if(mr.getParameter("radio"+i).equals("main")) {
						fVO.setMain_chk("Y");
						fVO.setRec_chk("N");
					} else if(mr.getParameter("radio"+i).equals("good")) {
						fVO.setMain_chk("N");
						fVO.setRec_chk("Y");
					} else {
						fVO.setMain_chk("N");
						fVO.setRec_chk("N");
					}
					foodList.add(fVO);
				}//end for
				mrs.addFood(foodList);
				
				//�ްԼ� ���̺�� �Ķ����
				AmenityVO amVO = new AmenityVO();
				amVO.setRestarea_idx(idx);
				if(mr.getParameterValues("restIcons") != null) {
					amVO.setRestIcons(mr.getParameterValues("restIcons"));
				}
				
				if(mr.getParameterValues("gasIcons") != null) {
					amVO.setGasIcons(mr.getParameterValues("gasIcons"));
				}
				
				if(mr.getParameterValues("restIcons") != null || mr.getParameterValues("gasIcons") != null) {
					mrs.addAmenity(amVO);
				}
				request.setAttribute("result", "success");
			}
			
		} catch(IOException ie) {
			ie.printStackTrace();
		}
		
		
		return "manager/rest_management/jsp/manager_rest_write_popup";
	}
	
	
	@RequestMapping(value="manager_rest_modifyPopup.do",method=GET)
	public String restModifyPopup() {//�Ű������� int �ް��� �ε����� model�߰�
		
		return "manager/rest_management/jsp/manager_rest_modify_popup";
	}
	
	@RequestMapping(value="manager_rest_modify.do")
	public String restModify(HttpServletRequest request) {
		
		return "manager/rest_management/jsp/manager_rest_modify_popup";
	}
	
	@RequestMapping(value="manager_removeRest.do",method=GET)
	public String delRest(int restarea_idx) {
		
		return "manager/rest_management/jsp/rest_popup";
	}

}
