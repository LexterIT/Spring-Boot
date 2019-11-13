    <!DOCTYPE html>
    <html xmlns:th="http://www.thymeleaf.org">
    <head lang="en">
        <title>Spring</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <link href="http://cdn.jsdelivr.net/webjars/bootstrap/3.3.4/css/bootstrap.min.css"
              th:href="@{/webjars/bootstrap/3.3.4/css/bootstrap.min.css}"
              rel="stylesheet" media="screen" />
        <script src="http://cdn.jsdelivr.net/webjars/jquery/2.1.4/jquery.min.js"
                th:src="@{/webjars/jquery/2.1.4/jquery.min.js}"></script>
        <link rel="stylesheet" type="text/css" href="/css/sample.css">
    </head>
    <body>
        <ul>
            <li><a href="role/roles">Roles</a></li>
            <li><a href="person/person">Person</a></li>
        </ul>
    </body>
    </html>