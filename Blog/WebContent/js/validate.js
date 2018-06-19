var validator = new Validator('example_form',[
  {
      name:"email",
      display:"邮箱不能为空",
      rules: 'required'
  },{
      name:"password",
      display:"密码不能为空",
      rules: 'required'
  },{
      name:"repassword",
      display:"密码不一致",
      rules: 'same(password)'
  }
],function(obj,evt){

  var errors_elm = document.getElementById('error_msg');
  errors_elm.style.display = 'none';
  //obj = {
  //  callback:(error, evt, handles)
  //  errors:Array[2]
  //  fields:Object
  //  form:form#example_form
  //  handles:Object
  //  isCallback:true
  //  isEmail:(field)
  //  isFax:(field)
  //  isIp:(field)
  //  isPhone:(field)
  //  isTel:(field)
  //  isUrl:(field)
  //  maxLength:(field, length)
  //  minLength:(field, length)
  //  required:(field)
  //} 
  console.log(evt);
  console.log(obj);
  if(obj.errors.length>0){
      // 判断是否错误
      var error_str = '';
      for (var i = 0; i < obj.errors.length; i++) {
          error_str += i+1 + ':' + obj.errors[i].message + '；<br/>';
		  console.log(obj.errors[i].message)
      }
      errors_elm.style.display = "block";
      errors_elm.innerHTML = error_str;

  }
  
})

function blurValidate(){
  validator.validate();
}
