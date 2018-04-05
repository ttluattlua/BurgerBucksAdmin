<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="utf-8"/> 

<!--===============현재가 어느 화면인지 나타내주는 상단바 ============================-->
<!-- Page wrapper  -->
   <!-- Bread crumb -->
<div class="row page-titles">
    <div class="col-md-5 align-self-center">
        <h3 class="text-primary">${doc_title }</h3> </div>
    <div class="col-md-7 align-self-center">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="javascript:void(0)">${doc_menu }</a></li>
            <li class="breadcrumb-item active">${doc_title }</li>
        </ol>
    </div>
</div>
<!-- End Bread crumb -->
<!-- Container fluid  -->


<!-- ajax 조건부 부분 -->
<script type="text/javascript">
	$(function() {
		$("#input-id").blur(function() {
			var userID = $('#input-id').val();
			$.ajax({
				type : 'post',
				url : 'getAdminID.do',
				data : {
					"id" : userID
				},
				success : function(data) {
						/* $("#checkMessage").attr('display','block'); */
						/*$("#checkMessage").html(data);*/
						idCheckMessage(data);
				},
				error : function() {
					alert("실패");
					
				}
			});
		});
	});
</script>

<script type="text/javascript">
function idCheckMessage(data) {
	if(data == 'S'){
		$("#checkMessage").html("사용하실 수 있는 아이디입니다");
		//$("#input-id").val($("#input-id").val());
	}else{
		$("#checkMessage").html("사용할 수 없는 아이디입니다");
		$("#input-id").val("");		
		
	}
}
</script>



<div class="container-fluid">
    <!-- Start Page Content -->
<div class="row">
    <div class="col-lg-12">
        <div class="card card-outline-primary">
        
            <div class="card-header">
                <h4 class="m-b-0 text-white">Branch manager Registration</h4>
            </div>

            <div class="card-body">
                 <form action="" name="adminPForm" id="_adminPForm" method="get">
                    <div class="form-body">
                        <h3 class="card-title m-t-15">Person Info</h3>
                        <hr>
                        <!-- 이름 입력 -->
                        <div class="row p-t-20">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label class="control-label">이름</label>
                                    <input type="text" name="name" id="input-firstname" class="form-control" placeholder="First Name">
                                </div>
                            </div>
                            <!--/span-->
                            <div class="col-md-6">
                                <div class="form-group has-danger">
                                    <label class="control-label">성</label>
                                    <input type="text" name="name" id="input-lastname" class="form-control form-control-danger" placeholder="Last Name">
                                </div>
                            </div>
                            <!--/span-->
                        </div>
                        
                       <!-- 아이디 입력 -->
                       <div class="row">
                            <div class="col-md-12 ">
                                <div class="form-group">
                                	<div>
                                    <label for="input-id">ID</label>
                                    <p id="checkMessage_ID" style="line-height: 35px;"></p>
                                    </div>
                                    <input type="text" name="id" id="input-id" placeholder="Enter ID" class="form-control">
                                	<strong class="help-block" style="display: block;width: 200%;" id="checkMessage"><!-- 영문, 숫자, 언더스코어(_), 하이픈(-)으로 이루어진  3~16 문자 --></strong>
                                </div>
                                </div>
                            </div>
                        
                        <!-- 패스워드 입력 -->
                        <div class="row">
                            <div class="col-md-12 ">
                                <div class="form-group">
                                    <label for="input-pw">Password</label>
                                    <div>
									<p id="checkMessage_PW" style="line-height: 35px;"></p>
									</div>
                                    <input type="password" name="password" id="input-pw" placeholder="Enter Password" class="form-control">
                                    	<strong class="help-block" style="display: block;width: 200%;" id="checkMessage2"><!-- 영문, 숫자, 언더스코어(_), 하이픈(-)으로 이루어진  6~18 문자. --></strong>
                                </div>
                            </div>
                            
                            <div class="col-md-12 ">
                                <div class="form-group">
                                    <label for="input-repw">Password 확인</label>
                                    <input type="password" id="input-repw" placeholder="Enter Password" class="form-control">
                                	<p class="help-block" style="display: block;width: 200%;" id="checkpw"></p>
                                </div>
                            </div>
                        </div>
                        
                        
                        <!-- 폰 입력 -->
                       <div class="row">
                            <div class="col-md-12 ">
                                <div class="form-group">
                                    <label for="input_phone">연락처</label>
                                    <input type="text" name="phone" id="input_phone" placeholder="Enter Phone Number" class="form-control">
                               </div>
                            </div>
                       </div>
                    
                    
					
                        <!-- 스토어 넘버 입력 -->
                       <div class="row">
                            <div class="col-md-12 ">
                                <div class="form-group">
									<label for="exampleFormControlSelect1">지점 선택</label>
									    <select class="form-control" onchange="document.getElementById('input_store').value = this.options[this.selectedIndex].value">
									    <option selected value=''>선택하세요</option> 
									    <c:forEach var="bsdto" items="${bslist}">
									      <option value='${bsdto.seq }'>${bsdto.name }</option>
									      </c:forEach>
									    </select>
                                    <input type="text" value="" name="input_store" id="input_store" class="form-control" readonly="readonly">
                                
                                </div>
                             </div>
                       </div>
                       

                    <div class="form-actions">
                        <button type="submit" class="btn btn-dark" id="btn_branchMRegi" onclick="account()"> <i class="fa fa-check"></i> Save</button>
                        <button type="button" class="btn btn-inverse">Cancel</button>
                    </div>
                    </div>



			<script type="text/javascript">
				jQuery( function($) {		// html 문서를 모두 읽으면 포함한 코드를 실행			
				
					// 정규식을 변수에 할당
					// 정규식을 직접 작성할 줄 알면 참 좋겠지만
					// 변수 우측에 할당된 정규식은 검색하면 쉽게 찾을 수 있다 
					// 이 변수들의 활약상을 기대한다
					// 변수 이름을 're_'로 정한것은 'Reguar Expression'의 머릿글자
					
					var re_id = /^[a-z0-9_-]{3,16}$/; // 아이디 검사식
					var re_pw = /^[a-z0-9_-]{6,18}$/; // 비밀번호 검사식
					
					// 선택할 요소를 변수에 할당
					// 변수에 할당하지 않으면 매번 HTML 요소를 선택해야 하기 때문에 귀찮고 성능에도 좋지 않다
					// 쉼표를 이용해서 여러 변수를 한 번에 선언할 수 있다
					// 보기 좋으라고 쉼표 단위로 줄을 바꿨다 
					
					var form = $(".card-body");
					var iid = $("#input-id");
					var ipw = $("#input-pw");
					var ipw2 = $("#input-repw");
					var ifirstname = $("#input-firstname");
					var ilastname = $("#input-lastname");
					var iphone = $("#input_phone");
					var istore = $("#input_store");
					
					
					// 선택한 form에 서밋 이벤트가 발생하면 실행한다
					// if (사용자 입력 값이 정규식 검사에 의해 참이 아니면) {포함한 코드를 실행}
					// if 조건절 안의 '정규식.test(검사할값)' 형식은 true 또는 false를 반환한다
					// if 조건절 안의 검사 결과가 '!= true' 참이 아니면 {...} 실행
					// 사용자 입력 값이 참이 아니면 alert을 띄운다
					// 사용자 입력 값이 참이 아니면 오류가 발생한 input으로 포커스를 보낸다
					// 사용자 입력 값이 참이 아니면 form 서밋을 중단한다
					
					form.submit(function() {
						if(re_id.test(iid.val()) != true) { // 아이디 검사
							alert('[ID입력 오류] 유효한 ID를 입력해 주세요.');
							iid.focus();
							return false;
						} else if (re_pw.test(ipw.val()) != true){	// 비밀번호 검사
							alert('[PW입력 오류] 유효한 PW를 입력해 주세요.');
							ipw.focus();
							return false;
						} else if (ipw2.val() != ipw.val()){
							alert('[PW 재입력 오류] PW와 동일하게 적어주세요.');
						 	ipw2.focus();
						 	return false;
						} else if (ifirstname.val() == ""){
							alert("[NAME 입력 오류] 이름을 입력해주세요");
							ifirstname.focus();
							return false;
						} else if (ilastname.val() == ""){
							alert("[NAME 입력 오류] 성을 입력해주세요");
							ilastname.focus();
							return false;
						}else if (iphone.val() == ""){
							alert("[PHONE 입력 오류] 연락처를 입력해주세요");
							ilastname.focus();
							return false;
						}else if (istore.val() == ""){
							alert("[STORE 입력 오류] 지점코드를 입력해주세요");
							ilastname.focus();
							return false;
						}
						
					});
										
					// #uid, #upw 인풋에 입력된 값의 길이가 적당한지 알려주려고 한다
					// #uid, #upw 다음 순서에 경고 텍스트 출력을 위한 빈 strong 요소를 추가한다
					// 무턱대고 자바스크립트를 이용해서 HTML 삽입하는 것은 좋지 않은 버릇
					// 그러나 이 경우는 strong 요소가 없어도 누구나 form 핵심 기능을 이용할 수 있으니까 문제 없다
					
					/* $("#input-id, #input-pw").after('<strong></strong>'); */
					
					// #uid 인풋에서 onkeyup 이벤트가 발생하면
					iid.keyup( function() {
						var i = $("#checkMessage_ID");
						/* var s = $(this).next('strong'); // strong 요소를 변수에 할당 */
						
						if (iid.val().length == 0) { // 입력 값이 없을 때
							i.text(''); // strong 요소에 포함된 문자 지움
						} else if (iid.val().length < 3) { // 입력 값이 3보다 작을 때
							i.text('아이디가 너무 짧습니다.'); // strong 요소에 문자 출력
						} else if (iid.val().length > 16) { // 입력 값이 16보다 클 때
							i.text('아이디가 너무 깁니다.'); // strong 요소에 문자 출력
						} else if ( re_id.test(iid.val()) != true ) { // 유효하지 않은 문자 입력 시
							i.text('유효한 문자를 입력해 주세요.'); // strong 요소에 문자 출력
						} else { // 입력 값이 3 이상 16 이하일 때
							i.text('아이디가 적당합니다.'); // strong 요소에 문자 출력
						}
					});
					
					// #upw 인풋에서 onkeyup 이벤트가 발생하면
					ipw.keyup( function() {
						var i = $("#checkMessage_PW");
						/* var s = $(this).next('strong'); // strong 요소를 변수에 할당 */
						
						if (ipw.val().length == 0) { // 입력 값이 없을 때
							i.text(''); // strong 요소에 포함된 문자 지움
						} else if (ipw.val().length < 6) { // 입력 값이 6보다 작을 때
							i.text('비밀번호는 6자리 이상 입력해주십시오.'); // strong 요소에 문자 출력
						} else if (ipw.val().length > 18) { // 입력 값이 18보다 클 때
							i.text('비밀번호가 너무 깁니다.'); // strong 요소에 문자 출력
						} else { // 입력 값이 6 이상 18 이하일 때
							i.text('비밀번호가 적당합니다.'); // strong 요소에 문자 출력
						}
					});
					
				});
				// ]]>
				</script>
     
                    
              </form>
             </div>
            </div>
		</div>
	</div>
	</div>
        


<!-- 비밀번호 확인창 blur -->
<script type="text/javascript">
$(function () {
	// 뿌려줄 문장
	var eqpw = "";
	
	// 비밀번호 같은지 체크
	var beqpw = false;
	
	$("#input-repw").blur(function () {
		if($("#input-pw").val()!=$("#input-repw").val()){
			eqpw = "비밀번호가 동일하지 않습니다";
			beqpw = false;
		}else if($("#input-pw").val().length==0 && $("#input-repw").val().length==0){
			eqpw = "";
			beqpw = false;
		}else {
			eqpw = "비밀번호가 동일합니다";
			beqpw = true;
		}
	/* $("#checkpw").attr("display","block" ); */
	$("#checkpw").html(eqpw);
	});
});
</script>

<!-- 비밀번호 입력창 blur -->
<script type="text/javascript">
$(function () {
	// 뿌려줄 문장
	var eqpw = "";
	
	// 비밀번호 같은지 체크
	var beqpw = false;
	
	$("#input-pw").blur(function () {				
		if($("#input-pw").val()!=$("#input-repw").val()){
			eqpw = "비밀번호가 동일하지 않습니다";
			beqpw = false;
		}else if($("#input-pw").val().length==0 && $("#input-repw").val().length==0){
			eqpw = "";
			beqpw = false;
		
		}else{
			eqpw = "비밀번호가 동일합니다";
			beqpw = true;
		}
	/* $("#checkpw").attr("display","block" ); */
	$("#checkpw").html(eqpw);
	});
});


$("#btn_branchMRegi").click(function() {	
	alert('등록!');	
	$("#_adminPForm").attr({"target":"_self", "action":"adminplusAf.do" }).submit();		
});

</script>
			
	
</html>