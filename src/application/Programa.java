package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Contrato;
import entities.Parcela;
import services.PaypalServico;
import services.ServicoContrato;

public class Programa {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("\n*************************Insira os dados do contrato: *************************\n");
		System.out.print("Número: ");
		int number = sc.nextInt();
		System.out.print("Data (dd/MM/yyyy): ");
		Date date = sdf.parse(sc.next());
		System.out.print("Valor de contrato: ");
		double totalValue = sc.nextDouble();
		
		Contrato contrato = new Contrato(number, date, totalValue);
		
		System.out.print("Entre com o número de parcelas: ");
		int n = sc.nextInt();
		
		ServicoContrato servicoContrato = new ServicoContrato(new PaypalServico());
		
		servicoContrato.processoContrato(contrato, n);
		
		System.out.println("\nParcelas:");
		for (Parcela x : contrato.getParcelas()) {
			System.out.println(x);
		}
		
		sc.close();
	}
}