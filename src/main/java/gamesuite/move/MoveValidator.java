package gamesuite.move;

import gamesuite.board.BoardManager;

public class MoveValidator {
    BoardManager bm;

    public MoveValidator(BoardManager desired){
        this.bm=desired;
    }

    public boolean invalidNode(Integer i){
        return (i<0)  |  (i>bm.columnsLength()*bm.rowLength()-1) ;
    }


    public boolean moveAlreadyDone(Move m){
        return bm.moveDone(m);
    }

    public boolean outBoardLine(Move m) throws MoveOutOfBoardException{
        Integer rowLen=bm.rowLength();
        Integer colLen=bm.columnsLength();

        return (leftFromFirstCol(m,rowLen)| rightFromLastCol(m,rowLen)| upFromFirstRow(m,rowLen) | downFromLastRow(m,rowLen,colLen));  //  throw new MoveOutOfBoardException(m); return true;
    }

            private boolean leftFromFirstCol(Move m, Integer rowLen) {
                return (inFirstColumn(m,rowLen)) && (m.getDirection()== Move.Direction.LEFT);
            }

            private boolean inFirstColumn(Move m, Integer rowLen) {
                return m.getNode()%rowLen==0;
            }

            private boolean rightFromLastCol(Move m, Integer rowLen) {
                return (inLastColumn(m,rowLen)) && (m.getDirection()== Move.Direction.RIGHT);
            }

            private boolean inLastColumn(Move m, Integer rowLen) {
                return (m.getNode()+1)%rowLen==0;
            }


            private boolean upFromFirstRow(Move m, Integer rowLen) {
                return (inFirstRow(m,rowLen)) && (m.getDirection()== Move.Direction.UP);
            }

            private boolean inFirstRow(Move m, Integer rowLen) {
                return m.getNode()<rowLen;
            }

            private boolean downFromLastRow(Move m, Integer rowLen, Integer colLen) {
                return (inLastRow(m,rowLen,colLen)) && (m.getDirection()== Move.Direction.DOWN);
            }

            private boolean inLastRow(Move m, Integer rowLen, Integer colLen) {
                return rowLen*colLen-1-m.getNode()<rowLen;
            }



    public void validateMove(Move m) throws MoveAlreadyDoneException, MoveOutOfBoardException, InvalidNodeException {
        if(invalidNode(m.getNode())) throw new InvalidNodeException(m);
        if(outBoardLine(m)) throw new MoveOutOfBoardException(m);
        if(moveAlreadyDone(m)) throw new MoveAlreadyDoneException(m);
    }

}