package potato.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import potato.dao.config.MyBatisHandler;
import potato.domain.UserDomain;
import potato.vo.ForgotIdVO;
import potato.vo.ForgotPwVO;
import potato.vo.LoginVO;
import potato.vo.ManagerLoginVO;
import potato.vo.UserInfoVO;

/**
 *	������ �α���, ȸ������ ���� DAO
 * @author user
 */
@Component
public class UserDAO {
	//mapper namespace ���� ����
	public static final String UserMapper="potato.userMapper.";
	
	/**
	 * ���� ȸ������
	 * @param uiVO
	 */
	public int insertMember(UserInfoVO uiVO) {
		int cnt = 0;
		
		//1. Handler ���
		MyBatisHandler mbh= MyBatisHandler.getInstance();
		SqlSession ss= mbh.getHandler();
		//2. ��������
		cnt=ss.insert(UserMapper+"insertMember", uiVO);
		ss.commit();
		//3. ����
		mbh.closeHandler(ss);
		
		return cnt;
	}//insertMember
	
	/**
	 * ���� �α���
	 * @param lVO
	 * @return
	 */
	public UserDomain selectLogin(LoginVO lVO) {
		UserDomain ud= null;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		ud=ss.selectOne(UserMapper+"selectMemberLogin", lVO);
		mbh.closeHandler(ss);
		return ud;
	}//selectLogin
	
	/**
	 * �Ŵ��� �α���
	 * @param mlVO
	 * @return
	 */
	public int selectManager(ManagerLoginVO mlVO) {
		int cnt=0;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		cnt = ss.selectOne(UserMapper+"selectManagerLogin", mlVO);
		
		mbh.closeHandler(ss);
		return cnt;
	}//selectManager
	
	/**
	 * ���̵� �ߺ�Ȯ��
	 * @param id
	 * @return 
	 */
	public int selectMDuplChkId(String id) {
		int cnt =0;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss= mbh.getHandler();
		
		cnt = ss.selectOne(UserMapper+"selectDuplChkId", id);
		mbh.closeHandler(ss);
		return cnt;
	}//selectMDuplChkId
	
	/**
	 * �г��� �ߺ� �˻�
	 * @param nick
	 * @return 
	 */
	public int selectMDuplChkNick(String nick) {
		int cnt=0;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss= mbh.getHandler();
		
		cnt = ss.selectOne(UserMapper+"selectDuplChkNick", nick);
		mbh.closeHandler(ss);
		return cnt;
	}//selectMDuplChkNick
	
	
	/**
	 * ���̵� ã��
	 * @param fiVO
	 * @return
	 */
	public String selectId(ForgotIdVO fiVO) {
		String id="";
		MyBatisHandler mbh=MyBatisHandler.getInstance(); 
		SqlSession ss=mbh.getHandler();
		id= ss.selectOne(UserMapper+"selectForgotId", fiVO); 
		mbh.closeHandler(ss);
		return id; 
	}//selectId
	 
	/**
	 * ��й�ȣ ã��
	 * @param fpVO
	 * @return
	 */
	public int selectPw(ForgotPwVO fpVO) {
		int cnt=0;
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss= mbh.getHandler();
		
		cnt= ss.selectOne(UserMapper+"selectForgotPw", fpVO);
		mbh.closeHandler(ss);
		
		return cnt;
	}//selectId
	
	/**
	 * �ӽú�й�ȣ ������Ʈ
	 * @param fpVO
	 * @return
	 */
	public void updatePw(ForgotPwVO fpVO) {
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss= mbh.getHandler();
		ss.update(UserMapper+"updatePw", fpVO);
		ss.commit();
		mbh.closeHandler(ss);
	}//updatePw
	
}//class
