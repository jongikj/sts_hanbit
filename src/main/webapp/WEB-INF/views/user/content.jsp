<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="apple-touch-icon" sizes="57x57" href="${img}/favicons/apple-touch-icon-57x57.png">
<link rel="apple-touch-icon" sizes="60x60" href="${img}/favicons/apple-touch-icon-60x60.png">
<link rel="icon" type="image/png" href="${img}/favicons/favicon-32x32.png" sizes="32x32">
<link rel="icon" type="image/png" href="${img}/favicons/favicon-16x16.png" sizes="16x16">
<link rel="manifest" href="${img}/favicons/manifest.json">
<link rel="shortcut icon" href="${img}/favicons/favicon.ico">
<link rel="stylesheet" type="text/css" href="${css}/normalize.css">
<link rel="stylesheet" type="text/css" href="${css}/owl.css">
<link rel="stylesheet" type="text/css" href="${css}/animate.css">
<link rel="stylesheet" type="text/css" href="${css}/fonts/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="${css}/fonts/et-icons.css">
<link rel="stylesheet" type="text/css" href="${css}/cardio.css">
	<section id="user_content_service" class="box section-padded">
		<div>
			<div class="row text-center title">
				<h2>Services</h2>
				<h4 class="light muted">Achieve the best results with our wide variety of training options!</h4>
			</div>
			<div class="row services">
				<div class="col-md-4">
					<div id="kaup" class="service">
						<div class="icon-holder">
							<img src="${img}/icons/kaup.jpg" alt="" class="icon">
						</div>
						<h4 class="heading">KAUP INDEX</h4>
						<p class="description">A elementum ligula lacus ac quam ultrices a scelerisque praesent vel suspendisse scelerisque a aenean hac montes.</p>
					</div>
				</div>
				<div class="col-md-4">
					<div id="rock_scissor_paper" class="service">
						<div class="icon-holder">
							<img src="${img}/icons/RSP.jpg" alt="" class="icon">
						</div>
						<h4 class="heading">ROCK SCISSOR PAPER</h4>
						<p class="description">A elementum ligula lacus ac quam ultrices a scelerisque praesent vel suspendisse scelerisque a aenean hac montes.</p>
					</div>
				</div>
				<div class="col-md-4">
					<div id="lotto" class="service">
						<div class="icon-holder">
							<img src="${img}/icons/lotto.jpg" alt="" class="icon">
						</div>
						<h4 class="heading">LOTTO DRAWING</h4>
						<p class="description">A elementum ligula lacus ac quam ultrices a scelerisque praesent vel suspendisse scelerisque a aenean hac montes.</p>
					</div>
				</div>
			</div>
		</div>
		<div class="cut cut-bottom"></div>
	</section>
	<section id="user_content_subject" class="section gray-bg">
		<div class="container">
			<div class="row title text-center">
				<h2 class="margin-top">Major Subject</h2>
				<h4 class="light muted">TOP 3</h4>
			</div>
			<div class="row">
				<div class="col-md-4">
					<div id="major_subject_1" class="team text-center">
						<div class="cover" style="background:url('${img}/team/java-cover.jpg'); background-size:cover;">
							<div class="overlay text-center">
								<h3 class="white">Java </h3>
								<h5 class="light light-white">1 - 5 sessions / month</h5>
							</div>
						</div>
						<img src="${img}/team/java.jpg" alt="Java Image" class="avatar" style="width: 120px" height="120px">
						<div class="title">
							<h4>JAVA</h4>
							<h5 class="muted regular">Server Program Language</h5>
						</div>
						<input type="hidden" name="major_subject_1" value="java"/>
						<input type="button" data-toggle="modal" data-target="#modal1" class="btn btn-blue-fill" value="과목 정보"/>
					</div>
				</div>
				<div class="col-md-4">
					<div id="major_subject_2" class="team text-center">
						<div class="cover" style="background:url('${img}/team/javascript-cover.jpg'); background-size:cover;">
							<div class="overlay text-center">
								<h3 class="white">Javascript</h3>
								<h5 class="light light-white">1 - 5 sessions / month</h5>
							</div>
						</div>
						<img src="${img}/team/javascript.jpg" alt="Javascript Image" class="avatar" style="width: 120px" height="120px">
						<div class="title">
							<h4>Javascript</h4>
							<h5 class="muted regular">UI Program Language</h5>
						</div>
						<input type="hidden" name="major_subject_2"/>
						<input type="button" data-toggle="modal" data-target="#modal1" class="btn btn-blue-fill" value="과목 정보"/>
					</div>
				</div>
				<div class="col-md-4">
					<div id="major_subject_3" class="team text-center">
						<div class="cover" style="background:url('${img}/team/sql-cover.jpg'); background-size:cover;">
							<div class="overlay text-center">
								<h3 class="white">SQL</h3>
								<h5 class="light light-white">1 - 5 sessions / month</h5>
							</div>
						</div>
						<img src="${img}/team/sql.jpg" alt="SQL Image" class="avatar" style="width: 120px" height="120px">
						<div class="title">
							<h4>SQL</h4>
							<h5 class="muted regular">Database Management Language</h5>
						</div>
						<input type="hidden" name="major_subject_3"/>
						<input type="button" data-toggle="modal" data-target="#modal1" class="btn btn-blue-fill" value="과목 정보"/>
					</div>
				</div>
			</div>
		</div>
	</section>

<script src="${js}/owl.carousel.min.js"></script>
<script src="${js}/wow.min.js"></script>
<script src="${js}/typewriter.js"></script>
<script src="${js}/jquery.onepagenav.js"></script>
<script src="${js}/main.js"></script>