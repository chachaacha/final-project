package potato.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import potato.dao.config.MyBatisHandler;
import potato.vo.WriteReviewImgVO;
import potato.vo.WriteReviewVO;

@Component
public class WriteDAO {

	//���� ���
	public int insertReview(WriteReviewVO wrVO) {
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		
		int cnt = ss.insert("potato.writeMapper.insReview",wrVO);
		if(cnt == 1) {
			ss.commit();
		}
		
		mbh.closeHandler(ss);
		return cnt;
	}
	
	//�߰��� �ްԼ� �ε��� ��ȯ
	public int selectNewReview(int restarea_idx) {
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		int idx = ss.selectOne("potato.writeMapper.selNewReview", restarea_idx);
		mbh.closeHandler(ss);
		return idx;
	}
	
	//���� �̹��� ���
	public int insertReviewImg(WriteReviewImgVO wrVO) {
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		
		int cnt = ss.insert("potato.writeMapper.upReReviewImg",wrVO);
		if(cnt == 1) {
			ss.commit();
		}
		
		mbh.closeHandler(ss);
		return cnt;
	}
	
	//���� ���� ���
	public int updateReReview(WriteReviewVO wrVO) {
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		
		int cnt = ss.update("potato.writeMapper.upReReview",wrVO);
		if(cnt != 0) {
			ss.commit();
		}
		
		mbh.closeHandler(ss);
		return cnt;
	}
	
	//�̹��� ���� 
	public int deleteReReviewImg(WriteReviewVO wrVO) {
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		
		int cnt = ss.delete("potato.writeMapper.delReReviewImg",wrVO);
		if(cnt != 0) {
			ss.commit();
		}
		mbh.closeHandler(ss);
		return cnt;
	}

}
