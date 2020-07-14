<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:select id="subCategoryId" path="item.subCategory.id"  items="${subCategoryList}"  itemValue="id"   itemLabel="name" cssClass="form-control input-sm">
</form:select>
