package potato.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import potato.manager.dao.MgrHomeDAO;

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
		System.out.println(NewMemCnt);
		
		return NewMemCnt;
	}//searchNewMemCnt
	
	//���� �Ű� ��
	public int searchReportCnt() {		
		return 0;
	}
	
	//�α� �ްԼ�(����+����)
	public String searchPopOne() {		
		return null;
	}
	
	//���� �ްԼ�(�ϸ�ũ)
	public String searchBookmark() {		
		return null;
	}
	
	//�湮�� ��Ȳ
	public List<Integer> searchVisitor() {		
		return null;
	}
	
	//�湮�� ��Ȳ(����,����,��)
	public int searchVisitorCnt(int visitFlag) {		
		return 0;
	}
	
	//ȸ�� ��Ȳ(��ü)
	public int searchAllMem(int visitFlag) {		
		return 0;
	}
	
	//ȸ�� ��Ȳ(Ż��)
	public int searchQuitMem(int visitFlag) {		
		return 0;
	}
	
	//�α� �ްԼ� ��ŷ
	public List<String> searchPopAll() {		
		return null;
	}
}
