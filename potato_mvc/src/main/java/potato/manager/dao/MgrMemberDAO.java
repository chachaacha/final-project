package potato.manager.dao;

import java.util.List;

import potato.manager.domain.MgrBlockReasonDomain;
import potato.manager.domain.MgrMemberDomain;
import potato.manager.vo.ManagerBlockVO;
import potato.manager.vo.MgrMemberVO;

public class MgrMemberDAO {
	
	//ȸ�� ��� ��ȸ
	public List<MgrMemberDomain> selectMember(MgrMemberVO mmVO){
		
		return null;
	}
	
	//ȸ�� �� ���� �˾�â
	public MgrMemberDomain selectDetailInfo(String id) {
		
		return null;
	}
	
	//���� �˾�â) ���� ���� �ҷ�����
	public List<MgrBlockReasonDomain> selectReason(){
		
		return null;
	}
	
	//ȸ�� ����
	public void insertBlock(ManagerBlockVO mbVO) {
		
	}
	
	//���� ����
	public int deleteBlock(String id) {
		
		return 0;
	}
	
	//����¡
	public int searchTotalMember(MgrMemberVO mmVO) {
		
		return 0;
	}
}
