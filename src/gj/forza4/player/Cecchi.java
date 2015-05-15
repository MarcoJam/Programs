package gj.forza4.player;

/**
 * 
 * Progetto di Programmazione:
 * sviluppo di un giocatore di forza quattro
 * @author Cecchi, Galli, Rotini
 *
 */
public class Cecchi implements Player {
	
	Integer [][] field;
	int turn; // Serve il turno?

	public int move() {	
		if(turn<5){
			return 0;
		} else if (turn<11){
			return 1;
		} else if (turn<17) {
			return 2;
		} else {
			return 3;
		}
	}

	@Override
	public void start(int arg0, int arg1) {
		field = new Integer [arg0-1][arg1];
		turn = 0;
	}

	@Override
	public void tellMove(int arg0) {
		turn++;
	}
	
	/**
	 * Questo metodo inizializza il campo con valori null
	 * @param field Rappresenta il campo
	 * @param nr Numero righe
	 * @param nc Numero colonne
	 * @return field, il campo svuotato
	 */
	public int[][] inizialize (int[][] field, int nr, int nc) {
		for(int i=0; i<nc; i++) {
			for(int j=0; j<nr; j++) {
				field[i][j] = (Integer) null;
			}
		}
		return field;
	}
}
