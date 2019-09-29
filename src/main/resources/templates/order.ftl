<#import "parts/common.ftl" as c>


<@c.page>
 <h1>Все заказы:</h1>
<div class="card-columns">

    <#list order as orderObj>
        <div class="card my-3">
            <div class="m-2">
                <span>Адрес: ${orderObj.address}</span><br/>
                <b>Номер телефона: ${orderObj.phone}</b><br/>
                <i>Статус: Новый</i><br/>
                <span>Дополнительное сообщение: ${orderObj.additional}</span><br/>

            </div>


        </div>
    </#list>
</div>

</@c.page>
