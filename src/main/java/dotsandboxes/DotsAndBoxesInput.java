package dotsandboxes;

import gamesuite.Move;
import iomanagement.InputManager;

import java.util.Scanner;

public class DotsAndBoxesInput implements InputManager {
    public String readInput(){
        Scanner input= new Scanner(System.in);
        return input.nextLine();
    }

    public void readMove(){

    }

    public Move getMove(){
        return new Move();
    }

}
