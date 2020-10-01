<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <script type="text/javascript">
  function workingClock() {
      var days=["Sun","Mon","Tue","Wed","Thur","Fri","Sat"];
      var today = new Date();
      var year = today.getFullYear();
      var month = today.getMonth()+1;
      if(month < 10) month="0" + month;
      var date = today.getDate();
      if(date<10) date="0"+date;
      var index = today.getDay();
      var day = days[index];
      var hour = today.getHours();
      var min = today.getMinutes();
      if(min < 10) min="0" +min;
      var sec = today.getSeconds();
      if(sec < 10) sec = "0"+sec;
      var str = year+"-"+month+"-"+date + "  " + day+"  "+ hour +" : "+ min+" : "+ sec;
      document.getElementById("clock").innerHTML = str;
   }
   function startClock() {
      setInterval(workingClock, 1000);
   }
  </script>
  <title>JAVAGERS's Final Legend Project</title>
<style type="text/css">
 #content{
   width: 99%;
   height:30%;
   float: left;
/*     background-image: url('../imgs/main1.jpg');    */
   background-size: 1800px;
}

.sticky-footer{
   background: #F0F8FF;
}
.container-fluid{
   background: #F0F8FF;
}
</style>
  <link href="${pageContext.request.contextPath}/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/css/sb-admin-2.min.css" rel="stylesheet">
</head>

<body id="page-top" onload="javascript:startClock()">

  <!-- Page Wrapper -->
  <div id="wrapper">

    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-warning sidebar sidebar-dark accordion" id="accordionSidebar">

      <!-- Sidebar - Brand -->
      <a class="sidebar-brand d-flex align-items-center justify-content-center" href="../home/intro.html">
        <div class="sidebar-brand-icon rotate-n-15">
			<img alt="" src="../imgs/pokemon/10.png" width="64" height="64">
        </div>
        <div class="sidebar-brand-text mx-3" > POKEMON Home</div>
      </a>

      <!-- Divider -->
      <hr class="sidebar-divider my-1">

      <!-- Nav Item - Dashboard -->
      <li class="nav-item active">
        <a class="nav-link"> <font color="black">JSL No.1 34th Javagers <br/>
        Especially thanks to<br/><img alt="" src="../imgs/main/trophy2.png" width="40" height="40">[ DeokJae Lee ]<img alt="" src="../imgs/main/trophy2.png" width="40" height="40"><br/>
        We were able to make this.</font>
<!--          <br/> Thanks to DaeSung Park  -->
      <div id="aside">
      <fieldset>
         <c:choose>
            <c:when test="${sessionScope.loginUser != null }">
             <jsp:include page="logoutForm.jsp"/>
            <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages" aria-expanded="true" aria-controls="collapsePages">
          <span>My Page</span>
        </a>
        <div id="collapsePages" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">Select </h6>
            <a class="collapse-item" href="../home/userinfo.html">My Page</a>
            <a class="collapse-item" href="../logout/template.html">Logout</a>
          </div>
        </div>
      </li>
      
<%--                <jsp:include page="logoutForm.jsp"/> --%>
            </c:when>
            <c:when test="${HEADER != null }">
               <jsp:include page="${HEADER }"/>
            </c:when>
            <c:otherwise>
               <jsp:include page="../login/login.html"/>
            </c:otherwise>
         </c:choose>
      </fieldset>
   </div>
  </a>
 </li><br/>
      <hr class="sidebar-divider">
      <hr class="sidebar-divider">
      
<!-- 		<li class="nav-item"> -->
<!--         	<a class="nav-link collapsed" > -->
<!--           	 <font color="yellow"><span>원하시는 게시판을 누르세요.</span></font> -->
<!--        	    </a> -->
<!--  	   </li>   -->
<!--  	   <br/> -->
<!--  	   <hr class="sidebar-divider"> -->
<!-- 	   <hr class="sidebar-divider"> -->
	   
      <!-- Nav Item - Pages Collapse Menu -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="../home/deck.html" >
          	<img alt="" src="../imgs/main/listImage.jpg" width="40" height="40">
          <br/>
          <br/><h6><font color="#F0FFFF"><b>Pokemon Deck</font></h6>
        </a>
      </li>
       
      <hr class="sidebar-divider">
      
      
      <li class="nav-item">
        <a class="nav-link collapsed" href="../pokemon/pokemonList2.html">
        	<img alt="" src="../imgs/main/listImage.jpg" width="40" height="40">
        	<br/>
          	<br/><h6><font color="#F0FFFF"><b>Pokemon Thumbnail</font></h6>
        </a>
      </li>
     
      <!-- Divider -->
      <hr class="sidebar-divider">
      
      <li class="nav-item">
        <a class="nav-link collapsed" href="../pokemon/pokemonList.html">
        <img alt="" src="../imgs/main/listImage.jpg" width="40" height="40">
        <br/>
        <br/><h6><font color="#F0FFFF"><b>Pokemon List</font></h6>
        </a>
      </li>
   
     <!-- Divider -->
      <hr class="sidebar-divider">
      
      <li class="nav-item">
        <a class="nav-link collapsed" href="../wish/show.html">
        <img alt="" src="../imgs/main/cartImage.jpg" width="40" height="40">
        <br/>
        <br/><h6><font color="#F0FFFF"><b>Pokemon WishList</font></h6>
        </a>
      </li>
      
 
      
      <hr class="sidebar-divider">
      
      
      
      <li class="nav-item">
        <a class="nav-link collapsed" href="../war/warSelect.html">
        <img alt="" src="../imgs/main/fightImage.png" width="40" height="40">
        <br/>
        <br/><h6><font color="red"><b>Pokemon Battle</font></h6>
        </a>
      </li>
      
      <hr class="sidebar-divider">
      
       <li class="nav-item">
        <a class="nav-link collapsed" href="../ranking/rankingList.html">
        <img alt="" src="../imgs/main/crownImage.jpg" width="40" height="40">
        <br/>
        <br/><h6><font color="#F0FFFF"><b>Pokemon Ranking</font></h6>
        </a>
      </li>
      
      <hr class="sidebar-divider">
      
<!--         <li class="nav-item"> -->
<!--         <a class="nav-link collapsed" href="../write/writeList.html"> -->
<!--         <img alt="" src="../imgs/main/exchangeImage.jpg" width="40" height="40"> -->
<!--         <br/> -->
<!--         <br/><h6><font color="#F0FFFF"><b>Pokemon Market</font></h6> -->
<!--         </a> -->
<!--         </li> -->

		<li class="nav-item">
		<a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages" aria-expanded="true" aria-controls="collapsePages">
         <img alt="" src="../imgs/main/exchangeImage.jpg" width="40" height="40"> <h6><font color="#F0FFFF"><b>Pokemon Market</font></h6>
        </a>
        <div id="collapsePages" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">Select </h6>
            <a class="collapse-item" href="../write/writeList.html">Go Market</a>
            <a class="collapse-item" href="../write/writeForm.html">Write</a>
          </div>
        </div>
      </li>
      
      <hr class="sidebar-divider">
      
      <li class="nav-item">
        <a class="nav-link collapsed" href="../userInfo/charge.html">
        <img alt="" src="../imgs/main/coinImage2.jpg" width="40" height="40">
        <br/>
        <br/><h6><font color="#F0FFFF"><b>Pokemoney Charge</font></h6>
        </a>
      </li>

      
      <hr class="sidebar-divider">
      <hr class="sidebar-divider">
      
      
      <!-- 사이드바 화살표 -->
      <div class="text-center d-none d-md-inline">
        <button class="rounded-circle border-0" id="sidebarToggle"></button>
      </div>
    </ul>
    
    <!-- End of Sidebar -->
    


    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">
        <!-- 화면 상단바 -->
        <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
			<img alt="" src="../imgs/pokemon/100.png" width="64" height="64">
			<img alt="" src="../imgs/main/blankImage.jpg" width="64" height="64">
			<img alt="" src="../imgs/pokemon/96.png" width="64" height="64">
			<img alt="" src="../imgs/main/blankImage.jpg" width="64" height="64">
			<img alt="" src="../imgs/pokemon/30.png" width="64" height="64">
			<img alt="" src="../imgs/main/blankImage.jpg" width="64" height="64">
			<img alt="" src="../imgs/pokemon/138.png" width="64" height="64">
			<img alt="" src="../imgs/main/blankImage.jpg" width="64" height="64">
			<img alt="" src="../imgs/pokemon/143.png" width="64" height="64">
			<img alt="" src="../imgs/main/blankImage.jpg" width="64" height="64">
			<img alt="" src="../imgs/pokemon/117.png" width="64" height="64">
			<img alt="" src="../imgs/main/blankImage.jpg" width="64" height="64">
			<img alt="" src="../imgs/pokemon/126.png" width="64" height="64">
			<img alt="" src="../imgs/main/blankImage.jpg" width="64" height="64">
			<img alt="" src="../imgs/pokemon/79.png" width="64" height="64">
			<img alt="" src="../imgs/main/blankImage.jpg" width="64" height="64">
			<img alt="" src="../imgs/pokemon/8.png" width="64" height="64">
	
          <!-- Topbar Search -->
          
<%--           <form class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search" > --%>
<!--             <div class="input-group"> -->
<!--               <input type="text" class="form-control bg-light border-0 small" placeholder="검색 기능 준비 중입니다..." aria-label="Search" aria-describedby="basic-addon2" id="search"> -->
<!--               <div class="input-group-append"> -->
<!--                 <button class="btn btn-danger" type="button"> -->
<!--                   <i class="fas fa-search fa-sm"></i> -->
<!--                 </button> -->
<!--               </div> -->
<!--             </div> -->
<%--           </form> --%>

            <!-- Topbar Navbar -->
          <ul class="navbar-nav ml-auto">

           <c:choose>
                 <c:when test="${sessionScope.loginUser != null }">
             
                     <li class="nav-item dropdown no-arrow mx-1">
              <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-bell fa-fw"></i>
                <!-- Counter - Alerts -->
                <span class="badge badge-danger badge-counter">3+</span>
              </a>
              <!-- Dropdown - Alerts -->
              <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="alertsDropdown">
                <h6 class="dropdown-header">
                     <h5>      Alert</h5>
                </h6>
                <a class="dropdown-item d-flex align-items-center" href="#">
                  <div class="mr-3">
                    <div class="icon-circle bg-primary">
                      <i class="fas fa-file-alt text-white"></i>
                    </div>
                  </div>
                  <div>
                    <div class="small text-gray-500">September 2, 2019</div>
                    <span class="font-weight-bold">${sessionScope.loginUser } 회원님의 회원가입을 축하드립니다!</span>
                  </div>
                </a>
                <a class="dropdown-item d-flex align-items-center" href="#">
                  <div class="mr-3">
                    <div class="icon-circle bg-primary">
                      <i class="fas fa-file-alt text-white"></i>
                    </div>
                  </div>
                  <div>
                    <div class="small text-gray-500">September 2, 2019</div>
                    	<span class="font-weight-bold">당장 과금을 하시어 포켓몬 대전에 참여하세요 ! </span>	
                    </div>
                </a>
                <a class="dropdown-item d-flex align-items-center" href="#">
                  <div class="mr-3">
                    <div class="icon-circle bg-warning">
                      <i class="fas fa-exclamation-triangle text-white"></i>
                    </div>
                  </div>
                  <div>
                    <div class="small text-gray-500">September 2, 2019</div>
                      	※ 안전한 계정 보안을 위해 비밀번호를 주기적으로 변경해주세요.
                    </div>
                </a>
                <a class="dropdown-item text-center small text-gray-500" href="#">Close</a>
              </div>
            </li>

            <!-- Nav Item - Messages -->
            <li class="nav-item dropdown no-arrow mx-1">
              <a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-envelope fa-fw"></i>
                <!-- Counter - Messages -->
                <span class="badge badge-danger badge-counter">2</span>
              </a>
              <!-- Dropdown - Messages -->
              <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="messagesDropdown">
                <h6 class="dropdown-header">
                  Message Center
                </h6>

                <a class="dropdown-item d-flex align-items-center" href="#">
                  <div class="dropdown-list-image mr-3">
                    <img class="rounded-circle" src="https://source.unsplash.com/AU4VPcFN4LE/60x60" alt="">
                    <div class="status-indicator bg-success"></div>
                  </div>
                  <div>
                    <div class="text-truncate"></div><span class="font-weight-bold">[ ${sessionScope.loginUser } ]님께 [스타터 포켓몬 알] &ensp; 1개를 지급해드렸습니다.</span>
                    <div class="small text-gray-500">admin · 방금</div>
                  </div>
                </a>
                <a class="dropdown-item d-flex align-items-center" href="#">
                  <div class="dropdown-list-image mr-3">
                    <img class="rounded-circle" src="https://source.unsplash.com/CS2uCrpNzJY/60x60" alt="">
                    <div class="status-indicator bg-danger"></div>
                  </div>
                  <div>
                    <div class="text-truncate">고객님은 100 만원에 월 이자 5,800원으로 5천만원까지 당일 송금 가능하십니다.</div>
                    <div class="small text-gray-500">김미영 팀장 · 방금 </div>
                  </div>
                </a>
             
                <a class="dropdown-item text-center small text-gray-500" href="#">Close</a>
              </div>
            </li>
                      <li class="nav-item dropdown no-arrow">
              <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <span class="mr-2 d-none d-lg-inline text-gray-600 small"><span class="font-weight-bold">${sessionScope.loginUser } 회원님</span></span>
              </a>
              <!-- Dropdown - User Information -->
              <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                <a class="dropdown-item" href="../home/userinfo.html">
                  <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                  My Page
                </a>
                <a class="dropdown-item" href="../home/deck.html">
                  <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                  Pokemon Deck
                </a>
                <a class="dropdown-item" href="../pokemon/pokemonList.html">
                  <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
                  Pokemon List
                </a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="../logout/template.html" >
                  <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                  Logout
                </a>
              </div>
            </li>
                 </c:when>
                 <c:otherwise>
                    
                 </c:otherwise>
           </c:choose>
          
          </ul>
        </nav>
        <!-- End of Topbar -->


        <!-- Begin Page Content -->
        <div class="container-fluid">
         <a href="#" onclick="javascript:startClock()"> </a>
         <div id="clock" style="width:800px; height:30px; line-height:20px; color:gold;font-size:25px; text-align:left;">
         </div>
        </div>
        
   <div id="content">
      <c:choose>
         <c:when test="${BODY != null }">      
            <jsp:include page="${BODY }"/>  
         </c:when>
         <c:otherwise>
<%--             <jsp:include page="front.jsp"/> --%>
<!--             <img alt="" src="../imgs/main/intro.png" width="100%" height="100%"/> -->
			<img alt="" src="../imgs/main/main2.jpg" width="99%" height="90%"/>
         </c:otherwise>
      </c:choose>   
   </div>
        </div>
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->

      <footer class="sticky-footer ">
        <div class="container my-auto" >
          <div class="copyright text-center my-auto">
           <img alt="" src="../imgs/main/trophy.jpg" height="90" width="90"> <br/><span><font color="black">Copyright &copy; JSL 34th No.1 Gorgeous Superb Praiseworthy Remarkable Highest Brilliant Fabulous Splendid Magnificent Honorable Worthy Team <font color="red">[Javagers DBsemble]</font>
            <br/><font color="red">[ Park JungHwan ] [ Kim DoWan ] [ Kim JunSeong ] [ Jang JaeYeong ]</font>
            <br/>The &nbsp; JSL & Cosea Human Resources Development Institute Legends Quartet </font></span>   
          </div>
        </div>
      </footer>

<!--     </div> -->
<!--     End of Content Wrapper -->

<!--   </div> -->
<!--   <!-- End of Page Wrapper --> 

  <!-- 스크롤 제일 위로 버튼-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

  <!-- Logout Modal-->
  <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
          <button class="close" type="button" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">×</span>
          </button>
        </div>
        <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
        <div class="modal-footer">
          <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
          <a class="btn btn-primary" href="login.html">Logout</a>
        </div>
      </div>
    </div>
  </div>
  

  <!-- Bootstrap core JavaScript-->
  <script src="<c:url value="/resources/vendor/jquery/jquery.min.js"/>"></script>
  <script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"/>"></script>

  <!-- Core plugin JavaScript-->
  <script src="<c:url value="/resources/vendor/jquery-easing/jquery.easing.min.js"/>"></script>

  <!-- Custom scripts for all pages-->
  <script src="<c:url value="/resources/js/sb-admin-2.min.js"/>"></script>

  <!-- Page level plugins -->
  <script src="<c:url value="/resources/vendor/chart.js/Chart.min.js"/>"></script>

  <!-- Page level custom scripts -->
  <script src="<c:url value="/resources/js/demo/chart-area-demo.js"/>"></script>
  <script src="<c:url value="/resources/js/demo/chart-pie-demo.js"/>"></script>

</body>

</html>