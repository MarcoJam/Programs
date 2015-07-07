package gj.forza4.player;

/**
 * 
 * Progetto di Programmazione:
 * sviluppo di un giocatore di forza quattro
 * @author Cecchi, Galli, Rotini
 *
 */
public class Cecchi implements Player {
	
	int [][] board;
	int nr, nc;

	/**
	 *  Metodo dell'interfaccia Player, il giocatore sceglie la propria mossa
	 */
	public int move () {
		for(int i=0; i<nr; i++) {
			for(int j=0; j<nc; j++) {
				if(board[i][j]==2) {
					System.out.print("-"+ " ");
				} else {
					System.out.print(board[i][j]+" ");
				}
			}
			System.out.println();
		}
		System.out.println("----------");
		return controlWin();
	}

	/**
	 *  Metodo dell'interfaccia Player, dice al giocatore di iniziare la partita
	 */
	public void start (int arg0, int arg1) {
		nr = arg0;
		nc = arg1;
		board = new int [nr][nc];
		inizialize(nr,nc);		
	}

	/**
	 *  Metodo dell'interfaccia Player, riceve la mossa dell'avversario
	 */
	public void tellMove (int c) {
		fill(c,0);
	}
	
	public int controlWin () {
		int i=0;
		while(i<nc) {
			if(isLegalMove(i)) {
				if(ifWin(i,1)) {
					return i;
				}
			}
			i++;
		}
		i=0;
		while(i<nc) {
			if(isLegalMove(i)) {
				if(ifWin(i,0)) {
					return i;
				}
			}
			i++;
		}
		return random();
	}
	
	public int random () {
		boolean flag=true;
		int a=0;
		while(flag==true) {
			a=(int)(Math.random()*7);
			if(isLegalMove(a)) {
				fill(a,1);
				flag=false;
			}
		}
		return a;
	}
	
	/**
	 * Metodo che controlla se esiste una mossa che fa vincere
	 * @param c Colonna nella quale viene posizionato il gettone
	 * @param value Valore del gettone
	 * @return true Se mettendo un gettone nella colonna c il giocatore vince, false altrimenti
	 */
	public boolean ifWin (int c, int value) {
		int count=1;
		int row=findRow(c);		
		for(int i=1; i<4; i++) {
			if(c-i<0 || board[row][c-i]!=value) {
				break;
			}
			count++;
		}
		for(int i=1; i<4; i++) {
			if(c+i>(nc-1) || board[row][c+i]!=value) {
				break;
			}
			count++;
		}
		if(count>=4) {
			System.out.println("Orizzontale sì");
			return true;
		}
		count=1;
		for(int i=1; i<4; i++) {
			if(row-i<0 || board[row-i][c]!=value) {
				break;
			}
			count++;
		}		
		if(count>=4) {
			System.out.println(count+" Verticale sì");
			return true;
		}
		count=1;
		for(int i=1; i<4; i++) {
			if(row-i<0 || c-i<0 || board[row-i][c-i]!=value) {
				break;
			}
			count++;
		}
		for(int i=1; i<4; i++) {
			if(row+i>(nr-1) || c+i>(nc-1) || board[row+i][c+i]!=value) {
				break;
			}
			count++;
		}
		if(count>=4) {
			System.out.println("Diagonale sì");
			return true;
		}
		count=1;
		for(int i=1; i<4; i++) {
			if(row-i<0 || c+i>(nc-1) || board[row-i][c+i]!=value) {
				break;
			}
			count++;
		}
		for(int i=1; i<4; i++) {
			if(row+i>(nr-1) || c-i<0 || board[row+i][c-i]!=value) {
				break;
			}
			count++;
		}
		if(count>=4) {
			System.out.println("Diagonale2 sì");
			return true;
		}
		return false;
	}
	
	/**
	 * La funzione fill inserisce nella tabella la mossa c
	 * @param c La colonna da riempire
	 * @param value Quale valore devo mettere nella tabella
	 */
	public void fill (int c, int value) {
		board[findRow(c)][c]=value;
	}
	
	public int findRow (int c) {
		int i=0;
		while(i<nr) {
			if(board[i][c]==2) {
				break;
			}
			i++;
		}
		return i;
	}
	
	/**
	 * Questo metodo inizializza il campo con valori null
	 * @param board Rappresenta il campo
	 * @param nr Numero righe
	 * @param nc Numero colonne
	 * @return board, il campo svuotato
	 */
	public void inizialize (int nr, int nc) {
		for(int i=0; i<nr; i++) {
			for(int j=0; j<nc; j++) {
				board[i][j] = 2;
			}
		}		
	}	
	
	/**
	 * 
	 * @param c Numero della colonna
	 * @return Se c'è ancora posto nella c colonna
	 */
	public boolean isLegalMove(int c){
        return board[nr-1][c]==2;
    }
}
