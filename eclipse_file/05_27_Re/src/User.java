
public class User {
	private String userId;
	private String userPassword;
	private String userName;
	private String userNick;
	private String userGender;
	
	public User(String userId) {
		this.userId = userId;
	}
	public User(
			String userId, String userPassword,String userName,
			String userNick, String userGender) {
			
			this.userId = userId;
			this.userPassword = userPassword;
			this.userName = userName;
			this.userNick = userNick;
			this.userGender = userGender;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserNick() {
		return userNick;
	}
	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	@Override
	public String toString() {
		String info = "<<" + userId + "���� ȸ�� ���� >>\n";
		info += "- name : " + userName + "\n";
		info += "- password : " + userPassword + "\n";
		info += "- nickName :" + userNick + "\n";
		info += "- gender :" + userGender + "\n";
		return info;
	}
	@Override
	public boolean equals(Object o) {
		if(o == null || !(o instanceof User)) {
			return false;
		}
		User user = (User)o;
		return userId.equals(user.getUserId());
	}
	
}