package tictactoe;

public class TicTacToeBoardImpl_Thomasson  implements TicTacToeBoard
{
protected static final int NO_MOVE = -1;
protected static final int NO_MATCH = -1;
public final static int ROW_COUNT = 3;
public final static int COLUMN_COUNT = 3;

protected int[] movesArray; 


public TicTacToeBoardImpl_Thomasson()
{
	final int CELL_COUNT = ROW_COUNT*COLUMN_COUNT;
	movesArray = new int[CELL_COUNT];
	for(int i = 0; i < CELL_COUNT; i++)
	{
		movesArray[i] = NO_MOVE; //fills empty TicTacToe Board/(intArray on impl side with all -1's
	}
}

public Mark getMark(int row, int column) 
{
	Mark rv = null;
	int gridSlot = 0; //gridSlot = location on TicTacToe Bard
	
	if (row == 0)
		gridSlot = column; // ex) (row1, column1 = 0, row1,column2 = 1)
	if (row ==1)
		gridSlot = column +3;
	if (row ==2)
		gridSlot = column +6;

	for(int i = 0; i<=8; i++)
	
		if (movesArray[i] == gridSlot)
		{
			if(i%2 ==0)
			rv =  Mark.X;
			if(i%2 == 1)
			rv = Mark.O;
		}
	return rv;
}			

//part of pre: isGameOver = False
//part of pre: 0 <= row < ROW_COUNT && 0 <= column < COLUMN_COUNT
//part of pre: getMark(row, column) == null
public void setMark(int row, int column)  
{
	assert !isGameOver() : "Game is over, cannot set another Mark!";
	assert row<=2  : "row must be between 0 & 2!";
	assert 0 <= row  : "row must be between 0 & 2!";
	
	assert 0<= column: " column must be between 0 & 2!";
	assert column <=2: " column must be between 0 & 2!";
	assert getMark(row, column) == null: "slot already marked!";

	int gridSlot = -1; //gridSlot = location on TicTacToe Bard
	if (row == 0)
		gridSlot = column; 
	if (row ==1)
		gridSlot = column +3;
	if (row ==2)
		gridSlot = column +6;
		
	for(int i = 0; i<=8; i++)
	{
		if (movesArray[i] == -1)
		{	
			movesArray[i] = gridSlot; //adds gridSlot to first position in Array that is still = -1, if not= -1, goes to next index
			break;   
		}
	}	
}

//part of post: rv == null if it is neither players turn, game  is over
public Mark getTurn()  
{	
	if(isGameOver() == true)
		return null;
	
	Mark rv = Mark.X; //initial = X: takes care of empty board
	for(int i = 0; i <=8; i++) 
	{	
		int gridSlotValueInMovesArray = movesArray[i];  
		if (gridSlotValueInMovesArray == -1)
		{
		if (i%2 == 1) 
		{
			rv = Mark.O;
			return rv;
		}
		if(i%2 == 0)
		{
			rv = Mark.X;
			return rv;
		}}
}
return rv;	
}

public boolean isGameOver() 
{
	boolean isGameOver = false;
	if(getMarkCount() == 9)
		{
		 isGameOver = true;}
	if(getWinner() == null)
		{ 
		 isGameOver = false;
		}
	if(getWinner() == Mark.X)
	{
		 isGameOver = true;	}
	if(getWinner() == Mark.O)
	{
		 isGameOver = true;}

	return isGameOver;

}
	

//part of post: True = there is a winner(not a draw)
//part of post: if True, isGameOver() = true
//part of post: null = no winner

public Mark getWinner()
{
	Mark winner = null;



//HARD CODE ROWS
for(int i = 0; i <=2; i++)
{
if(getMark(i,0) == Mark.X && getMark(i,1) == Mark.X && getMark(i,2) == Mark.X)
	return winner = Mark.X;

}
for(int iROW = 0; iROW <=2; iROW++)
{
if(getMark(iROW,0) == Mark.O && getMark(iROW,1) == Mark.O && getMark(iROW,2) == Mark.O)
	return winner = Mark.O;


//HARD CODE COLUMNS
for(int icX = 0; icX <=2; icX++)
{
if(getMark(0,icX) == Mark.X && getMark(1,icX) == Mark.X && getMark(2,icX) == Mark.X)
	return winner = Mark.X;

}

for(int icO = 0; icO <=2; icO++)
{
if(getMark(0,icO) == Mark.O && getMark(1,icO) == Mark.O && getMark(2,icO) == Mark.O)
	return winner = Mark.O;

}

//HARD CODE DIAGS


if(getMark(0,0) == Mark.X && getMark(1,1) == Mark.X && getMark(2,2) == Mark.X)
	return winner = Mark.X;
if(getMark(0,0) == Mark.O && getMark(1,1) == Mark.O && getMark(2,2) == Mark.O)
	return winner = Mark.O;

if(getMark(0,2) == Mark.X && getMark(1,1) == Mark.X && getMark(2,0)== Mark.X)
	return winner = Mark.X;

if(getMark(0,2) == Mark.O && getMark(1,1) == Mark.O && getMark(2,0)== Mark.O)
	return winner = Mark.O;

}
return winner;

}
public String toString()
{
	String toString = "";	
	toString += ((getMark(0,0)) + "|" + getMark(0,1) + "|" + getMark(0,2) + "\n" + 
			getMark(1,0) + "|"+ getMark(1,1) + "|" + getMark(1,2)+ "\n" +
			getMark(2,0)+ "|" + getMark(2,1) + "|" + getMark(2,2) + "\n" );

	return toString;
}


private int getMarkCount() 
{
	int markCount = 0;
	for(int i =0; i<=8; i++)
		if (movesArray[i] != -1)
		
		markCount ++;
		
return markCount;
}
}