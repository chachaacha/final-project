package potato.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
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
	public int addMember(UserInfoVO uiVO) {
		int cnt = 0;
		cnt=uDAO.insertMember(uiVO);
		return cnt;
	}
	
	/**
	 * ���̵� �ߺ�Ȯ��
	 * @param id
	 * @return
	 */
	public String searchDuplChkId(String id) {
		int cnt =0;
		cnt=uDAO.selectMDuplChkId(id);
		JSONObject jsonObj=new JSONObject();
		jsonObj.put("idCnt", cnt);
		return jsonObj.toJSONString();
	}
	
	/**
	 * �г��� �ߺ�Ȯ��
	 * @param nick
	 * @return
	 */
	public String searchDuplChkNick(String nick) {
		int cnt =0;
		cnt=uDAO.selectMDuplChkNick(nick);
		JSONObject jsonObj=new JSONObject();
		jsonObj.put("nickCnt", cnt);
		return jsonObj.toJSONString();
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
