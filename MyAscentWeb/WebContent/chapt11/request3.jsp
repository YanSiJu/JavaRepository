<%@ page contentType="text/html;charset=GB2312" %>
<HTML>
<BODY bgcolor=cyan><FONT size=5>
  <FORM action="" method=post name=form>
     <INPUT type="text" name="price"> 
     <INPUT TYPE="submit" value="Enter" name="submit">
  </FORM> 
  <%
  String textContent=request.getParameter("price");
   double number=0,r=0;
   if(textContent==null)
    {textContent="";
    }
   try{ number=Double.parseDouble(textContent);
     if(number>=0)
       {r=Math.sqrt(number) ;
       out.print("<BR>"+String.valueOf(number)+"��ƽ������");
       out.print("<BR>"+String.valueOf(r));
       }
     else
       {out.print("<BR>"+"������һ������");
       }
    }
   catch(NumberFormatException e)
    {out.print("<BR>"+"�����������ַ�");
    }
  %>
</FONT>
</BODY>
</HTML>
