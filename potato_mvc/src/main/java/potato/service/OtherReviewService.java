package potato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import potato.dao.OtherReviewDAO;
import potato.domain.OtherReviewDomain;
import potato.vo.OtherReviewVO;

@Component
public class OtherReviewService {
	
	@Autowired(required = false)
	private OtherReviewDAO orDAO;
	
	//������̹���
	public String searchOtherImg(OtherReviewVO orVO){
		String  img = orDAO.selOtherImg(orVO);
		return img;
	}
	
	//����ڴ�
	public String searchOtherNick(OtherReviewVO orVO){
		String  nick = orDAO.selOtherNick(orVO);
		return nick;
	}
	
	//������ȸ
	public List<OtherReviewDomain> searchOtherRevAll(OtherReviewVO orVO){
		List<OtherReviewDomain> list = orDAO.selOtherRevAll(orVO);
		return list;
	}
	
	//��ü�����
	public int searchOtherRev(OtherReviewVO orVO) {
		int otherRev=orDAO.selOtherRev(orVO);
		return otherRev;
	}//searchOtherRev
	

	
	
	
}//class
