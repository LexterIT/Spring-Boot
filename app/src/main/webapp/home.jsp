    <!DOCTYPE html>
    <html xmlns:th="http://www.thymeleaf.org">
    <head lang="en">
        <title>Spring Framework Guru</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <link href="http://cdn.jsdelivr.net/webjars/bootstrap/3.3.4/css/bootstrap.min.css"
              th:href="@{/webjars/bootstrap/3.3.4/css/bootstrap.min.css}"
              rel="stylesheet" media="screen" />
        <script src="http://cdn.jsdelivr.net/webjars/jquery/2.1.4/jquery.min.js"
                th:src="@{/webjars/jquery/2.1.4/jquery.min.js}"></script>
        <link href="../static/css/sample.css"
              th:href="@{css/sample.css}" rel="stylesheet" media="screen"/>
        <style>
            ul {
              list-style-type: none;
              margin: 0;
              padding: 0;
              overflow: hidden;
              background-color: #333;
            }

            li {
              float: left;
            }

            li a {
              display: block;
              color: white;
              text-align: center;
              padding: 14px 16px;
              text-decoration: none;
            }

            li a:hover {
              background-color: #111;
            }
        </style>
    </head>
    <body>
        <ul>
            <li><a href="role/roles">Roles</a></li>
            <li><a href="person/person">Person</a></li>
        </ul>
    </body>
    </html>