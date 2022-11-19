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
	 //2.������ ���� 
	 newMemCnt=ss.selectOne("potato.manager.mgrHomeMapper.selectNewMemCnt");
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
	reportCnt=ss.selectOne("potato.manager.mgrHomeMapper.selectReportCnt");
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
	popOne=ss.selectOne("potato.manager.mgrHomeMapper.selectPopOne");
	//3. MyBatis Handler ����
	mbh.closeHandler(ss);
	 
		 return popOne;
	 }//selectPopOne
	
	/**
	 * ���� �ްԼ�(�ϸ�ũ)
	 * @return
	 */
	public String selectBookmark() {
		String bookmark=null;
		  
	//1. MyBatis Handler(SqlSession) ���
	MyBatisHandler mbh=MyBatisHandler.getInstance();
	SqlSession ss=mbh.getHandler();
	//2.������ ���� : �Է°� ���� �� ���ڵ��� ���� ����
	bookmark=ss.selectOne("potato.manager.mgrHomeMapper.selectBookmark");
	//3. MyBatis Handler ����
	mbh.closeHandler(ss);
	  
		 return bookmark;
	}//selectBookmark
	  
	 //�湮�� ��Ȳ (????)
	public List<Integer> selectVisitor(){
		return null;
	 }//selectVisitor
	 
	/**
	 * �湮�� ��Ȳ(����,����,��)
	 * @param visitFlag
	 * @return
	 */
	public int selectVisitorCnt(int visitFlag) { 
		int visitorCnt=0;
		
	//1. MyBatis Handler(SqlSession) ���
	MyBatisHandler mbh=MyBatisHandler.getInstance();
	SqlSession ss=mbh.getHandler();
	//2.������ ���� : �Է°� ���� �� ���ڵ��� ���� ����
	visitorCnt=ss.selectOne("potato.manager.mgrHomeMapper.selectVisitorCnt");
	//3. MyBatis Handler ����
	mbh.closeHandler(ss);	 
		
		return visitorCnt;
	 }//selectVisitorCnt
	 
	/**
	 * ȸ�� ��Ȳ(��ü)
	 * @return
	 */
	public int selectAllMem() {
		 int AllMemCnt=0;
	
	//1. MyBatis Handler(SqlSession) ���
	MyBatisHandler mbh=MyBatisHandler.getInstance();
	SqlSession ss=mbh.getHandler();
	//2.������ ���� : �Է°� ���� �� ���ڵ��� ���� ����
	AllMemCnt=ss.selectOne("potato.manager.mgrHomeMapper.selectAllMem");
	//3. MyBatis Handler ����
	mbh.closeHandler(ss);	 
		 
	 	return AllMemCnt;
	 }//selectAllMem
	
	/**
	 * ȸ�� ��Ȳ(Ż��)
	 * @return
	 */
	public int selectQuitMem() {
		int QuitMemCnt=0;
		
	//1. MyBatis Handler(SqlSession) ���
	MyBatisHandler mbh=MyBatisHandler.getInstance();
	SqlSession ss=mbh.getHandler();
	//2.������ ���� : �Է°� ���� �� ���ڵ��� ���� ����
	QuitMemCnt=ss.selectOne("potato.manager.mgrHomeMapper.selectQuitMem");
	//3. MyBatis Handler ����
	mbh.closeHandler(ss);	 
		
		return QuitMemCnt;
	}//selectQuitMem
	 
	/**
	 * �α� �ްԼ� ��ŷ
	 * @return
	 */
	public List<String> selectPopAll(){ 
		List<String> list=null;
	 
	//1. MyBatis Handler(SqlSession) ���
	MyBatisHandler mbh=MyBatisHandler.getInstance();
	SqlSession ss=mbh.getHandler();
	//2.������ ���� : �Է°� ���� �� ���ڵ��� ���� ����
	list=ss.selectOne("potato.manager.mgrHomeMapper.selectPopAll");
	//3. MyBatis Handler ����
	mbh.closeHandler(ss);	 	
		
		return list;
	}//selectPopAll
	
	 }//class
