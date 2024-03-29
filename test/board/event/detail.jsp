<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/board.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/plugins/summernote/summernote-bs4.min.css">
</head>

<body>

	<div class="wrapper">
		<section class="content-header">
			<div class="container-fluid">
				<div class="row md-2">
					<div>
						<h3>경조사게시판</h3>
					</div>
					<div style="display: inline; margin-left: 10px; margin-top: 10px;">
						<span  class="text-muted"  style="padding-right: 535px;">게시판 > 경조사게시판</span>
					</div>
				</div>
			</div>
		</section>

		<section class="content container-fluid">
			<div class="card card-navy card-outline">
				<div class="card-header">
					<h3 class="card-title" style="padding-top: 8px;">경조사게시판 상세</h3>
					<div class="col-lg-12">
						<button class="btn btn-outline-danger float-right"
							style="margin-left: 20px;" type="button" ${loginUser.eno!=board.eno? 'hidden':'' } onclick="remove_go();">삭제</button>
						<button class="btn btn-outline-primary float-right"
							style="margin-left: 20px;" type="button" ${loginUser.eno!=board.eno? 'hidden':'' }
							onclick="goDetail('<%=request.getContextPath()%>/board/event/modifyGo.do?boardNo=${board.boardNo}','${menu.mcode}')">수정</button>
						<button class="btn btn-outline-dark float-right" type="button"
							onclick="goIframPage('<%=request.getContextPath() %>/board/event/list.do','${menu.mcode}')">목록</button>
					</div>
				</div>

				<div class="card-body">
					<h5 style="font-weight: bold;">
					<c:if test="${board.eventcate eq 1 }">[결혼] </c:if>
					<c:if test="${board.eventcate eq 2 }">[부고] </c:if>
					${board.boardTitle }
					</h5>
					<div class="form-group row">
						<div class="user-panel pb-3 d-flex">
							<div class="image">
								<img class="img-circle elevation-2" alt="img" src="${board.photo }" style="height: 35px;">
							</div>
							<div class="info">
								<span>${board.name }</span>
								<span class="date">&nbsp;&nbsp;<fmt:formatDate value="${board.regDate }" pattern="yyyy-MM-dd"/></span>
								<span class="date">/&nbsp;&nbsp;<fmt:formatDate value="${board.enddate }" pattern="yyyy-MM-dd"/></span>
							</div>
						</div>
					</div>

					<div class="form-group">${board.boardContent }</div>

					<div class="form-group">
						<span class="ic_classic ic_reply"></span> <span class="txt_b">참석자
							<span class="num txt_b" id="commentCount">${board.replyCnt } </span>명
						</span> <span class="part">&nbsp;|&nbsp;</span> <span class="txt_ txt_b">
							조회 <span>${board.viewCnt }</span>
						</span>
					</div>

					<div class="card card-light card-outline">
						<div class="card-header">
							<h5 class="card-title" style="font-size: medium;">
								<i class="fas fa-paperclip"></i>&nbsp;&nbsp;첨부파일
							</h5>
						</div>
						<div class="card-footer">
							<div class="row">
								<c:forEach items="${board.attachList }" var="attach">
									<div class="col-md-4 col-sm-4 col-xs-12"  style="cursor:pointer;" onclick="location.href='getFile.do?attachNo=${attach.attachNo}'">
										<div class="info-box">
										 	<span class="info-box-icon bg-yellow">
												<i class="fa fa-copy"></i>
											</span>
											<div class="info-box-content">
												<span class ="info-box-text">
													<fmt:formatDate value="${attach.regDate }" pattern="yyyy-MM-dd"/>
												</span>
												<span class ="info-box-number">${attach.fileName }</span>
											</div>
										</div>
									 </div>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="card card-navy">
				<div class="card-header">
					<h5 class="card-title" style="font-size: medium;">
						<i class="fas fa-users"></i>&nbsp;&nbsp;참석 신청
					</h5>
				</div>

				<div class="card-body row">
					<c:if test="${board.endCheck eq 1 }">
					<input type="text" class="form-control col-11" id="newReplyText" placeholder="참셕을 원하시는 분은 작성해주세요" value="" readonly>
					</c:if>
					<c:if test="${board.endCheck ne 1 }">
					<input type="text" class="form-control col-11" id="newReplyText" placeholder="참셕을 원하시는 분은 작성해주세요" value="" >
					</c:if>
					<button type="button" id="replyAddBtn" class="btn btn-default col-1" onclick="replyRegist_go();">
						참석
					</button>
				</div>

				<div class="card-footer">
					<div class="timeline">
						<div class="time-label" id="repliesDiv">
							<span class="bg-lightblue" >참석자 목록</span>
						</div>

					</div>

					<div class='text-center'>
						<ul class="pagination justify-content-center m-0" id="pagination"></ul>
					</div>

				</div>

			</div>
		</section>

		<div class="modal modal-default fade" id="modal-reply" role="dialog">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header">
						<h4>댓글 수정</h4>
						<h4 class="modal-title" style="display:none;"></h4>
					</div>
					<div class="modal-body">
						<div class="row ">
						<input class="form-control col-12" type="text" id="replyText" name='replyText' class="form-control">
					</div>
					</div>
					<div class="modal-footer justify-content-between">
						<button type="button" class="btn btn-outline-dark"
							data-dismiss="modal">닫기</button>
						<button type="button" class="btn btn-outline-primary" id="replyModBtn" style="text-align: right" onclick="replyModify_go();" data-dismiss="modal">수정</button>
					</div>
				</div>
			</div>
		</div>

	</div>

<form role="form">
	<input type="hidden" name="boardNo" value="${board.boardNo }" />
</form>

<script>
function remove_go(){
	var formObj = $("form[role='form']");
	var answer = confirm("정말 삭제하시겠습니까?");
	if(answer){
		formObj.attr("action", "remove.do");
		formObj.attr("method", "post");
		formObj.submit();
	}
}

<c:if test="${from eq 'remove'}" >
	alert("삭제되었습니다.");
</c:if>
</script>

<%@ include file="./eventReply_js.jsp" %>

</body>
