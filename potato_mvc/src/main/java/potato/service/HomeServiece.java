package potato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import potato.dao.HomeDAO;
import potato.domain.UserHomeMapDomain;
import potato.domain.UserHomeSliderDomain;

@Component
public class HomeServiece {
	
	@Autowired(required = false)
	private HomeDAO hDAO;
	
	//�����̵� �ްԼ� ��ũ
	//���󳲵�
	public List<UserHomeSliderDomain> getLink1() {
		List<UserHomeSliderDomain> list=null;
		list=hDAO.selectRestInx1();
		return list;
	}//getLink1
	
	//������
	public List<UserHomeSliderDomain> getLink2() {
		List<UserHomeSliderDomain> list=null;
		list=hDAO.selectRestInx2();
		return list;
	}
	
	//������
	public List<UserHomeSliderDomain> getLink3() {
		List<UserHomeSliderDomain> list=null;
		list=hDAO.selectRestInx3();
		return list;
	}
	
	//��û�ϵ�
	public List<UserHomeSliderDomain> getLink4() {
		List<UserHomeSliderDomain> list=null;
		list=hDAO.selectRestInx4();
		return list;
	}
	
	//���� �� ����
	public List<UserHomeMapDomain> getMap() {
		List<UserHomeMapDomain> list=null;
		list=hDAO.selectMapPin();
		return list;
	}
	
	//�湮�ڼ� ����
	public String getVisiter(String ip) {
		String visitorCnt="";
		if(ip.equals("0:0:0:0:0:0:0:1")) { //localhost ip�ּ� ��ȯ
			ip="127.0.0.1";
		}
		visitorCnt=hDAO.insertVisitor(ip);
		return visitorCnt;
	}
	
}
