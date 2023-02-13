package core.helpers;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

public interface BrowserHelper<T> {
  @Step("Ожидать (миллисекунды)")
  default T waitFor(Long timeInMilliseconds) {
    Selenide.sleep(timeInMilliseconds);
    return (T) this;
  }

  @Step("Перезагрузить страницу")
  default T refreshPage() {
    Selenide.refresh();
    return (T) this;
  }
}