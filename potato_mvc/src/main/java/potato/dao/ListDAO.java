package potato.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import potato.dao.config.MyBatisHandler;
import potato.domain.DetailedDomain;
import potato.domain.ListMapPinDomain;
import potato.domain.RestAreaListDomain;
import potato.vo.DoSearchVO;
import potato.vo.SearchFlagVO;

@Component
public class ListDAO {
	
	//��ü�ްԼ� ��� �����ֱ�
	public List<RestAreaListDomain> selectAllRestAreaList(SearchFlagVO sfVO){
		List<RestAreaListDomain> list=null;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		list=ss.selectList("potato.listMapper.allRestAreaList",sfVO);
		
		mbh.closeHandler(ss);
		
		return list;
	}//selectAllRestAreaList
	
	//��ӵ��� ��ư Ŭ���� �� �ҷ�����
	//��ΰ�ӵ���
	public List<ListMapPinDomain> selectPin1(){
		List<ListMapPinDomain> list=null;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		list=ss.selectList("potato.listMapper.highwayMapPin1");
				
		return list;
	}
	//���ذ�ӵ���
	public List<ListMapPinDomain> selectPin2(){
		List<ListMapPinDomain> list=null;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		list=ss.selectList("potato.listMapper.highwayMapPin2");
		
		return list;
	}
	//���ؾȰ�ӵ���
	public List<ListMapPinDomain> selectPin3(){
		List<ListMapPinDomain> list=null;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		list=ss.selectList("potato.listMapper.highwayMapPin3");
		
		return list;
	}
	//������ӵ���
	public List<ListMapPinDomain> selectPin4(){
		List<ListMapPinDomain> list=null;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		list=ss.selectList("potato.listMapper.highwayMapPin4");
		
		return list;
	}
	//�ߺγ�����ӵ���
	public List<ListMapPinDomain> selectPin5(){
		List<ListMapPinDomain> list=null;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		list=ss.selectList("potato.listMapper.highwayMapPin5");
		
		return list;
	}
	
	//�� Ŭ���� �ްԼ� ��� �����ֱ�
	public List<RestAreaListDomain> selectDoList(DoSearchVO dsVO){
		List<RestAreaListDomain> list = null;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		list=ss.selectList("potato.listMapper.doList",dsVO);
		
		return list;
	}//selectDoList
	
	//�� �ްԼ� ��Ͽ��� �˻�, ����
	public List<RestAreaListDomain> selectSearchArrangeDo(SearchFlagVO sfVO){
		
		return null;
	}
	
	//�ްԼ� ��Ͽ��� ��â���� �̵�
	public DetailedDomain selectDetailPage(int restarea_idx) {
		
		return null;
	}
	
	//����¡
	public int selectTotalPages(SearchFlagVO sfVO) {
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession session=mbh.getHandler();
		int cnt=session.selectOne("potato.listMapper.listPage",sfVO);
		
		return cnt;
	}
	//����¡(�� �ްԼ� ���)
	public int selectDoTotalPages(DoSearchVO dsVO) {
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession session=mbh.getHandler();
		int cnt=session.selectOne("potato.listMapper.doListPage",dsVO);
		
		return cnt;
	}
	
	//�����˻���(ajax)
	public String searchKeywordList(String keyword) {
		
		return null;
	}
}
