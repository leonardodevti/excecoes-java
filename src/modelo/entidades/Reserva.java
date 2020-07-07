package modelo.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import modelo.excecoes.DominioExcecao;

public class Reserva {

	private Integer numQuarto;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
	
	public Reserva(Integer numQuarto, Date checkIn, Date checkOut) {
		if (!checkOut.after(checkIn)) {
			throw new DominioExcecao("A data do check-out deve ser ap�s a data do check-in");
		} 
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
	
	public long duracao () { //diferen�a das duas datas em milisegundos.
		long dif = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS); //convertendo milisegundos para dias.
	}
	
	public void atualizacao (Date checkIn, Date checkOut) {
		Date agora = new Date();// Para testar se as datas est�o antes do momento atual.
		if (checkIn.before(agora) || checkOut.before(agora)) {
			throw new DominioExcecao("Datas de reserva para atualiza��o devem ser datas futuras");
		} 
		if (!checkOut.after(checkIn)) {//para testar se o checkOut est� numa data anterior a do checkIn.
			throw new DominioExcecao("A data do check-out deve ser ap�s a data do check-in");
		} 
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
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
