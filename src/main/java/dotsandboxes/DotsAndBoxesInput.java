package dotsandboxes;

import gamesuite.move.Move;
import iomanagement.InputManager;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.UnknownFormatConversionException;

public class DotsAndBoxesInput extends InputManager {



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
        if (validChar.contains(direction)) return true;

        return false;


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