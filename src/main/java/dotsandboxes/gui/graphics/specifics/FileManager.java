package dotsandboxes.gui.graphics.specifics;

import java.io.File;

public class FileManager {
    private static final File DIR=new File("images");
    private static final File HORIZONTAL_LINE_EMPTY=new File("horizontal_empty.png");
    private static final File HORIZONTAL_LINE_FULL=new File("horizontal_full.png");
    private static final File VERTICAL_LINE_EMPTY=new File("vertical_empty.png");
    private static final File VERTICAL_LINE_FULL=new File("vertical_full.png");;
    private static final File BOX=new File("box.png");
    private static final File DOT=new File("dot.png");
    private static final File WOOD=new File("woodTable.png");
    private static final File WOOD_DARK=new File("woodTableDark.png");

    public static File getHorizontalEmptyFile(){return new File(DIR,HORIZONTAL_LINE_EMPTY.getName());}
    public static File getHorizontalFullFile(){return new File(DIR,HORIZONTAL_LINE_FULL.getName());}
    public static File getVerticalLineEmptyFile(){return new File(DIR,VERTICAL_LINE_EMPTY.getName());}
    public static File getVerticalLineFullFile(){return new File(DIR,VERTICAL_LINE_FULL.getName());}
    public static File getBoxFile(){return new File(DIR,BOX.getName());}
    public static File getDotFile(){return new File(DIR,DOT.getName());}
    public static File getBox(){return new File(DIR,BOX.getName());}
    public static File getWood(){return new File(DIR,WOOD.getName());}
    public static File getWoodDark(){return new File(DIR,WOOD_DARK.getName());}

}
