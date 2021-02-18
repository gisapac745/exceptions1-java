package model.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");

		System.out.println("Entre com os dados da reserva:");

		System.out.println("Número do quarto:");
		int numQuarto = sc.nextInt();
		System.out.println("Data de checkin:");
		Date dtCheckIn = sdf.parse(sc.next());
		System.out.println("Data de checkout:");
		Date dtCheckOut = sdf.parse(sc.next());

		// a data de check out deve ser posterior a data de check in
		if (!dtCheckOut.after(dtCheckIn)) {
			System.out.println("Erro na reserva. A data de check out deve ser maior que a data de check in");
		} else {
			Reserva reserva = new Reserva(numQuarto, dtCheckIn, dtCheckOut);
			System.out.println(reserva);

			System.out.println();
			System.out.println("Entre com os dados da atualização da reserva:");
			System.out.println("Data de atualização de checkin:");
			dtCheckIn = sdf.parse(sc.next());
			System.out.println("Data de atualização de checkOUt:");
			dtCheckOut = sdf.parse(sc.next());

			Date agora = new Date();

			// a data de check out deve ser posterior a data de check in
			if (dtCheckIn.before(agora) || dtCheckOut.before(agora)) {
				System.out.println(
						"Erro na reserva. As datas de atualização da reserva só podem ser feitas em datas futuras.");
			} else if (!dtCheckOut.after(dtCheckIn)) {
				System.out.println("Erro na reserva. A data de check out deve ser maior que a data de check in");
			} else {

				reserva.atualizaData(dtCheckIn, dtCheckOut);
				System.out.println(reserva);

			}

		}

		sc.close();

	}

}
