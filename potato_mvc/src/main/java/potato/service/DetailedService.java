package potato.service;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import potato.dao.DetailedDAO;
import potato.domain.DetailedAmenityDomain;
import potato.domain.DetailedDomain;
import potato.domain.DetailedFoodDomain;
import potato.domain.DetailedReportDomain;
import potato.domain.DetailedReviewDomain;
import potato.vo.DetailedBookmarkVO;
import potato.vo.DetailedLikeVO;
import potato.vo.DetailedReportVO;
import potato.vo.DetailedReviewVO;

@Component
public class DetailedService {

	@Autowired(required = false)
	private DetailedDAO dDAO;
	
	//<�ްԼ� ��â>
	//�ްԼ� ��â ���� �ҷ�����
	public DetailedDomain getRestDetailed(int restarea_idx) {
		DetailedDomain dd=null;
		dd=dDAO.selectRestDetailed(restarea_idx);
		return dd;
	}
	
	//�ްԼ� �ϸ�ũ total
	public int getBookmarkTotal(int restarea_idx) {
		int booktotal=0;
		booktotal=dDAO.selectBookmarkTotal(restarea_idx);
		return booktotal;
	}
	
	//�ްԼ� �ϸ�ũ ����
	public int getBookmarkChk(DetailedBookmarkVO dbVO) {
		return 0;
	}
	
	//�ްԼ� �ϸ�ũ �߰� (�񵿱�)
	public int setBookmarkAdd(DetailedBookmarkVO dbVO) {
		return 0;
	}
	
	//�ްԼ� �ϸ�ũ ���� (�񵿱�)
	public int setBookmarkDel(DetailedBookmarkVO dbVO) {
		return 0;
	}
	
	//�ްԼ� ���� total
	public int getRateTotal(int restarea_idx) {
		int startotal=0;
		startotal=dDAO.selectRateTotal(restarea_idx);
		return startotal;
	}
	
	//�ްԼ� ���� ����
	public List<DetailedFoodDomain> getFoodDatailed(int restarea_idx) {
		List<DetailedFoodDomain> dfd=null;
		dfd=dDAO.selectFoodDatailed(restarea_idx);
		return dfd;
	}
	
	//�ްԼ� ���ǽü�������
	public List<DetailedAmenityDomain> getAmenityImg(int restarea_idx) {
		List<DetailedAmenityDomain> dad=null;
		dad=dDAO.selectAmenityImg(restarea_idx);
		return dad;
	}
	
	//<�ްԼ� ����>
	//���� �ۼ�â �̵�
	public DetailedReviewDomain moveReviewWrite(int restarea_idx) {
		return null;
	}
	
	//���� ����â �̵�
	public DetailedReviewDomain moveReReviewWrite(DetailedReviewVO drVO) {
		return null;
	}
	
	//���� �� total
	public int getReviewTotal(int restarea_idx) {
		int reviewtotal=0;
		reviewtotal=dDAO.selectReviewTotal(restarea_idx);
		return reviewtotal;
	}
	
	//���� ��ȸ(�񵿱�)
	public String getReviewAll(DetailedReviewVO drVO) {
		List<DetailedReviewDomain> list=null;
		list=dDAO.selectReviewAll(drVO);
		System.out.println(drVO+"findMe");
		System.out.println(list+"findMe");
		JSONObject jsonObj=null;
		JSONObject jo=null;
		JSONArray js=new JSONArray();

		for(DetailedReviewDomain dd: list) {
			jo=new JSONObject();
			jo.put("contents", dd.getContents());
			jo.put("foodImg", dd.getFoodimg());
			jo.put("id", dd.getId());
			jo.put("img", dd.getImg());
			jo.put("liked", dd.getLiked());
			jo.put("likeTotal", dd.getLikeTotal());
			jo.put("nick", dd.getNick());
			jo.put("post_date", dd.getPost_date());
			jo.put("rating", dd.getRating());
			jo.put("review_idx", dd.getReview_idx());
			js.add(jo);
		}//end for
		System.out.println(js+"find me");
		
		jsonObj.put("review", js);
		
		
		return jsonObj.toJSONString();
	}
	
	//����¡ ó�� ���� 
	public int getStartPageNum() {
		return 0;
	}
	
	//����¡ ������ ������
	public int getLastPageNum(int total) {
		return 0;
	}
	
	//����¡ �⺻ ������ ��
	public int getPageScale() {
		return 0;
	}
	
	//Ÿ����� ������ �̵�
	public DetailedReviewDomain moveOtherProfile(String id) {
		return null;
	}
	
	//���� ���ƿ� total
	public int getLikeTotal(DetailedLikeVO dlVO) {
		return 0;
	}
	
	//���� ���ƿ� �߰�
	public int getLikeAdd(DetailedLikeVO dlVO) {
		return 0;
	}
	
	//���� ���ƿ� ����
	public int getLikeDel(DetailedLikeVO dlVO) {
		return 0;
	}
	
	//���� ����
	public int getReviewDel(DetailedReviewVO drVO) {
		return 0;
	}
	
	//<�Ű�â>
	//�Ű�â ����
	public List<DetailedReportDomain> getReportPopup() {
		return null;
	}
	
	//�Ű� ����
	public int setReportPopup(DetailedReportVO drVO) {
		return 0;
	}
	
}
