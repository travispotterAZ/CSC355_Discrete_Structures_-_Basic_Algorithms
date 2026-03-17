public class LeaderBoard {
    private Contestant[] board;


    public LeaderBoard(int m){  //Default Constructor: greatest score will be at index 0
        board = new Contestant[m];
        for(int i = 0; i < m; i++){
            board[i] = new Contestant();
        }
    }
    
    public void add(Contestant c){
        for(int i = 0; i < board.length; i++){ //start checking at greatest score (index 0)
            if(c.getScore() > board[i].getScore()){
                updateBoard(c, i);//Update Scoreboard
                return;
            }
        }
    }

    private void updateBoard(Contestant c, int index){ 
        for(int i = board.length-1; i >= index; i--){ //Starts at end of board (lowest score)
            if(i == index){ 
                board[i] = c;
            }

            else{
                board[i] = board[i-1];
            }
        }
    }

    public Contestant[] finalBoard(){
        return board;
    }

}

