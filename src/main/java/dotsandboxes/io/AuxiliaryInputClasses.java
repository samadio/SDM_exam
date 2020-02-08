package dotsandboxes.io;

import gamesuite.game.EndGameException;
import gamesuite.game.ResetGameException;

import java.util.*;

class InputValidator{
    static boolean checkFormat(String s){
        List<String> validChar = Arrays.asList("U","D","L","R");
        String trimmed= s.trim();
        List<String> input;
        try{
            input=Arrays.asList(trimmed.split(" +"));
            System.out.println("parsedInput done");
            if(input.size()!=2) return false;
            Integer.valueOf(input.get(0));
            System.out.println("valueOf done");
        }
        catch(Exception e){
            System.out.println("Exception taken");
            return false;
        }
        return validChar.contains(input.get(1));
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

class QuitAndResetChecker{
    static void checkResetCondition(String inputLine) throws ResetGameException {
        if(inputLine.contains("reset")) throw new ResetGameException();
    }

    static void checkQuitCondition(String inputLine) throws EndGameException {
        if(inputLine.contains("quit")|inputLine.contains("exit")) throw new EndGameException();
    }
}