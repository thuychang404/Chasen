<%-- 
    Document   : add
    Created on : Nov 3, 2023, 10:39:39 AM
    Author     : vuong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>${title}</title>
        <link rel="stylesheet" href="./css/style.css"/>
    </head>
    <body>
        <h1>${title}</h1>
        <form action="/${action}" method="POST" class="form">
<!--            <div class="form-control">
                <label for="id" class="form-label">ID:</label>
                <input type="text" name="id" id="id" class="form-input" placeholder="Enter the ID..." required="true" value="${data.getId()}">
            </div>-->
            <div class="form-control">
                <label for="temperature" class="form-label">Temperature: </label>
                <input type="text" name="temperature" id="temperature" class="form-input" placeholder="Enter the temperature..." required="true" value="${data.getTemperature()}">
            </div>

            <div class="form-control">
                <label for="humid" class="form-label">Humid: </label>
                <input type="text" name="humid" id="humid" class="form-input" placeholder="Enter the humid..." required="true" value="${data.getHumid()}">
            </div>
            
            <div class="form-control">
                <label for="intensity" class="form-label">Intensity:</label>
                <input type="text" name="intensity" id="intensity" class="form-input" placeholder="Enter the intensity..." required="true" value="${data.getIntensity()}">
            </div>            
            
            <button type="submit" class="form-btn submit-btn">${title}</button>
        </form>
        
    </body>
</html>

