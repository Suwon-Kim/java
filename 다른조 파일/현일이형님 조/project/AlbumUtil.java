import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.Closeable;
import java.util.ArrayList;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class AlbumUtil {
	
	public static final String PATH= ".";
	public static final String DEFALUT_ALBUME_PROPERTIES = PATH + "//propertiese";
	public static final String DEFALUT_ALBUME_PROPERTIES_GROUP_DB = PATH + "//propertiese//groupName.db";
	public static final String DEFALUT_ALBUME_PROPERTIES_FILE_DB = PATH + "//propertiese//groupFileDb.db";
	public static final String PHOTO_PLUS_ICON = PATH + "//resource//photo-plus-icon.png";
	public static final String SEARCH_IMGPATH = ".//resource//Search-icon.png";
	public static final String PLUS_FORDER_ICON = ".//resource//Folder-Plus-icon.png";
	public static final String FIlE_OPEN_ICON = ".//resource//Folder-Open-icon.png";
	public static final String NO_IMG = ".//resource//noimage.png";
	public static final String ICON_X_IMG = ".//resource//x.png";
	public static final String BIG_PIC = ".//resource//bigPic.jpg";
	
	public static final int SCREEN_WIDTH = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2+100;
	public static final int SCREEN_HEIGHT = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2+100;
	
	public static final Dimension MAIN_IMG_SIZE =new Dimension(450,450);
	public static final Dimension SMALL_SIZE =new Dimension(200,200);
	public static final Dimension BIG_SIZE = new Dimension(480,480);
	
	public static String[] IMG_EXT_ABLE= {"JPG", "JPEG", "JPE", "JFIF","PNG"};
	public static String EXT_WARNNING= "JPG, JPEG, JPE, JFIF, PNG ";
	
	public static final Dimension BUTTON_SIZE = new Dimension(224, 40);
	public static Image imgSizeChange(String path,int width,int height){
		Image img = Toolkit.getDefaultToolkit().getImage(path);
		img = img.getScaledInstance(width, height, Image.SCALE_DEFAULT);
		return img;
	}
	public static void closeAll(Closeable... c){
		for(Closeable temp : c){
			try{
				temp.close();
			}catch(Exception e ){}
		}
	}
	public static String fileInGroupToString(ArrayList<String> pictureInGroup){
		String string= "";
		int count =0;
		for(String fileName : pictureInGroup){
			if(fileName.trim().length()!=0){
				string+= fileName + ",";
				count++;
			}
		}
		if(count==0){
			string ="";
		}
		return string;
	}
}
