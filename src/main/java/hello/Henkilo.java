package hello;

public class Henkilo {
	private Integer henkiloid;
	private String etunimi;
	private String sukunimi;
	
	public String getEtunimi() {
		return etunimi;
	}
	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}
	public String getSukunimi() {
		return sukunimi;
	}
	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}
	public Integer getHenkiloid() {
		return henkiloid;
	}
	public void setHenkiloid(Integer henkiloid) {
		this.henkiloid = henkiloid;
	}
	
}