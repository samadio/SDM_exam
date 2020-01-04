package dotsandboxes.io;

import gamesuite.game.EndGameException;
import gamesuite.game.ResetGameException;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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
        String direction;
        try{
            direction = in.next();
        } catch (Exception e) {
            return false;
        }
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

class QuitAndResetChecker{
    static void checkResetCondition(String inputLine) throws ResetGameException {
        if(inputLine.contains("reset")) throw new ResetGameException();
    }

    static void checkQuitCondition(String inputLine) throws EndGameException {
        if(inputLine.contains("quit")|inputLine.contains("exit")) throw new EndGameException();
    }
}