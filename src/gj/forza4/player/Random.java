package gj.forza4.player;

/**
 * 
 * Progetto di Programmazione:
 * sviluppo di un giocatore di forza quattro
 * @author Cecchi, Galli, Rotini
 *
 */
public class Random implements Player {
	
	Integer [][] board;
	int nr, nc;

	/**
	 *  Metodo dell'interfaccia Player, il giocatore sceglie la propria mossa
	 */
	public int move() {
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
	 *  Metodo dell'interfaccia Player, dice al giocatore di iniziare la partita
	 */
	public void start(int arg0, int arg1) {
		nr = arg0;
		nc = arg1;
		board = new Integer [nr][nc];
	}

	/**
	 *  Metodo dell'interfaccia Player, riceve la mossa dell'avversario
	 */
	public void tellMove(int c) {
		fill(c,0);
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
			if(board[i][c]==null) {
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
		for(int i=0; i<nc; i++) {
			for(int j=0; j<nr; j++) {
				board[i][j] = null;
			}
		}		
	}
	
	/**
	 * 
	 * @param c Numero della colonna
	 * @return Se c'è ancora posto nella c colonna
	 */
	public boolean isLegalMove(int c){
        return board[nr-1][c]==null;
    }
}
