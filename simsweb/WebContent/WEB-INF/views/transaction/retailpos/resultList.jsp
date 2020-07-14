<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<table>
				<tr>
					<td>
						
						<div class="table-responsive" style="width: 70%; padding: 10px 0px 10px 10px;">
							<table class="table table-striped table-hover table-bordered table-responsive" style="font-size: 10px;">
								<tr style="font-weight: bold;">
									<td width="40px">No</td>
									<td width="500px">Description</td>
									<td width="100px">Brand</td>
									<td width="150px">Category</td>
									<td width="50px">SubCategory</td>
									<td width="50px">ItemCode</td>
									<td></td>
								</tr>
								<c:forEach items="${resultList}" var="model" varStatus = "row" >
									<tr height="30px">
										<td align="right"><c:out value="${row.count}"></c:out> </td>
										<td>${model.description}</td>
										<td>${model.brand.name}</td>
										<td>${model.category.name}</td>
										<td>${model.subCategory.name}</td>
										<td>${model.itemCode}</td>
										<td align="center"><input type="button" value="Select" onclick="saveSalesDetail('${model.itemCode}', document.getElementById('qtyId').value, document.getElementById('salesHeaderIdId').value);"></td>						
									</tr>
								</c:forEach>
							</table>						
						</div>
						
					</td>
					
				</tr>
			
</table>