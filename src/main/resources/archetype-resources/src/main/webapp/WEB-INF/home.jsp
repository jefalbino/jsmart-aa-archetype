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

    <body>

        <!-- Menu example -->
        <nav class="navbar navbar-default">
            <div class="container-fluid">

                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                            data-target="#navbar-links" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <sm:link styleClass="navbar-brand" outcome="/home" label="My Logo">
                        <sm:icon name="glyphicon-leaf" />
                    </sm:link>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="navbar-links">
                    <ul class="nav navbar-nav">

                        <!-- Home link for current page -->
                        <li>
                            <sm:link outcome="/home" label="Home">
                                <sm:icon name="glyphicon-home" />
                            </sm:link>
                        </li>

                        <!-- Dropdown actions for menu -->
                        <sm:dropdown label="@{myAuthBean.name}" navbar="true">
                            <sm:icon name="glyphicon-user" />

                            <sm:dropmenu>
                                <sm:dropaction label="Logout" action="@{homeBean.doLogout}">
                                    <sm:icon name="glyphicon-log-out" />
                                </sm:dropaction>
                            </sm:dropmenu>
                        </sm:dropdown>

                    </ul>
                </div>

            </div>
        </nav>

        <div class="container col-md-12">

            <!-- Use Authorize tag to control content on page based on user access roles -->
            <sm:authorize>
                <sm:when access="admin">
                    Welcome administrator, this content only administrators can see!
                </sm:when>
                <sm:when access="user">
                    Welcome user, this content only users can see!
                </sm:when>
            </sm:authorize>

        </div>
    </body>

</html>