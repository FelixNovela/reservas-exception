package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservas;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Numero do quarto: ");
		int numero = sc.nextInt();

		System.out.print("Data de check-in (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());

		System.out.print("Data de check-out (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva: data de check-out deve ser posterior a data de check-in");
		} 
		else {
			Reservas reserva = new Reservas(numero, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);

			System.out.println();
			System.out.println("Insira os dados para atualizar a reserva");

			System.out.print("Data de check-in (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());

			System.out.print("Data de check-out (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());

			String error = reserva.atualizarReserva(checkIn, checkOut);
			if (error != null) {
				System.out.println(error);
			} 
			else {
				System.out.println("Reserva: " + reserva);
			}
		}

		sc.close();
	}

}
