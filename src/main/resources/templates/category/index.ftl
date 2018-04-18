<html>

<#include "../common/header.ftl">

<body>

<div id="wrapper" class="toggled">
<#--边栏sidebar-->
<#include "../common/nav.ftl">
<#--主要内容区域-->
    <div id="page-content-wrapper">

        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form role="form" method="post" action="/seller/category/save">
                        <div class="form-group">
                            <label>名字</label>
                            <input name="categoryName" value="${(category.categoryName)!''}" class="form-control" type="text"/>
                        </div>
                        <div class="form-group">
                            <label>类型编号</label>
                            <input name="categoryType" value="${(category.categoryType)!''}" class="form-control" type="number"/>
                        </div>

                        <input hidden type="text" name="categoryId" value="${(category.categoryId)!''}" >
                        <input type="submit" class="btn btn-default btn-info" value="保存">
                    </form>
                </div>
            </div>
        </div>

    </div>
</div>
</body>
</html>