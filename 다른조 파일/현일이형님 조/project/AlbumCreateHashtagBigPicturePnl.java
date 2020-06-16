import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AlbumCreateHashtagBigPicturePnl {
	private String file;
	private AlbumHashtagPicture  albumBigPicture;
	public AlbumCreateHashtagBigPicturePnl(AlbumHashtagPicture albumBigPicture,String file){
		this.albumBigPicture= albumBigPicture;
		this.file= file;
	}
	public JPanel createSmallPnl(){
		JPanel pnlSmallPic = new JPanel();
		JLabel pic = new JLabel();
		Image imgPicture = AlbumUtil.imgSizeChange(file, 80, 80);
		pic.setIcon(new ImageIcon(imgPicture));
		pnlSmallPic.add(pic);
		pic.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				albumBigPicture.pnlNorthRepaint(file);
			}
		});
		return pnlSmallPic;
	}
	
	
}
