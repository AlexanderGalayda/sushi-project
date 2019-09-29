<#import "parts/common.ftl" as c>
<@c.page>

<div class="form-row">
    <div class="form-group col-md-6">
        <form method="get" action="/main" class="form-inline">
            <input type="text" name="filter" class="form-control" value="${filter?ifExists}" placeholder="Search"/>

         <button type="submit" class="btn btn-primary ml-2" >Search</button>
        </form>
    </div>
</div>
<div class="card-columns">
    <#list sushi as sushiObj>
        <div class="card my-3" >
    <#if sushiObj.filename??>
        <img  src="/img/${sushiObj.filename}" class="card-img-top"/>
    </#if>
            <div class="m-2">
                <span>${sushiObj.name}</span>
                <b>${sushiObj.price}грн,</b>
                <i>${sushiObj.weight}г.</i><br/>
                <i>(${sushiObj.description})</i>
                <a href="/orders"><button type="button"  class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="@getbootstrap">Buy</button></a>
            </div>
        </div>
    <#else>
No sushi
    </#list>
</div>
</@c.page>
