import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

public class LoginForm extends JFrame implements ActionListener{
   private JTextComponent tfId;
   private JTextComponent pfPw;
   
   private JButton btnLogin;
   private JButton btnJoin;
   
   private Vector<User> list;
   private boolean isUpdated;
   //isUpdated : ȸ������Ʈ(list)�� �߰�/������ �߻����� �� true ������ �����ȴ�.
   //���� isUpated�� true�� �����ϰ� �����ϰ� ���ִ�.
   
   public LoginForm() {
      loadData();
      init();
      setDisplay();
      addListeners();
      showFrame();
   }
//   private void loadData() {
//      FileReader fr = null;
//      BufferedReader br = null;
//      
//      try {
//         fr = new FileReader(new File(LoginUtils.DIR, LoginUtils.FILE));
//         br = new BufferedReader(fr);
//         
//         list = new Vector<User>();
//         
//         String line = null;
//         while((line = br.readLine()) != null) {
//            String uid = line;
//            String upw = br.readLine();
//            String uname = br.readLine();
//            String unick = br.readLine();
//            String ugender = br.readLine();
//            list.add(new User(uid, upw, uname, unick, ugender));
//         }
//      }catch(FileNotFoundException e) {
//         list = new Vector<User>();
//         File dir = new File(LoginUtils.DIR).getAbsoluteFile();
//         if(!dir.exists()) {
//            dir.mkdir();
//         }
//      }catch(IOException e) {
//         JOptionPane.showMessageDialog(this, "������ ���� �ε� ����");
//      }finally {
//         closeAll(br, fr);
//      }
//   }
   private void loadData() {
      FileInputStream fis = null;
      DataInputStream dis = null;
      
      try {
         fis = new FileInputStream(new File(LoginUtils.DIR, LoginUtils.FILE));
         dis = new DataInputStream(fis);
         
         list = new Vector<User>();
         
         while(dis.available() > 0) {
            String uid = dis.readUTF();
            String upw = dis.readUTF();
            String uname = dis.readUTF();
            String unick = dis.readUTF();
            String ugender = dis.readUTF();
            list.add(new User(uid, upw, uname, unick, ugender));
         }
      }catch(FileNotFoundException e) {
         list = new Vector<User>();
         File dir = new File(LoginUtils.DIR).getAbsoluteFile();
         if(!dir.exists()) {
            dir.mkdir();
         }
      }catch(IOException e) {
         JOptionPane.showMessageDialog(this, "������ ���� �ε� ����");
      }finally {
         closeAll(dis, fis);
      }
   }
   private void init() {
      tfId = LoginUtils.getTextComponent(LoginUtils.TEXT);
      pfPw = LoginUtils.getTextComponent(LoginUtils.PASSWORD);
      
      btnJoin = LoginUtils.getButton("Join");
      btnLogin = LoginUtils.getButton("Login");
   }
   private void setDisplay() {
      JPanel pnlText = new JPanel(new GridLayout(0, 1));
      JPanel pnlInput = new JPanel(new GridLayout(0, 1));
      
      pnlText.add(LoginUtils.getLabel("ID"));
      pnlText.add(LoginUtils.getLabel("Password"));
      
      JPanel pnlId = new JPanel();
      pnlId.add(tfId);                                                                                                                      
      JPanel pnlPw = new JPanel();
      pnlPw.add(pfPw);
      pnlInput.add(pnlId);
      pnlInput.add(pnlPw);
      
      JPanel pnlSouth = new JPanel();
      pnlSouth.add(btnLogin);
      pnlSouth.add(btnJoin);
      
      JPanel pnlMain = new JPanel(new BorderLayout());
      pnlMain.add(pnlText, BorderLayout.WEST);
      pnlMain.add(pnlInput, BorderLayout.CENTER);
      pnlMain.add(pnlSouth, BorderLayout.SOUTH);
      
      pnlMain.setBorder(new EmptyBorder(5, 10, 5, 10));
      
      add(pnlMain, BorderLayout.CENTER);
   }
   private void addListeners() {
      btnLogin.addActionListener(this);
      btnJoin.addActionListener(this);
      
      addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent we) {
            int result = JOptionPane.showConfirmDialog(
                  LoginForm.this, 
                  "exit?", 
                  "question", 
                  JOptionPane.YES_NO_OPTION, 
                  JOptionPane.QUESTION_MESSAGE
            );
            if(result == JOptionPane.YES_OPTION) {
               if(isUpdated) {
                  //������ �� �����ϰ� ����
                  result = save();
               }
               if(result == JOptionPane.YES_OPTION) {
                  System.exit(0);
               }
            }
         }
      });
   }
   private void showFrame() {
      setTitle("Login");
      pack();
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      setResizable(false);
      setVisible(true);
   }
   private void closeAll(Closeable... c) {
      for(Closeable tmp : c) {
         try {
            tmp.close();
         } catch(Exception e) {}
      }
   }
//   private int save() {
//      FileWriter fw = null;
//      PrintWriter pw = null;
//      int result = JOptionPane.YES_OPTION;
//      try {
//         fw = new FileWriter(new File(LoginUtils.DIR, LoginUtils.FILE));
//         pw = new PrintWriter(fw);
//         
//         for(User user : list) {
//            pw.println(user.getUid());
//            pw.println(user.getUpw());
//            pw.println(user.getUname());
//            pw.println(user.getUnick());
//            pw.println(user.getUgender());
//         }
//         pw.flush();
//      } catch(IOException e) {
//         result = JOptionPane.showConfirmDialog(
//               LoginForm.this, 
//               "error occurred(saving user list). do you want to exit?", 
//               "question", 
//               JOptionPane.YES_NO_OPTION, 
//               JOptionPane.QUESTION_MESSAGE
//         );
//      } finally {
//         closeAll(pw, fw);
//      }
//      return result;
//   }
   private int save() {
      FileOutputStream fos = null;
      DataOutputStream dos = null;
      int result = JOptionPane.YES_OPTION;
      
      try {
         fos = new FileOutputStream(new File(LoginUtils.DIR, LoginUtils.FILE));
         dos = new DataOutputStream(fos);
         
         for(User user : list) {
            dos.writeUTF(user.getUid());
            dos.writeUTF(user.getUpw());
            dos.writeUTF(user.getUname());
            dos.writeUTF(user.getUnick());
            dos.writeUTF(user.getUgender());
         }
         dos.flush();
      }catch(IOException e) {
         result = JOptionPane.showConfirmDialog(
               LoginForm.this, 
               "error occurred(saving user list). do you want to exit?", 
               "question", 
               JOptionPane.YES_NO_OPTION, 
               JOptionPane.QUESTION_MESSAGE
         );
      } finally {
         closeAll(dos, fos);
      }
      return result;
   }
   @Override
   public void actionPerformed(ActionEvent ae) {
      Object src = ae.getSource();
      if(src == btnLogin) {
         //btnLogin ������ ��
         JTextComponent input = null;
         String msg = "welcome!!";
         User user = null;
         if(LoginUtils.isEmpty(tfId)) {
            //IDġ�� ���� ����ִٸ�
            msg = "input your ID";
            input = tfId;
         } else {
            if(LoginUtils.isEmpty(pfPw)) {
               //PWġ�� ���� ����ִٸ�
               msg = "input your password";
               input = pfPw;
            } else {
               String uid = tfId.getText();
               String upw = pfPw.getText();
               user = findUser(uid);
               if(user == null) {
                  //user ����Ʈ�� ���̵� ���ٸ�
                  msg = "check your ID";
                  input = tfId;
               } else {
                  //user ����Ʈ�� ���̵� �����ϸ�
                  if(!upw.equals(user.getUpw())) {
                     //���̵�� ������ �н����尡 �ٸ���
                     msg = "check your password";
                     input = pfPw;
                  }
               }
            }
         }
         JOptionPane.showMessageDialog(
               this, 
               msg, 
               "Infomation", 
               JOptionPane.INFORMATION_MESSAGE
         );
         if(input != null) {
            //�α��� ������ �߻��ϸ� �� component�� ��Ŀ���� �����.
            input.requestFocus();
         } else {
            //�α��� ����!
            clear();
            setVisible(false);
            new InformationForm(this, user);
         }
      } else {
         //btnJoin ������ ��
         clear();
         setVisible(false);
         new JoinForm(this);
      }
   }
   private void clear() {
      tfId.setText("");
      pfPw.setText("");
   }
   public User findUser(String userId) {
      int idx = list.indexOf(new User(userId));
      if(idx >= 0) {
         return list.get(idx);
      } else {
         return null;
      }
   }
   public void addUser(User user) {
      if(findUser(user.getUid()) == null) {
         list.add(user);
         isUpdated = true;
      }
   }
   public void removeUser(User user) {
      list.remove(user);
      isUpdated = true;
   }
   public static void main(String[] args) {
      new LoginForm();
   }
}