package arquivos;
public class RegAgenda {
	private String nome;
	private String end;
	private String tel;
	
	public RegAgenda (String nome, String end, String tel){
		this.nome = nome;
		this.end = end;
		this.tel = tel;
	}
	public String getNome (){
		return this.nome;
	}
	public String getEnd (){
		return this.end;
	}
	public String getTel (){
		return this.tel;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String toString() {
		return this.nome +"\t"+this.end+"\t"+this.tel+"\n";
	}

}

