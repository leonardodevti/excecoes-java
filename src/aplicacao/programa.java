package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import modelo.entidades.Reserva;
import modelo.excecoes.DominioExcecao;

/*Fazer um programa para ler os dados de uma reserva de hotel (n�mero do quarto, data
de entrada e data de sa�da) e mostrar os dados da reserva, inclusive sua dura��o em
dias. Em seguida, ler novas datas de entrada e sa�da, atualizar a reserva, e mostrar
novamente a reserva com os dados atualizados. O programa n�o deve aceitar dados
inv�lidos para a reserva, conforme as seguintes regras:
- Altera��es de reserva s� podem ocorrer para datas futuras
- A data de sa�da deve ser maior que a data de entrada
 * */


public class programa {

	public static void main(String[] args) { 

		Scanner ent = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("N�mero do quatrto: ");
			int numQuarto = ent.nextInt();
			System.out.print("Check-in data (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(ent.next());
			System.out.print("Check-out data (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(ent.next());
	
			Reserva reserva = new Reserva(numQuarto, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
	
			System.out.println();
			System.out.println("Informe os dados para atualizar a reserva: ");
			System.out.print("Check-in data (dd/MM/yyyy): ");
			checkIn = sdf.parse(ent.next());
			System.out.print("Check-out data (dd/MM/yyyy): ");
			checkOut = sdf.parse(ent.next());
	
			reserva.atualizacao(checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
		}
		catch (ParseException e) {
			System.out.println("Formato de data inv�lido");
		}
		
		catch (DominioExcecao e ) {
			System.out.println("Erro na reserva: "  + e.getMessage());
		}
		
		catch (RuntimeException e) {
			System.out.println("Erro inesperado");
		}
		
		
		ent.close();
	}

}
