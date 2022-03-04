package services;

public interface OnlinePagamentoServico {

	double taxaPagamento(double amount);
	double interesse(double amount, int months);
}