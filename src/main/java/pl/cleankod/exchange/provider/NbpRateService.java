package pl.cleankod.exchange.provider;

import org.springframework.cache.annotation.Cacheable;
import pl.cleankod.exchange.provider.nbp.ExchangeRatesNbpClient;
import pl.cleankod.exchange.provider.nbp.model.RateWrapper;

public class NbpRateService {

	private final ExchangeRatesNbpClient exchangeRatesNbpClient;

	public NbpRateService(ExchangeRatesNbpClient exchangeRatesNbpClient) {
		this.exchangeRatesNbpClient = exchangeRatesNbpClient;
	}

	@Cacheable(value = "nbpRates", key = "#currencyCode")
	public RateWrapper getRateWrapper(String table, String currencyCode) {
		return exchangeRatesNbpClient.fetch(table, currencyCode);
	}

}
