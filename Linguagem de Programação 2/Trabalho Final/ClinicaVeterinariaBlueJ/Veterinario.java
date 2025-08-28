public class Veterinario{
	 
private String nome;
private String cpf;
private String email;
private String telefoneContato;
private String especialidade;
private int cfmv;

	public Veterinario(String nome, String cpf, String email, String telefoneContato, String especialidade, int cfmv) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefoneContato = telefoneContato;
		this.especialidade = especialidade;
		this.cfmv = cfmv;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTelefoneContato() {
		return telefoneContato;
	}
	
	public void setTelefoneContato(String telefoneContato) {
		this.telefoneContato = telefoneContato;
	}
	
	public String getEspecialidade() {
		return especialidade;
	}
	
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	
	public int getCfmv() {
		return cfmv;
	}
	
	public void setCfmv(int cfmv) {
		this.cfmv = cfmv;
	}
}
