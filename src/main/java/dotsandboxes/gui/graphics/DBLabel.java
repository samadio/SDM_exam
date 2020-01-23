package dotsandboxes.gui.graphics;

import dotsandboxes.gui.graphics.specifics.ObjSpecifics;

import javax.swing.*;


public class DBLabel extends JLabel {
    String text;

    public DBLabel(String t, ObjSpecifics objSpecifics) {
        super();
        setLabelProperties(t,objSpecifics);
    }

    public DBLabel(){
        super();
    }

    public void setLabelProperties(String t, ObjSpecifics objSpecifics){
        text=t;
        this.setText(text);
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setVerticalAlignment(JLabel.CENTER);
        this.setBounds(objSpecifics.getPosition().x, objSpecifics.getPosition().y, objSpecifics.getSize().width, objSpecifics.getSize().height);
        this.setFont(FontSetter.setFont());


        this.setOpaque(false);
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("images/woodTable.png").getImage().getScaledInstance(objSpecifics.getSize().width,objSpecifics.getSize().height, objSpecifics.getHints()));
        this.setIcon(imageIcon);
        this.setVerticalTextPosition(SwingConstants.CENTER);
        this.setHorizontalTextPosition(SwingConstants.CENTER);
    }
}
