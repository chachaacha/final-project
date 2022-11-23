package potato.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import potato.dao.UserDAO;
import potato.domain.UserDomain;
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
	public UserDomain searchMember(LoginVO lVO) {
		UserDomain ud = null;
		ud=uDAO.selectLogin(lVO);
		return ud;
	}
	
	/**
	 * �Ŵ��� �α���
	 * @param mlVO
	 * @return
	 */
	public boolean searchManager(ManagerLoginVO mlVO) {
		boolean flag=false;
		String result="";
		result=uDAO.selectManager(mlVO);
		if( result != null && !result.equals("") ) {
			flag= true;
		}
		return flag;
	}
	
	/**
	 * ���� ȸ������
	 * @param uiVO
	 * @return
	 */
	public boolean addMember(UserInfoVO uiVO) {
		boolean flag=false;
		int cnt = 0;
		cnt=uDAO.insertMember(uiVO);
		if( cnt != 0) {
			flag=true;
		}
		return flag;
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
	
	
	/**
	 * ���̵� ã��
	 * @param fiVO
	 * @return
	 */
	public String searchId(ForgotIdVO fiVO) { 
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
