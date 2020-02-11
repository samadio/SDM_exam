package gamesuite.players;

public class NameAlreadyUsedException extends PlayerNameException{

   public NameAlreadyUsedException(){
       super();
   }
    public NameAlreadyUsedException(String message){
        super(message);
    }

}
