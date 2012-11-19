jQuery(document).ready(function(){
		jQuery("#signup").validate({
			  rules: {
		            name:	"required",
		            email:	{ required: true, email: true },
		            password: {required: true, minlength :10},
		            phone: {required: true, minlenght:6, maxlength:15}
		         },
		         messages: {
		            name:  "Enter name",
		            email: "Enter correct  E-mail",
		            password: "Enter correct password (minimum 10 symbols)",
		            phone: "Enter correct phone exam: 0671112233"
		         }
			  });
	});