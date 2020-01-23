package dotsandboxes.gui.frames;

import dotsandboxes.gui.graphics.*;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

public class GridDimensionFrame extends InputFrame<List<Integer>>{
    
    private static final int MIN_DIMENSION=3;
    private static final int MAX_DIMENSION=5;

    private final List<Integer> DIMENSION;
    private Integer rows;
    private Integer cols;

    private boolean rowInput;
    private boolean colInput;

    public GridDimensionFrame(BackgroundPanel bP, File imageDir, File fontDir) {

        super(bP, imageDir, fontDir);
        DIMENSION=new ArrayList<>(2);
    }

    @Override
    public void setPanel() {

        clear();

        DBLabel playerQuestion= new DBLabel("GRID DIMENSION",225, 30, 150, 30);

        BACKGROUND_PANEL.add(playerQuestion);

        List<DBNumRadioButton> rowsButtons= new ArrayList<>(MAX_DIMENSION-MIN_DIMENSION);
        List<DBNumRadioButton> colsButtons= new ArrayList<>(MAX_DIMENSION-MIN_DIMENSION);

        int yOffset = 100;

        for (int i=MIN_DIMENSION; i<MAX_DIMENSION+1; i++) {
            DBNumRadioButton rowButton=new DBNumRadioButton(IMAGE_DIR,i,new Point(250, yOffset),new Rectangle( 40, 30));
            DBNumRadioButton colButton=new DBNumRadioButton(IMAGE_DIR,i,new Point(310, yOffset), new Rectangle(40, 30));
            rowButton.addActionListener(x ->
            {
                rows= rowButton.getNumber();
                rowButton.setSelected(true);
                rowInput=true;
                for (DBNumRadioButton rButton : rowsButtons){
                    if(!rButton.equals(rowButton) & rButton.isSelected()){
                        rButton.setSelected(false);
                    }
                }
            });
            colButton.addActionListener(x ->
            {
                cols= colButton.getNumber();
                colButton.setSelected(true);
                colInput=true;
                for (DBNumRadioButton cButton : colsButtons){
                    if(!cButton.equals(colButton) & cButton.isSelected()){
                        cButton.setSelected(false);
                    }
                }
            });
            yOffset+=40;
            BACKGROUND_PANEL.add(rowButton);
            BACKGROUND_PANEL.add(colButton);
            rowsButtons.add(rowButton);
            colsButtons.add(colButton);
        }

        Point position = new Point(260, 300);
        Rectangle dimensions = new Rectangle(80, 30);
        ImageIcon image = new ImageIcon(new ImageIcon(IMAGE_DIR.getPath()+"/woodTable.png").getImage().getScaledInstance((int) dimensions.getWidth(), (int) dimensions.getHeight(), 80));

        DBTextButton button=new DBTextButton("OK",image, position, dimensions);
        button.addActionListener(x ->
        {
            inputGiven=true;
            if(rowInput & colInput){
                ImageIcon darkImage = new ImageIcon(new ImageIcon(IMAGE_DIR.getPath()+"/woodTableDark.png").getImage().getScaledInstance((int) dimensions.getWidth(), (int) dimensions.getHeight(), 80));
                button.setIcon(darkImage);
            }
        });
        BACKGROUND_PANEL.add(button);

        updatePanel();
    }


    @Override
    public List<Integer> getInput() {

        while (!rowInput || !colInput) {
            waitInput();
        }

        DIMENSION.add(rows+1);
        DIMENSION.add(cols+1);

        this.inputGiven=false;
        clear();

        return DIMENSION;
    }
}
