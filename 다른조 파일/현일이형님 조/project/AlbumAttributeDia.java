import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AlbumAttributeDia extends JDialog{
	private AlbumBigPicture albumBigPicture;
	private AlbumHashtagPicture albumHashtagPicture;
	public AlbumAttributeDia(AlbumBigPicture albumBigPicture,AlbumFile fileInfo) {
		this.albumBigPicture = albumBigPicture;
		JPanel pnlTotal = new JPanel(new BorderLayout());
		pnlTotal.setBorder(new EmptyBorder(10,10,10,10));
		
		JPanel pnlPicInfo = new JPanel();
		JLabel lblInfo = new JLabel("상세설명 ");
		JTextArea taInfo = new JTextArea(5,30);
		taInfo.setText(fileInfo.getExplanation());
		pnlPicInfo.add(lblInfo);
		pnlPicInfo.add(taInfo);
		
		JPanel pnlHash = new JPanel();
		JLabel lblHash = new JLabel("해시태그");
		JTextField tfHash = new JTextField(30);
		tfHash.setText(fileInfo.getHashtag());
		pnlHash.add(lblHash);
		pnlHash.add(tfHash);
		
		JPanel pnlButton = new JPanel();
		JButton btnApply = new JButton("적용");
		btnApply.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fileInfo.setHashtag(tfHash.getText());
				fileInfo.setExplanation(taInfo.getText());
				albumBigPicture.pnlNorthRepaint(fileInfo.getFilePath());
				dispose();
			}
		});
		pnlButton.add(btnApply);
		
		pnlTotal.add(pnlPicInfo, BorderLayout.NORTH);
		pnlTotal.add(pnlHash, BorderLayout.CENTER);
		pnlTotal.add(pnlButton, BorderLayout.SOUTH);
		add(pnlTotal);
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				dispose();
			}
			
		});
		setTitle("속성");
		pack();
//		setSize(300,300);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
	
	}

	public AlbumAttributeDia(AlbumHashtagPicture albumHashtagPicture,AlbumFile fileInfo) {
		this.albumHashtagPicture = albumHashtagPicture;
		JPanel pnlTotal = new JPanel(new BorderLayout());
		pnlTotal.setBorder(new EmptyBorder(10,10,10,10));
		
		JPanel pnlPicInfo = new JPanel();
		JLabel lblInfo = new JLabel("상세설명 ");
		JTextArea taInfo = new JTextArea(5,30);
		taInfo.setText(fileInfo.getExplanation());
		pnlPicInfo.add(lblInfo);
		pnlPicInfo.add(taInfo);
		
		JPanel pnlHash = new JPanel();
		JLabel lblHash = new JLabel("해시태그");
		JTextField tfHash = new JTextField(30);
		tfHash.setText(fileInfo.getHashtag());
		pnlHash.add(lblHash);
		pnlHash.add(tfHash);
		
		JPanel pnlButton = new JPanel();
		JButton btnApply = new JButton("적용");
		btnApply.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fileInfo.setHashtag(tfHash.getText());
				fileInfo.setExplanation(taInfo.getText());
				albumHashtagPicture.pnlNorthRepaint(fileInfo.getFilePath());
				dispose();
			}
		});
		pnlButton.add(btnApply);
		
		pnlTotal.add(pnlPicInfo, BorderLayout.NORTH);
		pnlTotal.add(pnlHash, BorderLayout.CENTER);
		pnlTotal.add(pnlButton, BorderLayout.SOUTH);
		add(pnlTotal);
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				dispose();
			}
			
		});
		setTitle("속성");
		pack();
//		setSize(300,300);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
	
	}

}
