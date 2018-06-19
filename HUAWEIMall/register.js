
    function checkForm()
    {  
       if (CheckUserName()&&CheckPassword()){return true;}
       return false;
    }
    function CheckUserName()
    {
        var userName=document.registerForm.userName;
        if (userName.value.length==0)
        {
           window.alert("用户名不能为空！");
           userName.focus();
           return false;
        }
        for (var i=0;i<userName.value.length;i++)
        {
           var lowerCase=userName.value.toLowerCase().charAt(i); 
           if ((!(lowerCase>='0' && lowerCase<='9')) && (!(lowerCase>='a' && lowerCase <='z')))
           {     window.alert("用户名只能由字母和数字组成！");
           userName.select();
               return false;
           }
        }
        return true;
    }
    function CheckPassword()
    {
        var password=document.registerForm.password; 
        if (password.value.length==0)
        {
           window.alert("密码不能为空！");
           password.focus();
           return false;
        }
        if (password.value.length<6)
        {
           window.alert("密码长度不能小于6位！");
           password.select();
           return false;
        }
        return true;
    }