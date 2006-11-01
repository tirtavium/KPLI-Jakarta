package or.id.linux.jakarta.item;

import java.util.Date;

public class AgendaItem {
	private Date publishDate;
	private String publishDateString;
	private String judul;
	private String topik;
	private String tempat;
	private String tanggal;
	private String pukul;
	
	
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public String getPublishDateString() {
		return publishDateString;
	}
	public void setPublishDateString(String publishDateString) {
		this.publishDateString = publishDateString;
	}
	public String getJudul() {
		return judul;
	}
	public void setJudul(String judul) {
		this.judul = judul;
	}
	public String getTopik() {
		return topik;
	}
	public void setTopik(String topik) {
		this.topik = topik;
	}
	public String getTempat() {
		return tempat;
	}
	public void setTempat(String tempat) {
		this.tempat = tempat;
	}
	public String getTanggal() {
		return tanggal;
	}
	public void setTanggal(String tanggal) {
		this.tanggal = tanggal;
	}
	public String getPukul() {
		return pukul;
	}
	public void setPukul(String pukul) {
		this.pukul = pukul;
	}
	
	
	

}
