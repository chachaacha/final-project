package potato.domain;

/**
 *	�α��� ���� ���� �� �ҷ��� ���� ������
 *	���ǿ� ����ȴ�.
 * @author user
 */
public class UserDomain {
	private String id, nick, img, quit;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getQuit() {
		return quit;
	}

	public void setQuit(String quit) {
		this.quit = quit;
	}

	@Override
	public String toString() {
		return "UserDomain [id=" + id + ", nick=" + nick + ", img=" + img + ", quit=" + quit + "]";
	}

}
