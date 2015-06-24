<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
	<div class="container" style="margin-top: 60px; margin-bottom: 5px;">
		<div class="row clearfix">
			<div class="col-md-4 column" ><a href="${base}/index.htm"><img alt="在线书店" src="${base}/logo.png" width="280px" height="50px" style="margin-left:20px"/></a></div>
			<div class="col-md-8 column">
				<form method="post" class="form-group" id="searchForm" action="${base}/search.htm">
					<div class="col-md-8">
						<input class="form-control" id="bookName" name="bookName"
							placeholder="图书名称" type="text" />
					</div>
					<button type="button" onclick="submitSearchForm();" class="btn btn-success">搜索</button>
				</form>
			</div>
		</div>
		<script type="text/javascript">
		function submitSearchForm(){
			$("#searchForm").submit();
		}
		</script>
	</div>