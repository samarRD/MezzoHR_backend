package mezzo.back_end.Response;

import java.util.Date;


public class CongeResponse {
	private Long id;
	private Date date_debut;
	private Date date_fin ;
	private String typeconge ;
	private Boolean notifier ;
	private Boolean status ;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}
	public Date getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}
	public String getTypeconge() {
		return typeconge;
	}
	public void setTypeconge(String typeconge) {
		this.typeconge = typeconge;
	}
	public Boolean getNotifier() {
		return notifier;
	}
	public void setNotifier(Boolean notifier) {
		this.notifier = notifier;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}

	
}
