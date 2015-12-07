<%--
  Created by IntelliJ IDEA.
  User: kevinholland
  Date: 12/6/15
  Time: 4:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <form action="/addPost" method="post">
        <div class="form-group" style="width: 80%;">
            <textarea id="post-text" class="post-area form-control empty" name="text" placeholder="whatya have to say?"></textarea>
        </div>
        <button id="submit" type="submit" class="btn-primary btn" disabled>post</button>
    </form>
</div>

<script>
    var textField = $("#post-text");
    var button = $("#submit");

    if (textField.val() != "") {
        button.prop("disabled", false);
    } else {
        button.prop("disabled", true);
    }

    textField.focus(function() {
       textField.addClass("expanded");
    });

    textField.on('input', function() {
        if (textField.val() != "") {
            button.prop("disabled", false);
            textField.removeClass("empty");
        } else {
            button.prop("disabled", true);
            textField.addClass("empty");
        }
    });
</script>
