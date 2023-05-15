<#import "commons/app_page.ftlh" as p />

<@p.app_page "Приказ">

  <h4>Приказ</h4>

  <form method="post" action="/orders/order/${order.id}/update">
    <div class="flex-container column">
      <div class="text-input">
        <div class="flex-container column">
          <div class="input-title">
            Номер приказа
          </div>
          <input type="text" name="orderNumber" placeholder="Введите номер..." required autofocus autocomplete="off"
                 value="${order.orderNumber}">
        </div>
      </div>
      <div class="text-input">
        <div class="flex-container column">
          <div class="input-title">
            Краткое содержание
          </div>
          <input type="text" name="contentOrder" placeholder="Введите содержание..." required  autocomplete="off"
                 value="${order.contentOrder}">
        </div>
      </div>
      <div class="text-input">
        <div class="flex-container column">
          <div class="input-title">
            Кто издал
          </div>
          <input type="text" name="issuingAuthorityOrder" placeholder="Введите издателя..." required autocomplete="off"
                 value="${order.issuingAuthorityOrder}">
        </div>
      </div>
      <div class="text-input">
        <div class="flex-container column">
          <div class="input-title">
            Кто издал
          </div>
          <input type="date" name="orderDate" placeholder="Введите дату окончания..." required autocomplete="off"
                 value="${order.orderDate}">
        </div>
      </div>
      <div class="text-input">
        <div class="flex-container column">
          <div class="input-title">
            Нотариус
          </div>
          <select name="employee.id">
            <#list employees as empl>
              <option value="${empl.id}" ${(empl.id == order.employee.id)?then('selected', '')}
              >${empl.lastName} ${empl.firstName} ${empl.secondName}
              </option>
            </#list>
          </select>
        </div>
      </div>

      <div class="table-buttons-block flex-container row">
        <div class="buttons-space">
        </div>
        <div class="flex-container buttons-block">
          <div class="flex-container button-row margin-button">
            <a href="/orders/list" class="interface-color">
										<span class="flex-container">
											<div class="yellow-button text-button">
												Записи
											</div>
										</span>
            </a>
          </div>
          <div class="flex-container button-row margin-button">
            <input type="submit" id="submitButton" class="interface-color green-button text-button" value="Сохранить"/>
          </div>
        </div>
      </div>
    </div>
  </form>

</@p.app_page>