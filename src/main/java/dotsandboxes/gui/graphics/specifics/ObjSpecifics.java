package dotsandboxes.gui.graphics.specifics;

public class ObjSpecifics {

    private String fileName;
    private String fileName2;
    private Integer width;
    private Integer height;
    private Integer hints;

    public ObjSpecifics(String fn, String fn2, Integer w, Integer h, Integer hi) {
        fileName = fn;
        fileName2 = fn2;
        width = w;
        height = h;
        hints = hi;
    }



    public String getFileName() {
        return fileName;
    }

    public String getFileName2() {
        return fileName2;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getHints() {
        return hints;
    }
}

