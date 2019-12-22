package gamesuite.move;

import gamesuite.board.BoardManager;

public class MoveValidator {
    BoardManager bm;

    public MoveValidator(BoardManager desired){
        this.bm=desired;
    }

    public boolean invalidNode(Integer i){
        return (i<1)  |  (i>bm.colLength()*bm.rowLength()) ;
    }


    public boolean moveAlreadyDone(Move m) throws MoveAlreadyDoneException{
        return bm.moveDone(m); //throw new MoveAlreadyDoneException(m);
    }

    public boolean outBoardLine(Move m) throws MoveOutOfBoardException{
        Integer rowLen=bm.rowLength();
        Integer colLen=bm.colLength();

        return (leftFromFirstCol(m,rowLen)| rightFromLastCol(m,rowLen)| upFromFirstRow(m,rowLen) | downFromLastRow(m,rowLen,colLen));  //  throw new MoveOutOfBoardException(m); return true;
    }

            private boolean leftFromFirstCol(Move m, Integer rowLen) {
                return (inFirstColumn(m,rowLen)) && (m.getDirection()== Move.Direction.LEFT);
            }

            private boolean inFirstColumn(Move m, Integer rowLen) {
                return m.getNode()%rowLen==1;
            }

            private boolean rightFromLastCol(Move m, Integer rowLen) {
                return (inLastColumn(m,rowLen)) && (m.getDirection()== Move.Direction.RIGHT);
            }

            private boolean inLastColumn(Move m, Integer rowLen) {
                return m.getNode()%rowLen==0;
            }


            private boolean upFromFirstRow(Move m, Integer rowLen) {
                return (inFirstRow(m,rowLen)) && (m.getDirection()== Move.Direction.UP);
            }

            private boolean inFirstRow(Move m, Integer rowLen) {
                return m.getNode()<rowLen+1;
            }

            private boolean downFromLastRow(Move m, Integer rowLen, Integer colLen) {
                return (inLastRow(m,rowLen,colLen)) && (m.getDirection()== Move.Direction.DOWN);
            }

            private boolean inLastRow(Move m, Integer rowLen, Integer colLen) {
                return rowLen*colLen-m.getNode()<rowLen+1;
            }



    public void validate(Move m) throws MoveAlreadyDoneException, MoveOutOfBoardException{
        if(moveAlreadyDone(m)) throw new MoveAlreadyDoneException(m);
        if(outBoardLine(m)| invalidNode(m.getNode())) throw new MoveOutOfBoardException(m);
    }

}