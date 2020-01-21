package dotsandboxes.gui.graphics;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FontSetter {
    public static Font setFont(){

        Font font=new Font("Helvetica Neue",Font.CENTER_BASELINE,12);
        try {
            File f = new File("font/SfEspressoShackCondensed-mYm5.ttf");
            FileInputStream in = new FileInputStream(f);
            font = Font.createFont(Font.TRUETYPE_FONT, in);


        }
        catch (FileNotFoundException |FontFormatException  e) {}
        catch (IOException e) {}

        return font.deriveFont(Font.CENTER_BASELINE, 12);
    }
}
