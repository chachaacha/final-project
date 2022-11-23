package potato.manager.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import potato.dao.config.MyBatisHandler;
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
public class MgrRestDAO {
	
	/**
	 * �ްԼҰ�������
	 * @param srVO
	 * @return
	 */
	public List<RestDomain> selectRest(SearchRestVO srVO) {
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		List<RestDomain> list = ss.selectList("potato.manager.rest.selectRestarea", srVO);
		mbh.closeHandler(ss);
		return list;
	}
	
	/**
	 * �뼱��������
	 * @return
	 */
	public List<LineDomain> selectLine() {
		List<LineDomain> list = null;
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		list = ss.selectList("potato.manager.rest.getLine");
		mbh.closeHandler(ss);
		return list;
	}
	
	/**
	 * �ްԼ� �� ��������
	 * @param srVO
	 * @return
	 */
	public int selectTotalRest(SearchRestVO srVO) {
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		int totalReview = ss.selectOne("potato.manager.rest.selectRestTotal", srVO);
		mbh.closeHandler(ss);
		return totalReview;
	}
	
	/**
	 * �ްԼ� ��â
	 * @param restarea_idx
	 * @return
	 */
	public RestDomain selectRestDetail(int restarea_idx) {
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		RestDomain rd = ss.selectOne("potato.manager.rest.selectRestDetail", restarea_idx); 
		mbh.closeHandler(ss);
		return rd;
	}
	
	//�ްԼһ�â�� ����â���û��
	public List<FoodDomain> selectRestFood(int restarea_idx) {
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		List<FoodDomain> list = ss.selectList("potato.manager.rest.selectFood", restarea_idx);
		mbh.closeHandler(ss);
		return list;
	}
	
	//����������
	public List<DoDomain> selectDo() {
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		List<DoDomain> list = ss.selectList("potato.manager.rest.getDo");
		mbh.closeHandler(ss);
		return list;
	}
	
	//�ްԼ� �߰�
	public int insertRest(RestVO rVO) {
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		int cnt = ss.insert("potato.manager.rest.insertRest", rVO);
		if(cnt == 1) {
			ss.commit();
		}
		mbh.closeHandler(ss);
		return cnt;
	}
	
	//�߰��� �ްԼ� �ε��� ��ȯ
	public int selectNewIdx(RestVO rVO) {
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		int idx = ss.selectOne("potato.manager.rest.selectNewIdx", rVO);
		mbh.closeHandler(ss);
		return idx;
	}
	
	//�ްԼ����� �߰�
	public int insertFood(List<FoodVO> list) {
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		int cnt = ss.insert("potato.manager.rest.insertFood",list);
		if(cnt == list.size()) {
			ss.commit();
		}
		mbh.closeHandler(ss);
		return cnt;
	}
	
	//�ްԼ� ���ǽü��߰�
	public int insertAmenity(AmenityVO amVO) {
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		int cnt = ss.insert("potato.manager.rest.insertAmt",amVO);
		ss.commit();
		mbh.closeHandler(ss);
		return cnt;
	}
	
	//�����ްԼ�����
	public RestDomain selectRestInfo(int restarea_idx) {
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		RestDomain rd = ss.selectOne("potato.manager.rest.selectModifyRest",restarea_idx );
		mbh.closeHandler(ss);
		return rd;
	}
		
	//�ްԼҼ���
	public int updateRest(RestVO rVO) {
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		int cnt = ss.update("potato.manager.rest.updateRest", rVO);
		if( cnt > 0) {
			ss.commit();
		}
		mbh.closeHandler(ss);
		return cnt;
	}
	
	//������ ���� �ްԼ� �̹��� �ҷ�����
	public String selectOldImg(int restarea_idx) {
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		String img = ss.selectOne("potato.manager.rest.selectOldImg", restarea_idx);
		mbh.closeHandler(ss);
		return img;
	}
	
	//�ްԼ� ������ ���� ���ǽü� ����
	public int deleteOldAmt(int restarea_idx) {
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		int cnt = ss.delete("potato.manager.rest.deleteAmt", restarea_idx);
		if(cnt > 0) {
			ss.commit();
		}
		mbh.closeHandler(ss);
		return cnt;
	}
	
	
	//�ްԼ� ����
	public int deleteRest(int restarea_idx) {
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		int cnt = ss.delete("potato.manager.rest.deleteRest", restarea_idx);
		if(cnt == 1) {
			ss.commit(); 
		}
		mbh.closeHandler(ss);
		return cnt;
	}
	
	//������ �ްԼҰ��� �̹��� ȣ��
	public DeleteImgDomain selectDelImg(int restarea_idx) {
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getHandler();
		DeleteImgDomain did = ss.selectOne("potato.manager.rest.selectDeleteImg", restarea_idx);
		mbh.closeHandler(ss);
		return did;
	}
	
	
}
