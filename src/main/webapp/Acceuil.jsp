<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<c:set var="title" value="Acceuil" scope="request"/>
	<jsp:include page="head.jsp"/>
	<body>    
		<jsp:include page="barAndNav.jsp"/>
        
        <%String content = "Parc de véhicules"; %>
         <!-- Carousel Start -->
        <div class="carousel">
            <div class="container-fluid">
                <div class="owl-carousel">
                    <div class="carousel-item">
                        <div class="carousel-img">
                            <img src="img/vehi.jpg" alt="Image">
                        </div>
                        <div class="carousel-text">
                            
                            <h1><%=content %></h1>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <div class="carousel-img">
                            <img src="img/vehi.jpg" alt="Image">
                        </div>
                        <div class="carousel-text">
                            
                            <h1><%=content %></h1>
                           
                        </div>
                    </div>
                    <div class="carousel-item">
                        <div class="carousel-img">
                            <img src="img/vehi.jpg" alt="Image">
                        </div>
                        <div class="carousel-text">
                            
                            <h1><%=content %></h1>
                           
                           
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Carousel End -->
	     <!-- Back to top button -->
		<a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>
        
        <!-- Pre Loader -->
        <div id="loader" class="show">
            <div class="loader"></div>
        </div>

        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <script src="lib/easing/easing.min.js"></script>
        <script src="lib/owlcarousel/owl.carousel.min.js"></script>
        <script src="lib/waypoints/waypoints.min.js"></script>
        <script src="lib/counterup/counterup.min.js"></script>
        
        <!-- Contact Javascript File -->
        <script src="mail/jqBootstrapValidation.min.js"></script>
        <script src="mail/contact.js"></script>

        <!-- Template Javascript -->
        <script src="js/main.js"></script>
    </body>
</html>
