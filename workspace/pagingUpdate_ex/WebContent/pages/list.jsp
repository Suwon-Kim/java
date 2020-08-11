<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<table>
	<caption>Doc List</caption>
	<thead>
		<tr>
			<th id = "num_td">num</th>
			<th id = "title_td">title</th>
			<th id = "author_td">author</th>
			<th id = "date_td">date</th>
		</tr>
	</thead>
	<tfoot>
		<tr>
			<th colspan = "4"><%@ include file = "paging.jspf" %></th>
		</tr>
	</tfoot>
	<tbody>
		<%@ include file = "list_sub.jspf" %>
	</tbody>
</table>