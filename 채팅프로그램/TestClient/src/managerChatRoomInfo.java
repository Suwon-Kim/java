import java.util.Vector;

public class managerChatRoomInfo {
	private Vector<ChatRoomInfo> infolist;
	public managerChatRoomInfo() {
		// TODO Auto-generated constructor stub
		ChatRoom ch = new ChatRoom();
		infolist= new Vector<ChatRoomInfo>();
		infolist.add(ch.getRoomInfo());
		setInfolist(infolist);
	}
	public Vector<ChatRoomInfo> getInfolist() {
		return infolist;
	}
	public void setInfolist(Vector<ChatRoomInfo> infolist) {
		this.infolist = infolist;
	}
	
	
}
