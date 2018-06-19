<HTML>
<%@ page contentType="text/html;charset=GB2312" %>
<BODY bgcolor=cyan>
<P>选择计算和的方式
  <FORM action="sum.jsp" method=post name=form>
    <Select name="sum" >
     <Option Selected value="1">计算1到n的连续和
     <Option value="2">计算1到n的平方和
     <Option value="3">计算1到n的立方和
    </Select> 
<P>选择n的值：<BR>
    <Select name="n" >
     <Option value="10">n=10
     <Option value="20">n=20
     <Option value="30">n=30
     <Option value="40">n=40
     <Option value="50">n=50
     <Option value="100">n=60
    </Select> 
    <BR><BR>
   <INPUT TYPE="submit" value="提交你的选择" name="submit">
  </FORM> 

</BODY>
</HTML>
