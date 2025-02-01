package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservas {

	private Integer numeroDoQuarto;
	private Date checkIn;
	private Date checkOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public Reservas() {

	}

	public Reservas(Integer numeroDoQuarto, Date checkIn, Date checkOut) {
		this.numeroDoQuarto = numeroDoQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNumeroDoQuarto() {
		return numeroDoQuarto;
	}

	public void setNumeroDoQuarto(Integer numeroDoQuarto) {
		this.numeroDoQuarto = numeroDoQuarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duracao() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public String atualizarReserva(Date checkIn, Date checkOut) {
		Date agora = new Date();
		
		if(checkIn.before(agora) || checkOut.before(agora)) {
			return "Erro na reserva: Datas da atualizacao da reserva devem ser posterios a data de hoje ";
		}
		if(!checkOut.after(checkIn)) {
			return"Erro na reserva: data de check-out deve ser posterior a data de check-in";
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut; 
		return null;
	}
	

	@Override
	public String toString() {
		return "Quarto "
				+ numeroDoQuarto
				+ ", check-in: "
				+ sdf.format(this.checkIn)
				+ ", check-out "
				+ sdf.format(checkOut)
				+ " "
				+duracao()
				+ " noites"; 
	}

}
