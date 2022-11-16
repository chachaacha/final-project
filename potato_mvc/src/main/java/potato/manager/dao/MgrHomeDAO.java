package potato.manager.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import potato.dao.config.MyBatisHandler;

public class MgrHomeDAO {
	
	/**
	 * ���� �ű԰��� ��
	 * @return
	 */
	public int selectNewMemCnt() {
		int newMemCnt=0;
		
	//1. MyBatis Handler(SqlSession) ���
	MyBatisHandler mbh=MyBatisHandler.getInstance();
	SqlSession ss=mbh.getHandler();
	//2.������ ���� : �Է°� ���� �� ���ڵ��� ���� ����
	newMemCnt=ss.selectOne("potato.manager.home.selectNewMemCnt");
	//3. MyBatis Handler ����
	mbh.closeHandler(ss);	
	
		return newMemCnt;		
	}//selectNewMemCnt
	
	/**
	 * ���� �Ű� ��
	 * @return
	 */
	public int selectReportCnt() {
		int reportCnt=0;
		
	//1. MyBatis Handler(SqlSession) ���
	MyBatisHandler mbh=MyBatisHandler.getInstance();
	SqlSession ss=mbh.getHandler();
	//2.������ ���� : �Է°� ���� �� ���ڵ��� ���� ����
	reportCnt=ss.selectOne("potato.manager.home.selectReportCnt");
	//3. MyBatis Handler ����
	mbh.closeHandler(ss);	
	
		return reportCnt;
	}//selectReportCnt
	
	/**
	 * �α� �ްԼ�(����+����)
	 * @return
	 */
	public String selectPopOne() {
		String popOne=null;
		
	//1. MyBatis Handler(SqlSession) ���
	MyBatisHandler mbh=MyBatisHandler.getInstance();
	SqlSession ss=mbh.getHandler();
	//2.������ ���� : �Է°� ���� �� ���ڵ��� ���� ����
	popOne=ss.selectOne("potato.manager.home.selectPopOne");
	//3. MyBatis Handler ����
	mbh.closeHandler(ss);	
		
		return popOne;		
	}//selectPopOne
	
	
	//�����ްԼ�(�ϸ�ũ)
	public String selectBookmarkRest() {
		return null;
	}//selectBookmarkRest
	
	//�湮�� �� ��Ȳ
	public List<Integer> selectVisitor(){
		return null;
	}//selectVisitor
	
	//ȸ�� �� ��Ȳ
	public List<Integer> selectMember(){
		return null;
	}//selectMember
	
	//�湮�� ��Ȳ(����,����)
	public int selectDayVisitor(int visitFlag) {
		return 0;
	}//selectDayVisitor
	
	//�湮�� ��Ȳ(�ְ�)
	public int selectWeekVisitor() {
		return 0;
	}//selectWeekVisitor
	
	//ȸ�� ��Ȳ
	public int selectMemberStatus(int visitFlag) {
		return 0;
	}//selectMemberStatus
	
	//�ްԼҷ�ŷ
	public List<String> selectPopAll(){
		List<String> list=null;
		
	//1. MyBatis Handler(SqlSession) ���
	MyBatisHandler mbh=MyBatisHandler.getInstance();
	SqlSession ss=mbh.getHandler();
	//2.������ ���� : �Է°� ���� �� ���ڵ��� ���� ����
	list=ss.selectOne("potato.manager.home.selectPopAll");
	//3. MyBatis Handler ����
	mbh.closeHandler(ss);	
			
		return list;
	}//selectPopAll
}
