package potato.manager.dao;

import java.util.List;

public class MgrHomeDAO {
	
	//�ű԰�����
	public int selectNewMemberCnt() {
		return 0;
	}//selectNewMemberCnt
	
	//�Ű���Ȳ
	public int selectNewMember() {
		return 0;
	}//selectNewMember
	
	//�α��ްԼ�(����+����)
	public String selectPopRest() {
		return null;
	}//selectPopRest
	
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
	public List<String> selectRestRank(){
		return null;
	}//selectRestRank
}
