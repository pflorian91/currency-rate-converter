package pl.cleankod.exchange.provider.nbp;

import feign.Param;
import feign.RequestLine;
import pl.cleankod.exchange.provider.nbp.model.RateWrapper;

public interface ExchangeRatesNbpClient {
    @RequestLine("GET /exchangerates/rates/{table}/{currency}/2022-02-08")
    RateWrapper fetch(@Param("table") String table, @Param("currency") String currency);
}

//  a ramas sa fac cache la aceste call-uri
// hai sa facem enable debug la toate call-urile sa vedem ca nu se mai fac dupa ce pun cacheul..