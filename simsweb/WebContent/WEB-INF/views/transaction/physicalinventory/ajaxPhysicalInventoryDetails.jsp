<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
				<c:if test="${isSuccess == true}">
					<label style="font-size: 11px; font-style: italic; color: blue; padding-left: 10px;">Item successfully updated!</label>	
				</c:if>
				<c:if test="${physicalInventory.piDetailsList.size() > 0}">
					<!-- Physical Inventory Details Item -->					
					<div  align="center" class="table-responsive" style="width: 70%; padding-left: 9px;">
								<table class="table table-striped table-hover table-bordered table-responsive" style="font-size: 9px;">
									<tr style="font-weight: bold;">
										<td align="right">No</td>
										<td>Item</td>
										<td align="right">System Qty</td>
										<td align="right">Physical Count</td>
										<td align="right">QtyVariance</td>
										<td>Variance</td>	
									</tr>
									<!-- loop here -->
									<c:forEach items="${physicalInventory.piDetailsList}" var="model" varStatus = "row">
									    <tr>
									    	<td align="right">${row.count}</td>
											<td>${model.item.description}</td>
											<td align="right">${model.systemQty}</td>
											<td align="right">${model.physicalCount}</td>
											<td align="right">${model.qtyVariance}</td>
											<td>${model.variance}</td>		
									    </tr>
									</c:forEach>
									
								</table>
					</div>
				</c:if>		
		