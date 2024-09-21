<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
    function redirectToEncode() {
        // Get the input text value
        var userInput = document.getElementById("userInput").value;
        // Get the email value
        var email = document.getElementById("userEmail").value;
        // Redirect to the encode servlet with user input and email as parameters
        window.location.href = "encode?toEncode=" + encodeURIComponent(userInput) + "&email=" + encodeURIComponent(email);
    }

    function redirectToDecode() {
        // Get the input text value
        var userInput = document.getElementById("userInput").value;
        var email = document.getElementById("userEmail").value;
        // Redirect to the decode servlet with the user input as a parameter
        window.location.href = "decode?toDecode=" + encodeURIComponent(userInput) + "&email=" + encodeURIComponent(email);
    }
</script>
</head>
<body>

    <!-- Main Body -->
    <h1>This is the main body</h1>
    
    <!-- Multi-line text area for user to enter text -->
    <label for="userInput">Enter text to encode/decode:</label>
    <textarea id="userInput" name="userInput" rows="5" cols="40"></textarea>
    <br><br>
    
    <!-- Input field for user to enter email -->
    <label for="userEmail">Enter receiver's email:</label>
    <input type="email" id="userEmail" name="userEmail" />
    <br><br>

    <!-- Buttons to trigger redirect for encoding or decoding -->
    <button onclick="redirectToEncode()">Send</button>
    <button onclick="redirectToDecode()">Receive</button>

</body>
</html>
