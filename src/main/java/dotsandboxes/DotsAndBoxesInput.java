package dotsandboxes;

import gamesuite.move.InvalidMoveException;
import gamesuite.move.Move;
import iomanagement.InputManager;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.zip.DataFormatException;

public class DotsAndBoxesInput extends InputManager {


    private Boolean settedConverter = false;
    private Converter moveConverter;

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
                printFormatWarning();
            }
        }
    }

    private void printFormatWarning() {

        System.err.println("Invalid move, please use the following format: [NodeNumber] [U|D|L|R]");
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
    public List<Integer> getGridDimensions() throws DataFormatException{

        System.out.println("Insert grid dimension in format:rowDimension columnDimension");
        Scanner in = new Scanner(System.in);

        List<Integer> result = Arrays.stream(in.nextLine().split(" ")).map(Integer::valueOf).collect(Collectors.toList());

        if (result.size() == 2) {

            if (!settedConverter)
                setConverter(result.get(1));
            return result;
        }

        else throw new DataFormatException("Invalid number of dimensions");
    }

    @Override
    public Integer getPlayersNumber() throws DataFormatException{
        System.out.println("Enter number of players");
        Scanner s=new Scanner(System.in);
        Integer i=s.nextInt();
        if(s.hasNext()) throw new DataFormatException("Format not valid");
        return i;
    }

    @Override
    public boolean customPlayers() throws DataFormatException {
        System.out.println("Do you want to customize player names? (y=yes,n=no) ");
        Scanner s=new Scanner(System.in);
        String answer=s.next();
        if(answer.contentEquals(new StringBuffer("y"))) return true;
        else if(answer.contentEquals(new StringBuffer("n"))) return false;
        else throw new DataFormatException("Format not valid");
    }

    @Override
    public String getPlayerName() {
        System.out.print("Insert next player's name: ");
        Scanner s = new Scanner(System.in);
        return s.nextLine();
    }

    @Override
    public void printInvalidMove(InvalidMoveException e) {

        System.err.println(e.getMessage());
    }

    @Override
    public Move getMove() {
        return this.currentMove;
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