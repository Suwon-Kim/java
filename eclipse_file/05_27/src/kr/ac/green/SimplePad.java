package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class SimplePad extends JFrame {
	
	private JMenuBar mBar;
	private JMenu mFile;
	private JMenuItem miOpen;
	private JMenuItem miSave;
	private JMenuItem miExit;
	private JMenuItem miSaveAs;
	private JMenuItem miNew;
	private JTextArea taEditor;
	
	private JFileChooser chooser;
	private String title = "SimplePad ver0.9";
	public SimplePad() {
		init();
		setDisplay();
		addListeners();
		showFrame();
	}
	
	private void init() {
		mBar = new JMenuBar();
		miNew = new JMenuItem("New");
		mFile = new JMenu("File");
		miOpen = new JMenuItem("Open");
		miSave = new JMenuItem("Save");
		miSaveAs = new JMenuItem("Save As");
		miExit = new JMenuItem("Exit");
		
		mFile.add(miNew);
		mFile.add(miOpen);
		mFile.addSeparator();
		mFile.add(miSave);
		mFile.add(miSaveAs);
		mFile.addSeparator();
		mFile.add(miExit);
		
		mBar.add(mFile);
		
		taEditor = new JTextArea();
		taEditor.setTabSize(4);
		
		chooser = new JFileChooser(".");
	}

	private void setDisplay() {
		setJMenuBar(mBar);
		add(new JScrollPane(taEditor), BorderLayout.CENTER);
	}

	private void addListeners() {
		ActionListener listener = (e) -> {
			Object o = e.getSource();
			if(o == miNew) {
				newFile();
			} else if(o == miOpen) {
				open();
			}
			else if(o == miSave) {
				save();
			} else if (o == miSaveAs) {
				//saveAs();
			}
			else {
				System.exit(0);
			}
		};
		miNew.addActionListener(listener);
		miOpen.addActionListener(listener);
		miSave.addActionListener(listener);
		miSaveAs.addActionListener(listener);
		miExit.addActionListener(listener);
		
		Document doc = taEditor.getDocument();
		doc.addDocumentListener(new DocumentListener() {
			@Override
			public void changedUpdate(DocumentEvent e) {
			}
			@Override
			public void insertUpdate(DocumentEvent e) {
				setTitle(title + "*");
			}
			@Override
			public void removeUpdate(DocumentEvent e) {
				setTitle(title + "*");
			}
		});
	}
	private void newFile() {
		
		
	}
	private void open() {
		int result = chooser.showOpenDialog(this);
		if(result == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			
			FileReader fr = null;
			BufferedReader br = null;
			
			try {
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				
				String line = null;
				StringBuilder builder = new StringBuilder();
				while( (line = br.readLine()) != null ) {
					builder.append(line + "\n");
				}
				taEditor.setText(builder.toString());
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this, "불러오는 중 에러발생");
			} finally {
				MyUtils.closeAll(br, fr);
			}
		}
	}
	private void save() {
		int result = chooser.showSaveDialog(this);
		if(result == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			
			FileWriter fw = null;
			try {
				fw = new FileWriter(file);
				fw.write(taEditor.getText());
				fw.flush();
			} catch(IOException e) {
				JOptionPane.showMessageDialog(this, "저장중 에러발생");
			} finally {
				MyUtils.closeAll(fw);
			}
		}
	}
//	private void saveAs() {
//		FileWriter fw = null;
//		if() {
//			
//		}
//		try {
//			fw = new FileWriter(file);
//			fw.write(taEditor.getText());
//		} catch (IOException e) {
//			JOptionPane.showMessageDialog(this, "저장중 에러발생");
//		} finally {
//			MyUtils.closeAll(fw);
//		}
//	}
//	
	private void showFrame() {
		setTitle(title);
		setSize(500, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);		
	}

	public static void main(String[] args) {
		new SimplePad();
	}
}





