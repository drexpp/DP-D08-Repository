

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
	name="comments" requestURI="comment/user/list.do" id="row">



	<!-- Attributes -->
	
	
	<!-- text -->
	<spring:message code="comment.text" var="textHeader" />
	<display:column property="text" title="${textHeader}"
		sortable="true" />
		
	<!-- picture -->
	<spring:message code="comment.picture" var="pictureHeader" />
	<spring:message code="comment.pictureError" var="pictureError" />
	<display:column title="${pictureHeader}" sortable="true" > <img src="${row.picture}"  width="auto" height="auto"></display:column> 


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
	<display:column property="rende.name" title="${rendeHeader}" sortable="true"/> 
	
	<!-- Replies of the comment -->
	<display:column title="${listReply}">
	
	<display:table pagesize="1" class="displaytag" 
	name="${row.repliesComments}" requestURI="comment/user/list.do" id="reply">
	
	<spring:message code="comment.reply2"
		var="reply2" />
	<display:column property="reply" title="${reply2}"/>
	
	<spring:message code="comment.writeBy"
	var="writer" />
	<display:column title="${writer}">
	 <a href="user/user/display.do?userId=${reply.user.id}">${reply.user.name}</a>
	 </display:column>
	
	
	</display:table>
	</display:column>
	<security:authorize access="hasRole('USER')">
	<!-- Reply -->
	<display:column>
			<a href="replyComment/create.do?commentId=${row.id}"> <spring:message
					code="comment.reply" />
			</a>
	</display:column>
	
			<a href="comment/user/create.do"> <spring:message
				code="comment.create" />
			</a>
	</security:authorize> 


</display:table>

<spring:message code="comment.writeBy"
	var="writer" />
 <a href="comment/user/create.do">${reply.user.name}</a>


