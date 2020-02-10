package dotsandboxes.io;

import gamesuite.game.EndGameException;
import gamesuite.game.ResetGameException;

import java.util.*;
import java.util.zip.DataFormatException;

class InputValidator{
    static void checkFormat(String s) throws DataFormatException {
        List<String> validChar = Arrays.asList("U","D","L","R");
        String trimmed=  s.trim();
        List<String> input;
        try{
            input = Arrays.asList(trimmed.split(" +"));
            if( input.size() != 2 ) throw new DataFormatException("Invalid move, please use the following format: [NodeNumber] [U|D|L|R]");
            Integer.valueOf(input.get(0));
        }
        catch(Exception e){
            throw new DataFormatException("Invalid move, please use the following format: [NodeNumber] [U|D|L|R]");
        }
        if(!validChar.contains( input.get(1) )) throw new DataFormatException("Invalid move, please use the following format: [NodeNumber] [U|D|L|R]");
    }
}

class InputParser {
    static InputMove parse(String s) throws DataFormatException {
        InputValidator.checkFormat(s);
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

class ExitAndResetChecker {
    static void checkResetCondition(String inputLine) throws ResetGameException {
        if(inputLine.contains("reset")) throw new ResetGameException();
    }

    static void checkQuitCondition(String inputLine) throws EndGameException {
        if(inputLine.contains("quit")|inputLine.contains("exit")) throw new EndGameException();
    }
}