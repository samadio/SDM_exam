package dotsandboxes.io;

import gamesuite.game.EndGameException;
import gamesuite.game.ResetGameException;
import gamesuite.move.Move;
import iomanagement.InputManager;
import iomanagement.OutputManager;

import java.util.*;
import java.util.stream.Collectors;
import java.util.zip.DataFormatException;

public class DotsAndBoxesInput implements InputManager {

    private Move currentMove;
    private final OutputManager OUTPUT;

    public DotsAndBoxesInput(OutputManager oManager){
        OUTPUT = oManager;
    }

    private Boolean converterSet = false;
    private Converter moveConverter;

    private void setConverter(Integer nCols){
        moveConverter = new Converter(nCols);
        converterSet = true;
    }

    private String readInput(){
        Scanner input= new Scanner(System.in);
        if (!input.hasNextLine())
            throw new ExhaustedInputException();
        return input.nextLine();
    }


    //private not considering tests
    private InputMove readInputMove() throws DataFormatException, EndGameException, ResetGameException {
        OUTPUT.outputMessage("Insert edge to be inserted in the format:[NodeNumber] [Direction={L,R,U or D}]");
        String inputLine=readInput();

        QuitAndResetChecker.checkQuitCondition(inputLine);
        QuitAndResetChecker.checkResetCondition(inputLine);

        return InputParser.parse(inputLine);
    }

    private void readMove() throws EndGameException, ResetGameException {

        if (!converterSet)
            throw new InvalidStateException("Convert not set");
        boolean invalidInput = true;
        while(invalidInput){

            try {
                this.currentMove = moveConverter.convert(readInputMove());
                invalidInput = false;
            }
            catch (DataFormatException e){
                OUTPUT.errorMessage(e.getMessage());
            }
        }
    }


    @Override
    public String getPlayerName() {
        String playerNameMessage = "Insert next player's name: ";
        OUTPUT.outputMessage(playerNameMessage);
        return readInput();
    }


    @Override
    public Move getMove() throws EndGameException, ResetGameException{
        readMove();
        return this.currentMove;
    }

    private List<Integer> setGridDimensions() {

        String gridMessage = "Insert grid dimension in format:[rowsNumber] [columnsNumber]";
        OUTPUT.outputMessage(gridMessage);

        boolean invalidDimensions = true;
        List<Integer> dimensions = null;

        while (invalidDimensions) {
            try {

                List<String> parsedInput = Arrays.asList(readInput().trim().split(" +"));
                dimensions = parsedInput.stream().map(Integer::valueOf).collect(Collectors.toList());
                if (dimensions.size() != 2) {
                    OUTPUT.errorMessage("Error: invalid grid dimensions.");
                    OUTPUT.outputMessage(gridMessage);
                } else
                    invalidDimensions = false;
            } catch (NumberFormatException e) {
                OUTPUT.errorMessage("Error: the input is expected to be a sequence of integer.");
                OUTPUT.outputMessage(gridMessage);
            }
        }
        return dimensions;
    }

    @Override
    public List<Integer> getGridDimensions() {
        List<Integer> dimensions= setGridDimensions();
        setConverter(dimensions.get(1));
        return dimensions;
    }

    @Override
    public Integer getPlayersNumber(){

        String playersMessage = "Enter number of players";

        List<String> input;
        int i = -1;
        boolean invalidNumber = true;

        while (invalidNumber){

            try {
                OUTPUT.outputMessage(playersMessage);
                input= new ArrayList<>(Arrays.asList(readInput().split(" ")));
                //if u put blank spaces at the beginning or the end, it doesn't matter
                input.removeAll(Collections.singletonList(""));

                if(input.size()!=1) throw new InputMismatchException();
                i=Integer.parseInt(input.get(0));
                invalidNumber = false;
                if(i<=0){
                    invalidNumber=true;
                    OUTPUT.errorMessage("Error: insert a number of players greater than 0");
                }
            }
            catch (InputMismatchException e){
                OUTPUT.errorMessage("Error: invalid number of inputs for number of players");
                OUTPUT.outputMessage(playersMessage);
            }
            catch(NumberFormatException e){
                OUTPUT.errorMessage("Error: the input is expected to be Integer");
                OUTPUT.outputMessage(playersMessage);
            }
        }
        return i;
    }

    @Override
    public boolean customPlayers(){

        String customPlayersMessage = "Do you want to customize player names? (y=yes,n=no)";
        OUTPUT.outputMessage(customPlayersMessage);
        String answer=readInput().trim();

        while (true) {
            if (answer.equalsIgnoreCase("y")) return true;
            else if (answer.equalsIgnoreCase("n")) return false;
            OUTPUT.errorMessage("Error: invalid answer");
            OUTPUT.outputMessage(customPlayersMessage);
            answer=readInput();
        }
    }


}