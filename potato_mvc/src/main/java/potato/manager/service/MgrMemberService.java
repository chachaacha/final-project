package potato.manager.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import potato.manager.dao.MgrMemberDAO;
import potato.manager.domain.MgrBlockReasonDomain;
import potato.manager.domain.MgrMemberDomain;
import potato.manager.vo.ManagerBlockVO;
import potato.manager.vo.MgrMemberVO;

@Component
public class MgrMemberService {

	@Autowired(required = false)
	private MgrMemberDAO mmDAO;
	
	//ȸ�� ��ȸ
	public List<MgrMemberDomain> searchMember(MgrMemberVO mmVO){
		List<MgrMemberDomain> list=null;
		
		list=mmDAO.selectMember(mmVO);
				
		return list;
	}
	
	//ȸ�� ������â �ҷ�����
	public MgrMemberDomain searchMemberInfo(String id) {
		MgrMemberDomain mmd=null;
		mmd=mmDAO.selectDetailInfo(id);
		
		return mmd;
	}
	
	//���� ���� �ҷ�����
	public List<MgrBlockReasonDomain> searchReason(){
		List<MgrBlockReasonDomain> list=null;
		list=mmDAO.selectReason();
		
		return list;
	}
	
	//ȸ�� �����ϱ�(����ȸ�� ��Ͽ� �߰�)
	public int addBlock(ManagerBlockVO mbVO) {
		
		return 0;
	}
	
	//���� ����
	public int removeBlock(String id) {
		
		return 0;
	}
	
	//����¡
	public int searchTotalPages(MgrMemberVO mmVO) {
		int cnt=mmDAO.selectTotalPages(mmVO);
		
		return cnt;
	}
	
	public int lastPage(int totalPages) {
		int lastPage=0;
		lastPage=(int)Math.ceil((double)totalPages/10); //10���� �����ֱ�

		return lastPage;
	}
	
	public int startNum(int currentPage) {
		int startNum=0;
		startNum=currentPage-(currentPage-1)%3;
		
		return startNum;
	}
	
	public int isLast(int startNum, int lastPage) {
		int isLast = 2; // 3������ �� 0,1,2
		if (startNum + 3 > lastPage) {
			isLast = lastPage - startNum;
		}
		return isLast;
	}
}
