package gametest;

import java.io.OutputStream;

public class DotsAndBoxes {
    public static void main(){
        Game myGame=new Game(new DotsAndBoxesBoard(), new DotsAndBoxesValidator(),new DotsAndBoxesStatus());
        InputManager myIn= new InputManager();
        OutputManager myOut=new OutputManager();
        while(myGame.notEnded()) {
            myIn.readMove();
            try{
                myGame.applyMove(myIn.getMove());
            }
            catch (InvalidMoveException e){
                //stampare mossa invalida richiesta
                continue;
            }
            myOut.print(myGame);
        }



    }
}
