package gamesuite.players;

public class NameAlreadyUsedException extends Exception{

   public NameAlreadyUsedException(){
       super();
   }
    public NameAlreadyUsedException(String message){
        super(message);
    }

}
