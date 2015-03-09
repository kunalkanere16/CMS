
	
	
	
	<!-- <h2 align="center"> Content Management System</h2> -->
	<!-- Bootstrap Navbar -->
	<div class="navbar navbar-inverse navbar-static-top">
		<div class="container">
			<a href="#" class="navbar-brand">Content Management System</a>
			<button class="navbar-toggle" data-toggle="collapse" data-target=".navHeaderCollapse">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<div class="collapse navbar-collapse navHeaderCollapse">
				<ul class="nav navbar-nav navbar-right">
					<li class="active"><a href="${pageContext.request.contextPath}/home.do">Home</a></li>
					
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" >Manage Products 
							<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li ><a href="${pageContext.request.contextPath}/viewProducts.do">View Products</a></li>
							<li ><a href="${pageContext.request.contextPath}/editProducts.do">Edit Products</a></li>
						</ul>
					</li>
					
					
				</ul>
			</div>
		</div>
	</div>
	
	<%-- <a href="${pageContext.request.contextPath}/home.do">Home</a>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="${pageContext.request.contextPath}/viewProducts.do">View Products</a>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="${pageContext.request.contextPath}/editProducts.do">Edit Products</a>	 --%>
