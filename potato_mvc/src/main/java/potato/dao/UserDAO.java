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
	public String selectManager(ManagerLoginVO mlVO) {
		String result;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss=mbh.getHandler();
		result = ss.selectOne(UserMapper+"selectManagerLogin", mlVO);
		mbh.closeHandler(ss);
		return result;
	}//selectManager
	
	/**
	 * ���̵� �ߺ�Ȯ��
	 * @param id
	 * @return 
	 */
	public String selectMDuplChkId(String id) {
		String result = "";
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss= mbh.getHandler();
		
		result = ss.selectOne(UserMapper+"selectDuplChkId", id);
		mbh.closeHandler(ss);
		return result;
	}//selectMDuplChkId
	
	/**
	 * �г��� �ߺ� �˻�
	 * @param nick
	 * @return 
	 */
	public String selectMDuplChkNick(String nick) {
		String result ="";
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss= mbh.getHandler();
		
		result = ss.selectOne(UserMapper+"selectDuplChkNick", nick);
		mbh.closeHandler(ss);
		return result;
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
	public String selectPw(ForgotPwVO fpVO) {
		String pw="";
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss= mbh.getHandler();
		
		pw= ss.selectOne(UserMapper+"selectForgotPw", fpVO);
		mbh.closeHandler(ss);
		
		return pw;
	}//selectId
	
	/**
	 * �ӽú�й�ȣ ������Ʈ
	 * @param fpVO
	 * @return
	 */
	public int updatePw(ForgotPwVO fpVO) {
		int cnt=0;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		SqlSession ss= mbh.getHandler();
		cnt = ss.update(UserMapper, fpVO);
		mbh.closeHandler(ss);
		return cnt;
	}//updatePw
	
}//class
