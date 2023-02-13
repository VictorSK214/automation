package core.data;

public enum CurrencySymbol {
  USD("$"),
  EUR("€");

  private final String currency;

  CurrencySymbol(String currency) {
    this.currency = currency;
  }

  public String getCurrency() {
    return currency;
  }
}