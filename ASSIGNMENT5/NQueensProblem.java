
public class NQueensProblem {
	static int N;
	static int [][] board;
	
	//crate board
	public static int[][] createBoard(int n){
		if(n<0){
			throw new AssertionError("number must be positive.");
		}
		N = n;
		board = new int[N][N];
		for(int i = 0; i<N;i++){
			for (int j=0;j<N;j++){
				board[i][j] = 0;
			}
		}
		return board;
	}
	
	
	//check the next chosen place is valid or not
	public static boolean isValid(int [][]board, int rowValue, int columnValue, int n){
		int row = 0, column = 0;
		
		// check in same rows and columns for attack
		
		while(row < n && column < n){
			if(board[row][columnValue] == 1 || board[rowValue][column] == 1){
				return false;
			}
			row+=1; column+=1;
		}
		
		// check in both diagonal for attack
		
		for(int k=0;k<n;k++)
        {
            for(int l=0;l<n;l++)
            {
                if(((k+l) == (rowValue+columnValue)) || ((k-l) == (rowValue-columnValue)))
                {
                    if(board[k][l] == 1)
                        return false;
                }
            }
           
        }
		return true;
	}
	
	public static void applyValue(int[][] board, int rowValue, int columnValue){
		board[rowValue][columnValue] = 1;
	}
	
	public static void removeValue(int[][] board, int rowValue, int columnValue){
		board[rowValue][columnValue] = 0;
	}
	
	public static void displayBoard(){
		System.out.println("board: ");
		for(int i = 0; i<N;i++){
			for (int j=0;j<N;j++){
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static boolean nQueen(int[][] board, int startRow, int dimensionOfMatrix){
		if(dimensionOfMatrix == 0){
			displayBoard();
			return true;
		}
		//
		if(startRow>0){
			for (int countRow = 0; countRow < N; countRow++){
				for (int countColumn = startRow; countColumn < N; countColumn++){
					if( isValid(board, countRow, countColumn, N)){
						applyValue(board, countRow, countColumn);
						dimensionOfMatrix -= 1;
						
						if(nQueen(board, countRow, dimensionOfMatrix)){
							return true;
						}
						removeValue(board, countRow, countColumn);
						dimensionOfMatrix += 1;
					}
				}
			}
		}
		//
		else{
			for (int countRow = startRow; countRow < N; countRow++){
				for (int countColumn = 0; countColumn < N; countColumn++){
					if( isValid(board, countRow, countColumn, N)){
						applyValue(board, countRow, countColumn);
						dimensionOfMatrix -= 1;
						
						if(nQueen(board, countRow, dimensionOfMatrix)){
							return true;
						}
						removeValue(board, countRow, countColumn);
						dimensionOfMatrix += 1;
					}
				}
			}
		}
		return false;
	}
	
	
	public static void main(String[] args){
		createBoard(9);
		System.out.print(nQueen(board, 4, N));
	}
}
