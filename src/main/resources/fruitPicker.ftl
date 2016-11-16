<html>
  <head><title>Fruit Picker</title></head>
  <body>
     <form action="/favorite" method="POST">
	    <p>Your name:</p>
	  	<input type="text" name="name">
        <p>What is your favorite fruit?</p>
        <#list fruits as fruit>
          <p>
             <input type="radio" name="fruit" value="${fruit}">${fruit}</input>
          </p>
        </#list>
        <input type="submit" value="Submit"/>
     </form>
  </body>
</html>