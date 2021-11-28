<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>LessaLand</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/rxjs/7.4.0/rxjs.umd.min.js" integrity="sha512-+44c+4RaNWpQRmhz2dwqH+t6caPi46MTcLaQr96rnvXOOW7SInBN4ivxSIZyqGlLSUOw5UQ+ndUmN417dJPXNA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <script src="js/index.js"></script>
    <link rel="stylesheet" href="css/styles.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700;900&display=swap" rel="stylesheet" />
</head>
<body>
    <main class="main">
        <header>
            <h2>Lessaland</h2>
            <div>
                <a href="javascript:void(0)">login</a>
                <a href="javascript:void(0)">cadastrar-se</a>
            </div>
        </header>
        <div class="main-wrapper">
            <div class="input-wrapper">
                <input id="search-input" type="text" />
                <div class="error-section"> </div>
            </div>
            <div class="client-wrapper" style="display: none;">
                <div class="indicator uf-indicator">
                    <h4>Unidade Federativa:</h4>
                    <h4 id="uf"></h4>
                </div>
                <div class="indicator">
                    <span>id</span>
                    <span>nome</span>
                </div>
            </div>
            <h2 id="no-results" style="display: none;">Nada foi encontrado</h2>
        </div>
    </main>
</body>
</html>