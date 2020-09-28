package com.testing.module2;

import java.math.BigDecimal;

//interfejs ma zdefiniowane zachowanie za pomocą dwóch metod
public interface VatProvider {

    //zwraca Vat domyślny, to mogłaby być wartość domyślna dla danego rynku
    BigDecimal getDefaultVat();

    //Vat dla konkretnego typu produktu
    BigDecimal getVatForType(String type);
}
