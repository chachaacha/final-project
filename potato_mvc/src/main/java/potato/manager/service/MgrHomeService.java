package potato.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import potato.manager.dao.MgrHomeDAO;

@Component
public class MgrHomeService {
	
	//����������
	@Autowired(required = false)
	private MgrHomeDAO mhDAO;
	
	/**
	 * ���� �ű԰��� ��
	 * @return
	 */
	public int searchNewMemCnt() {
		int NewMemCnt=0;
		
		NewMemCnt=mhDAO.selectNewMemCnt();
		
		return NewMemCnt;
	}//searchNewMemCnt
	
	/**
	 * ���� �Ű� ��
	 * @return
	 */
	public int searchReportCnt() {	
		int reportCnt=0;
		
		reportCnt=mhDAO.selectReportCnt();
		
		return reportCnt;
	}//searchReportCnt
	
	//�α� �ްԼ�(����+����)
	public String searchPopOne() {	
		String popOne=null;
		
		popOne=mhDAO.selectPopOne();
		
		return popOne;
	}//searchPopOne
	
	//���� �ްԼ�(�ϸ�ũ)
	public String searchBookmark() {	
		String bookmark=null;
		
		bookmark=mhDAO.selectBookmark();
		
		return bookmark;
	}//searchBookmark
	
	//�湮����Ȳ(������ ��¥)
	public String searchVisitDate(int DateFlag) {	
		String visitDate=null;
		
		visitDate=mhDAO.selectVisitDate(DateFlag);
		
		return visitDate;
	}//searchVisitDate
	
	//�湮�� ��Ȳ(����,����,��)
	public int searchVisitorCnt(int visitFlag) {	
		int visitorCnt=0;
		
		visitorCnt=mhDAO.selectVisitorCnt(visitFlag);
		
		return visitorCnt;
	}//searchVisitorCnt
	
	//ȸ�� ��Ȳ(��ü)
	public int searchAllMem() {
		int allMemCnt=0;
		
		allMemCnt=mhDAO.selectAllMem();
		
		return allMemCnt;
	}//searchAllMem
	
	//ȸ�� ��Ȳ(Ż��)
	public int searchQuitMem() {
		int quitMemCnt=0;
		
		quitMemCnt=mhDAO.selectQuitMem();
		
		return quitMemCnt;
	}//searchQuitMem
	
	//�α� �ްԼ� ��ŷ
	public List<String> searchPopAll() {
		List<String> list=null;
		
		list = mhDAO.selectPopAll();
		
		return list;
	}//searchQuitMem
}
