<#import "parts/common.ftl" as c>

<@c.page>

    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
        <h4>Add new sushi</h4>
    </a>

    <div class="collapse" id="collapseExample">
        <div class="form-group mt-3">
            <form method="post" action="/main" enctype="multipart/form-data" >

                <div class="form-group">
                    <input type="text" name="name" class="form-control" placeholder="Введите название суши"/>
                </div>

                <div class="form-group">
                    <input type="text" name="price" class="form-control" placeholder="Введите цену суши"/>
                </div>

                <div class="form-group">
                    <input type="text" name="weight" class="form-control" placeholder="Введите вес суши"/>
                </div>

                <div class="form-group">
                    <input type="text" name="description" class="form-control" placeholder="Напишите описание"/>
                </div>


                <div class="form-group">
                    <div class="custom-file">
                        <input type="file" name="file" id="customFile">
                        <label class="custom-file-label" for="customFile">Choose file</label>
                    </div>
                </div>

                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <button type="submit" class="btn btn-primary ">Добавить</button>
            </form>
        </div>
    </div>



  <a class="btn btn-primary" data-toggle="collapse" mr="100" href="#collapseExample1" role="button" aria-expanded="false" aria-controls="collapseExample">
     <h4>Add new sushi of set</h4>
 </a>
  <div class="collapse" id="collapseExample1">
      <div class="form-group mt-3">
          <form method="post" action="/sushiSet" enctype="multipart/form-data" >

              <div class="form-group">
                  <input type="text" name="name" class="form-control" placeholder="Введите название суши-сета"/>
              </div>

              <div class="form-group">
                  <input type="text" name="price" class="form-control" placeholder="Введите цену сущи-сета"/>
              </div>

              <div class="form-group">
                  <input type="text" name="weight" class="form-control" placeholder="Введите вес суши-сета"/>
              </div>
              <div class="form-group">
                  <input type="text" name="amountPiece" class="form-control" placeholder="Введите количество кусочков суши-сета"/>
              </div>

              <div class="form-group">
                  <input type="text" name="consist" class="form-control" placeholder="Напишите состав суши-сета"/>
              </div>


              <div class="form-group">
                  <div class="custom-file">
                      <input type="file" name="file" id="customFile1">
                      <label class="custom-file-label" for="customFile1">Choose file</label>
                  </div>
              </div>

              <input type="hidden" name="_csrf" value="${_csrf.token}"/>
              <button type="submit" class="btn btn-primary ">Добавить</button>
          </form>
      </div>
  </div>




<#--
    <div class="card-columns">
        <#list order as orderObj>
            <div class="card my-3" >



                <div class="m-2">
                    <span>Адрес: ${orderObj.address}</span>
                    <b>Номер телефона: ${orderObj.phone}</b>
                    <i>Статус: Новый</i><br/>
                    <span>Дополнительное сообщение: ${orderObj.additional}</span><br/>

                </div>


            </div>
        </#list>
    </div>
-->





</@c.page>
