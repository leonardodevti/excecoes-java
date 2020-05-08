package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import modelo.entidades.Reserva;

public class programa {

	public static void main(String[] args) throws ParseException { // propagando a exceção do parse no método main.

		Scanner ent = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Número do quatrto: ");
		int numQuarto = ent.nextInt();
		System.out.print("Check-in data (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(ent.next());
		System.out.print("Check-out data (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(ent.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva: A data do check-out deve ser após a data do check-in");
		} 
		else {
			Reserva reserva = new Reserva(numQuarto, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);

			System.out.println();
			System.out.println("Informe os dados para atualizar a reserva: ");
			System.out.print("Check-in data (dd/MM/yyyy): ");
			checkIn = sdf.parse(ent.next());
			System.out.print("Check-out data (dd/MM/yyyy): ");
			checkOut = sdf.parse(ent.next());

			Date agora = new Date();// Para testar se as datas são antes do momento atual.
			if (checkIn.before(agora) || checkOut.before(agora)) {
				System.out.println("Erro na reserva: Datas de reserva para atualização devem ser datas futuras");
			} 
			else if (!checkOut.after(checkIn)) {
				System.out.println("Erro na reserva: A data do check-out deve ser após a data do check-in");
			} 
			else {
				reserva.atualizacao(checkIn, checkOut);
				System.out.println("Reserva: " + reserva);
			}
		}
	}

}
