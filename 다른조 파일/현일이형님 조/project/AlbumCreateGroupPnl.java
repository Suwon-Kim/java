import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class AlbumCreateGroupPnl extends JFrame {
	private AlbumMain albumMain;

	private ArrayList<AlbumFile> albumFileList;
	private ArrayList<AlbumGroup> albumGroupList;

	public AlbumCreateGroupPnl(AlbumMain albumMain) {
		this.albumMain = albumMain;
		this.albumFileList = albumMain.getAlbumFileList();
		this.albumGroupList = albumMain.getAlbumGroupList(); 
	}

	protected JPanel CreateGroupPnlAll() {
		JPanel allGroupPnl;
		if(albumFileList.size()!=0){
			allGroupPnl = CreateGroupPnlName("전체",albumFileList.get(albumFileList.size()-1).getFilePath());
		}else{
			allGroupPnl = CreateGroupPnlName("전체",AlbumUtil.NO_IMG);
		}
		return allGroupPnl;
	}

	protected JPanel CreateGroupPnlName(String groupName,String path){
		
		JPanel pnlGroup = new JPanel(new BorderLayout());
		JLabel lblGroup = new JLabel();
		JLabel lblIconX = new JLabel();
		Image imgLastGroup = null;

		if(!groupName.equals("전체")){
			Image imgIconX = AlbumUtil.imgSizeChange(AlbumUtil.ICON_X_IMG, 20, 20);
			lblIconX.setIcon(new ImageIcon(imgIconX));
			JPanel pnlIconX = new JPanel(new BorderLayout());
			pnlIconX.add(lblIconX,BorderLayout.EAST);
			pnlGroup.add(pnlIconX,BorderLayout.NORTH);
			imgLastGroup = AlbumUtil.imgSizeChange(path, 470, 470);
			pnlIconX.addMouseListener(maListenerGroupRemove(groupName));
		}else{
			imgLastGroup = AlbumUtil.imgSizeChange(path, 450, 450);
		}
		if(!path.equals(AlbumUtil.NO_IMG)){
			lblGroup.addMouseListener(maListenerLblGroup(groupName));
		}
		
		lblGroup.setIcon(new ImageIcon(imgLastGroup));
		pnlGroup.add(lblGroup,BorderLayout.CENTER);
		TitledBorder tBorder = new TitledBorder(new LineBorder(Color.BLUE), groupName);
		tBorder.setTitleFont(new Font(Font.SANS_SERIF, Font.BOLD | Font.BOLD, 20));
		pnlGroup.setBorder(tBorder);
		return pnlGroup;
	}
	private MouseAdapter maListenerGroupRemove(String groupName){
		return new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				albumGroupList.remove(new AlbumGroup(groupName));
				albumMain.pnlRePaint();
			}
		};
	}
	
	private MouseAdapter maListenerLblGroup(String groupName){
		return new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				new AlbumSmallPicture(albumMain,groupName);
			}
		};
	}
}
