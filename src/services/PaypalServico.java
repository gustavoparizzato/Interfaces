package services;

public class PaypalServico implements OnlinePagamentoServico {

	private static final double PORCENTAGEM_TAXA = 0.02;
	private static final double INTERESSE_MESES = 0.01;

	@Override
	public double taxaPagamento(double amount) {
		return amount * PORCENTAGEM_TAXA;
	}

	@Override
	public double interesse(double amount, int months) {
		return amount * INTERESSE_MESES * months;
	}
}