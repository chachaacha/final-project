package potato.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import potato.dao.config.MyBatisHandler;
import potato.domain.UserHomeMapDomain;
import potato.domain.UserHomeSliderDomain;

@Component
public class HomeDAO {
	
	//�����̵� �ްԼ� ��ũ
	//���󳲵�
	public List<UserHomeSliderDomain> selectRestInx1() {
		List<UserHomeSliderDomain> list=null;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		list=ss.selectList("potato.homeMapper.selectSlide1");
		
		mbh.closeHandler(ss);
		
		return list;
	}
	
	//������
	public List<UserHomeSliderDomain> selectRestInx2() {
		List<UserHomeSliderDomain> list=null;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		list=ss.selectList("potato.homeMapper.selectSlide2");
		
		mbh.closeHandler(ss);
		
		return list;
	}
	
	//������
	public List<UserHomeSliderDomain> selectRestInx3() {
		List<UserHomeSliderDomain> list=null;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		list=ss.selectList("potato.homeMapper.selectSlide3");
		
		mbh.closeHandler(ss);
		
		return list;
	}
	
	//��û�ϵ�
	public List<UserHomeSliderDomain> selectRestInx4() {
		List<UserHomeSliderDomain> list=null;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		list=ss.selectList("potato.homeMapper.selectSlide4");
		
		mbh.closeHandler(ss);
		
		return list;
	}
	
	//���� �� ����
	public List<UserHomeMapDomain> selectMapPin() {
		List<UserHomeMapDomain> list=null;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		list=ss.selectList("potato.homeMapper.selectMapPin");
		
		mbh.closeHandler(ss);
		
		return list;
	}
	
	//�湮�ڼ� ����
	public String insertVisitor(String ip) {
		String visitorCnt="";
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		
		visitorCnt=ss.selectOne("potato.homeMapper.insertVisitor", ip);
		
		mbh.closeHandler(ss);
		
		return visitorCnt;
	}

}
