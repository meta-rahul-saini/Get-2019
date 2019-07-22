public class NQueensProblem {
	private static int boardSize;
	private static int [][] board;
	
	
	/** creates a Size*Size chaseBoard
	 * @param size:	size of chaseBoard
	 * @return	returns chaseBoard reference
	 */
	public static int[][] createBoard(final int size){
		if(size<0){
			throw new AssertionError("number must be positive.");
		}
		boardSize = size;
		board = new int[boardSize][boardSize];
		for(int rowIndex = 0; rowIndex < boardSize; rowIndex++){
			for (int columnIndex=0;columnIndex < boardSize; columnIndex++){
				board[rowIndex][columnIndex] = 0;
			}
		}
		return board;
	}
	
	
	/**
	 *  it checks weather, on given position if we place a Queen then it would be attacked or not
	 * @param rowIndex:   row index of position for which we want to check
	 * @param columnIndex: column index of position for which we want to check
	 * @return	returns true, if given position is attacked o/w false
	 */
	public static boolean isAttack(int rowIndex, int columnIndex){
		int currentRowIndex = 0, currentColumnIndex = 0;
		
		// check in same rows and columns for attack
		
		while(currentRowIndex < boardSize && currentColumnIndex < boardSize){
			if(board[currentRowIndex][columnIndex] == 1 || board[rowIndex][currentColumnIndex] == 1){
				return false;
			}
			currentRowIndex+=1; currentColumnIndex+=1;
		}
		
		// check in both diagonals for attack
		
		for( currentRowIndex = 0; currentRowIndex < boardSize; currentRowIndex++)
        {
            for(currentColumnIndex=0; currentColumnIndex < boardSize; currentColumnIndex++)
            {
                if(((currentRowIndex+currentColumnIndex) == (rowIndex + columnIndex)) || ((currentRowIndex-currentColumnIndex) == (rowIndex - columnIndex)))
                {
                    if(board[currentRowIndex][currentColumnIndex] == 1)
                        return false;
                }
            }
           
        }
		return true;
	}
	
	/** place the queen on given position by setting value = 1;
	 * @param rowValue	row index of position
	 * @param columnValue	column index of position
	 */
	public static void applyValue(int rowIndex, int columnIndex){
		board[rowIndex][columnIndex] = 1;
	}
	
	/**remove the queen from given position by setting value = 0;
	 * @param rowValue
	 * @param columnValue
	 */
	public static void removeValue(int rowIndex, int columnIndex){
		board[rowIndex][columnIndex] = 0;
	}
	
	
	/**
	 * it shows board after setting placing each queen on appropriate position
	 */
	public static void displayBoard(){
		System.out.println("board: ");
		for(int i = 0; i<boardSize;i++){
			for (int j=0;j<boardSize;j++){
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
	/**
	 * @param board		it is a N*N chaseBoard where N is the size of board.
	 * @param startRow	it is start of a row from where we have to start our move.
	 * @param dimensionOfMatrix	it is initial dimension of matrix.
	 * @return it returns false, if it is not possible to place given N queen on N*N chaseBoard. o/w it returns true, with placing the N queens on N*N board.
	 */
	public static boolean SolveNQueen(int[][] board, int startRow, int dimensionOfMatrix){
		
		if(dimensionOfMatrix == 0){
			displayBoard();
			return true;
		}
		
		// if startRow is greater than 0 then start from startRow index o/w start from 0
		if(startRow>0){
			for (int rowIndex = 0; rowIndex < boardSize; rowIndex++){
				for (int columnIndex = startRow; columnIndex < boardSize; columnIndex++){
					if( isAttack(rowIndex, columnIndex)){
						applyValue(rowIndex, columnIndex);
						dimensionOfMatrix -= 1;
						
						if(SolveNQueen(board, rowIndex, dimensionOfMatrix)){
							return true;
						}
						removeValue(rowIndex, columnIndex);
						dimensionOfMatrix += 1;
					}
				}
			}
		}
	
		else{
			for (int rowIndex = 0; rowIndex < boardSize; rowIndex++){
				for (int columnIndex = 0; columnIndex < boardSize; columnIndex++){
					if( isAttack(rowIndex, columnIndex)){
						applyValue(rowIndex, columnIndex);
						dimensionOfMatrix -= 1;
						
						if(SolveNQueen(board, rowIndex, dimensionOfMatrix)){
							return true;
						}
						removeValue(rowIndex, columnIndex);
						dimensionOfMatrix += 1;
					}
				}
			}
		}
		return false;
	}
	
	
// 	public static void main(String[] args){
// 		int boardSize = 9;
// 		int board[][] = createBoard(9);
// 		int startRow = 6;
// 		System.out.print(SolveNQueen(board, startRow, boardSize));
// 	}
}
