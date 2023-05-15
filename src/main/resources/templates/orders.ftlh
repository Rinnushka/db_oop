<#import "commons/app_page.ftlh" as p />

<@p.app_page "Записи">
  <div class="search-buttons-block flex-container row">
    <form method="post" action="/orders/filter">
      <div class="search-block flex-container row">
        <#if filter?? && filter?has_content>
          <input type="text" name="filter" autocomplete="off" placeholder="Поиск. Знак % для замены символов..." class="search-input" value="${filter}"/>
        <#else>
          <input type="text" name="filter" autocomplete="off"  placeholder="Поиск. Знак % для замены символов..." class="search-input"/>
        </#if>

        <div class="submit_wrapper">
          <input type="submit" id="submitButton" hidden value="send"/>
          <label for="submitButton">
										<span class="flex-container interface-color">
											<div class="button yellow-button margin-button">
												<img src="${baseUrl}/static/svg/search/free-icon-font-search-3917132.svg" width="20px" height="16px">
											</div>
										</span>
          </label>
        </div>
        <#if filter?? && filter?has_content>
          <div class="flex-container button-row">
            <a href="/orders/list" class="interface-color">
									<span class="flex-container">
										<div class="button red-button margin-button">
											<img src="${baseUrl}/static/svg/cross/free-icon-font-cross-3917188.svg" width="20px" height="16px">
										</div>
									</span>
            </a>
          </div>
        </#if>
      </div>
    </form>
    <div class="search-space"></div>
    <div class="flex-container buttons-block">
      <div class="flex-container button-row">
        <a href="/orders/create" class="interface-color">
									<span class="flex-container">
										<div class="button green-button margin-button">
											<img src="${baseUrl}/static/svg/add_user/free-icon-font-user-add-3917698.svg" width="24px" height="20px">
										</div>
									</span>
        </a>
      </div>
    </div>
  </div>
  <div class="table_block">
    <table>
      <tr>
        <th>Номер</th>
        <th>Дата</th>
        <th>Состав</th>
        <th>Нотариус</th>
        <th></th>
        <th></th>
      </tr>
        <#if orders?has_content>
            <#list orders as order>
              <tr>
                <td>${order.orderNumber}</td>
                <td>${order.orderDate}</td>
                <td>${order.contentOrder}</td>
                <td>${order.employee.lastName} ${order.employee.firstName} ${order.employee.secondName}</td>
                <td>
                  <a href="/orders/order/${order.id}" class="interface-color">
									<span class="flex-container">
										<div class="button yellow-button">
											<img src="${baseUrl}/static/svg/edit/free-icon-font-edit-3917361.svg" width="20px" height="16px">
										</div>
									</span>
                  </a>
                </td>
                <td>
                  <a href="/orders/order/${order.id}/delete" class="interface-color" target="_self" onclick="confirmDeleted(event)">
									<span class="flex-container">
										<div class="button red-button">
											<img src="${baseUrl}/static/svg/delete_user/free-icon-font-remove-user-3914336.svg" width="20px" height="16px">
										</div>
									</span>
                  </a>
                </td>
              </tr>
            </#list>
        </#if>
    </table>
  </div>
</@p.app_page>