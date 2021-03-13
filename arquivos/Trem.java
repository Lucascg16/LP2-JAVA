package arquivos;

public class Trem {

		private int numeroTrem;
		private String destino;
		private String turno;
		private String classe;
		

		public Trem (int numeroTrem, String destino, String turno, String classe) {
			this.numeroTrem = numeroTrem;
			this.destino = destino;
			this.turno = turno;
			this.classe = classe;
		}
		public int getNumeroTrem() {
			return numeroTrem;
		}
		public void setNumeroTrem(int numeroTrem) {
			this.numeroTrem = numeroTrem;
		}
		public String getDestino() {
			return destino;
		}
		public void setDestino(String destino) {
			this.destino = destino;
		}
		public String getTurno() {
			return turno;
		}
		public void setTurno(String turno) {
			this.turno = turno;
		}
		public String getClasse() {
			return classe;
		}
		public void setClasse(String classe) {
			this.classe = classe;
		}
	
		public String toString() {
			return this.numeroTrem + "\t"+this.destino + "\t" + this.turno + "\t" + this.classe+ "\n";
		}

	}

	
	
	
