package dotsandboxes.gui.frames;

import dotsandboxes.gui.graphics.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class GridFrame extends Frame{

    private Integer rows;
    private Integer cols;

    private boolean rowInput;
    private boolean colInput;

    public GridFrame(){
        super();
    }

    public List<Integer> setFrame(BackgroundPanel backgroundPanel) {

        List<Integer> dimensions=new ArrayList<>(2);

        GridFrame frame= new GridFrame();
        DBLabel playerQuestion= new DBLabel("GRID DIMENSIONS",225, 30, 150, 30);

        backgroundPanel.add(playerQuestion);

        Integer minDimension=3;
        Integer maxDimension=5;

        List<NumRadioButton> rowsButtons= new ArrayList<>(maxDimension-minDimension);
        List<NumRadioButton> colsButtons= new ArrayList<>(maxDimension-minDimension);

        Integer yOffset = 100;

        for (int i=minDimension; i<maxDimension+1; i++) {
            NumRadioButton rowButton=new NumRadioButton(i,250, yOffset, 40, 30);
            NumRadioButton colButton=new NumRadioButton(i,310, yOffset, 40, 30);
            rowButton.addActionListener(x ->
            {
                rows=rowButton.number;
                rowButton.setSelected(true);
                rowInput=true;
                for (NumRadioButton  rButton : rowsButtons){
                    if(!rButton.equals(rowButton) & rButton.isSelected()){
                        rButton.setSelected(false);
                    }
                }
            });
            colButton.addActionListener(x ->
            {
                cols=colButton.number;
                colButton.setSelected(true);
                colInput=true;
                for (NumRadioButton  cButton : colsButtons){
                    if(!cButton.equals(colButton) & cButton.isSelected()){
                        cButton.setSelected(false);
                    }
                }
            });
            yOffset+=40;
            backgroundPanel.add(rowButton);
            backgroundPanel.add(colButton);
            rowsButtons.add(rowButton);
            colsButtons.add(colButton);
        }



        DBButton button=new DBButton("OK",260, 300, 80, 30);
        button.addActionListener(x ->
        {
            inputGiven=true;
        });
        backgroundPanel.add(button);

        updatePanel(backgroundPanel);

        while (!rowInput || !colInput) {
            waitInput();
        }

        dimensions.add(rows+1);
        dimensions.add(cols+1);

        this.inputGiven=false;
        clear(backgroundPanel);

        return dimensions;
    }
}
