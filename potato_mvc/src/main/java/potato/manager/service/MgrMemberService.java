package potato.manager.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import potato.manager.domain.MgrBlockReasonDomain;
import potato.manager.domain.MgrMemberDomain;
import potato.manager.vo.ManagerBlockVO;
import potato.manager.vo.MgrMemberVO;

public class MgrMemberService {

	//ȸ�� ��ȸ
	public List<MgrMemberDomain> searchMember(MgrMemberVO mmVO, HttpSession session){
		
		return null;
	}
	
	//���̵�� ȸ�� �˻�
	public MgrMemberDomain searchId(String id) {
		
		return null;
	}
	
	//���� ���� �ҷ�����
	public List<MgrBlockReasonDomain> searchReason(){
		
		return null;
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
	public int searchTotalMember(MgrMemberVO mmVO) {
		
		return 0;
	}
	
	public int lastPage(int totalMember) {
		
		return 0;
	}
	
	public int startNum(int currentPage) {
		
		return 0;
	}
	
	public int isLast(int startNum, int lastPage) {
		
		return 0;
	}
}
