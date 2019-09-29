<#import "parts/common.ftl" as c>


<@c.page>

 <a class="btn btn-primary" data-toggle="collapse" mr="100" href="#collapseExample2" role="button" aria-expanded="false" aria-controls="collapseExample">
     <h4>Create order</h4>
 </a>
<div class="collapse" id="collapseExample2">
    <div class="form-group mt-3">
        <form method="post" action="/order" enctype="multipart/form-data" >

            <div class="form-group">
                <input type="text" name="address" class="form-control" placeholder="Адрес"/>
            </div>

            <div class="form-group">
                <input type="text" name="phone" class="form-control" placeholder="Номер телефона"/>
            </div>

            <div class="form-group">
                <input type="text" name="additional" class="form-control" placeholder="Дополнительное сообщение"/>
            </div>




            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button type="submit" class="btn btn-primary ">Оформить заказ</button>
        </form>
    </div>
</div>




</@c.page>