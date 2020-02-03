package dotsandboxes.gui.filesAndFont;

import javax.swing.*;
import java.io.File;

public class FileManager {
    private static final File IMAGE_DIR=new File("images");
    private static final File FONT_DIR=new File("font");
    
    
    private static final File HORIZONTAL_LINE_EMPTY=new File("horizontal_empty.png");
    private static final File HORIZONTAL_LINE_FULL=new File("horizontal_full.png");
    private static final File VERTICAL_LINE_EMPTY=new File("vertical_empty.png");
    private static final File VERTICAL_LINE_FULL=new File("vertical_full.png");
    private static final File BOX=new File("box.png");
    private static final File DOT=new File("dot.png");
    private static final File WOOD=new File("woodTable.png");
    private static final File WOOD_DARK=new File("woodTableDark.png");
    private static final File BACKGROUND= new File("background.jpg");

    private static final File FONT=new File("SfEspressoShackCondensed-mYm5.ttf");

    public static ImageIcon getHorizontalEmptyIcon(){return getImageIcon(new File(IMAGE_DIR,HORIZONTAL_LINE_EMPTY.getName()));}
    public static ImageIcon getHorizontalFullIcon(){return getImageIcon(new File(IMAGE_DIR,HORIZONTAL_LINE_FULL.getName()));}
    public static ImageIcon getVerticalLineEmptyIcon(){return getImageIcon(new File(IMAGE_DIR,VERTICAL_LINE_EMPTY.getName()));}
    public static ImageIcon getVerticalLineFullIcon(){return getImageIcon(new File(IMAGE_DIR,VERTICAL_LINE_FULL.getName()));}
    public static ImageIcon getBoxIcon(){return getImageIcon(new File(IMAGE_DIR,BOX.getName()));}
    public static ImageIcon getDotIcon(){return getImageIcon(new File(IMAGE_DIR,DOT.getName()));}
    public static ImageIcon getWoodIcon(){return getImageIcon(new File(IMAGE_DIR,WOOD.getName()));}
    public static ImageIcon getWoodDarkIcon(){return getImageIcon(new File(IMAGE_DIR,WOOD_DARK.getName()));}
    public static ImageIcon getBackgroundIcon() {return getImageIcon(new File(IMAGE_DIR,BACKGROUND.getName()));}

    public static File getFontFile() {return new File(FONT_DIR,FONT.getName());}

    private static ImageIcon getImageIcon(File imageFile) {
        return new ImageIcon(new ImageIcon(imageFile.getPath()).getImage());
    }

}
