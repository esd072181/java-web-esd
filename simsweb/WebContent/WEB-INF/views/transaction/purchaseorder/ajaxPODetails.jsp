<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
			<c:if test="${poHeader.poDetailsList.size() > 0}">
					<!-- Total Amount -->	
					<div align="left" style="padding-left: 10px;">
						<div style="width: 60%;" align="right" >
							<label>Total Amount (Php):</label>
					    	<input type="text" style="width: 120px; color: blue; font-size: 15px; text-align: right; background-color: yellow; font-weight: bold;" value="<fmt:formatNumber type="currency" currencySymbol="" value="${totalAmount}"  maxFractionDigits="2"></fmt:formatNumber>" readonly="readonly" />						
						</div>
						<label>PO Items:</label>
						<span style="font-style: italic;"><a  id="reportId" href="./viewPOReport?poHeaderId=${poHeader.id}" >(Click here to view PO Report)</a></span>
					</div>
					<!-- PO Details Item -->					
					<div  align="center" class="table-responsive" style="width: 60%; padding-left: 10px;">
								<table class="table table-striped table-hover table-bordered table-responsive" style="font-size: 11px;">
									<tr style="font-weight: bold;">
										<td align="right">No</td>
										<td>Item</td>
										<td align="right">Qty</td>
										<td align="right">Price</td>
										<td align="right">Amount</td>
										<c:if test="${poHeader.status.id == 601}">
											<td width="50px;"></td>		
										</c:if>
									</tr>
									<!-- loop here -->
									<c:forEach items="${poHeader.poDetailsList}" var="model" varStatus = "row">
									    <tr>
									    	<td align="right">${row.count}</td>
											<td>${model.item.description}</td>
											<td align="right">${model.qty}</td>
											<td align="right"><fmt:formatNumber type="currency" currencySymbol="" value="${model.price}"  maxFractionDigits="2"></fmt:formatNumber></td>
											<td align="right"><fmt:formatNumber type="currency" currencySymbol="" value="${model.amount}"  maxFractionDigits="2"></fmt:formatNumber></td>
											<c:if test="${poHeader.status.id == 601}">
												<td align="center"><input type="button" value="Delete" onclick="deletePODetails(${poHeader.id},${model.id});"></td>		
											</c:if>
									    </tr>
									</c:forEach>
									
								</table>
					</div>
				</c:if>				