package potato.manager.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import potato.manager.dao.MgrRestDAO;
import potato.manager.domain.DeleteImgDomain;
import potato.manager.domain.DoDomain;
import potato.manager.domain.FoodDomain;
import potato.manager.domain.LineDomain;
import potato.manager.domain.RestDomain;
import potato.manager.vo.AmenityVO;
import potato.manager.vo.FoodVO;
import potato.manager.vo.RestVO;
import potato.manager.vo.SearchRestVO;

@Component
public class ManagerRestService {
	@Autowired(required = false)
	private MgrRestDAO mrDAO;
	
	//�ްԼҰ�������
	public List<RestDomain> searchRest(SearchRestVO srVO) {
		List<RestDomain> list = mrDAO.selectRest(srVO);
		return list;
	}
	
	//�뼱��������
	public List<LineDomain> searchLine() {
		List<LineDomain> list = mrDAO.selectLine();
		return list;
	}
	
	//���ްԼҰ�������
	public int searchTotalRest(SearchRestVO srVO) {
		int totalReview = mrDAO.selectTotalRest(srVO);
		return totalReview;
	}
	
	//���������������ϱ�
	public int lastPage(int totalReview) {
		int lastPage = (int)Math.ceil((double)totalReview/10);
		return lastPage ;
	}
	
	//���� ���������� ����������
	public int startNum(int curPage) {
		int startNum = curPage-(curPage-1)%3;
		return startNum;
	}
	
	//���� ���ϴ� ������ ������ ���� ���� �ְ� ���࿡ �ʰ��� ��� isLast�� �Ű������� ���� set
	public int isLast(int lastPage, int startNum) {
		int isLast=2;
		if(startNum +3 > lastPage) {
			isLast = lastPage - startNum;
		}
		return isLast;
	}
	
	//�ްԼ� ��
	public RestDomain searchRestDetail(int restarea_idx) {
		RestDomain rd = mrDAO.selectRestDetail(restarea_idx);
		return rd;
	}
	
	//�ްԼһ�â�� ����â���û��
	public List<FoodDomain> searchRestFood(int restarea_idx) {
		List<FoodDomain> list = mrDAO.selectRestFood(restarea_idx);
		return list;
	}
	
	//����������
	public List<DoDomain> searchDo() {
		List<DoDomain> list = mrDAO.selectDo();
		return list;
	}
	
	//�ްԼ��߰�
	public int addRest(RestVO rVO) {
		int cnt = mrDAO.insertRest(rVO);
		return cnt;
	}
	
	//�߰����ްԼ��� �ε�����������
	public int searchNewIdx(RestVO rVO) {
		int idx = mrDAO.selectNewIdx(rVO);
		return idx;
	}
	
	//�ްԼ� �����߰��ϱ�
	public int addFood(List<FoodVO> list) {
		int cnt = mrDAO.insertFood(list);
		return cnt;
	}
	
	//�ްԼ� ���ǽü��߰��ϱ�
	public int addAmenity(AmenityVO amVO) {
		int cnt = mrDAO.insertAmenity(amVO);
		return cnt;
	}
	
	//�����ްԼ�����
	public RestDomain searchRestInfo(int restarea_idx) {
		RestDomain rd = mrDAO.selectRestInfo(restarea_idx);
		return rd;
	}
		
	//�ްԼ� ����
	public int modifyRest(RestVO rVO) {
		int cnt = mrDAO.updateRest(rVO);
		return cnt;
	}
	
	//�ްԼ� ������ �̹��� ȣ��
	public String searchOldImg(int restarea_idx) {
		String img = mrDAO.selectOldImg(restarea_idx);
		return img;
	}
	
	//�ްԼ� ������, ���� ������ �̹������� ���� 
	public void removeOldImg(String img) {
		File imgFile =new File("C:/Users/user/git/potato_mvc/potato_mvc/src/main/webapp/css/images/"+img);
		imgFile.delete();
	}
	
	//�ްԼ� ������ ���� ���ǽü� ����
	public int removeOldAnt(int restarea_idx) {
		int cnt = mrDAO.deleteOldAmt(restarea_idx);
		return cnt;
	}
	
	//���Ļ��� ���� �� �߰��� ���� AJAXó��
	public void modifyFoodImgAJAX(HttpServletRequest request) {
		File saveDir = new File("C:/Users/user/git/potato_mvc/potato_mvc/src/main/webapp/css/images/");
		int maxSize=1024*1024*20;
		int cnt = 0;
		try {
			//�̹������� �߰�
			MultipartRequest mr = new MultipartRequest(request, saveDir.getAbsolutePath(), maxSize, "UTF-8", new DefaultFileRenamePolicy());
			FoodVO fVO = new FoodVO();
			
			//ajax���� �Ѿ�� �� VO����
			fVO.setRestarea_idx(Integer.parseInt(mr.getParameter("restarea_idx")));
			fVO.setFood_idx(Integer.parseInt(mr.getParameter("food_idx")));
			fVO.setImg(mr.getFilesystemName("upFile"));
			
			//������ �̹����� �ҷ��� �������
			String delImg = mrDAO.selectDelFoodImg(fVO);
			
			//�����ε����� �����Ѵٸ�
			if(mrDAO.selectIsFoodIdx(fVO) > 0) {
				cnt = mrDAO.updateFoodImg(fVO); //������Ʈ�� ����
				if(cnt == 1) {
					removeOldImg(delImg);//�����̹��������� ����
				}
			} else { // �����ε����� �������� �ʴ´ٸ�
				//�μ�Ʈ ����
				mrDAO.insertUpdatedFoodImg(fVO);
			}
		}catch( IOException ie){	
		  ie.printStackTrace();
		}
	}
	
	//���������� �������̺� ���ڵ� ����
	public int removeFoodAJAX(FoodVO fVO) {
		//������ ���� �̹��� �ҷ�����
		String delImg =  mrDAO.selectDelFoodImg(fVO);
		
		//�������̺� ���ڵ� ������ ������
		int cnt = mrDAO.deleteFood(fVO);
		if(cnt == 1) {
			removeOldImg(delImg); //�ش� �̹��� ���� ����
		}
		return cnt;
	}
	
	//���������� �������� ���� �� �߰��� ���� AJAX
	public void modifyFoodInfoAJAX(FoodVO fVO) {
		if(mrDAO.selectIsFoodIdx(fVO) > 0) {
			//������Ʈ����
			mrDAO.updateFoodInfo(fVO);
		} else {
			//insert����
			mrDAO.insertUpdatedFoodInfo(fVO);
		}
	}
	
	//�ްԼһ���
	public int removeRest(int restarea_idx) {
		int cnt = mrDAO.deleteRest(restarea_idx);
		return cnt;
	}
	
	//�ްԼ� ������ ������ ���̺��� �ε����� �� �̹��� ���ϸ� ���� ȣ��
	public DeleteImgDomain searchImg(int restarea_idx) {
		DeleteImgDomain did= mrDAO.selectDelImg(restarea_idx);
		return did;
	}
	
	//�ްԼ� ���� �� �̹��������� ������ ó���ϴ� �ż���
	public void removeImg(DeleteImgDomain did) {
		removeOldImg(did.getImg());
		
		String[] foodImgs = did.getFoodImg().split(",");
		
		File foodImgFile = null;
		for(String imgs : foodImgs) {
			foodImgFile = new File("C:/Users/user/git/potato_mvc/potato_mvc/src/main/webapp/css/images/"+imgs);
			foodImgFile.delete();
		}
	}
}
