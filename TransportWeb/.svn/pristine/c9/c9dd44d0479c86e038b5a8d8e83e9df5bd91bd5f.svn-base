<!DOCTYPE html>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<%
response.setHeader("Cache-Control","no-cache");
%>

<html lang="en">
<head>
 	 <title>TransportWeb</title>
	 <meta http-equiv="content-type" content="text/html" charset="utf-8">
	 <!--<meta http-equiv="refresh" content="10">--><%-- goes back to login page after 10 seconds in refresh --%>
	 <meta name="description" content="Transport Web Management System">
	 <meta name="keywords" content="Hauling, Truck, Lorry, Transport, Delivery, Shell, Caltex">
	 <meta name="author" content="Edward S. David">
	 <meta name="viewport" content="width=device-width, initial-scale=1">
     <script src="js/jquery-1.11.1.js" type="text/javascript"></script>
 	 <script src="js/bootstrap.min.js"></script>
 	 <script src="js/jquery-ui.min.js"></script>
 	 <script src="js/masterfile.js"></script>
 	 <script src="js/transaction.js"></script>
 	 <script src="js/utilities.js"></script>
 	 <script src="js/global.js"></script>
 	 <script src="js/reports.js"></script>
 	 <script src="js/bootbox.js"></script>
 	 <script src="js/jquery.timepicker.min.js"></script>
 	 <link rel="stylesheet" href="style/bootstrap.min.css">
     <link rel="stylesheet" type="text/css" href="style/jquery-ui.css">
 	 <link rel="stylesheet" type="text/css" href="style/page_layout.css">
 	 <link rel="stylesheet" type="text/css" href="style/jquery.timepicker.min.css">
</head>
<script>

$(document).ready(function () {
 
	//test code for menu
    $('.nav li a').click(function(e) {

        $('.nav li').removeClass('active');

        var $parent = $(this).parent();
        if (!$parent.hasClass('active')) {
            $parent.addClass('active');
        }
        //e.preventDefault();
    });
	
	//Prevent the Enter key to submit the form
	$(window).keydown(function(event){
		if(event.keyCode == 13) {
			event.preventDefault(); //either this or return false
			return false;
		}
	});
	
});

  $(function() {
    $( "#menu" ).menu({
      items: "> :not(.ui-widget-header)"
    });
  });
  
 // $body = $("body");

  $(document).on({
      ajaxStart: function() { 
    	  $("#ajaxSpinnerId").addClass("modal");
    	  //alert('ajaxStart');
    	  //$body.addClass("loading");    
       },
       ajaxStop: function() { 
    	   setTimeout(function(){$("#ajaxSpinnerId").removeClass("modal")}, 400);
    	   //alert('ajaxStop');
    	  //$body.removeClass("loading"); 
       }    
  });
  
</script>
<style>
  .ui-menu { width: 200px; }
  .ui-widget-header { padding: 0.2em; }
</style>

<body>

<div id="mainDIV">

	<tiles:insert attribute="header"/>
	
	<div style="margin-top: 160px;">
		<tiles:insert attribute="body"/> 
	 </div>
	<tiles:insert attribute="footer"/> 

</div>

<div id="ajaxSpinnerId"></div>

</body>
</html>