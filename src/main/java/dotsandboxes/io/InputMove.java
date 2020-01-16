package dotsandboxes.io;

public class InputMove {

        public enum Direction{RIGHT,DOWN,UP,LEFT}

        private final Integer NODE;
        private final Direction DIRECTION;

        public InputMove(Integer nodeNumber,Direction direction){
            this.NODE = nodeNumber;
            this.DIRECTION = direction;
        }

        public Integer getNode(){ return this.NODE;}

        public Direction getDirection(){return this.DIRECTION;}
}
