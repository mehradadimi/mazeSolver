public class MazeRunner {
	Maze mazeToSolve;
	A4Stack<MazeLocation> path;



	public MazeRunner(Maze aMaze) {
		mazeToSolve = aMaze;
		int size = mazeToSolve.getSize();
		path = new A4Stack<MazeLocation>(size);
		System.out.println(size);
	}
	
	/*
	 * Purpose: Determines whether there is a path from start to finish in this maze
	 * Parameters: MazeLocation start - starting coordinates of this maze
	 *			   MazeLocation finish - finish coordinates of this maze
	 * Returns: true if there is a path from start to finish
	 */
	public boolean solve(MazeLocation start, MazeLocation finish) {
		System.out.println("Searching maze from start: "+start+" to finish: "+finish);
		path.push(start);
		return findPath(start, finish);	
	}
	
	/*
	 * Purpose: Recursively determines if there is a path from cur to finish
	 * Parameters: MazeLocation cur - current cordinates in this maze
	 *			   MazeLocation finish - goal coordinates of this maze
	 * Returns: true if there is a path from cur to finish
	 *
	 * NOTE: This method updates the Maze's mazeData array when locations
	 *       are visited to an 'o', and further updates locations to an 'x'
	 *       if it is determined they lead to dead ends. If the finish 
	 *       location is found, the Stack named path should contain all of 
	 *       loations visited from the start location to the finish. 
	 */

	private boolean findPath(MazeLocation cur, MazeLocation finish) {
		boolean SolvedMaze = false;
		boolean NotWork = false;

		char space = ' ';
		char wallH = 'H';
		char visitedO = 'o';
		char deadEndX = 'x';

		int beginningRow = cur.row;
		int beginningCol = cur.col;
		int rowFinish = finish.row;
		int colFinish = finish.col;


		mazeToSolve.setChar(beginningRow, beginningCol, 'o');

		System.out.println("\n" + mazeToSolve.toString());

		int sizeRows  = mazeToSolve.getRows();
		int sizeCols  = mazeToSolve.getCols();


		if (equal(cur.row,rowFinish) && equal(cur.col,colFinish)) {
																					//System.out.println(" This is true or false?");
			return true;
		} else if (LessThan(cur.row+1,sizeRows) && CharEqual(down(cur.row, cur.col),space)) {
				MazeLocation s0;
				s0 = CreateLocationDown(cur.row,cur.col);
				path.push(s0);
																					//System.out.println(cur);
																					//System.out.println(path.toString());

				SolvedMaze =  findPath(s0, finish);

		} else if (moreThanEqual(cur.row-1,0) && CharEqual(up(cur.row, cur.col),space)) {

				MazeLocation s1;
				s1 = CreateLocationUp(cur.row,cur.col);
				path.push(s1);
																					//cur.row = cur.row - 1;
																					//path.push(cur);
				SolvedMaze = findPath(s1, finish);


		} else if (LessThan(cur.col + 1, sizeCols) && CharEqual( right(cur.row, cur.col),space)) {
				MazeLocation s2;
				s2 = CreateLocationRight(cur.row,cur.col);
				path.push(s2);

																						//cur.col = cur.col + 1;
																						//MazeLocation s1 = new MazeLocation(cur.row,cur.col+1);
																						//path.push(cur);
																						//System.out.println(cur);
				SolvedMaze =  findPath(s2, finish);

		} else if (moreThanEqual(cur.col - 1 , 0) && CharEqual(left(cur.row, cur.col),space)) {

				MazeLocation s3;
				s3 = CreateLocationLeft(cur.row,cur.col);
				path.push(s3);


																						//cur.col = cur.col - 1;
																						//MazeLocation s1 = new MazeLocation(cur.row,cur.col-1);
																						//path.push(cur);

																						//setVisited(cur);
																						//System.out.println(cur);
																						//System.out.println(path.toString());
				SolvedMaze = findPath(s3, finish);

		} else if (moreThanEqual(cur.row-1,0) && CharEqual( up(cur.row, cur.col),visitedO)) {

				mazeToSolve.setChar(cur.row, cur.col, deadEndX);
				MazeLocation d = path.pop();
				MazeLocation s4;
				s4 = CreateLocationUp(cur.row,cur.col);
																						//cur.row = cur.row - 1;
																						//System.out.println(cur);
																						//System.out.println(path.toString());
				SolvedMaze = findPath(s4, finish);

		}else if (LessThan(cur.row + 1,sizeRows) && CharEqual(down(cur.row, cur.col),visitedO)) {
				mazeToSolve.setChar(cur.row, cur.col, deadEndX);
				MazeLocation d = path.pop();
				MazeLocation s7;
				s7 = CreateLocationDown(cur.row,cur.col);
																						//cur.row = cur.row + 1;
																						//System.out.println(cur);
																						//System.out.println(path.toString());;
				SolvedMaze = findPath(s7, finish);

		} else if (LessThan(cur.col + 1,sizeCols) && CharEqual(right(cur.row, cur.col),visitedO)) {
				mazeToSolve.setChar(cur.row, cur.col, deadEndX);
				MazeLocation d = path.pop();
				MazeLocation s5;
				s5 = CreateLocationRight(cur.row,cur.col);

																						//cur.col = cur.col + 1;
																						//System.out.println(cur);
																						//System.out.println(path.toString());
				SolvedMaze = findPath(s5, finish);

		} else if (moreThanEqual(cur.col - 1,0) && CharEqual(left(cur.row, cur.col),visitedO)) {
				mazeToSolve.setChar(cur.row, cur.col, deadEndX);
				MazeLocation d = path.pop();
				MazeLocation s6;
				s6 = CreateLocationLeft(cur.row,cur.col);
																						//cur.col = cur.col - 1;
																						//System.out.println(cur);
																						//System.out.println(path.toString());;
				SolvedMaze = findPath(s6, finish);

		}else{
																						//System.out.println("This is unsolvable");
			return NotWork;
		}

		return SolvedMaze;

	}


	/*
	 * Purpose: Creates a string of maze locations found in the stack 
	 * Parameters: None
	 * Returns: A String representation of maze locations
	 */
	public String getPathToSolution() {
		String details = "";
		while(!path.isEmpty()) {
			details = path.pop() + details;
		}
		return details;
	}



	public char up(int row, int col){
		return mazeToSolve.getChar(row-1,col);
	}

	public char down(int row, int col){
		return mazeToSolve.getChar(row+1,col);
	}

	public char left(int row, int col){
		return mazeToSolve.getChar(row,col-1);
	}

	public char right(int row, int col) {
		return mazeToSolve.getChar(row, col + 1);
	}
	public MazeLocation CreateLocationUp(int row, int col){
		MazeLocation s;
		s = new MazeLocation(row-1,col);
		return s;
	}
	public MazeLocation  CreateLocationDown(int row, int col){
		MazeLocation s;
		s = new MazeLocation(row+1,col);
		return s;
	}
	public MazeLocation CreateLocationLeft(int row, int col){
		MazeLocation s;
		s = new MazeLocation(row,col-1);
		return s;
	}
	public MazeLocation CreateLocationRight(int row, int col){
		MazeLocation s;
		s = new MazeLocation(row,col+1);
		return s;
	}
	public boolean equal (int a, int b){
		if (a==b){
			return true;
		}
		return false;
	}
	public boolean moreThanEqual (int a, int b){
		if (a >= b){
			return true;
		}
		return false;
	}
	public boolean LessThan (int a, int b){
		if (a < b){
			return true;
		}
		return false;
	}
	public boolean CharEqual (char a, char b){
		if (a==b){
			return true;
		}
		return false;
	}

}