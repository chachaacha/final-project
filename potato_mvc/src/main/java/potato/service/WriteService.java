package potato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import potato.dao.WriteDAO;
import potato.vo.WriteReviewImgVO;
import potato.vo.WriteReviewVO;

@Component
public class WriteService {
	
	@Autowired(required = false)
	private WriteDAO wDAO;

	//���� ���
	public int setReview(WriteReviewVO wrVO) {
		int idx = wDAO.insertReview(wrVO);
		return idx;
	}
	
	//�߰����ްԼ��� �ε�����������
	public int searchNewIdx(int restarea_idx) {
		int idx = wDAO.selectNewReview(restarea_idx);
		return idx;
	}
	
	//���� �̹��� ���
	public int setReviewImg(WriteReviewImgVO wrVO) {
		int cnt = wDAO.insertReviewImg(wrVO);
		return cnt;
	}
	
	//���� ���� ���
	public int setReReview(WriteReviewVO wrVO) {
		return 0;
	}
	
	//�̹��� ���� 
	public int delReReviewImg(WriteReviewImgVO wrVO) {
		return 0;
	}
	
}
