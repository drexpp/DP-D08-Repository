

<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>



<!-- Listing grid -->

<display:table pagesize="5" class="displaytag" 
	name="comments" requestURI="comment/list.do" id="row">



	<!-- Attributes -->
	
	
	<!-- text -->
	<spring:message code="comment.text" var="textHeader" />
	<display:column property="text" title="${textHeader}"
		sortable="true" />
		
	<!-- picture -->
	<spring:message code="comment.picture" var="pictureHeader" />
	<display:column property="picture" title="${pictureHeader}"
		sortable="true" />


	<!-- moment -->
	<spring:message code="comment.format"
  		var="format" />
	<spring:message code="comment.moment"
		var="momentHeader" />
	<display:column property="moment" title="${momentHeader}"
		sortable="true" format = "${format}" />


	<!-- rende -->
	<spring:message code="comment.rende"
		var="rendeHeader" />
	<display:column property="rende" title="${rendeHeader}" sortable="true"/> 
	
	
	<!-- Comments -->
	
	<display:column>
			<a href="comment/list.do?rendeId=${row.id}"> <spring:message
					code="rende.comments" />
			</a>
	</display:column>
	
	<display:column>
			<a href="question/list.do?rendeId=${row.id}"> <spring:message
					code="rende.questions" />
			</a>
	</display:column>
	
	
	
	<security:authorize access="hasRole('USER')">
			<a href="comment/user/create.do"> <spring:message
				code="comment.create" />
			</a>
	</security:authorize> 


</display:table>

