package dotsandboxes.gui.graphics;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FontSetter {
    public static Font setFont(){

        Integer size=14;

        Font font=new Font("Helvetica Neue",Font.CENTER_BASELINE,size);
        try {
            File f = new File(FileManager.getFontFile().getPath());
            FileInputStream in = new FileInputStream(f);
            font = Font.createFont(Font.TRUETYPE_FONT, in);
            GraphicsEnvironment ge;
            ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(font);


        }
        catch (FileNotFoundException |FontFormatException  e) {}
        catch (IOException e) {}

        return font.deriveFont(Font.CENTER_BASELINE, size);
    }
}
