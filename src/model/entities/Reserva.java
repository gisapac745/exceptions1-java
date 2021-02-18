package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {

	private int numQuarto;
	private Date checkin;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
	
	public Reserva() {
		
	}

	public Reserva(int numQuarto, Date checkin, Date checkOut) {
		this.numQuarto = numQuarto;
		this.checkin = checkin;
		this.checkOut = checkOut;
	}

	public int getNumQuarto() {
		return numQuarto;
	}

	public void setNumQuarto(int numQuarto) {
		this.numQuarto = numQuarto;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckOut() {
		return checkOut;
	}
	
	@Override
	public String toString() {
		return "Reserva [numQuarto=" + numQuarto + ", checkin=" + sdf.format(checkin) + ", checkOut=" + sdf.format(checkOut) 
		+ ", duração: "
		+ duracao()	+ " noites ]";
	}
	
	public long duracao() {
		
		// pega a diferença entre as datas em milisegundos
		long diff = checkOut.getTime() - checkin.getTime();
		
		// converter dos milisegundos para dias
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		
		
	}
	
	public void atualizaData (Date checkin, Date checkout) {
		this.checkin = checkin;
		this.checkOut = checkout;
		
	}
	
	
}
