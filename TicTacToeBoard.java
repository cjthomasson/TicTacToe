package tictactoe;

public interface TicTacToeBoard 
{
//Player with mark X always goes first

		public final static int ROW_COUNT = 3;
		public final static int COLUMN_COUNT = 3;
		
		// part of pre: 0 <= row < ROW_COUNT && 0 <= column < COLUMN_COUNT
		// part of post: rv == null <==> the (row, column) spot on the board is empty
		public Mark getMark(int row, int column);
		
		//part of pre: 0 <= row < ROW_COUNT && 0 <= column < COLUMN_COUNT
		//part of pre: getMark(row, column) == null
		//part of pre: !isGameOver()
		//post:
		public void setMark(int row, int column);
		
		//part of post: rv == null <==> it is neither players turn i.e.  game is over 
		//part of post: "number of Marks on board is even -> rv == Mark.X
		//part of post: "number of Marks on board is odd -> rv == Mark.O
		public Mark getTurn();
		
		//part of post: 
		public boolean isGameOver();
		
		//part of pre: isGameOver()
		//part of post: rv == null <==> neither player won( i.e. the game ended in a tie)
		public Mark getWinner();

		
	}

