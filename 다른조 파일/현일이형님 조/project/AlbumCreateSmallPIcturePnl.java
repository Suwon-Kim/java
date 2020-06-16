import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class AlbumCreateSmallPIcturePnl {

	private AlbumMain albumMain;
	private AlbumSmallPicture albumSmallPicture;
	private String groupName;
	private JCheckBox cbSelect;
	private String fileName;

	private JPanel pnlPicture;
	private JPanel pnlCbSelect;
	
	public AlbumCreateSmallPIcturePnl(AlbumMain albumMain, AlbumSmallPicture albumSmallPicture, String groupName) {
		this.albumMain = albumMain;
		this.groupName = groupName;
		this.albumSmallPicture = albumSmallPicture;
		cbSelect = new JCheckBox();
		
	}

	public JPanel smallPictureAll(String file) {
		pnlCbSelect = new JPanel(new BorderLayout());
		pnlPicture = new JPanel(new BorderLayout());
		Image imgPicture = AlbumUtil.imgSizeChange(file, 170, 170);
		fileName = file;
		JLabel lblPicture = new JLabel();
		lblPicture.setIcon(new ImageIcon(imgPicture));
		pnlPicture.add(lblPicture, BorderLayout.CENTER);
		pnlPicture.addMouseListener(mlPicListener());
		return pnlPicture;
	}
	
	private MouseListener mlPicListener(){
		return new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				new AlbumBigPicture(albumMain, albumSmallPicture, fileName);
			}
		};
	}
	public JPanel smallPictureInGroup(String file) {
		pnlCbSelect = new JPanel(new BorderLayout());
		pnlPicture = new JPanel(new BorderLayout());
		Image imgPicture = AlbumUtil.imgSizeChange(file, 170, 170);
		fileName = file;
		JLabel lblPicture = new JLabel();
		lblPicture.setIcon(new ImageIcon(imgPicture));
		pnlPicture.add(pnlCbSelect, BorderLayout.NORTH);
		pnlPicture.add(lblPicture, BorderLayout.CENTER);
		pnlPicture.addMouseListener(mlPicListener());
		return pnlPicture;
	}

	public void cbActivation(boolean flag) {
		if (!flag) {
			cbSelect = new JCheckBox();
			pnlCbSelect = new JPanel(new BorderLayout());
			pnlCbSelect.add(cbSelect,BorderLayout.WEST);
			pnlPicture.add(pnlCbSelect, BorderLayout.NORTH);
		}else{
			pnlPicture.remove(pnlCbSelect);
		}
		pnlPicture.updateUI();
	}
	public JCheckBox getCbSelect() {
		return cbSelect;
	}

	public void setCbSelect(JCheckBox cbSelect) {
		this.cbSelect = cbSelect;
	}
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}

