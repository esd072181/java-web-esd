//JS of Utilities

//Archive
function goToArchive() {
	$.ajax({
		  type: "GET",
		  cache: false,
		  url: "archive.do?"
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});
}
function getArchive(pageCriteria, isRestored) {

	$.ajax({
		  type: "GET",
		  url: "archive.do?command=ajaxSearch&page="+pageCriteria,
		  cache: false,
		  data: $("#idForm").serialize() 
		})
		  .done(function( result ) {
			$("#tablePresentationDIV").html(result);
			if (isRestored) {
				$("#msgId").show();
				setTimeout( "$('#msgId').hide();", 1500 );
			}
		});
}

function restoreEntity(id, currentPage) {
	
	bootbox.confirm("Are you sure you want to restore this record?", function(ans) {
		  //Example.show("Confirm result: "+result);
		if (ans) {
			$.ajax({
				  type: "POST",
				  url: "restoreEntity.do?",
				  data: { command: "ajaxRestore", id: id  }
				})
				  .done(function( result ) {
					 //$("#contentDIV").html(result);
					getArchive(currentPage, true);//show the updated list after restore
				});		
		} 
	}); 

}