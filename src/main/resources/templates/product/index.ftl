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
                    <form role="form" method="post" action="/seller/product/save">
                        <div class="form-group">
                            <label>名称</label>
                            <input name="productName" value="${(productInfo.productName)!''}" class="form-control" type="text"/>
                        </div>
                        <div class="form-group">
                            <label>价格</label>
                            <input name="productPrice" value="${(productInfo.productPrice)!''}" class="form-control" type="text"/>
                        </div>
                        <div class="form-group">
                            <label>库存</label>
                            <input name="productStock" value="${(productInfo.productStock)!''}" class="form-control" type="number"/>
                        </div>
                        <div class="form-group">
                            <label>描述</label>
                            <input name="productDescription" value="${(productInfo.productDescription)!''}" class="form-control" type="text"/>
                        </div>
                        <div class="form-group">
                            <label>图片</label>
                            <img src="${(productInfo.productIcon)!''}" width="100px" height="100px">
                            <input name="productIcon" value="${(productInfo.productIcon)!''}" class="form-control" type="text"/>
                        </div>
                        <div class="form-group">
                            <label>类目</label>
                            <select name="categoryType" class="form-control">
                                <#list categoryList as category>
                                    <option value="${category.categoryType}"
                                        <#if (productInfo.categoryType)?? && productInfo.categoryType == category.categoryType >
                                            selected
                                        </#if>
                                            >
                                        ${category.categoryName}
                                    </option>
                                </#list>
                            </select>
                        </div>
                        <input hidden type="text" name="productId" value="${(productInfo.productId)!''}" >
                        <input type="submit" class="btn btn-default btn-info" value="保存">
                    </form>
                </div>
            </div>
        </div>

    </div>
</div>
</body>
</html>