package dotsandboxes.gui.graphics;

public class Box {
    public static void setBox(int i, int j,BackgroundPanel backgroundPanel){

        ObjSpecifics boxSpec= new ObjSpecifics("images/box.png","",40, 40, 40);
        GraphicObj box = new GraphicObj(boxSpec);
        box.setButtonProperties(160 +i*50, 80+j*50, 40, 40);
        backgroundPanel.add(box.getButton());
    }
}
