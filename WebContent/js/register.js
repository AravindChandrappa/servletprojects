function validate(){
	alert("helllo js");
	let fname=document.getElementById("fname").value;
	let lname=document.getElementById("lname").value;
	let uname=document.getElementById("uname").value;
	let email=document.getElementById("email").value;
	let gender=document.getElementById("gender").value;
	let pass=document.getElementById("pass").value;
	let cpass=document.getElementById("cpass").value;
	
	Console.log("fname--->"+fname);
	Console.log("lname--->"+lname);
	Console.log("uname--->"+uname);
	Console.log("email--->"+email);
	Console.log("gender--->"+gender);
	Console.log("pass--->"+pass);
	Console.log("cpass--->"+cpass);
	
	if(fname='')
		{
		return false;
		document.getElementById("fname").focus();
		}
	if(lname='')
	{
	return false;
	document.getElementById("lname").focus();
	}
}