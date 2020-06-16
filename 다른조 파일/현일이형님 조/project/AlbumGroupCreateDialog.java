import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AlbumGroupCreateDialog extends JDialog {

	private AlbumMain albumMain;
	private AlbumImportFile albumImportFile;
	private JTextField tfGroupName;
	private JButton btnGroupAdd;
	private ArrayList<AlbumGroup> albumGroupList;
	private boolean albumImportFileCheckFlag;
	private AlbumFileMove albumFileMove;
	private int whereCheckFlag;
	

	public AlbumGroupCreateDialog(AlbumMain albumMain) {
		super(albumMain, "����ø - �׷� �߰�", true);
		this.albumMain = albumMain;
		this.albumGroupList = albumMain.getAlbumGroupList();
		albumImportFileCheckFlag = false;
		init();
		addListener();
		showFrame();
	}
	public AlbumGroupCreateDialog(AlbumMain albumMain,AlbumImportFile albumImportFile) {
		super(albumImportFile, "����ø - �׷� �߰�", true);
		this.albumMain = albumMain;
		this.albumImportFile= albumImportFile;
		albumImportFileCheckFlag = true;
		this.albumGroupList = albumMain.getAlbumGroupList();
		init();
		addListener();
		showFrame();
	}
	public AlbumGroupCreateDialog(AlbumFileMove albumFileMove) {
		super(albumFileMove, "����ø - �׷��̵�", true);
		this.albumFileMove = albumFileMove;
		albumImportFileCheckFlag = false;
		whereCheckFlag = 2;
		this.albumMain = albumFileMove.getAlbumMain();
		this.albumGroupList = albumMain.getAlbumGroupList();
		albumImportFileCheckFlag = false;
		init();
		addListener();
		showFrame();
	}

	private void init() {
		
		JLabel lblGroupName = new JLabel("�׷��");
		tfGroupName = new JTextField(20);
		tfGroupName.setPreferredSize(AlbumUtil.BUTTON_SIZE);
		btnGroupAdd = new JButton("�׷� �߰�");

		JPanel pnlGroupNameNField = new JPanel(new FlowLayout());
		pnlGroupNameNField.add(lblGroupName);
		pnlGroupNameNField.add(tfGroupName);
		add(pnlGroupNameNField, BorderLayout.NORTH);

		JPanel pnlButtonGroupAdd = new JPanel();
		pnlButtonGroupAdd.add(btnGroupAdd);
		add(pnlButtonGroupAdd, BorderLayout.SOUTH);

	}

	private void addListener() {
		// TODO Auto-generated method stub
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}

		});
		btnGroupAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String groupName = tfGroupName.getText().trim();
				if (tfGroupName.getText().trim().length() != 0) {
					boolean SameGroupNameCheckFlag = true;
					for (AlbumGroup GroupInfo : albumGroupList) {
						if (GroupInfo.getName().equals(groupName)) {
							SameGroupNameCheckFlag = false;
						}
					}
					if (SameGroupNameCheckFlag) {
						AlbumGroup newGroup = new AlbumGroup(groupName);
						albumGroupList.add(newGroup);
						albumMain.pnlRePaint();
						dispose();
						if(albumImportFileCheckFlag){
							albumImportFile.groupPartRePaint();
						}
					} else if (tfGroupName.getText().equals(groupName)) {
						JOptionPane.showMessageDialog(AlbumGroupCreateDialog.this, "�̹� ������ �׷��� ���� �մϴ�.", "���",
								JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(AlbumGroupCreateDialog.this, "��ĭ�� �Է� �Ҽ� �����ϴ�.", "���",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
	}

	private void showFrame() {
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setVisible(true);
	}

}
