<#import "parts/common.ftl" as c>

<@c.page>

<div class="form-row">
    <div class="form-group col-md-6">
        <form method="get" action="/sushiSet" class="form-inline">
            <input type="text" name="filter" class="form-control" value="${filter?ifExists}" placeholder="Search"/>

            <button type="submit" class="btn btn-primary ml-2" >Search</button>
        </form>
    </div>
</div>

<div class="card-columns">
    <#list sushiSet as sushiSetObj>
        <div class="card my-3" >


    <#if sushiSetObj.filename??>
        <img  src="/img/${sushiSetObj.filename}" class="card-img-top"/>
    </#if>
            <div class="m-2">
                <span>${sushiSetObj.name}</span>
                <b>${sushiSetObj.price}грн,</b>
                <i>${sushiSetObj.weight}г,</i><br/>
                <span>Количество: ${sushiSetObj.amountPiece}</span><br/>
                <i>(${sushiSetObj.consist})</i>






                <a href="/orders"> <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="@getbootstrap">Buy</button></a>



                <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Order</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>

                            <div class="modal-body">
                                <form>
                                    <div class="form-group">

                                        <label for="recipient-name" class="col-form-label">Address:</label>
                                        <input type="text" class="form-control" id="recipient-name1">
                                    </div>
                                    <div class="form-group">

                                        <label for="recipient-name" class="col-form-label">Phone:</label>
                                        <input type="text" class="form-control" id="recipient-name">
                                    </div>
                                    <div class="form-group">
                                        <label for="message-text" class="col-form-label">Additional message:</label>

                                        <textarea class="form-control" id="message-text">
                                        </textarea>
                                    </div>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                                <a href="/main"><button type="submit" class="btn btn-primary" >Create order</button></a>
                            </div>
                        </div>
                    </div>
                </div>









            </div>

        </div>

    <#else>
No sushiSet

    </#list>
</div>

</@c.page>