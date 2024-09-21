<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Encode/Decode</title>
    <script type="text/javascript">
        function sendPostRequest(actionUrl) {
            // Create a form element
            var form = document.createElement("form");
            form.method = "POST";
            form.action = actionUrl;

            // Get user input and email values
            var userInput = document.getElementById("userInput").value;
            var email = document.getElementById("userEmail").value;

            // Create hidden input fields for user input and email
            var userInputField = document.createElement("input");
            userInputField.type = "hidden";
            userInputField.name = "toProcess"; // Used for both encoding/decoding
            userInputField.value = userInput;

            var emailField = document.createElement("input");
            emailField.type = "hidden";
            emailField.name = "email";
            emailField.value = email;

            // Append hidden fields to the form
            form.appendChild(userInputField);
            form.appendChild(emailField);

            // Append form to body and submit it
            document.body.appendChild(form);
            form.submit();
        }
    </script>
</head>
<body>
    <h1>Encode/Decode Page</h1>

    <!-- Multi-line text area for user input -->
    <label for="userInput">Enter text to encode/decode:</label>
    <textarea id="userInput" name="userInput" rows="5" cols="40"></textarea>
    <br><br>

    <!-- Input field for user's email -->
    <label for="userEmail">Enter receiver's email:</label>
    <input type="email" id="userEmail" name="userEmail" />
    <br><br>

    <!-- Buttons to trigger POST requests for encoding/decoding -->
    <button type="button" onclick="sendPostRequest('encode')">Send (encode) </button>
    <button type="button" onclick="sendPostRequest('decode')">Receive (decode)</button>
</body>
</html>
