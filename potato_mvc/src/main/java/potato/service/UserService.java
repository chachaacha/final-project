package potato.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import potato.dao.UserDAO;
import potato.vo.ForgotIdVO;
import potato.vo.ForgotPwVO;
import potato.vo.LoginVO;
import potato.vo.ManagerLoginVO;
import potato.vo.UserInfoVO;

/**
 * ���� �α���/ȸ������ ���� ����
 * @author user
 */
@Component
public class UserService {
	
	@Autowired(required = false)
	private UserDAO uDAO;
	
	/**
	 * ���� �α���
	 * @param lVO
	 * @return
	 */
	@Autowired(required = false)
	public String searchMember(LoginVO lVO) {
		
		String id=null;
		id=uDAO.selectLogin(lVO);
		return id;
	}
	
	/**
	 * �Ŵ��� �α���
	 * @param mlVO
	 * @return
	 */
	public boolean searchManager(ManagerLoginVO mlVO) {
		boolean flag=false;
		return flag;
	}
	
	/**
	 * ���� ȸ������
	 * @param uiVO
	 * @return
	 */
	public String addMember(UserInfoVO uiVO) {
		return null;
	}
	
	/**
	 * ���̵� �ߺ�Ȯ��
	 * @param id
	 * @return
	 */
	public  boolean searchDuplChkId(String id) {
		return false;
	}
	
	/**
	 * �г��� �ߺ�Ȯ��
	 * @param nick
	 * @return
	 */
	public  boolean searchDuplChkNick(String nick) {
		return false;
	}
	
	public String  searchId(ForgotIdVO fiVO) {
		String id="";
		id=uDAO.selectId(fiVO);
		return id;
	}//searchId
	
	/**
	 * ��й�ȣ ã��
	 * @param fpVO
	 * @return
	 */
	public String searchPw(ForgotPwVO fpVO) {
		String pass="";
		pass=uDAO.selectPw(fpVO);
		return pass;
	}//searchPw
	
}//class
