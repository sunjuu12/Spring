<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container">
	<h1>게시글 등록</h1>
	<br>
	<form name="insertForm" action="boardInsert" method="post">
		<table class="table">
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" /></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer" /></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="contents"></textarea></td>
			</tr>
			<tr>
				<th>이미지</th><!-- app.jpg -->
				<td><input type="file" name="image" /></td>
			</tr>
		</table>
		<button class="btn btn-primary" type="submit">등록</button>
	</form>
</div>
<script>
    // 자바스크립트
	document.querySelector('form[name="insertForm"]')
			.addEventListener('submit', boardInsertJS)
			
	function boardInsertJS(event) {
		event.preventDefault();
		
		// 배열로 들어오기 때문에 idx 값 지정해줘야함
		let title = document.getElementsByName('title')[0];
		let writer = document.getElementsByName('writer')[0];
		
		if(title.value == '') {
			alert('제목이 입력되지 않았습니다.');
			title.focus();
			return;
		}
		if(writer.value == '') {
			alert('작성자가 입력되지 않았습니다.');
			writer.focus();
			return;
		}
		
		insertForm.submit();
	}
    
	document
	  .querySelector('form[name="insertForm"]')
	  .removeEventListener("submit", boardInsertJS);
    
	// jQuery  일대일대응
	  $('form[name="insertForm"]').on("submit", boardInsertJq);

	  function boardInsertJq(event) {
	    event.preventDefault();

	    let title = $('[name="title"]');
	    let writer = $('[name="writer"]');

	    if (title.val() == "") {
	      alert("제목을 확인해주세요");
	      title.focus();
	      return;
	    }
	    if (writer.val() == "") {
	      alert("작성자를 확인해주세요.");
	      writer.focus();
	      return;
	    }

	    insertForm.submit();
	  }
</script>