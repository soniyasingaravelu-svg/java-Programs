<%-- 
    Document   : Welcome
    Created on : 28 Sept 2025, 8:39:19 pm
    Author     : soniy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
    </head>
    <body>
        <%
            String username=request.getParameter("username");
            String email=request.getParameter("email");
            String password=request.getParameter("password");
            String mobile=request.getParameter("mobile");
            int age=Integer.parseInt(request.getParameter("age"));
            String course=request.getParameter("course");
            
            double courseFee=0;
            if("java".equals(course))
            {
                courseFee=30000;
            }
            else if("python".equals(course))
            {
                courseFee=25000;
            }
            else if("web".equals(course))
            {
                courseFee=20000;
            }
            double discount=0;
            if(age<=18&&age<=25)
            {
                
                discount=10;
            }
            else if(age<=60)
            {
                discount=20;
            }
            
            double finalFee=courseFee-(courseFee*discount/100);
            String passStrength=(password.length()<=6)?"weak":(password.length()>=10)?"medium":"Strong";
            boolean validMobile=mobile.length()==10;
            String domain=email.substring(email.indexOf("@")+1);
            %> 
            <p><b>Registration summary</b></p>
            <p><b>username:</b><%=username%></p>
            <p><b>email:</b><%=email%>(domain:<%=domain%>)</p>
            <p><b>mobile:</b><%=mobile%>(<%=validMobile?"valid":"Invalid"%>)</p>
            <p><b>age:</b><%=age%></p>
            <p><b>Password Strength:</b><%=passStrength%></p>
            <h3>Course Fee Details</h3>
            <p>Course Selected:<%=course%></p>
            <p>Original Fee:<%=courseFee%></p>
            <p>Discount Applied:<%=discount%></p>
            <p><b>Final Payable Fee:<%=finalFee%></b></p>
            <%
                if(age>=18)
                {
            %>
            <p style="color: green;">Eligible for registration</p>
            <%
                }
                else
               {
             %>
             <p style="color: red;">Not eligible(under 18)</p>
             <%
                     }
            %>
    </body>
</html>




    
