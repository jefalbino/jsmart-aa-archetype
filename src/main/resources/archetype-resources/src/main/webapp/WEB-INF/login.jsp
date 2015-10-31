<%@ taglib prefix="sm" uri="http://jsmartframework.com/v2/jsp/taglib/jsmart" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>JSmart Framework - AA Archetype</title>
    </head>

    <body class="container">

        <!--
            Example of login submitted via ajax to WebBean
            mapped on server and alert to provide error response
        -->

        <div style="margin: auto; margin-top: 50px; width: 50%;">

            <!-- Alert to provide response from WebBean -->
            <sm:alert id="login-error">
                <!-- Icon, title and message will be added via WebContext on LoginBean -->
            </sm:alert>

            <sm:form>
                <sm:output type="p" value="@{texts.aa.archetype.login.message}" />

                <!-- Email to be sent to server side -->
                <sm:input label="@{texts.aa.archetype.email}" value="@{loginBean.email}"
                        placeholder="@{texts.aa.archetype.email.placeholder}">

                    <!-- Validate the input before sending to server -->
                    <sm:validate text="@{texts.aa.archetype.email.required}" regex="" />

                    <!-- Popover to explain login options -->
                    <sm:popover title="@{texts.aa.archetype.popover.title}" event="hover">
                        <sm:output value="@{texts.aa.archetype.popover.message}" />
                    </sm:popover>
                </sm:input>

                <!-- Password to be sent to server side -->
                <sm:input label="@{texts.aa.archetype.password}" value="@{loginBean.password}"
                        type="password" placeholder="@{texts.aa.archetype.password.placeholder}">

                    <!-- Validate the input before sending to server -->
                    <sm:validate text="@{texts.aa.archetype.password.required}" minLength="5" />
                </sm:input>

                <sm:button id="login-btn" ajax="true" label="@{texts.aa.archetype.login}"
                        action="@{loginBean.doLogin}" look="primary">

                    <!-- Glyphicon to be placed inside button -->
                    <sm:icon name="glyphicon-log-in" />

                    <!-- Animated load will replace the icon during the request -->
                    <sm:load />
                </sm:button>

            </sm:form>
        </div>

        <script>
            $(document).ready(function() {
                // In case you need to get CSRF token for you own Ajax request
                // please use the following:
                // JSmart.getCsrfName();
                // JSmart.getCsrfToken();

                // For setting the CSRF tokens on your own Ajax request header
                // please use the following:
                // JSmart.setCsrfToken(xhr);
            });
        </script>
    </body>
</html>