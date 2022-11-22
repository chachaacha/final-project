package potato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import potato.dao.MyReviewDAO;
import potato.domain.MyReviewDomain;
import potato.vo.MyReviewVO;
import potato.vo.OtherReviewVO;

@Component
public class MyReviewService {
	
	@Autowired(required = false)
	private MyReviewDAO mrDAO;
	
	//������̹���
	public String searchMyImg(MyReviewVO mrVO){
		String  img = mrDAO.selMyImg(mrVO);
		return img;
	}
	
	//����ڴ�
	public String searchMyNick(MyReviewVO mrVO){
		String  nick = mrDAO.selMyNick(mrVO);
		return nick;
	}
	
	//������ȸ
	public List<MyReviewDomain> searchMyRevAll(MyReviewVO mrVO){
		List<MyReviewDomain> list = mrDAO.selMyRevAll(mrVO);
		return list;
	}
	
	
}//class
