package dotsandboxes.gui.frames;

import dotsandboxes.gui.graphics.*;
import dotsandboxes.gui.DBbuttons.DBNumRadioButton;
import dotsandboxes.gui.DBbuttons.DBTextButton;
import dotsandboxes.gui.graphics.ObjSpecifics;
import dotsandboxes.gui.DBlabels.DBLabel;

import java.util.ArrayList;
import java.util.List;

public class BoardDimensionFrame extends InputFrame<List<Integer>>{
    
    private static final int MIN_DIMENSION=3;
    private static final int MAX_DIMENSION=5;

    private final List<Integer> DIMENSION;
    private Integer rows;
    private Integer cols;

    private boolean rowInput;
    private boolean colInput;

    public BoardDimensionFrame(BackgroundPanel bP) {

        super(bP);
        DIMENSION=new ArrayList<>(2);
    }

    @Override
    public void setPanel() {

        clear();

        DBLabel playerQuestion= new DBLabel("GRID DIMENSION",new ObjSpecifics(225, 30, 150, 30,80));

        BACKGROUND_PANEL.add(playerQuestion);

        List<DBNumRadioButton> rowsButtons= new ArrayList<>(MAX_DIMENSION-MIN_DIMENSION);
        List<DBNumRadioButton> colsButtons= new ArrayList<>(MAX_DIMENSION-MIN_DIMENSION);

        int yOffset = 100;

        for (int i=MIN_DIMENSION; i<MAX_DIMENSION+1; i++) {
            DBNumRadioButton rowButton=new DBNumRadioButton(i,new ObjSpecifics(250, yOffset, 40, 30,80));
            DBNumRadioButton colButton=new DBNumRadioButton(i,new ObjSpecifics(310, yOffset,40, 30,80));
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

        DBTextButton button=new DBTextButton("OK", new ObjSpecifics(260, 300,80, 30,80));
        button.addActionListener(x ->
        {
            inputGiven=true;
            if(rowInput & colInput) button.setDark();
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
