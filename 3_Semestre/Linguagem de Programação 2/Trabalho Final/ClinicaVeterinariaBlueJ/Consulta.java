import java.util.Date;

public class Consulta{

	private Veterinario veterinario;
	private Date date;
	private String hora;
	
	public Consulta(Veterinario veterinario, Date date, String hora) {
		this.veterinario = veterinario;
		this.date = date;
		this.hora = hora;
	}
	public Veterinario getVeterinario() {
		return veterinario;
	}
	public void setVeterinario(Veterinario veterinario) {
		this.veterinario = veterinario;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	
}
