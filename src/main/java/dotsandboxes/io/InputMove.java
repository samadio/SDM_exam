package dotsandboxes.io;

public class InputMove {

        public enum Direction{RIGHT,DOWN,UP,LEFT}

        private Integer node;
        private Direction direction;

        public InputMove(Integer i,Direction d){
            this.node=i;
            this.direction=d;
        }

        public Integer getNode(){ return this.node;}

        public Direction getDirection(){return this.direction;}


}
