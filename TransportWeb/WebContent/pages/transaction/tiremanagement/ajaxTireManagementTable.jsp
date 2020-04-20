<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<script>
$(function() {
	//onload set the tire details color
	$('#colorRowFLId').addClass('${tireManagementForm.modelView.colorFL}');
	$('#colorRowFRId').addClass('${tireManagementForm.modelView.colorFR}');
	$('#colorRowDLOId').addClass('${tireManagementForm.modelView.colorDLO}');
	$('#colorRowDLIId').addClass('${tireManagementForm.modelView.colorDLI}');
	$('#colorRowR2Id').addClass('${tireManagementForm.modelView.colorR2}');
	$('#colorRowDRIId').addClass('${tireManagementForm.modelView.colorDRI}');
	$('#colorRowDROId').addClass('${tireManagementForm.modelView.colorDRO}');
	$('#colorRowRLOId').addClass('${tireManagementForm.modelView.colorRLO}');
	$('#colorRowRLIId').addClass('${tireManagementForm.modelView.colorRLI}');
	$('#colorRowRRIId').addClass('${tireManagementForm.modelView.colorRRI}');
	$('#colorRowRROId').addClass('${tireManagementForm.modelView.colorRRO}');
	$('#colorRowFLOId').addClass('${tireManagementForm.modelView.colorFLO}');
	$('#colorRowFLIId').addClass('${tireManagementForm.modelView.colorFLI}');
	$('#colorRowFRIId').addClass('${tireManagementForm.modelView.colorFRI}');
	$('#colorRowFROId').addClass('${tireManagementForm.modelView.colorFRO}');
	$('#colorRowSLOId').addClass('${tireManagementForm.modelView.colorSLO}');
	$('#colorRowSLIId').addClass('${tireManagementForm.modelView.colorSLI}');
	$('#colorRowSRIId').addClass('${tireManagementForm.modelView.colorSRI}');
	$('#colorRowSROId').addClass('${tireManagementForm.modelView.colorSRO}');
	$('#colorRowTLOId').addClass('${tireManagementForm.modelView.colorTLO}');
	$('#colorRowTLIId').addClass('${tireManagementForm.modelView.colorTLI}');
	$('#colorRowRId').addClass('${tireManagementForm.modelView.colorR}');
	$('#colorRowTRIId').addClass('${tireManagementForm.modelView.colorTRI}');
	$('#colorRowTROId').addClass('${tireManagementForm.modelView.colorTRO}');

});

</script>

<div class="table-responsive" style="padding-left: 10px;">

	<div style="padding-left: 20px;">
		
		<table>
			<tr>
				<td>
					<table class="tblCss">
							<tr>
								<td class="threadRow" align="center">${tireManagementForm.modelView.thread1FL}&nbsp;&nbsp;${tireManagementForm.modelView.thread2FL}&nbsp;&nbsp;${tireManagementForm.modelView.thread3FL}</td>
								<td width="10px;"></td>
								<td class="spaceBox"></td>
								<td width="40px;"></td>
								<td class="spaceBox"></td>
								<td width="40px;"></td>
								<td class="spaceBox"></td>
								<td width="10px;"></td>
								<td class="threadRow" align="center">${tireManagementForm.modelView.thread1FR}&nbsp;&nbsp;${tireManagementForm.modelView.thread2FR}&nbsp;&nbsp;${tireManagementForm.modelView.thread3FR}</td>
							</tr>
							<tr>
								<td id="colorRowFLId" class="colorRow" valign="middle" align="center" onclick="selectWheelPosition('FL');">FL</td>
								<td width="10px;"></td>
								<td class="spaceBox"></td>
								<td width="40px;"></td>
								<td class="spaceBox"></td>
								<td width="40px;"></td>
								<td class="spaceBox"></td>
								<td width="10px;"></td>
								<td id="colorRowFRId" class="colorRow" valign="middle" align="center" onclick="selectWheelPosition('FR');">FR</td>
							</tr>
							<tr>
								<td class="serialNoRow" align="center"><label id="lblSerialNoIdFL">${tireManagementForm.modelView.serialNoFL}</label></td>
								<td width="10px;"></td>
								<td class="spaceBox"></td>
								<td width="40px;"></td>
								<td class="spaceBox"></td>
								<td width="40px;"></td>
								<td class="spaceBox"></td>
								<td width="10px;"></td>
								<td class="serialNoRow" align="center"><label id="lblSerialNoIdFR" >${tireManagementForm.modelView.serialNoFR}</label></td>
							</tr>
							<tr height="20px;"></tr>
							<tr>
								<td class="threadRow" align="center">${tireManagementForm.modelView.thread1DLO}&nbsp;&nbsp;${tireManagementForm.modelView.thread2DLO}&nbsp;&nbsp;${tireManagementForm.modelView.thread3DLO}</td>
								<td width="10px;"></td>
								<td class="threadRow" align="center">${tireManagementForm.modelView.thread1DLI}&nbsp;&nbsp;${tireManagementForm.modelView.thread2DLI}&nbsp;&nbsp;${tireManagementForm.modelView.thread3DLI}</td>
								<td width="40px;"></td>
								<td class="threadRow" align="center">${tireManagementForm.modelView.thread1R2}&nbsp;&nbsp;${tireManagementForm.modelView.thread2R2}&nbsp;&nbsp;${tireManagementForm.modelView.thread3R2}</td>
								<td width="40px;"></td>
								<td class="threadRow" align="center">${tireManagementForm.modelView.thread1DRI}&nbsp;&nbsp;${tireManagementForm.modelView.thread2DRI}&nbsp;&nbsp;${tireManagementForm.modelView.thread3DRI}</td>
								<td width="10px;"></td>
								<td class="threadRow" align="center">${tireManagementForm.modelView.thread1DRO}&nbsp;&nbsp;${tireManagementForm.modelView.thread2DRO}&nbsp;&nbsp;${tireManagementForm.modelView.thread3DRO}</td>
							</tr>
							<tr>
								<td id="colorRowDLOId" class="colorRow" valign="middle" align="center" onclick="selectWheelPosition('DLO');">DLO</td>
								<td width="10px;"></td>
								<td id="colorRowDLIId" class="colorRow" valign="middle" align="center" onclick="selectWheelPosition('DLI');">DLI</td>
								<td width="40px;"></td>
								<td id="colorRowR2Id" class="colorRow" valign="middle" align="center" onclick="selectWheelPosition('R2');">R2</td>
								<td width="40px;"></td>
								<td id="colorRowDRIId" class="colorRow" valign="middle" align="center" onclick="selectWheelPosition('DRI');">DRI</td>
								<td width="10px;"></td>
								<td id="colorRowDROId" class="colorRow" valign="middle" align="center" onclick="selectWheelPosition('DRO');">DRO</td>
							</tr>
							<tr>
								<td class="serialNoRow" align="center"><label id="lblSerialNoIdDLO">${tireManagementForm.modelView.serialNoDLO}</label></td>
								<td width="10px;"></td>
								<td class="serialNoRow" align="center"><label id="lblSerialNoIdDLI">${tireManagementForm.modelView.serialNoDLI}</label></td>
								<td width="40px;"></td>
								<td class="serialNoRow" align="center"><label id="lblSerialNoIdR2">${tireManagementForm.modelView.serialNoR2}</label></td>
								<td width="40px;"></td>
								<td class="serialNoRow" align="center"><label id="lblSerialNoIdDRI">${tireManagementForm.modelView.serialNoDRI}</label></td>
								<td width="10px;"></td>
								<td class="serialNoRow" align="center"><label id="lblSerialNoIdDRO">${tireManagementForm.modelView.serialNoDRO}</label></td>
							</tr>
							<tr height="20px;"></tr>
							<tr>
								<td class="threadRow" align="center">${tireManagementForm.modelView.thread1RLO}&nbsp;&nbsp;${tireManagementForm.modelView.thread2RLO}&nbsp;&nbsp;${tireManagementForm.modelView.thread3RLO}</td>
								<td width="10px;"></td>
								<td class="threadRow" align="center">${tireManagementForm.modelView.thread1RLI}&nbsp;&nbsp;${tireManagementForm.modelView.thread2RLI}&nbsp;&nbsp;${tireManagementForm.modelView.thread3RLI}</td>
								<td width="40px;"></td>
								<td class="spaceBox"></td>
								<td width="40px;"></td>
								<td class="threadRow" align="center">${tireManagementForm.modelView.thread1RRI}&nbsp;&nbsp;${tireManagementForm.modelView.thread2RRI}&nbsp;&nbsp;${tireManagementForm.modelView.thread3RRI}</td>
								<td width="10px;"></td>
								<td class="threadRow" align="center">${tireManagementForm.modelView.thread1RRO}&nbsp;&nbsp;${tireManagementForm.modelView.thread2RRO}&nbsp;&nbsp;${tireManagementForm.modelView.thread3RRO}</td>
							</tr>
							<tr>
								<td id="colorRowRLOId" class="colorRow" valign="middle" align="center" onclick="selectWheelPosition('RLO');">RLO</td>
								<td width="10px;"></td>
								<td id="colorRowRLIId" class="colorRow" valign="middle" align="center" onclick="selectWheelPosition('RLI');">RLI</td>
								<td width="40px;"></td>
								<td class="spaceBox"></td>
								<td width="40px;"></td>
								<td id="colorRowRRIId" class="colorRow" valign="middle" align="center" onclick="selectWheelPosition('RRI');">RRI</td>
								<td width="10px;"></td>
								<td id="colorRowRROId" class="colorRow" valign="middle" align="center" onclick="selectWheelPosition('RRO');">RRO</td>
							</tr>
							<tr>
								<td class="serialNoRow" align="center"><label id="lblSerialNoIdRLO">${tireManagementForm.modelView.serialNoRLO}</label></td>
								<td width="10px;"></td>
								<td class="serialNoRow" align="center"><label id="lblSerialNoIdRLI">${tireManagementForm.modelView.serialNoRLI}</label></td>
								<td width="40px;"></td>
								<td class="spaceBox"></td>
								<td width="40px;"></td>
								<td class="serialNoRow" align="center"><label id="lblSerialNoIdRRI">${tireManagementForm.modelView.serialNoRRI}</label></td>
								<td width="10px;"></td>
								<td class="serialNoRow" align="center"><label id="lblSerialNoIdRRO">${tireManagementForm.modelView.serialNoRRO}</label></td>
							</tr>
							<tr height="20px;"></tr>
							<tr>
								<td class="threadRow" align="center">${tireManagementForm.modelView.thread1FLO}&nbsp;&nbsp;${tireManagementForm.modelView.thread2FLO}&nbsp;&nbsp;${tireManagementForm.modelView.thread3FLO}</td>
								<td width="10px;"></td>
								<td class="threadRow" align="center">${tireManagementForm.modelView.thread1FLI}&nbsp;&nbsp;${tireManagementForm.modelView.thread2FLI}&nbsp;&nbsp;${tireManagementForm.modelView.thread3FLI}</td>
								<td width="40px;"></td>
								<td class="spaceBox"></td>
								<td width="40px;"></td>
								<td class="threadRow" align="center">${tireManagementForm.modelView.thread1FRI}&nbsp;&nbsp;${tireManagementForm.modelView.thread2FRI}&nbsp;&nbsp;${tireManagementForm.modelView.thread3FRI}</td>
								<td width="10px;"></td>
								<td class="threadRow" align="center">${tireManagementForm.modelView.thread1FRO}&nbsp;&nbsp;${tireManagementForm.modelView.thread2FRO}&nbsp;&nbsp;${tireManagementForm.modelView.thread3FRO}</td>
							</tr>
							<tr>
								<td id="colorRowFLOId" class="colorRow" valign="middle" align="center" onclick="selectWheelPosition('FLO');">FLO</td>
								<td width="10px;"></td>
								<td id="colorRowFLIId" class="colorRow" valign="middle" align="center" onclick="selectWheelPosition('FLI');">FLI</td>
								<td width="40px;"></td>
								<td class="spaceBox"></td>
								<td width="40px;"></td>
								<td id="colorRowFRIId" class="colorRow" valign="middle" align="center" onclick="selectWheelPosition('FRI');">FRI</td>
								<td width="10px;"></td>
								<td id="colorRowFROId" class="colorRow" valign="middle" align="center" onclick="selectWheelPosition('FRO');">FRO</td>
							</tr>
							<tr>
								<td class="serialNoRow" align="center"><label id="lblSerialNoIdFLO">${tireManagementForm.modelView.serialNoFLO}</label></td>
								<td width="10px;"></td>
								<td class="serialNoRow" align="center"><label id="lblSerialNoIdFLI">${tireManagementForm.modelView.serialNoFLI}</label></td>
								<td width="40px;"></td>
								<td class="spaceBox"></td>
								<td width="40px;"></td>
								<td class="serialNoRow" align="center"><label id="lblSerialNoIdFRI">${tireManagementForm.modelView.serialNoFRI}</label></td>
								<td width="10px;"></td>
								<td class="serialNoRow" align="center"><label id="lblSerialNoIdFRO">${tireManagementForm.modelView.serialNoFRO}</label></td>
							</tr>
							<tr height="20px;"></tr>
							<tr>
								<td class="threadRow" align="center">${tireManagementForm.modelView.thread1SLO}&nbsp;&nbsp;${tireManagementForm.modelView.thread2SLO}&nbsp;&nbsp;${tireManagementForm.modelView.thread3SLO}</td>
								<td width="10px;"></td>
								<td class="threadRow" align="center">${tireManagementForm.modelView.thread1SLI}&nbsp;&nbsp;${tireManagementForm.modelView.thread2SLI}&nbsp;&nbsp;${tireManagementForm.modelView.thread3SLI}</td>
								<td width="40px;"></td>
								<td class="spaceBox"></td>
								<td width="40px;"></td>
								<td class="threadRow" align="center">${tireManagementForm.modelView.thread1SRI}&nbsp;&nbsp;${tireManagementForm.modelView.thread2SRI}&nbsp;&nbsp;${tireManagementForm.modelView.thread3SRI}</td>
								<td width="10px;"></td>
								<td class="threadRow" align="center">${tireManagementForm.modelView.thread1SRO}&nbsp;&nbsp;${tireManagementForm.modelView.thread2SRO}&nbsp;&nbsp;${tireManagementForm.modelView.thread3SRO}</td>
							</tr>
							<tr>
								<td id="colorRowSLOId" class="colorRow" valign="middle" align="center" onclick="selectWheelPosition('SLO');">SLO</td>
								<td width="10px;"></td>
								<td id="colorRowSLIId" class="colorRow" valign="middle" align="center" onclick="selectWheelPosition('SLI');">SLI</td>
								<td width="40px;"></td>
								<td class="spaceBox"></td>
								<td width="40px;"></td>
								<td id="colorRowSRIId" class="colorRow" valign="middle" align="center" onclick="selectWheelPosition('SRI');">SRI</td>
								<td width="10px;"></td>
								<td id="colorRowSROId" class="colorRow" valign="middle" align="center" onclick="selectWheelPosition('SRO');">SRO</td>
							</tr>
							<tr>
								<td class="serialNoRow" align="center"><label id="lblSerialNoIdSLO">${tireManagementForm.modelView.serialNoSLO}</label></td>
								<td width="10px;"></td>
								<td class="serialNoRow" align="center"><label id="lblSerialNoIdSLI">${tireManagementForm.modelView.serialNoSLI}</label></td>
								<td width="40px;"></td>
								<td class="spaceBox"></td>
								<td width="40px;"></td>
								<td class="serialNoRow" align="center"><label id="lblSerialNoIdSRI">${tireManagementForm.modelView.serialNoSRI}</label></td>
								<td width="10px;"></td>
								<td class="serialNoRow" align="center"><label id="lblSerialNoIdSRO">${tireManagementForm.modelView.serialNoSRO}</label></td>
							</tr>
							<tr height="20px;"></tr>
							<tr>
								<td class="threadRow" align="center">${tireManagementForm.modelView.thread1TLO}&nbsp;&nbsp;${tireManagementForm.modelView.thread2TLO}&nbsp;&nbsp;${tireManagementForm.modelView.thread3TLO}</td>
								<td width="10px;"></td>
								<td class="threadRow" align="center">${tireManagementForm.modelView.thread1TLI}&nbsp;&nbsp;${tireManagementForm.modelView.thread2TLI}&nbsp;&nbsp;${tireManagementForm.modelView.thread3TLI}</td>
								<td width="40px;"></td>
								<td class="threadRow" align="center">${tireManagementForm.modelView.thread1R}&nbsp;&nbsp;${tireManagementForm.modelView.thread2R}&nbsp;&nbsp;${tireManagementForm.modelView.thread3R}</td>
								<td width="40px;"></td>
								<td class="threadRow" align="center">${tireManagementForm.modelView.thread1TRI}&nbsp;&nbsp;${tireManagementForm.modelView.thread2TRI}&nbsp;&nbsp;${tireManagementForm.modelView.thread3TRI}</td>
								<td width="10px;"></td>
								<td class="threadRow" align="center">${tireManagementForm.modelView.thread1TRO}&nbsp;&nbsp;${tireManagementForm.modelView.thread2TRO}&nbsp;&nbsp;${tireManagementForm.modelView.thread3TRO}</td>
							</tr>
							<tr>
								<td id="colorRowTLOId" class="colorRow" valign="middle" align="center" onclick="selectWheelPosition('TLO');">TLO</td>
								<td width="10px;"></td>
								<td id="colorRowTLIId" class="colorRow" valign="middle" align="center" onclick="selectWheelPosition('TLI');">TLI</td>
								<td width="40px;"></td>
								<td id="colorRowRId" class="colorRow" valign="middle" align="center" onclick="selectWheelPosition('SRO');">R</td>
								<td width="40px;"></td>
								<td id="colorRowTRIId" class="colorRow" valign="middle" align="center" onclick="selectWheelPosition('TRI');">TRI</td>
								<td width="10px;"></td>
								<td id="colorRowTROId" class="colorRow" valign="middle" align="center" onclick="selectWheelPosition('TRO');">TRO</td>
							</tr>
							<tr>
								<td class="serialNoRow" align="center"><label id="lblSerialNoIdTLO">${tireManagementForm.modelView.serialNoTLO}</label></td>
								<td width="10px;"></td>
								<td class="serialNoRow" align="center"><label id="lblSerialNoIdTLI">${tireManagementForm.modelView.serialNoTLI}</label></td>
								<td width="40px;"></td>
								<td class="serialNoRow" align="center"><label id="lblSerialNoIdR">${tireManagementForm.modelView.serialNoR}</label></td>
								<td width="40px;"></td>
								<td class="serialNoRow" align="center"><label id="lblSerialNoIdTRI">${tireManagementForm.modelView.serialNoTRI}</label></td>
								<td width="10px;"></td>
								<td class="serialNoRow" align="center"><label id="lblSerialNoIdTRO">${tireManagementForm.modelView.serialNoTRO}</label></td>
							</tr>
						</table>		
				</td>
				<td width="20"></td>
				<td valign="top">
					<div id="tablePresentationDIVDetails">
						<!-- selected tire details here -->	
					</div>
				</td>
			</tr>
			<tr height="10"></tr>
		</table>	
			
	</div>
	
</div>


