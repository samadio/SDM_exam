package dotsandboxes.gui.frames;

import dotsandboxes.gui.graphics.*;

import java.util.ArrayList;
import java.util.List;

public class GridDimensionFrame extends InputFrame<List<Integer>>{

    private static final int MIN_DIMENSION=3;
    private static final int MAX_DIMENSION=5;

    List<Integer> dimensions;
    private Integer rows;
    private Integer cols;

    private boolean rowInput;
    private boolean colInput;

    public GridDimensionFrame(BackgroundPanel bP){

        super(bP);
        dimensions=new ArrayList<>(2);
    }

    @Override
    public void setPanel() {

        DBLabel playerQuestion= new DBLabel("GRID DIMENSIONS",225, 30, 150, 30);

        backgroundPanel.add(playerQuestion);

        List<NumRadioButton> rowsButtons= new ArrayList<>(MAX_DIMENSION-MIN_DIMENSION);
        List<NumRadioButton> colsButtons= new ArrayList<>(MAX_DIMENSION-MIN_DIMENSION);

        int yOffset = 100;

        for (int i=MIN_DIMENSION; i<MAX_DIMENSION+1; i++) {
            NumRadioButton rowButton=new NumRadioButton(i,250, yOffset, 40, 30);
            NumRadioButton colButton=new NumRadioButton(i,310, yOffset, 40, 30);
            rowButton.addActionListener(x ->
            {
                rows= rowButton.getNumber();
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
                cols= colButton.getNumber();
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
            if(rowInput & colInput) button.setDark();
        });
        backgroundPanel.add(button);

        updatePanel(backgroundPanel);
    }


    @Override
    public List<Integer> getInput() {

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
