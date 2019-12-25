package dotsandboxes;

import gamesuite.move.Move;
import iomanagement.InputManager;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class DotsAndBoxesInput extends InputManager {


    private Boolean settedConverter = false;
    private Converter moveConverter;

    public void setConverter(Integer nCols){

        moveConverter = new Converter(nCols);
        settedConverter = true;
    }

    @Override
    public Move getMove() {
        return this.currentMove;
    }

    //private not considering tests
    public String readInput(){
        Scanner input= new Scanner(System.in);
        return input.nextLine();
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

    @Override
    public Integer[] getGrid() throws DataFormatException{
        System.out.println("Insert grid dimension in format:rowDimension columnDimension");
        Scanner in = new Scanner(System.in);

        Integer[] result = Arrays.stream(in.nextLine().split(" ")).map(Integer::valueOf)
                .toArray(Integer[]::new);
        if (result.length == 2) {
            return result;
        }
        else throw new DataFormatException("Format not recognized");
    }

    @Override
    public void readMove() throws DataFormatException {

        if (!settedConverter)
            throw new InvalidStateException("Convert not set");

        this.currentMove= moveConverter.convert(readInputMove());
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
    public boolean customizePlayers() throws DataFormatException {
        System.out.println("Do you want to customize player names? (y=yes,n=no) ");
        Scanner s=new Scanner(System.in);
        String answer=s.next();
        if(answer.contentEquals(new StringBuffer("y"))) return true;
        else if(answer.contentEquals(new StringBuffer("n"))) return false;
        else throw new DataFormatException("Format not valid");
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