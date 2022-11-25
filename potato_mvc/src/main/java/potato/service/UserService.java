package potato.service;

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
import java.security.SecureRandom;
import java.util.Date;

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
		String temp=null;
		int cnt = 0;
		cnt=uDAO.selectPw(fpVO);
		if( cnt == 1 ) {
			UserService us = new UserService();
			temp=us.getRamdomPassword(10);
			fpVO.setTemp(temp);
			uDAO.updatePw(fpVO);
		}//end if
		return temp;
	}//searchPw
	
	/**
	 * �ӽ� ��й�ȣ �����
	 * @param size
	 * @return
	 */
	public String getRamdomPassword(int size) {
        char[] charSet = new char[] {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                '!', '@', '#', '$', '%', '^', '&' };

        StringBuffer sb = new StringBuffer();
        SecureRandom sr = new SecureRandom();
        sr.setSeed(new Date().getTime());

        int idx = 0;
        int len = charSet.length;
        for (int i=0; i<size; i++) {
            // idx = (int) (len * Math.random());
            idx = sr.nextInt(len);    // ������ ������ �߻���Ű�� ���� SecureRandom�� ����Ѵ�.
            sb.append(charSet[idx]);
        }

        return sb.toString();
    }//getRamdomPassword
	
}//class
