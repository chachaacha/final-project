package potato.manager.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import potato.dao.config.MyBatisHandler;

public class MgrHomeDAO {

	/**
	 * ���� �ű԰��� ��
	 * 
	 * @return
	 */
	/*
	 * public int selectNewMemCnt() { int newMemCnt=0;
	 * 
	 * //1. MyBatis Handler(SqlSession) ��� MyBatisHandler
	 * mbh=MyBatisHandler.getInstance(); SqlSession ss=mbh.getHandler(); //2.������ ����
	 * : �Է°� ���� �� ���ڵ��� ���� ����
	 * newMemCnt=ss.selectOne("potato.mgrHomeMapper.selectNewMemCnt"); //3. MyBatis
	 * Handler ���� mbh.closeHandler(ss);
	 * 
	 * return newMemCnt; }//selectNewMemCnt
	 * 
	 *//**
		 * ���� �Ű� ��
		 * 
		 * @return
		 */
	/*
	 * public int selectReportCnt() { int reportCnt=0;
	 * 
	 * //1. MyBatis Handler(SqlSession) ��� MyBatisHandler
	 * mbh=MyBatisHandler.getInstance(); SqlSession ss=mbh.getHandler(); //2.������ ����
	 * : �Է°� ���� �� ���ڵ��� ���� ����
	 * reportCnt=ss.selectOne("potato.mgrHomeMapper.selectReportCnt"); //3. MyBatis
	 * Handler ���� mbh.closeHandler(ss);
	 * 
	 * return reportCnt; }//selectReportCnt
	 * 
	 *//**
		 * �α� �ްԼ�(����+����)
		 * 
		 * @return
		 */
	/*
	 * public String selectPopOne() { String popOne=null;
	 * 
	 * //1. MyBatis Handler(SqlSession) ��� MyBatisHandler
	 * mbh=MyBatisHandler.getInstance(); SqlSession ss=mbh.getHandler(); //2.������ ����
	 * : �Է°� ���� �� ���ڵ��� ���� ����
	 * popOne=ss.selectOne("potato.mgrHomeMapper.selectPopOne"); //3. MyBatis
	 * Handler ���� mbh.closeHandler(ss);
	 * 
	 * return popOne; }//selectPopOne
	 * 
	 *//**
		 * ���� �ްԼ�(�ϸ�ũ)
		 * 
		 * @return
		 */
	/*
	 * public String selectBookmark() { String bookmark=null;
	 * 
	 * //1. MyBatis Handler(SqlSession) ��� MyBatisHandler
	 * mbh=MyBatisHandler.getInstance(); SqlSession ss=mbh.getHandler(); //2.������ ����
	 * : �Է°� ���� �� ���ڵ��� ���� ����
	 * bookmark=ss.selectOne("potato.mgrHomeMapper.selectBookmark"); //3. MyBatis
	 * Handler ���� mbh.closeHandler(ss);
	 * 
	 * return bookmark; }//selectBookmark
	 * 
	 * //�湮�� �� ��Ȳ public List<Integer> selectVisitor(){ return null;
	 * }//selectVisitor
	 * 
	 * //ȸ�� �� ��Ȳ public List<Integer> selectMember(){ return null; }//selectMember
	 * 
	 * //�湮�� ��Ȳ(����,����) public int selectDayVisitor(int visitFlag) { return 0;
	 * }//selectDayVisitor
	 * 
	 * //�湮�� ��Ȳ(�ְ�) public int selectWeekVisitor() { return 0; }//selectWeekVisitor
	 * 
	 *//**
		 * ȸ�� ��Ȳ(��ü)
		 * 
		 * @return
		 */
	/*
	 * public int selectAllMem() { int AllMemCnt=0;
	 * 
	 * //1. MyBatis Handler(SqlSession) ��� MyBatisHandler
	 * mbh=MyBatisHandler.getInstance(); SqlSession ss=mbh.getHandler(); //2.������ ����
	 * : �Է°� ���� �� ���ڵ��� ���� ����
	 * AllMemCnt=ss.selectOne("potato.mgrHomeMapper.selectAllMem"); //3. MyBatis
	 * Handler ���� mbh.closeHandler(ss);
	 * 
	 * return AllMemCnt; }//selectAllMem
	 * 
	 *//**
		 * ȸ�� ��Ȳ(��ü)
		 * 
		 * @return
		 */
	/*
	 * public int selectQuitMem() { int QuitMemCnt=0;
	 * 
	 * //1. MyBatis Handler(SqlSession) ��� MyBatisHandler
	 * mbh=MyBatisHandler.getInstance(); SqlSession ss=mbh.getHandler(); //2.������ ����
	 * : �Է°� ���� �� ���ڵ��� ���� ����
	 * QuitMemCnt=ss.selectOne("potato.mgrHomeMapper.selectQuitMem"); //3. MyBatis
	 * Handler ���� mbh.closeHandler(ss);
	 * 
	 * return QuitMemCnt; }//selectQuitMem
	 * 
	 * //�ްԼҷ�ŷ public List<String> selectPopAll(){ List<String> list=null;
	 * 
	 * //1. MyBatis Handler(SqlSession) ��� MyBatisHandler
	 * mbh=MyBatisHandler.getInstance(); SqlSession ss=mbh.getHandler(); //2.������ ����
	 * : �Է°� ���� �� ���ڵ��� ���� ���� list=ss.selectOne("potato.mgrHomeMapper.selectPopAll");
	 * //3. MyBatis Handler ���� mbh.closeHandler(ss);
	 * 
	 * return list; }//selectPopAll
	 */}
