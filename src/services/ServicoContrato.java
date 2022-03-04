package services;

import java.util.Calendar;
import java.util.Date;

import entities.Contrato;
import entities.Parcela;

public class ServicoContrato {

	private OnlinePagamentoServico onlinePagamentoServico;
	
	public ServicoContrato(OnlinePagamentoServico onlinePagamentoServico) {
		this.onlinePagamentoServico = onlinePagamentoServico;
	}
	
	public void processoContrato(Contrato contrato, int months) {
		double basicQuota = contrato.getTotalValue() / months;
        for (int i = 1; i <= months; i++) {
            Date date = addMeses(contrato.getDate(), i);
            double updatedQuota = basicQuota + onlinePagamentoServico.interesse(basicQuota, i);
            double fullQuota =  updatedQuota + onlinePagamentoServico.taxaPagamento(updatedQuota);
            contrato.addParcela(new Parcela(date, fullQuota));
        }
	}
	
	private static Date addMeses(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}
}