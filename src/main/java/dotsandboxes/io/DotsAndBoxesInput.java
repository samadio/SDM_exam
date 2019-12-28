package dotsandboxes.io;

import gamesuite.move.Move;
import iomanagement.InputManager;
import iomanagement.OutputManager;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.zip.DataFormatException;

public class DotsAndBoxesInput extends InputManager {


    private Boolean settedConverter = false;
    private Converter moveConverter;

    public DotsAndBoxesInput(OutputManager oManager) {
        super(oManager);
    }

    public void setConverter(Integer nCols){

        moveConverter = new Converter(nCols);
        settedConverter = true;
    }

    @Override
    public void readMove(){

        if (!settedConverter)
            throw new InvalidStateException("Convert not set");
        boolean invalidInput = true;
        while(invalidInput){

            try {
                this.currentMove = moveConverter.convert(readInputMove());
                invalidInput = false;
            }
            catch (DataFormatException e){
                OUTPUT.errorPrintln("Invalid move, please use the following format: [NodeNumber] [U|D|L|R]");
            }
        }
    }

    //private not considering tests
    public InputMove readInputMove() throws DataFormatException {
        String inputLine=readInput();

        if(InputValidator.checkFormat(inputLine)){
            return ValidatedInputParser.parse(inputLine);
        }
        else
            throw new DataFormatException("Format not recognized");

    }

    //private not considering tests
    public String readInput(){
        Scanner input= new Scanner(System.in);
        return input.nextLine();
    }

    @Override
    public Move getMove() {
        return this.currentMove;
    }

    @Override
    public List<Integer> getGridDimensions() {

        String gridMessage = "Insert grid dimension in format:rowNumber columnNumber";
        OUTPUT.outputPrintln(gridMessage);
        Scanner in = new Scanner(System.in);

        boolean invalidDimensions = true;
        List<Integer> result = Arrays.stream(in.nextLine().split(" ")).map(Integer::valueOf).collect(Collectors.toList());

        while (invalidDimensions) {

            if (result.size() != 2) {
                OUTPUT.errorPrintln("Error: invalid grid dimensions.");
                OUTPUT.outputPrintln(gridMessage);
                result = Arrays.stream(in.nextLine().split(" ")).map(Integer::valueOf).collect(Collectors.toList());
            }
            else
                invalidDimensions = false;
        }

        setConverter(result.get(1));

        return result;
    }

    @Override
    public Integer getPlayersNumber(){

        String playersMessage = "Enter number of players";
        OUTPUT.outputPrintln(playersMessage);
        Scanner s=new Scanner(System.in);

        List<String> input= s.tokens().collect(Collectors.toList());
        int i = 2;
        boolean invalidNumber = true;

        while (invalidNumber){

            try {
                if(input.size()!=1) throw new InputMismatchException();
                i=Integer.parseInt(input.get(0));
                invalidNumber = false;
            }
            catch (InputMismatchException e){
                OUTPUT.errorPrintln("Error: invalid number of inputs for number of players");
                OUTPUT.outputPrintln(playersMessage);
            }
            catch(NumberFormatException e){
                OUTPUT.errorPrintln("Error: the input is expected to be Integer");
                OUTPUT.outputPrintln(playersMessage);
            }
        }
        return i;
    }

    @Override
    public boolean customPlayers(){

        String customPlayersMessage = "Do you want to customize player names? (y=yes,n=no)";
        OUTPUT.outputPrintln(customPlayersMessage);
        Scanner s=new Scanner(System.in);
        String answer=s.next();

        while (true) {
            if (answer.contentEquals(new StringBuffer("y"))) return true;
            else if (answer.contentEquals(new StringBuffer("n"))) return false;
            else{
                OUTPUT.errorPrintln("Error: invalid answer");
                OUTPUT.outputPrintln(customPlayersMessage);
                answer=s.next();
            }
        }
    }

    @Override
    public String getPlayerName() {

        String playerNameMessage = "Insert next player's name: ";

        OUTPUT.outputPrint(playerNameMessage);
        Scanner s = new Scanner(System.in);
        return s.nextLine();
    }
}



class InputValidator{
    static boolean checkFormat(String s){
        Scanner in = new Scanner(s);
        try{
            Integer i = in.nextInt();
        }
        catch(Exception e){
            return false;
        }

        List<String> validChar = Arrays.asList("U","D","L","R");
        String direction = in.next();
        if (direction.length()!=1) return false;
        return (validChar.contains(direction));
    }
}

class ValidatedInputParser{
    static InputMove parse(String s){
        Scanner in = new Scanner(s);
        Integer i = in.nextInt();
        String d = in.next();
        switch (d.charAt(0)){
            case 'R':
                return new InputMove(i, InputMove.Direction.RIGHT);
            case 'U':
                return new InputMove(i, InputMove.Direction.UP);
            case 'L':
                return new InputMove(i, InputMove.Direction.LEFT);
            default:
                return new InputMove(i, InputMove.Direction.DOWN);
            }
    }
}