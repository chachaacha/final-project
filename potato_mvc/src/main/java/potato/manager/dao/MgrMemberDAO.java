package potato.manager.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import potato.dao.config.MyBatisHandler;
import potato.manager.domain.MgrBlockReasonDomain;
import potato.manager.domain.MgrMemberDomain;
import potato.manager.vo.ManagerBlockVO;
import potato.manager.vo.MgrMemberVO;

public class MgrMemberDAO {
	
	//ȸ�� ��� ��ȸ
	public List<MgrMemberDomain> selectMember(MgrMemberVO mmVO){
		List<MgrMemberDomain> list=null;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession session=mbh.getHandler();
		
		list=session.selectList("potato.manager.mgrMemberMapper.memberList",mmVO);
		
		mbh.closeHandler(session);
		
		return list;
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
