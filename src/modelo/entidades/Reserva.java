package modelo.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {

	private Integer numQuarto;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
	
	public Reserva(Integer numQuarto, Date checkIn, Date checkOut) {
		this.numQuarto = numQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNumQuarto() {
		return numQuarto;
	}

	public void setNumQuarto(Integer numQuarto) {
		this.numQuarto = numQuarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duracao () { //digerença das duas datas em milisegundos.
		long dif = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS); //convertendo milisegundos para dias.
	}
	
	public String atualizacao (Date checkIn, Date checkOut) {
		Date agora = new Date();// Para testar se as datas são antes do momento atual.
		if (checkIn.before(agora) || checkOut.before(agora)) {
			return "Datas de reserva para atualização devem ser datas futuras";
		} 
		if (!checkOut.after(checkIn)) {
			return "A data do check-out deve ser após a data do check-in";
		} 
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null; // para indicar que não houve erro.
	}
	@Override
	public String toString () {
		return "Quarto: "
				+ numQuarto
				+ ", check-in: "
				+ sdf.format(checkIn)
				+ ", check-out: "
				+ sdf.format(checkOut)
				+ ", "
				+ duracao()
				+ " noites";
	}
	
}
