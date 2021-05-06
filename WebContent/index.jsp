<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import='java.util.ArrayList' %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Lectura de API</title>
	<script type="text/javascript">
	  function cargarMunicipios() {
		  //console.log(arguments[0]);
		  window.location = "<%=request.getContextPath()%>?provincia=" + arguments[0];
	  }
	</script>
</head>
<body>
<% 
	String seleccionado = (String)request.getAttribute("seleccionado");
	if(seleccionado == null) {
		seleccionado = "";
	}
	
	ArrayList<String> listadoProvincias = (ArrayList<String>)request.getAttribute("listadoProvincias");
	//ArrayList<String> listadoProvincias = (ArrayList<String>)request.getSession().getAttribute("listadoProvincias");
	ArrayList<String> listadoMunicipios = (ArrayList<String>)request.getAttribute("listadoMunicipios");
%>
  <form action="<%=request.getContextPath()%>/miformulario" method="post">
                           
    <select name="provincia" id="provincia" onchange="cargarMunicipios(this.value)">                
    <% 
    if(listadoProvincias != null) {
    %>
        <option value="">Elige una provincia...</option>
    <%
    	  for(String provincia : listadoProvincias) {
    		    if(provincia.equals(seleccionado)) {
    %>
               <option value="<%= provincia %>" selected><%= provincia %></option>
    <%
            } else {
    %>
               <option value="<%= provincia %>"><%= provincia %></option>
    <% 
            } 
    		} 
    }
    %>
    </select>
    
    <br><br>
    
    <select name="municipio" id="municipio">
        <option value="">Elige un municipio...</option>                
    <% 
    if(listadoMunicipios != null) { 
    %>
        
    <%
    	  for(String municipio : listadoMunicipios) { 
    %>
	         <option value="<%= municipio %>"><%= municipio %></option>
	  <%
	      } 
	  }
	  %>
    </select>

  </form>
</body>
</html>

<!-- http://www.forosdelweb.com/f13/cargar-datos-select-jsp-1119690/ -->