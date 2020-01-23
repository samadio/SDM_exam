package dotsandboxes.gui.graphics;

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

    public static File getHorizontalEmptyFile(){return new File(IMAGE_DIR,HORIZONTAL_LINE_EMPTY.getName());}
    public static File getHorizontalFullFile(){return new File(IMAGE_DIR,HORIZONTAL_LINE_FULL.getName());}
    public static File getVerticalLineEmptyFile(){return new File(IMAGE_DIR,VERTICAL_LINE_EMPTY.getName());}
    public static File getVerticalLineFullFile(){return new File(IMAGE_DIR,VERTICAL_LINE_FULL.getName());}
    public static File getBoxFile(){return new File(IMAGE_DIR,BOX.getName());}
    public static File getDotFile(){return new File(IMAGE_DIR,DOT.getName());}
    public static File getWoodFile(){return new File(IMAGE_DIR,WOOD.getName());}
    public static File getWoodDarkFile(){return new File(IMAGE_DIR,WOOD_DARK.getName());}
    public static File getBackgroundFile() {return new File(IMAGE_DIR,BACKGROUND.getName());}

    public static File getFontFile() {return new File(FONT_DIR,FONT.getName());}

}
