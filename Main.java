import java.util.Random;

public class Main {
	
	static int board[]= {
		0,0,0,
		0,0,0,
		0,0,0,
	};
	
	static boolean oTurn=true;
	static int turns;
	
	static int O_WINS;
	static int X_WINS;
	static int TIES;
	
	public static void main(String[] args) {
		int i=0;
		while(i<1000000) {
			resetBoard();
			Play();
			displayBoard(i);
			i++;
		}
		displayResults(i);
	}
	
	public static void resetBoard() {
		turns=0;
		oTurn=true;
		board = new int[9];
	}
	
	public static void displayBoard(int i) {
		System.out.print(i);
		System.out.print("---"+'\n');
		System.out.print(board[0]+","+board[1]+","+board[2]+'\n');
		System.out.print(board[3]+","+board[4]+","+board[5]+'\n');
		System.out.print(board[6]+","+board[7]+","+board[8]+'\n');
		System.out.print("---"+'\n');
	}
	
	public static void displayResults(int i) {
		System.out.print("O: "+O_WINS);
		System.out.print(" X: "+X_WINS);
		System.out.print(" Ties: "+TIES);
		System.out.print(" Rounds: "+i);
		System.out.print('\n');
		System.out.print("O: "+Math.round(((double)O_WINS/i)*100f)+"%");
		System.out.print(" X: "+Math.round(((double)X_WINS/i)*100f)+"%");
		System.out.print(" Ties: "+Math.round(((double)TIES/i)*100f)+"%");
	}
	
	public static void Play() {
		Random random = new Random();
		int id = random.nextInt(9);
		
		while(board[id] > 0) {
			id = random.nextInt(9);
		}
		
		if(oTurn){board[id] = 1;}else{board[id] = 2;}
		
		oTurn = !oTurn;
		turns++;
		if(!isWinner()){Play();}
	}
	
	static boolean isWinner(){
		if(board[0]==1 && board[1]==1 && board[2]==1) {O_WINS++; return(true);}
		else if(board[3]==1 && board[4]==1 && board[5]==1) {O_WINS++; return(true);}
		else if(board[6]==1 && board[7]==1 && board[8]==1) {O_WINS++;return(true);}
		
		else if(board[0]==2 && board[1]==2 && board[2]==2) {X_WINS++; return(true);}
		else if(board[3]==2 && board[4]==2 && board[5]==2) {X_WINS++; return(true);}
		else if(board[6]==2 && board[7]==2 && board[8]==2) {X_WINS++; return(true);}
		
		else if(board[0]==1 && board[3]==1 && board[6]==1) {O_WINS++; return(true);}
		else if(board[1]==1 && board[4]==1 && board[7]==1) {O_WINS++; return(true);}
		else if(board[2]==1 && board[5]==1 && board[8]==1) {O_WINS++; return(true);}
		
		else if(board[0]==2 && board[3]==2 && board[6]==2) {X_WINS++; return(true);}
		else if(board[1]==2 && board[4]==2 && board[7]==2) {X_WINS++; return(true);}
		else if(board[2]==2 && board[5]==2 && board[8]==2) {X_WINS++; return(true);}
		
		else if(board[0]==1 && board[4]==1 && board[8]==1) {O_WINS++; return(true);}
		else if(board[2]==1 && board[4]==1 && board[6]==1) {O_WINS++; return(true);}
		
		else if(board[0]==2 && board[4]==2 && board[8]==2) {X_WINS++; return(true);}
		else if(board[2]==2 && board[4]==2 && board[6]==2) {X_WINS++; return(true);}
		else {
			if(turns==9){TIES++; return(true);}
			else{return(false);}
		}
	};

}
