<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>SIMS</title>
	<script>
		function goToRetailPOS() {
			window.location.href = "./goToRetailPOS";
		}
		function goToSearchPO() {
			window.location.href = "./goToSearchPO";
		}
		function goToSearchPOInRO() {
			window.location.href = "./goToSearchPOInRO";
		}
		function goToSearchPhysicalInventory() {
			window.location.href = "./goToSearchPhysicalInventory";
		}
		function goToSearchItem() {
			window.location.href = "./goToSearchItem";
		}
		function goToSearchEmployee() {
			window.location.href = "./goToSearchEmployee";
		}
		function goToSearchCategory() {
			window.location.href = "./goToSearchCategory";
		}
		function goToSearchSubCategory() {
			window.location.href = "./goToSearchSubCategory";
		}
		function goToSearchBrand() {
			window.location.href = "./goToSearchBrand";
		}
		function goToSearchSupplier() {
			window.location.href = "./goToSearchSupplier";
		}
		function goToSearchUserAccount() {
			window.location.href = "./goToSearchUserAccount";
		}
	</script>
</head>
<body>

	<div style="width: 100%" align="center">
	
		<jsp:include page="header.jsp"></jsp:include>
		
		<div>
			<h1>Sales and Inventory Management System</h1>
		</div>
	
		<table>
			<tr>
				<td colspan="7" align="center"><h4>Transaction</h4></td>
			</tr>
			<tr>
				<td align="center">
					<img onclick="goToRetailPOS();" src="resources/img/consult01.png" alt="Retail POS" height="100" width="100">	
				</td>
				<td width="40px"></td>
				<td align="center">
					<img onclick="goToSearchPO();" src="resources/img/browse_consult01.jpg" alt="Purchase Order" height="100" width="100">
				</td>
				<td width="40px"></td>
				<td align="center">
					<img onclick="goToSearchPOInRO();" src="resources/img/browse_consult01.jpg" alt="Receive Order" height="100" width="100">
				</td>
				<td width="40px"></td>
				<td align="center">
					<img onclick="goToSearchPhysicalInventory();" src="resources/img/browse_consult01.jpg" alt="Physical Inventory" height="100" width="100">
				</td>
			</tr>
			<tr>
				<td align="center"><a href="./goToRetailPOS">Retail POS</a></td>
				<td width="30px"></td>
				<td align="center"><a href="./goToSearchPO">Purchase Order</a></td>
				<td width="30px"></td>
				<td align="center"><a href="./goToSearchPOInRO">Receive Order</a></td>		
				<td width="30px"></td>
				<td align="center"><a href="./goToSearchPhysicalInventory">Physical Inventory</a></td>		
			</tr>
		</table> 
		<br>

		<table>
				<tr>
					<c:choose>
						<c:when test="${roleid == 501}">
							<td colspan="14" align="center"><h4>Master File</h4></td>					
						</c:when>
						<c:otherwise>
							<td colspan="12" align="center"><h4>Master File</h4></td>
						</c:otherwise>
					</c:choose>
				</tr>
				<tr>
					<td align="center">
						<img onclick="goToSearchItem();" src="resources/img/patient_reg.png" alt="Item Master File" height="100" width="100">	
					</td>
					<td width="50px"></td>
					<td align="center">
						<img onclick="goToSearchEmployee();" src="resources/img/prof03.jpg" alt="Employee Master File" height="100" width="100">	
					</td>	
					<td width="50px"></td>
					<td align="center">
						<img onclick="goToSearchCategory();" src="resources/img/med05.png" alt="Category Master File" height="100" width="100">	
					</td>
					<td width="50px"></td>
					<td align="center">
						<img onclick="goToSearchSubCategory();" src="resources/img/med05.png" alt="SubCategory Master File" height="100" width="100">	
					</td>		
					<td width="50px"></td>
					<td align="center">
						<img onclick="goToSearchBrand();" src="resources/img/lab01.png" alt="Brand Master File" height="100" width="100">	
					</td>
					<td width="50px"></td>
					<td align="center">
						<img onclick="goToSearchSupplier();" src="resources/img/lab01.png" alt="Supplier Master File" height="100" width="100">	
					</td>
					<!-- Below for Admin only -->
					<c:if test="${roleid == 501}">
						<td width="50px"></td>
						<td align="center">
							<img onclick="goToSearchUserAccount();" src="resources/img/login.jpg" alt="User Account Master File" height="100" width="100">	
						</td>						
					</c:if>
				</tr>
				<tr>
					<td align="center"><a href="./goToSearchItem">Item</a></td>
					<td width="30px"></td>
					<td align="center"><a href="./goToSearchEmployee">Employee</a></td>	
					<td width="30px"></td>
					<td align="center"><a href="./goToSearchCategory">Category</a></td>	
					<td width="30px"></td>
					<td align="center"><a href="./goToSearchCategory">SubCategory</a></td>	
					<td width="30px"></td>
					<td align="center"><a href="./goToSearchBrand">Brand</a></td>
					<td width="30px"></td>
					<td align="center"><a href="./goToSearchSupplier">Supplier</a></td>
					<c:if test="${roleid == 501}">
						<td width="30px"></td>
						<td align="center"><a href="./goToSearchUserAccount">User Account</a></td>						
					</c:if>	
				</tr>
		</table>
	</div>
	
</body>
</html>