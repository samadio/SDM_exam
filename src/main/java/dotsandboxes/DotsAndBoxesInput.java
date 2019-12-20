package dotsandboxes;

import gamesuite.Move;
import iomanagement.InputManager;

import java.util.Scanner;
import java.util.UnknownFormatConversionException;

public class DotsAndBoxesInput implements InputManager {

    private Move currentMove;


    public String readInput(){
        Scanner input= new Scanner(System.in);
        return input.nextLine();
    }

    @Override
    public void readMove() {
        String inputLine=readInput();

        if(InputValidator.checkFormat(inputLine)){
            currentMove = ValidatedInputParser.parse(inputLine);
        }
        else
            throw new UnknownFormatConversionException("Format not recognized");

    }

    @Override
    public Move getMove(){
        return currentMove;
    }

}




class InputValidator{
    static boolean checkFormat(String s){
        return true;
        //throw new UnknownFormatConversionException("Format not recognized");
    }

}





class ValidatedInputParser{
    static Move parse(String s){
        Scanner in = new Scanner(s);
        Integer i = in.nextInt();
        String d = in.next();
        switch (d.charAt(0)){
            case 'R':
                return new Move(i, Move.Direction.RIGHT);
            case 'U':
                return new Move(i, Move.Direction.UP);
            case 'L':
                return new Move(i, Move.Direction.LEFT);
            default:
                return new Move(i, Move.Direction.DOWN);
            }
    }
}