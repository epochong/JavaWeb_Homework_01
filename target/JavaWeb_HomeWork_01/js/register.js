function mySubmit () {
    var userName = document.forms["register"]["username"].value;
    var password = document.forms["register"]["password"];
    var email = document.forms["register"]["email"].value;
    // 判断是否为空
    if (userName == "" || password[0].value == "" || password[1].value == "" || email == "" ) {
        alert("信息不能为空！");
    }
    var atIndex = email.indexOf("@");
    var dotIndex = email.lastIndexOf(".");
    // 邮箱验证
    if (atIndex < 1 || atIndex + 2 > dotIndex || dotIndex + 2 >= email.length) {
        alert("邮箱格式不正确！");
        return false;
    }
    // 两次密码输入是否一致
    if (password[0].value != password[1].value) {
        alert("两次密码输入不一致！");
        password[1].value = "";
    }
    if (!(password[0].contains([0-9]) && password[0].contains([a-zA-Z]))) {
        alert("密码必须包含字母和数字")
    }
}